public class CityDistance {
    private long id;
    private String firstCity;
    private String secondCity;
    private int distance;

    public CityDistance(long id, String firstCity, String secondCity, int distance) {
        this.id = id;
        this.firstCity = firstCity;
        this.secondCity = secondCity;
        this.distance = distance;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstCity() {
        return firstCity;
    }

    public void setFirstCity(String firstCity) {
        this.firstCity = firstCity;
    }

    public String getSecondCity() {
        return secondCity;
    }

    public void setSecondCity(String secondCity) {
        this.secondCity = secondCity;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "CityDistance{" +
                "id=" + id +
                ", firstCity='" + firstCity + '\'' +
                ", secondCity='" + secondCity + '\'' +
                ", distance=" + distance +
                '}';
    }
}
