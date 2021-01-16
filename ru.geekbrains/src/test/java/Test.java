import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;


public class Test {
    private ArrTest arrTest;
    private OneFour oneFour;

    @BeforeEach
    public void init() {
        arrTest = new ArrTest();
        oneFour=new OneFour();
    }

    @Test
    public void test1() {
        int[] testArr1= {0,1,2,3,4,5};
        oneFour.OneFour(testArr1);
        int[] testShortArr1= {5};
        Assertions.assertEquals(testShortArr1, arrTest.arrTest(testArr1));
    }

    @Test
    public void test2() {
        int[] testArr2= {11,5,3,4,4,0};
        oneFour.OneFour(testArr2);
        int[] testShortArr2= {0};
        Assertions.assertEquals(testShortArr2, arrTest.arrTest(testArr2));
    }

    @Test
    public void test3() {
        int[] testArr3= {-4,3,100,0,1,2};
        oneFour.OneFour(testArr3);
        int[] testShortArr3= {};
        Assertions.assertEquals(testShortArr3, arrTest.arrTest(testArr3));
    }

    }