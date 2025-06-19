import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.lang.Math;

public class Calculator {

    private static final String HISTORY_FILE = "calculator_history.txt";

    public Calculator() {
    } // Default constructor - необходим, если класс public

    public static void main(String[] args) {
        Calculator calculator = new Calculator(); // Create an instance of Calculator
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите уравнение (или 'history' для просмотра истории, 'exit' для выхода):");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                break;
            } else if (input.equalsIgnoreCase("history")) {
                calculator.printHistory();
            } else {
                try {
                    double result = calculator.evaluateExpression(input);
                    System.out.println("Результат: " + result);
                    calculator.saveToHistory(input, result);
                } catch (Exception e) {
                    System.out.println("Ошибка: " + e.getMessage());
                }
            }
        }

        System.out.println("Программа завершена.");
        scanner.close();
    }

    // Метод для вычисления выражения
    public double evaluateExpression(String expression) {
        expression = expression.replaceAll("\\s+", ""); // Remove spaces

        // Tokenize the expression
        List<String> tokens = tokenize(expression);

        // Convert to postfix notation (Reverse Polish Notation)
        List<String> postfix = infixToPostfix(tokens);

        // Evaluate the postfix expression
        return evaluatePostfix(postfix);
    }


    // Метод для токенизации выражения (разбиение на лексемы)
    private List<String> tokenize(String expression) {
        List<String> tokens = new ArrayList<>();
        StringBuilder currentToken = new StringBuilder();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (Character.isDigit(c) || c == '.' ) {
                currentToken.append(c);
            }
            else if (c == '-') {
                // Check if it's a negative sign or subtraction operator
                if (currentToken.length() == 0 && (tokens.isEmpty() || (!tokens.isEmpty() && (tokens.get(tokens.size() - 1).equals("(") )))) {
                    // Negative number
                    currentToken.append(c);
                } else {
                    // Subtraction operator
                    if (currentToken.length() > 0) {
                        tokens.add(currentToken.toString());
                        currentToken = new StringBuilder();
                    }
                    tokens.add(String.valueOf(c));
                }
            }

            else if (Character.isLetter(c) || c == '|') {
                currentToken.append(c);
            }
            else {
                if (currentToken.length() > 0) {
                    tokens.add(currentToken.toString());
                    currentToken = new StringBuilder();
                }
                tokens.add(String.valueOf(c));
            }

            // Add the currentToken to tokens if it's the last character
            if (i == expression.length() - 1 && currentToken.length() > 0) {
                tokens.add(currentToken.toString());
            }
        }



        return tokens;
    }


    // Метод для преобразования в постфиксную нотацию (Reverse Polish Notation)
    private List<String> infixToPostfix(List<String> tokens) {
        List<String> postfix = new ArrayList<>();
        Stack<String> stack = new Stack<>();

        for (String token : tokens) {
            switch (token) {
                case "+":
                case "-":
                case "*":
                case "/":
                case "//":
                case "%":
                case "^":
                    while (!stack.isEmpty() && precedence(token) <= precedence(stack.peek())) {
                        postfix.add(stack.pop());
                    }
                    stack.push(token);
                    break;
                case "(":
                    stack.push(token);
                    break;
                case ")":
                    while (!stack.isEmpty() && !stack.peek().equals("(")) {
                        postfix.add(stack.pop());
                    }
                    stack.pop(); // Remove the opening parenthesis
                    break;
                default:
                    postfix.add(token);
            }
        }

        while (!stack.isEmpty()) {
            postfix.add(stack.pop());
        }

        return postfix;
    }


    // Метод для определения приоритета операторов
    private int precedence(String operator) {
        switch (operator) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
            case "//":
            case "%":
                return 2;
            case "^":
                return 3;
            default:
                return 0;
        }
    }

    // Метод для вычисления постфиксного выражения
    private double evaluatePostfix(List<String> postfix) {
        Stack<Double> stack = new Stack<>();

        for (String token : postfix) {
            if (Character.isDigit(token.charAt(0)) || (token.startsWith("-") && token.length() > 1 && Character.isDigit(token.charAt(1)))) {
                stack.push(Double.parseDouble(token));
            } else if (token.equals("|")) {
                double operand = stack.pop();
                stack.push(Math.abs(operand));
            } else {
                double operand2 = stack.pop();
                double operand1 = stack.pop();

                switch (token) {
                    case "+":
                        stack.push(operand1 + operand2);
                        break;
                    case "-":
                        stack.push(operand1 - operand2);
                        break;
                    case "*":
                        stack.push(operand1 * operand2);
                        break;
                    case "/":
                        if (operand2 == 0) {
                            throw new ArithmeticException("Деление на ноль");
                        }
                        stack.push(operand1 / operand2);
                        break;
                    case "//":
                        if (operand2 == 0) {
                            throw new ArithmeticException("Деление на ноль");
                        }
                        stack.push((double) Math.floor(operand1 / operand2)); // Integer division
                        break;
                    case "%":
                        if (operand2 == 0) {
                            throw new ArithmeticException("Деление на ноль");
                        }
                        stack.push(operand1 % operand2);
                        break;
                    case "^":
                        stack.push(Math.pow(operand1, operand2));
                        break;
                    default:
                        throw new IllegalArgumentException("Неизвестный оператор: " + token);
                }
            }
        }

        if (stack.size() == 1) {
            return stack.pop();
        } else {
            throw new IllegalArgumentException("Неверное выражение");
        }
    }

    // Метод для сохранения уравнения и результата в историю
    public void saveToHistory(String expression, double result) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(HISTORY_FILE, true))) {
            writer.write(expression + " = " + result + "\n");
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл истории: " + e.getMessage());
        }
    }

    // Метод для печати истории уравнений
    public void printHistory() {
        try (BufferedReader reader = new BufferedReader(new FileReader(HISTORY_FILE))) {
            String line;
            System.out.println("История уравнений:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл истории не найден.");
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла истории: " + e.getMessage());
        }
    }
}