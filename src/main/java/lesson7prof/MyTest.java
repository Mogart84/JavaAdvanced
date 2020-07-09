package lesson7prof;

public class MyTest {

    @BeforeSuite
    public static void testBefore(){
        System.out.println("Before testing...");
    }

    @Test(priority = 9)
    public static void test1(){
        System.out.println("test_1");
    }

    @Test(priority = 1)
    public static void test2(){
        System.out.println("test_2");
    }

    @Test(priority = 3)
    public static void test3(){
        System.out.println("test_3");
    }

    @Test(priority = 8)
    public static void test4(){ System.out.println("test_4"); }

    @Test(priority = 5)
    public static void test5(){
        System.out.println("test_5");
    }

    @Test(priority = 5)
    public static void test6(){
        System.out.println("test_6");
    }

    @AfterSuite
    public static void testAfter(){ System.out.println("After testing..."); }


}
