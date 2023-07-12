package jp.hit.hotels.dataaccess;

public class DaoException extends Exception {
	
	// データアクセスパッケージに属するクラスでは、利用しているクラスで発生する例外をキャッチして、DaoExceptionでラップして再通知します。
	// メッセージには、”データベース関連エラーを設定します。
	
	/*コンストラクト
	 * @param message
	 * @param cause
	 */
	
	public DaoException(String message, Throwable cause) {
		
		super(message, cause);
		
	}
	

}
