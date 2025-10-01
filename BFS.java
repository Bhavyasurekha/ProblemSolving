import java.util.*;

public class BFS {
    public static class Edge{
        int src;
        int dest;
        public Edge(int s,int d){
            this.src=s;
            this.dest=d;
        }
    }
    public static void creategraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));
        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,3));
        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,4));
        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,4));
        graph[3].add(new Edge(3,5));
        graph[4].add(new Edge(4,2));
        graph[4].add(new Edge(4,3));
        graph[4].add(new Edge(4,5));
        graph[5].add(new Edge(5,3));
        graph[5].add(new Edge(5,4));
        graph[5].add(new Edge(5,6));

    }
    public static void bfstraversal(ArrayList<Edge> graph[],int V){
        Queue<Integer> q = new LinkedList<>();
        boolean visited[]=new boolean[V];
        q.add(0);
        while(!q.isEmpty()){
            int cur=q.remove();
            if(visited[cur]==false){
                 System.out.print(cur+" ");
                 visited[cur]=true;
                 for(int i=0;i<graph[cur].size();i++){
                    Edge e= (graph[cur].get(i));
                    q.add(e.dest);
                 }
            }
        }
    }
    public static void dfstraversal(ArrayList<Edge> graph[],int cur,int V,boolean vis[]){
        System.out.print(cur+" ");
        vis[cur]=true;
        for(int i=0;i<graph[cur].size();i++){
            Edge e= graph[cur].get(i);
            if(vis[e.dest]==false){
                 dfstraversal(graph, e.dest, V, vis);
            }
        }
    }
    public static void allpath(ArrayList<Edge> graph[],int curr,int tar,String path,boolean vis[]){
        if(curr==tar){
            System.out.println(path);
            return ;
        }
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(!vis[e.dest]){
                vis[curr]=true;
                allpath(graph, e.dest, tar, path+e.dest, vis);
                vis[curr]=false;
            }
        }
    }
    public static boolean detectcycle(ArrayList<Edge> graph[],int cur,boolean vis[],boolean recr[]){
        vis[cur]=true;
        recr[cur]=true;
        for(int i=0;i<graph[cur].size();i++){
            Edge e = graph[cur].get(i);
            if(!recr[e.dest]){
                return true;
            }else if(!vis[e.dest]){
                detectcycle(graph, e.dest, vis, recr);
            }
        }
        recr[cur]=false; 
        return false;

    }
     public static void topologi(ArrayList<Edge> graph[],int cur,boolean vis[],Stack<Integer> st){
            vis[cur]=true;
            for(int i=0;i<graph[cur].size();i++){
                Edge e =graph[cur].get(i);
                if(!vis[cur]){
                    topologi(graph,e.dest,vis,st);
                }
            }
            st.push(cur);
    }
    public static void main(String[]args){
        int V=7;
        ArrayList<Edge> graph[]=new ArrayList[V];
        creategraph(graph);
        // bfstraversal(graph, V);
        boolean vis[]=new boolean[V];
        //dfstraversal(graph, 0, V, vis);
        // allpath(graph, 0, 5, "0", vis);
        // boolean recr[]=new boolean[V];
        // System.out.print(detectcycle(graph, 0, vis, recr));
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<V;i++){
            topologi(graph, i, vis, st);
        }
        while(!st.isEmpty()){
            System.out.print(st.pop()+" ");
        }
        
    }

}
