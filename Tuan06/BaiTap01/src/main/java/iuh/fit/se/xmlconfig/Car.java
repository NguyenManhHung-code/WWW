package iuh.fit.se.xmlconfig;

public class Car {
    private Engine engine;
    // Setter Injection
    public void setEngine(Engine engine) {
        this.engine = engine;
    }
    public void drive() {
        engine.start();
        System.out.println("Car is driving...");
    }
}
