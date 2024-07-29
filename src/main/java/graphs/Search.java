package graphs;

import java.util.*;

public class Search {


    public static void main(String[] args) {

                /*
        o         1

        3         2       4
        */

        Graph g = new Graph(5);
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(2,3);
        g.addEdge(3,0);
        g.addEdge(2,4);
        g.printGraph();

        breathFirstSearch(g);
        System.out.println("----------------------------------------------");
        depthFirstSearch(g);
    }


    public static void breathFirstSearch(Graph g){
        Queue<Integer> que = new LinkedList<Integer>();

        int start = 0;
        Set<Integer> visited = new HashSet<>();
        visited.add(start);

        que.add(start);

        while (!que.isEmpty()){
            int cur = que.poll();
            System.out.println(cur);
            for (int i = 0 ; i < g.adjVetex[cur].size(); i++){

                if(visited.add(g.adjVetex[cur].get(i))){
                    que.offer(g.adjVetex[cur].get(i));
                }

            }

        }

    }



    public static void depthFirstSearch(Graph g){
        Stack<Integer> stack =  new Stack<>();

        int start = 0;
        Set<Integer> visited = new HashSet<>();
        visited.add(start);

        stack.add(start);

        while (!stack.isEmpty()){
            int cur = stack.pop();
            System.out.println(cur);
            for (int i = 0 ; i < g.adjVetex[cur].size(); i++){

                if(visited.add(g.adjVetex[cur].get(i))){
                    stack.push(g.adjVetex[cur].get(i));
                }

            }

        }

    }
}
