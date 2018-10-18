import de.valtech.bowling.Frame;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class TestFrame {
    private Frame frame;

    @Before
    public void setUp() {
        frame = new Frame();
    }

    @Test
    public void testFirstRollInFrame() {
        firstRollInFrame(4);

        assertEquals(4, frame.getFirstRoll());
    }

    @Test
    public void testSecondRollInFrame() {
        secondRollInFrame(3);

        assertEquals(3, frame.getSecondRoll());
    }

    @Test
    public void testFrameScore() {
        firstRollInFrame(5);
        secondRollInFrame(3);

        assertEquals(8, frame.calculateFrameScore());
    }

    @Test
    public void testSpare() {
        firstRollInFrame(4);
        secondRollInFrame(6);

        assertEquals(true, frame.isSpare());
    }

    @Test
    public void testSpareFailed() {
        firstRollInFrame(7);
        secondRollInFrame(0);

        assertEquals(false, frame.isSpare());
    }

    @Test
    public void testStrike() {
        firstRollInFrame(10);

        assertEquals(true, frame.isStrike());
    }

    @Test
    public void testStrikeFailed() {
        firstRollInFrame(9);

        assertEquals(false, frame.isStrike());
    }

    private void firstRollInFrame(int knockedPins) {
        frame.setFirstRoll(knockedPins);
    }

    private void secondRollInFrame(int knockedPins) {
        frame.setSecondRoll(knockedPins);
    }
}
