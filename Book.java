
public class Book {
    
    private int number_Of_Book;
    private String Title;
    private String Authors_name;
    private String Book_status;

    public Book(int number_of_books,String Title, String Authors_name, String Book_status) {
        this.number_Of_Book = number_of_books;
        this.Title = Title;
        this.Authors_name = Authors_name;
        this.Book_status = Book_status;
    }

    public int getNumber_Of_Book() {
        return number_Of_Book;
    }
    
    
    public String getTitle() {
        return Title;
    }

    public String getAuthors_name() {
        return Authors_name;
    }

    public String getBook_status() {
        return Book_status;
    }

    public void setBook_status(String Book_status) {
        this.Book_status = Book_status;
    }

    public void setNumber_Of_Book(int number_Of_Book) {
        this.number_Of_Book = number_Of_Book;
    }

    @Override
    public String toString() {
        return "Book {" + "number_Of_Book = " + number_Of_Book + ", Title = " + Title + ", Authors_name = " 
                + Authors_name + ", Book_status = " + Book_status + '}';
    }
    

    
}
