package org.han.ica.oose.boterbloem.dataaccess.entities;



import javax.persistence.*;


@Entity
@Table(name = "driver", schema = "zorgrit")
public class DriverEntity {
    private int driverId;
    private byte verification;
    private UserEntity userEntity;
    private String typeOfPayment;
    private String image;
    private String accountnr;

    @Id
    @Column(name = "driverId")
    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "driverId")
    @MapsId
    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }



    @Basic
    @Column(name = "typeOfPayment")
    public String getTypeOfPayment() {
        return typeOfPayment;
    }

    public void setTypeOfPayment(String typeOfPayment) {
        this.typeOfPayment = typeOfPayment;
    }

    @Basic
    @Column(name = "verification")
    public byte getVerification() {
        return verification;
    }

    public void setVerification(byte verification) {
        this.verification = verification;
    }

//    @Basic
//    @Column(name = "utility")
//    public String getUtility() {
//        return utility;
//    }
//
//    public void setUtility(String utility) {
//        this.utility = utility;
//    }

    @Basic
    @Column(name = "image")
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Basic
    @Column(name = "accountnr")
    public String getAccountnr() {
        return accountnr;
    }

    public void setAccountnr(String accountnr) {
        this.accountnr = accountnr;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DriverEntity that = (DriverEntity) o;

        if (driverId != that.driverId) return false;
        if (verification != that.verification) return false;
        //if (utility != null ? !utility.equals(that.utility) : that.utility != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = driverId;
        result = 31 * result + (int) verification;
        //result = 31 * result + (utility != null ? utility.hashCode() : 0);
        return result;
    }
}
