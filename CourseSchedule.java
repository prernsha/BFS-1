class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        int[] numDependency = new int[numCourses];
        
        
        for(int i=0; i<prerequisites.length; i++){
            if(!map.containsKey(prerequisites[i][0])){
                map.put(prerequisites[i][0], new ArrayList<>());
            }
            map.get(prerequisites[i][0]).add(prerequisites[i][1]); 
            
            numDependency[prerequisites[i][1]] += 1;
        }
        
        for(int i=0; i<numDependency.length; i++){
            if(numDependency[i] == 0){
                queue.add(i);
            }
        }
        
        if(queue.size() >0){
            return recurse(numDependency,queue,set,map,numCourses);
        }
        
        return false;
    }
    
    public boolean recurse ( int[] numDependency, Queue<Integer> queue, HashSet<Integer> set, HashMap<Integer,ArrayList<Integer>> map , int numCourses){
        
        while(queue.size() > 0){
            int currentCourse = queue.poll();
            set.add(currentCourse);
            if(map.containsKey(currentCourse)){
                ArrayList<Integer> currentDepenList = map.get(currentCourse);
                
                for(Integer c:currentDepenList){
                    numDependency[c] -= 1;
                    
                    if(numDependency[c] == 0){
                        queue.add(c);
                    }
                }
            }
        }
        
        if(set.size() == numCourses){
            return true;
        }
        return false;
    }
}