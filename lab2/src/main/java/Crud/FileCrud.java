package Crud;

import Entities.EntityCar;
import FileIO.FileIO;
import FileIO.FileIOInterface;

public class FileCrud implements CrudInterface {

    FileIOInterface fio;

    public FileCrud() {
        this.fio = new FileIO();
    }

    @Override
    public EntityCar readEntity() {
        return (EntityCar) fio.loadFromFile();
    }

    @Override
    public void updateEntity(EntityCar car) {
        fio.saveToFile(car);
    }
}
