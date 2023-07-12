package jp.hit.hotels.service;

// サービスパッケージに属するクラスでは、　下位情報で発生する例外をキャッチして、ServiceExceptionでラップして再通知します。
// メッセージには、”サービス関連エラー”を設定します。

public class ServiceException extends Exception {
	
	/*コンストラクタ
	 * @param message
	 * @param cause
	 */
	
	public ServiceException(String message, Throwable cause) {
		
		super(message, cause);
		
	}
	

}
