/**
 * Class as Blueprint: fields, constructors, methods.
 * Shows how a class defines the structure for all objects.
 */
public class ClassBlueprintBasic {

    // Blueprint: defines what every Car object will have
    static class Car {
        // Fields — each Car object has its own copy
        String brand;
        String model;
        int    year;
        double speed;        // current speed
        boolean isRunning;

        // Constructor — called when new Car() is used
        Car(String brand, String model, int year) {
            this.brand = brand;
            this.model = model;
            this.year  = year;
            this.speed = 0;
            this.isRunning = false;
        }

        // Methods — behaviors every Car can do
        void start() {
            if (!isRunning) { isRunning = true; System.out.println(brand + " started. Vroom!"); }
            else            { System.out.println(brand + " is already running."); }
        }

        void accelerate(double amount) {
            if (!isRunning) { System.out.println("Start the car first!"); return; }
            speed += amount;
            System.out.printf("%s accelerated → %.1f km/h%n", brand, speed);
        }

        void brake(double amount) {
            speed = Math.max(0, speed - amount);
            System.out.printf("%s braking → %.1f km/h%n", brand, speed);
        }

        void stop() {
            speed = 0; isRunning = false;
            System.out.println(brand + " stopped.");
        }

        void status() {
            System.out.printf("[%s %s %d] — %s | Speed: %.1f km/h%n",
                brand, model, year, isRunning ? "RUNNING" : "PARKED", speed);
        }
    }

    public static void main(String[] args) {
        // Create multiple instances from the same blueprint
        Car car1 = new Car("Toyota", "Camry",   2022);
        Car car2 = new Car("Tesla",  "Model 3", 2023);
        Car car3 = new Car("BMW",    "X5",      2021);

        System.out.println("=== Created from same Car blueprint ===");
        car1.status();
        car2.status();
        car3.status();

        System.out.println("\n=== Driving car1 ===");
        car1.start();
        car1.accelerate(30);
        car1.accelerate(20);
        car1.brake(10);
        car1.status();

        System.out.println("\n=== Other cars unaffected ===");
        car2.status();  // car2 still parked
        car3.status();  // car3 still parked
    }
}
