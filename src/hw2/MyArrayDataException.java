package hw2;

public class MyArrayDataException extends NumberFormatException {

    private int i;
    private int j;
    private String data;

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    public String getData() {
        return data;
    }

    public MyArrayDataException (String massage, String data, int i, int j) {
        super(massage);
        this.i = i+1;
        this.j = j+1;
        this.data = data;
    }

    public MyArrayDataException (String massage) {
        super(massage);
    }


}
