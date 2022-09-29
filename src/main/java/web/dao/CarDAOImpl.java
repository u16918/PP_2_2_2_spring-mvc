package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CarDAOImpl implements CarDAO{

    List<Car> list = new ArrayList<>();
    {
        list.add(new Car("Mercedes", "Green", 1981));
        list.add(new Car("Toyota", "Black", 2000));
        list.add(new Car("Volkswagen", "Red", 2005));
        list.add(new Car("Nissan", "Blue", 2010));
        list.add(new Car("Infinite", "Brown", 2020));
    }
    @Override
    public List<Car> getCars(int count) {
        if (count == 0) {
            return list;
        }
        return list.stream().limit(count).collect(Collectors.toList());
    }
}
