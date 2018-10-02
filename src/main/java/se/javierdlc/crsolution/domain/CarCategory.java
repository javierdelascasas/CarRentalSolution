package se.javierdlc.crsolution.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "car_categories")
public class CarCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_category_ID")
    private Integer carCategoryID;

    @Column(name = "car_category_name")
    private String carCategoryName;

    @OneToMany(mappedBy = "carCategory",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Car> cars = new ArrayList<>();

    public CarCategory() {
    }

    public CarCategory(int carCategoryID, String carCategoryName) {
        this.carCategoryID = carCategoryID;
        this.carCategoryName = carCategoryName;
    }

    public Integer getCarCategoryID() {
        return carCategoryID;
    }

    public String getCarCategoryName() {
        return carCategoryName;
    }

    public List<Car> getCars() {
        return cars;
    }
}
