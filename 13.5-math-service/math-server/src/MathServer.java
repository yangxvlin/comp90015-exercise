/**
 * Xulin Yang, 904904
 *
 * @create 2019-11-25 16:58
 * description:
 **/

public abstract class MathServer implements IMathService {
    public abstract void run();

    public String execute(String request) {
        String[] inputs = request.split(":");

        if (inputs.length < 3) {
            return "Invalid format! require: <service>:<number 1>:<number 2>";
        }

        String opt = inputs[0];
        double value1;
        double value2;

        try {
            value1 = Double.parseDouble(inputs[1]);
            value2 = Double.parseDouble(inputs[2]);
        } catch (Exception e) {
            return "Invalid number format!";
        }

        double result;
        if (opt.equals(ADD)) {
            result = add(value1, value2);
        } else if (opt.equals(SUB)) {
            result = substract(value1, value2);
        } else if (opt.equals(MUL)) {
            result = multiply(value1, value2);
        } else if (opt.equals(DIV)) {
            result = divide(value1, value2);
        } else {
            return "Invalid operator!";
        }

        return inputs[1] + " " + opt + " " + inputs[2] + " = " + Double.toString(result);
    }
}
