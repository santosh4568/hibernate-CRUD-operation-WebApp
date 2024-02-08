package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import helper.FactoryProvider;
import project.*;


@WebServlet("/createStudentServlet")
public class createStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public createStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int regd = Integer.parseInt(request.getParameter("roll"));
		String namString = request.getParameter("naam");
		String emailString = request.getParameter("mail");
		
		//Employee employee = new Employee();
		studentWeb stdStudentWeb = new studentWeb();
		stdStudentWeb.setRoll(regd);
		stdStudentWeb.setName(namString);
		stdStudentWeb.setEmail(emailString);
		Session session = FactoryProvider.getFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.persist(stdStudentWeb);
		tx.commit();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1 style='text-align:center; color : green ;'>Student is added successfully</h1>");
		out.println("<h1 style='text-align:center;'><a href='display.jsp'>View all Student</a></h1>");
	}

}
