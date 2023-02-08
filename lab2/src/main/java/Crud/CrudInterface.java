package Crud;

import Entities.EntityCar;

public interface CrudInterface {
    EntityCar readEntity();
    void updateEntity(EntityCar car);
}
