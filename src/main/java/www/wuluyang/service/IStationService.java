package www.wuluyang.service;

public interface IStationService {
	//计算出发站到目的地的价格
	/*
	 * @Param trainnum 车次
	 * @Param startStation 始发站
	 * @Param endStation 目的地
	 * 
	 */
	public Double startAndEndPrice(String trainnum,String startStation,String endStation);
}
