import java.util.Calendar;
import java.io.*;
class ageFinder{
    public static int Finder()
    //to find the users current age using his birthdate stored in the files
    //returns his age
    {
        int bd=0,bm=0,by=0,cd=0,cm=0,cy=0,age;
        bd=Integer.parseInt(data.read("userBirthday"));     //read his birth day
        bm=Integer.parseInt(data.read("userBirthMonth"));     //read his birth month
        by=Integer.parseInt(data.read("userBirthYear"));     //read his birth year
        Calendar c =Calendar.getInstance();
        cd= c.get(Calendar.DATE);   //get current day
        cm= c.get(Calendar.MONTH)+1;   //get current month
        cy= c.get(Calendar.YEAR);   //get current year
        age=cy-by;
        if(bm>cm)
        {  
            age--;
        }
        else if(bm==cm)
        {
            if(bd>cd)
            age--;
        }
        return age;
    }
    
    
    public static void happyBirthday()
    //to check if it is the users birthday and wish him
    {
        int bd=0,bm=0,cd=0,cm=0;
        String name=null;
        bd=Integer.parseInt(data.read("userBirthday"));
        bm=Integer.parseInt(data.read("userBirthMonth"));
        name=data.read("userName");
        Calendar c =Calendar.getInstance();
        cd= c.get(Calendar.DATE);
        cm= c.get(Calendar.MONTH)+1;
        if(bd==cd&&bm==cm)
            System.out.println("Happy Birthday "+name);
    }
    
    
    public static int categorizer()
    //to find the category under which the age of the user falls under
    {
        int age=Finder();   //to find the users age
        int cat=0;
        if(age<15)
            cat=1;
        else if(age>=15&&age<25)
            cat=2;
        else if(age>=25&&age<35)
            cat=3;
        else if(age>=35&&age<50)
            cat=4;
        else if(age>=50)
            cat=5;
        return cat;
    }
}

     