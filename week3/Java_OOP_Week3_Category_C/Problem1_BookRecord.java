class Book {
    String title;
    double price;
}

public class Problem1_BookRecord {
    public static void main(String[] args) {
        Book book = new Book();

        book.title = "Clean Code";
        book.price = 650.0;

        System.out.println("Title: " + book.title + " | Price: Rs " + book.price);
    }
}
