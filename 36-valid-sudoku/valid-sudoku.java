class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> rowSet = new HashSet<>();
        HashSet<Character> colSet = new HashSet<>();
        HashSet<Character> sqSet = new HashSet<>();

        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if((rowSet.contains(board[i][j])) || (colSet.contains(board[j][i]))){
                    return false;
                }
                else if(board[i][j] != '.'){
                    rowSet.add(board[i][j]);
                }

                if(board[j][i] != '.'){
                    colSet.add(board[j][i]);
                }

                if((i%3 == 0) && (j%3 == 0)){
                    for(int k=i; k<i+3; k++){
                        for(int l=j; l<j+3; l++){
                            if(sqSet.contains(board[k][l])){
                                return false;
                            }
                            else if(board[k][l] != '.'){
                                sqSet.add(board[k][l]);
                            }
                        }

                    }
                    sqSet.clear();
                    
                }


            }
            rowSet.clear();
            colSet.clear();
        }
        return true;
    }
}