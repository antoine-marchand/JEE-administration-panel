package fr.epf.deadpoules.controller;

import java.io.IOException;
import java.util.Date;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.epf.deadpoules.model.CodeReview;
import fr.epf.deadpoules.persistence.CodeReviewDao;
import fr.epf.deadpoules.persistence.PromotionDao;

@WebServlet("/add-code-review")
public class AddCodeReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Inject
	private CodeReviewDao codeReviewDao;
	private PromotionDao promotionDao;
	
    public AddCodeReviewServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.getSession().setAttribute("promotions", promotionDao.findAll());
		request.getRequestDispatcher("WEB-INF/add-code-review.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CodeReview u = parseUser(request);
		request.getSession().setAttribute("codeReview", u);
		codeReviewDao.save(u);
		response.sendRedirect("dashboard");
	}
	
	private CodeReview parseUser(HttpServletRequest req) {
		return new CodeReview(req.getParameter("name"), req.getParameter("description"), new Date(4444), null);

	}

}
