package org.han.ica.oose.boterbloem.domain.domainMappers;

import org.han.ica.oose.boterbloem.dataAccess.daoHibernate.IUserDAO;
import org.han.ica.oose.boterbloem.dataAccess.daoHibernate.daoImplementation.UserDAOImpl;

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
