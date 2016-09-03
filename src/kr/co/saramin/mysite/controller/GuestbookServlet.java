package kr.co.saramin.mysite.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.saramin.mvc.MVCUtil;
import kr.co.saramin.mysite.dao.GuestbookDao;
import kr.co.saramin.mysite.vo.GuestbookVo;

/**
 * Servlet implementation class GuestbookServlet
 */
@WebServlet("")
public class GuestbookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); //parameter data encoding by post method
		String actionName = request.getParameter("a");
		if("deleteform".equals(actionName)) {
			System.out.println("#####666666666666666#################");			
			MVCUtil.forward(
					request, 
					response, 
					"/WEB-INF/views/guestbook/deleteform.jsp");
			
		}else if("delete".equals(actionName)) {
			String no = request.getParameter("no");
			String password = request.getParameter("password");
			GuestbookVo vo = new GuestbookVo();
			vo.setNo(Long.parseLong(no));
			vo.setPassword(password);
			new GuestbookDao().delete(vo);
			
			MVCUtil.redirect(request, response, "/mysite2/guestbook/list.jsp");
		}else {
			/*default action list */
			GuestbookDao dao = new GuestbookDao();
			List<GuestbookVo> list = dao.getList();
			
			request.setAttribute("list", list);
			MVCUtil.forward(
					request, 
					response, 
					"/WEB-INF/views/guestbook/list.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
