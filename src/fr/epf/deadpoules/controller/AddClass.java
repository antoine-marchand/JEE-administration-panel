package fr.epf.deadpoules.controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.epf.deadpoules.persistence.MemberDao;

@WebServlet("/AddClass")
public class AddClass extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
	@Inject
	private MemberDao classDao;
	
	@Override
	public void init() throws ServletException {
		getServletContext().setAttribute("liveUserCount", 0);
	}
	
    public AddClass() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
