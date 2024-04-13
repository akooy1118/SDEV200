import java.util.*;
import java.io.*;

public class CountKeywords {
   public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a Java source file: ");
        String filename = input.nextLine();

        File file = new File(filename);
        if (file.exists()) {
            System.out.println("The number of keywords in " + filename + " is " + countKeywords(file));
        }
        else {
            System.out.println("File " + filename + " does not exist");
        }
   }

   public static int countKeywords(File file) throws Exception {
        String[] keywordString = { "abstract", "assert", "boolean", "break", "byte",
                                    "case", "catch", "char", "class", "const", "continue",
                                    "default", "do", "double", "else", "enum", "extends",
                                    "for", "final", "finally", "float", "goto", "if", "implements",
                                    "import", "instanceof", "int", "interface", "long", "native", 
                                    "new", "package", "private", "protected", "public", "return",
                                    "short", "static", "strictfp", "super", "switch", "synchronized",
                                    "this", "throw", "throws", "transient", "try", "void", "volatile",
                                    "while", "true", "false", "null"};
        

        Set<String> keywordSet = new HashSet<>(Arrays.asList(keywordString));
           int count = 0;
           boolean inComment = false;
           boolean inString = false;

           Scanner input = new Scanner(file);
           while (input.hasNext()) {
                String line = input.nextLine();

                inComment = checkComment(line, inComment);
                inString = checkString(line, inString);

                if (!inComment && !inString) {
                    String[] words = line.split("\\W+");
                    for (String word : words) {
                        if (keywordSet.contains(word))
                            count++;
                    }
                }
           }
           return count;
    }

    private static boolean checkComment(String line, boolean inComment) {
        if (inComment) {
            int endCommentIndex = line.indexOf("*/");
            return endCommentIndex == -1 ? true : false;
        }
        int startCommentIndex = line.indexOf("*/");
        if (startCommentIndex == -1)
            return false;
        int endCommentIndex = line.indexOf("*/", startCommentIndex);
        return endCommentIndex == -1 ? true : false;
    }

    private static boolean checkString(String line, boolean inString) {
        if (inString) {
            int endStringIndex = line.indexOf('"');
            return endStringIndex == -1 ? true : false;
        }
        int startStringIndex = line.indexOf('"');
        if (startStringIndex == -1)
            return false;
        int endStringIndex = line.indexOf('"', startStringIndex + 1);
        return endStringIndex == -1 ? true : false;
    }
}