package org.han.ica.oose.boterbloem.service.serviceimplementation;

import org.han.ica.oose.boterbloem.dataaccess.daohibernate.IAuthUsersDAO;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation.AuthUsersDAOImpl;
import org.han.ica.oose.boterbloem.domain.domainobjects.JwtUser;
import org.han.ica.oose.boterbloem.dataaccess.entities.AuthUsersEntity;
import org.han.ica.oose.boterbloem.service.IAuthService;
import org.mindrot.jbcrypt.BCrypt;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AuthService implements IAuthService {
    private static final Logger LOGGER = Logger.getLogger(AuthService.class.getName());
    private IAuthUsersDAO authUsersDAO = new AuthUsersDAOImpl();

    @Override
    public boolean userIsValid(String userName, String password){
        List<AuthUsersEntity> authUsersEntities = authUsersDAO.findAll();
        boolean userIsValid = false;
        try {
            for (int i = 0; i < authUsersEntities.size(); i++) {
                if (authUsersEntities.get(i).getUserName().equals(userName) && BCrypt.checkpw(password, authUsersEntities.get(i).getPassword())) {
                    userIsValid = true;
                }
            }
        } catch (Exception e){
            LOGGER.log(Level.WARNING, e.getMessage());
        }
        return userIsValid;
    }

    @Override
    public void updateToken(JwtUser jwtUser) {
        jwtUser.updateToken(jwtUser);
    }

    @Override
    public boolean tokenExists(String token) {
        List<AuthUsersEntity> authUsersEntities = authUsersDAO.findAll();
        boolean tokenExists = false;
        int i = 0;
        try {
            System.out.println(authUsersEntities.size());
            for (AuthUsersEntity authUsersEntity : authUsersEntities) {
                System.out.println(authUsersEntities.get(i));
                System.out.println("-----------------------------------------");
                System.out.println("Token vergelijken 1=db, 2=meegegeven:");
                System.out.println(authUsersEntity.getLatestToken());
                System.out.println(token);
                System.out.println("-----------------------------------------");

                if (authUsersEntity.getLatestToken().equals(token)) {
                    tokenExists = true;
                }
                i++;
            }
        } catch (Exception e){
            LOGGER.log(Level.WARNING, e.getMessage());
        }
        return tokenExists;
    }

    @Override
    public String findUserRoleByUsernameAndPassword(String userName, String password) {
        List<AuthUsersEntity> authUsersEntities = authUsersDAO.findAll();
        String userRole = "";
        try {
            for (int i = 0; i < authUsersEntities.size(); i++) {
                if (authUsersEntities.get(i).getUserName().equals(userName) && BCrypt.checkpw(password, authUsersEntities.get(i).getPassword())) {
                    userRole = authUsersEntities.get(i).getRole();
                }
            }
        } catch (Exception e){
            LOGGER.log(Level.WARNING, e.getMessage());
        }
        return userRole;
    }

    @Override
    public int findCareInstitutionIdByUsernameAndPassword(String userName, String password) {
        List<AuthUsersEntity> authUsersEntities = authUsersDAO.findAll();
        int careInstitutionId = 0;
        try {
            for (int i = 0; i < authUsersEntities.size(); i++) {
                if (authUsersEntities.get(i).getUserName().equals(userName) && BCrypt.checkpw(password, authUsersEntities.get(i).getPassword())) {
                    careInstitutionId = authUsersEntities.get(i).getCareInstitutionId();
                }
            }
        } catch (Exception e){
            LOGGER.log(Level.WARNING, e.getMessage());
        }
        return careInstitutionId;
    }

    @Override
    public void createAuthenticatedUser(JwtUser jwtUser) {
        jwtUser.saveAuthenticatedUser(jwtUser);
    }


}
