/**
 * Created by admin on 4/15/14.
 */
public class Queens {
    public static final int SIZE = 8;

    int[] rowState = new int[SIZE];

    int combinations;

    public static void main(String[] args){
        Queens queen = new Queens();
        while (queen.next()){
            if(queen.checkPosition()){
                queen.drawBoard();

                queen.combinations++;
                System.out.println("========================");
            }
        }
        System.out.println("Total: " + queen.combinations);

    }

    /*
    Check, is queens attack each other by vertical and diagonal
     */
    public boolean checkPosition(){
        for(int i = 0; i < SIZE; i++)
            for(int j = i + 1; j < SIZE; j++) {
                if (rowState[i] == rowState[j] ||
                        (Math.abs(i - j) == (Math.abs(rowState[i] - rowState[j])))) {
                    return false;
                }
            }
        System.out.println("true");
        return true;
    }

    /*
    Move queen one position to the right and return true
    If queen in a end position< the queen is set to a first position
    and moves the queen located above and so on
     If the lines remains retruns false
     */
    public boolean move(int row){
//        System.out.println("move starts");
        if(rowState[row] < SIZE -1) {
            rowState[row]++;
            return true;
        }

        rowState[row] = 0;
        if(row == 0) {
            return false;
        }
        else {
            return move(row - 1);
        }
    }

    /*
    generate new combination of queens on board
     */
    public boolean next(){
        return move(SIZE - 1);
    }

    /*
    output on console board with queens
     */
    public void drawBoard(){
        for(int i = 0; i < SIZE; i++){
            int position = rowState[i];
            for(int j = 0; j < SIZE; j ++){

                System.out.print(j == position ? "|Q|" : "|_|");
            }
            System.out.println();
        }

    }
}
