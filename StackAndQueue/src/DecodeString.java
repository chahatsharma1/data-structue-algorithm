import java.util.Stack;

class DecodeString {
    public String decodeString(String s) {
        Stack<Integer> numberStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int number = 0;

        for (char ch : s.toCharArray()){
            if (Character.isDigit(ch)){
                number =  number * 10 + (ch - '0');
            } else if (ch == '['){
                numberStack.push(number);
                stringStack.push(currentString.toString());
                currentString = new StringBuilder();
                number = 0;
            } else if (ch == ']') {
                int prevNumber = numberStack.pop();
                StringBuilder prevString = new StringBuilder(stringStack.pop());

                for (int i = 0; i < prevNumber; i++){
                    prevString.append(currentString);
                }
                currentString = prevString;
            } else {
                currentString.append(ch);
            }
        }
        return currentString.toString();
    }
}