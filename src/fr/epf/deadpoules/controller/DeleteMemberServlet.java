package fr.epf.deadpoules.controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.epf.deadpoules.model.Member;
import fr.epf.deadpoules.persistence.MemberDao;
import fr.epf.deadpoules.persistence.PromotionDao;

@WebServlet("/delete-member")
public class DeleteMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private MemberDao memberDao;

	@Inject
	private PromotionDao promotionDao;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Long memberId = Long.valueOf(request.getParameter("memberId"));
		Member deleteMember = memberDao.findOne(memberId);
		deleteMember.getPromotion().decrementNumMembers();
		promotionDao.update(deleteMember.getPromotion());
		memberDao.delete(deleteMember);
		request.setAttribute("promotions", promotionDao.findAll());
		response.sendRedirect("dashboard");
	}

}
