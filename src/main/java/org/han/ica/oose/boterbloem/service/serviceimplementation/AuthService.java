package org.han.ica.oose.boterbloem.service.serviceimplementation;

import org.han.ica.oose.boterbloem.dataaccess.daohibernate.IAuthUsersDAO;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation.AuthUsersDAOImpl;
import org.han.ica.oose.boterbloem.domain.domainmappers.AuthenticationMapper;
import org.han.ica.oose.boterbloem.domain.domainmappers.JwtUserMapper;
import org.han.ica.oose.boterbloem.domain.domainobjects.JwtUser;
import org.han.ica.oose.boterbloem.dataaccess.entities.AuthUsersEntity;
import org.han.ica.oose.boterbloem.service.IAuthService;
import org.mindrot.jbcrypt.BCrypt;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AuthService implements IAuthService {
    private static final Logger LOGGER = Logger.getLogger(AuthService.class.getName());
    private AuthenticationMapper authenticationMapper = new AuthenticationMapper();
    private IAuthUsersDAO authUsersDAO = new AuthUsersDAOImpl();
    private JwtUserMapper jwtUserMapper = new JwtUserMapper();

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean tokenExists(String token) {
        return authUsersDAO.findIfTokenExist(token);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateToken(JwtUser jwtUser) {
        jwtUser.updateToken(jwtUser);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void createAuthenticatedUser(JwtUser jwtUser) {
        jwtUser.saveAuthenticatedUser(jwtUser);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JwtUser findByUsername(String userName) {
        return jwtUserMapper.setJwtUserValues(authUsersDAO.findByUserName(userName));
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public List<JwtUser> getAllAuthenticatedUsers() {
        return authenticationMapper.getAllAuthenticatedUsers();
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteAuthenticatedUser(String userName) {
        try {
            AuthUsersEntity authenticatedUserToBeRemoved = authUsersDAO.findByUserName(userName);
            authUsersDAO.remove(authenticatedUserToBeRemoved);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, e.toString(), e);
        }
    }

}
