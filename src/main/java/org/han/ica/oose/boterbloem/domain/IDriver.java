package org.han.ica.oose.boterbloem.domain;

import org.han.ica.oose.boterbloem.domain.domainImplementation.DriverCar;

import java.util.List;

public interface IDriver {
    List<DriverCar> getDriverCars();

    void setDriverCars(List<DriverCar> driverCars);

    float getTotalEarned();

    void setTotalEarned(float totalEarned);

    int getTotalRides();

    void setTotalRides(int totalRides);

    byte getVerification();

    void setVerification(byte verification);

    String getType_of_payment();

    void setType_of_payment(String type_of_payment);

    String getImage();

    void setImage(String image);

    String getAccountnr();

    void setAccountnr(String accountnr);
}
