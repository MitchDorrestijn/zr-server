package org.han.ica.oose.boterbloem.entity;

import javax.persistence.*;

@Entity
@Table(name = "careInstitution", schema = "zorgrit")
public class CareinstitutionEntity {

    private int id;
    private String name;

    private String street;
    private String houseNumber;
    private String zipCode;
    private String residence;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "street")
    public String getStreet() {return street;}

    public void setStreet(String street) {this.street = street;}

    @Basic
    @Column(name = "houseNumber")
    public String getHouseNumber(){return houseNumber;}

    public void setHouseNumber(String houseNumber){this.houseNumber = houseNumber;}

    @Basic
    @Column(name = "zipCode")
    public String getZipCode(){ return zipCode;}

    public void setZipCode(String zipCode){this.zipCode = zipCode;}

    @Basic
    @Column(name = "residence")
    public String getResidence(){return residence;}

    public void setResidence(String residence){this.residence = residence;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CareinstitutionEntity that = (CareinstitutionEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
