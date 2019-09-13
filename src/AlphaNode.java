public class AlphaNode {
    AlphaNode children[];
    private boolean word;

    public AlphaNode() {
        /*an Alphabet Node contains 26 potential children (one for each alphabet) and a flag marking whether a word
        * has been reached*/
        this.children = new AlphaNode[26];
        this.word = false;
    }

    public boolean isWord() {
        return word;
    }

    public void setWord(boolean word) {
        this.word = word;
    }
}

