package jp.co.topgate.kai.sekiguchi.ox.board;

import jp.co.topgate.kai.sekiguchi.ox.constantset.Moves;

import java.util.stream.IntStream;

/**
 * Created by sekiguchikai on 2017/01/05.
 */
public abstract class Board {
    /**
     * ゲーム盤のX軸を表す
     */
   public static final int X = 9;
    /**
     * ゲーム盤のY軸を表す
     */
    public static final int Y = 9;

    /**
     * ゲーム盤を表す2次元配列
     */
    private Moves[][] gameBoard = new Moves[Y][X];



    /**
     * ゲーム盤の指定した場所に打ち手を打つためのメソッド
     *
     * @param y     ゲーム盤のy座標
     * @param x     ゲーム盤のx座標
     * @param moves 打ち手
     */
    public void putMoves(int y, int x, Moves moves) {
        gameBoard[y][x] = moves;
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
//        Moves[][] copyArray = new Moves[Y][X];
//        IntStream.range(0, Y).forEach(i -> IntStream.range(0, X).forEach(j -> copyArray[i][j] = gameBoard[i][j]));
//        return copyArray;

        // 必ずのちに変更すること
        return this.gameBoard;
    }

    /**
     * ゲーム盤のY軸の長さを返す
     *
     * @return ゲーム盤のY軸の長さ
     */
    public int getYLength() {
        return Y;
    }

    /**
     * ゲーム盤のX軸の長さを返す
     *
     * @return ゲーム盤のX軸の長さ
     */
    public int getXLength() {
        return X;
    }
}
