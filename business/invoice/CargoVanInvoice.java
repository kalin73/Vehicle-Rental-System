package business.invoice;

import business.insurance.CargoVanInsuranceCalc;
import business.rental.CargoVanRental;
import utils.CurrencyFormatter;

import java.time.LocalDate;

public class CargoVanInvoice extends Invoice {
    public CargoVanInvoice(CargoVanRental cargoVanRental, CargoVanInsuranceCalc cargoVanInsuranceCalc, LocalDate returnDate) {
        super(cargoVanRental, cargoVanInsuranceCalc, returnDate);
    }

    @Override
    public String getInvoice() {
        String title = String.format("A cargo van valued at %s, and the driver has %d years of driving experience%n",
                CurrencyFormatter.getFormatedValue((getVehicleRental().getVehicle().getValue())),
                getVehicleRental().getClient().getDrivingExperience());

        StringBuilder invoice = new StringBuilder(title);
        invoice.append(System.lineSeparator());
        invoice.append(super.getInvoice());

        if (getVehicleRental().getClient().getDrivingExperience() > 5) {
            invoice.append(String.format("Initial insurance per day: %s%n", CurrencyFormatter.getFormatedValue(getInsuranceCalculator().calculateInitialCostPerDay())));
            invoice.append(String.format("Insurance discount per day: %s%n", CurrencyFormatter.getFormatedValue(getInsuranceCalculator().calculateDiscountPerDay())));
            invoice.append(String.format("Insurance per day: %s%n", CurrencyFormatter.getFormatedValue(getInsuranceCalculator().calculateTotalCostPerDay())));

        } else {
            invoice.append(String.format("Insurance per day: %s%n", CurrencyFormatter.getFormatedValue(getInsuranceCalculator().calculateTotalCostPerDay())));

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
