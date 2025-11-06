import java.util.*;

public class PowerGridMaintenance {
    private void assignGrid(Station station, int gridId, PriorityQueue<Integer> gridStations, PowerNetwork network) {
        station.gridId = gridId;
        gridStations.add(station.id);
        for (int neighborId : network.getNeighbors(station.id)) {
            Station neighbor = network.getStation(neighborId);
            if (neighbor.gridId == -1) {
                assignGrid(neighbor, gridId, gridStations, network);
            }
        }
    }

    public int[] processQueries(int c, int[][] cables, int[][] queries) {
        PowerNetwork network = new PowerNetwork();

        for (int i = 1; i <= c; i++) {
            network.addStation(i, new Station(i));
        }

        for (int[] cable : cables) {
            network.addConnection(cable[0], cable[1]);
        }

        List<PriorityQueue<Integer>> grids = new ArrayList<>();
        int currentGridId = 0;

        for (int i = 1; i <= c; i++) {
            Station station = network.getStation(i);
            if (station.gridId == -1) {
                PriorityQueue<Integer> gridStations = new PriorityQueue<>();
                assignGrid(station, currentGridId, gridStations, network);
                grids.add(gridStations);
                currentGridId++;
            }
        }

        List<Integer> results = new ArrayList<>();

        for (int[] query : queries) {
            int type = query[0];
            int x = query[1];
            Station station = network.getStation(x);

            if (type == 1) {
                if (!station.isOffline) {
                    results.add(x);
                } else {
                    PriorityQueue<Integer> gridStations = grids.get(station.gridId);
                    while (
                        !gridStations.isEmpty() &&
                        network.getStation(gridStations.peek()).isOffline
                    ) {
                        gridStations.poll();
                    }
                    results.add(gridStations.isEmpty() ? -1 : gridStations.peek());
                }
            } else if (type == 2) {
                station.isOffline = true;
            }
        }
        return results.stream().mapToInt(Integer::intValue).toArray();
    }
}