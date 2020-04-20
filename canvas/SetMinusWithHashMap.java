import java.util.*;

class SetMinusWithHashMap {
    public static void main(String[] args) {
        Set<Integer> A = new HashSet<Integer>();
        Set<Integer> B = new HashSet<Integer>();

        A.add(11);
        A.add(12);
        A.add(13);
        A.add(14);
        A.add(15);

        B.add(11);
        B.add(12);
        B.add(13);
        B.add(14);
        B.add(15);

        System.out.println("A - B = " + HashMapSetMinus(A, B));
    }

    public static Set<Integer> HashMapSetMinus(Set<Integer> A, Set<Integer> B) {
        HashMap<Integer, Integer> temp = new HashMap<Integer, Integer>();
        Set<Integer> C = new HashSet<Integer>();

        for (Integer item : B) {
            temp.put(item, 0);
        }

        for (Integer item : A) {
            if (!temp.containsKey(item)) {
                C.add(item);
            }
        }
        return C;
    }
}