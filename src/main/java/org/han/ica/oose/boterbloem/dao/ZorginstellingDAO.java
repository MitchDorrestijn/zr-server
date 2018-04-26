package org.han.ica.oose.boterbloem.dao;

import org.han.ica.oose.boterbloem.domain.Zorginstelling;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

/**
 * Class for handling the CRUD operations on Zorginstelling
 */
public class ZorginstellingDAO extends DAO implements IZorginstellingDAO{
    /**
     * {@inheritDoc}
     */
    @Override
    public void create(Zorginstelling zorginstelling) {
        try (PreparedStatement ps = getPreparedStatement(
                "INSERT INTO careInstitution ("
                        + "id, "
                        + "name, "
                        + ")"
                        + "VALUES (?, ?")) {
            ps.setInt(1, zorginstelling.getId());
            ps.setString(2, zorginstelling.getName());
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, e.toString(), e);
        }

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Zorginstelling> getAllZorginstellingen() {
        List<Zorginstelling> zorginstellingen = new ArrayList<>();
        try (PreparedStatement ps = getPreparedStatement("SELECT * FROM careinstitution");
             ResultSet rs = ps.executeQuery()) {
            while(rs.next()) {
                Zorginstelling zorginstelling = new Zorginstelling(
                        rs.getInt("id"),
                        rs.getString("name")
                );
                zorginstellingen.add(zorginstelling);
            }
            return zorginstellingen;
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, e.toString(), e);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Zorginstelling getByID(int id) {
        Zorginstelling zorginstelling;
        try (PreparedStatement ps = getPreparedStatement("SELECT * FROM careinstitution WHERE id = " + id);
             ResultSet rs = ps.executeQuery()){
            while(rs.next()) {
                zorginstelling = new Zorginstelling(
                        rs.getInt("id"),
                        rs.getString("name")
                );
                return zorginstelling;
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, e.toString(), e);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Zorginstelling> getByName(String name) {
        List<Zorginstelling> zorginstellingen = new ArrayList<>();
        try (PreparedStatement ps = getPreparedStatement("SELECT * FROM careinstitution WHERE name = '" + name + "'");
             ResultSet rs = ps.executeQuery()) {
            while(rs.next()) {
                Zorginstelling zorginstelling = new Zorginstelling(
                        rs.getInt("id"),
                        rs.getString("name")
                );
                zorginstellingen.add(zorginstelling);
            }
            return zorginstellingen;
        } catch (SQLException e ) {
            LOGGER.log(Level.SEVERE, e.toString(), e);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteById(int id) {
        try (PreparedStatement ps = getPreparedStatement(
                "DELETE FROM careinstitution "
                        + "WHERE id = ? ")){
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.INFO, e.toString(), e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteByName(String name) {
        try (PreparedStatement ps = getPreparedStatement(
                "DELETE FROM careinstitution "
                        + "WHERE name = ? ")){
            ps.setString(1, name);
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.INFO, e.toString(), e);
        }
    }
}
