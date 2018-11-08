public class MaxSubArray {
    public static int sequence(int[] arr) {
    int max_ending_here = 0;
    int max_so_far = 0;
    for (int i=0;i< arr.length; i++){
        max_ending_here = Math.max(arr[i], max_ending_here + arr[i]);
        max_so_far = Math.max(max_so_far, max_ending_here)
    }
    return max_so_far;
    }
  }