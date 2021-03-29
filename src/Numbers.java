import java.util.ArrayList;
import java.util.Collections;

public class Numbers {
    private ArrayList<Double> inp;
    private double number;

    public Numbers() {
        inp = new ArrayList<>();
    }

    public Numbers (ArrayList<Double> d) {
        this();

        for (Double i: d) {
            inp.add(i);
        }

        number = 0.0;

        this.convertToDouble();

    }

    public void convertToDouble() {
        int multiplier = 1;
        for (int i = inp.size() - 1; i >= 0; i--) {
            number += inp.get(i) * multiplier;
            multiplier *= 10;
        }
    }

    public double getNumber() {
        return number;
    }
}
