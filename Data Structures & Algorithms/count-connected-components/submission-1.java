class Solution {
    public int countComponents(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> graph = create_graph(n,edges);

        int count = 0; 
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++){
            if (!visited[i]){
                count++;
                dfs_traversal(i,graph,visited);
            }
        }
        return count;
    }

    public ArrayList<ArrayList<Integer>> create_graph(int n, int [][] edges){
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0 ; i < n; i++){
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        return graph;
    }

    pubic void dfs_traversal(int start, ArrayList<ArrayList<Integer>> graph, boolean[] visited){
        Stack<Integer> st = new Stack<>();
        st.push(start);

        while (!st.isEmpty()){
            int current = st.pop();

            if (!visited[current]){
                visited[current] = true;

                ArrayList<Integer> neighbors = graph.get(current);

                for (int i = 0 ; i < neighbors.size(); i++){
                    int next = neighbors.get(i);

                    if (!visited[next]){
                        st.push(next);
                    }
                }
            }
        }
    }
}
