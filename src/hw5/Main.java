package hw5;

public class Main {

    static final int SIZE = 10000000;
    static final int HALF = SIZE / 2;

    private static float arr[] = new float[SIZE];

    public static void main(String[] args) {

        for (int i = 0; i <arr.length ; i++) {
            arr[i] = 1;
        }

        firstMethod(arr);
        secondMethod(arr);

    }

    public static void firstMethod (float arr[]){

        long a = System.currentTimeMillis();

        for (int i = 0; i <arr.length ; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        System.out.printf("Время первого метода: %d мс \n", System.currentTimeMillis() - a);
//        System.out.println(arr[arr.length-1]);
    }

    public static void secondMethod (float arr[]){
        float[] a1 = new float[HALF];
        float[] a2 = new float[HALF];

        Thread t1 = new Thread( ()-> {
            for (int i = 0; i <a1.length ; i++) {
                a1[i] = (float)(a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });

        Thread t2 = new Thread( ()-> {
            for (int i = 0; i <a2.length-1; i++) {
                a2[i] = (float)(a2[i] * Math.sin(0.2f + (i+HALF) / 5) * Math.cos(0.2f + (i+HALF) / 5) * Math.cos(0.4f + (i+HALF) / 2));
            }
        });

        long a = System.currentTimeMillis();

        System.arraycopy(arr, 0, a1, 0, HALF-1);
        System.arraycopy(arr, HALF, a2, 0, HALF-1);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(a1, 0, arr, 0, HALF-1);
        System.arraycopy(a2, 0, arr, HALF, HALF-1);

        System.out.printf("Время второго метода: %d мс \n", System.currentTimeMillis() - a);
//        System.out.println(arr[arr.length-1]);

    }
}
