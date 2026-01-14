import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CarBrakingTest {
    private Car car;

    @Before
    public void setUp() {
        car = new Car("Toyota", "Camry", 2023);
    }

    @Test
    public void testBrake() {
        car.startEngine();
        car.accelerate(50);
        car.brake(20);
        assertEquals(30.0, car.getSpeed(), 0.01);
    }

    @Test
    public void testBrakeToZero() {
        car.startEngine();
        car.accelerate(30);
        car.brake(40);
        assertEquals("Speed should not go below 0", 0.0, car.getSpeed(), 0.01);
    }

    @Test
    public void testBrakeWithNegativeValue() {
        car.startEngine();
        car.accelerate(50);
        car.brake(-10);
        assertEquals("Negative brake should not change speed", 50.0, car.getSpeed(), 0.01);
    }
}
