package business.invoice;

import business.insurance.InsuranceCalculator;
import business.rental.VehicleRental;
import utils.Utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

public abstract class Invoice {
    private VehicleRental vehicleRental;
    private InsuranceCalculator insuranceCalculator;
    private LocalDate returnDate;
    private long rentDuration;

    protected Invoice(VehicleRental vehicleRental, InsuranceCalculator insuranceCalculator, LocalDate returnDate) {
        this.vehicleRental = vehicleRental;
        this.insuranceCalculator = insuranceCalculator;
        this.returnDate = returnDate;
        this.rentDuration = DAYS.between(vehicleRental.getReservationStartDate(), returnDate);
    }

    public String getInvoice() {
        StringBuilder invoice = new StringBuilder();

        invoice.append("XXXXXXXXXX\n");
        invoice.append("Date: " + LocalDate.from(getVehicleRental().getReservationStartDate()));
        invoice.append(System.lineSeparator());
        invoice.append("Customer Name: " + getVehicleRental().getClient().getFirstName() + " " + getVehicleRental().getClient().getLastName());
        invoice.append(System.lineSeparator());
        invoice.append(String.format("Rented Vehicle: %s %s%n", vehicleRental.getVehicle().getBrand(), vehicleRental.getVehicle().getModel()));
        invoice.append(System.lineSeparator());
        invoice.append(String.format("Reservation start date: %s%n", LocalDate.from(getVehicleRental().getReservationStartDate())));
        invoice.append(String.format("Reservation end date: %s%n", LocalDate.from(getVehicleRental().getReservationEndDate())));
        invoice.append(String.format("Reserved rental days: %d days%n", getVehicleRental().getRentalDays()));
        invoice.append(System.lineSeparator());
        invoice.append(getReturnDateDetails());

        return invoice.toString();
    }

    public String getReturnDateDetails() {
        String returnDateDetails = String.format("Actual Return date: %s%n", this.returnDate);
        returnDateDetails += String.format("Actual rental days: %d days%n", this.rentDuration);

        return returnDateDetails;
    }

    public String getTotal() {
        BigDecimal rent = vehicleRental.getRentalCostPerDay().multiply(BigDecimal.valueOf(vehicleRental.getRentalDays())).subtract(getEarlyReturnRentDiscount());
        BigDecimal insurance = insuranceCalculator.calculateTotalCostPerDay().multiply(BigDecimal.valueOf(rentDuration));

        String totalRent = String.format("Total rent: %s%n", Utils.getFormatedValue(rent));
        String totalInsurance = String.format("Total insurance: %s%n", Utils.getFormatedValue(insurance));
        String total = String.format("Total: %s%n", Utils.getFormatedValue(rent.add(insurance)));

        return totalRent + totalInsurance + total;
    }

    public BigDecimal getEarlyReturnRentDiscount() {
        long daysLeft = vehicleRental.getRentalDays() - rentDuration;

        if (daysLeft == 0) return new BigDecimal(0);

        BigDecimal discount = vehicleRental.getRentalCostPerDay().divide(BigDecimal.TWO, RoundingMode.HALF_UP);
        discount = discount.multiply(BigDecimal.valueOf(daysLeft));

        return discount;
    }

    public BigDecimal calculateRentDiscount() {
        BigDecimal total = vehicleRental.getRentalCostPerDay().multiply(BigDecimal.valueOf(rentDuration));
        total = total.add(getEarlyReturnRentDiscount());

        return total;
    }

    public String earlyReturnDiscounts() {
        StringBuilder invoice = new StringBuilder();

        invoice.append(String.format("Early return discount for rent: %s%n", Utils.getFormatedValue(getEarlyReturnRentDiscount())));
        invoice.append(String.format("Early return discount for insurance: %s%n",
                Utils.getFormatedValue(getInsuranceCalculator().calculateTotalCostPerDay().multiply(BigDecimal.valueOf(vehicleRental.getRentalDays() - rentDuration)))));
        invoice.append(System.lineSeparator());

        return invoice.toString();
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public Invoice setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
        return this;
    }

    public VehicleRental getVehicleRental() {
        return vehicleRental;
    }

    public Invoice setVehicleRental(VehicleRental vehicleRental) {
        this.vehicleRental = vehicleRental;
        return this;
    }

    public InsuranceCalculator getInsuranceCalculator() {
        return insuranceCalculator;
    }

    public Invoice setInsuranceCalculator(InsuranceCalculator insuranceCalculator) {
        this.insuranceCalculator = insuranceCalculator;
        return this;
    }

    public long getRentDuration() {
        return rentDuration;
    }
}
