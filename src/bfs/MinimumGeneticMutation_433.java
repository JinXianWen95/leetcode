package bfs;

import java.util.*;
import java.util.stream.Collectors;

public class MinimumGeneticMutation_433 {
    int minMutation = 1;

    public static void main(String[] args) {
        System.out.println(
                new MinimumGeneticMutation_433().minMutation("AACCGGTT", "AAACGGTA",
                        new String[]{"AACCGGTA","AACCGCTA","AAACGGTA"}));
    }
    public int minMutation(String startGene, String endGene, String[] bank) {
        // can be solved as word ladder problem, build a graph and find the minimum path from startGene to endGene
        Set<String> geneBank = Arrays.stream(bank).collect(Collectors.toSet());
        if (startGene.equals(endGene) || !geneBank.contains(endGene)) {
            return -1;
        }
        bfs(startGene, endGene, geneBank);
        return minMutation;
    }

    private void bfs(String startGene, String endGene, Set<String> bank) {
        Deque<String> currentLayer = new LinkedList<>();
        currentLayer.add(startGene);
        // to prevent cycle
        Set<String> visitedMutation = new HashSet<>();

        boolean found = false;
        while (!currentLayer.isEmpty()) {
            int currentLayerSize = currentLayer.size();
            for (int i = 0; i < currentLayerSize; i++) {
                String currentGene = currentLayer.pollFirst();
                List<String> mutations = findMutations(currentGene, bank);
                for (String mutation : mutations) {
                    bank.remove(mutation);
                    if (mutation.equals(endGene)) {
                        found = true;
                    }
                    if (!visitedMutation.contains(mutation)) {
                        visitedMutation.add(mutation);
                        currentLayer.addLast(mutation);
                    }
                }
            }
            if (found) {
                return;
            }
            minMutation++;
        }
        minMutation = -1;
    }

    private List<String> findMutations(String gene, Set<String> bank) {
        List<String> result = new ArrayList<>();
        char[] geneChars = gene.toCharArray();
        List<Character> validGenes = List.of('A', 'C', 'G', 'T');
        for (int i = 0; i < geneChars.length; i++) {
            char original = geneChars[i];
            for (Character validGene : validGenes) {
                geneChars[i] = validGene;
                String newGene = String.valueOf(geneChars);
                if (bank.contains(newGene)) {
                    result.add(newGene);
                }
                geneChars[i] = original;
            }
        }
        return result;
    }
}
