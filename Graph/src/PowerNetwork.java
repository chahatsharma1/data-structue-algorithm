import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class PowerNetwork {
    private Map<Integer, List<Integer>> connections;
    private Map<Integer, Station> stations;

    public PowerNetwork() {
        this.connections = new HashMap<>();
        this.stations = new HashMap<>();
    }

    public void addStation(int id, Station station) {
        this.stations.put(id, station);
        this.connections.put(id, new ArrayList<>());
    }

    public void addConnection(int u, int v) {
        this.connections.get(u).add(v);
        this.connections.get(v).add(u);
    }

    public Station getStation(int id) {
        return this.stations.get(id);
    }

    public List<Integer> getNeighbors(int id) {
        return this.connections.get(id);
    }
}