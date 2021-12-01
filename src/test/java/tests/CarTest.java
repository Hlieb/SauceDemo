package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CarTest {

    @Test
    public void carComparisonTest(){

        Car car1 = new Car("Tesla");
        Car car2 = new Car("Tesla");
        Assert.assertEquals(car1,car2);
    }
}
