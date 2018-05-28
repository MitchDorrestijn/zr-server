package org.han.ica.oose.boterbloem.entity;

import javax.persistence.*;

@Entity
@Table(name = "clientUtility", schema = "zorgrit")
@IdClass(ClientUtilityEntityPK.class)
public class ClientUtilityEntity {
    private int clientId;
    private String utility;

    @Id
    @Column(name = "clientId")
    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    @Id
    @Column(name = "utility")
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

        ClientUtilityEntity that = (ClientUtilityEntity) o;

        if (clientId != that.clientId) return false;
        if (utility != null ? !utility.equals(that.utility) : that.utility != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = clientId;
        result = 31 * result + (utility != null ? utility.hashCode() : 0);
        return result;
    }
}
