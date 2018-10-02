package se.javierdlc.crsolution.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "currencies")
public class Currency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "currency_ID")
    private Integer currency_ID;

    @Column(name = "currency_name")
    private String currency_name;

    @Column(name = "currency_abbr")
    private String currency_abbr;

    @Column(name = "currency_symbol")
    private String currency_symbol;

    @OneToMany(mappedBy = "currency",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private List<Country> countries = new ArrayList<>();

    public Currency() {
    }

    public Currency(String currency_name, String currency_abbr, String currency_symbol) {
        this.currency_name = currency_name;
        this.currency_abbr = currency_abbr;
        this.currency_symbol = currency_symbol;
    }
}