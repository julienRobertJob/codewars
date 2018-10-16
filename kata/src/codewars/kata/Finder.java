package codewars.kata;

public class Finder {
    
    public static int pathFinder(String maze) {
        
        int n = maze.indexOf("\n");
        String mazeClean = maze.replaceAll("\n", "");
        System.out.println("n : " + n);
        int[][] tab = new int[n][n];

        for (int i=0; i< mazeClean.length();i++) {
            System.out.println("i%n : " + i%n);
            System.out.println("i/n : " + i/n);
            tab[i%n][i/n] = Integer.valueOf(mazeClean.charAt(i));
        }

        return -1;
    }
}