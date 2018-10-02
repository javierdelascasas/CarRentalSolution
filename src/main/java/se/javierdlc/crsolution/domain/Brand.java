package se.javierdlc.crsolution.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "brands")
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "brand_ID")
    private Integer brandID;

    @Column(name = "brand_name")
    private String brandName;

    @OneToMany(mappedBy = "brand",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Car> cars = new ArrayList<>();

    public Brand() {
    }

    public Brand(int brandID, String brandName) {
        this.brandID = brandID;
        this.brandName = brandName;
    }

    public Integer getBrandID() {
        return brandID;
    }

    public String getBrandName() {
        return brandName;
    }

    public List<Car> getCars() {
        return cars;
    }
}
