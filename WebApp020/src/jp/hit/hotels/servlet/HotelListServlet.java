package jp.hit.hotels.servlet;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class HotelListServlet
 */
@WebServlet("/HotelListServlet")
public class HotelListServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		try {
			
			// ホテル一覧の取得
			// ホテルマネージャーのfindAllメソッドを呼び出し
			List<Hotel> hotels = new HotelManager().findAll();
			
			// ホテル一覧をリクエスト・スコープに格納
			request.setAttribute("hotels", hotels);
			
			// hotelList.jspへフォワード
			ServletContext servletContext = getServletContext();
			RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/hotelList.jsp");
			requestDispatcher.forward(request, response);
			
		} catch (ServiceException e) {
			// TODO 自動生成された catch ブロック
			//e.printStackTrace();
			
			// 例外情報をリクエスト・スコープに格納
			request.setAttribute("exception", e);
			
			// exceptionMessage.jspへフォワード
			ServletContext servletContext = getServletContext();
			RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/exceptionMessage.jsp");
			requestDispatcher.forward(request, response);
			
		}
		
		
	}

}
