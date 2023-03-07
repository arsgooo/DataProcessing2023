package jdbc;

import Crud.CRUDInterface;
import Crud.SqlCRUD;
import Entities.CarEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args)  {
        CRUDInterface crud = new SqlCRUD();
        Connection connection = new Connect().getCon();

        List<CarEntity> cars;
        List<CarEntity> list = new ArrayList<>();

    //JDBC connection
        try (Statement st = connection.createStatement(); ResultSet rs = st.executeQuery("SELECT * FROM lab4schema.cars;");) {
            while (rs.next()) {
                list.add(new CarEntity(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("JDBC");
        for (CarEntity car : list) {
            System.out.println(car);
        }


    //JPA connection
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        try (SessionFactory sessionFactory = new MetadataSources(registry)
                .addAnnotatedClass(CarEntity.class)
                .buildMetadata()
                .buildSessionFactory()) {

            Session session = sessionFactory.openSession();
            session.beginTransaction();

            session.save(new CarEntity(3, "img3", "name3", 30000));
            session.save(new CarEntity(2, "img2", "name2", 20000));

           // CarEntity updateCar1 = new CarEntity(3, "img1", "updated_name_1", 10000);
           // session.update(updateCar1);
           // session.delete(new CarEntity(2, "img2", "name2", 20000));

            cars = (List<CarEntity>) session.createQuery("from CarEntity").list();

            session.getTransaction().commit();

        }

        System.out.println("JPA");
        for(CarEntity car : cars) {
            System.out.println(car);
        }
        System.out.println("SUCCESS!");
    }
}

