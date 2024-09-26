package trie;

public class SumOfPrefixScoresOfString_2416 {
    private Node root = new Node();

    public int[] sumPrefixScores(String[] words) {
        for (String word : words) {
            insertWord(word);
        }

        int[] result = new int[words.length];

        for (int i = 0; i < words.length; i++) {
            result[i] = sumPrefix(words[i]);
        }
        return result;
    }

    private void insertWord(String word) {
        Node node = root;
        for (char c : word.toCharArray()) {
            if (!node.contains(c)) {
                node.put(c, new Node());
            }
            node.inc(c);
            node = node.get(c);
        }
    }

    private int sumPrefix(String word) {
        Node node = root;
        int sum = 0;
        for (char c : word.toCharArray()) {
            sum += node.getCount(c);
            node = node.get(c);
        }
        return sum;
    }

    private class Node {
        int count = 0;
        Node[] nodes = new Node[26];

        void put(char ch, Node node) {
            nodes[ch - 'a'] = node;
        }

        Node get(char ch) {
            return nodes[ch - 'a'];
        }

        void inc(char ch) {
            nodes[ch - 'a'].count++;
        }

        int getCount(char ch) {
            return nodes[ch - 'a'].count;
        }

        boolean contains(char ch) {
            return get(ch) != null;
        }
    }
}
