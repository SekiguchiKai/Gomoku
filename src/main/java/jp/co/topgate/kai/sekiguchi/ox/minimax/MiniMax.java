package jp.co.topgate.kai.sekiguchi.ox.minimax;

import jp.co.topgate.kai.sekiguchi.ox.board.Board;
import jp.co.topgate.kai.sekiguchi.ox.board.Cell;
import jp.co.topgate.kai.sekiguchi.ox.calculator.ScoreCalculator;
import jp.co.topgate.kai.sekiguchi.ox.constantset.Moves;

import java.util.*;

/**
 * ミニマックスアルゴリズムを表したクラス
 * Created by sekiguchikai on 2016/12/22.
 */
public class MiniMax {

    /**
     * ScoreCalculatorクラスのインスタンス
     */
    private ScoreCalculator scoreCalculator;

    /**
     * コンストラクタ
     * フイールドを初期化する
     *
     * @param scoreCalculator ScoreCalculatorクラスのインスタンス
     */
    public MiniMax(final ScoreCalculator scoreCalculator) {
        this.scoreCalculator = scoreCalculator;
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
     * @param board      Boardクラスのインスタンス
     * @param playerMove player名
     * @param alpha      α
     * @param beta       β
     * @return 打ち手を打つのに最適な場所とそこに打ち手を打った場合の点数を格納したBestクラスのインスタンス
     */
    public Cell calcMinMax(final int depth, final Board board, final Moves playerMove, int alpha, int beta) {

        // 石を置くことが可能な全てのゲーム盤の場所を格納したListを作成
        List<Cell> capableMove = this.makeCapableMOveList(board);
        int score;
        int y = -1;
        int x = -1;


        // 試合が終了か、深さが0の場合は、スコアを
        if (capableMove.isEmpty() || depth == 0) {

            score = scoreCalculator.calcScore(board.getGameBoardState());

            Cell cell = new Cell(y, x);
            cell.setBestScore(score);

            return cell;
        } else {
            // CPUの点数であるαの方が、βよりも大きい場合、それ以上探索しなくても良い(その時のαが最大なので)ので、探索を打ち切る
            for (Cell cell : capableMove) {

                int cellY = cell.getCellRow();
                int cellX = cell.getCellColumn();

                board.putMoves(cellY, cellX, playerMove);

                if (playerMove == Moves.CPU_MOVE) {
                    score = calcMinMax(depth - 1, board, Moves.USER_MOVE, alpha, beta).getBestScore();
                    if (score > alpha) {
                        alpha = score;
                        x = cellX;
                        y = cellY;
                    }
                } else if (playerMove == Moves.USER_MOVE) {
                    score = calcMinMax(depth - 1, board, Moves.CPU_MOVE, alpha, beta).getBestScore();
                    if (score < beta) {
                        beta = score;
                        x = cellX;
                        y = cellY;
                    }
                }

                board.putMoves(cellY, cellX, Moves.NO_MOVE);

                if (alpha >= beta) break;
            }
            Cell cell = new Cell(y, x);
            cell.setBestScore((playerMove == Moves.CPU_MOVE) ? alpha : beta);
            return cell;
        }
    }


    /**
     * 現在の打ち手を打つことが可能なすべてのゲーム盤の場所をリスト化する（NO_MOVEが存在しているGameBoardの場所）
     *
     * @param board Boardクラスのインスタンス
     * @return NO_MOVEが存在するGameBoard上の場所の一覧を格納したList
     */
  List<Cell> makeCapableMOveList(final Board board) {

        List<Cell> capableMoveList = new ArrayList<>();

        for (int y = 0; y < board.getRowSize(); y++) {
            for (int x = 0; x < board.getColumnSize(); x++) {
                if (board.getCellState(y, x) == Moves.NO_MOVE) {
                    capableMoveList.add(new Cell(y, x));
                }
            }
        }
        return capableMoveList;
    }


}