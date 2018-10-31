package codewars.kata;

import java.util.*;

public class DirReduction {
    public static String[] dirReduc(String[] arr) {
        LinkedList<String> result = new LinkedList<String>();
        for (int i=0;i<arr.length;i++){
            if (!result.isEmpty()
                && ((result.getLast().equals("NORTH") && arr[i].equals("SOUTH"))
                    ||(result.getLast().equals("SOUTH") && arr[i].equals("NORTH"))
                    ||(result.getLast().equals("EAST") && arr[i].equals("WEST"))
                    ||(result.getLast().equals("WEST") && arr[i].equals("EAST")))){
                result.removeLast();
            }else{
                result.addLast(arr[i]);
            }
        }
        return result.toArray(new String[result.size()]);
    }
}
