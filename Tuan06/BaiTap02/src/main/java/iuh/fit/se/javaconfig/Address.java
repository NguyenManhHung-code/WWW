package iuh.fit.se.javaconfig;

public class Address {
    private String city, state, country;

    public Address(String city, String state, String country) {
        this.city = city;
        this.state = state;
        this.country = country;
    }

    @Override
    public String toString() {
        return city + ", " + state + ", " + country;
    }
}
