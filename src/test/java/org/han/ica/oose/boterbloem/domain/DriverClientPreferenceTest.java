//package org.han.ica.oose.boterbloem.domain;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.lang.reflect.Field;
//
//import static org.junit.Assert.assertEquals;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class DriverClientPreferenceTest {
//
//    @Test
//    public void testGetter_getsDriverId() throws NoSuchFieldException, IllegalAccessException {
//        //given
//        final DriverClientPreference driverClientPreference = new DriverClientPreference();
//        final Field field = driverClientPreference.getClass().getDeclaredField("driverId");
//        field.setAccessible(true);
//        field.set(driverClientPreference, 1);
//
//        //when
//        final int result = driverClientPreference.getDriverId();
//
//        //then
//        assertEquals("field wasn't retrieved properly", 1, result);
//    }
//
//    @Test
//    public void testSetter_setsDriverId() throws NoSuchFieldException, IllegalAccessException {
//        //given
//        final DriverClientPreference driverClientPreference = new DriverClientPreference();
//
//        driverClientPreference.setDriverId(1);
//        //when
//        final Field field = driverClientPreference.getClass().getDeclaredField("driverId");
//        field.setAccessible(true);
//
//        //then
//        assertEquals("Fields didn't match", 1, field.get(driverClientPreference));
//
//    }
//
//    @Test
//    public void testGetter_getsClientId() throws NoSuchFieldException, IllegalAccessException {
//        //given
//        final DriverClientPreference driverClientPreference = new DriverClientPreference();
//        final Field field = driverClientPreference.getClass().getDeclaredField("clientId");
//        field.setAccessible(true);
//        field.set(driverClientPreference, 1);
//
//        //when
//        final int result = driverClientPreference.getClientId();
//
//        //then
//        assertEquals("field wasn't retrieved properly", 1, result);
//    }
//
//    @Test
//    public void testSetter_setsClientId() throws NoSuchFieldException, IllegalAccessException {
//        //given
//        final DriverClientPreference driverClientPreference = new DriverClientPreference();
//
//        driverClientPreference.setClientId(1);
//        //when
//        final Field field = driverClientPreference.getClass().getDeclaredField("clientId");
//        field.setAccessible(true);
//
//        //then
//        assertEquals("Fields didn't match", 1, field.get(driverClientPreference));
//
//    }
//}
