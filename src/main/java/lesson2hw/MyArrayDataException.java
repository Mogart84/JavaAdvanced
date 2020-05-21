package lesson2hw;

public class MyArrayDataException extends Exception {

    private String msg;
    private int iExc;
    private int jExc;

    public MyArrayDataException(String message, int i, int j) {
        super(message);
        this.iExc = i;
        this.jExc = j;
        this.msg = message;
    }

    public int getI() { return iExc; }

    public int getJ() { return jExc; }

    public void printMessage() {
        System.out.println(msg);
    }

}
