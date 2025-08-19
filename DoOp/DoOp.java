public class DoOp {
    public static String operate(String[] args) {
        if (args.length != 3) {
            return "Error";
        }

        final int leftOperand = Integer.parseInt(args[0]);
        String operator = args[1];
        final int rightOperand = Integer.parseInt(args[2]);

        int result;

        switch (operator) {
            case "%":
                if (rightOperand == 0 || rightOperand == 0) {
                    return "Error";
                }
                result = leftOperand % rightOperand;
                break;
            case "+":
                result = leftOperand + rightOperand;
                break;
            case "-":
                result = leftOperand - rightOperand;
                break;
            case "*":
                result = leftOperand * rightOperand;
                break;
            case "/":
                if (rightOperand == 0 || rightOperand == 0) {
                    return "Error";
                }
                result = leftOperand / rightOperand;
                break;
            default:
                return "Error";
        }
        return result + "";
    }
}
