package se.javierdlc.crsolution.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.javierdlc.crsolution.domain.Brand;
import se.javierdlc.crsolution.domain.Car;
import se.javierdlc.crsolution.domain.CarCategory;
import se.javierdlc.crsolution.io.SearchCarForm;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class CRSRepository {

    @Autowired
    private DataSource dataSource;

    public List<Car> getAvailableCars(SearchCarForm form) {
        String query = "SELECT c.*, b.brand_name, cc.car_category_name " +
                "FROM cars AS c " +
                "INNER JOIN brands AS b ON b.brand_ID = c.brand_ID " +
                "INNER JOIN car_categories AS cc ON cc.car_category_ID = c.car_category_ID " +
                "WHERE c.car_category_ID = ? " +
                    "AND c.car_ID NOT IN (" +
                    "SELECT bo.car_ID " +
                    "FROM bookings AS bo " +
                    "WHERE bo.booking_returntime IS NULL OR bo.booking_returntime >= ?)";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
                ps.setInt(1, form.getCarType());
                ps.setTimestamp(2, Timestamp.valueOf(form.getFromDateTime()));
                ResultSet rs = ps.executeQuery();
                List<Car> cars = new ArrayList<>();
            while (rs.next()) {
                cars.add(rsCar(rs));
            }
            if (cars.size() > 0) {
                return cars;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }

    public Car rsCar(ResultSet rs) throws SQLException {
        Brand brand = rsBrand(rs);
        CarCategory carCategory = rsCarCategory(rs);
        return new Car(
                rs.getInt("car_ID"),
                brand,
                rs.getString("car_model"),
                rs.getInt("car_year"),
                rs.getInt("car_milage"),
                carCategory,
                rs.getString("car_plate")
        );
    }

    public Brand rsBrand(ResultSet rs) throws SQLException {
        return new Brand(rs.getInt("brand_ID"), rs.getString("brand_name"));
    }

    public CarCategory rsCarCategory(ResultSet rs) throws SQLException {
        return new CarCategory(rs.getInt("car_category_ID"), rs.getString("car_category_name"));
    }
}
