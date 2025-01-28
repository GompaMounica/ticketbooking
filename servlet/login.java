package ticketBookingSystem;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static ArrayList<User> userList = new ArrayList<>();

	static {
		userList.add(new User("mounica", "4585884477", "mounica@gmail.com", "555"));
		userList.add(new User("komali", "5281567891", "komali@gmail.com", "456"));
		userList.add(new User("anil", "9934567892", "anil@gmail.com", "789"));
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String phone = request.getParameter("phone");
		String password = request.getParameter("password");

		for (User user : userList) {
			if (user.getPhoneNumber().equals(phone)) {
				if (user.getPassword().equals(password)) {

					//Cookie loginCookie = new Cookie("user", phone);
					//loginCookie.setMaxAge(120);
					//loginCookie.setPath("/");
					//response.addCookie(loginCookie);

//					For cookies we cant use RequestDispatcher because the browser doesn't receive the response with the cookies.
//	              	Thus, cookies are unavailable in the target servlet during the same request lifecycle.

//	              	RequestDispatcher dispatcher = request.getRequestDispatcher("/dashboard");
//	              	dispatcher.forward(request, response);

//	 			  	So when we use the cookies, we can use sendRedirect method so the to ensure cookies are sent back to the server in a new request.
//	              	RequestDispatcher.forward only for internal navigation when cookies or a new request lifecycle are not required.

					response.sendRedirect("DashboardServlet");
				}
			}
		}

		response.getWriter().println("Account Not Present");
	}
}
