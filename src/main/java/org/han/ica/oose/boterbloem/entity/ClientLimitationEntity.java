package org.han.ica.oose.boterbloem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "clientLimitation")
public class ClientLimitationEntity {

    @Id
    int clientId;

    @Id
    @Column(name = "limitation")
    String limitation;

    /**
     * Getter for property 'clientId'.
     *
     * @return Value for property 'clientId'.
     */
    public int getClientId() {
        return clientId;
    }

    /**
     * Setter for property 'clientId'.
     *
     * @param clientId Value to set for property 'clientId'.
     */
    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    /**
     * Getter for property 'limitation'.
     *
     * @return Value for property 'limitation'.
     */
    public String getLimitation() {
        return limitation;
    }

    /**
     * Setter for property 'limitation'.
     *
     * @param limitation Value to set for property 'limitation'.
     */
    public void setLimitation(String limitation) {
        this.limitation = limitation;
    }
}
