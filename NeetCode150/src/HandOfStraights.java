import java.util.TreeMap;

public class HandOfStraights {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0){
            return false;
        }

        TreeMap<Integer, Integer> map = new TreeMap<>();

        for(int num : hand){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        while (!map.isEmpty()){
            int first = map.firstKey();
            for(int i = 0; i < groupSize; i++){
                int nextCard = first + i;

                if (!map.containsKey(nextCard)){
                    return false;
                }

                map.put(nextCard, map.get(nextCard) - 1);
                if (map.get(nextCard) == 0){
                    map.remove(nextCard);
                }
            }
        }
        return true;
    }
}
