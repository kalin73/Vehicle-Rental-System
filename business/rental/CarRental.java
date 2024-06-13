package business.rental;

import model.client.Client;
import model.vehicle.Vehicle;

import java.math.BigDecimal;

public class CarRental extends VehicleRental {

    public CarRental(Client client, Vehicle car, int rentalDays) {
        super(client, car, rentalDays);
    }

    @Override
    public void setRentalCostPerDay() {
        if (this.getRentalDays() < 8 && this.getRentalDays() > 0) {
            this.rentalCostPerDay = BigDecimal.valueOf(20);

        } else {
            this.rentalCostPerDay = BigDecimal.valueOf(15);
        }
    }

}
