import java.util.*;

public class graph {
    static class edge{
        int src;
        int dest;
        int weight;
        
        public edge(int src, int dest, int weight){
            this.src=src;
            this.dest=dest;
            this.weight=weight;
        }

        
    }
    public static void createGraph(ArrayList<edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<edge>();
        }

        graph[0].add(new edge(0, 1, 1));
graph[0].add(new edge(0, 2, 1));
graph[1].add(new edge(1, 0, 1));
graph[1].add(new edge(1, 3, 1));
graph[2].add(new edge(2, 0, 1));

graph[2].add(new edge(2, 4, 1));
graph[3].add(new edge(3, 1, 1));
graph[3].add(new edge(3, 4, 1));
graph[3].add(new edge(3, 5, 1));
graph[4].add(new edge(4, 2, 1));
graph[4].add(new edge(4, 3, 1));
graph[4].add(new edge(4, 5, 1));
graph[5].add(new edge(5, 3, 1));
graph[5].add(new edge(5, 4, 1));
graph[5].add(new edge(5, 6, 1));
graph[5].add(new edge(6, 5, 1));

    
    }

    public static void bfs(ArrayList<edge> graph[], int v,boolean visit[], int start){
        Queue<Integer> q=new LinkedList<>();

        q.add(start);

        while (!q.isEmpty()) {
            int curr=q.remove();
            if(visit[curr]==false){
                System.out.print(curr+" ");
                visit[curr]=true;

                for(int i=0;i<graph[curr].size();i++){
                    edge e=graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }

    }

    public static void dfs(ArrayList<edge> graph[],int curr,boolean visit[]){
        System.out.print(curr+" ");
        visit[curr]=true;

        for(int i=0;i<graph[curr].size();i++){
            edge e=graph[curr].get(i);
            if(visit[e.dest]==false){
                dfs(graph, e.dest, visit);
            }
        }
    }

    public static void findAllPath(ArrayList<edge> graph[],boolean visit[], int curr, String path ,int tar){
        if(curr==tar){
            System.err.println(path);
            return;
        }
        for(int i=0;i<graph[curr].size();i++){
            edge e=graph[curr].get(i);
            if(!visit[e.dest]){
                visit[curr]=true;
                findAllPath(graph, visit, e.dest, path+e.dest, tar);
                visit[curr]=false;
            }
        }
    }
    public static void main(String[] args){
        int v=7;
        @SuppressWarnings("unchecked")
        ArrayList<edge> graph[]=new ArrayList[v];

        createGraph(graph);
        // for(int i=0;i<graph[3].size();i++){
        //     edge e =graph[3].get(i);
        //     System.out.println(e.src+"->"+e.dest+" , "+e.weight);
        // }
        boolean visit[]=new boolean[v];

        // for (int i=0;i< v;i++){
        //     if(visit[i]==false){
        //         bfs(graph, v,visit,i);
        //     }
        // }

        // for (int i=0;i< v;i++){
        //     if(visit[i]==false){
        //         dfs(graph, i, visit);
        //     }
        // }

        findAllPath(graph, visit, 0, "0", 5);
    }
    
}
