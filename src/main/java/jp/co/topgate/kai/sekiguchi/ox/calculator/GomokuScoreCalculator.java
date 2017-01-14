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
        int endNum = 5;
        int innerEndNum = 5;
        for (int startNum = 0; startNum < endNum; startNum++) {
            totalScore += calcRow(movesArray, gameBoard, startNum, innerEndNum, startNum);
            innerEndNum++;
        }

        // Column
        endNum = 5;
        innerEndNum = 5;
        for (int startNum = 0; startNum < endNum; startNum++) {
            totalScore += calcColumn(movesArray, gameBoard, startNum, innerEndNum, startNum);
            innerEndNum++;
        }

        // leftSlanting
        endNum = 5;
        innerEndNum = 5;
        for (int startNum = 0; startNum < endNum; startNum++) {
            totalScore += calcLeftSlanting(movesArray, gameBoard, startNum, innerEndNum, startNum);
            innerEndNum++;
        }


        // leftSlanting
        endNum = 5;
        innerEndNum = 5;
        int column = 8;
        for (int startNum = 0; startNum < endNum; startNum++) {
            totalScore += calcRightSlanting(movesArray, gameBoard, startNum, innerEndNum, startNum, column);
            innerEndNum--;
            column--;
        }

        return totalScore;
    }


    /**
     * rowの点数を計算するためのメソッド
     *
     * @param movesArray      Movesを格納するための配列
     * @param gameBoard       ゲーム盤
     * @param startNum        rowの走査する範囲の最初の番号
     * @param innerEndNum     rowの走査する範囲の最後の番号
     * @param indexDifference movesArrayのインテレーター
     * @return rowの合計点数
     */
    private int calcRow(final Moves[] movesArray, final Moves[][] gameBoard, final int startNum, final int innerEndNum, final int indexDifference) {

        final int maxPoint = 50;
        final int minPoint = -50;

        final int maxLength = 9;

        IntStream.range(0, maxLength).forEach(row -> IntStream.range(startNum, innerEndNum).forEach(column -> movesArray[column - indexDifference] = gameBoard[row][column]));
        return super.calcLineScore(movesArray, maxPoint, minPoint);

    }

    /**
     * columnの点数を計算するためのメソッド
     *
     * @param movesArray      Movesを格納するための配列
     * @param gameBoard       ゲーム盤
     * @param startNum        rowの走査する範囲の最初の番号
     * @param innerEndNum     rowの走査する範囲の最後の番号
     * @param indexDifference movesArrayのインテレーター
     * @return columnの合計点数
     */
    private int calcColumn(final Moves[] movesArray, final Moves[][] gameBoard, final int startNum, final int innerEndNum, final int indexDifference) {

        final int maxPoint = 50;
        final int minPoint = -50;

        final int maxLength = 9;

        IntStream.range(0, maxLength).forEach(column -> IntStream.range(startNum, innerEndNum).forEach(row -> movesArray[row - indexDifference] = gameBoard[row][column]));
        return super.calcLineScore(movesArray, maxPoint, minPoint);

    }


    /**
     * 左斜めのラインの点数を計算するためのメソッド
     *
     * @param movesArray      Movesを格納するための配列
     * @param gameBoard       ゲーム盤
     * @param startNum        rowの走査する範囲の最初の番号
     * @param innerEndNum     rowの走査する範囲の最後の番号
     * @param indexDifference movesArrayのインテレーター
     * @return columnの合計点数
     */
    private int calcLeftSlanting(final Moves[] movesArray, final Moves[][] gameBoard, final int startNum, final int innerEndNum, final int indexDifference) {

        final int maxPoint = 50;
        final int minPoint = -50;

        IntStream.range(startNum, innerEndNum).forEach(i -> movesArray[i - indexDifference] = gameBoard[i][i]);
        return super.calcLineScore(movesArray, maxPoint, minPoint);

    }

    /**
     * 右斜めのラインの点数を計算するためのメソッド
     *
     * @param movesArray      Movesを格納するための配列
     * @param gameBoard       ゲーム盤
     * @param startNum        rowの走査する範囲の最初の番号
     * @param innerEndNum     rowの走査する範囲の最後の番号
     * @param indexDifference movesArrayのインテレーター
     * @return columnの合計点数
     */
    private int calcRightSlanting(final Moves[] movesArray, final Moves[][] gameBoard, final int startNum, final int innerEndNum, final int indexDifference, int column) {

        final int maxPoint = 50;
        final int minPoint = -50;

        final int maxLength = 9;

        int i = 0;
        for (int row = startNum; row < innerEndNum; row++) {

            movesArray[row] = gameBoard[row][column];
            column--;

        }
        return super.calcLineScore(movesArray, maxPoint, minPoint);
    }
}