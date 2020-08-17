/*
* Fruits into Baskets (medium)
* Given an array of characters where each character represents a fruit tree,
* you are given two baskets and your goal is to put maximum number of fruits in each basket.
* The only restriction is that each basket can have only one type of fruit.
* */
import java.util.*;

class MaxFruitCountOf2Types {
    public static int findLength(char[] str) {
        Map<Character, Integer> count = new HashMap<Character, Integer>();
        int res = 0;
        int j = 0;
        for( int i=0; i< str.length; i++){
            char right = str[i];
            count.put( right, count.getOrDefault(right, 0)+1);

            while( count.size() > 2) {
                char left = str[j];
                count.put(left, count.get(left) - 1);
                if (count.get(left) == 0)
                    count.remove(left);
                j++;
            }
            res = Math.max( res, i-j+1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("Maximum number of fruits: " +
                MaxFruitCountOf2Types.findLength(new char[] { 'A', 'B', 'C', 'A', 'C' }));
        System.out.println("Maximum number of fruits: " +
                MaxFruitCountOf2Types.findLength(new char[] { 'A', 'B', 'C', 'B', 'B', 'C' }));
    }
}
