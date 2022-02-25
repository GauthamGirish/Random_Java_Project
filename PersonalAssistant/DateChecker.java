import java.util.Calendar;
class DateChecker{
    public static boolean checker(int day,int month,int year)
    //to check if the birth date entered by the user is a valid date or not
    //returns true if date is invalid and false if date is valid
    {
        System.out.println("\n");
        boolean check=false;        
        if(currentYear(day,month,year))
            check=true;
        else if(day==0||month==0)
            check=true;
        else if(year<1900)
            check=true;
        else if(month>12)
            check=true;            
        else if(month==2)
        {            
            if(leapYear(year))
            {
                if(day>29)
                    check=true;
            }            
            else if(day>28)
                check=true;            
        }        
        else if(month==1||month==3||month==5||month==7||month==8||month==10||month==12)
        {
            if(day>31)
                check=true;
        }        
        else if(month==2||month==4||month==6||month==9||month==11)
        {
            if(day>30)
                check=true;
        }        
        return check;
    }
    
    
    public static boolean leapYear(int year)
    //to check if the year is a leap year or not
    //return true if leap year or else false
    {
        boolean leap=false;        
        if(year%4==0)
        {
            if(year%100!=0)
                leap=true;
            else if(year%400==0)
                leap=true;
        }        
        return leap;
    }
    
    
    public static boolean currentYear(int d,int m,int y)
    //to check if the date entered is equal to or more than the current date(today)
    //returns true if the date is current date or future date, else returns false
    {
        Calendar c =Calendar.getInstance();
        boolean fake=false;
        int cd,cm,cy;
        cd= c.get(Calendar.DATE);   //get current day
        cm= c.get(Calendar.MONTH)+1;    //get current month
        cy= c.get(Calendar.YEAR);   //get current year        
        if(y>cy)
        {
            fake=true;
            System.out.println("Well into the future!");
        }                
        else if(y==cy)
        {
            if(m>cm)
            {
                fake=true;
                System.out.println("Well into the future!");
            }                
            else if(m==cm)
            {
                if(d>cd)
                {
                    fake=true;
                    System.out.println("Well into the future!");
                }
                else if(d<cd)
                {
                    System.out.println("Too young to type");
                    fake=true;
                }   
                else if(d==cd)
                {
                    System.out.println("Happy Birthday.Literally!");
                    fake=true;
                }
            }            
            else
            {
                 System.out.println("Too young to type");
                 fake=true;
            }            
        }
        return fake;
    }
}
