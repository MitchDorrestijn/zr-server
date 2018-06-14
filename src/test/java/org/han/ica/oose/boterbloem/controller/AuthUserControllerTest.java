package org.han.ica.oose.boterbloem.controller;


import org.han.ica.oose.boterbloem.JpaTestConfig;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.IAuthUsersDAO;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation.AuthUsersDAOImpl;
import org.han.ica.oose.boterbloem.domain.domainmappers.AuthenticationMapper;

import org.han.ica.oose.boterbloem.domain.domainobjects.JwtUser;
import org.han.ica.oose.boterbloem.security.JwtGenerator;
import org.han.ica.oose.boterbloem.security.SecurityProperties;
import org.han.ica.oose.boterbloem.service.serviceimplementation.AuthService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@WithMockUser(username="Alex",password = "Qwerty123",roles={"ADMIN","CAREINSTITUTION"})
public class AuthUserControllerTest extends JpaTestConfig {

    AuthUserController authUserController = new AuthUserController();
    AuthService authService =  new AuthService();
    private AuthenticationMapper authenticationMapper = new AuthenticationMapper();
    private IAuthUsersDAO authUsersDAO = new AuthUsersDAOImpl();
    JwtGenerator jwtGenerator =  new JwtGenerator();
    TokenController tokenController;



    @Before
    public void setup(){
        authUsersDAO.setEntityManager(em);
        authenticationMapper.setAuthUsersDAO(authUsersDAO);
        authService.setAuthUsersDAO(authUsersDAO);
        authService.setAuthenticationMapper(authenticationMapper);
        authUserController.setAuthService(authService);
        jwtGenerator.setAuthService(authService);
        jwtGenerator.setSecurityProperties(new SecurityProperties());
        tokenController =  new TokenController(jwtGenerator);
        tokenController.setAuthService(authService);
    }

    @Test
    public void getAllAuthenticatedUsersTest(){
        List<JwtUser> jwtUserList =  authUserController.getAllAuthenticatedUsers();
        assertEquals(2,jwtUserList.size());
        JwtUser jwtUser =  new JwtUser();
        jwtUser.setRole("ADMIN");
        jwtUser.setUserName("Martijn");
        jwtUser.setCareInstitutionId(1);
        jwtUser.setPassword("SomePassword");
        jwtUser.setEmail("some email");
        jwtUser.setAuthUsersDAO(authUsersDAO);
        authUserController.addAuthenticatedUser(jwtUser);

        assertEquals(3,authUserController.getAllAuthenticatedUsers().size());

        authUserController.deleteAuthenticatedUser("Martijn");

        assertEquals(2,authUserController.getAllAuthenticatedUsers().size());

    }

    @Test
    public void generatorTest(){
    JwtUser jwtUser =  new JwtUser();
    jwtUser.setUserName("Mitch");
    jwtUser.setPassword("Qwerty123");
        String someString = tokenController.generate(jwtUser);
    //    assertEquals(someString,tokenController.generate(jwtUserList.get(1)));
    }


}
