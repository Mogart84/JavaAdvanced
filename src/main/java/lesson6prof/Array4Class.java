package lesson6prof;

//Класс для задачи 1
public class Array4Class {

    public Array4Class() {
    }

    public int[] subArray(int[] arr) {

        int[] newArr = null;
        int iFour = -1;

        // Находим последнюю 4-ку в массиве
        for (int i = arr.length -1; i >= 0 ; i--) {
            if(arr[i] == 4) {
                iFour = i;
                break;
            }
        }

        System.out.println(iFour);

        if(!(iFour == -1)) {
            newArr = new int[arr.length-iFour-1];
            System.arraycopy(arr,iFour+1,newArr,0,arr.length-iFour-1);
        }
        else {
            throw new RuntimeException("В массиве нет числа 4!");
        }

        return newArr;
    }

}
