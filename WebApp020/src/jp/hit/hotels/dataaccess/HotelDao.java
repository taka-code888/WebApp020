package jp.hit.hotels.dataaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jp.hit.hotels.bean.Hotel;

/**
 * hotelsテーブルへアクセスするクラス
 */

public class HotelDao {
	
	// JDBCドライバ名
	//private static final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
	private static final String DRIVER_NAME = "org.mariadb.jdbc.Driver";

	// 接続文字列
	//private static final String URL = "jdbc:oracle:thin:@//localhost:1521/NEW_PDB";
	private static final String URL = "jdbc:mariadb://localhost:3306/WebApp?useSSL=false";

	// ユーザ名
	//private static final String USER = "hit";
	private static final String USER = "hoge";

	// パスワード
	//private static final String PASSWORD = "hit123";
	private static final String PASSWORD = "hoge123";	
	
	
	// 例外処理を確認する際に使用するパスワード
//	private static final String PASSWORD = "hit456";
	
	/**
	 * hotelsテーブルから全件検索し情報を取得
	 * @return hotelsテーブルから取得した情報のリスト
	 * @throws DaoException データベース関連エラー
	 */
	
	public List<Hotel> findAll() throws DaoException {
		
		// 接続に必要な値
		Connection connection = null;
		// SQL文を実行する値
		PreparedStatement preparedStatement = null;
		// 検索結果を受け取る値
		ResultSet resultSet = null;
		// Item型の値を格納するリスト
		List<Hotel> hotels = new ArrayList<Hotel>();
		
		
		try {
		
		// 接続
		Class.forName(DRIVER_NAME);
		connection = DriverManager.getConnection(URL, USER, PASSWORD);
		
		// SELECT文（hotelsテーブルの全件検索）
		final String SQL_SELECT_ALL = "SELECT * FROM hotels";
		
		// 実行するSQL文の設定
		preparedStatement = connection.prepareStatement(SQL_SELECT_ALL);
		
		// SQL文の実行と検索結果の取得
		resultSet = preparedStatement.executeQuery();
		
		// 取得した検索結果でItem型のインスタンスを生成しリストに格納
		while (resultSet.next()) {
			
			// NUMBER型のホテルIDを取得
			int id = resultSet.getInt("id");
			// VARCHAR型のホテル名を取得
			String name = resultSet.getString("name");
			// VACHAR型の最寄り駅を取得
			String nearestStation = resultSet.getString("nearest_station");
			// VACHAR型の部屋タイプを取得
			String roomType = resultSet.getString("room_type");
			// NUMBER型の料金を取得
			int charge = resultSet.getInt("charge");
			
			// Hotel型のインスタンス生成
			// Hotelクラスのコンストラクタ　引数全部
			Hotel hotel = new Hotel(id, name, nearestStation, roomType, charge);
			
			// リストに追加
			hotels.add(hotel);
		}
		
		return hotels;
		
	} catch (ClassNotFoundException e) {
		throw new DaoException("データベース関連エラー", e);
	} catch (SQLException e) {
		throw new DaoException("データベース関連エラー", e);
	} catch (Exception e) {
		throw new DaoException("データベース関連エラー", e);
	} finally {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if (preparedStatement != null) {
					try {
						preparedStatement.close();
					} catch (SQLException e) {
						e.printStackTrace();
					} finally {
						if (connection != null) {
							try {
								connection.close();
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}
					}
				}
			}
		}
	}
	}


/*
 * 　ホテル情報の登録
 * 　@parm hotelホテル情報
 *   @throws DaoException データベース関連エラー
*/

public void regist(Hotel hotel) throws DaoException {
	
	// 接続に必要な値
    Connection connection = null;
	// SQL文を実行する値
	PreparedStatement preparedStatement = null;
	
	
	// 接続
	try {
		Class.forName(DRIVER_NAME);
		connection = DriverManager.getConnection(URL, USER, PASSWORD);
		
		// INSERT文（入力されたホテル情報をhotelsテーブルに挿入）
		// final String SQL_INSERT = "INSERT INTO hotels VALUES (SEQ_HOTELS.nextval, ?, ?, ?, ?)"
		final String SQL_INSERT = "INSERT INTO hotels VALUES (NULL, ?, ?, ?, ?)";
		
		// 実行するSQL文の設定
		preparedStatement = connection.prepareStatement(SQL_INSERT);
		
		// プレースホルダをバインディング
		preparedStatement.setString(1, hotel.getName());
		preparedStatement.setString(2, hotel.getNearestStation());
		preparedStatement.setString(3, hotel.getRoomType());
		preparedStatement.setInt(4, hotel.getCharge());
		
		// SQL文の実行
		preparedStatement.executeUpdate();
 		
	} catch (ClassNotFoundException e) {
		throw new DaoException("データベース関連エラー", e);
	} catch (SQLException e) {
		throw new DaoException("データベース関連エラー", e);
	} catch (Exception e) {
		throw new DaoException("データベース関連エラー", e);
	} finally {
		if (preparedStatement != null) {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if (connection != null) {
					try {
						connection.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
}