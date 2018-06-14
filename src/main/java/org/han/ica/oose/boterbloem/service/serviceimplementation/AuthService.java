package org.han.ica.oose.boterbloem.service.serviceimplementation;

import org.han.ica.oose.boterbloem.dataaccess.daohibernate.IAuthUsersDAO;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation.AuthUsersDAOImpl;
import org.han.ica.oose.boterbloem.domain.domainmappers.AuthenticationMapper;
import org.han.ica.oose.boterbloem.domain.domainmappers.JwtUserMapper;
import org.han.ica.oose.boterbloem.domain.domainobjects.JwtUser;
import org.han.ica.oose.boterbloem.dataaccess.entities.AuthUsersEntity;
import org.han.ica.oose.boterbloem.service.IAuthService;

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

    /**
     * Setter for property 'authenticationMapper'.
     *
     * @param authenticationMapper Value to set for property 'authenticationMapper'.
     */
    public void setAuthenticationMapper(AuthenticationMapper authenticationMapper) {
        this.authenticationMapper = authenticationMapper;
    }

    /**
     * Setter for property 'authUsersDAO'.
     *
     * @param authUsersDAO Value to set for property 'authUsersDAO'.
     */
    public void setAuthUsersDAO(IAuthUsersDAO authUsersDAO) {
        this.authUsersDAO = authUsersDAO;
    }

    /**
     * Setter for property 'jwtUserMapper'.
     *
     * @param jwtUserMapper Value to set for property 'jwtUserMapper'.
     */
    public void setJwtUserMapper(JwtUserMapper jwtUserMapper) {
        this.jwtUserMapper = jwtUserMapper;
    }
}
