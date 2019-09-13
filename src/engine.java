import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class engine {

    public static void main(String[] args) {
        /*the entire section below is intended for testing purposes only*/

        /* ********************************************************************************************************* */

        Dictionary dictionary = Utils.makeDictionary(args[0]);
        Map<Character, Integer> points = Utils.makeMap(args[1]);
        String words[] = {"QI", "AZURE", "ALLURE", "ZEBRA", "RIOJA"};
        /* enter the 7 tiles you want to test with below */
        String tiles = "QASENDIG";

        System.out.println("\nTESTING STAGE 3: MANUAL WORD SEARCHES");

        for (int i = 0; i < words.length; i++) {
            if (dictionary.findWord(words[i])) {
                System.out.println("Word: " + words[i] + "; This is a valid scrabble word");
            } else {
                System.out.println("Word: " + words[i] + "; This is not a valid scrabble word");
            }
        }

        System.out.println("\nTESTING STAGE 4: GENERATION OF ALL POSSIBLE PERMUTATIONS GIVEN TILES");
        List<String> permutations = dictionary.generatePermutations(tiles);

        System.out.println("Your Tiles Were: " + tiles);
        System.out.println("There are " + permutations.size() + " possible permutations");

        System.out.println("\nTESTING STAGE 5: CHECKING HOW MANY PERMUTATIONS ARE VALID");
        List<String> valid = dictionary.getAllWords(tiles);
        System.out.println("There are " + valid.size() + " valid scrabble words with your tiles");
        System.out.println("Here is the list of all possible words: " + valid);

        System.out.println("\nTESTING STAGE 6: GETTING THE LONGEST WORDS AND WORD LENGTH");
        System.out.println("The longest word you can make with your tiles is " + dictionary.getMaxLength(valid) + " letters long");
        System.out.println("Longest possible word: " + dictionary.getLongestWords(valid));

        System.out.println("\nTESTING STAGE 7: CREATING A HASHMAP OF LETTER POINTS");
        System.out.println(points);

        System.out.println("\nTESTING STAGE 8: MANUAL WORD POINT CHECK");
        for (String s : words) {
            System.out.println("Word: " + s + "; Score: " + Utils.score(points, s));
        }

        System.out.println("\nTESTING STAGE 9: FINDING BEST WORD AND ATTACHED SCORE");
        System.out.println("The best word you can make with your tiles is worth " + dictionary.getMaxScore(points, valid) + " points");
        System.out.println("Best word: " + dictionary.getBestWords(points, valid));

        /* ********************************************************************************************************** */
/* The section below is intended to serve as a running beta version of the program */
//        Dictionary dictionary = new Dictionary();
//        List<String> words = Utils.readFile(args[0]);
//
//        for (String s : words) {
//            dictionary.addWord(s);
//        }
//
//        Scanner input = new Scanner(System.in);
//        String word;
//
//        while (!(word = input.next().toUpperCase()).equals(" ")) {
//            System.out.println(word + ": " + dictionary.findWord(word));
//        }
    }
}
