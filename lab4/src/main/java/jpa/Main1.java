package jpa;

import Crud.SqlCRUD;
import Entities.CarEntity;

import java.util.List;

public class Main1 {
    public static void main(String[] args) {

    //JPA connection
        List<CarEntity> cars;
        SqlCRUD scrud = new SqlCRUD();

        scrud.create(new CarEntity(1, "assets/Terrier-LT-79.jpg", "TERRIER LT-79", 1000));
        scrud.create(new CarEntity(2, "assets/HUSKY-TSV.jpg", "HUSKY TSV", 1200));
        scrud.create(new CarEntity(3, "assets/BATT-UMG.jfif", "BATT UMG", 900));

      //  scrud.update(1, new CarEntity(1, "assets/HUSKY-TSV.jpg", "HUSKY TSV", 1200));
      //  scrud.delete(2);

        cars = scrud.read();

        System.out.println("---JPA---");
        for(CarEntity car : cars) {
            System.out.println(car);
        }
        System.out.println("SUCCESS!");






    // -------------------------------------------------------------------------------------------
    /*  List<CarEntity> cars;

        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        try (SessionFactory sessionFactory = new MetadataSources(registry)
                .addAnnotatedClass(CarEntity.class)
                .buildMetadata()
                .buildSessionFactory()) {

            Session session = sessionFactory.openSession();
            session.beginTransaction();

            session.save(new CarEntity(1, "assets/Terrier-LT-79.jpg", "TERRIER LT-79", 1000));
            session.save(new CarEntity(2, "assets/HUSKY-TSV.jpg", "HUSKY TSV", 1200));
            session.save(new CarEntity(3, "assets/BATT-UMG.jfif", "BATT UMG", 900));


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
        System.out.println();
        System.out.println("SUCCESS!"); */


    }
}
