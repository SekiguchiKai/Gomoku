package jp.co.topgate.kai.sekiguchi.ox.calculator;

import jp.co.topgate.kai.sekiguchi.ox.constantset.Moves;

import java.util.Arrays;
import java.util.List;
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


        final int maxLength = 5;

        final int arraySize = 5;
        final Moves[] movesArray = new Moves[arraySize];

        final int maxPoint = 50;
        final int minPoint = -50;


        // 横
        IntStream.range(0, 9).forEach(row -> IntStream.range(0, 5).forEach(column -> movesArray[column] = gameBoard[row][column]));
        totalScore += super.calcLineScore(movesArray, maxPoint, minPoint);

        IntStream.range(0, 9).forEach(row -> IntStream.range(1, 6).forEach(column -> movesArray[column - 1] = gameBoard[row][column]));
        totalScore += super.calcLineScore(movesArray, maxPoint, minPoint);

        IntStream.range(0, 9).forEach(row -> IntStream.range(2, 7).forEach(column -> movesArray[column - 2] = gameBoard[row][column]));
        totalScore += super.calcLineScore(movesArray, maxPoint, minPoint);

        IntStream.range(0, 9).forEach(row -> IntStream.range(3, 8).forEach(column -> movesArray[column - 3] = gameBoard[row][column]));
        totalScore += super.calcLineScore(movesArray, maxPoint, minPoint);

        IntStream.range(0, 9).forEach(row -> IntStream.range(4, 9).forEach(column -> movesArray[column - 4] = gameBoard[row][column]));
        totalScore += super.calcLineScore(movesArray, maxPoint, minPoint);


        // 縦
        IntStream.range(0, 9).forEach(column -> IntStream.range(0, 5).forEach(row -> movesArray[row] = gameBoard[row][column]));
        totalScore += super.calcLineScore(movesArray, maxPoint, minPoint);

        IntStream.range(0, 9).forEach(column -> IntStream.range(1, 6).forEach(row -> movesArray[row - 1] = gameBoard[row][column]));
        totalScore += super.calcLineScore(movesArray, maxPoint, minPoint);

        IntStream.range(0, 9).forEach(column -> IntStream.range(2, 7).forEach(row -> movesArray[row - 2] = gameBoard[row][column]));
        totalScore += super.calcLineScore(movesArray, maxPoint, minPoint);

        IntStream.range(0, 9).forEach(column -> IntStream.range(3, 8).forEach(row -> movesArray[row - 3] = gameBoard[row][column]));
        totalScore += super.calcLineScore(movesArray, maxPoint, minPoint);

        IntStream.range(0, 9).forEach(column -> IntStream.range(4, 9).forEach(row -> movesArray[row - 4] = gameBoard[row][column]));
        totalScore += super.calcLineScore(movesArray, maxPoint, minPoint);


        // 左斜め
        IntStream.range(0, 5).forEach(i -> movesArray[i] = gameBoard[i][i]);
        totalScore += super.calcLineScore(movesArray, maxPoint, minPoint);


        IntStream.range(1, 6).forEach(i -> movesArray[i - 1] = gameBoard[i][i]);
        totalScore += super.calcLineScore(movesArray, maxPoint, minPoint);

        IntStream.range(2, 7).forEach(i -> movesArray[i - 2] = gameBoard[i][i]);
        totalScore += super.calcLineScore(movesArray, maxPoint, minPoint);

        IntStream.range(3, 8).forEach(i -> movesArray[i - 3] = gameBoard[i][i]);
        totalScore += super.calcLineScore(movesArray, maxPoint, minPoint);

        IntStream.range(4, 9).forEach(i -> movesArray[i - 4] = gameBoard[i][i]);
        totalScore += super.calcLineScore(movesArray, maxPoint, minPoint);


        // 右斜め
        int i = 0;
        for (int row = 0; row < 9; row++) {
            int column = 8;
            movesArray[i] = gameBoard[row][column];
            column--;
            if (i < 4) {
                i++;
            }
        }
        totalScore += super.calcLineScore(movesArray, maxPoint, minPoint);

        int j = 0;
        for (int row = 1; row > 8; row++) {
            int column = 7;

            movesArray[row] = gameBoard[row][column];
            column--;
            if (i < 4) {
                j++;
            }
        }
        totalScore += super.calcLineScore(movesArray, maxPoint, minPoint);

        int k = 0;
        for (int row = 2; row > 7; row++) {
            int column = 6;

            movesArray[row] = gameBoard[row][column];
            column--;
            if (i < 4) {
                k++;
            }
        }
        totalScore += super.calcLineScore(movesArray, maxPoint, minPoint);

        int l = 0;
        for (int row = 3; row > 6; row++) {
            int column = 5;
            movesArray[row] = gameBoard[row][column];
            column--;
            if (i < 4) {
                l++;
            }
        }
        totalScore += super.calcLineScore(movesArray, maxPoint, minPoint);


        return totalScore;

    }


}