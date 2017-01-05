package jp.co.topgate.kai.sekiguchi.ox.calculator;

import jp.co.topgate.kai.sekiguchi.ox.board.Board;
import jp.co.topgate.kai.sekiguchi.ox.board.TicTacToeBoard;
import jp.co.topgate.kai.sekiguchi.ox.constantset.Moves;

import java.util.*;
import java.util.stream.IntStream;

/**
 * ミニマックスアルゴリズムを表したクラス
 * Created by sekiguchikai on 2016/12/22.
 */
public class MinMaxCalculator {

    /**
     * 打ち手にとって、最適なゲーム盤上の場所とそこに打ち手を打った時の得点を格納するためのクラス
     */
    public static class Best {
        /**
         * 打ち手を打つのに最適なゲーム盤上の場所
         */
        private int bestScore;
        /**
         * 最適なゲーム盤上の場所に打ち手を打った際に取得する得点
         */
        private int bestSpot;


        /**
         * コンストラクタ
         *
         * @param bestScore 　打ち手を打つのに最適なゲーム盤上の場所
         * @param bestSpot  最適なゲーム盤上の場所に打ち手を打った際に取得する得点
         */
        Best(int bestScore, int bestSpot) {
            this.bestScore = bestScore;
            this.bestSpot = bestSpot;
        }

        /**
         * bestSpotを返すためのメソッド
         *
         * @return bestSpot
         */
        public int getBestSpot() {
            return this.bestSpot;
        }
    }

    /**
     * ミニマックスアルゴリズムαβ法を用い、引数で渡された打ち手のプレイヤーに取って最適な点数とゲーム盤の場所を返すメソッド
     * CPUの場合は、最大の点数とその点数を取り得るゲーム盤の場所を返し、USERの場合は、点数とその点数を取り得るゲーム盤の場所を返す
     * <p>
     * このメソッドのアルゴリズム
     * 【CPUの場合】
     * 現在のゲーム木の深さの1個下の階層の点数をMinMaxで取得する
     * その取得した点数が現在保持している一番高い点数（ベストスコア）よりも高い場合は、その点数が保持されるベストスコアとなる
     * <p>
     * 【USERの場合】
     * 現在のゲーム木の深さの1個下の階層の点数をMinMaxで取得する
     * その取得した点数が現在保持している一番低い点数（ベストスコア）よりも低い場合は、その点数が保持されるベストスコアとなる
     *
     * @param depth      探索の深さ
     * @param gameBoard  ゲーム盤
     * @param playerMove player名
     * @param alpha      α
     * @param beta       β
     * @return 打ち手を打つのに最適な場所とそこに打ち手を打った場合の点数を格納したBestクラスのインスタンス
     */
    public Best calcMinMax(int depth, TicTacToeBoard gameBoard, Moves playerMove, int alpha, int beta) {

        // 石を置くことが可能な全てのゲーム盤の場所を格納したListを作成
        List<Integer> capableMove = this.makeCapableMOveList(gameBoard);
        int score;
        int spot = -1;

        ScoreCalculator scoreCalculator = new ScoreCalculator();

        // 試合が終了か、深さが0の場合は、スコアを
        if (capableMove.isEmpty() || depth == 0) {
            score = scoreCalculator.calcScore(gameBoard.getGameBoardState());
            return new Best(score, spot);
        } else {
            // CPUの点数であるαの方が、βよりも大きい場合、それ以上探索しなくても良い(その時のαが最大なので)ので、探索を打ち切る
            for (int moveSpot : capableMove) {

                gameBoard.getGameBoardState()[moveSpot] = playerMove;

                if (playerMove == Moves.CPU_MOVE) {
                    score = calcMinMax(depth - 1, gameBoard, Moves.USER_MOVE, alpha, beta).bestScore;
                    if (score > alpha) {
                        alpha = score;
                        spot = moveSpot;
                    }
                } else if (playerMove == Moves.USER_MOVE) {
                    score = calcMinMax(depth - 1, gameBoard, Moves.CPU_MOVE, alpha, beta).bestScore;
                    if (score < beta) {
                        beta = score;
                        spot = moveSpot;
                    }
                }

                gameBoard.getGameBoardState()[moveSpot] = Moves.NO_MOVE;
                if (alpha >= beta) break;
            }
            return new Best((playerMove == Moves.CPU_MOVE) ? alpha : beta, spot);
        }
    }

    /**
     * 現在こと打ち手を打つことが可能なすべてのゲーム盤の場所をリスト化する（NO_MOVEが存在しているGameBoardの場所）
     *
     * @param gameBoard ゲームの盤
     * @return NO_MOVEが存在するGameBoard上の場所の一覧を格納したList
     */
    List<Integer> makeCapableMOveList(TicTacToeBoard gameBoard) {

        List<Integer> capableMoveList = new ArrayList<>();
        IntStream.range(0, gameBoard.getGameBoardState().length).forEach(i -> {
            if (gameBoard.getGameBoardState()[i] == Moves.NO_MOVE) {
                capableMoveList.add(i);
            }
        });

        return capableMoveList;
    }


}