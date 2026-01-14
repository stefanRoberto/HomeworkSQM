import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CarEngineTest {
    private Car car;

    @Before
    public void setUp() {
        car = new Car("Toyota", "Camry", 2023);
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
        assertTrue("Engine should remain running when speed > 0", car.isEngineRunning());
    }
}
