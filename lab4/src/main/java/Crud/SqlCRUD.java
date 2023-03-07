package Crud;

import Entities.CarEntity;
import jdbc.Connect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SqlCRUD implements CRUDInterface<CarEntity> {

    Connection connection;

    public SqlCRUD() {
        this.connection = new Connect().getCon();
        System.out.println(connection);
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(CarEntity car) {
        try(PreparedStatement st = connection.prepareStatement("INSERT INTO lab4schema.cars (img, name, price) "
                + "VALUES (?, ?, ?);")) {
            st.setString(1, car.getImg());
            st.setString(2, car.getName());
            st.setInt(3, car.getPrice());
            st.executeUpdate(); //database update
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<CarEntity> read() {
        List<CarEntity> list = new ArrayList<>();

        try(
                Statement st = connection.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM lab4schema.cars;");
                )
        {
            while(rs.next()) {
                list.add(new CarEntity(rs.getInt(1), rs.getString(2),
                        rs.getString(3),rs.getInt(4)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public void update(int id, CarEntity car) {
        try(PreparedStatement st = connection.prepareStatement("UPDATE lab4schema.cars "
                + "SET \"img\"=?, \"name\"=?, \"price\"=? WHERE id=?;")) {
            st.setString(1, car.getImg());
            st.setString(2, car.getName());
            st.setInt(3, car.getPrice());
            st.setInt(4, id);
            st.executeUpdate(); //database update
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try(PreparedStatement st = connection.prepareStatement("DELETE FROM lab4schema.cars WHERE id=?;")) {
            st.setInt(1, id);
            st.executeUpdate(); //database update
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
