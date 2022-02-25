import java.io.*;
import java.util.Calendar;
class wishlist
{
    /*There is two wishlist files named wishlist1 and wishlist2.
     * Wishfile contains the number 1 or 2 depending on what is being used as the current wishlist file.
     * The reason for this is written in the comments of method delete
     */
    public static int fileNum()
    //To read the number in wishFile to check which wishlist file is to be used
    {
        
        int file=0;
        file=Integer.parseInt(data.read("wishFile"));
        return file;
    }
       
    
    public static void fileNumChange()
    //to change the number in wishFile so that the other wishlist will be used
    {
        int file=0;
        String str;
        file=fileNum();
        if (file==1)
            file=2;
        else
            file=1;
        str=Integer.toString(file);
        data.write("wishFile",str);
    }        
    
    
    public static void add(int age,int loc,int cat,int num)
    //to add a book to the wishlist
    {
        String book=null;
        int i=0;
        int file=fileNum();
        try
        {
            File myFile=new File(age+""+loc+""+cat+".txt");
            FileReader filereader = new FileReader(myFile);
            BufferedReader reader=new BufferedReader(filereader);
            while ((book=reader.readLine()) != null)
            {
                i++;
                if(i==num)
                data.append("wishlist"+file,book+"\n");
            }
        }catch(Exception ex){ex.printStackTrace();}
    }    
      
    
    public static void read()
    //to read the wishlist
    {
        int i=0,file=fileNum();
        try
        { 
            File myFile=new File("wishlist"+file+".txt");
            FileReader filereader = new FileReader(myFile);
            BufferedReader reader=new BufferedReader(filereader);
            String line=null;
            while ((line=reader.readLine()) != null)
            {
                i++;
                System.out.println(i+". "+line);
            }
            reader.close();
        }catch(Exception ex){ex.printStackTrace();}
        if(i==0)
            System.out.println("Oops! Looks like there are no books in your wishlist. Go over to the book recommender to add some. ");
    }

    
    public static void delete(int del)
    //to delete a book from the wishlist
    //we take the number of the book the user wants to delete
    /*The logic is here we first check which wishlist file is being used
     *then we clear the contents of the other wishlist
     *after that we read the first wishlist and write onto the other wishlist
     *we write the names of all the books except the book the user has decided to delete
     *then we change the number in wishFile so that we use the other wishlist
     */
    {
        int file=fileNum(),i=0;
        fileNumChange();
        int change=fileNum();
        data.write("wishlist"+change,"");
        try
        { 
            File myFile=new File("wishlist"+file+".txt");
            FileReader filereader = new FileReader(myFile);
            BufferedReader reader=new BufferedReader(filereader);
            try
            {
                FileWriter writer = new FileWriter("wishlist"+change+".txt",true);
                String line=null;
                while ((line=reader.readLine()) != null)
                {
                    i++;
                    if(i!=del)
                    writer.write(line+"\n");                
                }
                writer.close();
            }catch (IOException ex){ex.printStackTrace();}
            reader.close();
        }catch(Exception ex){ex.printStackTrace();}
    }
    
    public static void editor()
    //to display the wishlist and delete a book of the users choice
    {
        boolean flag,del,rep;
        int choice=0,num=0,delete=0;
        System.out.println("Here is your wishlist:");
                    wishlist.read();
                    do
                    {
                        flag=false;
                        System.out.println("Do you want to remove a book from your wishlist?\n1. Yes\n2. No");
                        choice=entry.take();
                        switch(choice)
                        {
                            case 1:
                                do
                                {
                                    del=false;
                                    System.out.println();
                                    System.out.println("Enter the number of the book you want to delete");
                                    num=entry.take();
                                    wishlist.delete(num);
                                    System.out.println("\n\n\nHere is your updated wishlist:");
                                    wishlist.read();
                                    do
                                    {                        
                                        rep=false;
                                        System.out.println();
                                        System.out.println("Do you want to delete another book?\n1. Yes\n2. No");
                                        delete=entry.take();
                                        if(delete==1)
                                        del=true;
                                        else if(delete<1||delete>2)
                                        {
                                            System.out.println("Invalid Choice");
                                            rep=true;
                                        }
                                    }while(rep);    //repeats if the user has entered an invalid choice for question in line 140
                                }while(del);    //repeats if the user wants to delete another book
                            break;
                            case 2:
                            break;
                            default:
                                System.out.println("Invalid choice");
                                flag=true;
                            break;
                        }
                    }while(flag);    //repeats if the user has entered an invalid choice for question in line 122
                }
}
    