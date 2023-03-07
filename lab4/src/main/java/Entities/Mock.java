package Entities;

import java.util.ArrayList;
import java.util.List;

public class Mock {
    private List<CarEntity> carList = new ArrayList<>();

    public Mock () {
        this.carList.add(new CarEntity(1, "assets/Terrier-LT-79.jpg", "TERRIER LT-79", 1000));
        this.carList.add(new CarEntity(2, "assets/HUSKY-TSV.jpg", "HUSKY TSV", 1200));
        this.carList.add(new CarEntity(3, "assets/BATT-UMG.jfif", "BATT UMG", 900));
    }

    public List<CarEntity> getCarList() {
        return carList;
    }

    public void setCarList(List<CarEntity> carList) {
        this.carList = carList;
    }
}
