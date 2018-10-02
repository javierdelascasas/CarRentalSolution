package se.javierdlc.crsolution.io;

import java.time.LocalDateTime;

public class SearchCarForm {
    private int carType;
    private int location;
    private LocalDateTime fromDateTime;

    public int getCarType() {
        return carType;
    }

    public int getLocation() {
        return location;
    }

    public LocalDateTime getFromDateTime() {
        return fromDateTime;
    }
}
