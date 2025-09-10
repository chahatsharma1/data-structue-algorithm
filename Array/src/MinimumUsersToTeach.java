import java.util.*;

public class MinimumUsersToTeach {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {

        List<Set<Integer>> userLanguages = new ArrayList<>();
        for (int[] language : languages) {
            Set<Integer> set = new HashSet<>();
            for (int lang : language) {
                set.add(lang);
            }
            userLanguages.add(set);
        }

        Set<Integer> problematicUsers = new HashSet<>();

        for (int[] f : friendships) {
            int u = f[0] - 1;
            int v = f[1] - 1;
            Set<Integer> langsU = userLanguages.get(u);
            Set<Integer> langsV = userLanguages.get(v);

            boolean canCommunicate = false;
            for (int lang : langsU) {
                if (langsV.contains(lang)) {
                    canCommunicate = true;
                    break;
                }
            }

            if (!canCommunicate) {
                problematicUsers.add(u);
                problematicUsers.add(v);
            }
        }

        if (problematicUsers.isEmpty()) {
            return 0;
        }

        int minTeach = Integer.MAX_VALUE;
        for (int lang = 1; lang <= n; lang++) {
            int count = 0;
            for (int user : problematicUsers) {
                if (!userLanguages.get(user).contains(lang)) {
                    count++;
                }
            }
            minTeach = Math.min(minTeach, count);
        }
        
        return minTeach;
    }
}
