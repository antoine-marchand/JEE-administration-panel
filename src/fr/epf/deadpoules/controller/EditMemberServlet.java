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

import fr.epf.deadpoules.model.Member;
import fr.epf.deadpoules.model.Promotion;
import fr.epf.deadpoules.persistence.MemberDao;
import fr.epf.deadpoules.persistence.PromotionDao;


@WebServlet("/edit-member")
public class EditMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Inject
	private MemberDao memberDao;
	
	@Inject
	private PromotionDao promotionDao;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Long memberId = Long.valueOf(request.getParameter("id"));
		request.setAttribute("member", memberDao.findOne(memberId));
		request.setAttribute("promotions", promotionDao.findAll());

		request.getRequestDispatcher("WEB-INF/edit-member.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		editMember(request);
		
		response.sendRedirect("dashboard");
		
	}

	private void editMember(HttpServletRequest request) {
		
		Long memberId = Long.valueOf(request.getParameter("member.id"));

//		choper l'id 
//		update avec 
		Member oldMember = memberDao.findOne(memberId);
		
		
		String param = request.getParameter("birthdate");
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate birthdate;
		birthdate = LocalDate.parse(param, format);
		
		
		Long promParam = Long.valueOf(request.getParameter("promotion"));
		Promotion promotion = promotionDao.findOne(promParam);
								
	}
	
}
