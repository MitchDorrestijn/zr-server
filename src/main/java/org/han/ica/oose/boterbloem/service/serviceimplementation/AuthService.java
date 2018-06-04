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
    public void createAuthenticatedUser(JwtUser jwtUser) {
        jwtUser.saveAuthenticatedUser(jwtUser);
    }
}
