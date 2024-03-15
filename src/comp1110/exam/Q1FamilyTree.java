package comp1110.exam;

import java.util.ArrayList;
import java.util.List;

/**
 * COMP1110 Exam, Question 1.2
 */
public class Q1FamilyTree {

    /**
     * This class represents an individual with zero or more children.
     */
    static class Individual {
        public String name;
        /**
         * This individual's immediate descendants.
         * If this individual has no children, this field is null.
         */
        public Individual[] children;

        public Individual(String name, Individual[] children) {
            this.name = name;
            this.children = children;
        }
    }

    /**
     * This function accepts an Individual <code>ancestor</code> representing
     * the root (common ancestor) of a family tree
     * and the name of a target individual to find within that family tree,
     * and returns a string representation of all the ancestors of that
     * individual, each separated by the string " born of ".
     * <p>
     * If target name matches the name of <code>ancestor</code>, then only
     * the target name is returned.
     * <p>
     * If the target name is not found within the family tree descended from
     * <code>ancestor</code>, then null is returned.
     * <p>
     * For example, given an Individual homer representing a person named
     * "Homer", who has children named "Lisa" and "Bart":
     * getAncestry(homer, "Lisa") returns "Lisa born of Homer";
     * getAncestry(homer, "Bart") returns "Bart born of Homer"; and
     * getAncestry(homer, "Homer") returns "Homer"; and
     * getAncestry(homer, "Barney") returns null
     * <p>
     * Note: each individual has only one parent in the family tree.
     *
     * @param ancestor   the root (common ancestor) of a family tree
     * @param targetName the name of an individual to find in the family tree
     * @return a String representing the ancestry of the individual named
     * <code>targetName</code>, or null if no such individual is found
     */
    static boolean recGetAncestry(ArrayList<String> ansList,Individual ancestor1, String ancestor) {
    	ansList.add(ancestor1.name);
    	if(ancestor1.name.equals(ancestor)) 
    		return true;
    	if(ancestor1.children==null) {
    		ansList.remove(ancestor1.name);
    		return false;
    	}
    	for(int i=0;i<ancestor1.children.length;i++) {
    		if(recGetAncestry(ansList, ancestor1.children[i], ancestor))
    			return true;
    	}
    	ansList.remove(ancestor1.name);
    	return false;
    	
    }
    public static String getAncestry(Individual ancestor1, String ancestor) {
        // FIXME complete this method
    	ArrayList<String> ansList=new ArrayList<>();
    	String ans="";
    	recGetAncestry(ansList,ancestor1,ancestor);
    	for(int i=ansList.size()-1;i>0;i--) 
    		ans+=(ansList.get(i)+" born of ");
    	if(ansList.size()!=0) {
	    	ans+=ansList.get(0);
	        return ans;
    	}
    	return null;
    }
}
