import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static double calc(String arg) {
        Stack<Double> stack = new Stack<>();
        String temp2 = "0";

        for (String token : arg.split("\\s+")) {
            System.out.print(token);
            System.out.print(" ");

            String text = token;
            String pattern = "[a-zA-Z]+";
            Pattern regex = Pattern.compile(pattern);
            Matcher matcher = regex.matcher(text);

            while (matcher.find()) {
                temp2 = matcher.group(0);
                System.out.print(matcher.group(0) + " ");
            }

            if (temp2 == "0") {
                switch (token) {
                    case "=":

                        break;
                    case "+":
                        System.out.print("Add ");
                        stack.push(stack.pop() + stack.pop());
                        break;
                    case "-":
                        System.out.print("Sub ");
                        stack.push(-stack.pop() + stack.pop());
                        break;
                    case "*":
                        System.out.print("Mul ");
                        stack.push(stack.pop() * stack.pop());
                        break;
                    case "/":
                        System.out.print("Div ");
                        double temp = stack.pop();
                        stack.push(stack.pop() / temp);
                        break;
                    case "^":
                        System.out.print("Pow ");
                        double pow = stack.pop();
                        stack.push(Math.pow(stack.pop(), pow));
                        break;

                    default:
                        System.out.print("Push ");
                        stack.push(Double.parseDouble(token));
                        break;
                }
                System.out.println(stack);
            } else{
                String tempVariable = temp2;
                System.out.println(temp2);
            }

        }
        double temp = stack.peek();
        System.out.println("Wynik: " + stack.pop());
        return temp;
    }

    public static void main(String[] args) {
//        String text = args[0];
//        //String pattern = "[a-zA-Z]+";
//        String pattern = "=";
//        Pattern regex = Pattern.compile(pattern);
//        Matcher matcher = regex.matcher(text);
//
//        while(matcher.find()) {
//            System.out.print(matcher.group(0)+" ");
//        }
//        System.out.println("");

        double stack = 0;
        int i = 0;

        while(i<args.length) {
            System.out.println(args[i] + " ");
            stack+=calc(args[i]);
            System.out.println("Stack: " + stack);
            System.out.println("");
            i++;
        }
    }
}