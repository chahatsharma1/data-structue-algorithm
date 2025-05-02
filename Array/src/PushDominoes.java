public class PushDominoes {
    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        int force = 0;
        int[] forces = new int[n];

        for (int i = 0; i < n; i++){
            if (dominoes.charAt(i) == 'R'){
                force = n;
            } else if (dominoes.charAt(i) =='L'){
                force = 0;
            } else {
                force = Math.max(force - 1, 0);
            }
            forces[i] += force;
        }

        for (int i = n - 1; i >= 0; i--){
            if (dominoes.charAt(i) == 'L'){
                force = n;
            } else if (dominoes.charAt(i) =='R'){
                force = 0;
            } else {
                force = Math.max(force - 1, 0);
            }
            forces[i] -= force;
        }

        StringBuilder ans = new StringBuilder();
        for (int num : forces){
            if (num < 0){
                ans.append("L");
            } else if (num > 0){
                ans.append("R");
            } else {
                ans.append(".");
            }
        }
        return ans.toString();
    }
}
