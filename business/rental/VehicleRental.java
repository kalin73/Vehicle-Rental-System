package business.rental;

import model.client.Client;
import model.vehicle.Vehicle;

import java.math.BigDecimal;
import java.time.LocalDate;

public abstract class VehicleRental {
    private Client client;
    private Vehicle vehicle;
    private LocalDate reservationStartDate;
    private int rentalDays;
    private LocalDate reservationEndDate;
    protected BigDecimal rentalCostPerDay;

    public VehicleRental(Client client, Vehicle vehicle, int rentalDays) {
        this.vehicle = vehicle;
        this.rentalDays = rentalDays;
        this.client = client;
        reservationStartDate = LocalDate.now();
        reservationEndDate = reservationStartDate.plusDays(rentalDays);
        setRentalCostPerDay();
    }

    public abstract void setRentalCostPerDay();

    public Client getClient() {
        return client;
    }

    public VehicleRental setClient(Client client) {
        this.client = client;
        return this;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public VehicleRental setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        return this;
    }

    public LocalDate getReservationStartDate() {
        return reservationStartDate;
    }

    public VehicleRental setReservationStartDate(LocalDate reservationStartDate) {
        this.reservationStartDate = reservationStartDate;
        return this;
    }

    public int getRentalDays() {
        return rentalDays;
    }

    public VehicleRental setRentalDays(int rentalDays) {
        this.rentalDays = rentalDays;
        return this;
    }

    public LocalDate getReservationEndDate() {
        return reservationEndDate;
    }

    public VehicleRental setReservationEndDate(LocalDate reservationEndDate) {
        this.reservationEndDate = reservationEndDate;
        return this;
    }

    public BigDecimal getRentalCostPerDay() {
        return rentalCostPerDay;
    }


}
