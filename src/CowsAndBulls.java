public class CowsAndBulls {

    public final static int NUM_DIGITS = 4;
    public final static int MAX_VALUE = 9876;
    public final static int MIN_VALUE = 1234;
    public final static int MAX_GUESSES = 10;
    int mysteryNumber = 0;
    static int guesses;
    boolean didWin = false;

    public CowsAndBulls(int seed){
        guesses = MAX_GUESSES;
        NumberPicker numberPicker = new NumberPicker(seed, 1, 9);
        //        mysteryNumber = numberPicker.nextInt()*10;
//        mysteryNumber = (mysteryNumber + numberPicker.nextInt())*10;
//        mysteryNumber = (mysteryNumber + numberPicker.nextInt())*10;
        while((mysteryNumber < MAX_VALUE)){
            mysteryNumber = mysteryNumber + numberPicker.nextInt();
            if (mysteryNumber > MIN_VALUE){
                break;
            }
            mysteryNumber = mysteryNumber * 10;
        }

    }

    public int guessesRemaining(){
        return guesses;
    }

    public Result guess(int guessNumber){
        Result result = new Result(NumberUtils.countIntersect(mysteryNumber,guessNumber),NumberUtils.countMatches(mysteryNumber,guessNumber));
        guesses--;
        if (result.bulls() == 4){
            didWin = true;
        }
        return result;
    }

    public int giveUp(){
        guesses = 10;
        return mysteryNumber;
    }

    public boolean gameOver(){
        return didWin || guesses == 0;
    }







}
