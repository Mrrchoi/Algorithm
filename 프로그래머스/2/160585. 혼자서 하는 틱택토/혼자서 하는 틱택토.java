class Solution {
    public boolean x_ttt = false, o_ttt = false;
    public void tick_tack_toe(String[] board) {
        for(int i = 0; i < 3; i++) {
            char[] ch = {board[0].charAt(i), board[i].charAt(0)};
            boolean[] check = {true, true};

            for(int j = 1; j < 3; j++) {
                if(ch[0] != board[j].charAt(i)) check[0] = false;
                if(ch[1] != board[i].charAt(j)) check[1] = false;
            }

            for(int j = 0; j < 2; j++) {
                if(check[j] && ch[j] == 'X') x_ttt = true;
                else if(check[j] && ch[j] == 'O') o_ttt = true;
            }
        }
        
        boolean[] check = {true, true};
        
        for(int i = 1; i < 3; i++) {
            if(board[0].charAt(0) != board[i].charAt(i)) check[0] = false;
            if(board[0].charAt(2) != board[i].charAt(2 - i)) check[1] = false;
        }

        for(int j = 0; j < 2; j++) {
            if(check[j] && board[1].charAt(1) == 'X') x_ttt = true;
            else if(check[j] && board[1].charAt(1) == 'O') o_ttt = true;
        }
    }
    public int solution(String[] board) {
        int answer = 0;
        int x_count = 0, o_count = 0;
        
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(board[i].charAt(j) == 'X') x_count++;
                else if(board[i].charAt(j) == 'O') o_count++;
            }
        }

        if(x_count > o_count || o_count - x_count > 1) {
            return answer;
        }
        
        tick_tack_toe(board);

        if(!(x_ttt && o_ttt) && !(o_ttt && x_count == o_count) && !(x_ttt && o_count > x_count)) {
            answer = 1;
        }

        return answer;
    }
}