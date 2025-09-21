import java.util.*;

class MovieRentingSystem {
    private final Map<Integer, TreeSet<int[]>> movieToAvailable;
    private final TreeSet<int[]> rentedMovies;
    private final Map<String, Integer> priceMap;

    public MovieRentingSystem(int n, int[][] entries) {
        movieToAvailable = new HashMap<>();
        rentedMovies = new TreeSet<>((a, b) -> {
            if (a[2] != b[2]) {
                return a[2] - b[2];
            }
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });

        priceMap = new HashMap<>();

        for (int[] e : entries) {
            int shop = e[0];
            int movie = e[1];
            int price = e[2];
            priceMap.put(key(shop, movie), price);

            movieToAvailable.putIfAbsent(movie, new TreeSet<>((a, b) -> {
                if (a[1] != b[1]) {
                    return a[1] - b[1];
                }
                return a[0] - b[0];
            }));
            movieToAvailable.get(movie).add(new int[]{shop, price});
        }
    }

    public List<Integer> search(int movie) {
        List<Integer> result = new ArrayList<>();
        if (!movieToAvailable.containsKey(movie)) {
            return result;
        }

        Iterator<int[]> it = movieToAvailable.get(movie).iterator();
        int count = 0;
        while (it.hasNext() && count < 5) {
            result.add(it.next()[0]);
            count++;
        }
        return result;
    }

    public void rent(int shop, int movie) {
        int price = priceMap.get(key(shop, movie));
        movieToAvailable.get(movie).remove(new int[]{shop, price});
        rentedMovies.add(new int[]{shop, movie, price});
    }

    public void drop(int shop, int movie) {
        int price = priceMap.get(key(shop, movie));
        rentedMovies.remove(new int[]{shop, movie, price});
        movieToAvailable.get(movie).add(new int[]{shop, price});
    }

    public List<List<Integer>> report() {
        List<List<Integer>> result = new ArrayList<>();
        Iterator<int[]> it = rentedMovies.iterator();
        int count = 0;
        while (it.hasNext() && count < 5) {
            int[] cur = it.next();
            result.add(Arrays.asList(cur[0], cur[1]));
            count++;
        }
        return result;
    }

    private String key(int shop, int movie) {
        return shop + "#" + movie;
    }
}
