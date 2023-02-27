package Entities;

import java.io.Serializable;

public class EntityCar implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String img;
    private String name;
    private int price;

    public EntityCar(int id, String img, String name, int price) {
        this.id = id;
        this.img = img;
        this.name = name;
        this.price = price;
    }

    public EntityCar() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "{\"id\": \""+id+"\", \"img\": \""+img+"\", \"name\": \""+name+"\", \"price\": "+price+"}";
    }
}

