package codewars.kata;

import java.util.*;

public class DirReduction {
    public static String[] dirReduc(String[] arr) {
        Stack<String> result = new Stack<String>();
        for (int i=0;i<arr.length;i++){
            if (!result.isEmpty()
                && ((result.peek().equals("NORTH") && arr[i].equals("SOUTH"))
                    ||(result.peek().equals("SOUTH") && arr[i].equals("NORTH"))
                    ||(result.peek().equals("EAST") && arr[i].equals("WEST"))
                    ||(result.peek().equals("WEST") && arr[i].equals("EAST")))){
                result.pop();
            }else{
                result.push(arr[i]);
            }
        }
        return result.toArray(new String[result.size()]);
    }
}
