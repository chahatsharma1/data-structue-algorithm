import java.util.Objects;

class Packet implements Comparable<Packet> {
    public int source;
    public int destination;
    public int timestamp;

    public Packet(int source, int destination, int timestamp) {
        this.source = source;
        this.destination = destination;
        this.timestamp = timestamp;
    }

    @Override
    public int compareTo(Packet other) {
        if (source != other.source) {
            return Integer.compare(source, other.source);
        }
        if (destination != other.destination) {
            return Integer.compare(destination, other.destination);
        }
        return Integer.compare(timestamp, other.timestamp);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Packet packet = (Packet) o;
        return source == packet.source && destination == packet.destination && timestamp == packet.timestamp;
    }

    @Override
    public int hashCode() {
        return Objects.hash(source, destination, timestamp);
    }
}