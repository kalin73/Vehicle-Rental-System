package business.invoice;

import business.insurance.InsuranceDiscountCalculator;
import business.rental.CarRental;
import model.vehicle.Car;
import utils.CurrencyFormatter;

import java.time.LocalDate;

public class CarInvoice extends Invoice {
    private final Car car;
    private final InsuranceDiscountCalculator insuranceDiscountCalculator;

    public CarInvoice(CarRental carRental, InsuranceDiscountCalculator carInsuranceCalc, LocalDate returnDate) {
        super(carRental, carInsuranceCalc, returnDate);

        if (carRental.getVehicle() instanceof Car) this.car = (Car) carRental.getVehicle();
        else throw new IllegalArgumentException();

        this.insuranceDiscountCalculator = carInsuranceCalc;
    }

    @Override
    public String getInvoice() {
        String title = String.format("A car valued at %s, and has a security rating of %d%n", CurrencyFormatter.getFormatedValue((car.getValue())), car.getSafetyRating());

        StringBuilder invoice = new StringBuilder(title);
        invoice.append(System.lineSeparator());
        invoice.append(super.getInvoice());

        if (car.getSafetyRating() > 3 && car.getSafetyRating() <= 5) {
            invoice.append(String.format("Initial insurance per day: %s%n", CurrencyFormatter.getFormatedValue(insuranceDiscountCalculator.calculateInitialCostPerDay())));
            invoice.append(String.format("Insurance discount per day: %s%n", CurrencyFormatter.getFormatedValue(insuranceDiscountCalculator.calculateDiscountPerDay())));
            invoice.append(String.format("Insurance per day: %s%n", CurrencyFormatter.getFormatedValue(insuranceDiscountCalculator.calculateTotalCostPerDay())));

        } else {
            invoice.append(String.format("Insurance per day: %s%n", CurrencyFormatter.getFormatedValue(insuranceDiscountCalculator.calculateTotalCostPerDay())));

        }
        invoice.append(System.lineSeparator());

        if (getVehicleRental().getRentalDays() - getRentDuration() > 0) {
            invoice.append(earlyReturnDiscounts());
        }

        invoice.append(getTotal());
        invoice.append("XXXXXXXXXX\n");

        return invoice.toString();
    }
}
