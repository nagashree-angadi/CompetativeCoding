/*
* Balanced Parentheses (hard)
* For a given number ‘N’, write a function to generate all combination of ‘N’ pairs of balanced parentheses.
* */

import java.util.*;

class ParenthesesString {
    String str;
    int openCount; // open parentheses count
    int closeCount; // close parentheses count

    public ParenthesesString(String s, int openCount, int closeCount) {
        str = s;
        this.openCount = openCount;
        this.closeCount = closeCount;
    }
}

class GenerateParentheses {

    public static List<String> generateValidParentheses(int num) {
        List<String> res = new ArrayList<String>();
        Queue<ParenthesesString> q = new LinkedList<ParenthesesString>();
        q.add( new ParenthesesString("(", 1 , 0 ));
        while(!q.isEmpty()){
            ParenthesesString temp = q.poll();
            if( temp.str.length() == num*2){
                res.add(temp.str);
            }
            else{
                if( temp.openCount < num)
                    q.add( new ParenthesesString(temp.str+"(", temp.openCount+1, temp.closeCount ));
                if( temp.openCount > temp.closeCount)
                    q.add( new ParenthesesString(temp.str+")", temp.openCount, temp.closeCount+1 ));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<String> result = GenerateParentheses.generateValidParentheses(2);
        System.out.println("All combinations of balanced parentheses are: " + result);

        result = GenerateParentheses.generateValidParentheses(3);
        System.out.println("All combinations of balanced parentheses are: " + result);
    }
}
