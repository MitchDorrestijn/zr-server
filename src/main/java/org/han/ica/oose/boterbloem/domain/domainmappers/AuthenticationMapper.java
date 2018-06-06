package org.han.ica.oose.boterbloem.domain.domainmappers;

import org.han.ica.oose.boterbloem.dataaccess.daohibernate.IAuthUsersDAO;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation.AuthUsersDAOImpl;
import org.han.ica.oose.boterbloem.dataaccess.entities.AuthUsersEntity;
import org.han.ica.oose.boterbloem.domain.domainobjects.JwtUser;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AuthenticationMapper {
    private IAuthUsersDAO authUsersDAO = new AuthUsersDAOImpl();
    private static final Logger LOGGER = Logger.getLogger(AuthenticationMapper.class.getName());

    /**
     * @return a list of domain objects JwtUser
     */
    public List<JwtUser> getAllAuthenticatedUsers() {
        List<JwtUser> jwtUsers = new ArrayList<>();
        try {
            for (AuthUsersEntity entity : authUsersDAO.findAll()) {
                JwtUser jwtUser = new JwtUser();
                jwtUser.setUserName(entity.getUserName());
                jwtUser.setRole(entity.getRole());
                jwtUser.setEmail(entity.getEmail());
                jwtUsers.add(jwtUser);
            }
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, e.getMessage());
        }
        return jwtUsers;
    }
}
