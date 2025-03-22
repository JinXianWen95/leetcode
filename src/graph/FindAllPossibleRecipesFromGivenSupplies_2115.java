package graph;

import java.util.*;
import java.util.stream.Collectors;

public class FindAllPossibleRecipesFromGivenSupplies_2115 {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Set<String> availableIngredients = Arrays.stream(supplies).collect(Collectors.toSet());
        Map<String, Integer> recipeAndIndex = new HashMap<>();
        for (int i = 0; i < recipes.length; i++) {
            recipeAndIndex.put(recipes[i], i);
        }

        Map<String, List<String>> dependenciesGraph = new HashMap<>();
        int[] inDegrees = new int[recipes.length];

        for (int i = 0; i < recipes.length; i++) {
            for (String ingredient : ingredients.get(i)) {
                if (!availableIngredients.contains(ingredient)) {
                    dependenciesGraph.putIfAbsent(ingredient, new ArrayList<>());
                    dependenciesGraph.get(ingredient).add(recipes[i]);
                    inDegrees[i]++;
                }
            }
        }

        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < inDegrees.length; i++) {
            if (inDegrees[i] == 0) { // the recipe has all ingredients available
                queue.add(recipes[i]);
            }
        }

        List<String> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            String recipe = queue.poll();
            result.add(recipe);

            if (!dependenciesGraph.containsKey(recipe)) {
                continue;
            }

            for (String dependencyRecipe : dependenciesGraph.get(recipe)) {
                if (--inDegrees[recipeAndIndex.get(dependencyRecipe)] == 0) {
                    queue.offer(dependencyRecipe);
                }
            }
        }

        return result;

    }
}
