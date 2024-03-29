package com.example.cs2340c_team40;

import org.junit.Test;

import static org.junit.Assert.*;

import com.example.cs2340c_team40.Model.Score;
import com.example.cs2340c_team40.Model.Leaderboard;

public class ScoreUnitTest {
    @Test
    public void testInitializeNegativeScore() {

        Score testScore = new Score(-4, "test");
        assertEquals(0, testScore.getScore());
    }
    @Test
    public void testUpdateNegativeScore() {
        Score testScore = new Score(-20, "test2");
        testScore.setScore(30);
        assertEquals(30, testScore.getScore());
        testScore.setScore(-45);
        assertEquals(0, testScore.getScore());
    }
    @Test
    public void testValidUsername() {
        Leaderboard board = Leaderboard.getInstance();
        for (int i = 0; i < board.getSize(); i++) {
            assertNotNull(board.getScore(i).getName());
            assertNotEquals(board.getScore(i).getName().length(), 0);
        }
    }
}
