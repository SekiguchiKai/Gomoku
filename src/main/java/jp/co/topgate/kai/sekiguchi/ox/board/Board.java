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
    private int x;
    /**
     * ゲーム盤のY軸を表す
     */
    private int y;

    /**
     * ゲーム盤を表す二次元配列
     */
    private Moves[][] gameBoard;

    /**
     * コンストラクタ
     * X軸、Y軸、配列の大きさを初期化する
     *
     * @param x x軸の長さ
     * @param y y軸の長さ
     */
    public Board(int x, int y) {
        this.x = x;
        this.y = y;
        this.gameBoard = new Moves[y][x];
    }

    /**
     * ゲーム盤の指定した場所に打ち手を打つためのメソッド
     *
     * @param y     ゲーム盤のy座標
     * @param x     ゲーム盤のx座標
     * @param moves 打ち手
     */
    public void putMoves(int y, int x, Moves moves) {
        this.gameBoard[y][x] = moves;
    }


    /**
     * ゲーム盤の指定されたマスの打ち手を返す
     *
     * @param y ゲーム盤のy座標
     * @param x ゲーム盤のx座標
     * @return 打ち手
     */
    public Moves getCellState(int y, int x) {
        return this.gameBoard[y][x];
    }

    /**
     * ゲーム盤の現在の状態を取得するためのメソッド
     *
     * @return ゲーム盤のコピー
     */
    public Moves[][] getGameBoardState() {
        Moves[][] copyArray = new Moves[y][x];
        IntStream.range(0, y).forEach(i -> IntStream.range(0, x).forEach(j -> copyArray[i][j] = gameBoard[i][j]));
        return copyArray;

    }

    /**
     * ゲーム盤のY軸の長さを返す
     *
     * @return ゲーム盤のY軸の長さ
     */
    public int getYLength() {
        return y;
    }

    /**
     * ゲーム盤のX軸の長さを返す
     *
     * @return ゲーム盤のX軸の長さ
     */
    public int getXLength() {
        return x;
    }
}
