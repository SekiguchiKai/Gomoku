package jp.co.topgate.kai.sekiguchi.ox.calculator;

import jp.co.topgate.kai.sekiguchi.ox.constantset.Moves;
import jp.co.topgate.kai.sekiguchi.ox.util.Counter;


import java.util.stream.IntStream;

/**
 * 五目並べの得点計算を表すクラス
 * Created by sekiguchikai on 2017/01/06.
 */
public class ScoreCalculator {

    /**
     * rowのサイズ
     */
    private int rowSize;

    /**
     * columnSize columnのサイズ
     */
    private int columnSize;

    /**
     * 勝敗が決定する連続する打ち手の長さ
     */
    private int judgeCriteriaSequence;

    /**
     * 連続するrowの値を調べる際に使用する操作開始値の限界値
     */
    private int rowMax;

    /**
     * 連続するcolumnの値を調べる際に使用する操作開始値の限界値
     */
    private int columnMax;

    /**
     * 補正前の最大得点
     */
    private int maxPoint;

    /**
     * 補正前の最小得点
     */
    private int minPoint;

    /**
     * コンストラクタ
     *
     * @param rowSize rowのサイズ
     * @param columnSize columnのサイズ
     * @param judgeCriteriaSequence 勝敗が決定する連続する打ち手の長さ
     * @param maxPoint 補正前の最大得点
     * @param minPoint 補正前の最小得点
     */
    public ScoreCalculator(final int rowSize, final int columnSize, final int judgeCriteriaSequence, final int maxPoint, final int minPoint) {
        this.rowSize = rowSize;
        this.columnSize = columnSize;
        this.judgeCriteriaSequence = judgeCriteriaSequence;
        this.rowMax = this.rowSize - this.judgeCriteriaSequence + 1;
        this.columnMax = this.columnSize - this.judgeCriteriaSequence + 1;
        this.maxPoint = maxPoint;
        this.minPoint = minPoint;
    }

    /**
     * 現在のゲーム盤の点数を計算するためのメソッド
     *
     * @param gameBoard ゲーム盤
     * @return そのゲーム盤の点数の合計
     */
    public int calcScore(final Moves[][] gameBoard) {
        int totalScore = 0;
        final int arraySize = this.judgeCriteriaSequence;
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

        int score = 0;

        for (int row = 0; row < this.rowSize; row++) {
            for (int column = 0; column < this.columnMax; column++) {
                for (int i = 0; i < movesArray.length; i++) {
                    movesArray[i] = gameBoard[row][column + i];
                }
                score += this.calcLineScore(movesArray, maxPoint, minPoint);
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
        int score = 0;

        for (int column = 0; column < columnSize; column++) {
            for (int row = 0; row < rowMax; row++) {

                for (int i = 0; i < movesArray.length; i++) {
                    movesArray[i] = gameBoard[row + i][column];
                }
                score += this.calcLineScore(movesArray, maxPoint, minPoint);
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
        int score = 0;

        for (int index = 0; index < rowMax; index++) {

            for (int i = 0; i < movesArray.length; i++) {
                movesArray[i] = gameBoard[index + i][index + i];
            }
            score += this.calcLineScore(movesArray, maxPoint, minPoint);
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
        int score = 0;

        final int columnLastIndex = columnSize - 1;
        int column = columnLastIndex;


        // for文1回で、1つの連を表す
        for (int row = 0; row < rowMax; row++) {
            for (int i = 0; i < movesArray.length; i++) {
                movesArray[i] = gameBoard[row + i][column - i];
            }
            score += this.calcLineScore(movesArray, maxPoint, minPoint);

            column--;
        }
        return score;
    }

    /**
     * 引数として受け取った3つの打ち手の点数の合計を求める
     *
     * @param movesArray 一列分のMovesを格納した配列
     * @param maxPoint   自分の打ち手がラインが揃った時の点数
     * @param minPoint   相手の打ち手がラインが揃った時の点数
     * @return ラインの合計点数
     */
    protected int calcLineScore(final Moves[] movesArray, final int maxPoint, final int minPoint) {

        int score = 0;
        final int perTernPoint = 10;

        for (Moves moves : movesArray) {

            if (moves == Moves.CROSS) {
                score += perTernPoint;
            } else if (moves == Moves.CIRCLE) {
                score -= perTernPoint;
            }
        }

        int counter = Counter.getCount();
        final int correctionValue = 100;

        int counterCorrectionValue = counter * correctionValue;

        final int finalMaxPoint = 100000;
        final int finalMinPoint = -100000;

        // 勝敗がつくときには、点数の差を大きくする
        if (score == maxPoint) {
            score = finalMaxPoint - counterCorrectionValue;
        } else if (score == minPoint) {
            score = finalMinPoint + counterCorrectionValue;
        }
        Counter.upCount();

        return score;
    }
}