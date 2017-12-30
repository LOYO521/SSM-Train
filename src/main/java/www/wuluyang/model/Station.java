package www.wuluyang.model;

public class Station {
    private Integer stationid;

    private String trainnum;

   

	private String station;

    private String outtime;

    private Integer daytime;

    private Double siteprice;
    public String getTrainnum() {
		return trainnum;
	}

	public void setTrainnum(String trainnum) {
		this.trainnum = trainnum;
	}

    public Integer getStationid() {
        return stationid;
    }

    public void setStationid(Integer stationid) {
        this.stationid = stationid;
    }

   

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station == null ? null : station.trim();
    }

    public String getOuttime() {
        return outtime;
    }

    public void setOuttime(String outtime) {
        this.outtime = outtime == null ? null : outtime.trim();
    }

    public Integer getDaytime() {
        return daytime;
    }

    public void setDaytime(Integer daytime) {
        this.daytime = daytime;
    }

    public Double getSiteprice() {
        return siteprice;
    }

    public void setSiteprice(Double siteprice) {
        this.siteprice = siteprice;
    }
}