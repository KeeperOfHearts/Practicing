import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);
        String input = inputReader.nextLine();

        System.out.println(input);
        System.out.println("--------------------");
        System.out.println(encode(input));
        System.out.println("--------------------");
        System.out.println(decode(encode(input)));


    }

    public static String encode(String input) {
        StringBuilder result = new StringBuilder();
        int count = 0;
        char current = input.charAt(0);

        for (char c : input.toCharArray()) {
            if (c == current) {
                count++;
            } else {
                if (count > 1) result.append(count);
                result.append(current);
                current = c;
                count = 1;
            }
        }
        if (count > 1) result.append(count);
        result.append(current);

        return result.toString();
    }

    public static String decode(String input) {
        StringBuilder result = new StringBuilder();
        String count = "0";

        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                count += "" + c;
            } else {
                int amount = Integer.parseInt(count);
                if (amount == 0) amount++;
                result.append(String.valueOf(c).repeat(amount));
                count = "0";
            }
        }
//        int amount = Integer.parseInt(count);
//        if (amount > 1) result.append(amount);
//        result.append(current);

        return result.toString();
    }
}