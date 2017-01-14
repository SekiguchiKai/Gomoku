package jp.co.topgate.kai.sekiguchi.ox.calculator;

import jp.co.topgate.kai.sekiguchi.ox.constantset.Moves;


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

        // row
        totalScore += calcRow(movesArray, gameBoard);

        // Column
        totalScore += calcColumn(movesArray, gameBoard);

        // leftSlanting
        totalScore += calcLeftSlanting(movesArray, gameBoard);

        // rightSlanting
        totalScore += calcRightSlanting(movesArray, gameBoard);

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
        final int maxLength = 9;
        int index = 0;

        int subTotal = 0;

        for (int row = 0; row < maxLength; row++) {
            for (int column = 0; column < 5; column++) {
                movesArray[index] = gameBoard[row][column];
                movesArray[index + 1] = gameBoard[row][column + 1];
                movesArray[index + 2] = gameBoard[row][column + 2];
                movesArray[index + 3] = gameBoard[row][column + 3];
                movesArray[index + 4] = gameBoard[row][column + 4];

                subTotal += super.calcLineScore(movesArray, maxPoint, minPoint);
            }
        }
        return subTotal;
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
        final int maxLength = 9;
        int index = 0;

        int subTotal = 0;

        for (int column = 0; column < maxLength; column++) {
            for (int row = 0; row < 5; row++) {
                movesArray[index] = gameBoard[row][column];
                movesArray[index + 1] = gameBoard[row + 1][column];
                movesArray[index + 2] = gameBoard[row + 2][column];
                movesArray[index + 3] = gameBoard[row + 3][column];
                movesArray[index + 4] = gameBoard[row + 4][column];

                subTotal += super.calcLineScore(movesArray, maxPoint, minPoint);
            }
        }
        return subTotal;

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

        int arrayIndex = 0;
        int subTotal = 0;

        for (int index = 0; index < 5; index++) {
            movesArray[arrayIndex] = gameBoard[index][index];
            movesArray[arrayIndex + 1] = gameBoard[index + 1][index + 1];
            movesArray[arrayIndex + 2] = gameBoard[index + 2][index + 2];
            movesArray[arrayIndex + 3] = gameBoard[index + 3][index + 3];
            movesArray[arrayIndex + 4] = gameBoard[index + 4][index + 4];

            subTotal += super.calcLineScore(movesArray, maxPoint, minPoint);
        }

        return subTotal;

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

        int column = 8;
        int index = 0;
        int subTotal = 0;

        // for文1回で、1つの連を表す
        for (int row = 0; row < 5; row++) {
            movesArray[index] = gameBoard[row][column];
            movesArray[index + 1] = gameBoard[row + 1][column - 1];
            movesArray[index + 2] = gameBoard[row + 2][column - 2];
            movesArray[index + 3] = gameBoard[row + 3][column - 3];
            movesArray[index + 4] = gameBoard[row + 4][column - 4];

            subTotal += super.calcLineScore(movesArray, maxPoint, minPoint);
            column--;
        }
        return subTotal;
    }
}