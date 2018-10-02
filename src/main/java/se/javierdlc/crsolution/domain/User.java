package se.javierdlc.crsolution.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_ID")
    private Integer user_ID;

    @Column(name = "user_birthdate")
    private LocalDate user_birthdate;

    @Column(name = "user_fname")
    private String user_fname;

    @Column(name = "user_lname")
    private String user_lname;

    @Column(name = "user_phone")
    private String user_phone;

    @Column(name = "user_email")
    private String user_email;

    @OneToMany(mappedBy = "user",
        fetch = FetchType.EAGER,
        cascade = CascadeType.ALL)
    private List<Booking> bookings = new ArrayList<>();

    public User() {
    }

    public User(LocalDate user_birthdate, String user_fname, String user_lname, String user_phone, String user_email) {
        this.user_birthdate = user_birthdate;
        this.user_fname = user_fname;
        this.user_lname = user_lname;
        this.user_phone = user_phone;
        this.user_email = user_email;
    }
}
