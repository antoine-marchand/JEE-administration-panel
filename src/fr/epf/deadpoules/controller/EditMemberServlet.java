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
		
		Long memberId = Long.valueOf(request.getParameter("memberId"));
		request.setAttribute("member", memberDao.findOne(memberId));
		request.setAttribute("promotions", promotionDao.findAll());
		
		request.getRequestDispatcher("WEB-INF/edit-member.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Member newMember = editMember(request);
		memberDao.update(newMember);
		
		response.sendRedirect("dashboard");
		
	}

	private Member editMember(HttpServletRequest request) {
		
		Long memberId = Long.valueOf(request.getParameter("memberId"));
		Member oldMember = memberDao.findOne(memberId);
		
		oldMember.setName(request.getParameter("name"));
		oldMember.setEmail(request.getParameter("email"));
		
		String param = request.getParameter("birthdate");
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate birthdate;
		birthdate = LocalDate.parse(param, format);
		
		oldMember.setBirthdate(birthdate);
		
		Promotion promotion = promotionDao.findByName(String.valueOf(request.getParameter("promotion")));

		oldMember.setPromotion(promotion);
		
		return oldMember;
	}
	
}
