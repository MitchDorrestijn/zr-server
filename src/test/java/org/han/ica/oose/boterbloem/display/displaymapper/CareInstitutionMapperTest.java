package org.han.ica.oose.boterbloem.display.displaymapper;

import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@WithMockUser(username="Alex",password = "Qwerty123",roles={"ADMIN","CAREINSTITUTION"})
public class CareInstitutionMapperTest {

    @Test
    public void emptyTestForCoverage(){

    }
}
