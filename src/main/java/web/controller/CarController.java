package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.Models.Car;
import web.Service.CarService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/cars")
public class CarController {
    @Autowired
    CarService carService;

    @RequestMapping(value = "/cars.html")
    public String createCarList(Model model) {
        Car car1 = new Car("Black", "Bl", 1);
        Car car2 = new Car("White", "Wh", 2);
        Car car3 = new Car("Yellow", "Ye", 3);
        Car car4 = new Car("Pink", "Pi", 4);
        Car car5 = new Car("Grey", "Gr", 5);
        List<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
        cars.add(car5);
        carService.fillTableOfCars(cars);
        model.addAttribute("createTable", carService.getCars());
        return "carsAdded";
    }

    @GetMapping(value = "/cars")
    public String showCarList(@RequestParam(value = "count", required = false) Integer count, Model model) {
        if (count == null) {
            model.addAttribute("showTable", carService.getCars());
        } else {
            model.addAttribute("showTable", carService.getCountOfCars(count));
        }
        return "cars";
    }


    @GetMapping(value = "/amountOfCars.html")
    public String carCount(ModelMap modelMap) {
        modelMap.addAttribute("amountOfCars", carService.getAmountOfCars());
        return "amountOfCars";
    }
}
