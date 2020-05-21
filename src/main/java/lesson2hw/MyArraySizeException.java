package lesson2hw;

public class MyArraySizeException extends Exception {

    private String msg;

    public MyArraySizeException(String message) {
        super(message);
        this.msg = message;
    }

    public void printMessage() {
        System.out.println(msg);
    }

}
