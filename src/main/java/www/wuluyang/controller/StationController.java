package www.wuluyang.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import www.wuluyang.service.IStationService;
import www.wuluyang.service.StationServiceImpl;

@Controller
public class StationController {
	private static Logger LOGGER=Logger.getLogger(StationServiceImpl.class);
	//跳转至车票价格界面
	private static final String SHOWPRICE="showPrice";
	//跳转至查询结果界面
	private static final String GETPRICE="getPrice";
	//未找到结果界面
	private static final String EMPTY="empty";
	@Autowired
	private IStationService iStationService;
	
	@RequestMapping("/showPrice")
	public String showPrice(){
		
		
		return SHOWPRICE;
	}
	
    @RequestMapping("/getPrice")
	public String getPrice(String trainnum,String startStation,String endStation,HttpServletRequest request){
    	//校验前端传入参数是否为空开始
		if(StringUtils.isEmpty(trainnum)){
			LOGGER.error("trainnum is null");
			request.setAttribute("error", "车次不能为空");
			return SHOWPRICE;
		}
		if(StringUtils.isEmpty(startStation)){
			LOGGER.error("startstation is null");
			request.setAttribute("error", "出发站不能为空");
			return SHOWPRICE;
		}
		if(StringUtils.isEmpty(endStation)){
			LOGGER.error("endstation is null");
			request.setAttribute("error", "终点不能为空");
			return SHOWPRICE;
		}
		//校验前端传入参数是否为空结束
	  Double	startAndEndPrice=iStationService.startAndEndPrice(trainnum, startStation, endStation);
	  //如果没查到
	  if(startAndEndPrice  == null|| startAndEndPrice == 0){
		  LOGGER.error("startAndEndPrice is null或 startAndEndPrice");
		  return EMPTY;
	  }
	  
	  //车票价格参数
	  request.setAttribute("startAndEndPrice", startAndEndPrice);
	  request.setAttribute("trainnum", trainnum);
	  request.setAttribute("startStation", startStation);
	  request.setAttribute("endStation", endStation);
		return GETPRICE;
		
	}
}
