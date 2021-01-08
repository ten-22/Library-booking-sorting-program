
public class User {

    private String Firstname;
    private String Sirname;
    private int Number_of_books_hold;

    public User(String Firstname, String Sirname, int Number_of_books_hold) {
        this.Firstname = Firstname;
        this.Sirname = Sirname;
        this.Number_of_books_hold = Number_of_books_hold;
    }

    public String getFirstname() {
        return Firstname;
    }

    public String getSirname() {
        return Sirname;
    }

    public int getNumber_of_books_hold() {
        return Number_of_books_hold;
    }

    public void setNumber_of_books_hold(int Number_of_books_hold) {
        this.Number_of_books_hold = Number_of_books_hold;
    }
    

    @Override
    public String toString() {
        return "User{" + "Firstname : " + Firstname + ", Sirname : " + Sirname + 
                ", Number_of_books_hold : " + Number_of_books_hold + '}';
    }
    
    
    
}
