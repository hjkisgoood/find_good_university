package sjk.com.demo.entity;
import jakarta.persistence.*;

@Entity
public class Universities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "university_id")
    private Long universityID;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "campus_area")
    private Double campusArea;

    @Column(name = "min_fee")
    private Double minFee;

    @Column(name = "max_fee")
    private Double maxFee;

    @Column(name = "province")
    private String province;

    @Column(name = "city")
    private String city;

    @Column(name = "address")
    private String address;

    @Column(name = "climate")
    private String climate;

    @Column(name = "application_deadline")
    private String applicationDeadline;

    // 构造函数
    public Universities() {
    }

    // 构造函数
    public Universities( String name, String type, Double campusArea, Double minFee, Double maxFee, String province, String city, String address, String climate, String applicationDeadline) {
        this.name = name;
        this.type = type;
        this.campusArea = campusArea;
        this.minFee = minFee;
        this.maxFee = maxFee;
        this.province = province;
        this.city = city;
        this.address = address;
        this.climate = climate;
        this.applicationDeadline = applicationDeadline;
    }

    // Getter 和 Setter 方法
    public Long getUniversityID() {
        return universityID;
    }

    public void setUniversityID(Long universityID) {
        this.universityID = universityID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getCampusArea() {
        return campusArea;
    }

    public void setCampusArea(Double campusArea) {
        this.campusArea = campusArea;
    }

    public Double getMinFee() {
        return minFee;
    }

    public void setMinFee(Double minFee) {
        this.minFee = minFee;
    }

    public Double getMaxFee() {
        return maxFee;
    }

    public void setMaxFee(Double maxFee) {
        this.maxFee = maxFee;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getClimate() {
        return climate;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

    public String getApplicationDeadline() {
        return applicationDeadline;
    }

    public void setApplicationDeadline(String applicationDeadline) {
        this.applicationDeadline = applicationDeadline;
    }


}
