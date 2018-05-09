package org.han.ica.oose.boterbloem.dao;

import org.han.ica.oose.boterbloem.domain.Zorginstelling;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class for handling the CRUD operations on Zorginstelling
 */
public class ZorginstellingDAO implements IZorginstellingDAO{
    private static final Logger LOGGER = Logger.getLogger(ZorginstellingDAO.class.getName());
    public DAO dao;

    public ZorginstellingDAO() {
        dao = new DAO();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void create(Zorginstelling zorginstelling) {
        try (PreparedStatement ps = dao.getPreparedStatement(
                "INSERT INTO careInstitution (name) VALUES (?)")) {
            ps.setString(1, zorginstelling.getName());
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
        try (PreparedStatement ps = dao.getPreparedStatement("SELECT * FROM careInstitution");
             ResultSet rs = ps.executeQuery()) {
            while(rs.next()) {
                String foundName = rs.getString("name");
                int foundId = rs.getInt("id");
                Zorginstelling zorginstelling = new Zorginstelling(foundId,foundName);
                zorginstellingen.add(zorginstelling);
            }
            return zorginstellingen;
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, e.toString(), e);
        }
        return zorginstellingen;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Zorginstelling getByID(int id) {
        Zorginstelling zorginstelling;
        try (PreparedStatement ps = dao.getPreparedStatement("select * from careInstitution WHERE id =" + id);
             ResultSet rs = ps.executeQuery()){
            while(rs.next()) {
                String foundName = rs.getString("name");
                int foundID  = rs.getInt("id");
                zorginstelling = new Zorginstelling(foundID,foundName);
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
        try (PreparedStatement ps = dao.getPreparedStatement("SELECT * FROM careInstitution WHERE name = '" + name + "'");
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
        return zorginstellingen;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteById(int id) {
        try (PreparedStatement ps = dao.getPreparedStatement(
                "DELETE FROM careInstitution "
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
        try (PreparedStatement ps = dao.getPreparedStatement(
                "DELETE FROM careInstitution "
                        + "WHERE name = ? ")){
            ps.setString(1, name);
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.INFO, e.toString(), e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateZorginstelling(int id, String newName){
        try (PreparedStatement ps = dao.getPreparedStatement(
                "UPDATE careInstitution SET name = ? WHERE id = ?")){
            ps.setString(1,newName);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.INFO, e.toString(), e);
        }
    }
}