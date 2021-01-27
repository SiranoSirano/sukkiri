package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Login;
import model.LoginLogic;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TOP、ログイン画面へフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/index.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//入力内容からリクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String userName = request.getParameter("userName");
		String pass = request.getParameter("pass");

		//ログイン処理の実行
		Login login = new Login(userName,pass);
		LoginLogic bo = new LoginLogic();
		boolean result = bo.execute(login);

		//ログイン処理で結果を分ける
		//		ログイン成功時
		if(result) {
			//				セッションスコープにユーザー名を保存
			HttpSession session = request.getSession();
			session.setAttribute("userName", userName);
			//			ログイン結果画面へフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/loginResult.jsp");
			dispatcher.forward(request, response);
		}
		//		ログイン失敗時
		else {
			// TOP、ログイン画面へリダイレクト
			response.sendRedirect("/スッキリ/LoginServlet");

		}
	}
}


