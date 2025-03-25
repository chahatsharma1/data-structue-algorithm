import java.util.*;

public class GeneticMutation {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> set = new HashSet<>(Arrays.asList(bank));
        if (!set.contains(endGene)){
            return -1;
        }

        char[] differentChar = {'A', 'C', 'G', 'T'};
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(startGene);
        set.add(startGene);
        int count = 0;

        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                String current = queue.poll();
                if (current.equals(endGene)){
                    return count;
                }

                char[] currentArray = current.toCharArray();
                for (int j = 0; j < currentArray.length; j++) {
                    char currentChar = currentArray[j];

                    for (char ch : differentChar){
                        if (ch == currentChar){
                            continue;
                        }
                        currentArray[j] = ch;
                        String newMutation = new String(currentArray);

                        if (set.contains(newMutation) && !visited.contains(newMutation)){
                            queue.offer(newMutation);
                            visited.add(newMutation);
                        }
                    }
                    currentArray[j] = currentChar;
                }
            }
            count++;
        }
        return -1;
    }
}
