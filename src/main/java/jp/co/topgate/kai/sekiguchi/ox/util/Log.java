package jp.co.topgate.kai.sekiguchi.ox.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.logging.*;

/**
 * ログファイルを残すためのクラス
 * Created by sekiguchikai on 2017/01/13.
 */
public class Log {
    /**
     * ログを書き込む先のファイル
     */
    public static final String LOGFILE = "java.log";

    /**
     * Loggerクラスのインスタンス
     */
    private static Logger logger;


    /**
     * ログに書き込むための初期化を行うためのクラス
     */
    public static void doLogging() {
        // Loggingという名前付きサブシステムのロガー（ログを出力するクラスのインスタンス）を取得する
        // ロガーの名前は、FQCN（完全修飾クラス名）を利用することが慣習
        logger = java.util.logging.Logger.getLogger("jp.co.topgate.kai.sekiguchi.ox.util.Log");

        // logger.info("ログを残します"); のような形で記述する
        // infoメソッドはログレベルに対応している

        // ログを外部の出力ファイルに書き出すための設定を行う
        bundleLogFile(logger);

        // ログの出力を見やすくする
        changeEasyToReadLog(logger);

        // 標準出力に出力されないようにする
        Handler consoleHandle = new ConsoleHandler();

        logger.removeHandler(consoleHandle);


    }

    /**
     * ログに書き込むためのメソッド
     *
     * @param logString ログに書き込む文字
     */
    public static void writeLog(final String logString) {
        logger.info(logString);

    }


    /**
     * ログを外部の出力ファイルに書き出すための設定を行うためのメソッド
     *
     * @param logger Loggerクラスのインスタンス
     */
    private static void bundleLogFile(final Logger logger) {
        try {
            // 出力ファイルを指定する
            /* FileHandler
            単純ファイルのロギング。
            指定されたファイル、またはファイルのローテーションセットのいずれかに書き込むことができる。*/
            FileHandler fh = new FileHandler(LOGFILE);

            /*
             * addHandler
             * ログ Handler を追加してログメッセージを受け取る
             */
            logger.addHandler(fh);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    /**
     * ログの出力を見やすくするためのメソッド
     *
     * @param logger Loggerクラスのインスタンス
     */
    private static void changeEasyToReadLog(final Logger logger) {
        /**
         * FileHandlerに対してjava.util.logging.SimpleFormatterクラスを設定することで、
         * 標準出力画面と同じ書式でファイルに出力できるようになる
         * (デフォルトではXMLで表示される)
         */

        try {
            // 出力ファイルを指定する
            FileHandler fh = new FileHandler(LOGFILE);
            // 出力フォーマットを指定する
            fh.setFormatter(new java.util.logging.SimpleFormatter());
            logger.addHandler(fh);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
