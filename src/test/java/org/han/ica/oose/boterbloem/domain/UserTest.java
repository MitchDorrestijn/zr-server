//package org.han.ica.oose.boterbloem.domain;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//
//import java.lang.reflect.Field;
//
//import java.util.Date;
//
//import static org.junit.Assert.assertEquals;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class UserTest {
//
//
//    @Test
//    public void testSetter_setsId() throws NoSuchFieldException, IllegalAccessException {
//        //given
//        final User testUser = new User();
//
//        testUser.setId(1);
//        //when
//        final Field field = testUser.getClass().getDeclaredField("id");
//        field.setAccessible(true);
//
//        //then
//        assertEquals("Fields didn't match", 1, field.get(testUser));
//
//    }
//
//    @Test
//    public void testGetter_getsId() throws NoSuchFieldException, IllegalAccessException {
//        //given
//        final User testUser = new User();
//        final Field field = testUser.getClass().getDeclaredField("id");
//        field.setAccessible(true);
//        field.set(testUser, 1);
//
//        //when
//        final int result = testUser.getId();
//
//        //then
//        assertEquals("field wasn't retrieved properly", 1, result);
//    }
//
//    @Test
//    public void testSetter_setsLastname() throws NoSuchFieldException, IllegalAccessException {
//        //given
//        final User testUser = new User();
//
//        testUser.setLastName("Nieuwhof");
//        //when
//        final Field field = testUser.getClass().getDeclaredField("lastName");
//        field.setAccessible(true);
//
//        //then
//        assertEquals("Fields didn't match", "Nieuwhof", field.get(testUser));
//
//    }
//
//    @Test
//    public void testGetter_getsLastname() throws NoSuchFieldException, IllegalAccessException {
//        //given
//        final User testUser = new User();
//        final Field field = testUser.getClass().getDeclaredField("lastName");
//        field.setAccessible(true);
//        field.set(testUser, "Nieuwhof");
//
//        //when
//        final String result = testUser.getLastName();
//
//        //then
//        assertEquals("field wasn't retrieved properly", "Nieuwhof", result);
//    }
//
//    @Test
//    public void testSetter_setsFirtname() throws NoSuchFieldException, IllegalAccessException {
//        //given
//        final User testUser = new User();
//
//        testUser.setFirstName("Ben");
//        //when
//        final Field field = testUser.getClass().getDeclaredField("firstName");
//        field.setAccessible(true);
//
//        //then
//        assertEquals("Fields didn't match", "Ben", field.get(testUser));
//
//    }
//
//    @Test
//    public void testGetter_getsFirstname() throws NoSuchFieldException, IllegalAccessException {
//        //given
//        final User testUser = new User();
//        final Field field = testUser.getClass().getDeclaredField("firstName");
//        field.setAccessible(true);
//        field.set(testUser, "Ben");
//
//        //when
//        final String result = testUser.getFirstName();
//
//        //then
//        assertEquals("field wasn't retrieved properly", "Ben", result);
//    }
//
//    @Test
//    public void testSetter_setsEmail() throws NoSuchFieldException, IllegalAccessException {
//        //given
//        final User testUser = new User();
//
//        testUser.setEmail("Boterbloem@Oose.nl");
//        //when
//        final Field field = testUser.getClass().getDeclaredField("email");
//        field.setAccessible(true);
//
//        //then
//        assertEquals("Fields didn't match", "Boterbloem@Oose.nl", field.get(testUser));
//
//    }
//
//    @Test
//    public void testGetter_getsEmail() throws NoSuchFieldException, IllegalAccessException {
//        //given
//        final User testUser = new User();
//        final Field field = testUser.getClass().getDeclaredField("email");
//        field.setAccessible(true);
//        field.set(testUser, "Boterbloem@Oose.nl");
//
//        //when
//        final String result = testUser.getEmail();
//
//        //then
//        assertEquals("field wasn't retrieved properly", "Boterbloem@Oose.nl", result);
//    }
//
//    @Test
//    public void testSetter_setsPhonenumber() throws NoSuchFieldException, IllegalAccessException {
//        //given
//        final User testUser = new User();
//
//        testUser.setPhoneNumber("0615285745");
//        //when
//        final Field field = testUser.getClass().getDeclaredField("phoneNumber");
//        field.setAccessible(true);
//
//        //then
//        assertEquals("Fields didn't match", "0615285745", field.get(testUser));
//
//    }
//
//    @Test
//    public void testGetter_getsPhonenumber() throws NoSuchFieldException, IllegalAccessException {
//        //given
//        final User testUser = new User();
//        final Field field = testUser.getClass().getDeclaredField("phoneNumber");
//        field.setAccessible(true);
//        field.set(testUser, "0615285745");
//
//        //when
//        final String result = testUser.getPhoneNumber();
//
//        //then
//        assertEquals("field wasn't retrieved properly", "0615285745", result);
//    }
//
//    @Test
//    public void testSetter_setsStreet() throws NoSuchFieldException, IllegalAccessException {
//        //given
//        final User testUser = new User();
//
//        testUser.setStreet("Laan van gelre");
//        //when
//        final Field field = testUser.getClass().getDeclaredField("street");
//        field.setAccessible(true);
//
//        //then
//        assertEquals("Fields didn't match", "Laan van gelre", field.get(testUser));
//
//    }
//
//    @Test
//    public void testGetter_getsStreet() throws NoSuchFieldException, IllegalAccessException {
//        //given
//        final User testUser = new User();
//        final Field field = testUser.getClass().getDeclaredField("street");
//        field.setAccessible(true);
//        field.set(testUser, "Laan van gelre");
//
//        //when
//        final String result = testUser.getStreet();
//
//        //then
//        assertEquals("field wasn't retrieved properly", "Laan van gelre", result);
//    }
//
//    @Test
//    public void testSetter_setsHousenumber() throws NoSuchFieldException, IllegalAccessException {
//        //given
//        final User testUser = new User();
//
//        testUser.setHouseNumber(5);
//        //when
//        final Field field = testUser.getClass().getDeclaredField("houseNumber");
//        field.setAccessible(true);
//
//        //then
//        assertEquals("Fields didn't match", 5, field.get(testUser));
//
//    }
//
//    @Test
//    public void testGetter_getsHousenumber() throws NoSuchFieldException, IllegalAccessException {
//        //given
//        final User testUser = new User();
//        final Field field = testUser.getClass().getDeclaredField("houseNumber");
//        field.setAccessible(true);
//        field.set(testUser, 5);
//
//        //when
//        final int result = testUser.getHouseNumber();
//
//        //then
//        assertEquals("field wasn't retrieved properly", 5, result);
//    }
//
//    @Test
//    public void testSetter_setsZipcode() throws NoSuchFieldException, IllegalAccessException {
//        //given
//        final User testUser = new User();
//
//        testUser.setZipCode(5786);
//        //when
//        final Field field = testUser.getClass().getDeclaredField("zipCode");
//        field.setAccessible(true);
//
//        //then
//        assertEquals("Fields didn't match", 5786, field.get(testUser));
//
//    }
//
//    @Test
//    public void testGetter_getsZipcode() throws NoSuchFieldException, IllegalAccessException {
//        //given
//        final User testUser = new User();
//        final Field field = testUser.getClass().getDeclaredField("zipCode");
//        field.setAccessible(true);
//        field.set(testUser, 5786);
//
//        //when
//        final int result = testUser.getZipCode();
//
//        //then
//        assertEquals("field wasn't retrieved properly", 5786, result);
//    }
//
//    @Test
//    public void testSetter_setsResidence() throws NoSuchFieldException, IllegalAccessException {
//        //given
//        final User testUser = new User();
//
//        testUser.setResidence("home");
//        //when1
//        final Field field = testUser.getClass().getDeclaredField("residence");
//        field.setAccessible(true);
//
//        //then
//        assertEquals("Fields didn't match", "home", field.get(testUser));
//
//    }
//
//    @Test
//    public void testGetter_getsResidence() throws NoSuchFieldException, IllegalAccessException {
//        //given
//        final User testUser = new User();
//        final Field field = testUser.getClass().getDeclaredField("residence");
//        field.setAccessible(true);
//        field.set(testUser, "home");
//
//        //when
//        final String result = testUser.getResidence();
//
//        //then
//        assertEquals("field wasn't retrieved properly", "home", result);
//    }
//
//    @Test
//    public void testSetter_setsPassword() throws NoSuchFieldException, IllegalAccessException {
//        //given
//        final User testUser = new User();
//
//        testUser.setPassword("Admin123");
//        //when
//        final Field field = testUser.getClass().getDeclaredField("password");
//        field.setAccessible(true);
//
//        //then
//        assertEquals("Fields didn't match", "Admin123", field.get(testUser));
//
//    }
//
//    @Test
//    public void testGetter_getsPassword() throws NoSuchFieldException, IllegalAccessException {
//        //given
//        final User testUser = new User();
//        final Field field = testUser.getClass().getDeclaredField("password");
//        field.setAccessible(true);
//        field.set(testUser, "Admin123");
//
//        //when
//        final String result = testUser.getPassword();
//
//        //then
//        assertEquals("field wasn't retrieved properly", "Admin123", result);
//    }
//
//    @Test
//    public void testSetter_setsPasswordsalt() throws NoSuchFieldException, IllegalAccessException {
//        //given
//        final User testUser = new User();
//
//        testUser.setPasswordSalt("asdwefg");
//        //when
//        final Field field = testUser.getClass().getDeclaredField("passwordSalt");
//        field.setAccessible(true);
//
//        //then
//        assertEquals("Fields didn't match", "asdwefg", field.get(testUser));
//
//    }
//
//    @Test
//    public void testGetter_getsPasswordsalt() throws NoSuchFieldException, IllegalAccessException {
//        //given
//        final User testUser = new User();
//        final Field field = testUser.getClass().getDeclaredField("passwordSalt");
//        field.setAccessible(true);
//        field.set(testUser, "asdwefg");
//
//        //when
//        final String result = testUser.getPasswordSalt();
//
//        //then
//        assertEquals("field wasn't retrieved properly", "asdwefg", result);
//    }
//
//    @Test
//    public void testSetter_setsDate() throws NoSuchFieldException, IllegalAccessException {
//        //given
//        final User testUser = new User();
//        final Date date = new Date(2018, 4, 26);
//
//        testUser.setDateOfBirth(date);
//        //when
//        final Field field = testUser.getClass().getDeclaredField("dateOfBirth");
//        field.setAccessible(true);
//
//        //then
//        assertEquals("Fields didn't match", field.get(testUser), date);
//
//    }
//
//    @Test
//    public void testGetter_getsDate() throws NoSuchFieldException, IllegalAccessException {
//        //given
//        final User testUser = new User();
//        final Date date = new Date(2018, 4, 26);
//        final Field field = testUser.getClass().getDeclaredField("dateOfBirth");
//        field.setAccessible(true);
//        field.set(testUser, date);
//
//        //when
//        final Date result = testUser.getDateOfBirth();
//
//        //then
//        assertEquals("field wasn't retrieved properly", result, date);
//    }
//
//    @Test
//    public void testSetter_setsFirstTimeProfileCheck() throws NoSuchFieldException, IllegalAccessException {
//        //given
//        final User testUser = new User();
//
//        testUser.setFirstTimeProfileCheck(true);
//        //when
//        final Field field = testUser.getClass().getDeclaredField("firstTimeProfileCheck");
//        field.setAccessible(true);
//
//        //then
//        assertEquals("Fields didn't match", true, field.get(testUser));
//
//    }
//
//    @Test
//    public void testGetter_getsFirstTimeProfileCheck() throws NoSuchFieldException, IllegalAccessException {
//        //given
//        final User testUser = new User();
//        final Field field = testUser.getClass().getDeclaredField("firstTimeProfileCheck");
//        field.setAccessible(true);
//        field.set(testUser, true);
//
//        //when
//        final Boolean result = testUser.isFirstTimeProfileCheck();
//
//        //then
//        assertEquals("field wasn't retrieved properly", true, result);
//    }
//}
