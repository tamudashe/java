import java.util.Set;

public abstract class Graph {
    // returns "true" if vertex i and j are neighbors, otherwise, returns "false".
    public abstract boolean isNeighbor(int i, int j);

    // returns the neighbors of vertex i as an ArrayList.
    public abstract Set<Integer> neighborList(int i);

    // prints out the given data structure
    public abstract void PrintDataStructure();
}