import java.util.Scanner;

class Calculator {
    public static int calculate(int num1, char operator, int num2) {
        return switch (operator) {
            case '+' -> num1 + num2;
            case '-' -> num1 - num2;
            case '*' -> num1 * num2;
            case '/' -> num1 / num2;
            default -> throw new IllegalArgumentException("Неподдерживаемая операция");
        };
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Input: ");
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("exit")) {
                    System.out.println("Завершение программы.");
                    break;
                }

                String[] tokens = input.split("\\s+");
                if (tokens.length != 3) {
                    throw new IllegalArgumentException("Неверный формат ввода");
                }

                int num1 = Integer.parseInt(tokens[0]);
                char operator = tokens[1].charAt(0);
                int num2 = Integer.parseInt(tokens[2]);

                if (num1 < 1 || num1 > 10 || num2 < 1 || num2 > 10) {
                    throw new IllegalArgumentException("Числа должны быть от 1 до 10");
                }

                if (!"+-*/".contains(String.valueOf(operator))) {
                    throw new IllegalArgumentException("Неподдерживаемая операция");
                }

                int result = Calculator.calculate(num1, operator, num2);
                System.out.println("Output:");
                System.out.println(result);
            } catch (NumberFormatException | ArithmeticException e) {
                System.out.println("Output:");
                System.out.println("Ошибка: Неправильный формат числа");
                break;
            }
        }
        scanner.close();
    }
}
