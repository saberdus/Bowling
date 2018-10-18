package de.valtech.bowling;


public class LastFrame extends Frame {
    private int thirdRoll;

    public LastFrame(int firstRoll, int secondRoll, int thirdRoll) {
        super(firstRoll, secondRoll);
        this.thirdRoll = thirdRoll;
    }

    @Override
    public int calculateFrameScore() {
        //Strike or Spare
        if( (super.isStrike()) || (super.isSpare()) ) {
            return getFirstRoll() + getSecondRoll() + getThirdRoll();
        }
        return getFirstRoll() + getSecondRoll();
    }

    public int getThirdRoll() {
        return thirdRoll;
    }

    public void setThirdRoll(int thirdRoll) {
        this.thirdRoll = thirdRoll;
    }
}
