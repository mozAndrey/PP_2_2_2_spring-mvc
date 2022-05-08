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
    public void fillTableOfCars(List<Car> list) {
        cars = list;
    }

    @Override
    public List<Car> getCountOfCars(Integer count) {
        List<Car> list = new ArrayList<>();
        if (count == 0 || count == null) {
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
