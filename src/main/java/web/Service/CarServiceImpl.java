package web.Service;

import org.springframework.stereotype.Service;
import web.Models.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    public List<Car> cars = new ArrayList<>();

    @Override
    public List<Car> getCars() {
        return cars;
    }

    @Override
    public Integer getAmountOfCars() {
        return cars.size();
    }

    @Override
    public void fillTableOfCars() {
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
        this.cars = cars;
    }

    @Override
    public List<Car> getCountOfCars(Integer count) {
        List<Car> list = new ArrayList<>();
        if (count == 0) {
            return list;
        } else if (count > 5) {
            return cars;
        } else {
            for (int i = 0; i < count; i++) {
                list.add(cars.get(i));
            }
            return list;
        }
    }
}
