import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Utils {

    /*The following method aims to read a file with one word per line, separated by a comma
    * and put all of said words into a list*/
    private static List<String> readFile(String filename) {
        List<String> words = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String word;
            while ((word = reader.readLine()) != null) {
                if (word.charAt(word.length() - 1) == ',') {
                    word = word.substring(0, word.length() - 1);
                }
                words.add(word);
            }
            reader.close();
            return words;
        } catch( Exception e) {
            System.out.println("error due to " + e);
            return null;
        }
    }

    public static Dictionary makeDictionary(String filename) {
        Dictionary dictionary = new Dictionary();
        List<String> words = readFile(filename);
        for (String word : words) {
            dictionary.addWord(word);
        }
        return dictionary;
    }

    public static Map<Character, Integer> makeMap(String filename) {
        List<String> file = readFile(filename);
        Map<Character, Integer> points = new HashMap<>();
        for (String s : file) {
            Character character = s.charAt(0);
            StringBuilder numAsString = new StringBuilder();
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == ' ') {
                    continue;
                }
                numAsString.append(s.charAt(i));
            }
            Integer point = Integer.parseInt(numAsString.toString());
            points.put(character, point);
        }
        return points;
    }

    public static int score(Map<Character, Integer> points, String word) {
        int score = 0;
        for (int i = 0; i < word.length(); i++) {
            Character character = word.charAt(i);
            score += points.get(character);
        }
        return score;
    }
}
