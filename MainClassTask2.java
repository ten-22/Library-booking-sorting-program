
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MainClassTask2 {

        // creating object of the books from sortedArray List 
    	static SortedArrayList<Book> books = new SortedArrayList<Book>();   
	// creating object of the users from sortedArray List 
    	static SortedArrayList<User> users = new SortedArrayList<User>();   
	
    public static void menuDriven(){
    
        String menu = "f - to finish\n"
                    + "b - to display books\n"
                    + "u - to display users\n"
                    + "i - to update book when book issue\n"
                    + "r - to update user when book return\n";
        
        System.out.println(menu);
        
    }
    public static void readFile(String fileName) throws FileNotFoundException{
    
        File file = new File(fileName);
            
            Scanner scanFile = new Scanner(file);
            StringBuffer Records = new StringBuffer();
            int index =0;
            
            while(scanFile.hasNextLine()){
         
                Records.append(scanFile.nextLine()+"\n");
            index+=1;
            if(index ==7 ){
            
                Records.append("splits\n");
               index=0;
            }
            
            }
            
            
            
            String seperateRecord[] = Records.toString().split("splits");
            for(int j =0; j<seperateRecord.length-1; j++){
              
           String SingleRecord[] = seperateRecord[j].split("\n");
            List<String> list = new ArrayList<String>(Arrays.asList(SingleRecord));
           if(list.get(0).length()<1){
           
               list.remove(0);
           }
           
          
            int numberOfBooks = Integer.parseInt(list.get(0)); 
            String title = list.get(1);
            String Author = list.get(2);
         
            Book book = new Book(numberOfBooks, title, Author, "Available");
            books.add(book);
            
            for(int i = 3; i<SingleRecord.length-1; i++){
            
              String User[] = list.get(i).split(" ");
              String firstName = User[0];
              String lastName =User[1];
              
              User user = new User(firstName, lastName, 0);
              users.add(user);
            }
            }
            
          

        
    }
      static void writeFile(String filename) throws IOException{
            
          File file = new File(filename);
          file.createNewFile();
                    FileWriter writer = new FileWriter(file);
                    
                    writer.append("List of Books\n");
                    for(Book b : books){
                    
                        writer.append(b.toString()+"\n");
                    }
                    
                    writer.append("List of users\n");
                   for(User u : users){
                    
                        writer.append(u.toString()+"\n");
                    }
                   
                   writer.close();
            }
    
    
    public static void main(String[] args) {
        
                try {
                    
                    Scanner input = new Scanner(System.in);
                    
                    //call read file method with file name
                    readFile("library.txt");
                    
                    while(true){
                        
                        // call menu driven method into the loop
                        menuDriven();
                        System.out.print("Please Select a option : ");
                        String select = input.nextLine();
                        
                        if(select.equals("f")){
                            System.out.println("Thank you for using the system.");
                            //create output file
                            writeFile("output.txt");
                            //stop program
                            System.exit(0);
                            
                        }else if(select.equals("b")){
                            
                            for(Book b : books){
                            
                         
                                System.out.println(b.toString());
                            }
                            
                        }else if(select.equals("u")){
                            
                            for(User u : users){
                            
                         
                                System.out.println(u.toString());
                            }
                            
                        }else if(select.equals("i")){
                             int index =1;
                            for(Book b : books){
                            
                         
                                System.out.println(index+ ": "+b.toString());
                                index+=1;
                            }
                            System.out.println("Select Book for issue");
                            int selectBook = input.nextInt();
                          
                            
                            
                               int indexu =1;
                            for(User u : users){
                            
                         
                                System.out.println(indexu+ ": "+u.toString());
                                indexu+=1;
                            }
                          
                            
                             System.out.println("Select User To issue");
                            int selectUser = input.nextInt();
                            
                             if(books.size() > selectBook-1 && users.size() > selectUser-1 ){
                           
                                    int numberOfBook =  books.get(selectBook-1).getNumber_Of_Book();
                                    if(numberOfBook>0){
                                    books.get(selectBook-1).setNumber_Of_Book(numberOfBook-1);
                                    int BooksHold = users.get(selectUser-1).getNumber_of_books_hold();
                                    users.get(selectUser-1).setNumber_of_books_hold(BooksHold+1);
                                    
                                     System.out.println(books.get(selectBook-1).toString());
                                     System.out.println(users.get(selectUser-1).toString());
                                     
                                     System.out.println("Book Issued");
                                    }else{
                                    
                                        System.out.println("Sorry Book Not Available");
                                         books.get(selectBook-1).setBook_status("Not Available");
                                        
                                    }
                             }else{
                             
                                 System.out.println("Please Select Appropriate Books or user");
                             }
                           
                        }else if(select.equals("r")){
                           
                                int indexu =1;
                            for(User u : users){
                            
                                if(u.getNumber_of_books_hold()>0){
                                System.out.println(indexu+ ": "+u.toString());
                                indexu+=1;
                                }
                            }
                          
                            
                             System.out.println("Select User who returning book");
                            int selectUser = input.nextInt();
                          
                            
                              int index =1;
                            for(Book b : books){
                            
                                System.out.println(index+ ": "+b.toString());
                                index+=1;
                            }
                            System.out.println("Select Book for returning");
                            int selectBook = input.nextInt();
                          
                          if(books.size() > selectBook-1 && users.size() > selectUser-1 ){
                           
                           // creating object of the users from sortedArray List 
                            SortedArrayList<User> usersissuer = new SortedArrayList<User>();   
	      
                            for(User u : users){
                            
                                if(u.getNumber_of_books_hold()>0){
                             
                                    usersissuer.add(u);
                                }
                            }
                             
                            
                                    int numberOfBook =  books.get(selectBook-1).getNumber_Of_Book();
                                    books.get(selectBook-1).setNumber_Of_Book(numberOfBook+1);
                                    int BooksHold = usersissuer.get(selectUser-1).getNumber_of_books_hold();
                                    usersissuer.get(selectUser-1).setNumber_of_books_hold(BooksHold-1);
                                    books.get(selectBook-1).setBook_status("Avialable");
                                    
                                    
                                     System.out.println(books.get(selectBook-1).toString());
                                     System.out.println(usersissuer.get(selectUser-1).toString());
                                     
                                     System.out.println("Book Returned");
                                    
                             }else{
                             
                                 System.out.println("Please Select Appropriate Books or user");
                             }
                           
                            
                        }else{
                            
                            System.out.println("Please Select Correct Option : ");
                        }
                        
                    }       } catch (Exception ex) {
              
                            ex.printStackTrace();
                        
                    }
    }
    
}
