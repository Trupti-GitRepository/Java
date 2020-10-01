/**
 * A utility class that converts an infix expression to a postfix expression, a
 * postfix expression to an infix expression and evaluates a postfix expression.
 * 
 * @author Trupti Thakur
 *
 */
public class Notation {
	NotationStack stack;
	private static final Character LEFT_PARENTHESIS = '(';
	private static final Character RIGHT_PARENTHESIS = ')';
	private static final Character ADDITION_OPERATOR = '+';
	private static final Character SUBSTRACTION_OPERATOR = '-';
	private static final Character MULTIPLICATION_OPERATOR = '*';
	private static final Character DIVISION_OPERATOR = '/';

	/** Constructor */
	public Notation() {

	}

	/**
	 * The method convet an Infix expression into a postFix Expression.
	 * 
	 * @param infix - the infix expression in string format
	 * @return the postfix expression in string format
	 * @throws StackUnderflowException
	 * @throws QueueOverflowException
	 * @throws StackOverflowException
	 * @throws InvalidNotationFormatException - if the infix expression format is
	 *                                        invalid
	 */
	public static String convertInfixToPostfix(String infix) throws StackOverflowException, StackUnderflowException,
			QueueOverflowException, InvalidNotationFormatException {
		QueueInterface<Character> charQueue = new NotationQueue<>(infix.length());
		StackInterface<Character> charStack = new NotationStack<>(infix.length());
		char[] ipArray = infix.toCharArray();
		int stringCounter = 0;
		while (stringCounter < infix.length()) {
			if (ipArray[stringCounter] == LEFT_PARENTHESIS) {

				charStack.push(ipArray[stringCounter]);

			} else if (ipArray[stringCounter] == RIGHT_PARENTHESIS) {

				Character oppedCharacter = charStack.pop();
				boolean gotLeft = true;
				while (oppedCharacter != LEFT_PARENTHESIS) {
					charQueue.enqueue(oppedCharacter);
					if (!charStack.isEmpty()) {
						oppedCharacter = charStack.pop();
					} else {
						gotLeft = false;
						break;
					}
				}
				if (!gotLeft) {
					throw new InvalidNotationFormatException();
				}
			} else if (ipArray[stringCounter] == MULTIPLICATION_OPERATOR || ipArray[stringCounter] == DIVISION_OPERATOR
					|| ipArray[stringCounter] == ADDITION_OPERATOR || ipArray[stringCounter] == SUBSTRACTION_OPERATOR) {
				int topPriority = 0;
				if (!charStack.isEmpty()) {
					topPriority = getPrecedence(charStack.top());
				}

				int currPriority = getPrecedence(ipArray[stringCounter]);
				while (topPriority != -1 && currPriority <= topPriority) {
					charQueue.enqueue(charStack.pop());
					if (!charStack.isEmpty()) {
						topPriority = getPrecedence(charStack.top());
					}
				}
				charStack.push(ipArray[stringCounter]);

			} else {
				charQueue.enqueue(ipArray[stringCounter]);
			}
			stringCounter++;
		}
		while (!charStack.isEmpty() && charStack.top() != LEFT_PARENTHESIS) {
			charQueue.enqueue(charStack.pop());
		}
		return charQueue.toString();
	}

	/**
	 * The method Convert the Postfix expression to the Infix expression
	 * 
	 * @param postfix expression in String format
	 * @return the infix expression in string format
	 * @throws StackOverflowException
	 * @throws StackUnderflowException
	 * @throws Exception
	 * @throws InvalidNotationFormatException -if the postfix expression format is
	 *                                        invalid
	 */
	public static String convertPostfixToInfix(String postfix)
			throws StackOverflowException, StackUnderflowException, InvalidNotationFormatException {

		StackInterface<String> charStack = new NotationStack<>(postfix.length());
		char[] ipArray = postfix.toCharArray();
		int stringCounter = 0;

		while (stringCounter < postfix.length()) {

			if ((ipArray[stringCounter] != ADDITION_OPERATOR) && (ipArray[stringCounter] != SUBSTRACTION_OPERATOR)
					&& (ipArray[stringCounter] != MULTIPLICATION_OPERATOR)
					&& (ipArray[stringCounter] != DIVISION_OPERATOR)) {

				charStack.push(ipArray[stringCounter] + "");

			} else {

				if (!(charStack.size() < 2)) {

					String ch1 = charStack.pop();
					String ch2 = charStack.pop();
					StringBuilder sb = new StringBuilder();
					sb.append('(').append(ch2).append(ipArray[stringCounter]).append(ch1).append(')');
					charStack.push(sb.toString());
				} else {
					throw new InvalidNotationFormatException();
				}
			}
			stringCounter++;
		}
		String infix;
		if (charStack.size() == 1) {
			infix = charStack.pop();
		} else {

			throw new InvalidNotationFormatException();
		}

		return infix;

	}

	/**
	 * Evalates a infix expression.
	 * 
	 * @param infixExpr infix - the infix expression in string format
	 * @return the evaluation of the infix expression as a double
	 * @throws StackOverflowException
	 * @throws StackUnderflowException
	 * @throws InvalidNotationFormatException
	 */
	public static double evaluateInfixExpression(String infixExpr)
			throws StackOverflowException, StackUnderflowException, InvalidNotationFormatException {

		StackInterface<Character> charStack = new NotationStack<>(infixExpr.length());
		StackInterface<Integer> intStack = new NotationStack<>(infixExpr.length());
		int charCounter = 0;
		int intCounter = 0;
		char[] expArray = infixExpr.toCharArray();

		while (charCounter < infixExpr.length()) {
			if ((expArray[charCounter] == LEFT_PARENTHESIS)) {
				charStack.push((expArray[charCounter]));

			} else if ((expArray[charCounter] == ADDITION_OPERATOR) || (expArray[charCounter] == SUBSTRACTION_OPERATOR)
					|| (expArray[charCounter] == MULTIPLICATION_OPERATOR)
					|| (expArray[charCounter] == DIVISION_OPERATOR)) {

				charStack.push((expArray[charCounter]));

			} else if (expArray[charCounter] == RIGHT_PARENTHESIS) {
				/**
				 * while(!charStack.isEmpty()&& charStack.top()!=LEFT_PARENTHESIS) { int
				 * or1=intStack.pop(); int or2=intStack.pop(); char op1=charStack.pop();
				 * intStack.push(doOperation(or2, or1, op1)); }
				 **/

				if (charStack.top() != LEFT_PARENTHESIS) {
					int or1 = intStack.pop();
					int or2 = intStack.pop();
					char op1 = charStack.pop();
					intStack.push(doOperation(or2, or1, op1));
					charStack.pop();
				} else {
					charStack.pop();
				}

			} else {
				intStack.push((Integer.parseInt(expArray[charCounter] + "")));
			}
			charCounter++;
		}

		while (!charStack.isEmpty() && charStack.top() != LEFT_PARENTHESIS) {
			int or1 = intStack.pop();
			int or2 = intStack.pop();
			char op1 = charStack.pop();
			intStack.push(doOperation(or2, or1, op1));
		}

		// int postfix = (intStack.size() == 1) ? intStack.pop() : Integer.MAX_VALUE;
		int postfix;
		if (intStack.size() == 1) {
			postfix = intStack.pop();
		} else {

			throw new InvalidNotationFormatException();
		}

		return postfix;

	}

	/**
	 * Evaluates a postFix expression.
	 * 
	 * @param postfixExpr postFix - the postFix expression in string format
	 * @return the evaluation of the postfix expression as a double.
	 * @throws StackOverflowException
	 * @throws InvalidNotationFormatException
	 * @throws StackUnderflowException
	 *
	 */
	public static double evaluatePostfixExpression(String postfixExpr)
			throws InvalidNotationFormatException, StackOverflowException, StackUnderflowException {

		StackInterface<Integer> checkStack = new NotationStack<>(postfixExpr.length());
		char[] ippArray = postfixExpr.toCharArray();
		int counter = 0;

		while (counter < postfixExpr.length()) {

			if ((ippArray[counter] != ADDITION_OPERATOR) && (ippArray[counter] != SUBSTRACTION_OPERATOR)
					&& (ippArray[counter] != MULTIPLICATION_OPERATOR) && (ippArray[counter] != DIVISION_OPERATOR)) {
				checkStack.push((Integer.parseInt(ippArray[counter] + "")));
			} else {

				if (!(checkStack.size() < 2)) {

					Integer ch1 = checkStack.pop();
					Integer ch2 = checkStack.pop();
					StringBuilder sb = new StringBuilder();
					checkStack.push(doOperation(ch2, ch1, ippArray[counter]));

				} else {

					throw new InvalidNotationFormatException();
				}
			}
			counter++;
		}

		int infix = (checkStack.size() == 1) ? checkStack.pop() : Integer.MAX_VALUE;
		return infix;

	}

	/** perform arithmetic operations. **/
	private static int doOperation(Integer op1, Integer op2, Character operator) {
		switch (operator) {
		case '+':
			return op1 + op2;
		case '-':
			return op1 - op2;
		case '*':
			return op1 * op2;
		case '/':
			return op1 / op2;
		default:
			return Integer.MAX_VALUE;

		}

	}

	/** calculate operator prededence **/
	private static int getPrecedence(char c) {
		switch (c) {
		case '+':
			return 1;
		case '-':
			return 1;
		case '*':
			return 2;
		case '/':
			return 2;
		default:
			return -1;
		}
	}

}
