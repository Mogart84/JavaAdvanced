import lesson6prof.Array4Class;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;

//Проверка формирования под-массива из задачи 1
@RunWith(Parameterized.class)
public class MassTest4Arr {
    private int[] arr;
    private int[] arrResult;
    private boolean b;
    Array4Class arrFour;

    public MassTest4Arr(int[] arr, int[] arrResult) {
        this.arr = arr;
        this.arrResult = arrResult;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 4, 6}, new int[]{6}},
                {new int[]{1, 4, 6, 5}, new int[]{6, 5}},
                {new int[]{1, 4, 6, 5}, new int[]{6, 5}},
                {new int[]{4, 0, 6, 9, 6}, new int[]{0, 6, 9, 6}},
                {new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7}, new int[]{1, 7}}
        });
    }

    @Before
    public void init() {
        arrFour = new Array4Class();
    }

    @Test
    public void testAdd() {
        Assert.assertArrayEquals(arrFour.subArray(arr), arrResult);
    }

}