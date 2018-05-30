package org.han.ica.oose.boterbloem.entity;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name = "careInstitution", schema = "zorgrit")
public class CareinstitutionEntity {
    private int id;
    private String name;
    private String address;
    private String community;
    private int telephonenumber;

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
    @Column(name = "address")
    public String getAddress(){return address;}

    public void setAddress(String address) {this.address = address;}

    @Basic
    @Column(name = "community")
    public String getCommunity(){return community;}

    public void setCommunity(String community) {this.community = community;}

    @Basic
    @Column(name = "telephonenumber")
    public int getTelephonenumber(){return telephonenumber; }

    public void setTelephonenumber(int telephonenumber){this.telephonenumber = telephonenumber;}

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
