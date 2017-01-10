import jp.co.topgate.kai.sekiguchi.ox.io.SelectModeCommandLineIO;
import jp.co.topgate.kai.sekiguchi.ox.logic.GameLogic;
import jp.co.topgate.kai.sekiguchi.ox.logic.TicTacToeGameLogic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Mainのクラス、このアプリケーションのエントリーポイント
 * Created by sekiguchikai on 2016/12/20.
 */
public class Main {
    /**
     * メインメソッド
     *
     * @param args
     */
    public static void main(String[] args) throws IOException {


        // 最初の選択画面を選択させる
        SelectModeCommandLineIO selectModeCommandLineIO = new SelectModeCommandLineIO();
        selectModeCommandLineIO.drawUI();

        // 実行するゲームのロジック
        GameLogic gameLogic = selectModeCommandLineIO.receiveCommand();
        gameLogic.playGame();


    }


}
