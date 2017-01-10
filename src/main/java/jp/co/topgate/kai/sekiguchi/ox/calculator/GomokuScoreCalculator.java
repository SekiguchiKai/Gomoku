package jp.co.topgate.kai.sekiguchi.ox.calculator;

import jp.co.topgate.kai.sekiguchi.ox.constantset.Moves;

import java.util.Arrays;
import java.util.List;

/**
 * 五目並べの得点計算を表すクラス
 * Created by sekiguchikai on 2017/01/06.
 */
public class GomokuScoreCalculator implements ScoreCalculator {

    /**
     * 現在のゲーム盤の点数を計算するためのメソッド
     *
     * @param gameBoard ゲーム盤
     * @return そのゲーム盤の点数の合計
     */
    public int calcScore(final Moves[][] gameBoard) {

        int totalScore = 0;
        final int maxLength = 5;

        final int one = 1;
        final int two = 2;
        final int three = 3;
        final int four = 4;

        // 横
        for (int i = 0; i < maxLength; i++) {
            for (int j = 0; j < maxLength; j++) {
                totalScore += this.calcLineScore(gameBoard[i][j], gameBoard[i][j + one], gameBoard[i][j + two], gameBoard[i][j + three], gameBoard[i][j + four]);
            }
        }

        // 縦
        for (int i = 0; i < maxLength; i++) {
            for (int j = 0; j < maxLength; j++) {
                totalScore += this.calcLineScore(gameBoard[i][j], gameBoard[i + one][j], gameBoard[i + two][j], gameBoard[i + three][j], gameBoard[i + four][j]);
            }
        }

        // 左斜め
        for (int i = 0; i < maxLength; i++) {
            totalScore += this.calcLineScore(gameBoard[i][i], gameBoard[i + one][i + one], gameBoard[i + two][i + two], gameBoard[i + three][i + three], gameBoard[i + four][i + four]);
        }

        // 右斜め

        final int statNumber = 8;
        for (int i = statNumber; i > maxLength; i--) {
            for (int j = 0; j < maxLength; j++) {
                totalScore += this.calcLineScore(gameBoard[i][j], gameBoard[i - one][j + one], gameBoard[i - two][j + two], gameBoard[i - three][j + three], gameBoard[i - four][j + four]);
            }
        }


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
     * @param moves4 打ち手4
     * @param moves5 打ち手5
     * @return 得点
     */
    int calcLineScore(final Moves moves1, final Moves moves2, final Moves moves3, final Moves moves4, final Moves moves5) {

        int score = 0;

        List<Moves> movesList = Arrays.asList(moves1, moves2, moves3, moves4, moves5);

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

        final int maxScore = 50;
        final int minScore = -50;

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
