package codewars.kata;

public class MissingLetter
{
    public static char findMissingLetter(char[] array)
  {
    char missingLetter = '?';

    for (int i = 1; i < array.length; i++){
      if ((int)array[i] - (int)array[i-1] > 1){
        missingLetter = (char)((int)array[i-1] + 1);
        break;
      }
    }
    
    return missingLetter;
  }
}