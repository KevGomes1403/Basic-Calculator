import java.util.ArrayList;
import java.util.Collections;

public class Operations {
    private ArrayList<String> calcInput;
    private ArrayList<Numbers> numbers;
    private ArrayList<String> operators;

    public Operations() {
        calcInput = new ArrayList<>();
        numbers = new ArrayList<>();
        operators = new ArrayList<>();
    }

    public Operations(ArrayList<String> inp) {
        this();

        for (String s: inp) {
            calcInput.add(s);
        }

        // Add all numbers to calcInput by creating individual Numbers objects
        // TODO: Add a way to handle decimals
        ArrayList<Double> num = new ArrayList<Double>();

        for (String s: calcInput) {
            if (strContains(s)) {
                num.add(Double.parseDouble(s));
            } else {
                operators.add(s);
                numbers.add(new Numbers(num));
                num.clear();
            }
        }

        numbers.add(new Numbers(num));
        num.clear();
    }

    public double compute() {
        double result = numbers.get(0).getNumber();

        if (operators.size() == 0) {
            return result;
        }

        if (operators.get(0).equals("+")) {
            result += numbers.get(1).getNumber();
        }

        return result;
    }

    public static boolean strContains(String s) {
        if (s.equals("0") || s.equals("1") || s.equals("2") || s.equals("3") || s.equals("4") || s.equals("5")
                || s.equals("6") || s.equals("7") || s.equals("8") || s.equals("9") || s.equals(".")) {
            return true;
        }

        return false;
    }

    public String toString() {
        String result = "";

        for (String s: calcInput) {
            result += s;
        }

        return result;
    }
}
