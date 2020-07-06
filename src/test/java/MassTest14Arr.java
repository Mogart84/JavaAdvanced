import lesson6prof.Array14Class;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

//Проверка присутствия в массиве только цифр 1 и 4
@RunWith(Parameterized.class)
public class MassTest14Arr {
    private int[] arr;
    private boolean result;
    Array14Class arr14;

    public MassTest14Arr(int[] arr, boolean result) {
        this.arr = arr;
        this.result = result;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 4, 1}, true},
                {new int[]{1, 1, 4, 4}, true},
                {new int[]{1, 4, 1, 8}, false},
                {new int[]{4, 4, 4, 4, 4}, false},
                {new int[]{1, 1, 1}, false}
        });
    }

    @Before
    public void init() {
        arr14 = new Array14Class();
    }

    @Test
    public void testArray1or4() {
        Assert.assertEquals(arr14.is1or4(arr), result);
    }
}
