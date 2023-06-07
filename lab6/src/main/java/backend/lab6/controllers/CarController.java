package backend.lab6.controllers;

import backend.lab6.entities.CarEntity;
import backend.lab6.exceptions.ResourceNotFoundException;
import backend.lab6.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lab6/api")
@CrossOrigin(origins = "*")
public class CarController {

    @Autowired
    private CarRepository cRepo;

    @GetMapping("/list")
    public List<CarEntity> getCars() {
        return cRepo.findAll();
    }

    @PostMapping("/add")
    public CarEntity postCar(@RequestBody CarEntity car) {
        return cRepo.save(car);
    }

    @PutMapping("/update/{id}")
    public CarEntity putCar(@PathVariable long id, @RequestBody CarEntity updatedCar) {
        CarEntity newCar = cRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No car found with id:" + id));

        newCar.setName(updatedCar.getName());
        newCar.setImg(updatedCar.getImg());
        newCar.setPrice(updatedCar.getPrice());

        return cRepo.save(newCar);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCar(@PathVariable long id) {
        CarEntity car = cRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No car found with id:" + id));

        cRepo.delete(car);
    }
}