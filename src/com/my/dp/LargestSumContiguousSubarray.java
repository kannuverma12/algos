package com.my.dp;

/**
 * 
 * @author karan.verma
 *
 */


/*
 * Kadane’s Algorithm:
 * 
 * Initialize:
    max_so_far = 0
    max_ending_here = 0

Loop for each element of the array
  (a) max_ending_here = max_ending_here + a[i]
  (b) if(max_ending_here < 0)
            max_ending_here = 0
  (c) if(max_so_far < max_ending_here)
            max_so_far = max_ending_here
return max_so_far
 */

/*
 * Explanation:
Simple idea of the Kadane's algorithm is to look for all positive contiguous segments of the array (max_ending_here is used for this). And keep track of maximum sum contiguous segment among all positive segments (max_so_far is used for this). Each time we get a positive sum compare it with max_so_far and update max_so_far if it is greater than max_so_far
 */
public class LargestSumContiguousSubarray {

	public static void main(String[] args) {
		int [] a = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println("Maximum contiguous sum is " +
                                       maxSubArraySum(a));

	}

	private static int maxSubArraySum(int[] n) {
		int size = n.length;
		
		int max_so_far = Integer.MIN_VALUE;
		int max_ending_here = 0;
		
		for(int i=0;i<size;i++) {
			max_ending_here = max_ending_here + n[i];
			
			if(max_so_far < max_ending_here)
				max_so_far = max_ending_here;
		
			if(max_ending_here < 0)
				max_ending_here = 0;
		}
				
		return max_so_far;
	}

}
