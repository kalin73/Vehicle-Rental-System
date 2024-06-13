package business.rental;

import model.client.Client;
import model.vehicle.Vehicle;

import java.math.BigDecimal;

public class CargoVanRental extends VehicleRental {
    public CargoVanRental(Client client, Vehicle vehicle, int rentalDays) {
        super(client, vehicle, rentalDays);
    }

    @Override
    public void setRentalCostPerDay() {
        if (this.getRentalDays() < 8 && this.getRentalDays() > 0) {
            this.rentalCostPerDay = BigDecimal.valueOf(50);

        } else {
            this.rentalCostPerDay = BigDecimal.valueOf(40);
        }
    }
}
