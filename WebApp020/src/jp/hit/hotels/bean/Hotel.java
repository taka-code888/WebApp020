package jp.hit.hotels.bean;

/*
 * hotelsテーブルの1レコード毎の情報を保持するクラス
 */

public class Hotel {
	
	// ホテルID
	private int id;
	
	// ホテル名
	private String name;
	
	// 最寄り駅
	private String nearestStation;
	
	// 部屋タイプ
	private String roomType;
	
	// 料金
	private int charge;
	
	/**
	 * コンストラクタ
	 * @param id ホテルID
	 * @param name ホテル名
	 * @param nearestStation 最寄り駅
	 * @param roomType 部屋タイプ
	 * @param charge 料金
	 */
	
	// HotelDao で　インスタンス生成時に呼び出される
	public Hotel(int id, String name, String nearestStation, String roomType, int chage) {
		
//		this(name, nearestStation, roomType, chage);
		this.id = id;
		this.name = name;
		this.nearestStation = nearestStation;
		this.roomType = roomType;
		this.charge = chage;
		
	}
	
	/**
	 * コンストラクタ
	 * @param id ホテルID
	 * @param name ホテル名
	 * @param nearestStation 最寄り駅
	 * @param roomType 部屋タイプ
	 * @param charge 料金
	 */
	
	public Hotel(String name, String nearestStation, String roomType, int charge) {
		
		this.name = name;
		this.nearestStation = nearestStation;
		this.roomType = roomType;
		this.charge = charge;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNearestStation() {
		return nearestStation;
	}

	public void setNearestStation(String nearestStation) {
		this.nearestStation = nearestStation;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public int getCharge() {
		return charge;
	}

	public void setCharge(int charge) {
		this.charge = charge;
	}
	

}
