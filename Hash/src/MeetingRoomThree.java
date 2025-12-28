import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomThree {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (Comparator.comparingInt(a -> a[0])));

        PriorityQueue<Integer> availableRoom = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            availableRoom.offer(i);
        }

        PriorityQueue<long[]> occupiedRoom = new PriorityQueue<>((a, b) -> {
            if(a[0] != b[0]) {
                return Long.compare(a[0], b[0]);
            }
            return Long.compare(a[1], b[1]);
        });

        int[] count = new int[n];

        for(int[] meeting : meetings){
            int start = meeting[0];
            int end = meeting[1];


            while (!occupiedRoom.isEmpty() && occupiedRoom.peek()[0] <= start){
                availableRoom.offer((int) occupiedRoom.poll()[1]);
            }
            if(!availableRoom.isEmpty()){
                int room = availableRoom.poll();
                count[room]++;
                occupiedRoom.offer(new long[]{end, room});
            } else {
                long[] earliestAvailableRoom = occupiedRoom.poll();
                long availableAt = earliestAvailableRoom[0];
                int room = (int) earliestAvailableRoom[1];
                long newEnd = availableAt + (end - start);
                count[room]++;
                occupiedRoom.offer(new long[]{newEnd, room});
            }
        }
        int max = 0;
        int room = 0;
        for (int i = 0; i < n; i++) {
            if (count[i] > max){
                max = count[i];
                room = i;
            }
        }
        return room;
    }
}