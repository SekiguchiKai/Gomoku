package jp.co.topgate.kai.sekiguchi.ox.calculator;

import jp.co.topgate.kai.sekiguchi.ox.constantset.Moves;

import java.util.Arrays;
import java.util.List;

/**
 * 打ち手のシミュレーションを行うためのクラス
 * Created by sekiguchikai on 2016/12/22.
 */
public class TicTacToeScoreCalculator implements ScoreCalculator {

    /**
     * 現在のゲーム盤の点数を計算するためのメソッド
     *
     * @param gameBoard ゲーム盤
     * @return そのゲーム盤の点数の合計
     */
    public int calcScore(final Moves[][] gameBoard) {

        int totalScore = 0;
        // 横
        totalScore += calcLineScore(gameBoard[0][0], gameBoard[0][1], gameBoard[0][2]);
        totalScore += calcLineScore(gameBoard[1][0], gameBoard[1][1], gameBoard[1][2]);
        totalScore += calcLineScore(gameBoard[2][0], gameBoard[2][1], gameBoard[2][2]);

        // 縦
        totalScore += calcLineScore(gameBoard[0][0], gameBoard[1][0], gameBoard[2][0]);
        totalScore += calcLineScore(gameBoard[0][1], gameBoard[1][1], gameBoard[2][1]);
        totalScore += calcLineScore(gameBoard[0][2], gameBoard[1][2], gameBoard[2][2]);

        // 斜め
        totalScore += calcLineScore(gameBoard[0][0], gameBoard[1][1], gameBoard[2][2]);
        totalScore += calcLineScore(gameBoard[0][2], gameBoard[1][1], gameBoard[2][0]);

        return totalScore;
    }


    /**
     * 引数として受け取った打ち手3つの点数の合計を求める
     * 点数の計算方法は以下
     * <p>
     * CPUの石1つ :1
     * USERの石1つ :-1
     * EMPTY :0
     * <p>
     * 合計
     * 【CPU】
     * CPUの石が3つ揃っていた場合 : 100
     * CPUの石が2つ揃っていた場合 : 20
     * CPUの石が1つ揃っていた場合 : 10
     * <p>
     * 【USER】
     * USERの石が3つ揃っていた場合 : -100
     * USERの石が2つ揃っていた場合 : -20
     * USERの石が1つ揃っていた場合 : -10
     * <p>
     * 【EMPTY】
     * EMPTYの場合 :0
     *
     * @param moves1 打ち手1
     * @param moves2 打ち手2
     * @param moves3 打ち手3
     * @return ラインの合計点数
     */

    int calcLineScore(final Moves moves1, final Moves moves2, final Moves moves3) {

        int score = 0;

        List<Moves> movesList = Arrays.asList(moves1, moves2, moves3);

        int counter = 0;

        final int perTurnScore = 10;
        counter += perTurnScore;

        for (Moves moves : movesList) {
            if (moves == Moves.CPU_MOVE) {
                score += perTurnScore;
            } else if (moves == Moves.USER_MOVE) {
                score -= perTurnScore;
            }
        }

        final int maxScore = 30;
        final int minScore = -30;

        final int bonusMaxScore = 1000;
        final int bonusMinScore = -1000;


        // 勝敗がつくときには、点数の差を大きくする
        if (score == maxScore) {
            score = bonusMaxScore - counter;
        } else if (score == minScore) {
            score = counter + bonusMinScore;
        }

        return score;


    }
}



