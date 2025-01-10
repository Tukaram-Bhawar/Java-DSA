import java.util.*;

public class iscycle {
    static class edge{
        int src;
        int dest;
        
        
        public edge(int src, int dest){
            this.src=src;
            this.dest=dest;
        }

        
    }
    public static void createGraph(ArrayList<edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<edge>();
        }

        graph[0].add(new edge(0, 2));
        graph[1].add(new edge(1, 0));
        graph[2].add(new edge(2, 3));
        graph[3].add(new edge(3, 0));
    
    }

    public static boolean isCyclecheck(ArrayList<edge> graph[],boolean visit[], int curr, boolean rec[]){
        visit[curr]=true;
        rec[curr]=true;

        for(int i=0;i<graph[curr].size();i++){
            edge e=graph[curr].get(i);
            if(rec[e.dest]){
                return true;
            }
            if(!visit[e.dest]){
                if(isCyclecheck(graph, visit, e.dest, rec)){
                    return true;
                }
            }
        }
        rec[curr]=false;
        return false;
    }
    public static void main(String[] args){
        int v=4;
        @SuppressWarnings("unchecked")
        ArrayList<edge> graph[]=new ArrayList[v];

        createGraph(graph);
        System.out.println(isCyclecheck(graph, new boolean[v], 0, new boolean[v]));
    }
    
}
