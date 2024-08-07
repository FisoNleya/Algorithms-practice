package graphs1;

import java.util.List;

public class Vertex<T> {

    public Vertex(T value, List<Vertex<T>> neighbours){
        this.value = value;
        this.neighbours = neighbours;
    }

    private T value;
    private boolean visited;
    private List<Vertex<T>> neighbours;


    public void setValue(T value){
        this.value = value;
    }

    public void setVisited(boolean visited){
        this.visited = visited;
    }

    public T getValue() {
        return value;
    }

    public boolean visited() {
        return visited;
    }

    public void setNeighbours(List<Vertex<T>> neighbours){
        this.neighbours = neighbours;
    }

    public List<Vertex<T>> getNeighbours(){
        return neighbours;
    }

}
