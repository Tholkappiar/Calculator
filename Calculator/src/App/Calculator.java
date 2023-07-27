package App;
import java.util.Scanner;
public class Calculator{

    // Main Method
    public static void main(String[] args) {
        getUserInput();
    }

    // To get value from the user and run recursively util the user enter 'q' .
    public static void getUserInput()
    {
        /* Intializing num1 , num2 here to avoid the error where the variables are used , if it is initialized in try catch 
        block , it will throw an error where the variables are used, because it limits the scope. */

        float num1 = 0;
        float num2 = 0;
        Scanner sc = new Scanner(System.in);

        System.out.println("\nPress q and Enter to exit the calculator ! \nEnter the First Number : ");
       
        String str = sc.next();
        if (str.equals("q")) {
            System.out.println("Exiting..........!");
            System.exit(0);
        }

        // If the user input is not a number , then it will handle the exception 

        try{
            num1 = Float.parseFloat(str);
        }
        catch(Exception e)
        {
            System.out.println("\n###### Invalid Input ! Please Enter a valid Number ###### ");
            getUserInput();
        }

        
        System.out.println("\nEnter the Operation + , - , / , * : ");
        
        // To only perform the given Operations (+,-,*,/) 
        String ch = sc.next();
        if(ch.charAt(0)!='+' && ch.charAt(0)!='-' && ch.charAt(0)!='*' && ch.charAt(0)!='/' || ch.length()!=1)
        {
            System.out.println("\nEnter only the given Operations : + , - , * , / ");
            getUserInput();
        }

        System.out.println("\nEnter the Second Number : ");

        // If the user input is not a number ,then it will handle the exception 
        try{
            num2 = sc.nextFloat();
        }
        catch(Exception e)
        {
            System.out.println("\n###### Invalid Input ! Please Enter a valid Number #######");
            getUserInput();
        }
        

        System.out.println("\nAnswer : "+check(num1, ch.charAt(0), num2));
        getUserInput();
    }

    // To call the specific method for the operator , which is given by the user. 
    protected static float check(float num1,char ch1,float num2)
    {
        Operations oper = new Operations();
        switch (ch1)
        {
            case '+':
                return oper.add(num1,num2);
            case '-':
                return oper.sub(num1,num2);
            case '*':
                return oper.mul(num1,num2);
            case '/':
                return oper.div(num1,num2);
            default:
                System.out.println("\n###### Enter the valid Operator -> (+,-,/,*) ######");
        }
        return -1;
    }
}


// For Calculations
class Operations{
    protected float add(float num,float num2)
    {
        return num + num2;
    }
    protected float sub(float num,float num2)
    {
        return num - num2;
    }
    protected float mul(float num,float num2)
    {
        return num * num2;
    }
    protected float div(float num,float num2)
    {
        return num / num2;
    }
}

