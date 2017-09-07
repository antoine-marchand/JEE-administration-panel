package fr.epf.deadpoules;

import java.io.IOException;
import java.util.Date;

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
	private MemberDao memberDao;

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

		Member u = parseUser(request);

		request.getSession().setAttribute("user", u);

		incrementLiveUserCount();

		memberDao.save(u);
		response.sendRedirect("dashboard");
	}

	private Member parseUser(HttpServletRequest req) {
		return new Member(req.getParameter("name"), req.getParameter("email"), new Date(4444));
	}
	
	private void incrementLiveUserCount() {
		Integer liveUserCount = (Integer) getServletContext().getAttribute("liveUserCount");
		getServletContext().setAttribute("liveUserCount", liveUserCount + 1);
	} 

}
