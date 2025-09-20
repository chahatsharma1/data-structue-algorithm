import java.util.*;

public class Router {
    public Router(int memoryLimit) {
        this.memoryLimit = memoryLimit;
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        Packet packet = new Packet(source, destination, timestamp);
        if (uniquePackets.contains(packet)) {
            return false;
        }
        if (packetQueue.size() == memoryLimit) {
            int[] next = forwardPacket();
        }
        packetQueue.add(packet);
        uniquePackets.add(packet);
        destinationTimestamps.computeIfAbsent(destination, k -> new ArrayList<>()).add(timestamp);
        return true;
    }

    public int[] forwardPacket() {
        if (packetQueue.isEmpty()) {
            return new int[0];
        }
        Packet nextPacket = packetQueue.poll();
        uniquePackets.remove(nextPacket);
        processedPacketIndex.merge(nextPacket.destination, 1, Integer::sum);
        return new int[]{nextPacket.source, nextPacket.destination, nextPacket.timestamp};
    }

    public int getCount(int destination, int startTime, int endTime) {
        if (!destinationTimestamps.containsKey(destination)) {
            return 0;
        }
        List<Integer> timestamps = destinationTimestamps.get(destination);
        int startIndex = processedPacketIndex.getOrDefault(destination, 0);
        int lowerBoundIndex = firstGreaterEqual(timestamps, startIndex, startTime);
        int upperBoundIndex = firstGreater(timestamps, lowerBoundIndex, endTime);
        return upperBoundIndex - lowerBoundIndex;
    }

    private final int memoryLimit;
    private final TreeSet<Packet> uniquePackets = new TreeSet<>();
    private final Queue<Packet> packetQueue = new LinkedList<>();
    private final Map<Integer, List<Integer>> destinationTimestamps = new HashMap<>();
    private final Map<Integer, Integer> processedPacketIndex = new HashMap<>();

    private int firstGreaterEqual(List<Integer> timestamps, int startIndex, int startTime) {
        int left = startIndex;
        int right = timestamps.size();
        while (left < right) {
            final int m = (left + right) / 2;
            if (timestamps.get(m) >= startTime)
                right = m;
            else
                left = m + 1;
        }
        return left;
    }

    private int firstGreater(List<Integer> timestamps, int startIndex, int endTime) {
        int left = startIndex;
        int right = timestamps.size();
        while (left < right) {
            int m = (left + right) / 2;
            if (timestamps.get(m) > endTime) {
                right = m;
            }
            else {
                left = m + 1;
            }
        }
        return left;
    }
}