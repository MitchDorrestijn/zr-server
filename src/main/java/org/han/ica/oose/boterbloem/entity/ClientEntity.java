package org.han.ica.oose.boterbloem.entity;

import javax.persistence.*;

@Entity
@Table(name = "client", schema = "zorgrit", catalog = "")
public class ClientEntity {
    private int clientId;
    private String companion;
    private byte driverPreferenceForced;
    private UserEntity userEntity;

    @Id
    @Column(name = "clientId")
    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    @Basic
    @Column(name = "companion")
    public String getCompanion() {
        return companion;
    }

    public void setCompanion(String companion) {
        this.companion = companion;
    }


    @OneToOne
    @JoinColumn(name = "clientId")
    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    @Basic
    @Column(name = "driverPreferenceForced")
    public byte getDriverPreferenceForced() {
        return driverPreferenceForced;
    }

    public void setDriverPreferenceForced(byte driverPreferenceForced) {
        this.driverPreferenceForced = driverPreferenceForced;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientEntity that = (ClientEntity) o;

        if (clientId != that.clientId) return false;
        if (driverPreferenceForced != that.driverPreferenceForced) return false;
        if (companion != null ? !companion.equals(that.companion) : that.companion != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = clientId;
        result = 31 * result + (companion != null ? companion.hashCode() : 0);
        result = 31 * result + (int) driverPreferenceForced;
        return result;
    }
}
