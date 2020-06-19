package hw2;

public class Main {

    private static String[][] arr;
    private static int arrLines = 4;
    private static int arrColumns = 4;

    public static void main (String[] args) {

        arr  = new String[][]{ {"1", "2", "3", "4"},
                               {"1", "2", "3", "4"},
                               {"d", "2", "3", "4"},
                               {"1", "2", "3", "4"} };

        try {
            System.out.println(arraySum(arr));
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        }



    }

    public static int arraySum (String[][] arr){

        int sum = 0;

        for (int i = 0; i < arr.length ; i++) {

            if (  (arr.length != arrLines) || (arr[i].length != arrColumns)) {
                throw new MyArraySizeException("Неверный размер массива");
            }

            for (int j = 0; j < arr[i].length; j++) {
                try {
                    sum += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e){
                    throw new MyArrayDataException("\"" + arr[i][j] + "\"" + "; Cтрока: " + (i+1) + ", Cтолбец: " + (j+1), arr[i][j], i, j);
                }
            }
        }

        return sum;
    }
}
