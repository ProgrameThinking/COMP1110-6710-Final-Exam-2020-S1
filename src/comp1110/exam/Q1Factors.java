package comp1110.exam;

import java.util.ArrayList;

/**
 * COMP1110 Exam, Question 1.1
 */
public class Q1Factors {
    /**
     * This function takes a positive integer, n, and returns an array
     * of ints containing all prime factors of that integer in ascending order.
     * For example:
     * factors(6) returns {2, 3}
     * factors{7} returns {7}
     * factors{24} returns {2, 2, 2, 3}
     * <p>
     * If n is less than 2, an empty array is returned.
     *
     * @param n the number to factor
     * @return an array containing all prime factors of the number
     */
    public static int[] factors(int n) {
    	if(n<2) {
    		int ans[]= {};
    		return ans;
    	}
        // FIXME complete this method
        ArrayList<Integer> ans= new ArrayList<Integer>();
        int i=2;
        while(i<=n) {
        	if(n%i==0) {
        		ans.add(i);
            	n=n/i;
        		i=2;
        	}
        	else 
				i++;
        }
        System.out.println(ans);
        int[] result = new int[ans.size()];
        for (int j = 0; j < ans.size(); j++) {
            result[j] = ans.get(j);
        }

        return result;
        
    }
}
