import lesson6prof.Array4Class;
import org.junit.BeforeClass;
import org.junit.Test;

//Проверка генерирования RuntimeException из задачи 1
public class TestExcept4Arr {
    private static Array4Class arr;

    @BeforeClass
    public static void init(){
        arr = new Array4Class();
    }

    @Test(expected = RuntimeException.class)
    public void testNoFour1() {
        arr.subArray(new int[]{0, 1, 2});
    }

    @Test(expected = RuntimeException.class)
    public void testNoFour2() {
        arr.subArray(new int[]{1, 5, 8, 11, 24});
    }

}
