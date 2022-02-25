import java.io.*;
class Calculator
{
    public static void cal()throws IOException
    //Performs an opration, asks the user if he wants to perform a operation on the result or another operation
    {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int choice;
        double result;
        boolean flag, repeat;
        System.out.println("Welcome to your calculator!");
        do
        {
            flag=true;
            result=operation1();
            do
            {
                repeat=true;
                System.out.println("\n\nDo you want to:\n1) Perform an operation on the result\n2) Start fresh and perform another operation\n3) Exit the calculator");
                choice=entry.take();
                switch(choice)
                {
                    case 1:
                        result=operation2(result);
                    break;
                    case 2:
                        repeat=false;
                    break;
                    case 3:
                        flag=false;
                        repeat=false;
                    break;
                    default:
                        System.out.println("Invalid choice");
                        repeat=true;
                    break;
                }
            }while(repeat);
        }while(flag);
    }
    
  public static double operation1()throws IOException
  //performs an operation on values entered by the user
  {
      BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
      double a=0, b=0, c=0;
      int choice;
      boolean op1;
      do
      {
        op1=false;
        System.out.println("\nWhat operation do you want to do?");
        System.out.println("\n1. Addition\n2. Subtraction\n3. Multiplication\n4. Division\n5. Power\n6. Square Root\n7. Sin\n8. Cos\n9. Tan\n10. Logarithm\n11. Exponential form\n");
        choice=entry.take();
        try
        {
        switch(choice)
        {
            case 1:
            System.out.println("\nEnter the 2 numbers that you want to add:\n");
            a=Double.parseDouble(br.readLine());
            b=Double.parseDouble(br.readLine());
            c=a+b;
            System.out.println("\nThe sum is "+c);
            break;
            case 2:
            System.out.println("\nEnter the minuend:\n");
            a=Double.parseDouble(br.readLine());
            System.out.println("\nEnter the subtrahend:\n");
            b=Double.parseDouble(br.readLine());
            c=a-b;
            System.out.println("\nThe difference is "+c);
            break;
            case 3:
            System.out.println("\nEnter the 2 numbers that you want to multiply:\n");
            a=Double.parseDouble(br.readLine());
            b=Double.parseDouble(br.readLine());
            c=a*b;
            System.out.println("\nThe product is "+c);
            break;
            case 4:
            System.out.println("\nEnter the dividend:\n");
            a=Double.parseDouble(br.readLine());
            System.out.println("\nEnter the divisor:\n");
            b=Double.parseDouble(br.readLine());
            c=a/b;
            System.out.println("\nThe quotient is "+c);
            break;
            case 5:
            System.out.println("\nEnter the base number:\n");
            a=Double.parseDouble(br.readLine());
            System.out.println("\nEnter the power to be raised to:\n");
            b=Double.parseDouble(br.readLine());
            c=Math.pow(a,b);
            System.out.println("\nThe result is "+c);
            break;
            case 6:
            System.out.println("\nEnter the number to find it's square root:\n");
            a=Double.parseDouble(br.readLine());
            c=Math.sqrt(a);
            System.out.println("\nThe answer is: "+c);
            break;
            case 7:
            System.out.println("\nEnter the angle to find it's sin value:\n");
            a=Double.parseDouble(br.readLine());
            c=Math.sin(Math.toRadians(a));
            System.out.println("\nThe sin value is: "+c);
            break;
            case 8:
            System.out.println("\nEnter the angle to find it's cos value:\n");
            a=Double.parseDouble(br.readLine());
            c=Math.cos(Math.toRadians(a));
            System.out.println("\nThe cos value is: "+c);
            break;
            case 9:
            System.out.println("\nEnter the angle to find it's tan value:\n");
            a=Double.parseDouble(br.readLine());
            c=Math.tan(Math.toRadians(a));
            System.out.println("\nThe tan value is: "+c);
            break;
            case 10:
            System.out.println("\nEnter the number to get it's log value:\n");
            a=Double.parseDouble(br.readLine());
            c=Math.log(a);
            System.out.println("\nThe log value is: "+c);
            break;
            case 11:
            System.out.println("\nEnter a number to find it's exponential form:\n");
            a=Double.parseDouble(br.readLine());
            c=Math.exp(a);
            System.out.println("\nThe exponential form is:"+c);
            break;
            default:
            System.out.println("\nInvalid choice");
            op1=true;
            break;
        }
    }catch(Exception ex){
        op1=true;
        System.out.println("\nInvalid entry");
    }
    }while(op1);
    return(c);
}

    public static double operation2(double result)throws IOException
    //performs operation on the previous result
    {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        double a=result,b=0,c=0;
        boolean op2;
        int choice;
        do
        {
        op2=false;
        System.out.println("\nWhat operation do you want to do?");
        System.out.println("\n1. Addition\n2. Subtraction\n3. Multiplication\n4. Division\n5. Power\n6. Square Root\n7. Sin\n8. Cos\n9. Tan\n10. Logarithm\n11. Exponential form");
        choice=entry.take();
        try
        {
        switch(choice)
        {
            case 1:
            System.out.println("\nEnter the number you want to add to the result:\n");
            b=Double.parseDouble(br.readLine());
            c=a+b;
            System.out.println("\nThe sum is "+c);
            break;
            case 2:
            System.out.println("\nEnter the subtrahend:\n");
            b=Double.parseDouble(br.readLine());
            c=a-b;
            System.out.println("\nThe difference is "+c);
            break;
            case 3:
            System.out.println("\nEnter the number you want to multiply the result with:\n");
            b=Double.parseDouble(br.readLine());
            c=a*b;
            System.out.println("\nThe product is "+c);
            break;
            case 4:
            System.out.println("\nEnter the divisor:\n");
            b=Double.parseDouble(br.readLine());
            c=a/b;
            System.out.println("\nThe quotient is "+c);
            break;
            case 5:
            System.out.println("\nEnter the power to which the result should be raised:\n");
            b=Double.parseDouble(br.readLine());
            c=Math.pow(a,b);
            System.out.println("\nThe result is "+c);
            break;
            case 6:
            c=Math.sqrt(a);
            System.out.println("\nThe answer is: "+c);
            break;
            case 7:
            c=Math.sin(Math.toRadians(a));
            System.out.println("\nThe sin value is: "+c);
            break;
            case 8:
            c=Math.cos(Math.toRadians(a));
            System.out.println("\nThe cos value is: "+c);
            break;
            case 9:
            c=Math.tan(Math.toRadians(a));
            System.out.println("\nThe tan value is: "+c);
            break;
            case 10:
            c=Math.log(a);
            System.out.println("\nThe log value is: "+c);
            break;
            case 11:
            c=Math.exp(a);
            System.out.println("\nThe exponential form is: "+c);
            break;
            default:
            System.out.println("\nInvalid choice");
            op2=true;
            break;
        }
         }catch(Exception ex){
        op2=true;
        System.out.println("\nInvalid entry");
    }
    }while(op2);
        return(c);
    }
}

