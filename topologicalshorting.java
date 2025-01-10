import java.util.ArrayList;
import java.util.Stack;

public class topologicalshorting {
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
        // directed graph
        // graph[2].add(new edge(2, 3));
        // graph[3].add(new edge(3, 1));
        // graph[4].add(new edge(4, 0));
        // graph[4].add(new edge(4, 1));
        // graph[5].add(new edge(5, 0));
        // graph[5].add(new edge(5, 1));

        //undirected geaph
    
        graph[0].add(new edge(0, 1));
        graph[0].add(new edge(0, 4));

        graph[1].add(new edge(1, 0));
        graph[1].add(new edge(1,2));
        // graph[1].add(new edge(1, 4));

        graph[2].add(new edge(2, 1));
        graph[2].add(new edge(2, 3));

        graph[3].add(new edge(3, 2));

        graph[4].add(new edge(4, 0));
        // graph[4].add(new edge(4, 1));
        graph[4].add(new edge(4, 5));

        graph[5].add(new edge(5, 4));
    }


    public static void topshort(ArrayList<edge> graph[],int curr,boolean visit[],Stack<Integer> stack){
        visit[curr]=true;

        for(int i=0;i<graph[curr].size();i++){
            edge e=graph[curr].get(i);
            if(!visit[e.dest]){
                topshort(graph, e.dest, visit, stack);
            }
        }   
        stack.push(curr);
    }

    public static void ptopstac(ArrayList<edge> graph[], int v){
        boolean visit[]=new boolean[v];
        Stack<Integer> stack=new Stack<>(); 
        for(int i=0;i<v;i++){
            if(!visit[i]){
                topshort(graph, i, visit, stack);
            }
        }

        while (!stack.isEmpty()) {
            System.err.print(stack.pop()+ " ");
        }
    }


    public static boolean iscycleundirecte(ArrayList<edge> graph[], boolean visit[], int curr,int parent){
        visit[curr]=true;

        for(int i=0;i<graph[curr].size();i++){
            edge e=graph[curr].get(i);
            if(visit[e.dest] && e.dest!=parent){
                return true;
            }
            else if(!visit[e.dest]){
                if(iscycleundirecte(graph, visit, e.dest, curr)){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int v=6;
        @SuppressWarnings("unchecked")
        ArrayList<edge> graph[]=new ArrayList[v];

        createGraph(graph);
        // ptopstac(graph, v);

        boolean visit[]=new boolean[v];
        System.out.println(iscycleundirecte(graph, visit, 0, -1));
        
        
    }
}
