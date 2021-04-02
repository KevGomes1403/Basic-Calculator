import java.util.ArrayList;
import java.util.Collections;

public class Operations {
    private ArrayList<Numbers> numbers;
    private ArrayList<String> operators;

    public Operations() {
        numbers = new ArrayList<>();
        operators = new ArrayList<>();
    }

    public Operations(String inp) {
        this();

        int cur = 0;

        for (int i = 0; i < inp.length(); i++) {
            if (inp.charAt(i) == '+' || inp.charAt(i) == '-' ||
                    inp.charAt(i) == 'x' || inp.charAt(i) == '/') {

                double thisNum = Double.parseDouble(inp.substring(cur, i));
                numbers.add(new Numbers(thisNum));

                String thisOper = Character.toString(inp.charAt(i));
                operators.add(thisOper);
                cur = i + 1;
            }
        }

        double thisNum = Double.parseDouble(inp.substring(cur));
        numbers.add(new Numbers(thisNum));
    }

    public double compute() {
        double result = numbers.get(0).getNumber();

        if (operators.size() == 0) {
            return result;
        }

        for (int i = 1; i < numbers.size(); i++) {
            if (operators.get(i - 1).equals("+")) {
                result += numbers.get(i).getNumber();
            } else if (operators.get(i - 1).equals("-")) {
                result -= numbers.get(i).getNumber();
            } else if (operators.get(i - 1).equals("x")) {
                result *= numbers.get(i).getNumber();
            } else if (operators.get(i - 1).equals("/")) {
                result /= numbers.get(i).getNumber();
            }
        }

        return result;
    }

    public String toString() {
        String result = "";

        // TODO

        return result;
    }
}
