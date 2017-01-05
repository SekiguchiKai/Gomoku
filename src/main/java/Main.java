import jp.co.topgate.kai.sekiguchi.ox.logic.GameLogic;
import jp.co.topgate.kai.sekiguchi.ox.logic.TicTacToeGameLogic;

/**
 * Mainのクラス、このアプリケーションのエントリーポイント
 * Created by sekiguchikai on 2016/12/20.
 */
public class Main {
    /**
     * メインメソッド
     * @param args
     */
    public static void main(String[] args) {
        GameLogic normalGameLogic = new TicTacToeGameLogic();
        normalGameLogic.playGame();
    }
}
