package org.han.ica.oose.boterbloem.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ZorginstellingTest {
    Zorginstelling zorginstelling;

    @Before
    public void setUp() throws Exception {
        zorginstelling = new Zorginstelling(1, "Ziekenhuis de prothese");
    }

    @Test
    public void getId() {
        assertEquals(1, zorginstelling.getId());
        assertNotEquals(2, zorginstelling.getId());
    }

    @Test
    public void setId() {
        zorginstelling.setId(2);
        assertEquals(2, zorginstelling.getId());
        assertNotEquals(1, zorginstelling.getId());
    }

    @Test
    public void getName() {
        assertEquals("Ziekenhuis de prothese", zorginstelling.getName());
        assertNotEquals("Ziekenhuis de prothes", zorginstelling.getName());
    }

    @Test
    public void setName() {
        zorginstelling.setName("Ziekenhuis de prothes");
        assertEquals("Ziekenhuis de prothes", zorginstelling.getName());
        assertNotEquals("Ziekenhuis de prothese", zorginstelling.getName());
    }
}