package adtstack;

import java.util.ArrayList;
import java.util.StringTokenizer;

//Note: No Static methods. Otherwise, no credits.

/**
 * Define Class Expression including the method infixToPostfix() and method evaluate().
 * Other methods such as constructors and helper methods should be included in the class.
 * @author ylzhao
 * @version 1.0
 */
public class Expression {
	
	/**
	 * The content of this expression
	 */
	private String infix;
	
	/**
	 * Constructs an empty (null) String infix.
	 */
	public Expression(){
	}
	
	/**
	 * Constructs the String infix with a reference to a String instance.
	 * @param infix A reference to a String instance to be used to construct the String infix.
	 */
	public Expression(String infix){
		this.infix = new String(infix);
	}
	
	/**
	 * Convert an infix expression to an equivalent postfix expression.
	 * @return A reference to a array list of tokens of the postfix expression.
	 */
	public ArrayList<String> infixToPostfix(){
//		StringBuilder tokensStr = new StringBuilder();
		
		ArrayList<String> postList = new ArrayList<String>();
		GenericStack<String> tokenStack = new GenericStack<String>();
		
		ArrayList<String> tokenList = splitInput(this.infix);
		
		for (int i = 0; i < tokenList.size(); i++) {
			String token = new String(tokenList.get(i));
			if (token.equals("(")) {
				tokenStack.push(token);
			} else if (token.equals(")")) {
				while (!tokenStack.isEmpty() && !tokenStack.peek().equals("(")) {
					postList.add(tokenStack.pop());
				}
				tokenStack.pop();
			} else if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
				while (!tokenStack.isEmpty() && !tokenStack.peek().equals("(") && (precedence(tokenStack.peek()) >= precedence(token))) {
					postList.add(tokenStack.pop());
				}
				tokenStack.push(token);
			} else {
				postList.add(token);
			}
		}
		
		while(!tokenStack.isEmpty()) {
			postList.add(tokenStack.pop());
		}
		
		return postList;
    }
	
	/**
	 * Invoke method infixToPostfix and evaluate the postfix expression to get the result of the expression.
	 * @return An integer specifying the result of the postfix expression.
	 */
	public int evaluate(){
		
		GenericStack<Integer> operandStack = new GenericStack<Integer>();
		
		ArrayList<String> postfixList = infixToPostfix();
		
		for (int i = 0; i < postfixList.size(); i++) {
			String token = postfixList.get(i);
			if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
				int operand2 = operandStack.pop();
				int operand1 = operandStack.pop();
				
				if (token.equals("+")) {
					operandStack.push(operand1 + operand2);
				} else if (token.equals("-")) {
					operandStack.push(operand1 - operand2);
				} else if (token.equals("*")) {
					operandStack.push(operand1 * operand2);
				} else if (token.equals("/")) {
					operandStack.push(operand1 / operand2);
				}
			} else {
				operandStack.push(Integer.parseInt(token));
			}
		}
		return operandStack.pop();
		
	}
	
	//Other methods
	//Helper methods
	
	/**
	 * Split an infix expression into tokens.
	 * We should not use charAt method and expect all operands are single-digit tokens.
	 * Instead we should split an infix expression by proper delimiters 
	 * so that all operators, operands (single-digit or not), and parentheses are tokens.
	 * @param inputStr A reference to a String instance of an infix expression.
	 * @return A reference to a array list of tokens of the infix expression.
	 */
	private ArrayList<String> splitInput(String inputStr){
	    StringTokenizer tokens = new StringTokenizer(inputStr, "()+-/*", true);
	    
	    ArrayList<String> tokenStrList = new ArrayList<String>();
	    
	    while(tokens.hasMoreTokens()){
	    	tokenStrList.add(new String(tokens.nextToken()));
	    }
	    return tokenStrList;
	}
	
	/**
	 * Get the precedence of a given operator(token) by using Integer value.
	 * A higher precedence operator has a greater Integer value.
	 * @param token A reference to a String instance of a given operator(token).
	 * @return An integer specifying the precedence of a given operator(token).
	 */
	private int precedence(String token) {
		if (token.equals("+") || token.equals("-")) {
			return 1;
		} else if (token.equals("*") || token.equals("/")) {
			return 2;
		} else {
			return 0;
		}
	}
}
