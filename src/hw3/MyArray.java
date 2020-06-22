package hw3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class MyArray {

    private static String[] arr;

    public MyArray(String[] arr) {
        this.arr = arr;
    }

    public static void printUnique () {

        HashSet<String> set = new HashSet<>(Arrays.asList(arr));

        System.out.println(set);

    }

    public static void countWords () {

        HashMap<String, Integer> map = new HashMap();

        for (int i = 0; i < arr.length ; i++) {

            Integer value = map.getOrDefault(arr[i], 0);
            map.put(arr[i], value + 1);
        }

        System.out.println(map);

    }

}
