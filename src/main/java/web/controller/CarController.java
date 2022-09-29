package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarService;

import java.util.Optional;

@Controller
public class CarController {
    private final CarService service;

    public CarController(CarService service) {
        this.service = service;
    }
    @GetMapping("/cars")
    public String showCars(@RequestParam(value = "count") Optional<Integer> count, Model model) {
        model.addAttribute("cars", service.getCars(count.orElse(5)));
        return "cars";
    }
}
