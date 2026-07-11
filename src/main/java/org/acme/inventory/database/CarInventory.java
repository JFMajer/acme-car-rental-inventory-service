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
    Car mazda = new Car(ids.incrementAndGet(), "ABC123", "Mazda", "6");
    cars.add(mazda);
    Car ford = new Car(ids.incrementAndGet(), "XYZ987", "Ford", "Mustang");
    cars.add(ford);
    Car toyota = new Car(ids.incrementAndGet(), "LMN456", "Toyota", "Corolla");
    cars.add(toyota);
    Car honda = new Car(ids.incrementAndGet(), "DEF789", "Honda", "Civic");
    cars.add(honda);
    }
}
