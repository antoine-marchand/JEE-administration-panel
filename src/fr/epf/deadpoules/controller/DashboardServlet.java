package fr.epf.deadpoules.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.epf.deadpoules.model.Member;
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
		request.setAttribute("numberMembersPromotion", promotionDao.countMembers());
		request.setAttribute("codeReviews", codeReviewDao.findAll());
		request.setAttribute("numberCodeReviews", codeReviewDao.count());

		
		//PAGINATION
		int maxEntriesPerPage = 5;
		int page = 1;

		String pageNumberValue = request.getParameter("pageNumber");

		if (pageNumberValue != null) {
			try {
				page = Integer.parseInt(pageNumberValue);
				System.out.println("Page Number:" + page);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}
		int offset = maxEntriesPerPage * (page - 1);
		
		List<Member>memberList = memberDao.findAll();
		
		HttpSession httpSession = request.getSession();
		httpSession.setAttribute("pages", getPages(memberList, maxEntriesPerPage));
		httpSession.setAttribute("displayedMembers", getListByOffsetAndLength(offset, maxEntriesPerPage, memberList));

		request.getRequestDispatcher("WEB-INF/dashboard.jsp").forward(request, response);
	}

	public ArrayList<Integer> getPages(List<Member> list, int maxEntriesPerPage) {
		ArrayList<Integer> pageNumbers = new ArrayList<>();
		int pages = list.size() / maxEntriesPerPage;
		if (list.size() % maxEntriesPerPage != 0) {
			pages = pages + 1;
		}
		for (int i = 1; i <= pages; i++) {
			pageNumbers.add(new Integer(i));
		}
		return pageNumbers;
	}

	public ArrayList<Member> getListByOffsetAndLength(int offset, int maxEntriesPerPage, List<Member> orginialList) {
		ArrayList<Member> displayedList = new ArrayList<>();
		int lastElementIndex = offset + maxEntriesPerPage;
		if (offset >= orginialList.size())
			offset = orginialList.size() - maxEntriesPerPage;
		if (lastElementIndex > orginialList.size())
			lastElementIndex = orginialList.size();
		for (int i = offset; i < lastElementIndex; i++) {
			displayedList.add(orginialList.get(i));
		}
		return displayedList;
	}
}
