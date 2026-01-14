public class Car {
    private String make;
    private String model;
    private int year;
    private double speed;
    private boolean engineRunning;

    public Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.speed = 0.0;
        this.engineRunning = false;
    }

    public void startEngine() {
        this.engineRunning = true;
    }

    public void stopEngine() {
        if (speed == 0) {
            this.engineRunning = false;
        }
    }

    public void accelerate(double amount) {
        if (engineRunning && amount > 0) {
            this.speed += amount;
        }
    }

    public void brake(double amount) {
        if (amount > 0) {
            this.speed = Math.max(0, this.speed - amount);
        }
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public double getSpeed() {
        return speed;
    }

    public boolean isEngineRunning() {
        return engineRunning;
    }
}
