package other;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.TreeSet;

public class DesignFoodRatingSystem_2353 {

    public static void main(String[] args) {
        DesignFoodRatingSystem_2353 foodRatings = new DesignFoodRatingSystem_2353(
                new String[] {"kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"},
                new String[] {"korean", "japanese", "japanese", "greek", "japanese", "korean"},
                new int[] {9, 12, 8, 15, 14, 7});
        foodRatings.highestRated("korean"); // return "kimchi"
        // "kimchi" is the highest rated korean food with a rating of 9.
        foodRatings.highestRated("japanese"); // return "ramen"
        // "ramen" is the highest rated japanese food with a rating of 14.
        foodRatings.changeRating("sushi", 16); // "sushi" now has a rating of 16.
        foodRatings.highestRated("japanese"); // return "sushi"
        // "sushi" is the highest rated japanese food with a rating of 16.
        foodRatings.changeRating("ramen", 16); // "ramen" now has a rating of 16.
        foodRatings.highestRated("japanese"); // return "ramen"
        // Both "sushi" and "ramen" have a rating of 16.
        // However, "ramen" is lexicographically smaller than "sushi".
    }

    Map<String, Food> foodMap = new HashMap<>();
    Map<String, TreeSet<Food>> cuisineMap = new HashMap<>();

    public DesignFoodRatingSystem_2353(String[] foods, String[] cuisines, int[] ratings) {
        for (int i = 0; i < foods.length; i++) {
            Food food = new Food(foods[i], cuisines[i], ratings[i]);
            foodMap.put(foods[i], food);
            cuisineMap.computeIfAbsent(cuisines[i], k -> new TreeSet<>(Comparator.reverseOrder())).add(food);
        }
    }

    public void changeRating(String food, int newRating) {
        Food updateFood = foodMap.get(food);
        cuisineMap.get(foodMap.get(food).cuisine).remove(updateFood);
        updateFood.rating = newRating;
        cuisineMap.get(foodMap.get(food).cuisine).add(updateFood);
    }

    public String highestRated(String cuisine) {
        return cuisineMap.get(cuisine).first().food;
    }

    private class Food implements Comparable<Food> {
        private final String food;
        private final String cuisine;
        private int rating;

        public Food(String food, String cuisine, int rating) {
            this.food = food;
            this.cuisine = cuisine;
            this.rating = rating;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Food food1 = (Food) o;
            return Objects.equals(food, food1.food) && Objects.equals(cuisine, food1.cuisine);
        }

        @Override
        public int hashCode() {
            return Objects.hash(food, cuisine);
        }

        @Override
        public int compareTo(Food o) {
            if (this.rating == o.rating) {
                return o.food.compareTo(this.food);
            }
            return this.rating - o.rating;
        }
    }
}
