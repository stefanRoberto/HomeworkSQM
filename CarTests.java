import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CarTests {
    private Car car;

    @Before
    public void setUp() {
        car = new Car("Toyota", "Camry", 2023);
    }

    @Test
    public void testCarConstructor() {
        assertEquals("Toyota", car.getMake());
        assertEquals("Camry", car.getModel());
        assertEquals(2023, car.getYear());
        assertEquals(0.0, car.getSpeed());
        assertFalse(car.isEngineRunning());
    }

    @Test
    public void testStartEngine() {
        car.startEngine();
        assertTrue(car.isEngineRunning());
    }

    @Test
    public void testStopEngine() {
        car.startEngine();
        car.stopEngine();
        assertFalse(car.isEngineRunning());
    }

    @Test
    public void testStopEngineWhileMoving() {
        car.startEngine();
        car.accelerate(50);
        car.stopEngine();
        assertTrue(car.isEngineRunning(), "Engine should remain running when speed > 0");
    }

    @Test
    public void testAccelerate() {
        car.startEngine();
        car.accelerate(30);
        assertEquals(30.0, car.getSpeed());
    }

    @Test
    public void testAccelerateWithoutEngine() {
        car.accelerate(30);
        assertEquals(0.0, car.getSpeed(), "Speed should remain 0 when engine is off");
    }

    @Test
    public void testAccelerateMultipleTimes() {
        car.startEngine();
        car.accelerate(20);
        car.accelerate(15);
        assertEquals(35.0, car.getSpeed());
    }

    @Test
    public void testAccelerateWithNegativeValue() {
        car.startEngine();
        car.accelerate(-10);
        assertEquals(0.0, car.getSpeed(), "Negative acceleration should not change speed");
    }

    @Test
    public void testBrake() {
        car.startEngine();
        car.accelerate(50);
        car.brake(20);
        assertEquals(30.0, car.getSpeed());
    }

    @Test
    public void testBrakeToZero() {
        car.startEngine();
        car.accelerate(30);
        car.brake(40);
        assertEquals(0.0, car.getSpeed(), "Speed should not go below 0");
    }

    @Test
    public void testBrakeWithNegativeValue() {
        car.startEngine();
        car.accelerate(50);
        car.brake(-10);
        assertEquals(50.0, car.getSpeed(), "Negative brake should not change speed");
    }

    @Test
    public void testGetters() {
        assertEquals("Toyota", car.getMake());
        assertEquals("Camry", car.getModel());
        assertEquals(2023, car.getYear());
    }
}
