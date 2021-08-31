import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Dictionary {
    private AlphaNode head;

    public Dictionary() {
        this.head = new AlphaNode();
    }

    public boolean addWord(String word) {
        if (word == null) {
            System.out.println("cannot add empty word to dictionary");
            return false;
        }
        return add(word, head);
    }

    /*recursively adds a word to the dictionary starting from the head*/
    private boolean add(String word, AlphaNode node) {
        char character = word.charAt(0);
        int charValue = character - 'A';


        if (node.children[charValue] == null) {
            node.children[charValue] = new AlphaNode();
        }

        AlphaNode next = node.children[charValue];
        if (word.length() == 1) {
            next.setWord(true);
            return true;
        } else {
           return add (word.substring(1), next);
        }
    }

    public boolean findWord(String word) {
        if (word == null) {
            System.out.println("cannot find null word");
            return false;
        }

        return find(word, head);
    }

    /*highly similar to the add method above*/
    private boolean find(String word, AlphaNode node) {
        char character = word.charAt(0);
        int charValue = character - 'A';

        if (node.children[charValue] == null) {
            return false;
        }

        AlphaNode next = node.children[charValue];
        if (word.length() == 1) {
            return next.isWord();
        } else {
            return find (word.substring(1), next);
        }
    }

    /*lists all possible permutations of words (valid or invalid) from given letters*/
    /*public only for testing purposes*/
    public List<String> generatePermutations(String letters) {
        List<String> words = new ArrayList<>();
        List<Character> letterList = new ArrayList<>();
        for (Character c : letters.toCharArray()) {
            letterList.add(c);
        }
        permutations(new StringBuilder(), letterList, words);
        return words;
    }

    private void permutations(StringBuilder current, List<Character> letters, List<String> words) {
        /* recursive function, builds from smallest unit upwards*/
        for (int i =0; i < letters.size(); i++) {
            current.append(letters.get(i));
            if(current.length() > 1) {
                words.add(current.toString());
            }
            List<Character> rest = new ArrayList<>();
            for (int j = 0; j < letters.size(); j++) {
                if (j != i) {
                    rest.add(letters.get(j));
                }
            }
            permutations(current, rest, words);
            current.deleteCharAt(current.length() - 1);
        }
    }

    /*returns a list of all valid words that can be played with  current tiles*/
    public List<String> getAllWords(String tiles) {
        List<String> permutations = generatePermutations(tiles);
        List<String> valid = new ArrayList<>();
        for (String word : permutations) {
            if (findWord(word) && !valid.contains(word)) {
                valid.add(word);
            }
        }
        return valid;
    }

    public String getLongestWords(List<String> valids) {
        int length = 0;
        StringBuilder current = new StringBuilder();
        for (String word : valids) {
            if (word.length() == length) {
                if (current.length() > 0) {
                    current.append(" or ");
                }
                current.append(word);
            } else if (word.length() > length) {
                length = word.length();
                current.delete(0, current.length());
                current.append(word);
            }
        }
        return current.toString();
    }

    public int getMaxLength (List<String> valids) {
        int length = 0;
        for (String word : valids) {
            if (word.length() > length) {
                length = word.length();
            }
        }
        return length;
    }

    public String getBestWords(Map<Character, Integer> points, List<String> valids) {
        int maxScore = 0;
        StringBuilder current = new StringBuilder();
        for (String word : valids) {
            int score = Utils.score(points, word);
            if (score == maxScore) {
                if (current.length() > 0) {
                    current.append(" or ");
                }
                current.append(word);
            } else if (score > maxScore) {
                maxScore = score;
                current.delete(0, current.length());
                current.append(word);
            }
        }
        return current.toString();
    }

    public int getMaxScore(Map<Character, Integer> points, List<String> valids) {
        int maxScore = 0;
        for (String word : valids) {
            int score = Utils.score(points, word);
            if (score > maxScore) {
                maxScore = score;
            }
        }
        return maxScore;
    }

}
