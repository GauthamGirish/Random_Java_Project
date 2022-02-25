import java.util.*;
class entry
{
    public static int take()
    //to take the users choice from the menu and catch any exceptions
    //returns the choice which user has entered or 0 if the user has entered anything except a integer
    /*it returns 0 in the case of exception because in any menu that is displayed 0 is not a option 
     *hence it will always result in Invalid option
     *this is done so as to remove any run time errors*/
    {
        int enter=0;
        try
        {        
            Scanner in=new Scanner(System.in);
            System.out.print("Enter the number of your choice : ");
            enter = in.nextInt();
        }catch(Exception ex)
            {
                enter=0;
            }
        return enter;
    }
    
    public static boolean check(int enter, int low, int high)
    //to take the value entered by the user, the minimum value and the maximium value accepted and check if the number entered is valid
    //it returns true if the user has entered an invalid option or else false
    {
        boolean test=false;
        if(enter<low||enter>high)
        {
        System.out.println("Invalid Choice. Please enter a correct option.");
        test=true;
        }
        return test;
    }
    
    
    public static boolean quiz(int correct)
    //to take the users option and check if it is the correct option for the perticular quiz question
    //here the correct option is passed by us in the formal parameter
    //we return true if the user enters the correct option or else false
    {
        int enter=0;
        boolean check= false;
        enter = entry.take();   //to take the users entry
        if(enter==correct)
        check = true;
        return check;
    }
    
    public static int takeDate()
    //to take the users date of birth
    {
        int enter=0;
        try
        {        
            Scanner in=new Scanner(System.in);
            enter = in.nextInt();
        }catch(Exception ex)
        {   
            enter=0;
        }
        return enter;
    }
}


        
        