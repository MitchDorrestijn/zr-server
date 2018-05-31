package org.han.ica.oose.boterbloem.dataAccess.entities;

import javax.persistence.*;

@Entity
@Table(name = "utility", schema = "zorgrit")
public class UtilityEntity {
    private String name;
    private int priority;

    @Id
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "priority")
    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UtilityEntity that = (UtilityEntity) o;

        if (priority != that.priority) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + priority;
        return result;
    }
}
