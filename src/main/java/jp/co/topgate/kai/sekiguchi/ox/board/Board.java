package jp.co.topgate.kai.sekiguchi.ox.board;

import jp.co.topgate.kai.sekiguchi.ox.constantset.Moves;

import java.util.stream.IntStream;

/**
 * ゲーム盤
 * Created by sekiguchikai on 2017/01/05.
 */
public abstract class Board {

    /**
     * ゲーム盤のX軸を表す
     */
    private final int column;
    /**
     * ゲーム盤のY軸を表す
     */
    private final int row;

    /**
     * ゲーム盤を表す二次元配列
     */
    private Moves[][] gameBoard;

    /**
     * コンストラクタ
     * X軸、Y軸、配列の大きさを初期化する
     *
     * @param column x軸の長さ
     * @param row    y軸の長さ
     */
    Board(final int column, final int row) {
        this.column = column;
        this.row = row;
        this.gameBoard = new Moves[row][column];
    }

    /**
     * ゲーム盤の指定した場所に打ち手を打つためのメソッド
     *
     * @param column ゲーム盤の列
     * @param row    ゲーム盤の行
     * @param moves  打ち手
     */
    public void putMoves(final int column, final int row, final Moves moves) {
        this.gameBoard[column][row] = moves;
    }


    /**
     /**
     * ゲーム盤の指定されたマスの打ち手を返す
     *
     * @param column ゲーム盤の列
     * @param row    ゲーム盤の行
     *
     * @return 指定された箇所の打ち手
     */
    public Moves getCellState(final int column, final int row) {
        return this.gameBoard[column][row];
    }

    /**
     * ゲーム盤の現在の状態を取得するためのメソッド
     *
     * @return ゲーム盤のコピー
     */
    public Moves[][] getGameBoardState() {
        Moves[][] copyArray = new Moves[row][column];
        IntStream.range(0, this.row).forEach(i -> IntStream.range(0, this.column).forEach(j -> copyArray[i][j] = this.gameBoard[i][j]));
        return copyArray;
    }

    /**
     * ゲーム盤のY軸の長さを返す
     *
     * @return ゲーム盤のY軸の長さ
     */
    public int getRowLength() {
        return this.row;
    }

    /**
     * ゲーム盤のX軸の長さを返す
     *
     * @return ゲーム盤のX軸の長さ
     */
    public int getColumnLength() {
        return this.column;
    }
}
