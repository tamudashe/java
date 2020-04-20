import java.util.ArrayList;
import java.util.HashSet;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;

public class GraphAdjacencyMatrix extends Graph {
    private ArrayList<ArrayList<Integer>> adjacencyMatrix;
    private String[] vertices;

    public GraphAdjacencyMatrix(String inputFilePath) throws FileNotFoundException {
        adjacencyMatrix = new ArrayList<ArrayList<Integer>>();

        File file = new File(inputFilePath);
        Scanner scannedFile = new Scanner(file);

        // add all vertices to an array
        String list_of_vertices = scannedFile.nextLine();
        vertices = list_of_vertices.split(",");

        // add the adjacency matrix to an ArrayList
        while (scannedFile.hasNextLine()) {
            String currentLine = scannedFile.nextLine();
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = 0; i < currentLine.length(); i++) {
                temp.add((currentLine.charAt(i) - '0'));
            }
            adjacencyMatrix.add(temp);
        }

        // close the scanner
        scannedFile.close();
    }

    @Override
    public boolean isNeighbor(int i, int j) {
        // returns "true" if vertex i and j are neighbors, otherwise, returns "false".
        int isConnected = adjacencyMatrix.get(i).get(j);
        if (isConnected == 1)
            return true;
        else
            return false;
    }

    @Override
    public Set<Integer> neighborList(int i) {
        // returns the neighbors of vertex i as an ArrayList.
        Set<Integer> neighborsList = new HashSet<>();
        for (int j = 0; j < adjacencyMatrix.get(i).size(); j++) {
            if (adjacencyMatrix.get(i).get(j) == 1) {
                neighborsList.add(j);
            }
        }
        return neighborsList;
    }

    @Override
    public void PrintDataStructure() {
        for (int i = 0; i < adjacencyMatrix.size(); i++) {
            for (int j = 0; j < adjacencyMatrix.get(i).size(); j++) {
                System.out.print(adjacencyMatrix.get(i).get(j) + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // check if the graph has a hamiltonian circuit
    public boolean IsHamiltonian(ArrayList<Integer> A) {
        Set<Integer> set_a = new HashSet<>();
        int n = vertices.length;

        for (int element : A) {
            set_a.add(element);
        }

        int v_first = A.get(0);
        int v_last = A.get(A.size() - 1);

        if (A.size() == n && isNeighbor(v_first, v_last)) {
            System.out.println(A);
            return true;
        }

        Set<Integer> B = neighborList(v_last);

        if (B.isEmpty()) {
            return false;
        }
        // Set C = B – A
        Set<Integer> C = setMinus(B, set_a);

        if (C.isEmpty()) {
            return false;
        }

        for (int v : C) {
            ArrayList<Integer> a_with_v = new ArrayList<>();
            for (int element : A) {
                a_with_v.add(element);
            }
            a_with_v.add(v);
            Boolean result = IsHamiltonian(a_with_v);

            if (result == true) {
                return true;
            }
        }
        return false;
    }

    // returns the values that are in A but not in B
    public static Set<Integer> setMinus(Set<Integer> A, Set<Integer> B) {
        Set<Integer> C = new HashSet<Integer>();
        HashSet<Integer> tempBHashSet = new HashSet<Integer>();

        for (Integer element : B) {
            tempBHashSet.add(element);
        }

        for (Integer element : A) {
            if (!tempBHashSet.contains(element)) {
                C.add(element);
            }
        }
        return C;
    }
}