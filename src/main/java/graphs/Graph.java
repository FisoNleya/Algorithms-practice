package graphs;

import java.util.LinkedList;

public class Graph {

     public LinkedList<Integer>[] adjVetex;

    int V;
    int E;

    Graph(int numberOfV){
        adjVetex = new LinkedList[numberOfV];

        this.V = numberOfV;

        for(int i = 0; i < numberOfV; i++){
            adjVetex[i] = new LinkedList<>();
        }
    }


    public void addEdge(int v , int u){
        adjVetex[v].add(u);
        adjVetex[u].add(v);
        E++;
    }


    public void printGraph(){

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < adjVetex.length; i++){
            sb.append("v").append(i).append("->");

            for(int j = 0; j < adjVetex[i].size(); j++){
                sb.append(adjVetex[i].get(j));
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }


    public static void main(String[] args) {

        /*
        o         1

        3         2
        */

        Graph g = new Graph(4);
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(2,3);
        g.addEdge(3,0);

        g.printGraph();
    }
}
