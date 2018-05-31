package org.han.ica.oose.boterbloem.domain.domainobjects;

public class Ratings {

    String DriverName; // Rating is based on a driver.
    int stars;
    String comment;
    String ClientName; // client gives a rating

    /**
     * Getter for property 'driverName'.
     *
     * @return Value for property 'driverName'.
     */
    public String getDriverName() {
        return DriverName;
    }

    /**
     * Setter for property 'driverName'.
     *
     * @param driverName Value to set for property 'driverName'.
     */
    public void setDriverName(String driverName) {
        DriverName = driverName;
    }

    /**
     * Getter for property 'stars'.
     *
     * @return Value for property 'stars'.
     */
    public int getStars() {
        return stars;
    }

    /**
     * Setter for property 'stars'.
     *
     * @param stars Value to set for property 'stars'.
     */
    public void setStars(int stars) {
        this.stars = stars;
    }

    /**
     * Getter for property 'comment'.
     *
     * @return Value for property 'comment'.
     */
    public String getComment() {
        return comment;
    }

    /**
     * Setter for property 'comment'.
     *
     * @param comment Value to set for property 'comment'.
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * Getter for property 'clientName'.
     *
     * @return Value for property 'clientName'.
     */
    public String getClientName() {
        return ClientName;
    }

    /**
     * Setter for property 'clientName'.
     *
     * @param clientName Value to set for property 'clientName'.
     */
    public void setClientName(String clientName) {
        ClientName = clientName;
    }
}
