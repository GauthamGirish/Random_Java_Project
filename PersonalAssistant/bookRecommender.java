import java.io.*;
class bookRecommender
{
    public static void recommender()throws IOException
    //to give the user a book recommendation
    {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        boolean repeat=true;
        int loc=0,age=0, cat=0, option=0;
        System.out.println("Welcome to your book recommender! Help yourself to an amazing collections books!");
        loc=Integer.parseInt(data.read("userLocation"));
        age=ageFinder.categorizer();
        cat=display.category();        
        display.books(age,loc,cat);
        System.out.println("\n\n");
        do
        {
            repeat=true;
            System.out.println("Do you want to:\n1. Find books in another age group\n2. Find books at other locations\n3. Find books in another category\n4. Exit from book recommender");
            option=entry.take();
            System.out.println();
            switch(option)
            {
                case 1:
                    age=display.age();
                    display.books(age,loc,cat);
                break;
                case 2:
                    loc=display.location();
                    display.books(age,loc,cat);       
                break;
                case 3:
                    cat=display.category();
                    display.books(age,loc,cat);
                break;
                case 4:
                    repeat=false;
                break;
                default:
                    System.out.println("Invalid choice");
            }
         System.out.println("\n\n");
        }while(repeat);     //to keep repeating until the user decides to exit
    }
}    