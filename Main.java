import business.insurance.CarInsuranceCalc;
import business.insurance.CargoVanInsuranceCalc;
import business.insurance.MotorcycleInsuranceCalc;
import business.invoice.CarInvoice;
import business.invoice.CargoVanInvoice;
import business.invoice.Invoice;
import business.invoice.MotorcycleInvoice;
import business.rental.CarRental;
import business.rental.CargoVanRental;
import business.rental.MotorcycleRental;
import model.client.Client;
import model.vehicle.Car;
import model.vehicle.CargoVan;
import model.vehicle.Motorcycle;
import model.vehicle.Vehicle;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println(getCarInvoice());
        System.out.println(getMotorcycleInvoice());
        System.out.println(getCargoVanInvoice());
    }

    public static String getCarInvoice() {
        Client client = new Client("John", "Doe", 26, 7);
        Vehicle car = new Car("Mitsubishi", "Mirage", BigDecimal.valueOf(15000), 3);
        CarRental carRental = new CarRental(client, car, 10);
        CarInsuranceCalc carInsuranceCalculator = new CarInsuranceCalc(carRental);

        Invoice carInvoice = new CarInvoice(carRental, carInsuranceCalculator, LocalDate.now().plusDays(10));

        return carInvoice.getInvoice();
    }

    public static String getMotorcycleInvoice() {
        Client client = new Client("Mary", "Johnson", 20, 2);
        Vehicle motorcycle = new Motorcycle("Triumph Tiger", "Sport 660", BigDecimal.valueOf(10000));
        MotorcycleRental motorcycleRental = new MotorcycleRental(client, motorcycle, 10);
        MotorcycleInsuranceCalc motorcycleInsuranceCalc = new MotorcycleInsuranceCalc(motorcycleRental);

        Invoice motorcycleInvoice = new MotorcycleInvoice(motorcycleRental, motorcycleInsuranceCalc, LocalDate.now().plusDays(10));

        return motorcycleInvoice.getInvoice();
    }

    public static String getCargoVanInvoice() {
        Client client = new Client("John", "Markson", 27, 8);
        Vehicle cargoVan = new CargoVan("Citroen", "Jumper", BigDecimal.valueOf(20000));
        CargoVanRental cargoVanRental = new CargoVanRental(client, cargoVan, 15);
        CargoVanInsuranceCalc cargoVanInsuranceCalc = new CargoVanInsuranceCalc(cargoVanRental);

        Invoice cargoVanInvoice = new CargoVanInvoice(cargoVanRental, cargoVanInsuranceCalc, LocalDate.now().plusDays(10));

        return cargoVanInvoice.getInvoice();
    }
}
