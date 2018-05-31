package org.han.ica.oose.boterbloem.dataAccess.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class ClientUtilityEntityPK implements Serializable {
    private int clientId;
    private String utility;

    @Column(name = "clientId")
    @Id
    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    @Column(name = "utility")
    @Id
    public String getUtility() {
        return utility;
    }

    public void setUtility(String utility) {
        this.utility = utility;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientUtilityEntityPK that = (ClientUtilityEntityPK) o;

        if (clientId != that.clientId) return false;
        if (utility != null ? !utility.equals(that.utility) : that.utility!= null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = clientId;
        result = 31 * result + (utility != null ? utility.hashCode() : 0);
        return result;
    }
}
