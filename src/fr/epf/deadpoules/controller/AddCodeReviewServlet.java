package fr.epf.deadpoules.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.epf.deadpoules.model.CodeReview;
import fr.epf.deadpoules.model.Promotion;
import fr.epf.deadpoules.persistence.CodeReviewDao;
import fr.epf.deadpoules.persistence.PromotionDao;

@WebServlet("/add-code-review")
public class AddCodeReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private CodeReviewDao codeReviewDao;

	@Inject
	private PromotionDao promotionDao;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("promotions", promotionDao.findAll());
		request.getRequestDispatcher("WEB-INF/add-code-review.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		CodeReview cr = parseCodeReview(request);
		request.setAttribute("codeReview", cr);
		codeReviewDao.save(cr);
		response.sendRedirect("dashboard");
	}

	private CodeReview parseCodeReview(HttpServletRequest req) {

		String param = req.getParameter("date");
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		LocalDate date;
		date = LocalDate.parse(param, format);

		Promotion promotion = promotionDao.findByName(String.valueOf(req.getParameter("promotion")));
		// Long promParam = Long.valueOf(req.getParameter("promotion"));
		// Promotion promotion = promotionDao.findOne(promParam);

		return new CodeReview(req.getParameter("name"), req.getParameter("description"), date, promotion);

	}

}
