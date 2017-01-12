package jp.co.topgate.kai.sekiguchi.ox.judge;

import jp.co.topgate.kai.sekiguchi.ox.board.Board;
import jp.co.topgate.kai.sekiguchi.ox.calculator.ScoreCalculator;
import jp.co.topgate.kai.sekiguchi.ox.constantset.Moves;
import jp.co.topgate.kai.sekiguchi.ox.constantset.Result;

/**
 * 三目並べの勝敗結果を調べるクラス
 * Created by sekiguchikai on 2017/01/06.
 */
public class Judgement {

    /**
     * Boardクラスのインスタンス
     */
    private Board board;

    /**
     * ScoreCalculatorクラスのインスタンス
     */
    private ScoreCalculator scoreCalculator;

    /**
     * コンストラクタ
     *
     * @param board           Boardクラスのインスタンス
     * @param scoreCalculator ScoreCalculatorクラスのインスタンス
     */
    public Judgement(final Board board, final ScoreCalculator scoreCalculator) {
        this.board = board;
        this.scoreCalculator = scoreCalculator;
    }


    /**
     * 勝敗はついているかを確認し、その結果を返すためのメソッド
     *
     * @return 勝敗の結果
     */
    public Result judgeResult() {
        Moves[][] gameBoard = board.getGameBoardState();


        final int referenceHighValue = 1000;
        final int referenceLowValue = -1000;

        int resultScore = scoreCalculator.calcScore(gameBoard);

        if (resultScore > referenceHighValue) {
            return Result.LOSE;
        } else if (resultScore < referenceLowValue) {
            return Result.WIN;
        } else if (this.judgeDraw()) {
            return Result.DRAW;
        }

        return Result.PENDING;


    }

    /**
     * ゲーム盤の現在の状況が引き分けかどうかの真偽値を返すメソッド
     *
     * @return ゲーム盤の現在の状況が引き分けかどうかの真偽値
     */
    private boolean judgeDraw() {
        Moves[][] gameBoard = this.board.getGameBoardState();

        for (int y = 0; y < gameBoard[0].length; y++) {
            for (int x = 0; x < gameBoard[1].length; x++) {
                if (gameBoard[y][x] == Moves.NO_MOVE) {
                    return false;
                }
            }
        }
        return true;
    }
}