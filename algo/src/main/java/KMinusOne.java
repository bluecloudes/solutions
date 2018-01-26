import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class KMinusOne {
	  public List<String> subStringsLessKDist(String inputString, int num)
		{
		  	int length = inputString.length();
		    if(length < num) {
		        return new ArrayList<String>();
		    }
	        if(num <= 0) {
	            return new ArrayList<String>();
	        }
	        
	        
	        List<String> result = new ArrayList<>();
	        for (int i=0; i<= length-num; i++) {
	        	System.out.println(inputString.substring(i, i+num));
	            Set<Character> set = new HashSet<Character>();
	            for (int j = i; j <= i + num - 1; j++) {
					set.add(inputString.charAt(j));
				}
	            if(set.size() == num -1) {
	            	result.add(inputString.substring(i, i+num));
				}
	        }
	        return result;
	        
	    }
	  public int[] find(List<String> targetList, List<String> allTags) {
		  Map<String, Integer> map = new HashMap<>();
		  int i=0;
		  for (Iterator iterator = allTags.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			if(!map.containsKey(string))
				map.put(string.toLowerCase(), i++);
		  }
		  int[] targetInts = new int[targetList.size()];
		  i=0;
		  for (Iterator iterator = targetList.iterator(); iterator.hasNext();) {
				String string = (String) iterator.next();
				targetInts[i] = map.get(string.toLowerCase());
				i++;
		  }
		  int[] allInts = new int[allTags.size()];
		  i=0;
		  for (Iterator iterator = allTags.iterator(); iterator.hasNext();) {
				String string = (String) iterator.next();
				allInts[i++] = map.get(string.toLowerCase());
		  }
		  System.out.println(Arrays.toString(targetInts));
		  System.out.println(Arrays.toString(allInts));
		  int result[][] = new int[allInts.length+1][2];
		  result[0][0] = result[0][1] = -1;
 		  for (int j = 1; j <= allInts.length; j++) {
			for (int k = 0; k < 1; k++) {
				if(targetInts[k] == allInts[j-1]) {
					result[j][1] = (result[j-1][1]!=-1)?result[j-1][1]:j-1;
					if(k==0) result[j][0] = result[j][1]=j-1;
				} else {
					result[j][1] = result[j-1][1];
					result[j][0] = result[j-1][1];
				}
			}
		  }
		  for (int j = 0; j < result.length; j++) {
			System.out.println(result[j][0]+"~"+result[j][1]);
		}
		  return new int[2];
	  }
	  public static void main(String [] args) {
		  KMinusOne p = new KMinusOne();
		  //System.out.println(p.subStringsLessKDist("awagw", 2));
		  String[] targetList = {"made", "in", "Spain"};
		  String[] allTags = {"made", "weather", "forecast", "says", "that", "made", "rain", "in", "spain", "stays"};
		  p.find(Arrays.asList(targetList), Arrays.asList(allTags));
	  }
}
