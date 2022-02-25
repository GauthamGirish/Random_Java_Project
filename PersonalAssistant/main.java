import java.io.*;
class main
{
    public static void main()throws IOException
    //this is the main file
    //here the file userCheck is used to ask the user information only the first time the program is run or after the user resets it
    {
        int choice=0,check=0,user=0;
        boolean repeat;
        check=Integer.parseInt(data.read("userCheck"));
        if(check==1)
        {
            userInfo.userName();
            System.out.println("\n\n");
            userInfo.userBirthday();
            System.out.println("\n\n");
            userInfo.userLocation();
            System.out.println("\n\n");
            check=2;
            String str=Integer.toString(check);
            data.write("userCheck",str);          
        }    
        
        System.out.println("Hey "+data.read("userName")+"! Welcome to your personal assistant!");
        ageFinder.happyBirthday();
        do
        {
            repeat=true;
            System.out.println("\n\n");
            System.out.println("What do you want to do?\n1. Use the calculator\n2. Get a book recommendation\n3. Take a quiz\n4. View and edit your books wishlist\n5. View and edit your to do list\n6. Edit user info\n7. Exit the program");
            choice=entry.take();
            System.out.println("\n\n");
            switch(choice)
            {
                case 1:
                    Calculator.cal();
                    System.out.println("\n\n");
                break;
                case 2:
                    bookRecommender.recommender();
                    System.out.println("\n\n");
                break;
                case 3:
                    quiz.quizChooser();
                    System.out.println("\n\n");
                break;
                case 4:
                    wishlist.editor();
                    System.out.println("\n\n");
                break;
                case 5:
                    toDoList.editor();
                    System.out.println("\n\n");
                break;
                case 6:
                    repeat=userInfo.edit();     //checking if the user has decided to reset user information and stop program if he has
                    System.out.println("\n\n");
                break;
                case 7:
                    System.out.println("\n\n");
                    System.out.println("See you soon! Bye");
                    repeat=false;
                break;
                default:
                    System.out.println("Invalid choice");
                    System.out.println("\n\n");
                break;
            }
        }while(repeat);     //to keep repeating till the user decides to exit
    }

    
    public static void wipe()
    //to reset all user information
    {
        String str="1";
        data.write("userCheck",str);
        data.write("wishFile",str);
        data.write("whichList",str);
        data.write("wishlist1","");
        data.write("toDoList1","");
        data.write("quiz",str);
    }
}