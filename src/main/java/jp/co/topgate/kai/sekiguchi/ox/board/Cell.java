package jp.co.topgate.kai.sekiguchi.ox.board;

import jp.co.topgate.kai.sekiguchi.ox.constantset.Moves;

/**
 * 打ち手にとって、最適なゲーム盤上の場所とそこに打ち手を打った時の得点を格納するためのクラス
 */
public class Cell {
    /**
     * 打ち手を打つのに最適なゲーム盤上のY軸
     */
    private int cellY;

    /**
     * 打ち手を打つのに最適なゲーム盤上のX軸
     */
    private int cellX;

    Moves moves;


    /**
     * 最適なゲーム盤上の場所に打ち手を打った際に取得する得点
     */
    private int bestScore;


    /**
     * コンストラクタ
     *
     * @param cellY 　打ち手を打つのに最適なゲーム盤上のY座標
     * @param cellX 打ち手を打つのに最適なゲーム盤上のX軸
     */
    public Cell(int cellY, int cellX) {
        this.cellY = cellY;
        this.cellX = cellX;
    }

    /**
     * 最適な場所に打ち手を打った時に得られる得点を取得するためのメソッド
     *
     * @param bestScore 最適な場所に打ち手を打った時に得られる得点
     */
    public void setBestScore(int bestScore) {
        this.bestScore = bestScore;
    }

    /**
     * bestSpotを返すためのメソッド
     *
     * @return bestSpot
     */
    public int getBestScore() {
        return this.bestScore;
    }


    /**
     * @return
     */
    public int getCellY() {
        return this.cellY;
    }

    /**
     * @return
     */
    public int getCellX() {
        return this.cellX;
    }

    public void setMoves(Moves moves) {
        this.moves = moves;
    }

    public Moves getMoves() {
        return this.moves;
    }
}
