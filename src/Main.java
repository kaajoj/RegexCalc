import javax.xml.bind.SchemaOutputResolver;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static Map calc(String arg) {
        Stack<Integer> stack = new Stack<>();
        Map<String, Integer> map = new HashMap<>();

        String ifLetter = "0";
        String letter = "";

        for (String equation : arg.split("\\s+")) {
            //System.out.print(equation);
            //System.out.print(" ");

            String text = equation;
            String pattern = "[a-zA-Z]+";
            Pattern regex = Pattern.compile(pattern);
            Matcher matcher = regex.matcher(text);

            while (matcher.find()) {
                ifLetter = matcher.group(0);
                //System.out.print(matcher.group(0) + " ");
            }

            if (ifLetter == "0") {
                switch (equation) {
                    case "=":

                        break;
                    case "+":
                        //   System.out.print("Add ");
                        stack.push(stack.pop() + stack.pop());
                        break;
                    case "-":
                        //    System.out.print("Sub ");
                        stack.push(-stack.pop() + stack.pop());
                        break;
                    case "*":
                        //   System.out.print("Mul ");
                        stack.push(stack.pop() * stack.pop());
                        break;
                    case "/":
                        //   System.out.print("Div ");
                        int temp = stack.pop();
                        stack.push(stack.pop() / temp);
                        break;

                    default:
                        //    System.out.print("Push ");
                        stack.push(Integer.parseInt(equation));
                        break;
                }
                // System.out.println(stack);
            } else {
                letter = ifLetter;
                ifLetter = "0";
                //   System.out.println("");
            }
        }
        if(!stack.isEmpty()) {
            int temp = stack.peek();
            map.put(letter, temp);
        }
        //System.out.println("Wynik: " + stack.pop());
        //System.out.println(map.get("d"));
        return map;
    }

    public static void main(String[] args) throws IOException {
        Map<String, Integer> map = new HashMap<>();
        ArrayList<String> lista = new ArrayList<>();

        int i = 0;
        int j = 0;
        String oneLetter = "";

        String filePath = "test.txt";
        String line = "";

        try {
            File file = new File(filePath);
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                line = sc.nextLine();
                lista.add(line);
                System.out.println(lista.get(j));
                j++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Nie można odnaleźć określonego pliku wejściowego: " + filePath);
        }

        while (i < lista.size()) {
            //System.out.println(lista.get(i) + " ");
            String text = lista.get(i);
            String pattern = "[a-zA-Z]{1}";
            Pattern regex = Pattern.compile(pattern);
            Matcher matcher = regex.matcher(text);

            while (matcher.find()) {
                oneLetter = matcher.group(0);
                //System.out.print(matcher.group(0) + " ");
                if (map.containsKey(oneLetter)) {
                    if(map.get(text)!=null)
                    System.out.println(map.get(text));
                    else System.out.println("Error");
                } else map = calc(text);

            }
            if (!map.containsKey(oneLetter)) {
                System.out.println("???");
            }
            //System.out.println("Map: " + map);
            //System.out.println("");
            i++;
        }
    }
}