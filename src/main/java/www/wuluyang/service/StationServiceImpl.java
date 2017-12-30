package www.wuluyang.service;



import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import www.wuluyang.dao.StationMapper;
import www.wuluyang.model.Station;
@Service("stationService")
public class StationServiceImpl implements IStationService {
	private static Logger LOGGER=Logger.getLogger(StationServiceImpl.class);
	@Autowired
	private StationMapper stationMapper;
	public Double startAndEndPrice(String trainnum, String startStation, String endStation) {
		LOGGER.info("startAndEndPrice参数：trainnum"+trainnum+",startStation"+startStation+",endStation"+endStation);
		// TODO Auto-generated method stub
		//查找出发站的车站信息
		Station startStationResult=findByStation(trainnum, startStation);
		Double resultPrice=null;
		if(startStationResult==null){
			//判断值是否为空，以防止空指针错误，养成打印日志习惯
			LOGGER.error("startStationResult is null");
			return resultPrice;
		}
		//查找目的地的车站信息
		Station endStationResult=findByStation(trainnum, endStation);
		if(endStationResult==null){
			LOGGER.error("endStationResult is null");
			return resultPrice;
		}
		resultPrice=(double) (endStationResult.getSiteprice()- startStationResult.getSiteprice());
		LOGGER.info("startAndEndPrice参数 resultPrice"+resultPrice);
		return  resultPrice;
		/*
		 * 对整个方法的入参，过程，返回值进行打印日志，方便查找错误
		 * 即进入该方法之前之后，之后都打印日志，级别为
		 * 
		 */
	}
	/*
	 * 通过车次+车站信息得到相应的价格
	 * @Param trainnum 车次
	 * @Param Station 车站信息
	 * @Param return
	 */
	private Station findByStation(String trainnum,String station){
		Station sta=new Station();
		sta.setTrainnum(trainnum);
		sta.setStation(station);
		return stationMapper.findByStation(sta);
		
	}
// 
}
