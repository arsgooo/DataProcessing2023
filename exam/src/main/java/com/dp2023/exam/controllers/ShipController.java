package com.dp2023.exam.controllers;
import com.dp2023.exam.entities.ShipEntity;
import com.dp2023.exam.repositories.ShipRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;

@RestController
@RequestMapping("/api/ships")
@Slf4j
public class ShipController {
    @Autowired
    private ShipRepository shRep;

    @GetMapping("/list")
    public List<ShipEntity> getAllShips() {
        List<ShipEntity> shipsList = shRep.findAll();
        log.info("[SHIP CONTROLLER] GET method performed: found {} ships", shipsList.size());
        return shipsList;
    }

    @GetMapping("/list/{id}")
    public ShipEntity getShipById(@PathVariable Long id) {
        return shRep.findById(id)
                .orElseThrow(() -> new ResourceAccessException("No ship found with id: " + id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ShipEntity postShip(@RequestBody ShipEntity ship) {
        shRep.save(ship);
        log.info("[SHIP CONTROLLER] POST method performed: added {} ship", ship.getName());
        return ship;
    }

    @PutMapping("/update/{id}")
    public ShipEntity putShip(@PathVariable Long id, @RequestBody ShipEntity updatedShip) {
        ShipEntity newShip = shRep.findById(id)
                        .orElseThrow(() -> new ResourceAccessException("No ship found with id: " + id));
        newShip.setId(updatedShip.getId());
        newShip.setName(updatedShip.getName());
        newShip.setImg(updatedShip.getImg());
        newShip.setYear(updatedShip.getYear());
        newShip.setCountry(updatedShip.getCountry());
        log.info("[SHIP CONTROLLER] PUT method performed: ship with id {} was updated", newShip.getName());
        return shRep.save(newShip);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteShip(@PathVariable Long id) {
        if (!shRep.existsById(id)) {
            throw new ResourceAccessException("No ship found with id: " + id);
        }
        shRep.deleteById(id);
        log.info("[SHIP CONTROLLER] DELETE method performed: ship with id {} was deleted", id);
    }
}
