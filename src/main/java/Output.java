/**
 * This class serves to output data in different ways.
 */
public class Output {

    private Output(){ throw new AssertionError("that class shouldn't be implemented"); }
    /**
     * Output object in console.
     * @param object object that shout be output.
     */
    public static void println(Object object){
        System.out.println(object);
    }

    /**
     * Output board and queens alignment
     */
    public static void drawBoard(Queens queens){
        for(int i = 0; i < Constants.DESK_SIZE; i++){
            int position = queens.getQueenPos()[i];
            for(int j = 0; j < Constants.DESK_SIZE; j ++){

                System.out.print(j == position ? "|Q|" : "|_|");
            }
            System.out.println();
        }
        System.out.println("========================");
    }

}
