import java.util.Arrays;

public class CarFleet {
    public static int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double[][] cars = new double[n][2];

        for(int i = 0; i < n; i++){
            cars[i][0] = position[i];
            cars[i][1] = (double) (target - position[i]) / speed[i];
        }

        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));
        double prevTime = 0;
        int fleet = 0;

        for(int i = 0; i < n; i++){
            double time = cars[i][1];
            if(time > prevTime){
                fleet++;
                prevTime = time;
            }
        }
        return fleet;
    }
}
