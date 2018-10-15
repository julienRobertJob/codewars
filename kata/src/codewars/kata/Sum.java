package codewars.kata;

public class Sum
{
   public int GetSum(int a, int b)
   {
     int result = 0;
     int min;
     int max;
     
     if (b < a) {
       min = b;
       max = a;
     }
     else{
       min = a;
       max = b;
     }
     
     for (int i =min; i<=max;i++){
         result += i;
      }
     
     return result;
   }
}