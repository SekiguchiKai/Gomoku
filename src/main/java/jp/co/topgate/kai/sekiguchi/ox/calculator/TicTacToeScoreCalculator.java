package jp.co.topgate.kai.sekiguchi.ox.calculator;

import jp.co.topgate.kai.sekiguchi.ox.constantset.Moves;


/**
 * 打ち手のシミュレーションを行うためのクラス
 * Created by sekiguchikai on 2016/12/22.
 */
public class TicTacToeScoreCalculator extends ScoreCalculator {

    /**
     * 現在のゲーム盤の点数を計算するためのメソッド
     *
     * @param gameBoard ゲーム盤
     * @return そのゲーム盤の点数の合計
     */
    @Override
    public int calcScore(final Moves[][] gameBoard) {

        int totalScore = 0;

        final int arraySize = 3;

        final Moves[] movesArray = new Moves[arraySize];

        final int maxPoint = 30;
        final int minPoint = -30;

        // 横
        movesArray[0] = gameBoard[0][0];
        movesArray[1] = gameBoard[0][1];
        movesArray[2] = gameBoard[0][2];

        int score = super.calcLineScore(movesArray, maxPoint, minPoint);
        if (score == Integer.MAX_VALUE) {
            return score;
        } else if (score == Integer.MIN_VALUE) {
            return score;
        }
        totalScore += score;
        score = 0;


        movesArray[0] = gameBoard[1][0];
        movesArray[1] = gameBoard[1][1];
        movesArray[2] = gameBoard[1][2];

        score = super.calcLineScore(movesArray, maxPoint, minPoint);
        if (score == Integer.MAX_VALUE) {
            return score;
        } else if (score == Integer.MIN_VALUE) {
            return score;
        }
        totalScore += score;
        score = 0;

        movesArray[0] = gameBoard[2][0];
        movesArray[1] = gameBoard[2][1];
        movesArray[2] = gameBoard[2][2];
        score = super.calcLineScore(movesArray, maxPoint, minPoint);
        if (score == Integer.MAX_VALUE) {
            return score;
        } else if (score == Integer.MIN_VALUE) {
            return score;
        }
        totalScore += score;
        score = 0;

        // 縦
        movesArray[0] = gameBoard[0][0];
        movesArray[1] = gameBoard[1][0];
        movesArray[2] = gameBoard[2][0];
        score = super.calcLineScore(movesArray, maxPoint, minPoint);
        if (score == Integer.MAX_VALUE) {
            return score;
        } else if (score == Integer.MIN_VALUE) {
            return score;
        }
        totalScore += score;
        score = 0;

        movesArray[0] = gameBoard[0][1];
        movesArray[1] = gameBoard[1][1];
        movesArray[2] = gameBoard[2][1];
        score = super.calcLineScore(movesArray, maxPoint, minPoint);
        if (score == Integer.MAX_VALUE) {
            return score;
        } else if (score == Integer.MIN_VALUE) {
            return score;
        }
        totalScore += score;
        score = 0;

        movesArray[0] = gameBoard[0][2];
        movesArray[1] = gameBoard[1][2];
        movesArray[2] = gameBoard[2][2];
        score = super.calcLineScore(movesArray, maxPoint, minPoint);
        if (score == Integer.MAX_VALUE) {
            return score;
        } else if (score == Integer.MIN_VALUE) {
            return score;
        }
        totalScore += score;
        score = 0;


        // 斜め
        movesArray[0] = gameBoard[0][0];
        movesArray[1] = gameBoard[1][1];
        movesArray[2] = gameBoard[2][2];
        score = super.calcLineScore(movesArray, maxPoint, minPoint);
        if (score == Integer.MAX_VALUE) {
            return score;
        } else if (score == Integer.MIN_VALUE) {
            return score;
        }
        totalScore += score;
        score = 0;

        movesArray[0] = gameBoard[0][2];
        movesArray[1] = gameBoard[1][1];
        movesArray[2] = gameBoard[2][0];
        score = super.calcLineScore(movesArray, maxPoint, minPoint);
        if (score == Integer.MAX_VALUE) {
            return score;
        } else if (score == Integer.MIN_VALUE) {
            return score;
        }
        totalScore += score;
        score = 0;


        return totalScore;
    }


}



