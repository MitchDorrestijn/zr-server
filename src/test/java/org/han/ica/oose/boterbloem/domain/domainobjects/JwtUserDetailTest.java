package org.han.ica.oose.boterbloem.domain.domainobjects;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.security.core.GrantedAuthority;

import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;
import java.util.List;


import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
public class JwtUserDetailTest {

    Collection<? extends GrantedAuthority>  authorities;
    JwtUserDetails jwtUserDetails;

    @Before
    @SuppressWarnings("unchecked")
    public void setup(){
        jwtUserDetails = new JwtUserDetails("name","pass","token", (List<GrantedAuthority>) authorities);

    }


    @Test
    public void testGetterLimitation() {
        assertEquals("Field not retrieved properly", "name", jwtUserDetails.getUsername());
    }

    @Test
    public void getPass()  {
        assertEquals("Field not retrieved properly", "pass", jwtUserDetails.getPassword());
    }

    @Test
    public  void getToken(){
        assertEquals("Field not retrieved properly", authorities, jwtUserDetails.getAuthorities());
    }

    @Test
    public void testTrueaccount(){
        assertTrue(jwtUserDetails.isAccountNonExpired());
    }
    @Test
    public void testNonLocked(){
        assertTrue(jwtUserDetails.isAccountNonLocked());
    }
    @Test
    public void testCredentials(){
        assertTrue(jwtUserDetails.isCredentialsNonExpired());
    }
    @Test
    public void isEnabledTest(){
        assertTrue(jwtUserDetails.isEnabled());
    }
}
