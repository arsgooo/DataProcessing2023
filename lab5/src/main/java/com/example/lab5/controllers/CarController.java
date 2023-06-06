package com.example.lab5.controllers;

import com.example.lab5.entities.CarEntity;
import com.example.lab5.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CarController {

    @Autowired
    private CarRepository cRepo;

    @GetMapping("/listOfCars")
    public ModelAndView showCars() {
        ModelAndView mav = new ModelAndView("index");
        List<CarEntity> list = cRepo.findAll();
        mav.addObject("cars", list);
        return mav;
    }

    @GetMapping("/addCarForm")
    public ModelAndView addCarForm() {
        ModelAndView mav = new ModelAndView("add-car-form");
        CarEntity newCar = new CarEntity();
        mav.addObject("car", newCar);
        return mav;
    }

    @PostMapping("/saveCar")
    public String saveCar(@ModelAttribute CarEntity car) {
        cRepo.save(car);
        return "redirect:/listOfCars";
    }

    @GetMapping("/updateCarForm")
    public ModelAndView showUpdateForm(@RequestParam Integer carId) {
        ModelAndView mav = new ModelAndView("add-car-form");
        CarEntity existingCar = cRepo.findById(carId).get();
        mav.addObject("car", existingCar);
        return mav;
    }

    @GetMapping("/deleteCar")
    public String deleteCar(@RequestParam Integer carId) {
        cRepo.deleteById(carId);
        return "redirect:/listOfCars";
    }
}
