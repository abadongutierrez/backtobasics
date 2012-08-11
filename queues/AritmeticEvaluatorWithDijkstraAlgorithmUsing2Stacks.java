class Stack<T> {
    private java.util.List<T> elements = new java.util.ArrayList<T>();

    public void push(T item) {
        elements.add(item);
    }

    public T pop() {
        if (this.size() > 0) {
            T popedItem = elements.get(this.size() - 1);
            elements.remove(popedItem);
            return popedItem;
        }
        return null;
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    public int size() {
        return this.elements.size();
    }
}

public class AritmeticEvaluatorWithDijkstraAlgorithmUsing2Stacks {

    public static int evaluate(String expression) {
        Stack<Integer> operands = new Stack<Integer>();
        Stack<String> operators = new Stack<String>();

        for (char c: expression.toCharArray()) {
            // ignore left parentesis (and white spaces)
            if (c == '(' || c == ' ') {
                continue;
            }
            else if (c == ')') {
                // pop an operator
                String operator = operators.pop();

                // do the math
                if ("+".equals(operator)) {
                    Integer result = operands.pop() + operands.pop();
                    operands.push(result);
                }
                // the order affects the operation!
                else if ("-".equals(operator)) {
                    Integer op1 = operands.pop();
                    Integer op2 = operands.pop();
                    Integer result = op2 - op1;
                    operands.push(result);   
                }
                else if ("*".equals(operator)) {
                    Integer result = operands.pop() * operands.pop();
                    operands.push(result);   
                }
                // the order affects the operation!
                else if ("/".equals(operator)) {
                    Integer op1 = operands.pop();
                    Integer op2 = operands.pop();
                    Integer result = op2 / op1;
                    operands.push(result);   
                }
                else if (operator != null) {
                    throw new RuntimeException("Unsupported operator [" + operator + "]");
                }
            }
            // its an operand
            else if (Character.isDigit(c)) {
                operands.push(Integer.parseInt(String.valueOf(c)));
            }
            // its an operator
            else {
                operators.push(String.valueOf(c));
            }
        }

        return operands.pop();
    }

    public static void main(String[] args) {
        String[] expressions = {
            "5",
            "(1)",
            "(8+1)",
            "(9 * 2)",
            "((2*2) + (4-2))",
            "(((8/2)+2))-4)",
            "((((8/2)+2))-4) -     4)"
        };

        for (String expression: expressions) {
            System.out.printf("%s = %d\n", expression, evaluate(expression));
        }
    }
}