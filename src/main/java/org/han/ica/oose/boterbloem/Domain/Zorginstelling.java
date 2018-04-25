package org.han.ica.oose.boterbloem.Domain;

/**
 * Representative domain class for a Zorginstelling
 */
public class Zorginstelling {
    private int id;
    private String name;

    public Zorginstelling(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
