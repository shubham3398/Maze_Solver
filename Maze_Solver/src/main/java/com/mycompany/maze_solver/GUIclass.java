
package com.mycompany.maze_solver;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;


public class GUIclass extends JFrame{
    
    private int[][] maze = {
        {1,1,1,1,1,1,1,1,1,1,1,1},
        {1,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,0,1,0,1,1,0,0,0,0,1},
        {1,0,0,1,0,0,0,0,0,0,0,1},
        {1,0,0,1,1,0,0,0,1,0,0,1},
        {1,0,0,0,0,0,0,0,1,0,0,1},
        {1,0,1,1,1,1,0,0,0,0,9,1},
        {1,0,0,0,0,0,0,0,0,0,0,1},
        {1,1,1,1,1,1,1,1,1,1,1,1}
    };
    
    //store cordinate of path
    List<Integer> path = new ArrayList<>();
    //constrcutor
    GUIclass(){
        //set the window title
        setTitle("Maze Solver");
        setSize(640,720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DepthFirst.searchPath(maze, 1, 1, path);//stored the cordinates of path
        //System.out.print(path);
    }
    
    @Override
    public void paint(Graphics g){
        g.translate(80, 80);//translate the origin
        
        //color the each cell of maze
        for(int i = 0; i < maze.length; i++){
            for(int j = 0; j < maze[0].length; j++){
                Color color;
                //now assign the color 
                switch(maze[i][j]){
                    case 1 : color = Color.BLACK; break;
                    case 9 : color = Color.RED; break;
                    default : color = Color.WHITE;
                }
                g.setColor(color);
                g.fillRect(30*j, 30*i, 30, 30);
                g.setColor(Color.RED);
                g.drawRect(30*j, 30*i, 30, 30);
            }
        }
        int sourceX = 1;
        int sourceY = 1;
        g.setColor(Color.GREEN);
        g.fillRect(30*sourceX, 30*sourceY, 30, 30);
        //paint the path
        for(int i = 0; i < path.size(); i += 2){
            int xCordinate = path.get(i);
            int yCordinate = path.get(i+1);
            
            g.setColor(Color.BLUE);
            g.fillRect(30*xCordinate, 30*yCordinate, 20, 20);
        }
        
    }
    
    //main method
    public static void main(String[] args){
        GUIclass view = new GUIclass();
        view.setVisible(true);
    }
}
