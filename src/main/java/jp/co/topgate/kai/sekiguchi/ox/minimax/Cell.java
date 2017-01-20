package jp.co.topgate.kai.sekiguchi.ox.minimax;

import jp.co.topgate.kai.sekiguchi.ox.constantset.Moves;

/**
 * 打ち手にとって、最適なゲーム盤上の場所とそこに打ち手を打った時の得点を格納するためのクラス
 */
public class Cell {
    /**
     * 打ち手を打つのに最適なゲーム盤上の行の位置
     */
    private int cellRow;

    /**
     * 打ち手を打つのに最適なゲーム盤上の列の位置
     */
    private int cellColumn;

    /**
     * 打ち手
     */
    private Moves moves;


    /**
     * 最適なゲーム盤上の場所に打ち手を打った際に取得する得点
     */
    private int bestScore;


    /**
     * コンストラクタ
     * cellRowとcellColumnを初期化する
     * @param cellRow rowの位置
     * @param cellColumn columnの位置
     */
   public Cell(final int cellRow, final int cellColumn) {
        this.cellRow = cellRow;
       this.cellColumn = cellColumn;
    }



    /**
     * 最適な場所に打ち手を打った時に得られる得点を取得するためのメソッド
     *
     * @param bestScore 最適な場所に打ち手を打った時に得られる得点
     */
    public void setBestScore(final int bestScore) {
        this.bestScore = bestScore;
    }

    /**
     * 打ち手を打つのに最適なゲーム盤上の列の位置を設定するためのメソッド
     *
     * @param cellRow 　最適なゲーム盤上の列の位置
     */
    public void setCellRow(final int cellRow) {
        this.cellRow = cellRow;
    }

    /**
     * 打ち手を打つのに最適なゲーム盤上の行の位置を設定するためのメソッド
     *
     * @param cellColumn 　最適なゲーム盤上の行の位置
     */
    public void setCellColumn(final int cellColumn) {
        this.cellColumn = cellColumn;
    }

    /**
     * 最適な場所に打ち手を打った時に得られる得点を返すためのメソッド
     *
     * @return 最適な場所に打ち手を打った時に得られる得点
     */
    public int getBestScore() {
        return this.bestScore;
    }


    /**
     * @return マスの列の値
     */
    public int getCellRow() {
        return this.cellRow;
    }

    /**
     * @return マスの行の値
     */
    public int getCellColumn() {
        return this.cellColumn;
    }

    /**
     * 打ち手を設定するためのメソッド
     *
     * @param moves 打ち手
     */
    public void setMoves(final Moves moves) {
        this.moves = moves;
    }

    /**
     * 打ち手を取得するためのメソッド
     *
     * @return 打ち手
     */
    public Moves getMoves() {
        return this.moves;
    }


}