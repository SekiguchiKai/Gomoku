package jp.co.topgate.kai.sekiguchi.ox.board;

import jp.co.topgate.kai.sekiguchi.ox.constantset.Moves;

import java.util.stream.IntStream;

/**
 * ゲーム盤
 * Created brow sekiguchikai on 2017/01/05.
 */
public abstract class Board {

    /**
     * ゲーム盤の列を表す
     */
    private int column;
    /**
     * ゲーム盤の行を表す
     */
    private int row;

    /**
     * ゲーム盤を表す二次元配列
     */
    private Moves[][] gameBoard;

    /**
     * コンストラクタ
     * column、row、配列の大きさを初期化する
     *
     * @param column columnの長さ
     * @param row    rowの長さ
     */
    public Board(final int column, final int row) {
        this.column = column;
        this.row = row;
        this.gameBoard = new Moves[row][column];
    }

    /**
     * ゲーム盤の指定した場所に打ち手を打つためのメソッド
     *
     * @param row    ゲーム盤のrow座標
     * @param column ゲーム盤のcolumn座標
     * @param moves  打ち手
     */
    public void putMoves(final int row, final int column, final Moves moves) {
        this.gameBoard[row][column] = moves;
    }


    /**
     * ゲーム盤の指定されたマスの打ち手を返す
     *
     * @param row    ゲーム盤のrow座標
     * @param column ゲーム盤のcolumn座標
     * @return 打ち手
     */
    public Moves getCellState(final int row, final int column) {
        return this.gameBoard[row][column];
    }

    /**
     * ゲーム盤の現在の状態を取得するためのメソッド
     *
     * @return ゲーム盤のコピー
     */
    public Moves[][] getGameBoardState() {
        final Moves[][] copyArray = new Moves[row][column];
        IntStream.range(0, row).forEach(i -> IntStream.range(0, column).forEach(j -> copyArray[i][j] = gameBoard[i][j]));
        return copyArray;

    }

    /**
     * ゲーム盤の列の長さを返す
     *
     * @return ゲーム盤の行の長さ
     */
    public int getRowSize() {
        return this.row;
    }

    /**
     * ゲーム盤のX軸の長さを返す
     *
     * @return ゲーム盤の列の長さ
     */
    public int getColumnSize() {
        return this.column;
    }
}