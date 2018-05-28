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
//public class ClientTest {
//
//    @Test
//    public void testSetter_setsClientId() throws NoSuchFieldException, IllegalAccessException {
//        //given
//        final Client client = new Client();
//
//        client.setClientId(1);
//        //when
//        final Field field = client.getClass().getDeclaredField("clientId");
//        field.setAccessible(true);
//
//        //then
//        assertEquals("Fields didn't match", 1, field.get(client));
//    }
//
//    @Test
//    public void testGetter_getsClientId() throws NoSuchFieldException, IllegalAccessException {
//        //given
//        final Client client = new Client();
//        final Field field = client.getClass().getDeclaredField("clientId");
//        field.setAccessible(true);
//        field.set(client, 1);
//
//        //when
//        final int result = client.getClientId();
//
//        //then
//        assertEquals("field wasn't retrieved properly", 1, result);
//    }
//
//    @Test
//    public void testSetter_setsTotalMeters() throws NoSuchFieldException, IllegalAccessException {
//        //given
//        final Client client = new Client();
//
//        client.setTotalMeters(500);
//        //when
//        final Field field = client.getClass().getDeclaredField("totalMeters");
//        field.setAccessible(true);
//
//        //then
//        assertEquals("Fields didn't match", 500, field.get(client));
//    }
//
//    @Test
//    public void testGetter_getsTotalMeters() throws NoSuchFieldException, IllegalAccessException{
//        // given
//        final Client client = new Client();
//        final Field field = client.getClass().getDeclaredField("totalMeters");
//        field.setAccessible(true);
//        field.set(client, 500);
//
//        //when
//        final int result = client.getTotalMeters();
//
//        //then
//        assertEquals("Field wasn't retrieved properly", 500, result);
//    }
//
//    @Test
//    public void testSetter_setsPKB() throws NoSuchFieldException, IllegalAccessException{
//        //give
//        final Client client = new Client();
//        client.setPKB(500);
//
//        //when
//        final Field field = client.getClass().getDeclaredField("PKB");
//        field.setAccessible(true);
//
//        //then
//        assertEquals("Fields didn't match", 500, field.get(client));
//    }
//
//    @Test
//    public void testGetter_getsPKB() throws NoSuchFieldException, IllegalAccessException{
//        // give
//        final Client client = new Client();
//        final Field field = client.getClass().getDeclaredField("PKB");
//        field.setAccessible(true);
//        field.set(client, 500);
//
//        //when
//        final int result = client.getPKB();
//
//        //then
//        assertEquals("Field wasn't retrieved properly", 500, result);
//    }
//
//    @Test
//    public void testSetter_setsName() throws NoSuchFieldException, IllegalAccessException{
//        //give
//        final Client client = new Client();
//        client.setName("Mees");
//
//        //when
//        final Field field = client.getClass().getDeclaredField("name");
//        field.setAccessible(true);
//
//        //then
//        assertEquals("Fields didn't match", "Mees", field.get(client));
//    }
//
//    @Test
//    public void testGetter_getsName() throws NoSuchFieldException, IllegalAccessException{
//        //give
//        final Client client = new Client();
//        final Field field = client.getClass().getDeclaredField("name");
//        field.setAccessible(true);
//        field.set(client,"Mees");
//
//        //when
//        final String result = client.getName();
//
//        //then
//        assertEquals("Field wasn't retrieved properly","Mees", result);
//    }
//
//    @Test
//    public void testSetter_setsPKBWarning() throws NoSuchFieldException, IllegalAccessException{
//        //give
//        final Client client = new Client();
//        client.setWarningPKB(true);
//
//        //when
//        final Field field = client.getClass().getDeclaredField("warningPKB");
//        field.setAccessible(true);
//
//        //then
//        assertEquals("Fields didn't match", true,field.get(client));
//    }
//
//    @Test
//    public void testGetter_getsPKBWarning() throws NoSuchFieldException, IllegalAccessException{
//        //give
//        final Client client = new Client();
//        final Field field = client.getClass().getDeclaredField("warningPKB");
//        field.setAccessible(true);
//        field.set(client,true);
//
//        //when
//        final boolean result = client.isWarningPKB();
//
//        //then
//        assertEquals("Field wasn't retrieved properly", true, result);
//    }
//
//    @Test
//    public void testSetter_setPriceToPay() throws NoSuchFieldException, IllegalAccessException{
//        //give
//        final Client client = new Client();
//        client.setPriceToPay(423.23);
//
//        //when
//        final Field field = client.getClass().getDeclaredField("priceToPay");
//        field.setAccessible(true);
//
//        //then
//        assertEquals("Fields didn't match properly", 423.23, field.get(client));
//    }
//
//    @Test
//    public void testGetter_getsPriceToPay() throws NoSuchFieldException, IllegalAccessException{
//        //give
//        final Client client = new Client();
//        final Field field = client.getClass().getDeclaredField("priceToPay");
//        field.setAccessible(true);
//        field.set(client,435.34);
//
//        //when
//        final double result = client.getPriceToPay();
//
//        //then
//        assertEquals("Field wasn't retrieved properly", 435.34,result, 0.02);
//    }
//
//    @Test
//    public void testSetter_setsCompanion() throws NoSuchFieldException, IllegalAccessException {
//        //given
//        final Client client = new Client();
//
//        client.setCompanion("Martijn");
//        //when
//        final Field field = client.getClass().getDeclaredField("companion");
//        field.setAccessible(true);
//
//        //then
//        assertEquals("Fields didn't match", "Martijn", field.get(client));
//
//    }
//
//    @Test
//    public void testGetter_getsCompanion() throws NoSuchFieldException, IllegalAccessException {
//        //given
//        final Client client = new Client();
//        final Field field = client.getClass().getDeclaredField("companion");
//        field.setAccessible(true);
//        field.set(client, "Martijn");
//
//        //when
//        final String result = client.getCompanion();
//
//        //then
//        assertEquals("field wasn't retrieved properly", "Martijn", result);
//    }
//
//    @Test
//    public void testSetter_setsUtility() throws NoSuchFieldException, IllegalAccessException {
//        //given
//        final Client client = new Client();
//
//        client.setUtility("Some stuff");
//        //when
//        final Field field = client.getClass().getDeclaredField("utility");
//        field.setAccessible(true);
//
//        //then
//        assertEquals("Fields didn't match", "Some stuff", field.get(client));
//
//    }
//
//    @Test
//    public void testGetter_getsUtility() throws NoSuchFieldException, IllegalAccessException {
//        //given
//        final Client client = new Client();
//        final Field field = client.getClass().getDeclaredField("utility");
//        field.setAccessible(true);
//        field.set(client, "Some stuff");
//
//        //when
//        final String result = client.getUtility();
//
//        //then
//        assertEquals("field wasn't retrieved properly", "Some stuff", result);
//    }
//
//    @Test
//    public void testSetter_setsdriverPreferenceForced() throws NoSuchFieldException, IllegalAccessException {
//
//        //given
//        final Client client = new Client();
//
//        client.setDriverPreferenceF(true);
//        //when
//        final Field field = client.getClass().getDeclaredField("driverPreferenceForced");
//        field.setAccessible(true);
//
//        //then
//        assertEquals("Fields didn't match", true, field.get(client));
//
//    }
//
//    @Test
//    public void testGetter_getsdriverPreferenceForced() throws NoSuchFieldException, IllegalAccessException {
//
//        //given
//        final Client client = new Client();
//        final Field field = client.getClass().getDeclaredField("driverPreferenceForced");
//        field.setAccessible(true);
//        field.set(client, true);
//
//        //when
//        final Boolean result = client.isDriverPreferenceF();
//
//        //then
//        assertEquals("field wasn't retrieved properly", true, result);
//    }
//}
