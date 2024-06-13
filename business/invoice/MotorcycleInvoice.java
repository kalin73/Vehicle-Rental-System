package business.invoice;

import business.insurance.InsuranceCalculator;
import business.rental.MotorcycleRental;
import utils.Utils;

import java.time.LocalDate;

public class MotorcycleInvoice extends Invoice {
    public MotorcycleInvoice(MotorcycleRental motorcycleRental, InsuranceCalculator insuranceCalculator, LocalDate returnDate) {
        super(motorcycleRental, insuranceCalculator, returnDate);
    }

    @Override
    public String getInvoice() {
        String title = String.format("A motorcycle valued at %s, and the driver is %d years old%n",
                Utils.getFormatedValue((getVehicleRental().getVehicle().getValue())),
                getVehicleRental().getClient().getAge());

        StringBuilder invoice = new StringBuilder(title);
        invoice.append(System.lineSeparator());
        invoice.append(super.getInvoice());
        invoice.append(System.lineSeparator());
        invoice.append(String.format("Rental cost per day: %s%n", Utils.getFormatedValue(getVehicleRental().getRentalCostPerDay())));

        if (getVehicleRental().getClient().getAge() < 25) {
            invoice.append(String.format("Initial insurance per day: %s%n", Utils.getFormatedValue(getInsuranceCalculator().calculateInitialCostPerDay())));
            invoice.append(String.format("Insurance addition per day: %s%n", Utils.getFormatedValue(getInsuranceCalculator().calculateAdditionPerDay())));
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
