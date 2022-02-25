import java.util.*;
import java.io.*;
class quiz{
    public static void quizChooser()throws IOException
    {
        BufferedReader br=new BufferedReader (new InputStreamReader(System.in));
        boolean wrong=false,repeat=false,newQuiz=false;
        int n=0,ch=0;
        String s;
        do
        {
            do
            {
                n=Integer.parseInt(data.read("quiz"));
                quiz(n);
                do
                {
                    wrong=false;
                    System.out.println("\nDo you want to take this quiz again?\n1. Yes\n2. No");
                    ch=entry.take();
                    switch(ch)
                    {
                        case 1:
                            repeat=true;
                        break;
                        case 2:
                            repeat=false;
                        break;
                        default:
                            System.out.println("\nInvalid choice\n");
                            wrong=true;
                        break;
                    }
                }while(wrong);
            }while(repeat);
            if(n==5)
                n=0;
            n++;
            s=Integer.toString(n);        
            data.write("quiz",s);
            int ch1=0;
            do
            {
                wrong=false;
                System.out.println("\nDo you want to take another quiz?\n1. Yes\n2. No");
                ch=entry.take();
                switch(ch)
                {
                    case 1:
                        newQuiz=true;
                    break;
                    case 2:
                        newQuiz=false;
                    break;
                    default:
                        System.out.println("\nInvalid choice\n");
                        wrong=true;
                    break;
                }
            }while(wrong);
        }while(newQuiz);
        System.out.println("\n\nHope you had fun");
    }
    
    
    public static void quiz(int num)
    {
        int c=0, j=0, i=0, answer = 0;
        String wr="", question = null, option = null;
        System.out.println("\n\nWelcome to the Quiz! Have fun!");
        try
        { 
            File myFileQues = new File("quiz"+num+"questions.txt");  //to open and read the file containing the questions for the quiz
            FileReader filereaderQues = new FileReader(myFileQues);
            BufferedReader readerQues = new BufferedReader(filereaderQues);
            
            File myFileOpt=new File("quiz"+num+"options.txt");  //to open and read the file containing the options for the quiz
            FileReader filereaderOpt = new FileReader(myFileOpt);
            BufferedReader readerOpt=new BufferedReader(filereaderOpt);
            
            File myFileAns=new File("quiz"+num+"answers.txt");  //to open and read the file containing the correct answers for the quiz
            FileReader filereaderAns = new FileReader(myFileAns);
            BufferedReader readerAns = new BufferedReader(filereaderAns);
            
            while ((question=readerQues.readLine()) != null)      //reads question
            {
                System.out.println();
                answer=Integer.parseInt(readerAns.readLine());
                j++;
                System.out.println(j+")\t"+question);
                for(i=1;i<=4;i++)   //to print options one below the other
                {
                    option=readerOpt.readLine();
                    System.out.println(i+".\t"+option);
                }
                if(entry.quiz(answer))
                c++;
                else
                wr=wr+", "+j;   //to store question numbers which the user answered wrong
            }
            readerQues.close();
            readerOpt.close();
            readerAns.close();
        }catch(Exception ex){ex.printStackTrace();}
        System.out.println("\n\nAwesome! You're done! Let's see how you did.");
        System.out.println("You got "+c+" out of 10 questions right!!");
        if(c==10)
            System.out.println("Congradulations!!You got nothing wrong.");
        else
            System.out.println("You got questions"+wr+" wrong");
    }
}

