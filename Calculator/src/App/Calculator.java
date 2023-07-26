package App;
import java.util.Scanner;
public class Calculator{

    // Main Method
    public static void main(String[] args) {
        getValues();
    }

    // To get value from the user and run recursively util the user enter 'q' .
    public static void getValues()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the First Number or\nPress q and Enter to exit the calculator !");
       
        String str = sc.next();
        if (str.equals("q")) {
            System.out.println("Exiting..........!");
            return;
        }

        float num1 = Float.parseFloat(str);
        System.out.println("Enter the Operation + , - , / , * : ");
        char ch1 = sc.next().charAt(0);
        System.out.println("Enter the Second Number : ");
        float num2 = sc.nextFloat();

        System.out.println(check(num1, ch1, num2));

        getValues();
    }

    // To check , which operation to perform
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
                System.out.println("Enter the valid Operator -> + - / *");
        }
        return -1;
    }
}


// To perform Operations
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

