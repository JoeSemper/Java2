package hw3;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class PhoneBook {

    private static HashMap<String, List<String>> map = new HashMap<>();
    private static List<String> list;


    public static void add(String name, String... number) {

        list = map.getOrDefault(name, new LinkedList<String>());

        for (int i = 0; i <number.length ; i++) {
            list.add(number[i]);
        }

        map.put(name, list);
    }

    public static List<String> get(String name) {
        return map.get(name);
    }

}
