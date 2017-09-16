public class CommunityFilterDTO {





    private String name;
    private String city;
    private String district;
    private String street;
    private Double average;
    private String houseAge;
    private String houseType;




    public CommunityFilterDTO(String name, String city, String district, String street, Double average, String houseAge, String houseType) {
        this.name = name;
        this.city = city;
        this.district = district;
        this.street = street;
        this.average = average;
        this.houseAge = houseAge;
        this.houseType = houseType;
    }

    @Override
    public String toString() {
        return "CommunityFilterDTO{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", street='" + street + '\'' +
                ", average=" + average +
                ", houseAge='" + houseAge + '\'' +
                ", houseType='" + houseType + '\'' +
                '}';
    }

    public CommunityFilterDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Double getAverage() {
        return average;
    }

    public void setAverage(Double average) {
        this.average = average;
    }

    public String getHouseAge() {
        return houseAge;
    }

    public void setHouseAge(String houseAge) {
        this.houseAge = houseAge;
    }

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }
}
