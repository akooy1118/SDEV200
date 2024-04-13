import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class SymbolsChecker {
   public static void main(String[] args) {
    if (args.length != 1) {
        System.out.println("Usage: java SymbolsChecker <filename>");
        return;
    }
    
    String filename = args[0];
    try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
        String line;
        while ((line = reader.readLine()) != null) {
            if (!checkGroupingSymbols(line)) {
                System.out.println("Unbalanced grouping symbols in the line: " + line);
                return;
            }
        }

        if (checkGroupingSymbols("")) {
            System.out.println("Al grouping symbols are balanced.");
        } else {
            System.out.println("Unbalanced grouping symbols in the file.");
        }
    } catch (IOException e) {
        System.out.println("Error reading the file: " + e.getMessage());
    }
   }

   private static boolean checkGroupingSymbols(String line) {
    Stack<Character> stack = new Stack<>();
    for (char c : line.toCharArray()) {
        if (c == '(' || c == '{' || c == '[') {
            stack.push(c);
        } else if (c == ')' || c == '}' || c == ']') {
            if (stack.isEmpty() || !isMatchingPair(stack.pop(), c)) {
                return false;
            }
        }
    }
    return stack.isEmpty();
   }

   private static boolean isMatchingPair(char opening, char closing) {
    return (opening == '(' && closing == ')') ||
           (opening == '{' && closing == '}') ||
           (opening == '[' && closing == ']');
   }
}
