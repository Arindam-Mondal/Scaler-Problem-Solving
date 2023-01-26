package advance.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Course Schedule II
 *
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
 *
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.
 *
 *
 *
 * Example 1:
 *
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: [0,1]
 * Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].
 * Example 2:
 *
 * Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
 * Output: [0,2,1,3]
 * Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
 * So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
 * Example 3:
 *
 * Input: numCourses = 1, prerequisites = []
 * Output: [0]
 *
 *
 * Constraints:
 *
 * 1 <= numCourses <= 2000
 * 0 <= prerequisites.length <= numCourses * (numCourses - 1)
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * ai != bi
 * All the pairs [ai, bi] are distinct.
 *
 */
public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] incomingEdges = new int[numCourses];
        ArrayList<Integer>[] adjList = new ArrayList[numCourses];
        ArrayList<Integer> courseOrder = new ArrayList<>();

        for(int i=0;i<adjList.length;i++){
            adjList[i] = new ArrayList<>();
        }

        for(int i=0;i<prerequisites.length;i++){
            int course = prerequisites[i][0];
            int preCourse = prerequisites[i][1];
            incomingEdges[course] = incomingEdges[course] + 1;
            adjList[preCourse].add(course);
        }

        Queue<Integer> pq = new LinkedList<>();

        for(int i=0;i<incomingEdges.length;i++){
            if(incomingEdges[i] == 0){
                pq.add(i);
            }
        }

        while(!pq.isEmpty()){
            int currCourse = pq.poll();
            courseOrder.add(currCourse);
            for(int adjCourse : adjList[currCourse]){
                incomingEdges[adjCourse] = incomingEdges[adjCourse] - 1;
                if(incomingEdges[adjCourse] == 0){
                    pq.add(adjCourse);
                }
            }
        }

        int[] arr = courseOrder.stream().mapToInt(i -> i).toArray();

        for(int i=0;i<incomingEdges.length;i++){
            if(incomingEdges[i] != 0){
                return new int[0];
            }
        }

        return arr;
    }
}
