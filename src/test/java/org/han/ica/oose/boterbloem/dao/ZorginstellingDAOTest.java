package org.han.ica.oose.boterbloem.dao;

import org.han.ica.oose.boterbloem.domain.Zorginstelling;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class ZorginstellingDAOTest {

    @Autowired
    private ZorginstellingDAO dao;

    @Transactional
    @Rollback(true)
    @Test
    public void create() {
        Zorginstelling zorginstelling = new Zorginstelling(6, "De prothese" );
        dao.create(zorginstelling);

        List<Zorginstelling> zorginstellingen = dao.getAllZorginstellingen();
        assertEquals(zorginstelling.getId(), zorginstellingen.get(5).getId());
    }

    @Test
    public void getAllZorginstellingen() {
    }

    @Test
    public void getByID() {
    }

    @Test
    public void getByName() {
    }

    @Test
    public void deleteById() {
    }

    @Test
    public void deleteByName() {
    }
}