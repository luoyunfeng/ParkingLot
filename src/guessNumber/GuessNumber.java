package guessNumber;

public class GuessNumber {

    private String randomNumber;

    public GuessNumber(String randomNumber) {
        this.randomNumber = randomNumber;
    }

    public String validate(String userInput) {

        int ANum = getANum(userInput);
        int BNum = getBNum(userInput)-ANum;
        return ANum+"a"+BNum+"b";
    }
    public int getANum(String userInput){
        char input[] =  userInput.toCharArray();
        char random[] = this.randomNumber.toCharArray();
        int rightNum = 0;
        for (int i =0;i<input.length;i++){
            if(input[i]==random[i])
                rightNum++;
        }
        return rightNum;
    }
    public int getBNum(String userInput){
        char input[] =  userInput.toCharArray();
        char random[] = this.randomNumber.toCharArray();
        int rightNum = 0;
        for (int i =0;i<input.length;i++){
            for (int j=0;j<random.length;j++) {
                if(input[i]==random[j])
                    rightNum++;
            }
        }
        return rightNum;
    }
}
