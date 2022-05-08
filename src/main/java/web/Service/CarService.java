package web.Service;

import org.springframework.stereotype.Service;
import web.Models.Car;

import java.util.List;

@Service
public interface CarService {

    List<Car> getCars();

    Integer getAmountOfCars();

    void fillTableOfCars(List<Car> list);

    List<Car> getCountOfCars(Integer count);

}
