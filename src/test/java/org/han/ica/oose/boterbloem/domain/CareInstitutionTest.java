package org.han.ica.oose.boterbloem.domain;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CareInstitutionTest {
    private CareInstitution careInstitution;

    @Before
    public void setUp() throws Exception {
        careInstitution = new CareInstitution(1, "Ziekenhuis de prothese");
    }

    @Test
    public void getId() {
        assertEquals(1, careInstitution.getId());
        assertNotEquals(2, careInstitution.getId());
    }

    @Test
    public void setId() {
        careInstitution.setId(2);
        assertEquals(2, careInstitution.getId());
        assertNotEquals(1, careInstitution.getId());
    }

    @Test
    public void getName() {
        assertEquals("Ziekenhuis de prothese", careInstitution.getName());
        assertNotEquals("Ziekenhuis de prothes", careInstitution.getName());
    }

    @Test
    public void setName() {
        careInstitution.setName("Ziekenhuis de prothes");
        assertEquals("Ziekenhuis de prothes", careInstitution.getName());
        assertNotEquals("Ziekenhuis de prothese", careInstitution.getName());
    }
}