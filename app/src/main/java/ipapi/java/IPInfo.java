package ipapi.java;

public class IPInfo {
    private String ip;
    private ISPInfo isp;
    private LocationInfo location;
    private RiskInfo risk;

    // Getters and Setters
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public ISPInfo getIsp() {
        return isp;
    }

    public void setIsp(ISPInfo isp) {
        this.isp = isp;
    }

    public LocationInfo getLocation() {
        return location;
    }

    public void setLocation(LocationInfo location) {
        this.location = location;
    }

    public RiskInfo getRisk() {
        return risk;
    }

    public void setRisk(RiskInfo risk) {
        this.risk = risk;
    }
}
