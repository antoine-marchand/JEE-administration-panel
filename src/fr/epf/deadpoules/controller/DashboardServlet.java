package fr.epf.deadpoules.controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.epf.deadpoules.persistence.CodeReviewDao;
import fr.epf.deadpoules.persistence.MemberDao;
import fr.epf.deadpoules.persistence.PromotionDao;;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {	
	
	private static final long serialVersionUID = 1L;

	@Inject
	private CodeReviewDao codeReviewDao;
	
	@Inject
	private MemberDao memberDao;
	
	@Inject
	private PromotionDao promotionDao;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setAttribute("members", memberDao.findAll());
		request.setAttribute("numberMembers", memberDao.count());
		request.setAttribute("promotions", promotionDao.findAll());
		request.setAttribute("numberPromotions", promotionDao.count());
		request.setAttribute("codeReviews",codeReviewDao.findAll());
		request.setAttribute("numberCodeReviews", codeReviewDao.count());
		
		request.getRequestDispatcher("WEB-INF/dashboard.jsp").forward(request, response);
	}
}
