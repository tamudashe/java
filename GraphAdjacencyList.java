import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GraphAdjacencyList extends Graph {
    private ArrayList<ArrayList<Integer>> adjacencyList;

    public GraphAdjacencyList(String inputFilePath) throws FileNotFoundException {
        adjacencyList = new ArrayList<ArrayList<Integer>>();

        // read from file
        File file = new File(inputFilePath);
        // read line by line in file
        Scanner scannedFile = new Scanner(file);

        // skip the first line since it contains the vertex number
        scannedFile.nextLine();

        while (scannedFile.hasNextLine()) {
            String currentLine = scannedFile.nextLine();
            ArrayList<Integer> temp = new ArrayList<Integer>();
            for (int i = 0; i < currentLine.length(); i++) {
                if (currentLine.charAt(i) - '0' == 1)
                    temp.add(i);
            }
            adjacencyList.add(temp);
        }

        // close the currently oppended file
        scannedFile.close();
    }

    @Override
    public boolean isNeighbor(int i, int j) {
        // returns "true" if vertex i and j are neighbors, otherwise, returns "false".
        for (int k = 0; k < adjacencyList.get(i).size(); k++) {
            if (adjacencyList.get(i).get(k) == j)
                return true;
        }
        return false;
    }

    @Override
    public ArrayList<Integer> neighborList(int i) {
        // returns the neighbors of vertex i as an ArrayList.
        return adjacencyList.get(i);
    }

    @Override
    public void PrintDataStructure() {
        for (int i = 0; i < adjacencyList.size(); i++) {
            System.out.print(i + ":");
            for (int j = 0; j < adjacencyList.get(i).size(); j++)
                System.out.print(adjacencyList.get(i).get(j) + " ");
            System.out.println();
        }
    };
}