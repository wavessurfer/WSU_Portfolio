package lab;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ParenthesisChecker {

	// Design and write a program that uses Stacks to determine whether an
	// expression involving both parentheses and square brackets is well formed.
	public static boolean isWellFormed(String expression) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < expression.length(); i++) {
			if (expression.charAt(i) == '(')
				stack.push(expression.charAt(i));
			else if (expression.charAt(i) == ')') {
				if (stack.isEmpty())
					return false;
				char ch = stack.pop();
				if (ch != '(')
					return false;
			} else
				continue; // skip the character if it is nor parentheses/bracket
		}

		return stack.isEmpty(); // the stack should be empty at the end for all pairs
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = Arrays.asList("()","())", "a(c)b", "(()","(a+b)", "()()(", "(a+b)(c)", "(())");

		for (String exp : list)
			System.out.println(exp + ": " + isWellFormed(exp));

	}
}
