package fr.epf.deadpoules.controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.epf.deadpoules.model.Promotion;
import fr.epf.deadpoules.persistence.PromotionDao;


@WebServlet("/add-promotion")
public class AddPromotionServlet extends HttpServlet {
	
	@Inject
	private PromotionDao promotionDao;
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/add-promotion.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(promotionDao.promotionExist(request.getParameter("name"))) {
			Promotion p = parsePromotion(request);
			request.getSession().setAttribute("promotion", p);
			promotionDao.save(p);
			response.sendRedirect("dashboard");
		}else{
			request.setAttribute("message", "Ce nom est déjà utilisé");
			request.getRequestDispatcher("WEB-INF/add-promotion.jsp").forward(request, response);	
		}

		
		
	}
	
	private Promotion parsePromotion (HttpServletRequest req) {
		return new Promotion(req.getParameter("name"));
	}

}

