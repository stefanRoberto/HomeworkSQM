import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CarAccelerationTest {
    private Car car;

    @Before
    public void setUp() {
        car = new Car("Toyota", "Camry", 2023);
    }

    @Test
    public void testAccelerate() {
        car.startEngine();
        car.accelerate(30);
        assertEquals(30.0, car.getSpeed(), 0.01);
    }

    @Test
    public void testAccelerateWithoutEngine() {
        car.accelerate(30);
        assertEquals("Speed should remain 0 when engine is off", 0.0, car.getSpeed(), 0.01);
    }

    @Test
    public void testAccelerateMultipleTimes() {
        car.startEngine();
        car.accelerate(20);
        car.accelerate(15);
        assertEquals(35.0, car.getSpeed(), 0.01);
    }

    @Test
    public void testAccelerateWithNegativeValue() {
        car.startEngine();
        car.accelerate(-10);
        assertEquals("Negative acceleration should not change speed", 0.0, car.getSpeed(), 0.01);
    }
}
