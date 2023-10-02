package com.example.assignment_2;

public class Notation {
    public static double evaluatePostfixExpression(String postfix) throws InvalidNotationFormatException {
        MyStack<String> postfixStack = new MyStack<String>();
        double firstNum;
        double secondNum;
        double result;

        try {
            for(int i = 0; i < postfix.length(); i++) {
                Character currentChar = postfix.charAt(i);

                if (currentChar == ' ')
                    continue;

                if (Character.isDigit(currentChar) || currentChar == '(')
                    postfixStack.push(currentChar.toString());

                if (isOperator(currentChar)) {
                    if (postfixStack.size() < 2)
                        throw new InvalidNotationFormatException();

                    firstNum = Double.parseDouble(postfixStack.pop());
                    secondNum = Double.parseDouble(postfixStack.pop());

                    result = evaluateExpression(firstNum, currentChar, secondNum);
                    postfixStack.push(Double.toString(result));
                }
            }

            if (postfixStack.size() > 1)
                throw new InvalidNotationFormatException();

        } catch (InvalidNotationFormatException | StackOverflowException | StackUnderflowException e) {
            e.printStackTrace(System.out);
        }

        StringBuilder realResult = new StringBuilder(postfixStack.toString());
        return Double.parseDouble(realResult.reverse().toString());
    }

    public static String convertPostfixToInfix(String postfix) throws InvalidNotationFormatException {
        MyStack<String> postfixStack = new MyStack<String>();
        StringBuilder expression = new StringBuilder();

        try {
            for (int i = 0; i < postfix.length(); i++) {
                Character currentChar = postfix.charAt(i);

                if (currentChar == ' ')
                    continue;

                if (Character.isDigit(currentChar))
                    postfixStack.push(currentChar.toString());

                if (isOperator(currentChar)) {
                    if (postfixStack.size() > 1) {
                        expression.append(')');
                        expression.append(postfixStack.pop());
                        expression.append(currentChar);
                        expression.append(postfixStack.pop());
                        expression.append('(');
                        postfixStack.push(expression.toString());
                    } else
                        throw new InvalidNotationFormatException();
                }
            }

            if (postfixStack.size() > 1)
                throw new InvalidNotationFormatException();

        } catch (InvalidNotationFormatException | StackOverflowException | StackUnderflowException e) {
            e.printStackTrace(System.out);
        }

        return postfixStack.toString();
    }

    public static String convertInfixToPostfix(String infix) throws InvalidNotationFormatException {
        MyQueue<Character> postFixQueue = new MyQueue<Character>();
        MyStack<Character> postfixStack = new MyStack<Character>();

        try {
            for (int i = 0; i < infix.length(); i++) {
                char currentChar = infix.charAt(i);

                if (currentChar == ' ')
                    continue;

                if (Character.isDigit(currentChar))
                    postFixQueue.enqueue(currentChar);

                if (currentChar == '(')
                    postfixStack.push(currentChar);

                if (isOperator(currentChar)) {
                    while (!postfixStack.isEmpty() && hasHigherPrecedence(currentChar, postfixStack.top())) {
                        postFixQueue.enqueue(postfixStack.pop());
                    }
                    postfixStack.push(currentChar);
                }

                if (currentChar == ')') {
                    while(!postfixStack.isEmpty()) {
                        if (isOperator(postfixStack.top()))
                            postFixQueue.enqueue(postfixStack.pop());
                        else if (postfixStack.top() == '(') {
                            postfixStack.pop();
                        }
                        else
                            throw new InvalidNotationFormatException();
                    }
                }
            }

            while (!postfixStack.isEmpty()) {
                postFixQueue.enqueue(postfixStack.pop());
            }

        } catch (InvalidNotationFormatException |
                 StackOverflowException |
                 QueueOverflowException |
                 StackUnderflowException e) {
            System.out.print(e.getMessage());
            e.printStackTrace(System.out);
        }

        return postFixQueue.toString();
    }

    public static boolean isOperator(Character ch) {
        if (ch == '+' || ch == '-' ||  ch == '*' || ch == '/')
            return true;

        return false;
    }

    public static boolean hasHigherPrecedence(Character current, Character next) {
        int currentPrecedence = 0;
        int nextPrecedence = 0;

        switch (current) {
            case '+', '-' -> {}
            case '*', '/' -> currentPrecedence = 1;
        }

        switch (next) {
            case '+', '-' -> {}
            case '*', '/' -> nextPrecedence = 1;
            case '(' -> { return false; }
        }

        if (currentPrecedence > nextPrecedence)
            return true;
        else if (currentPrecedence < nextPrecedence)
            return false;
        else
            return true;
    }

    public static double evaluateExpression(double firstNum, Character operator, double secondNum) throws InvalidNotationFormatException {
        double result;

        switch (operator) {
            case '+' -> result = secondNum + firstNum;
            case '-' -> result = secondNum - firstNum;
            case '*' -> result = secondNum * firstNum;
            case '/' -> result = secondNum / firstNum;
            default -> throw new InvalidNotationFormatException();
        }

        System.out.println("result: " + result);
        return result;
    }
}
