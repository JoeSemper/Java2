package hw3;

public class Main {

    public static void main(String[] args) {

        String[] arr = new String[] {"melon", "apple", "garlic", "orange", "lemon", "banana", "apricot", "avocado",
                "broccoli", "carrot", "melon", "cherry", "garlic", "carrot", "grape", "melon", "leak", "orange", "apricot"};

        MyArray a = new MyArray(arr);

        a.printUnique();

        a.countWords();


        System.out.println();

        PhoneBook book = new PhoneBook();

        book.add("Sam", "5-35-04");
        book.add("Bob", "5-17-18");
        book.add("Bob", "5-48-42");
        book.add("Joe", "5-05-38", "5-76-02", "5-13-46");
        book.add("Dan", "5-03-78");
        book.add("Adam", "5-26-56", "5-35-21");

        System.out.println(book.get("Sam"));
        System.out.println(book.get("Bob"));
        System.out.println(book.get("Joe"));
    }
}
