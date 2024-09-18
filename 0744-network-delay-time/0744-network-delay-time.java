class Solution {
    class pair{
        int first ,second;
        pair(int first,int second){
            this.first=first;
            this.second=second;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<pair>> adj=new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<times.length;i++){
            adj.get(times[i][0]-1).add(new pair (times[i][1]-1,times[i][2]));
        }

        Queue<pair> q=new LinkedList<>();
        q.add(new pair(k-1,0));//node time

        int time[]=new int[n];
        Arrays.fill(time,(int)1e9);
        time[k-1]=0;

        while(!q.isEmpty()){
            pair pr=q.poll();
            int node=pr.first;
            int ti=pr.second; 

            for(pair curr:adj.get(node))  {
                int adjnode=curr.first;
                int adjtime=curr.second;

                if(ti+adjtime<time[adjnode]){
                   time[adjnode]= ti+adjtime;
                   q.add(new pair(adjnode,time[adjnode]));
                }
            } 
        }
        int maxTime = 0;
        for(int i=0;i<n;i++){
            if(time[i]==(int)1e9){
                return -1;
            }
           maxTime = Math.max(maxTime, time[i]); 
        }

        return maxTime;
    }
}