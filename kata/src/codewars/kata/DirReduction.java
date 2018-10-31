package codewars.kata;

import java.util.*;

public class DirReduction {
    public static String[] dirReduc(String[] arr) {
        int nbN = 0;
        int nbS = 0;
        int nbE = 0;
        int nbW = 0;
        
         System.out.println("arr : " + Arrays.toString(arr));
        LinkedList<String> larr = new LinkedList<String>(Arrays.asList(arr));
        LinkedList<String> result = new LinkedList<String>();
        for (String dir : larr) {
            if (dir.equals("NORTH")){
                if (nbS > 0){
                    result.removeLastOccurrence("SOUTH");
                }
                else{
                    result.addLast("NORTH");
                    nbN++;
                }
              }
              if (dir.equals("SOUTH")){
                if (nbN > 0){
                    result.removeLastOccurrence("NORTH");
                }
                else{
                    result.addLast("SOUTH");
                    nbS++;
                }
              }
              if (dir.equals("EAST")){
                if (nbW > 0){
                    result.removeLastOccurrence("WEST");
                }
                else{
                    result.addLast("EAST");
                    nbE++;
                }
              }
              if (dir.equals("WEST")){
                if (nbE > 0){
                    result.removeLastOccurrence("EAST");
                }
                else{
                    result.addLast("WEST");
                    nbW++;
                }
              }
        }
        // for (int i=0;i<arr.length;i++){
        //   if (arr[i].equals("NORTH")){
        //     vertical++;
        //   }
        //   if (arr[i].equals("SOUTH")){
        //     vertical--;
        //   }
        //   if (arr[i].equals("EAST")){
        //     horizontal++;
        //   }
        //   if (arr[i].equals("WEST")){
        //     horizontal--;
        //   }
        // }
        
        // int nbResult = Math.abs(vertical) + Math.abs(horizontal);
        
        // System.out.println("horizontal : " + horizontal);
        // System.out.println("vertical : " + vertical);
        // System.out.println("nbResult : " + nbResult);
        // String[] result = new String[nbResult];
        
        // for (int i=0;i<nbResult;i++){
        //   if (horizontal>0){
        //     result[i] = "EAST";
        //     horizontal--;
        //   }
        //   if (horizontal<0){
        //     result[i] = "WEST";
        //     horizontal++;
        //   }
        //   if (vertical>0){
        //     result[i] = "NORTH";
        //     vertical--;
        //   }
        //   if (vertical<0){
        //     result[i] = "SOUTH";
        //     vertical++;
        //   }
        // }

        return result.toArray(new String[result.size()]);
    }
}
