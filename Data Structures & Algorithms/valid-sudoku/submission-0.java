class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        // for row 
        for (int row = 0; row < 9; row++) {

    HashSet<Character> seen = new HashSet<>();

    for (int col = 0; col < 9; col++) {

        char current = board[row][col];

        if (current == '.') {
            continue;
        }

        if (seen.contains(current)) {
            return false;
        }

        seen.add(current);
    }
}


    // for column 
    for (int col = 0; col < 9; col++) {

    HashSet<Character> seen = new HashSet<>();

    for (int row = 0; row < 9; row++) {

        char current = board[row][col];

        if (current == '.') {
           continue;
        }

        if (seen.contains(current)) {
           return false;
        }

        seen.add(current);

    }
    }

    // for box 
    for (int startRow = 0; startRow < 9; startRow += 3) {

    for (int startCol = 0; startCol < 9; startCol += 3) {

        HashSet<Character> seen = new HashSet<>();

        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {

                char current = board[startRow + i][startCol + j];

                if (current == '.') {
                    continue;
                }

                if (seen.contains(current)) {
                    return false;
                }

                seen.add(current);
            }
        }
    }
}
 return true;
    }
}
