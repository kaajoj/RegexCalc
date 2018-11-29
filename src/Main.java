import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static Map calc(String arg) {
        Stack<Integer> stack = new Stack<>();
        Map<String, Integer> map = new HashMap<>();

        String ifLetter = "0";
        String letter = "";

        for (String token : arg.split("\\s+")) {
            System.out.print(token);
            System.out.print(" ");

            String text = token;
            String pattern = "[a-zA-Z]+";
            Pattern regex = Pattern.compile(pattern);
            Matcher matcher = regex.matcher(text);

            while (matcher.find()) {
                ifLetter = matcher.group(0);
                //System.out.print(matcher.group(0) + " ");
            }

            if (ifLetter == "0") {
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
                            int temp = stack.pop();
                            stack.push(stack.pop() / temp);
                            break;

                        default:
                            System.out.print("Push ");
                            stack.push(Integer.parseInt(token));
                            break;
                    }
                    System.out.println(stack);
                } else {
                    letter = ifLetter;
                    ifLetter = "0";
                    System.out.println("");
                }
        }
        int temp = stack.peek();
        map.put(letter, temp);
        System.out.println("Wynik: " + stack.pop());
        System.out.println(map.get("d"));
        return map;
    }

    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();
        int i = 0;

        while(i<args.length) {
            System.out.println(args[i] + " ");

            if (map.containsKey(args[i])) {
                System.out.println(map.get(args[i]));
            } else map=calc(args[i]);
            System.out.println("Map: " + map);
            System.out.println("");
            i++;
        }


    }
}