package jp.co.topgate.kai.sekiguchi.ox.calculator;

import jp.co.topgate.kai.sekiguchi.ox.constantset.Moves;

import java.util.Arrays;
import java.util.List;

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

        final int one = 1;
        final int two = 2;
        final int three = 3;
        final int four = 4;

        final int arraySize = 5;
        final Moves[] movesArray = new Moves[arraySize];

        final int maxPoint = 50;
        final int minPoint = -50;


        // 横
        for (int i = 0; i < maxLength; i++) {
            for (int j = 0; j < maxLength; j++) {

                for (int k = 0; k < arraySize; k++) {
                    movesArray[k] = gameBoard[i][j + k];
                }
                totalScore += super.calcLineScore(movesArray, maxPoint, minPoint);
            }
        }

        // 縦
        for (int i = 0; i < maxLength; i++) {
            for (int j = 0; j < maxLength; j++) {
                for (int k = 0; k < arraySize; k++) {
                    movesArray[k] = gameBoard[i + k][j];
                }
                totalScore += super.calcLineScore(movesArray, maxPoint, minPoint);
            }
        }

        // 左斜め
        for (int i = 0; i < maxLength; i++) {
            for (int k = 0; k < arraySize; k++) {
                movesArray[k] = gameBoard[i + k][i + k];
            }
            totalScore += super.calcLineScore(movesArray, maxPoint, minPoint);
        }

        // 右斜め

        final int startNumber = 8;
        for (int i = startNumber; i > maxLength; i--) {
            for (int j = 0; j < maxLength; j++) {

                for (int k = 0; k < arraySize; k++) {
                    movesArray[k] = gameBoard[i - k][j + k];
                }
                totalScore += super.calcLineScore(movesArray, maxPoint, minPoint);
            }
        }


        return totalScore;
    }


}
