import java.io.*;
class data
{
    public static void write(String fileName, String wrt)
    //to write a string onto a file
    {
        try
        {
            FileWriter writer = new FileWriter(fileName+".txt");
            writer.write(wrt);
            writer.close();
        }catch (IOException ex){ex.printStackTrace();}
    }
    
    
    public static void append(String fileName, String wrt)
    //to append a string to the next line of a file
    {
        try
        {
            FileWriter writer = new FileWriter(fileName+".txt",true);
            writer.write(wrt);
            writer.close();
        }catch (IOException ex){ex.printStackTrace();}
    }
    
    
     public static String read(String fileName)
     //to read a file containing a single line and return it after storing it in a string
     {
        String str=null;
        try{
            File myFile=new File(fileName+".txt");
            FileReader filereader = new FileReader(myFile);
            BufferedReader reader=new BufferedReader(filereader);
            str=reader.readLine();
            }catch(Exception ex){ex.printStackTrace();}
        return str;
     }
}