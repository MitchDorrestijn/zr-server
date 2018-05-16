//package org.han.ica.oose.boterbloem.dao;
//
//import org.han.ica.oose.boterbloem.domain.CareInstitution;
//
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
///**
// * Class for handling the CRUD operations on CareInstitution
// */
//
//public class CareInstitutionDAO implements ICareInstitutionDAO {
//    private static final Logger LOGGER = Logger.getLogger(CareInstitutionDAO.class.getName());
//    public static final IConnectionDAO CONNECTION_DAO = new ConnectionDAO();
//
//    public CareInstitutionDAO() {
//        // empty constructor because of Spring
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public void create(CareInstitution careInstitution) {
//        try (PreparedStatement ps = CONNECTION_DAO.getPreparedStatement(
//                "INSERT INTO careInstitution (name) VALUES (?)")) {
//            ps.setString(1, careInstitution.getName());
//            ps.executeUpdate();
//        } catch (SQLException e) {
//            LOGGER.log(Level.SEVERE, e.toString(), e);
//        }
//
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public List<CareInstitution> getAllCareInstitutions() {
//        List<CareInstitution> careInstitutions = new ArrayList<>();
//        try (PreparedStatement ps = CONNECTION_DAO.getPreparedStatement("SELECT * FROM careInstitution");
//             ResultSet rs = ps.executeQuery()) {
//            while (rs.next()) {
//                String foundName = rs.getString("name");
//                int foundId = rs.getInt("id");
//                CareInstitution careInstitution = new CareInstitution(foundId, foundName);
//                careInstitutions.add(careInstitution);
//            }
//            return careInstitutions;
//        } catch (SQLException e) {
//            LOGGER.log(Level.SEVERE, e.toString(), e);
//        }
//        return careInstitutions;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    public CareInstitution getByID(int id) {
//        CareInstitution careInstitution;
//        try (PreparedStatement ps = CONNECTION_DAO.getPreparedStatement("select * from careInstitution WHERE id =" + id);
//             ResultSet rs = ps.executeQuery()) {
//            while (rs.next()) {
//                String foundName = rs.getString("name");
//                int foundID = rs.getInt("id");
//                careInstitution = new CareInstitution(foundID, foundName);
//                return careInstitution;
//            }
//        } catch (SQLException e) {
//            LOGGER.log(Level.SEVERE, e.toString(), e);
//        }
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public List<CareInstitution> getByName(String name) {
//        List<CareInstitution> careInstitutions = new ArrayList<>();
//        try (PreparedStatement ps = CONNECTION_DAO.getPreparedStatement("SELECT * FROM careInstitution WHERE name = '" + name + "'");
//             ResultSet rs = ps.executeQuery()) {
//            while (rs.next()) {
//                CareInstitution careInstitution = new CareInstitution(
//                        rs.getInt("id"),
//                        rs.getString("name")
//                );
//                careInstitutions.add(careInstitution);
//            }
//            return careInstitutions;
//        } catch (SQLException e) {
//            LOGGER.log(Level.SEVERE, e.toString(), e);
//        }
//        return careInstitutions;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public void deleteById(int id) {
//        try (PreparedStatement ps = CONNECTION_DAO.getPreparedStatement(
//                "DELETE FROM careInstitution "
//                        + "WHERE id = ? ")) {
//            ps.setInt(1, id);
//            ps.executeUpdate();
//        } catch (SQLException e) {
//            LOGGER.log(Level.INFO, e.toString(), e);
//        }
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public void deleteByName(String name) {
//        try (PreparedStatement ps = CONNECTION_DAO.getPreparedStatement(
//                "DELETE FROM careInstitution "
//                        + "WHERE name = ? ")) {
//            ps.setString(1, name);
//            ps.executeUpdate();
//        } catch (SQLException e) {
//            LOGGER.log(Level.INFO, e.toString(), e);
//        }
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public void updateCareInstitution(int id, String newName) {
//
//        try (PreparedStatement ps = CONNECTION_DAO.getPreparedStatement(
//                "UPDATE careInstitution SET name = ? WHERE id = ?")) {
//            ps.setString(1, newName);
//            ps.setInt(2, id);
//            ps.executeUpdate();
//        } catch (SQLException e) {
//            LOGGER.log(Level.INFO, e.toString(), e);
//        }
//    }
//}