package org.han.ica.oose.boterbloem.domain.domainmappers;

import org.han.ica.oose.boterbloem.dataaccess.entities.AuthUsersEntity;
import org.han.ica.oose.boterbloem.domain.domainobjects.JwtUser;
import org.han.ica.oose.boterbloem.utils.exceptions.UserNotFoundException;

public class JwtUserMapper {
    public JwtUser convertEntityToDomain(AuthUsersEntity authUsersEntity){
        return setJwtUserValues(authUsersEntity);
    }

    public JwtUser setJwtUserValues(AuthUsersEntity authUsersEntity){
        JwtUser jwtUser = new JwtUser();
        try {
            jwtUser.setUserName(authUsersEntity.getUserName());
            jwtUser.setPassword(authUsersEntity.getPassword());
            jwtUser.setCareInstitutionId(authUsersEntity.getCareInstitutionId());
            jwtUser.setRole(authUsersEntity.getRole());
            jwtUser.setLatestToken(authUsersEntity.getLatestToken());
        } catch (NullPointerException e){
            throw new UserNotFoundException("USER DOES NOT EXISTS");
        }
        return jwtUser;
    }
}
