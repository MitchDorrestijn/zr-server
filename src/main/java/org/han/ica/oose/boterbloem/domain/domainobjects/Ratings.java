package org.han.ica.oose.boterbloem.domain.domainobjects;

public class Ratings {

    // Rating is based on a driver.
    private String driverName;
    private int stars;
    private String comment;
    // client gives a rating
    private String clientName;

    /**
     * Getter for property 'driverName'.
     *
     * @return Value for property 'driverName'.
     */
    public String getdriverName() {
        return driverName;
    }

    /**
     * Setter for property 'driverName'.
     *
     * @param driverName Value to set for property 'driverName'.
     */
    public void setdriverName(String driverName) {
        this.driverName = driverName;
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
    public String getclientName() {
        return clientName;
    }

    /**
     * Setter for property 'clientName'.
     *
     * @param clientName Value to set for property 'clientName'.
     */
    public void setclientName(String clientName) {
        this.clientName = clientName;
    }
}
