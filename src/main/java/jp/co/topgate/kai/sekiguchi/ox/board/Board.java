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
    private int columnSize;

    /**
     * ゲーム盤の行を表す
     */
    private int rowSize;

    /**
     * ゲーム盤を表す二次元配列
     */
    private Moves[][] gameBoard;

    /**
     * コンストラクタ
     * columnSize、rowSize、配列の大きさを初期化する
     *
     * @param columnSize columnの長さ
     * @param rowSize    rowの長さ
     */
    public Board(final int columnSize, final int rowSize) {
        this.columnSize = columnSize;
        this.rowSize = rowSize;
        this.gameBoard = new Moves[rowSize][columnSize];
    }

    /**
     * インスタンス変数であるgameBoard(ゲーム盤)を初期化する
     */
    protected void initGameBoard() {
        IntStream.range(0, this.rowSize).forEach(y -> IntStream.range(0, this.columnSize).forEach(x -> this.putMoves(y, x, Moves.EMPTY)));
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
        final Moves[][] copyArray = new Moves[rowSize][columnSize];
        IntStream.range(0, rowSize).forEach(i -> IntStream.range(0, columnSize).forEach(j -> copyArray[i][j] = gameBoard[i][j]));
        return copyArray;

    }

    /**
     * ゲーム盤の列の長さを返す
     *
     * @return ゲーム盤の行の長さ
     */
    public int getRowSize() {
        return this.rowSize;
    }

    /**
     * ゲーム盤のX軸の長さを返す
     *
     * @return ゲーム盤の列の長さ
     */
    public int getColumnSize() {
        return this.columnSize;
    }
}