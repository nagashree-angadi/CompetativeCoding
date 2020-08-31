/*
* String Permutations by changing case (medium)
* Given a string, find all of its permutations preserving the character sequence but changing case.
* */

import java.util.*;

class LetterCaseStringPermutation {

    public static List<String> findLetterCaseStringPermutations(String str) {
        List<String> res = new ArrayList<>();
        res.add(str);
        for(int i=0; i< str.length(); i++){
            if(Character.isLetter(str.charAt(i))){
                int size = res.size();
                for( int j=0; j<size; j++) {
                    char[] temp = res.get(j).toCharArray();
                    if(Character.isUpperCase(temp[i]))
                        temp[i] -= ('A'-'a');
                    else
                        temp[i] += ('A'-'a');
                    res.add(new String(temp));
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<String> result = LetterCaseStringPermutation.findLetterCaseStringPermutations("ad52");
        System.out.println(" String permutations are: " + result);

        result = LetterCaseStringPermutation.findLetterCaseStringPermutations("ab7c");
        System.out.println(" String permutations are: " + result);
    }
}
