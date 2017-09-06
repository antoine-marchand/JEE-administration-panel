package fr.epf;

import java.io.IOException;
import javax.inject.Inject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Inject
	private UserDao userDao;

	@Override
	public void init() throws ServletException {
		getServletContext().setAttribute("liveUserCount", 0);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/register.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		User u = parseUser(request);

		request.getSession().setAttribute("user", u);

		incrementLiveUserCount();

		userDao.save(u);
		response.sendRedirect("dashboard");
	}

	private User parseUser(HttpServletRequest req) {
		return new User(req.getParameter("firstName"), req.getParameter("lastName"));
	}
	
	private void incrementLiveUserCount() {
		Integer liveUserCount = (Integer) getServletContext().getAttribute("liveUserCount");
		getServletContext().setAttribute("liveUserCount", liveUserCount + 1);
	} 

}
