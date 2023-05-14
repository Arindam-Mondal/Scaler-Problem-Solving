package advance.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Course Schedule
 *
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
 *
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return true if you can finish all courses. Otherwise, return false.
 *
 *
 *
 * Example 1:
 *
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0. So it is possible.
 * Example 2:
 *
 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 *
 *
 * Constraints:
 *
 * 1 <= numCourses <= 2000
 * 0 <= prerequisites.length <= 5000
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * All the pairs prerequisites[i] are unique.
 */
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] incomingEdges = new int[numCourses];
        ArrayList<Integer>[] adjList = new ArrayList[numCourses];

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
            for(int adjCourse : adjList[currCourse]){
                incomingEdges[adjCourse] = incomingEdges[adjCourse] - 1;
                if(incomingEdges[adjCourse] == 0){
                    pq.add(adjCourse);
                }
            }
        }
        for(int i=0;i<incomingEdges.length;i++){
            if(incomingEdges[i] != 0){
                return false;
            }
        }
        return true;
    }
}
