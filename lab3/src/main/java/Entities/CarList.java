package Entities;

import java.util.ArrayList;
import java.util.List;

public class CarList {
    private List<EntityCar> carList = new ArrayList<>();

    public CarList () { //contains necessary data
        this.carList.add(new EntityCar(1, "assets/Terrier-LT-79.jpg", "TERRIER LT-79", 1000));
        this.carList.add(new EntityCar(2, "assets/HUSKY-TSV.jpg", "HUSKY TSV", 1200));
        this.carList.add(new EntityCar(3, "assets/BATT-UMG.jfif", "BATT UMG", 900));
    }

    public List<EntityCar> getCarList() {
        return carList;
    }

    public void setCarList(List<EntityCar> carList) {
        this.carList = carList;
    }
}
