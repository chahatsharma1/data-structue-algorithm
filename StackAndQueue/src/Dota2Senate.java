import java.util.LinkedList;
import java.util.Queue;

public class Dota2Senate {
    public String predictPartyVictory(String senate) {
        Queue<Integer> radiantQueue = new LinkedList<>();
        Queue<Integer> direQueue = new LinkedList<>();

        for (int i = 0; i < senate.length(); i++){
            if (senate.charAt(i) == 'R'){
                radiantQueue.offer(i);
            } else {
                direQueue.offer(i);
            }
        }

        while (!radiantQueue.isEmpty() && !direQueue.isEmpty()){
            int radiantIndex = radiantQueue.poll();
            int direIndex = direQueue.poll();

            if (radiantIndex < direIndex){
                radiantQueue.offer(radiantIndex + senate.length());
            } else {
                direQueue.offer(direIndex + senate.length());
            }
        }
        return radiantQueue.isEmpty() ? "Dire" : "Radiant";
    }
}
