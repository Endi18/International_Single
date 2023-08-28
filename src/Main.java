import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/Files/input05.txt"));

        String[] firstLine = scanner.nextLine().split(" ");
        int numberOfArtists = Integer.parseInt(firstLine[0]);
        int edges  = Integer.parseInt(firstLine[1]);

        UndirectedGraph undirectedGraph = new UndirectedGraph(numberOfArtists);

        IntStream.range(0, edges)
                .mapToObj(i -> scanner.nextLine().split(" "))
                .forEach(edgesPart -> undirectedGraph.addEdge(Integer.parseInt(edgesPart[0]), Integer.parseInt(edgesPart[1])
                ));

        List<Integer> components = undirectedGraph.connectedComponentSizes();

        System.out.println("All possible artist combinations are: " + calculateSumOfCombinations(numberOfArtists, components));
    }

    public static int calculateSumOfCombinations(int totalVertices, List<Integer> arrayList) {
        int sum = 0;

        int remainingVertices = totalVertices;

        for (int componentSize : arrayList) {
            sum += componentSize * (remainingVertices - componentSize);
            remainingVertices = remainingVertices - componentSize;
        }

        return sum;
    }
}