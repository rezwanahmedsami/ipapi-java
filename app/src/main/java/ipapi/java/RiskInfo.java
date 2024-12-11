package ipapi.java;

public class RiskInfo {
    private Boolean is_mobile;
    private Boolean is_vpn;
    private Boolean is_tor;
    private Boolean is_proxy;
    private Boolean is_datacenter;
    private Integer risk_score;

    // Getters and Setters
    public Boolean getis_mobile() {
        return is_mobile;
    }

    public void setis_mobile(Boolean is_mobile) {
        this.is_mobile = is_mobile;
    }

    public Boolean getis_vpn() {
        return is_vpn;
    }

    public void setis_vpn(Boolean is_vpn) {
        this.is_vpn = is_vpn;
    }

    public Boolean getis_tor() {
        return is_tor;
    }

    public void setis_tor(Boolean is_tor) {
        this.is_tor = is_tor;
    }

    public Boolean getis_proxy() {
        return is_proxy;
    }

    public void setis_proxy(Boolean is_proxy) {
        this.is_proxy = is_proxy;
    }

    public Boolean getis_datacenter() {
        return is_datacenter;
    }

    public void setis_datacenter(Boolean is_datacenter) {
        this.is_datacenter = is_datacenter;
    }

    public Integer getrisk_score() {
        return risk_score;
    }

    public void setrisk_score(Integer risk_score) {
        this.risk_score = risk_score;
    }
}
