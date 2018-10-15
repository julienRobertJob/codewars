package codewars.kata;
import java.util.*;

public class MexicanWave {

    public static String[] wave(String str) {

        String[] result = new String[str.replaceAll(" ", "").length()];
        ArrayList<String> list = new ArrayList<String>();
        
        for (int i=0; i< str.length();i++){
          if (str.charAt(i) != ' '){ 
            String s = str.substring(0,i) + (str.substring(i,i+1)).toUpperCase() + str.substring(i+1,str.length());
            list.add(s);
          }
        }
        return list.toArray(result);
    }
    
}