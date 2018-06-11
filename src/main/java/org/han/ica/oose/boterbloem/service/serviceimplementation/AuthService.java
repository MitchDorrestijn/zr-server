package org.han.ica.oose.boterbloem.service.serviceimplementation;

import org.han.ica.oose.boterbloem.dataaccess.daohibernate.IAuthUsersDAO;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation.AuthUsersDAOImpl;
import org.han.ica.oose.boterbloem.domain.domainmappers.AuthenticationMapper;
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

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean userIsValid(String userName){
        return checkIfItemHasTheSameValue(userName, "userName");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean tokenExists(String token) {
        return checkIfItemHasTheSameValue(token, "token");
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
    public String findUserRoleByUsernameAndPassword(String userName, String password) {
        List<AuthUsersEntity> authUsersEntities = authUsersDAO.findAll();
        String userRole = "";
        try {
            for (AuthUsersEntity authUsersEntity : authUsersEntities) {
                if (userExists(userName, password, authUsersEntity)) {
                    userRole = authUsersEntity.getRole();
                }
            }
        } catch (Exception e){
            LOGGER.log(Level.WARNING, e.getMessage());
        }
        return userRole;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int findCareInstitutionIdByUsernameAndPassword(String userName, String password) {
        List<AuthUsersEntity> authUsersEntities = authUsersDAO.findAll();
        int careInstitutionId = 0;
        try {
            for (AuthUsersEntity authUsersEntity : authUsersEntities) {
                if (userExists(userName, password, authUsersEntity)){
                    careInstitutionId = authUsersEntity.getCareInstitutionId();
                }
            }
        } catch (Exception e){
            LOGGER.log(Level.WARNING, e.getMessage());
        }
        return careInstitutionId;
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
            System.out.println(authenticatedUserToBeRemoved.getUserName());
            authUsersDAO.remove(authenticatedUserToBeRemoved);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, e.toString(), e);
        }
    }

    /**
     * This method checks if the user exists and can only be called in a loop
     * @param userName the username of the user
     * @param password the password of the user
     * @param authUsersEntity the list of userEntities where the user has to be found in
     * @return true if the user is found, false if the user is not found
     */
    private boolean userExists(String userName, String password, AuthUsersEntity authUsersEntity) {
        return authUsersEntity.getUserName().equals(userName) && BCrypt.checkpw(password, authUsersEntity.getPassword());
    }

    /**
     * This method checks if an item matches another item within the user entities
     * @param theItem the items that needs to be matched
     * @param valueToCheckFor where @param theItem must be equal to
     * @return true is the item matches, fals if it does not match
     */
    public boolean checkIfItemHasTheSameValue(String theItem, String valueToCheckFor){
        List<AuthUsersEntity> authUsersEntities = authUsersDAO.findAll();
        boolean theItemHasTheSameValue = false;
        try {
            for (AuthUsersEntity authUsersEntity : authUsersEntities) {
                if(valueToCheckFor == "token") {
                    if (authUsersEntity.getLatestToken().equals(theItem)) {
                        theItemHasTheSameValue = true;
                    }
                } else if(valueToCheckFor == "userName") {
                    if (authUsersEntity.getUserName().equals(theItem)) {
                        theItemHasTheSameValue = true;
                    }
                }
            }
        } catch (Exception e){
            LOGGER.log(Level.WARNING, e.getMessage());
        }
        return theItemHasTheSameValue;
    }
}
