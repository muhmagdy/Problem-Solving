class Solution {
    public int isWinner(int[] player1, int[] player2) {
        boolean old1 = false, prev1 = false, old2 = false, prev2 = false;
        int player1Score = 0, player2Score = 0;
        for(int i = 0; i < player1.length; i++){
            int val1 = player1[i];
            if(old1 || prev1)
                player1Score += val1*2;
            else
                player1Score += val1;
            int val2 = player2[i];
            if(old2 || prev2)
                player2Score += val2*2;
            else
                player2Score += val2;
            
            old1 = prev1;
            prev1 = val1 == 10;
            old2 = prev2;
            prev2 = val2 == 10;
        }
        if(player1Score > player2Score)
            return 1;
        if(player1Score < player2Score)
            return 2;
        return 0;
    }
}