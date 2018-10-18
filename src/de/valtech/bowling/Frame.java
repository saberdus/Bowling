package de.valtech.bowling;


public class Frame {
    private int firstRoll = 0;
    private int secondRoll = 0;
    private boolean strike = false;
    private boolean spare = false;
    private boolean normalFrame = false;
    private int frameScore;

    public Frame() {
    }

    public Frame(int firstRoll, int secondRoll) {
        this.firstRoll = firstRoll;
        this.secondRoll = secondRoll;
    }

    public int calculateFrameScore() {
        return getFirstRoll() + getSecondRoll();
    }

    public boolean isStrike() {
        if(getFirstRoll() == 10) {
            strike = true;
        }
        return strike;
    }

    public boolean isSpare() {
        if(getFirstRoll() + getSecondRoll() == 10) {
            spare = true;
        }
        return spare;
    }

    public int getFirstRoll() {
        return firstRoll;
    }

    public void setFirstRoll(int firstRoll) {
        this.firstRoll = firstRoll;
    }

    public int getSecondRoll() {
        return secondRoll;
    }

    public void setSecondRoll(int secondRoll) {
        this.secondRoll = secondRoll;
    }

    public void setStrike(boolean strike) {
        this.strike = strike;
    }

    public void setSpare(boolean spare) {
        this.spare = spare;
    }

    public void setNormalFrame(boolean normalFrame) {
        this.normalFrame = normalFrame;
    }

    public int getFrameScore() {
        return frameScore;
    }

    public void setFrameScore(int frameScore) {
        this.frameScore = frameScore;
    }
}
