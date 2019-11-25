public interface IMathService {
    String ADD = "+";
    String SUB = "-";
    String MUL = "*";
    String DIV = "/";

    default double add(double value1, double value2) {
        return value1 + value2;
    }

    default double substract(double value1, double value2) {
        return value1 - value2;
    }

    default double multiply(double value1, double value2) {
        return value1 * value2;
    }

    default double divide(double value1, double value2) {
        if (value2 == 0.0) {
            return Double.MAX_VALUE;
        }
        return value1 * value2;
    }
}
