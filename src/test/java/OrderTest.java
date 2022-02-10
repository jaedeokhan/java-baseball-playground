import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderTest {

    @BeforeEach
    public void setup() {
        System.out.println("setup");
    }

    @Test
    public void test1() throws Exception {
        System.out.println("test1");
    }

    @Test
    public void test2() throws Exception {
        System.out.println("test2");
    }

    @AfterEach
    public void teardown() {
        System.out.println("teardown");
    }

    // 위를 실행하면 예상 결과는
    // setup
    // test1
    // teardown

    // setup
    // test2
    // teardown
}
