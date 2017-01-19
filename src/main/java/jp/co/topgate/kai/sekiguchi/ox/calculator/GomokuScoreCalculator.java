package jp.co.topgate.kai.sekiguchi.ox.calculator;

import jp.co.topgate.kai.sekiguchi.ox.constantset.Moves;
import jp.co.topgate.kai.sekiguchi.ox.util.Counter;


import java.util.stream.IntStream;

/**
 * 五目並べの得点計算を表すクラス
 * Created by sekiguchikai on 2017/01/06.
 */
public class GomokuScoreCalculator extends ScoreCalculator {

    /**
     * 現在のゲーム盤の点数を計算するためのメソッド
     *
     * @param gameBoard ゲーム盤
     * @return そのゲーム盤の点数の合計
     */
    @Override
    public int calcScore(final Moves[][] gameBoard) {
        int totalScore = 0;
        final int arraySize = 5;
        final Moves[] movesArray = new Moves[arraySize];


        totalScore += this.calcRow(movesArray, gameBoard);

        totalScore += this.calcColumn(movesArray, gameBoard);

        totalScore += this.calcLeftSlanting(movesArray, gameBoard);

        totalScore += this.calcRightSlanting(movesArray, gameBoard);


        Counter.resetCount();

        return totalScore;
    }


    /**
     * rowの点数を計算するためのメソッド
     *
     * @param movesArray Movesを格納するための配列
     * @param gameBoard  ゲーム盤
     * @return rowの合計点数
     */
    private int calcRow(final Moves[] movesArray, final Moves[][] gameBoard) {
        final int maxPoint = 50;
        final int minPoint = -50;

        int score = 0;

        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 5; column++) {

                for (int i = 0; i < 5; i++) {
                    movesArray[i] = gameBoard[row][column + i];
                }
                score += super.calcLineScore(movesArray, maxPoint, minPoint);

            }
        }

        return score;
    }

    /**
     * columnの点数を計算するためのメソッド
     *
     * @param movesArray Movesを格納するための配列
     * @param gameBoard  ゲーム盤
     * @return columnの合計点数
     */
    private int calcColumn(final Moves[] movesArray, final Moves[][] gameBoard) {

        final int maxPoint = 50;
        final int minPoint = -50;

        int score = 0;

        for (int column = 0; column < 9; column++) {
            for (int row = 0; row < 5; row++) {

                for (int i = 0; i < 5; i++) {
                    movesArray[i] = gameBoard[row + i][column];
                }
                score += super.calcLineScore(movesArray, maxPoint, minPoint);

            }
        }
        return score;

    }


    /**
     * 左斜めのラインの点数を計算するためのメソッド
     *
     * @param movesArray Movesを格納するための配列
     * @param gameBoard  ゲーム盤
     * @return columnの合計点数
     */
    private int calcLeftSlanting(final Moves[] movesArray, final Moves[][] gameBoard) {

        final int maxPoint = 50;
        final int minPoint = -50;

        int score = 0;

        for (int index = 0; index < 5; index++) {

            for (int i = 0; i < 5; i++) {
                movesArray[i] = gameBoard[index + i][index + i];
            }
            score += super.calcLineScore(movesArray, maxPoint, minPoint);

        }

        return score;

    }

    /**
     * 右斜めのラインの点数を計算するためのメソッド
     *
     * @param movesArray Movesを格納するための配列
     * @param gameBoard  ゲーム盤
     * @return columnの合計点数
     */
    private int calcRightSlanting(final Moves[] movesArray, final Moves[][] gameBoard) {

        final int maxPoint = 50;
        final int minPoint = -50;

        int score = 0;

        int column = 8;


        // for文1回で、1つの連を表す
        for (int row = 0; row < 5; row++) {
            for (int i = 0; i < 5; i++) {
                movesArray[i] = gameBoard[row + i][column - i];
            }
            score += super.calcLineScore(movesArray, maxPoint, minPoint);

            column--;
        }

        return score;
    }
}