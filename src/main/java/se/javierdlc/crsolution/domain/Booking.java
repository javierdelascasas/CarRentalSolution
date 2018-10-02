package se.javierdlc.crsolution.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_ID")
    private Integer bookingID;

    @ManyToOne
    @JoinColumn(name = "user_ID")
    @JsonBackReference
    private User user;

    @ManyToOne
    @JoinColumn(name = "car_ID")
    @JsonBackReference
    private Car car;

    @Column(name = "booking_datetime")
    private LocalDateTime bookingDatetime;

    @Column(name = "booking_returntime")
    private LocalDateTime bookingReturntime;

    @Column(name = "booking_start_milage")
    private int bookingStartMilage;

    @Column(name = "booking_end_milage")
    private int bookingEndMilage;

    @Column(name = "booking_price")
    private int bookingPrice;

    @Column(name = "booking_taxrate")
    private float bookingTaxrate;

    @Column(name = "booking_status")
    private int bookingStatus;

    public Booking() {
    }

    public Booking(User user, Car car, LocalDateTime bookingDatetime, LocalDateTime bookingReturntime, int bookingStartMilage, int bookingEndMilage, int bookingPrice, float bookingTaxrate, int bookingStatus) {
        this.user = user;
        this.car = car;
        this.bookingDatetime = bookingDatetime;
        this.bookingReturntime = bookingReturntime;
        this.bookingStartMilage = bookingStartMilage;
        this.bookingEndMilage = bookingEndMilage;
        this.bookingPrice = bookingPrice;
        this.bookingTaxrate = bookingTaxrate;
        this.bookingStatus = bookingStatus;
    }

    public Integer getBookingID() {
        return bookingID;
    }

    public User getUser() {
        return user;
    }

    public Car getCar() {
        return car;
    }

    public LocalDateTime getBookingDatetime() {
        return bookingDatetime;
    }

    public LocalDateTime getBookingReturntime() {
        return bookingReturntime;
    }

    public int getBookingStartMilage() {
        return bookingStartMilage;
    }

    public int getBookingEndMilage() {
        return bookingEndMilage;
    }

    public int getBookingPrice() {
        return bookingPrice;
    }

    public float getBookingTaxrate() {
        return bookingTaxrate;
    }

    public int getBookingStatus() {
        return bookingStatus;
    }
}
