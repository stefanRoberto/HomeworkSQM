import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CarConstructorTest {
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
        assertEquals(0.0, car.getSpeed(), 0.01);
        assertFalse(car.isEngineRunning());
    }

    @Test
    public void testGetters() {
        assertEquals("Toyota", car.getMake());
        assertEquals("Camry", car.getModel());
        assertEquals(2023, car.getYear());
    }
}
