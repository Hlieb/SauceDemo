package tests;

import java.util.Objects;

public class Car {

    public Car(String make) {
        this.make = make;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(make, car.make);
    }

    @Override
    public int hashCode() {
        return Objects.hash(make);
    }

    String make;

}
