/**
 *
 * @author
 */
public class Queens {

    private int[] queenPos = new int[Constants.SIZE];

    private int combinations;

    /**
     * Checks, is queens attack each other by vertical and diagonal.
     * @return true if queens attack each other by vertical and diagonal.
     */
    public boolean checkPosition(){
        for(int i = 0; i < Constants.SIZE; i++)
            for(int j = i + 1; j < Constants.SIZE; j++) {
                if (queenPos[i] == queenPos[j] ||
                        (Math.abs(i - j) == (Math.abs(queenPos[i] - queenPos[j])))) {
                    return false;
                }
            }
        return true;
    }

    /**
     * Move queen one position to the right and return true
     * If queen in a end position, the queen is set to a first position
     * and moves the queen located above and so on
     * If the lines remains returns false
     * @param row row number.
     * @return false if queen in a end position.
     */
    public boolean move(int row){
        if(queenPos[row] < Constants.SIZE -1) {
            queenPos[row]++;
            return true;
        }

        queenPos[row] = 0;

        return row != 0 && move(row - 1);
    }

    /**
     * generate new combination of queens on board
     * @return true if queens has moves
     */
    public boolean next(){
        return move(Constants.SIZE - 1);
    }

    public void findAllSolutions(){
        while (next()){
            if(checkPosition()){
                Output.drawBoard(this);
                combinations++;
            }
        }
        System.out.println("Total: " + combinations);
    }

    /**
     * queenPos getter.
     * @return queenPos
     */
    public int[] getQueenPos(){
        return queenPos;
    }

    /**
     *  Starts look all solutions by alignment queens
     * @param args
     */
    public static void main(String[] args){
        Queens queen = new Queens();

        queen.findAllSolutions();
    }

}
