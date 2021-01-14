import org.junit.jupiter.api.*;

public class TestSuite2 {
    @Test
    public void test1() {
        System.out.println("TestSuit2 Test1 completed.");
    }

    @Test
    @Disabled
    public void test2() {
        System.out.println("TestSuit2 Test2 completed.");
    }

    @BeforeEach
    public void testBeforeEach() {
        System.out.println("TestSuit2 Before Each!");
    }


    @AfterEach
    public void testAfterEach() {
        System.out.println("TestSuit2 After Each!");
    }

    @BeforeAll
    public static void testBeforeAll() {
        System.out.println("TestSuit2 Before All!");
    }


    @AfterAll
    public static void testAfterAll() {
        System.out.println("TestSuit2 After All!");
    }
}
