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

    private CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @RequestMapping(value = "/cars.html")
    public String createCarList(Model model) {
        carService.fillTableOfCars();
        model.addAttribute("createTable", carService.getCars());
        return "redirect:/";
    }

    @GetMapping(value = "/cars")
    public String showCarList(@RequestParam(value = "count", required = false) Integer count, Model model) {
        model.addAttribute("showTable", carService.getCountOfCars(count));
        return "cars";
    }


    @GetMapping(value = "/amountOfCars.html")
    public String carCount(ModelMap modelMap) {
        modelMap.addAttribute("amountOfCars", carService.getAmountOfCars());
        return "amountOfCars";
    }
}
