import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class UndirectedGraph {
    private int vertices;
    private final List<List<Integer>> adjacencyList;

    public UndirectedGraph(int vertices) {
        setVertices(vertices);

        adjacencyList = IntStream.range(0, vertices)
                .mapToObj(i -> new ArrayList<Integer>())
                .collect(Collectors.toList());
    }

    public void setVertices(int vertices) {
        this.vertices = vertices;
    }

    public void addEdge(int u, int v) {
        adjacencyList.get(u).add(v);
        adjacencyList.get(v).add(u);
    }

    public List<Integer> connectedComponentSizes() {
        boolean[] visited = new boolean[vertices];

        return IntStream.range(0, adjacencyList.size())
                .filter(vertex -> !visited[vertex])
                .mapToObj(vertex -> depthFirstSearch(vertex, visited))
                .collect(Collectors.toList());
    }

    private int depthFirstSearch(int v, boolean[] visited) {
        visited[v] = true;
        int componentSize = 1;

        componentSize += adjacencyList.get(v).stream().filter(neighbor -> !visited[neighbor])
                        .mapToInt(neighbor -> depthFirstSearch(neighbor, visited))
                        .sum();

        return componentSize;
    }
}