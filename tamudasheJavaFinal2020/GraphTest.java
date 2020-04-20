import java.io.FileNotFoundException;
import java.util.ArrayList;

class GraphTest {
    public static void main(String[] args) throws FileNotFoundException {
        String filePath = "graphTestFile.txt";
        GraphAdjacencyMatrix adjacencyMatrix = new GraphAdjacencyMatrix(filePath);
        
        System.out.println("\nAdjacency matrix\n");
        adjacencyMatrix.PrintDataStructure();

        ArrayList<Integer> A = new ArrayList<>();
        A.add(0);

        if (adjacencyMatrix.IsHamiltonian(A)) {
            System.out.println("This graph has a hamiltonian circuit.");
        } else {
            System.out.println("This graph does not have a hamiltonian circuit.");
        }
    }
}