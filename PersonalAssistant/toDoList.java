import java.io.*;
import java.util.*;
import java.util.Calendar;
class toDoList
{
    /*There is two toDoList files named toDoList1 and toDoList2.
     * whichList contains the number 1 or 2 depending on what is being used as the current toDoList file.
     * The reason for this is written in the comments of method delete
     */
    public static int fileNum()
    //To read the number in whichList to check which toDoList file is to be used
    {
        
        int file=0;
        file=Integer.parseInt(data.read("whichList"));
        return file;
    }
       
    
    public static void fileNumChange()
    //to change the number in whichList so that the other toDoList will be used
    {
        int file=0;
        String str;
        file=fileNum();
        if (file==1)
            file=2;
        else
            file=1;
        str=Integer.toString(file);
        data.write("whichList",str);
    }        
    
    
    public static void add()
    //to add a thing to the toDoList
    {
        int i=0;
        int file=fileNum();
        System.out.println("\nEnter what you want to add to your to do list:");
        Scanner sc= new Scanner(System.in);
        String toDo=sc.nextLine();
        data.append("toDoList"+file,toDo+"\n");
    }    
      
    
    public static void read()
    //to read the toDoList
    {
        int i=0,file=fileNum();
        try
        { 
            File myFile=new File("toDoList"+file+".txt");
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
            System.out.println("Looks like you have completed everything you wanted to do. Add something you want to do. ");
    }

    
    public static void delete(int del)
    //to delete a task from the toDoList
    //we take the number of the task the user wants to delete
    /*The logic is here we first check which toDoList file is being used
     *then we clear the contents of the other toDoList
     *after that we read the first toDoList and write onto the other toDoList
     *we write all the tasks except the task the user has decided to delete
     *then we change the number in whichList so that we use the other toDoList
     */
    {
        int file=fileNum(),i=0;
        fileNumChange();
        int change=fileNum();
        data.write("toDoList"+change,"");
        try
        { 
            File myFile=new File("toDoList"+file+".txt");
            FileReader filereader = new FileReader(myFile);
            BufferedReader reader=new BufferedReader(filereader);
            try
            {
                FileWriter writer = new FileWriter("toDoList"+change+".txt",true);
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
    //to display the toDoList and delete or add a task of the users choice
    {
        boolean flag;
        int choice=0,num=0,delete=0;
        System.out.println("Here is your toDoList:");
                    toDoList.read();
                    do
                    {
                        flag=true;
                        System.out.println("\n\nDo you want to \n1. Add something you want to do\n2. Remove somthing you finished doing or dont want to do\n3. Go back to main menu");
                        choice=entry.take();
                        switch(choice)
                        {
                            case 1:
                                toDoList.add();
                                System.out.println("\n\n\nHere is your updated toDoList:");
                                toDoList.read();
                            break;
                            case 2:
                                    System.out.println();
                                    System.out.println("Enter the number of which you want to delete");
                                    num=entry.take();
                                    toDoList.delete(num);
                                    System.out.println("\n\n\nHere is your updated toDoList:");
                                    toDoList.read();
                            break;
                            case 3:
                                flag=false;
                                break;
                            default:
                                System.out.println("Invalid choice");
                            break;
                        }
                    }while(flag);    
                }
}
    