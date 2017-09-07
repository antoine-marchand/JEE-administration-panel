package fr.epf.deadpoules.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.epf.deadpoules.model.Member;
import fr.epf.deadpoules.persistence.MemberDao;
import fr.epf.deadpoules.persistence.PromotionDao;
import fr.epf.deadpoules.model.Promotion;

@WebServlet("/add-member")
public class AddMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Inject
	private MemberDao memberDao;
	
	private PromotionDao promotionDao;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 
		request.getSession().setAttribute("promotions", promotionDao.findAll());
		request.getRequestDispatcher("WEB-INF/add-member.jsp").forward(request, response);
		

	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Member u = parseMember(request);

		request.getSession().setAttribute("member", u);

		memberDao.save(u);
		response.sendRedirect("dashboard");
	}

	private Member parseMember(HttpServletRequest req) {
		
		String param = req.getParameter("birthdate");
		SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
		Date birthdate = new Date();
	
//		Utilisez LocalDate
		
		try {
			birthdate = date.parse(param);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		String promParam = req.getParameter("promotion");
		Promotion promotion = promotionDao.findByName(promParam);
				
		return new Member(req.getParameter("name"), req.getParameter("email"), new Date(444), promotion);
	}

}
