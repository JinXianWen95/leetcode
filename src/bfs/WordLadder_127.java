package bfs;

import java.util.*;

public class WordLadder_127 {
    private int shortestLength = 0;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        // bfs
        bfs(beginWord, endWord, wordSet);
        return shortestLength;
    }

    private void bfs(String beginWord, String endWord, Set<String> words) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        words.remove(beginWord);
        // prevent cycle
        shortestLength = 1;
        while (!queue.isEmpty()) {
            // current layer
            Set<String> visitedWords = new HashSet<>();
            for (int i = queue.size() - 1; i >= 0; i--) {
                String currentWord = queue.remove();
                if (endWord.equals(currentWord)) {
                    return;
                }
                Set<String> neighbors = findNeighbors(currentWord, words);

                for (String word : neighbors) {
                    visitedWords.add(word);
                    queue.add(word);
                }
            }
            // remove the words of previous layer
            words.removeAll(visitedWords);
            shortestLength++;
        }
        // not reachable end
        shortestLength = 0;
    }

    private Set<String> findNeighbors(String word, Set<String> words) {
        Set<String> neighbors = new HashSet<>();
        char[] chars = word.toCharArray();

        for (int i = 0; i < word.length(); i++) {
            char originalChar = chars[i];
            for (int j = 'a'; j <= 'z'; j++) {
                chars[i] = (char) j;
                String candidateNeighbor = String.valueOf(chars);
                if (j != originalChar && words.contains(candidateNeighbor)) {
                    neighbors.add(candidateNeighbor);
                }
            }
            chars[i] = originalChar;
        }
        return neighbors;

    }
}
