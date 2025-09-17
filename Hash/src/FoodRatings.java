import java.util.*;

public class FoodRatings {
    private final Map<String, Integer> foodRating;
    private final Map<String, String> foodCuisine;
    private final Map<String, PriorityQueue<Food>> cuisineFoods;

    private static class Food {
        String name;
        int rating;

        Food(String name, int rating) {
            this.name = name;
            this.rating = rating;
        }
    }

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodRating = new HashMap<>();
        foodCuisine = new HashMap<>();
        cuisineFoods = new HashMap<>();

        for (int i = 0; i < foods.length; i++) {
            String food = foods[i];
            String cuisine = cuisines[i];
            int rating = ratings[i];

            foodRating.put(food, rating);
            foodCuisine.put(food, cuisine);

            cuisineFoods.putIfAbsent(cuisine, new PriorityQueue<>(
                (a, b) -> a.rating == b.rating ? a.name.compareTo(b.name) : b.rating - a.rating
            ));

            cuisineFoods.get(cuisine).offer(new Food(food, rating));
        }
    }

    public void changeRating(String food, int newRating) {
        foodRating.put(food, newRating);
        String cuisine = foodCuisine.get(food);

        cuisineFoods.get(cuisine).offer(new Food(food, newRating));
    }

    public String highestRated(String cuisine) {
        PriorityQueue<Food> pq = cuisineFoods.get(cuisine);

        while (true) {
            Food top = pq.peek();
            if (top.rating == foodRating.get(top.name)) {
                return top.name;
            }
            pq.poll();
        }
    }
}
