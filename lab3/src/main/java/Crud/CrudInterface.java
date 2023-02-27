package Crud;

import Entities.EntityCar;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

public interface CrudInterface {
    EntityCar readEntity();
    void updateEntity(EntityCar car);

    EntityCar carParse(HttpServletRequest request);
    int getIndexByCarId(int id, List<EntityCar> list);
    int getNextId(List<EntityCar> list);
}
