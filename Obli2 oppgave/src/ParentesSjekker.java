//a) 
import java.util.Stack;

public class ParentesSjekker {
    public static boolean sjekkParentes(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (erStartParentes(c)) {
                stack.push(c);
            }
            
            else if (erSluttParentes(c)) {
                if (stack.isEmpty()) {
                    return false;
                }

                char start = stack.pop();
                if (!erParentesPar(start, c)) {
                    return false;
                }
            }    
        }
        return stack.isEmpty();
    }

    private static boolean erStartParentes(char c) {
        return c == '(' || c == '{' || c == '[';
    }

    private static boolean erSluttParentes(char c) {
        return c == ')' || c == '}' || c == ']';
    }   

    private static boolean erParentesPar(char start, char slutt) {
        return (start == '(' && slutt == ')') ||
               (start == '{' && slutt == '}') ||
               (start == '[' && slutt == ']');             
    }

    public static void main(String[] args) {
    }
}



