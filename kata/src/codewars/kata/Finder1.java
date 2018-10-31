package codewars.kata;

import java.awt.Point;
import java.util.HashSet;

public class Finder1 {
    
    static char[][] map;
    static int max;
    
    static boolean pathFinder(String maze) {
        max = maze.indexOf("\n");
        if (max == -1)
          max = 1;
        String mazeClean = maze.replaceAll("\n", "");
        map = new char[max][max];

        for (int i=0; i< mazeClean.length();i++) {
            map[i%max][i/max] = mazeClean.charAt(i);
        }
        
        return accessible(0,0,new HashSet<Point>());
    }
    
    static boolean accessible(int x, int y, HashSet<Point> dejaPass){
      if (x==max-1 && y == max-1 ){
            return (map[x][y] != 'W');
      }
      dejaPass.add(new Point(x,y));
      HashSet<Point> newDejaPass = new HashSet<Point>(dejaPass);
      boolean result = false; 
      if (x<max-1 && !dejaPass.contains(new Point(x+1,y)) && map[x+1][y] != 'W' && accessible(x+1,y,newDejaPass)){
        result = true;
      }
      if (!result && x>0 && !dejaPass.contains(new Point(x-1,y)) && map[x-1][y] != 'W' && accessible(x-1,y,newDejaPass)){
        result = true;
      }
      if (!result && y<max-1 && !dejaPass.contains(new Point(x,y+1)) && map[x][y+1] != 'W' && accessible(x,y+1,newDejaPass)){
        result = true;
      }
      if (!result && y>0 && !dejaPass.contains(new Point(x,y-1)) && map[x][y-1] != 'W' && accessible(x,y-1,newDejaPass)){
        result = true;
      }
      
      return result;
    }
}