package org.acme.inventory.database;

import org.acme.inventory.model.Car;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

@ApplicationScoped
public class CarInventory {

    private List<Car> cars;

    public static final AtomicLong ids = new AtomicLong(0);
    @PostConstruct
    void initialize() {
        cars = new CopyOnWriteArrayList<>();
        initialData();
    }

    public List<Car> getCars() {
        return cars;
    }

    private void initialData() {
    Car mazda = new Car();
    mazda.id = ids.incrementAndGet();
    mazda.licensePlateNumber = "ABC123";
    mazda.manufacturer = "Mazda";
    mazda.model = "6";
    cars.add(mazda);
    Car ford = new Car();
    ford.id = ids.incrementAndGet();
    ford.licensePlateNumber = "XYZ987";
    ford.manufacturer = "Ford";
    ford.model = "Mustang";
    cars.add(ford);
    Car toyota = new Car();
    toyota.id = ids.incrementAndGet();
    toyota.licensePlateNumber = "LMN456";
    toyota.manufacturer = "Toyota";
    toyota.model = "Corolla";
    cars.add(toyota);
    Car honda = new Car();
    honda.id = ids.incrementAndGet();
    honda.licensePlateNumber = "DEF789";
    honda.manufacturer = "Honda";
    honda.model = "Civic";
    cars.add(honda);
    }
}
