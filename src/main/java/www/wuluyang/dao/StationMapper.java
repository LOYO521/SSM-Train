package www.wuluyang.dao;

import www.wuluyang.model.Station;

public interface StationMapper {
    int deleteByPrimaryKey(Integer stationid);

    int insert(Station record);

    int insertSelective(Station record);

    Station selectByPrimaryKey(Integer stationid);

    int updateByPrimaryKeySelective(Station record);

    int updateByPrimaryKey(Station record);

    Station findByStation(Station record);
}