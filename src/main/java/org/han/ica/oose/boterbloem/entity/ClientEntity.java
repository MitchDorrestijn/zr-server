package org.han.ica.oose.boterbloem.entity;

import javax.persistence.*;

@Entity
@Table(name = "client", schema = "zorgrit", catalog = "")
public class ClientEntity {
    private int clientId;
    private String companion;
    private byte driverPreferenceForced;
    private byte warningPKB;
    private int PKB;
    private byte companionRequired;
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

    @Basic
    @Column(name = "driverPreferenceForced")
    public byte getDriverPreferenceForced() {
        return driverPreferenceForced;
    }

    public void setDriverPreferenceForced(byte driverPreferenceForced) {
        this.driverPreferenceForced = driverPreferenceForced;
    }

    @Basic
    @Column(name = "warningPKB")
    public byte isWarningPKB() {
        return warningPKB;
    }

    public void setWarningPKB(byte warningPKB) {
        this.warningPKB = warningPKB;
    }

    @Basic
    @Column(name = "PKB")
    public int getPKB() {
        return PKB;
    }

    public void setPKB(int PKB) {
        this.PKB = PKB;
    }

    @Basic
    @Column(name = "companionRequired")
    public byte getCompanionRequired() {
        return companionRequired;
    }

    public void setCompanionRequired(byte companionRequired) {
        this.companionRequired = companionRequired;
    }

    @OneToOne
    @JoinColumn(name = "clientId")
    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientEntity that = (ClientEntity) o;

        if (clientId != that.clientId) return false;
        if (driverPreferenceForced != that.driverPreferenceForced) return false;
        return companion != null ? companion.equals(that.companion) : that.companion == null;
    }

    @Override
    public int hashCode() {
        int result = clientId;
        result = 31 * result + (companion != null ? companion.hashCode() : 0);
        result = 31 * result + (int) driverPreferenceForced;
        return result;
    }
}
