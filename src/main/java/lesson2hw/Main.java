package lesson2hw;

import static java.lang.Integer.*;
import static java.lang.Integer.parseInt;

public class Main {

    public static void main(String[] args) {

        String[][] arrNoError = {{"1","2","3","4"},{"5","6","7","8"},{"9","10","11","12"},{"13","14","15","16"}};
        String[][] arrSizeError = {{"1","2"}, {"5","6"}, {"9","10"}, {"13","14"}};
        String[][] arrDataError = {{"1","2","3","NotNumber"},{"5","6","7","8"},{"9","10","11","12"},{"13","14","15","16"}};

        try {
            System.out.println("Cумма элементов массива: " + sumArray(arrNoError));
            // System.out.println("Cумма элементов массива: " + sumArray(arrSizeError));
            System.out.println("Cумма элементов массива: " + sumArray(arrDataError));
        }
        catch (MyArraySizeException sExc) {
            sExc.printMessage();
        }
        catch (MyArrayDataException dExc) {
            dExc.printMessage();
            System.out.println("Ошибка типа данных в элементе с индексами i: " + dExc.getI() + ", j: " + dExc.getJ());
        }
    }

    static int sumArray(String[][] arr) throws MyArraySizeException, MyArrayDataException {

        int sum = 0;
        int iDim = arr[0].length;
        int jDim = arr[1].length;

        if ((iDim != 4) || (jDim != 4)) throw new MyArraySizeException("Неверный размер массива!");

        for (int i = 0; i < iDim; i++) {
            for (int j = 0; j < jDim; j++) {

                try {
                    sum += parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Неверный формат элемента!", i, j);
                }
            }
         }
        return sum;
    }
}
