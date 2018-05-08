package org.han.ica.oose.boterbloem.service;

import org.han.ica.oose.boterbloem.domain.Zorginstelling;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.SQLException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ZorginstellingServiceTest {

    private Zorginstelling zorginstellingA = new Zorginstelling(1, "instellingA");
    private Zorginstelling zorginstellingB = new Zorginstelling(2, "instellingB");
    private Zorginstelling zorginstellingC = new Zorginstelling(3, "instellingC");
    private Zorginstelling zorginstellingD = new Zorginstelling(4, "instellingD");
    private Zorginstelling zorginstellingE = new Zorginstelling(5, "instellingE");


    @Test
    public void findByID(){
        ZorginstellingService serviceMock = mock(ZorginstellingService.class);

    }
}
