public class ValidWord {
    public boolean isValid(String word) {
        if(word.length() < 3){
            return false;
        }

        boolean hasVowel = false;
        boolean hasConsonant = false;

        for (char ch : word.toCharArray()){
            if(!Character.isLetterOrDigit(ch)){
                return false;
            }
            if (checkVowel(ch)){
                hasVowel = true;
            } else if (Character.isLetter(ch)){
                hasConsonant = true;
            }
        }
        return hasVowel && hasConsonant;
    }

    private boolean checkVowel(char ch){
        ch = Character.toLowerCase(ch);
        return ch == 'a' || ch == 'e'|| ch =='i' || ch == 'o' || ch == 'u';
    }
}