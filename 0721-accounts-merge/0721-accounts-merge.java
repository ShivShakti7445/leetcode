class Solution {
    class DisjointSet {
        List<Integer> parent = new ArrayList<>();
        List<Integer> rank = new ArrayList<>();

        public DisjointSet(int n) {
            for (int i = 0; i <= n; i++) {
                parent.add(i);
                rank.add(0);
            }
        }

        public int findUPar(int node) {
            if (node == parent.get(node)) {
                return node;
            }
            int ulp = findUPar(parent.get(node));
            parent.set(node, ulp);
            return parent.get(node);
        }

        public void unionByRank(int u, int v) {
            int ulp_u = findUPar(u);
            int ulp_v = findUPar(v);
            if (ulp_u == ulp_v) return;

            if (rank.get(ulp_u) < rank.get(ulp_v)) {
                parent.set(ulp_u, ulp_v);
            } else if (rank.get(ulp_v) < rank.get(ulp_u)) {
                parent.set(ulp_v, ulp_u);
            } else {
                parent.set(ulp_v, ulp_u);
                int rankU = rank.get(ulp_u);
                rank.set(ulp_u, rankU + 1);
            }
        }
    }

    // Edge class to represent graph edges
    class Edge implements Comparable<Edge> {
        int src, dest, weight;

        Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.weight = wt;
        }

        // Compare edges based on their weights
        public int compareTo(Edge compareEdge) {
            return this.weight - compareEdge.weight;
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n= accounts.size();
        DisjointSet ds =new  DisjointSet(n); // for self node

        HashMap<String, Integer> mapmailnode= new HashMap<String, Integer> ();
        for(int i=0;i<n;i++){
            for(int j=1;j<accounts.get(i).size();j++){
                String mail= accounts.get(i).get(j);
                if(mapmailnode.containsKey(mail)==false){
                    mapmailnode.put(mail,i);
                }
                else{
                    ds.unionByRank(i,mapmailnode.get(mail));
                }

            }
        }

        ArrayList<String>[] margedmail=new ArrayList[n]; // only merged mail of common user 

        for(int i=0;i<n;i++){
            margedmail[i]=new ArrayList<String>();

        }

        for (Map.Entry<String,Integer> it :mapmailnode.entrySet()){
           String mail= it.getKey();
           int node= ds.findUPar(it.getValue());

           margedmail[node].add(mail);
        }

         List<List<String>> ans =new ArrayList<>();

         for(int i=0;i<n;i++){
            if(margedmail[i].size()==0) continue;

            Collections.sort(margedmail[i]);
            List<String>temp=new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            for( String it: margedmail[i]){
                temp.add(it);
            }
            ans.add(temp);
         }
         return ans;
    }
}