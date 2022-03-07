import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Homework {

    // Using any technique presented in our last course, please do the following:
    //
    // 1. Parse the given text to check if it contains "Waldo" and print the result
    // 2. Parse the given text to replace regex "W[a-z]ld[a-z]" with "*****" and print the resulting text
    // 3. Tokenize the given text using "-" and print the number of resulting tokens
    //
    // - Write all your solutions as separate static methods inside this class
    // - Call all your methods inside "main" (to be run on startup)

    static String text = "Walda-Walde-Waldi-Waldu-Weldo-Wildo-Woldo-Wuldo-"
            + "Weldo-Wildo-Woldo-Wuldo-Walda-Walde-Waldi-Waldu-"
            + "Walda-Walde-Waldi-Waldu-Weldo-Wildo-Woldo-Wuldo-"
            + "Weldo-Wildo-Woldo-Wuldo-Walda-Walde-Waldi-Waldu-"
            + "Walda-Walde-Waldi-Waldu-Weldo-Wildo-Woldo-Wuldo-"
            + "Weldo-Wildo-Woldo-Wuldo-Walda-Walde-Waldi-Waldu-"
            + "Walda-Walde-Waldi-Waldu-Weldo-Wildo-Woldo-Wuldo-"
            + "Weldo-Wildo-Woldo-Wuldo-Walda-Walde-Waldi-Waldu-"
            + "Walda-Walde-Waldi-Waldu-Weldo-Wildo-Waldo-Wuldo-"
            + "Weldo-Wildo-Woldo-Wuldo-Walda-Walde-Waldi-Waldu-"
            + "Walda-Walde-Waldi-Waldu-Weldo-Wildo-Woldo-Wuldo-"
            + "Weldo-Wildo-Woldo-Wuldo-Walda-Walde-Waldi-Waldu";

    public static void main(String[] args) {

        // Add your method calls here.
        Scanner in = new Scanner(System.in);
        boolean isNewStart = true;
        String option = "start";
        while (isNewStart == true && option != "exit") {
            System.out.println("available options: [findWaldo, hideWaldo, tokenize, exit]");
            System.out.print("option=");
            option = in.nextLine();

            switch (option) {
                case "findWaldo":
                    boolean findWaldo = false;
                    System.out.println(findWaldo(text));
                    break;
                case "hideWaldo":
                    hideWaldo(text);
                    break;
                case "tokenize":
                    tokenize(text);
                    break;
                case "exit":
                    System.exit(0);
                    break;
                default:
                    System.err.println("Invalid option");

            }
        }


//        System.out.println(text);

    }


    // Add your methods here.
    public static boolean findWaldo(String text) {
       boolean findWaldo = Homework.text.contains("Waldo");
       return findWaldo;

    }
    public static void hideWaldo(String text) {
        String waldoRegex = "W[a-z]ld[a-z]";
        Pattern regexPattern = Pattern.compile(waldoRegex);
        Matcher regexMatcher = regexPattern.matcher(text);
        System.out.println("\n SEARCHING PARTS MATCHING REGEX \"+="+ waldoRegex +"\" IN THE GIVEN TEXT:");
        int counter = 0;

        while (regexMatcher.find()){
            String match = regexMatcher.group();
            int startIndex = regexMatcher.start();
            int endIndex = regexMatcher.end();
            int lenght = endIndex - startIndex;
            System.out.println("FOUND \""+ match + "\" AT INDEX" + startIndex + ", CONTAINING " + lenght + " CHARACTER(S)");
            counter++;

        }
        System.out.println("FOUND A TOTAL OF " + counter + "MATCH(ES)");
        System.out.println("REPLACING PARTS MATCHING REGEX" + waldoRegex + " IN THE GIVEN TEXT ");
        String updatedText= regexMatcher.replaceAll("*****");
        System.out.println("UPDATED TEXT: "+ updatedText);


    }
    public static void tokenize (String text) {
        String waldoRegex = "W[a-z]ld[a-z]";
        String[] tokens = text.split(waldoRegex);
        System.out.println("\n USING REGEX \"" + waldoRegex + "\" AS A DELIMITER TO TOKENIZE THE GIVEN TEXT:");
        for (int i = 0; i< tokens.length; i++) {
            String token = tokens[i];
            System.out.println("TOKEN #" + (i+1) + ": " + token);
        }
        System.out.println("CREATED A TOTAL OF " + tokens.length + "TOKEN(S)");
    }

}
