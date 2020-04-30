import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

class UserTest {

    private static ArrayList<User> userList = new ArrayList<>();

    private static User findOne(ArrayList<User> array, String email) {
        Iterator<User> it = array.iterator();
        while (it.hasNext()) {
            User temp = it.next();
            if (temp.getEmail().equals(email)) {
                return temp;
            }
        }
        return null;
    }

    @BeforeAll
    static void addData() {
        User user1 = new User("john@gmail.com", "John");
        User user2 = new User("ana@gmail.com", "Ana");
        userList.add(user1);
        userList.add(user2);
        System.out.println("John and Anna Added.");
    }

    @AfterAll
    static void removeData() {
        userList.removeAll(userList);
        System.out.println(userList.size());
        System.out.println("userList deleted.");
    }

    @Test
    @DisplayName("Test Size of Users")
    void testSizeOfUsers() {
        assertEquals(2, userList.size());
    }


    @Test
    void testGetUser() {
        User user = findOne(userList, "john@gmail.com");

        assertNotNull(user);
        assertEquals("John", user.getName(),
                "User name:" + user.getName() + " incorrect");
    }


    @Test
    void testClassicAssertions() {
        User user1 = findOne(userList, "john@gmail.com");
        User user2 = findOne(userList, "john@yahoo.com");

        assertNotNull(user1);
        assertNull(user2);

        user2 = new User("john@yahoo.com", "John");
        assertEquals(user1.getName(), user2.getName(), "Names are not equal");
        assertFalse(user1.getEmail().equals(user2.getEmail()), "Emails are equal");
        assertNotSame(user1, user2);
    }


    @Test
    void testGetUsers() {
        User user = findOne(userList, "john@gmail.com");

        assertAll("user",
                () -> assertEquals("Johnson", user.getName()),
                () -> assertEquals("johnson@gmail.com", user.getEmail()));
    }

    @Test
    void testIterableEquals() {
        User user1 = new User("john@gmail.com", "John");
        User user2 = new User("ana@gmail.com", "Ana");

        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);

        assertIterableEquals(users, userList);
    }

    @Test
    void testLinesMatch() {
        List<String> expectedLines = Collections.singletonList("(.*)@(.*)");
        List<String> emails = Arrays.asList("john@gmail.com");
        assertLinesMatch(expectedLines, emails);
    }

    @Test
    void testThrows() {
        User user = null;
        Exception exception = assertThrows(NullPointerException.class, () -> user.getName());
        System.out.println(exception.getMessage());
    }

    @Test
    void testFail() {
        fail("this test fails");
    }


    @Test
    void testAssumptions() {
        List<User> users = userList;
        assumeFalse(users == null);
        assumeTrue(users.size() > 0);

        User user1 = new User("john@gmail.com", "John");
        assumingThat(users.contains(user1), () -> assertTrue(users.size() > 1));
    }


    @Nested
    class DeleteUsersTest {
        @Test
        void addUser() {
            User user = new User("bob@gmail.com", "Bob");
            userList.add(user);
            assertNotNull(findOne(userList, "bob@gmail.com"));

            userList.remove(findOne(userList,"bob@gmail.com"));
            assertNull(findOne(userList,"bob@gmail.com"));
        }
    }

    @RepeatedTest(3)
    void testForThreeTimes() {
        assertTrue(1 == 1);
        System.out.println("Repeated Test");
    }

    @Test
    @DisplayName("Test Get Users")
    public void testGetUsersNumberWithInfo(TestInfo testInfo) {
        assertEquals(2, userList.size());
        assertEquals("Test Get Users", testInfo.getDisplayName());
        assertEquals(UserTest.class, testInfo.getTestClass().get());

        System.out.println("Running test method:" + testInfo.getTestMethod().get().getName());
    }

}
