// class Solution {
//     public int[] findOrder(int numCourses, int[][] prerequisites) {
       
//         Stack<Integer> st=new Stack<>();
//         for (int i=0;i<prerequisites.length;i++){
//             if(prerequisites[i][0]>prerequisites[i][1]){
//                 if(!st.contains(prerequisites[i][1]))
//                 st.add(prerequisites[i][1]);
//                 if(!st.contains(prerequisites[i][0]))
//                 st.add(prerequisites[i][0]);
//             }
//         }

//         int arr[]=new int[st.size()];
//          if(prerequisites==null||prerequisites.length==0) {
//             int[] result = new int[numCourses];
//             for (int i = 0; i < numCourses; i++) {
//                 result[i] = numCourses - 1 - i;  // Reverse order (to match [1, 0] for numCourses=2)
//             }
//             return result;
//          }
//         for(int i=0;i<arr.length;i++){
//             arr[i]=st.pop();
//         }

//         Arrays.sort(arr);

//         if(arr.length==numCourses){
//             return arr;
//         }
//         return new int[0];
        
//     }
// }

import java.util.*;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Step 1: Create an adjacency list to represent the graph
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }
        
        // Step 2: Create an in-degree array to count prerequisites for each course
        int[] inDegree = new int[numCourses];
        
        // Step 3: Build the graph (adjacency list) and in-degree array
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prereq = prerequisite[1];
            adjList.get(prereq).add(course);
            inDegree[course]++;
        }
        
        // Step 4: Initialize a queue with courses that have no prerequisites (in-degree == 0)
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        // Step 5: Perform BFS to process each course in topological order
        int[] courseOrder = new int[numCourses];
        int index = 0;  // Index for courseOrder array
        
        while (!queue.isEmpty()) {
            int currentCourse = queue.poll();
            courseOrder[index++] = currentCourse;
            
            // Step 6: Reduce the in-degree of dependent courses
            for (int nextCourse : adjList.get(currentCourse)) {
                inDegree[nextCourse]--;
                if (inDegree[nextCourse] == 0) {
                    queue.offer(nextCourse);
                }
            }
        }
        
        // Step 7: Check if we were able to process all the courses
        if (index == numCourses) {
            return courseOrder;  // All courses have been processed
        } else {
            return new int[0];  // Cycle detected, it's impossible to finish all courses
        }
    }
}
