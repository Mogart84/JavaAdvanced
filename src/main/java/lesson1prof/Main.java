package lesson1prof;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        // Прогон метода, меняющего местами элементы массива
        Integer[] arrTestSwap = {1,2,3,4};
        System.out.print("Исходный массив: ");
        for (int i = 0; i < arrTestSwap.length; i++) {
            System.out.print(arrTestSwap[i]+" ");
        }
        System.out.println();

        arraySwap(1,3,arrTestSwap);
        System.out.print("Преобразованный массив: ");
        for (int i = 0; i < arrTestSwap.length; i++) {
            System.out.print(arrTestSwap[i]+" ");
        }
        System.out.println();

        // Прогон метода преобразования массива в ArrayList
        String[] arrTest1 = {"A","B","C"};
        Integer[] arrTest2 = {1,2,3};
        System.out.println(arrayToList(arrTest1));
        System.out.println(arrayToList(arrTest2));

        // Тестирование работы с классами Box, Fruit

        Box box1 = new Box(); //Будем засыпать Apple
        Box box2 = new Box(); //Будем засыпать Orange
        Box box3 = new Box(); //Оставляем пустой

        Apple apple = new Apple();
        Orange orange = new Orange();

        box1.addFruit(apple);
        box1.addFruit(apple);
        box1.addFruit(apple);

        box2.addFruit(orange);

        // Пытаемся разместить Apple в коробку 2
        box2.addFruit(apple);

        System.out.println("Вес коробки 1: " + box1.getWeight());
        System.out.println("Весь коробки 2: " + box2.getWeight());

        System.out.println("Сравнение коробок 1 и 2: " + box1.compare(box2));

        //Пересыпаем из коробки 1 в 3
        box1.emptyBox(box3);
        System.out.println(box1.getWeight());
        System.out.println(box3.getWeight());

    }

    // Метод, меняющий местами элементы с индексами i, j
    public static <T> void arraySwap(int i, int j, T[] arr) {
        try {
            T first = arr[i];
            arr[i] = arr[j];
            arr[j] = first;
        }
        catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    // Метод, преобразующий массив в ArrayList
    public static <T> ArrayList<T> arrayToList(T[] arr) {
        List<T> arrList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            arrList.add(arr[i]);
        }
        return (ArrayList<T>) arrList;
    }

}
