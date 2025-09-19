import java.util.HashMap;
import java.util.Map;

class Spreadsheet {
    private final Map<String, Integer> map = new HashMap<>();

    public Spreadsheet(int rows) {
    }

    public void setCell(String cell, int value) {
        map.put(cell, value);
    }

    public void resetCell(String cell) {
        map.remove(cell);
    }

    public int getValue(String formula) {
        String expr = formula.substring(1).trim();
        String[] parts = expr.split("\\+");

        int val1 = parseOperand(parts[0].trim());
        int val2 = parseOperand(parts[1].trim());

        return val1 + val2;
    }

    private int parseOperand(String operand) {
        if (Character.isLetter(operand.charAt(0))) {
            return map.getOrDefault(operand, 0);
        } else {
            return Integer.parseInt(operand);
        }
    }
}
