package org.han.ica.oose.boterbloem.dao;

import org.han.ica.oose.boterbloem.domain.Zorginstelling;

import java.util.List;

/**
 * Interface for handling the ZorginstellingDAO
 */
public interface IZorginstellingDAO {
    /**
     * Creates a new Zorginstelling and adds it to the database
     * @param zorginstelling the Zorginstelling that will be added
     */
    void create(Zorginstelling zorginstelling);

    /**
     * Requests a list of all current Zorginstellingen from the database
     * @return The list of Zorginstellingen
     */
    List<Zorginstelling> getAllZorginstellingen();

    /**
     * Reqeusts a specific Zorginstelling by id from the database
     * @param id The id related to the Zorginstelling to be requested
     * @return The requested Zorginstelling
     */
    Zorginstelling getByID(int id);

    /**
     * Requests a specific Zorginstelling by name from the database
     * @param name The name related to the Zorginstelling to be requested
     * @return The requested Zorginstelling
     */
    List<Zorginstelling> getByName(String name);

    /**
     * Deletes a Zorginstelling with a given id from the database
     * @param id The id related to the Zorginstelling to be deleted
     */
    void deleteById(int id);

    /**
     * Deletes one or multiple Zorginstellingen with a given name from the database
     * @param name
     */
    void deleteByName(String name);
}
