/*
* String Anagrams (hard) #
* Given a string and a pattern, find all anagrams of the pattern in the given string.
* */
import java.util.*;

class StringAnagrams {
    public static List<Integer> findStringAnagrams(String str, String pattern) {
        List<Integer> res = new ArrayList<Integer>();
        int j=0;
        int matched = 0;
        Map<Character, Integer> count = new HashMap<Character, Integer>();

        for(char ch: pattern.toCharArray())
            count.put(ch, count.getOrDefault(ch, 0)+1);

        for(int i=0; i<str.length(); i++){
            char right = str.charAt(i);
            if(count.containsKey(right)){
                count.put(right, count.get(right)-1);
                if( count.get(right) == 0)
                    matched++;
            }

            if (matched == count.size())
                res.add(j);

            if(i >= pattern.length()-1){
                char left = str.charAt(j);
                if(count.containsKey(left)) {
                    if( count.get(left) == 0)
                        matched--;
                    count.put(left, count.get(left)+1);
                }
                j++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(StringAnagrams.findStringAnagrams("ppqp", "pq"));
        System.out.println(StringAnagrams.findStringAnagrams("abbcabc", "abc"));
    }
}
