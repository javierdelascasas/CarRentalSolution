package se.javierdlc.crsolution.domain;

import javax.persistence.*;

@Entity
@Table(name = "locations")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "location_ID")
    private Integer location_ID;

    @Column(name = "location_name")
    private String location_name;

    @Column(name = "location_address")
    private String location_address;

    @Column(name = "location_zipcode")
    private String location_zipcode;

    @Column(name = "location_city")
    private String location_city;

    @ManyToOne
    @JoinColumn(name = "country_ID")
    private Country country;

    public Location() {
    }

    public Location(String location_name, String location_address, String location_zipcode, String location_city) {
        this.location_name = location_name;
        this.location_address = location_address;
        this.location_zipcode = location_zipcode;
        this.location_city = location_city;
    }

    public Integer getLocation_ID() {
        return location_ID;
    }

    @Override
    public String toString() {
        return location_name + ", " +
                location_city + " - " +
                country.getCountry_name();
    }
}