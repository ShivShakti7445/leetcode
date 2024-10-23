class Solution {
    class Node{
        Node link[]=new Node[2];
        boolean containsKey(int bit){
              return (link[bit]!=null);
        }
        Node get(int bit){
            return link[bit];
        }
        void put(int bit,Node node){
            link[bit]=node;
        }

    }


    class Trie{
      Node root;
      Trie(){
        root=new Node();
      }
      public void insert(int num){
        Node node=root;
        for(int i=31;i>=0;i--){
            int bit=(num>>i)&1;
            if(!node.containsKey(bit)){
               node.put(bit,new Node());
            }
            node=node.get(bit);
        }
      }

      int getMax(int num){
         Node node = root;
           int max=0;
           for(int i=31;i>=0;i--){
            int bit=(num>>i)&1;
            // to check opposite bit
            if(node.containsKey(1-bit)){
                max=max|(1<<i);
                node=node.get(1-bit);
            }
            else{
               node=node.get(bit);
            }  
        }
        return max;
      }

    }


    public int findMaximumXOR(int[] nums) {
        Trie obj=new Trie();

        for(int i:nums){
            obj.insert(i);
        }
        int maxans=0;
        for(int i:nums){
             maxans=Math.max(maxans,obj.getMax(i));
        }
        return maxans;
    }
}