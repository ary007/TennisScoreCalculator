package com.arijeet;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

public class MatchTest {

    @Test void checkScoreIsZeroWhenNoGameIsWon() {
        Match match=new Match("player 1", "player 2");
        assertEquals("0-0", match.score());
    }

    @Test void checkScoreWhenPlayerOneHasWonTwoPointsAndPlayerTwoThreePoints() {
        Match match=new Match("player 1", "player 2");
        IntStream.range(0, 2).mapToObj(i -> "player 1").forEach(match::pointWonBy);
        IntStream.range(0, 3).mapToObj(i -> "player 2").forEach(match::pointWonBy);
        assertEquals("0-0, 30-40", match.score());
    }

    @Test void checkDeuce() {
        Match match=new Match("player 1", "player 2");
        IntStream.range(0, 3).mapToObj(i -> "player 1").forEach(match::pointWonBy);
        IntStream.range(0, 3).mapToObj(i -> "player 2").forEach(match::pointWonBy);
        assertEquals("0-0, Deuce", match.score());
    }

    @Test void checkGameWonByPlayer() {
        Match match=new Match("player 1", "player 2");
        IntStream.range(0, 4).mapToObj(i -> "player 1").forEach(match::pointWonBy);
        assertEquals("1-0", match.score());
    }

    @Test void checkSetWonByPlayer() {
        Match match=new Match("player 1", "player 2");
        IntStream.range(0, 6).forEach(i-> match.player1.addGameWon());
        assertEquals("6-0, player 1 wins", match.score());
    }

    @Test void checkNoOneWinsInTie() {
        Match match=new Match("player 1", "player 2");
        IntStream.range(0, 6).forEach(i-> match.player1.addGameWon());
        IntStream.range(0, 6).forEach(i-> match.player2.addGameWon());
        assertEquals("6-6", match.score());
    }

    @Test void checkScoringAfterTie() {
        Match match=new Match("player 1", "player 2");
        IntStream.range(0, 6).forEach(i-> match.player1.addGameWon());
        IntStream.range(0, 6).forEach(i-> match.player2.addGameWon());
        IntStream.range(0, 2).mapToObj(i -> "player 1").forEach(match::pointWonBy);
        match.pointWonBy("player 2");
        assertEquals("6-6, 2-1", match.score());
    }

    @Test void checkWinnerAfterPlayingTieBreaker() {
        Match match=new Match("player 1", "player 2");
        IntStream.range(0, 6).forEach(i-> match.player1.addGameWon());
        IntStream.range(0, 6).forEach(i-> match.player2.addGameWon());
        IntStream.range(0, 7).mapToObj(i -> "player 1").forEach(match::pointWonBy);
        assertEquals("7-6, player 1 wins", match.score());
    }
}
