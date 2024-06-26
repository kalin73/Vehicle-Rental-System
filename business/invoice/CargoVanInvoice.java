package business.invoice;

import business.insurance.InsuranceDiscountCalculator;
import business.rental.CargoVanRental;
import utils.CurrencyFormatter;

import java.time.LocalDate;

public class CargoVanInvoice extends Invoice {
    private final InsuranceDiscountCalculator insuranceDiscountCalculator;

    public CargoVanInvoice(CargoVanRental cargoVanRental, InsuranceDiscountCalculator cargoVanInsuranceCalc, LocalDate returnDate) {
        super(cargoVanRental, cargoVanInsuranceCalc, returnDate);
        this.insuranceDiscountCalculator = cargoVanInsuranceCalc;
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
