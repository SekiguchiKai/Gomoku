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
    public int calcScore(Moves[][] gameBoard) {

        int totalScore = 0;


        // 横
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                totalScore += this.calcLineScore(gameBoard[i][j], gameBoard[i][j + 1], gameBoard[i][j + 2], gameBoard[i][j + 3], gameBoard[i][j + 4]);
            }
        }

        // 縦
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                totalScore += this.calcLineScore(gameBoard[i][j], gameBoard[i + 1][j], gameBoard[i + 2][j], gameBoard[i + 3][j], gameBoard[i + 4][j]);
            }
        }

        // 左斜め
        for (int i = 0; i < 5; i++) {
            totalScore += this.calcLineScore(gameBoard[i][i], gameBoard[i + 1][i + 1], gameBoard[i + 2][i + 2], gameBoard[i + 3][i + 3], gameBoard[i + 4][i + 4]);
        }

        // 右斜め

        for (int i = 8; i > 5; i--) {
            for (int j = 0; j < 5; j++) {
                totalScore += this.calcLineScore(gameBoard[i][j], gameBoard[i - 1][j + 1], gameBoard[i - 2][j + 2], gameBoard[i - 3][j + 3], gameBoard[i - 4][j + 4]);
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
     * @return ラインの合計点数
     */

    int calcLineScore(Moves moves1, Moves moves2, Moves moves3, Moves moves4, Moves moves5) {

        int score = 0;

        List<Moves> movesList = Arrays.asList(moves1, moves2, moves3, moves4, moves5);

        int counter = 0;

        counter += 10;

        for (Moves moves : movesList) {
            if (moves == Moves.CPU_MOVE) {
                score += 10;
            } else if (moves == Moves.USER_MOVE) {
                score -= 10;
            }
        }

        // 勝敗がつくときには、点数の差を大きくする
        if (score == 50) {
            score = 1000 - counter;
        } else if (score == -50) {
            score = counter - 1000;
        }

        return score;


    }
}
