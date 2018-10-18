package de.valtech.bowling;


import java.util.ArrayList;

public class Bowler {
    private int score = 0;
    private int tmpScore;
    private ArrayList<Frame> frames;
    private String bowlerName;
    private Frame frame;
    private LastFrame lastFrame;
    private int[] rolls;
    private int currentRoll = 0;

    public Bowler() {
        frames = new ArrayList<>();
        rolls = new int[21];
    }

    //Play a Strike
    public void playStrikeFrame() {
        frame = new Frame();
        frame.setStrike(true);
        frame.setFirstRoll(10);

        frames.add(frame);
    }

    //Play the first 9 frames as spares or normal rolls
    public void playFrame(int firstRoll, int secondRoll) {
        frame = new Frame(firstRoll, secondRoll);

        if(firstRoll + secondRoll == 10) {
            frame.setSpare(true);
        } else {
            frame.setNormalFrame(true);
        }
        frames.add(frame);
    }

    //Play the last frame
    public void playLastFrame(int firstRoll, int secondRoll, int thirdRoll) {
        lastFrame = new LastFrame(firstRoll, secondRoll, thirdRoll);

        if(firstRoll == 10) {
            lastFrame.setStrike(true);
        } else {
            if(firstRoll + secondRoll == 10) {
                lastFrame.setSpare(true);
            } else {
                lastFrame.setNormalFrame(true);
            }
        }
        frames.add(lastFrame);
    }

    //Compute total score
    public int calculateBowlerScore() {
        int frameScore;
        int frameIndex;
        ArrayList<Frame> bowlerFrames = getFrames();

        for(Frame frame: bowlerFrames) {
            frameIndex = bowlerFrames.indexOf(frame);
            //Strike
            if(frame.isStrike()) {
                frameScore = 10 + calculateStrikeFrameScore(frameIndex);
            } else {
                //Spare
                if(frame.isSpare()) {
                    frameScore = 10 + calculateSpareFrameScore(frameIndex);
                } else {
                    //Normal roll
                    frameScore = frame.calculateFrameScore();
                }
            }
            frame.setFrameScore(frameScore);
            System.out.println("SCORE OF FRAME "+ (frameIndex + 1) +": "+ frame.getFrameScore());

            score += frameScore;
        }
        return score;
    }

    private int calculateStrikeFrameScore(int frameIndex) {
        tmpScore = 0;
        Frame nextFrame;
        Frame afterNextFrame;

        switch(frameIndex) {
            case 8:
                nextFrame = getFrames().get(frameIndex + 1);
                tmpScore = nextFrame.getFirstRoll() + nextFrame.getSecondRoll();
                break;
            case 9:
                lastFrame = (LastFrame) getFrames().get(9);
                tmpScore = lastFrame.getSecondRoll() + lastFrame.getThirdRoll();
                break;
            default:
                nextFrame = getFrames().get(frameIndex + 1);
                afterNextFrame = getFrames().get(frameIndex + 2);

                if(nextFrame.isStrike()) {
                    tmpScore = nextFrame.getFirstRoll() + afterNextFrame.getFirstRoll();
                } else {
                    tmpScore = nextFrame.getFirstRoll() + nextFrame.getSecondRoll();
                }
                break;
        }
        return tmpScore;
    }

    private int calculateSpareFrameScore(int frameIndex) {
        tmpScore = 0;
        Frame nextFrame;

        switch(frameIndex) {
            case 9:
                lastFrame = (LastFrame) getFrames().get(9);
                tmpScore = lastFrame.getThirdRoll();
                break;
            default:
                nextFrame = getFrames().get(frameIndex + 1);
                tmpScore = nextFrame.getFirstRoll();
                break;
        }
        return tmpScore;
    }

    public void roll(int knockedDownPins) {
        rolls[getCurrentRoll()] = knockedDownPins;
        setCurrentRoll(getCurrentRoll()+1);
    }

    /**
     * Calculate the until now played score
     *
     * @return the current result of the until now played rolls
     */
    public int currentScore() {
        int score = 0;
        int indexInRollsArray = 0;
        for(int frame = 0; frame < 10; frame++) {
            //Strike
            if((rolls[indexInRollsArray] == 10)) {
                score += 10 + rolls[indexInRollsArray + 1] + rolls[indexInRollsArray + 2];
                indexInRollsArray += 1;
            } else {
                //Spare
                if((rolls[indexInRollsArray] + rolls[indexInRollsArray+1]) == 10) {
                    score += 10 + rolls[indexInRollsArray+2];
                } else {
                    //default
                    score += rolls[indexInRollsArray] + rolls[indexInRollsArray+1];
                }
                indexInRollsArray += 2;
            }
        }
        return score;
    }

    public int getScore() {
        return score;
    }

    private ArrayList<Frame> getFrames() {
        return frames;
    }

    public void setFrames(ArrayList<Frame> frames) {
        this.frames = frames;
    }

    public String getBowlerName() {
        return bowlerName;
    }

    public void setBowlerName(String bowlerName) {
        this.bowlerName = bowlerName;
    }

    public int getCurrentRoll() {
        return currentRoll;
    }

    public void setCurrentRoll(int currentRoll) {
        this.currentRoll = currentRoll;
    }
}
