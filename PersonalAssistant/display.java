import java.io.*;
class display
{
    public static void books(int age,int loc,int cat)
    //to display the books which are recommended for the user and add the books to his wishlist
    {
        int i=0, cho=0;
        boolean flag =false;
        String line=null;
        System.out.println("\n\n");
        library(loc);
        try
        {            
            File myFile=new File(age+""+loc+""+cat+".txt");
            FileReader filereader = new FileReader(myFile);
            BufferedReader reader=new BufferedReader(filereader);
            while ((line=reader.readLine()) != null)
            {
                i++;
                System.out.println(i+". "+line);
            }
            System.out.println();     
            reader.close();
        }catch(Exception ex){ex.printStackTrace();}        
        do
        {
            flag=false;
            System.out.println("Do you want to add\n1. The first book to your wishlist?\n2. The second book to your wishlist?\n3. Both the books in your wishlist?\n4. None of these to your wishlist");
            cho=entry.take();
            i=0;
            switch(cho)
            {
                case 1:
                    wishlist.add(age,loc,cat,1);
                break;
                case 2:
                    wishlist.add(age,loc,cat,2);
                break;
                case 3:
                    wishlist.add(age,loc,cat,1);
                    wishlist.add(age,loc,cat,2);
                break;
                case 4:
                break;
                default:
                    System.out.println("You entered the wrong choice");
                    flag=true;
            }
        }while(flag);
    }
    
    
    static void library(int loc)
    //To display the name of the library in the users location
    {        
        String line=null;
        try
        { 
            File myFile=new File("library"+loc+".txt");
            FileReader filereader = new FileReader(myFile);
            BufferedReader reader=new BufferedReader(filereader);            
            while ((line=reader.readLine()) != null)
            {
                System.out.println(line);
            }    
            reader.close();
        }catch(Exception ex){ex.printStackTrace();}
    }
    
    
    static int category()
    //to display the category of books and return the users choice
    {
        System.out.println("\n\n");
        int cat=0;        
        do
        {            
            System.out.println("Enter the category of your choice:");
            System.out.println("1. Science\n2. Drama\n3. Fiction\n4. Horror\n5. Mystery");
            cat=entry.take();
        }while(entry.check(cat,1,5));
        return cat;
    }
    
    static int age()
    //to display the different age groups and return the users choice
    {
        System.out.println("\n\n");
        int age=0;
        do
        {
            System.out.println("Choose from the following age groups");
            System.out.println("1. Upto 15\n2. 15-25\n3. 25-35\n4. 35-50\n5. 50 and above");
            age=entry.take();
        }while(entry.check(age,1,5));
        return age;
    }
        
    static int location()
    //to display the locations and return the users choice
    {
        System.out.println("\n\n");
        int loc;
        do
        {            
            System.out.println("Choose from the following locations\n1. Jayanagar\n2. Basavanagudi\n3. J P Nagar\n4. Banashankari\n5. Indiranagar");
            loc=entry.take();            
        }while(entry.check(loc,1,5));
        return loc;
    }
}
