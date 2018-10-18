import de.valtech.bowling.Bowler;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class TestBowler {
    private Bowler bowler;

    @Before
    public void setUp() {
        bowler = new Bowler();
    }

    @Test
    public void testOneNormalFrame() {
        bowler.playFrame(5,3);

        assertEquals(8, bowler.calculateBowlerScore());
    }

    @Test
    public void testStrikeFrame() {
        bowler.playStrikeFrame();
        bowler.playFrame(3,2);
        bowler.playFrame(5,2);

        assertEquals(27, bowler.calculateBowlerScore());
    }

    @Test
    public void testSpareFrame() {
        bowler.playFrame(5,5);
        bowler.playFrame(3,2);

        assertEquals(18, bowler.calculateBowlerScore());
    }

    @Test
    public void testMultipleFrames() {
        bowler.playFrame(5,5);
        bowler.playStrikeFrame();
        bowler.playFrame(3,2);
        bowler.playFrame(9,0);

        assertEquals(49, bowler.calculateBowlerScore());
    }

    @Test
    public void testScoreOfPerfectBowlingGame() {
        for(int frame = 0; frame <=8; frame++) {
            bowler.playStrikeFrame();
        }
        bowler.playLastFrame(10, 10, 10);
        assertEquals(300, bowler.calculateBowlerScore());
    }
}
