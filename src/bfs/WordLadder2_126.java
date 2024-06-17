package bfs;

import java.util.*;

public class WordLadder2_126 {

    public static void main(String[] args) {
        new WordLadder2_126().findLadders("hit", "cog", Arrays.asList("hot","dot","dog","lot","log","cog"));
    }
    private final Map<String, List<String>> adjMap = new HashMap<>();
    private final List<List<String>> shortestPaths = new ArrayList<>();

    // bfs to build the graph; dfs to find the shortest path starting from endWord,
    // this avoids TLE since we discard no-valid paths

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return Collections.emptyList();
        }
        // bfs
        bfs(beginWord, endWord, wordSet);
        // find the shortest paths
        List<String> currentPath = new ArrayList<>();
        currentPath.add(endWord);
        backtrack(beginWord, endWord, currentPath);
        return shortestPaths;
    }

    private void bfs(String beginWord, String endWord, Set<String> words) {
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        words.remove(beginWord);
        // prevent cycle
        Set<String> isEnqueued = new HashSet<>();
        isEnqueued.add(beginWord);
        boolean found = false;
        while (!queue.isEmpty()) {
            // current layer
            Set<String> visitedWords = new HashSet<>();
            for (int i = queue.size() - 1; i >= 0; i--) {
                String currentWord = queue.remove();
                Set<String> neighbors = findNeighbors(currentWord, words);

                for (String word : neighbors) {
                    if (!adjMap.containsKey(word)) {
                        adjMap.put(word, new ArrayList<>());
                    }

                    adjMap.get(word).add(currentWord);
                    visitedWords.add(word);
                    if (!isEnqueued.contains(word)) {
                        queue.add(word);
                        isEnqueued.add(word);
                    }
                    if (endWord.equals(beginWord)) {
                        found = true;
                    }
                }
            }
            if (found) {
                break;
            }
            // remove the words of previous layer
            words.removeAll(visitedWords);
        }
    }

    private void backtrack(String beginWord, String endWord, List<String> path) {
        if (beginWord.equals(endWord)) {
            shortestPaths.add(new ArrayList<>(path));
            return;
        }

        if (!adjMap.containsKey(endWord)) {
            return;
        }
        List<String> currenLayer = adjMap.get(endWord);
        for (String s : currenLayer) {
            path.add(0, s);
            backtrack(beginWord, s, path);
            path.remove(0);
        }
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
