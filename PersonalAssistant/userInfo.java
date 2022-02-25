import java.io.*;
import java.util.*;
class userInfo
{
    public static void userName()
    //to ask the user his name and store it in a file
    {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter your name");
        String name=sc.nextLine();
        data.write("userName",name);
    }
    
    
    public static void userBirthday()
    //to ask the user his birthday and store it in files after making sure it is valid
    {
        int day=0,month=0,year=0;
        Boolean test=false;
        System.out.println();
        do
        {
            test=false;
            System.out.println("Enter the date of your birth");
            System.out.print("Day: ");
            day=entry.takeDate();
            System.out.print("Month: ");
            month=entry.takeDate();
            System.out.print("Year: ");
            year=entry.takeDate();
            test=DateChecker.checker(day,month,year);   //To check if the date entered is valid
            if(test)
                System.out.println("Please enter a valid date"); 
         }while(test);      //to repeat if the date entered is invalid
          
        String d=Integer.toString(day),m=Integer.toString(month),y=Integer.toString(year);  // to convert to string to write in the files
        data.write("userBirthDay",d);
        data.write("userBirthMonth",m);
        data.write("userBirthYear",y);
   }
    
    
    public static void userLocation()
    //to ask and store the users location
    {   
        System.out.println();     
        String loc;
        int temp;
        do
        { 
            System.out.println("Choose the location where you live. If you do not live in any of these locations choose the location nearest to you");
            System.out.println("1. Jayanagar\n2. Basavanagudi\n3. J P nagar\n4. Banashankari\n5. Indiranagar");
            temp=entry.take();
        }while(entry.check(temp,1,5));      //to check if the option entered by the user is correct        
        loc=Integer.toString(temp);     //to convert value of temp from integer to string
        data.write("userLocation",loc);      //to write the number of the users location to file userLocation
    }
    
    
    public static boolean edit()
    //to ask and edit the user info
    //returns false if the user wants to reset all his information
    {
        int choice=0;
        boolean test=false,repeat=true;
        System.out.println("Do you want to change your:\n1. Name\n2. Age\n3. Location\n4. or reset all user information");
        choice=entry.take();
        do
            {
                    test = false;
                    switch(choice)
                    {
                        case 1:
                            userName();
                        break;
                        case 2:
                            userBirthday();
                        break;
                        case 3:
                            userLocation();
                        break;
                        case 4:
                            main.wipe();
                            System.out.println("Please close the program and open it again to reset it");
                            repeat=false;
                        break;
                        default:
                            System.out.println("Invalid choice");
                            test=true;
                        break;
                    }
            }while(test);   //repeat if the user enters a wrong option
            return repeat;      //to return false if the user has decided to reset his information
    }
}
    