package org.han.ica.oose.boterbloem.mapper;

import org.han.ica.oose.boterbloem.daoHibernate.IUserDAO;
import org.han.ica.oose.boterbloem.daoHibernate.UserDAOImpl;

public class GenericMapper {
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
