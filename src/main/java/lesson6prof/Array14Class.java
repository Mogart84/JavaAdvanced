package lesson6prof;

//Класс для задачи 2
public class Array14Class {

    public Array14Class() {
    }

    public boolean is1or4(int[] arr) {

        boolean is1 = false;
        boolean is4 = false;
        boolean isOther = false;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) is1 = true;
            if (arr[i] == 4) is4 = true;
            if (!(arr[i] == 1 || arr[i] == 4)) isOther = true;
        }

        if (is1 && is4 && !isOther) {
            return true;
        } else {
            return false;
        }

    }

}
