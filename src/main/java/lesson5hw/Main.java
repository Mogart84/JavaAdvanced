package lesson5hw;

public class Main {

    static final int SIZE = 10000000;
    static final int HALF = SIZE / 2;
    static float[] arr = new float[SIZE];

    public static void main(String[] args) {
        func1();
        func2();
    }

    public static void populateArr(float[] inputArr, int sizeArr) {
        for (int i = 0; i < sizeArr ; i++) {
            inputArr[i] = (float) 1.0;
        }
    }

    public static void func1() {
        populateArr(arr,SIZE);
        long a = System.currentTimeMillis();
        calcArray(arr);
        System.out.println("Время выполнения метода 1: " + (System.currentTimeMillis() - a));
    }

    public static void func2() {
        populateArr(arr,SIZE);
        float[] a1 = new float[HALF];
        float[] a2 = new float[HALF];

        long a = System.currentTimeMillis();

        System.arraycopy(arr, 0, a1, 0, HALF);
        System.arraycopy(arr, HALF, a2, 0, HALF);

        Thread t1 = new Thread(() -> calcArray(a1));
        Thread t2 = new Thread(() -> calcArray(a2));
        t1.run();
        t2.run();

        System.arraycopy(a1, 0, arr, 0, HALF);
        System.arraycopy(a2, 0, arr, HALF, HALF);

//        System.out.println(a2[1000]);
        System.out.println("Время выполнения метода 2: " + (System.currentTimeMillis() - a));
    }

    public static void calcArray(float[] inputArr) {
        for (int i = 0; i < inputArr.length; i++) {
            inputArr[i] = (float)(inputArr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }

}
