package se.javierdlc.crsolution.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "countries")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_ID")
    private Integer country_ID;

    @Column(name = "country_name")
    private String country_name;

    @Column(name = "country_phonecode")
    private String country_phonecode;

    @ManyToOne
    @JoinColumn(name = "currency_ID")
    private Currency currency;

    @OneToMany(mappedBy = "country",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private List<Location> locations = new ArrayList<>();

    public Country() {
    }

    public Country(String country_name, String country_phonecode) {
        this.country_name = country_name;
        this.country_phonecode = country_phonecode;
    }

    public Integer getCountry_ID() {
        return country_ID;
    }

    public String getCountry_name() {
        return country_name;
    }
}
