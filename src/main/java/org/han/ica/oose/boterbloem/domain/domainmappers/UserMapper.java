package org.han.ica.oose.boterbloem.domain.domainmappers;

import org.han.ica.oose.boterbloem.dataaccess.daohibernate.IUserDAO;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation.UserDAOImpl;
import org.han.ica.oose.boterbloem.dataaccess.entities.UserEntity;
import org.han.ica.oose.boterbloem.domain.domainobjects.Address;
import org.han.ica.oose.boterbloem.domain.domainobjects.User;

public class UserMapper {

    private IUserDAO userDAO = new UserDAOImpl();

    /**
     * return name from a user
     *
     * @param id
     * @return the name of the user
     */
    public String findNameById(int id) {
        return userDAO.findById(id).getFirstName() + " " + userDAO.findById(id).getLastName();
    }

    /**
     * @param userEntity to bee extracted
     * @return User
     */
    public User extractUser(UserEntity userEntity) {
        User user = new User();
        Address address = new Address();
        address.setHouseNumber(userEntity.getHouseNumber());
        address.setResidence(userEntity.getResidence());
        address.setStreet(userEntity.getStreet());
        address.setZipCode(userEntity.getZipCode());

        user.setFirstName(userEntity.getFirstName());
        user.setLastName(userEntity.getLastName());
        user.setAddress(address);
        user.setDateOfBirth(userEntity.getDateOfBirth());
        user.setEmail(userEntity.getEmail());
        user.setPhoneNumber(userEntity.getPhoneNumber());
        user.setFirstTimeProfileCheck(userEntity.getFirstTimeProfileCheck());
        user.setPassword(userEntity.getPassword());
        return user;

    }

    /**
     * @param user to be converted
     * @param id   either driver or client id
     * @return Entity of user
     */
    public UserEntity convertUser(User user, int id) {
        UserEntity userEntity = new UserEntity();

        userEntity.setDateOfBirth(user.getDateOfBirth());
        userEntity.setEmail(user.getEmail());
        userEntity.setFirstName(user.getFirstName());
        userEntity.setLastName(user.getLastName());
        userEntity.setFirstTimeProfileCheck(user.getFirstTimeProfileCheck());
        userEntity.setHouseNumber(user.getAddress().getHouseNumber());
        userEntity.setResidence(user.getAddress().getResidence());
        userEntity.setStreet(user.getAddress().getStreet());
        userEntity.setZipCode(user.getAddress().getZipCode());
        userEntity.setId(id);
        userEntity.setPassword(user.getPassword());
        userEntity.setPhoneNumber(user.getPhoneNumber());
        return userEntity;
    }

}
