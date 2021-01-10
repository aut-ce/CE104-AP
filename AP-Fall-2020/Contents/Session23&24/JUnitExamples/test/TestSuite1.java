import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestSuite1 {

    @Test
    void test1() {
        assertEquals(2, 1 + 1);
        System.out.println("Test1 completed.");
    }

    @Test
    @DisplayName("Second One")
    void test2() {
        System.out.println("Test2 completed.");
    }

    @BeforeEach
    void testBeforeEach() {
        System.out.println("Before Each!");
    }


    @AfterEach
    void testAfterEach() {
        System.out.println("After Each!");
    }

    @BeforeAll
    static void testBeforeAll() {
        System.out.println("Before All!");
    }

    @AfterAll
    static void testAfterAll() {
        System.out.println("After All!");
    }
}
