package org.han.ica.oose.boterbloem.domain.domainmappers;

import org.han.ica.oose.boterbloem.dataaccess.daohibernate.IUserDAO;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation.UserDAOImpl;

public class UserMapper {

    private IUserDAO userDAO = new UserDAOImpl();

    /**
     * return name from a user
     * @param id
     * @return the name of the user
     */
    public String findNameById(int id) {
        return userDAO.findById(id).getFirstName() + " " + userDAO.findById(id).getLastName();
    }
}
