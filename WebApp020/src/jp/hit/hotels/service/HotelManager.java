package jp.hit.hotels.service;

import java.util.List;

import jp.hit.hotels.bean.Hotel;
import jp.hit.hotels.dataaccess.DaoException;
import jp.hit.hotels.dataaccess.HotelDao;
import jp.hit.hotels.service.ServiceException;

public class HotelManager {
	
	
	// ホテル管理クラス
	
	
	/**
	 * hotelsテーブルから全件検索し情報を取得
	 * @return hotelsテーブルから取得した情報のリスト
	 * @throws ServiceException サービス関連エラー
	 */	
	
	// サーブレットからホテルDAOへの連携
	public List<Hotel> findAll() throws ServiceException {
		
		
		try {
			return new HotelDao().findAll();
		} catch (DaoException e) {
			throw new ServiceException("サービス関連エラー", e);
		} catch (Exception e) {
			throw new ServiceException("サービス関連エラー", e);
		}
		
	}
	
	
	
	/*ホテル情報の登録
	 * @param hotel ホテル情報
	 * @throws ServiceException サービス関連エラー
	 */
	
	public void regist(Hotel hotel) throws ServiceException {
		
		try {
			
		new HotelDao().regist(hotel);
		
		} catch (DaoException e) {
			throw new ServiceException("サービス関連エラー", e);
		} catch (Exception e) {
			throw new ServiceException("サービス関連エラー", e);
		}
	}
}
