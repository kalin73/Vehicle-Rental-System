package business.invoice;

import business.insurance.CarInsuranceCalc;
import business.rental.CarRental;
import model.vehicle.Car;
import utils.Utils;

import java.time.LocalDate;

public class CarInvoice extends Invoice {
    private final Car car;

    public CarInvoice(CarRental carRental, CarInsuranceCalc carInsuranceCalc, LocalDate returnDate) {
        super(carRental, carInsuranceCalc, returnDate);
        this.car = (Car) carRental.getVehicle();
    }

    @Override
    public String getInvoice() {
        String title = String.format("A car valued at %s, and has a security rating of %d%n", Utils.getFormatedValue((car.getValue())), car.getSafetyRating());

        StringBuilder invoice = new StringBuilder(title);
        invoice.append(System.lineSeparator());
        invoice.append(super.getInvoice());
        invoice.append(System.lineSeparator());
        invoice.append(String.format("Rental cost per day: %s%n", Utils.getFormatedValue(getVehicleRental().getRentalCostPerDay())));

        if (car.getSafetyRating() > 3 && car.getSafetyRating() <= 5) {
            invoice.append(String.format("Initial insurance per day: %s%n", Utils.getFormatedValue(getInsuranceCalculator().calculateInitialCostPerDay())));
            invoice.append(String.format("Insurance discount per day: %s%n", Utils.getFormatedValue(getInsuranceCalculator().calculateDiscountPerDay())));
            invoice.append(String.format("Insurance per day: %s%n", Utils.getFormatedValue(getInsuranceCalculator().calculateTotalCostPerDay())));

        } else {
            invoice.append(String.format("Insurance per day: %s%n", Utils.getFormatedValue(getInsuranceCalculator().calculateTotalCostPerDay())));

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
