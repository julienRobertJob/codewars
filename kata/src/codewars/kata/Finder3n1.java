package codewars.kata;

import java.awt.Point;
import java.util.HashMap;

public class Finder3n1 {
    
    static int[][] map;
    static int max;

    public static int pathFinder(String maze) {
        
        max = maze.indexOf("\n");
        if (max < 0)
          return 0;
        String mazeClean = maze.replaceAll("\n", "");
        map = new int[max][max];

        for (int i=0; i< mazeClean.length();i++) {
            map[i%max][i/max] = Character.getNumericValue(mazeClean.charAt(i));
        }

        return chemin(0,0,0, new HashMap<Point,Boolean>());
    }

    private static int chemin (int total, int x, int y, HashMap<Point,Boolean> dejaPass){
        int cheminTrouve = -1;
        // Ajout du point courant dans les deja passés
        dejaPass.put(new Point(x,y), true);
        // copie de la map
        HashMap<Point,Boolean> newDejaPass = new HashMap<Point,Boolean>(dejaPass);
        
        // Arrivé au noeud final
        if (x==max-1 && y == max-1){
            return total;
        }

        // Test des chemins dans les 4 directions
        // Si il y a une case et qu'on y est pas deja passé
        
        // Est
        if (x<max-1 && !dejaPass.containsKey(new Point(x+1,y)))
          cheminTrouve = testChemin(total, x, y, x+1, y, newDejaPass, cheminTrouve);

        // Ouest
        if (x>0 && !dejaPass.containsKey(new Point(x-1,y)))
            cheminTrouve = testChemin(total, x, y, x-1, y, newDejaPass, cheminTrouve);

        // SUD
        if (y<max-1 && !dejaPass.containsKey(new Point(x,y+1)))
            cheminTrouve = testChemin(total, x, y, x, y+1, newDejaPass, cheminTrouve);

        // Nord
        if (y>0 && !dejaPass.containsKey(new Point(x,y-1)))
            cheminTrouve = testChemin(total, x, y, x, y-1, newDejaPass, cheminTrouve);

        // On poursuit notre chemin
        return cheminTrouve;
    }
    
    private static int testChemin (int total, int x, int y, int nx, int ny, HashMap<Point,Boolean> dejaPass, int cheminTrouve ){
      // on ajoute le denivelé parcouru
      int newTotal = total + Math.abs(map[x][y] - map[nx][ny]);
      
      // Si le chemin est deja plus long qu'un chemin trouvé, on ne va pas plus loin
      if (cheminTrouve != -1 && newTotal >= cheminTrouve)
        return cheminTrouve;
      else {
        // calcul de chemin a partir du prochain point (nx,ny)
        int nouveauChemin = chemin(newTotal, nx,ny, dejaPass);
              
        // si le nouveau chemin parvient a l'arrivé et qu'il est le plus court
        if(nouveauChemin != -1 && (cheminTrouve==-1 || nouveauChemin < cheminTrouve))
          cheminTrouve = nouveauChemin;
          
        return cheminTrouve;
      }
    }
}