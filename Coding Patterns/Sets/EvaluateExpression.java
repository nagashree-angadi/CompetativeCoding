/*
* Evaluate Expression (hard) #
* Given an expression containing digits and operations (+, -, *),
* find all possible ways in which the expression can be evaluated by grouping
* the numbers and operators using parentheses.
* */

import java.util.*;

class EvaluateExpression {
    public static List<Integer> diffWaysToEvaluateExpression(String input) {
        List<Integer> result = new ArrayList<>();
        // TODO: Write your code here
        return result;
    }

    public static void main(String[] args) {
        List<Integer> result = EvaluateExpression.diffWaysToEvaluateExpression("1+2*3");
        System.out.println("Expression evaluations: " + result);

        result = EvaluateExpression.diffWaysToEvaluateExpression("2*3-4-5");
        System.out.println("Expression evaluations: " + result);
    }
}
