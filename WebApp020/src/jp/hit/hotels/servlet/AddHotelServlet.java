package jp.hit.hotels.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.hit.hotels.bean.Hotel;
import jp.hit.hotels.service.HotelManager;
import jp.hit.hotels.service.ServiceException;

/**
 * Servlet implementation class AddHotelServlet
 */
@WebServlet("/AddHotelServlet")
public class AddHotelServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
		// 入力値の文字コード設定
		request.setCharacterEncoding("UTF-8");
		
		// 入力値の取得
		String name = request.getParameter("name");
		String nearestStation = request.getParameter("nearestStation");
		String roomType = request.getParameter("roomType");
		int charge = Integer.parseInt(request.getParameter("charge"));
		
		// Hotel型のインスタンス生成    Hotelクラスの引数４つのコンストラクタ
		Hotel hotel = new Hotel(name, nearestStation, roomType, charge);
		
		// ホテル情報を登録
			new HotelManager().regist(hotel);
			
			// HotelListServletにリダイレクト
			response.sendRedirect("HotelListServlet");
			
		} catch (ServiceException e) {
			// 例外情報をリクエストスコープに格納
			request.setAttribute("exception", e);
			
			// exceptionMessage.jspへフォワード
			ServletContext servletContext = getServletContext();
			RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/exceptionMessage.jsp");
			requestDispatcher.forward(request, response);
			
		}

	}

}
