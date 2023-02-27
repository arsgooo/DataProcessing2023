package Crud;

import Entities.EntityCar;
import FileIO.FileIO;
import FileIO.FileIOInterface;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

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

    public JsonElement bodyParse(HttpServletRequest request){
        JsonElement jsonElement = null;

        try {
            jsonElement = JsonParser.parseReader(request.getReader());
        } catch (JsonIOException | JsonSyntaxException | IOException e) {
            e.printStackTrace();
        }

        return jsonElement;
    }

    @Override
    public EntityCar carParse(HttpServletRequest request) {
        EntityCar car = new EntityCar();
        JsonElement jsonElement = bodyParse(request);
        car.setId(jsonElement.getAsJsonObject().get("id").getAsInt());
        car.setImg(jsonElement.getAsJsonObject().get("img").getAsString());
        car.setName(jsonElement.getAsJsonObject().get("name").getAsString());
        car.setPrice(jsonElement.getAsJsonObject().get("price").getAsInt());
        return car;
    }

    public int getIndexByCarId(int id, List<EntityCar> list) {
        int listId = id;

        Iterator<EntityCar> iterator = list.iterator();
        while(iterator.hasNext()) {
            EntityCar temp = iterator.next();
            if(temp.getId() == listId) {
                listId=list.indexOf(temp);
                break;
            }
        }
        return listId;
    }

    public int getNextId(List<EntityCar> list) {
        int maxId = 0;

        Iterator<EntityCar> iterator = list.iterator();
        while(iterator.hasNext()) {
            int currentId = iterator.next().getId();
            if(currentId>maxId) maxId=currentId;
        }
        return maxId+1;
    }
}
