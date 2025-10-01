import java.util.*;
public class graph {
    static class Edge{
        int src;
        int dest;
        //int wt;
        public Edge(int s,int d){
            this.src=s;
            this.dest=d;
            //this.wt=weight;
        }
    }
    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0,2));
        graph[1].add(new Edge(1,2));
        graph[1].add(new Edge(1,3));
        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,3));
        graph[2].add(new Edge(2,1));
        graph[3].add(new Edge(3,2));
        graph[3].add(new Edge(3,1));
    }
    public static void DFS(ArrayList<Edge> graph[],boolean vis[],int cur){
        System.out.print(cur+" ");
        vis[cur]=true;
        for(int i=0;i<graph[cur].size();i++){
            Edge e = graph[cur].get(i);
            if(vis[e.dest]==false){
                DFS(graph,vis,e.dest);
            }
        }
    }
    public static void BFS(ArrayList<Edge> graph[],int V){
        Queue<Integer> q = new LinkedList<>();
        boolean vis[]=new boolean[V];
        q.add(0);
        while(!q.isEmpty()){
            int cur=q.remove();
            if(vis[cur]==false){
                System.out.print(cur+" ");
                vis[cur]=true;
                for(int i=0;i<graph[cur].size();i++){
                     Edge e=graph[cur].get(i);
                     q.add(e.dest);
                }
            }
        }
    }
    public static void AllPath(ArrayList<Edge> graph[],boolean vis[],int cur,String path,int tar){
        if(cur==tar){
            System.out.println(path);
            return;
        }
        for(int i=0;i<graph[cur].size();i++){
            Edge e = graph[cur].get(i);
            if(vis[e.dest]==false){
                vis[cur]=true;
                AllPath(graph,vis,e.dest,path+e.dest,tar);
                vis[cur]=false;
            }
        }
    }
    public static void main(String[]args){
        int V=4;
        ArrayList<Edge> graph[]=new ArrayList[V];
        createGraph(graph);
        // for(int i=0;i<graph[2].size();i++){
        //     Edge e = graph[2].get(i);
        //     System.out.println(e.src+" "+e.dest);
        // }
        //BFS(graph,V);
        boolean vis[]=new boolean[V];
        //DFS(graph,vis,0);
        AllPath(graph,vis,0,"0",3);
        
    }
}
