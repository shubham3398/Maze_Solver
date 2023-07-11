
package com.mycompany.maze_solver;

import java.util.List;

public class DepthFirst {
    public static boolean searchPath(int[][] maze, int r, int c, List<Integer> path){
        //Base case
        if(maze[c][r] == 9){
            //reached destination
            path.add(r);
            path.add(c);
            return true;
        }
        if(maze[c][r] == 0){
            //mark this cell
            maze[c][r] = 3;
            //move up
            if(searchPath(maze, r-1, c, path)){
                path.add(r);
                path.add(c);
                return true;
            }
            //move right
            if(searchPath(maze, r, c+1, path)){
                path.add(r);
                path.add(c);
                return true;
            }
            //move down
            if(searchPath(maze, r+1, c, path)){
                path.add(r);
                path.add(c);
                return true;
            }
            //move left
            if(searchPath(maze, r, c-1, path)){
                path.add(r);
                path.add(c);
                return true;
            }
        }
        return false;
    }
    
}
