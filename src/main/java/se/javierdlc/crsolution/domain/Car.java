package se.javierdlc.crsolution.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_ID")
    private Integer carID;

    @ManyToOne
    @JoinColumn(name = "brand_ID")
    @JsonBackReference
    private Brand brand;

    @Column(name = "car_model")
    private String carModel;

    @Column(name = "car_year")
    private int carYear;

    @Column(name = "car_milage")
    private int carMilage;

    @ManyToOne
    @JoinColumn(name = "car_category_ID")
    @JsonBackReference
    private CarCategory carCategory;

    @Column(name = "car_plate")
    private String carPlate;

    @OneToMany(mappedBy = "car",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Booking> bookings = new ArrayList<>();

    public Car() {
    }

    public Car(int carID, Brand brand, String carModel, int carYear, int carMilage, CarCategory carCategory, String carPlate) {
        this.carID = carID;
        this.brand = brand;
        this.carModel = carModel;
        this.carYear = carYear;
        this.carMilage = carMilage;
        this.carCategory = carCategory;
        this.carPlate = carPlate;
    }

    public Integer getCarID() {
        return carID;
    }

    public Brand getBrand() {
        return brand;
    }

    public String getCarModel() {
        return carModel;
    }

    public int getCarYear() {
        return carYear;
    }

    public int getCarMilage() {
        return carMilage;
    }

    public CarCategory getCarCategory() {
        return carCategory;
    }

    public String getCarPlate() {
        return carPlate;
    }

    public List<Booking> getBookings() {
        return bookings;
    }
}
