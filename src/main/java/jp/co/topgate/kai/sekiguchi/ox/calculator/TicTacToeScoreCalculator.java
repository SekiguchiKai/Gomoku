package jp.co.topgate.kai.sekiguchi.ox.calculator;

import jp.co.topgate.kai.sekiguchi.ox.constantset.Moves;
import jp.co.topgate.kai.sekiguchi.ox.util.Counter;

import java.util.stream.IntStream;


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
        final int maxLength = 3;
        IntStream.range(0, maxLength).forEach(index -> movesArray[index] = gameBoard[0][index]);
//        movesArray[0] = gameBoard[0][0];
//        movesArray[1] = gameBoard[0][1];
//        movesArray[2] = gameBoard[0][2];

        totalScore += super.calcLineScore(movesArray, maxPoint, minPoint);


        IntStream.range(0, maxLength).forEach(index -> movesArray[index] = gameBoard[1][index]);
//        movesArray[0] = gameBoard[1][0];
//        movesArray[1] = gameBoard[1][1];
//        movesArray[2] = gameBoard[1][2];

        totalScore += super.calcLineScore(movesArray, maxPoint, minPoint);


        IntStream.range(0, maxLength).forEach(index -> movesArray[index] = gameBoard[2][index]);
//        movesArray[0] = gameBoard[2][0];
//        movesArray[1] = gameBoard[2][1];
//        movesArray[2] = gameBoard[2][2];
        totalScore += super.calcLineScore(movesArray, maxPoint, minPoint);

        // 縦
        IntStream.range(0, maxLength).forEach(index -> movesArray[index] = gameBoard[index][0]);

//        movesArray[0] = gameBoard[0][0];
//        movesArray[1] = gameBoard[1][0];
//        movesArray[2] = gameBoard[2][0];
        totalScore += super.calcLineScore(movesArray, maxPoint, minPoint);


        IntStream.range(0, maxLength).forEach(index -> movesArray[index] = gameBoard[index][1]);

//        movesArray[0] = gameBoard[0][1];
//        movesArray[1] = gameBoard[1][1];
//        movesArray[2] = gameBoard[2][1];
        totalScore += super.calcLineScore(movesArray, maxPoint, minPoint);


        IntStream.range(0, maxLength).forEach(index -> movesArray[index] = gameBoard[index][2]);
//        movesArray[0] = gameBoard[0][2];
//        movesArray[1] = gameBoard[1][2];
//        movesArray[2] = gameBoard[2][2];
        totalScore += super.calcLineScore(movesArray, maxPoint, minPoint);


        // 斜め
        IntStream.range(0, maxLength).forEach(index -> movesArray[index] = gameBoard[index][index]);

//        movesArray[0] = gameBoard[0][0];
//        movesArray[1] = gameBoard[1][1];
//        movesArray[2] = gameBoard[2][2];
        totalScore += super.calcLineScore(movesArray, maxPoint, minPoint);


        int column = 2;

        for (int row = 0; row < maxLength; row++) {
            movesArray[row] = gameBoard[row][column];

            column--;
        }
        
//        movesArray[0] = gameBoard[0][2];
//        movesArray[1] = gameBoard[1][1];
//        movesArray[2] = gameBoard[2][0];
        totalScore += super.calcLineScore(movesArray, maxPoint, minPoint);


        Counter.resetCount();

        return totalScore;
    }


}