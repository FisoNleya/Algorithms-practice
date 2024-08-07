package graphs1;

import java.util.*;

public class Search {

    public static void main(String[] args) {

        /*
         *               2
         *
         *        4            3
         *
         *    6     7         5      9
         * */

        Vertex<Integer> six = new Vertex<>(6, Collections.emptyList());
        Vertex<Integer> seven = new Vertex<>(7, Collections.emptyList());

        Vertex<Integer> five = new Vertex<>(5, Collections.emptyList());
        Vertex<Integer> nine = new Vertex<>(9, Collections.emptyList());

        Vertex<Integer> four = new Vertex<>(4, List.of(seven, six));
        Vertex<Integer> three = new Vertex<>(3, List.of(nine, five));


        Vertex<Integer> two = new Vertex<>(2, List.of(three, four));
//        depthFirstSearch(two);
        depthFirstSearchRecursive(two);

    }


    /**
    *Depth first search using recursion
    *
    *
    * */
    public static void depthFirstSearchRecursive(Vertex<Integer> current) {


        Stack<Vertex<Integer>> stack = new Stack();

        System.out.println(current.getValue());
        current.setVisited(true);

        current.getNeighbours().forEach(v -> {
            if (!v.visited()) {
                stack.push(v);
            }
        });


        while (!stack.isEmpty()) {
            Vertex<Integer> neighbour = stack.pop();
            depthFirstSearchRecursive(neighbour);
        }

    }


    /**
     *Depth first
     * Use of either stack or queue also depends on the creation of the graph edges
     *To be revisited
     * */
    public static void depthFirstSearch(Vertex<Integer> root) {


        Stack<Vertex<Integer>> valueStack = new Stack<>();
        valueStack.add(root);


        while (!valueStack.isEmpty()) {
            Vertex<Integer> current = valueStack.pop();

            System.out.println(current.getValue());
            current.setVisited(true);


            current.getNeighbours().forEach(v -> {
                if (!v.visited()) {
                    valueStack.push(v);
                }

            });



        }


    }


}
