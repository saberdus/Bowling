import de.valtech.bowling.Frame;
import de.valtech.bowling.LastFrame;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class TestLastFrame {
    private LastFrame lastFrame;
    private Frame frame;

    @Before
    public void setUp() {
        frame = new Frame(0,0);
        lastFrame = new LastFrame(frame.getFirstRoll(), frame.getSecondRoll(), 0);
    }

    @Test
    public void TestNormalLastFrame() {
        lastFrame = new LastFrame(5, 3, 0);
        assertEquals(8, lastFrame.calculateFrameScore());
    }

    @Test
    public void TestLastFrameWithoutSpareOrStrike() {
        frame = new Frame(5,3);
        lastFrame = new LastFrame(frame.getFirstRoll(), frame.getSecondRoll(), 8);

        assertEquals(8, lastFrame.calculateFrameScore());
    }

    @Test
    public void testLastFrameWithSpare() {
        lastFrame.setFirstRoll(4);
        lastFrame.setSecondRoll(6);
        lastFrame.setThirdRoll(8);

        assertEquals(18, lastFrame.calculateFrameScore());
    }

    @Test
    public void testLastFrameWithStrike() {
        lastFrame.setFirstRoll(10);
        lastFrame.setSecondRoll(6);
        lastFrame.setThirdRoll(8);

        assertEquals(24, lastFrame.calculateFrameScore());
    }

    @Test
    public void testPerfectLastFrame() {
        lastFrame.setFirstRoll(10);
        lastFrame.setSecondRoll(10);
        lastFrame.setThirdRoll(10);

        assertEquals(30, lastFrame.calculateFrameScore());
    }
}
