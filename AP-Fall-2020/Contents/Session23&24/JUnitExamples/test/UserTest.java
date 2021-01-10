import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

class UserTest {
    private static ChatRoom chatRoom;

    @BeforeAll
    static void addData() {
        User user1 = new User("john@gmail.com", "John");
        User user2 = new User("ana@gmail.com", "Ana");
        chatRoom = new ChatRoom();
        chatRoom.getUserList().add(user1);
        chatRoom.getUserList().add(user2);
        System.out.println("John and Anna Added.");
    }

    @AfterAll
    static void removeData() {
        chatRoom.getUserList().removeAll(chatRoom.getUserList());
        System.out.println(chatRoom.getUserList().size());
        System.out.println("chatRoom.getUserList() deleted.");
    }

    @Test
    @DisplayName("Test Size of Users")
    void testSizeOfUsers() {
        assertEquals(2, chatRoom.getUserList().size());
    }


    @Test
    void testGetUser() {
        User user = chatRoom.findOne("john@gmail.com");

        assertNotNull(user);
        assertEquals("John", user.getName(),
                "User name:" + user.getName() + " incorrect");
    }


    @Test
    void testClassicAssertions() {
        User user1 = chatRoom.findOne("john@gmail.com");
        User user2 = chatRoom.findOne("john@yahoo.com");

        assertNotNull(user1);
        assertNull(user2);

        user2 = new User("john@yahoo.com", "John");
        assertEquals(user1.getName(), user2.getName(), "Names are not equal");
        assertFalse(user1.getEmail().equals(user2.getEmail()), "Emails are equal");
        assertNotSame(user1, user2);
    }


    @Test
    void testGetUsers() {
        User user = chatRoom.findOne("john@gmail.com");

        assertAll("user",
                () -> assertEquals("Johnson", user.getName()),
                () -> assertEquals("johnson@gmail.com", user.getEmail()));
    }

    @Test
    void testIterableEquals() {
        //User user1 = new User("john@gmail.com", "John");
        User user1 = chatRoom.findOne("john@gmail.com");
        User user2 = new User("ana@gmail.com", "Ana");

        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);

        assertIterableEquals(users, chatRoom.getUserList());
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
        List<User> users = chatRoom.getUserList();
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
            chatRoom.getUserList().add(user);
            assertNotNull(chatRoom.findOne("bob@gmail.com"));

            chatRoom.getUserList().remove(chatRoom.findOne("bob@gmail.com"));
            assertNull(chatRoom.findOne("bob@gmail.com"));
        }
    }

    @RepeatedTest(3)
    void testForThreeTimes() {
        assertTrue(1 == 2);
        System.out.println("Repeated Test");
    }

    @Test
    @DisplayName("Test Get Users")
    public void testGetUsersNumberWithInfo(TestInfo testInfo) {
        assertEquals(2, chatRoom.getUserList().size());
        assertEquals("Test Get Users", testInfo.getDisplayName());
        assertEquals(UserTest.class, testInfo.getTestClass().get());

        System.out.println("Running test method:" + testInfo.getTestMethod().get().getName());
    }

}
