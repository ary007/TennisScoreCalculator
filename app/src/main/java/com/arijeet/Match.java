package com.arijeet;

import com.arijeet.model.Player;
import com.arijeet.service.ScoreService;

public class Match {
    final Player player1;
    final Player player2;
    Player winnerOfSet;
    final ScoreService scoreService;

    public Match(String player1Name, String player2Name) {
        player1 = new Player(player1Name);
        player2 = new Player(player2Name);
        this.scoreService = new ScoreService(player1,player2);
    }

    public void pointWonBy(String player) {
       if(player1.getName().equals(player)) {
           addPointTo(player1);
       } else {
           addPointTo(player2);
       }
    }

    private void addPointTo(Player player) {
        player.addPoint();
        if (scoreService.isGameWon()) {
            scoreService.gameWonBy(player);
        }
    }

    public String score() {
        String setScore = scoreService.getScoreOfSet();
        winnerOfSet = scoreService.getWinnerOfSet();
        if(winnerOfSet != null) return setScore + ", " + winnerOfSet.getName() + " wins";
            String gameScore = scoreService.getGameScore();
        if (!gameScore.isEmpty()) {
            return setScore + ", " + gameScore;
        } else {
            return setScore;
        }
    }
}
