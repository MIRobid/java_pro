import java.lang.reflect.Method;

public class testClass {
    @BeforeSuite(priority = 10)
    public static void start(Class testClass){
        System.out.println("...");
    }

    @Test(priority = 5)
    public static void test(){
        System.out.println("testing");
    }

    @AfterSuite(priority = 1)
    public static void after(){
        System.out.println("ending");
    }

    public static void main(String[] args) {
        try {
            Method m1=testClass.class.getMethod("start", Class.class);
            BeforeSuite before=m1.getAnnotation(BeforeSuite.class);
            System.out.println(before);

            Method m2=testClass.class.getMethod("test");
            Test test=m2.getAnnotation(Test.class);
            System.out.println(test);

            Method m3=testClass.class.getMethod("after");
            AfterSuite after=m3.getAnnotation(AfterSuite.class);
            System.out.println(after);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }


    }
}


