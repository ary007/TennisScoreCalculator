package com.arijeet.service;
import com.arijeet.model.Player;

public class ScoreService {
    final Player player1;
    final Player player2;
    final int gameWinningPointWhenNotTie = 4;
    final int gameWinningPointWhenTie = 7;
    final int setWinningPoints = 6;

    public ScoreService(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public boolean isGameWon() {
        int gameWinningPoint = gameWinningPointWhenNotTie;
        if(isTie()) {
            gameWinningPoint = gameWinningPointWhenTie;
        }
        int player1Points = player1.getPointsWon();
        int player2Points = player2.getPointsWon();
        if (player1Points >= gameWinningPoint && player2Points + 2 <= player1Points) {
            return true;

        } else return player2Points >= gameWinningPoint && player1Points + 2 <= player2Points;
    }

    public void gameWonBy(Player player) {
        player.addGameWon();
        resetPoints();
    }

    private void resetPoints() {
        player1.resetPoints();
        player2.resetPoints();
    }

    public String getScoreOfSet() {
      return player1.getGamesWon() + "-" + player2.getGamesWon();
    }

    public String getGameScore() {
    int player1Points=player1.getPointsWon();
    int player2Points=player2.getPointsWon();
    int[] scoreMapper={0,15,30,40};
    if(isTie()) {
     return (player1Points > 0 || player2Points > 0) ? player1.getPointsWon() + "-" + player2.getPointsWon() : "";
    } else {
        if (player1Points >= 3 && player1Points==player2Points) {
            return "Deuce";
        } else if (player1Points >= gameWinningPointWhenNotTie && player2Points + 1 == player1Points) {
            return "Advantage " + player1.getName();
        } else if (player2Points >= gameWinningPointWhenNotTie && player1Points + 1 == player2Points) {
            return "Advantage " + player2.getName();
        }

        return (player1Points > 0 || player2Points > 0) ? scoreMapper[player1Points] + "-" + scoreMapper[player2Points] : "";
    }
    }

     public Player getWinnerOfSet() {
         int player1GamesWon=player1.getGamesWon();
         int player2GamesWon=player2.getGamesWon();
        if (player1GamesWon > setWinningPoints || (player1GamesWon == setWinningPoints && player2GamesWon + 2 <= player1GamesWon)) {
            return player1;
        } else if(player2GamesWon > setWinningPoints || (player2GamesWon == setWinningPoints && player1GamesWon + 2 <= player2GamesWon)) {
            return player2;
        }
        return null;
    }

    private boolean isTie() {
        return player1.getGamesWon() == setWinningPoints && player2.getGamesWon() == setWinningPoints;
    }
}


