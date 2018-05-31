package org.han.ica.oose.boterbloem.dataaccess.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class ClientlimitationEntityPK implements Serializable {
    private int clientId;
    private String limitation;

    @Column(name = "clientId")
    @Id
    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    @Column(name = "limitation")
    @Id
    public String getLimitation() {
        return limitation;
    }

    public void setLimitation(String limitation) {
        this.limitation = limitation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientlimitationEntityPK that = (ClientlimitationEntityPK) o;

        if (clientId != that.clientId) return false;
        if (limitation != null ? !limitation.equals(that.limitation) : that.limitation != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = clientId;
        result = 31 * result + (limitation != null ? limitation.hashCode() : 0);
        return result;
    }
}
