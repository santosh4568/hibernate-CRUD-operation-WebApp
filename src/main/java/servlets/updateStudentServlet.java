package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import helper.FactoryProvider;
import project.*;

@WebServlet("/updateStudentServlet")
public class updateStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int regd = Integer.parseInt(request.getParameter("roll"));
		String nameString = request.getParameter("naam");
		String emailString = request.getParameter("mail");
		
		Session session = FactoryProvider.getFactory().openSession();

        try {
            // Begin a transaction
            session.beginTransaction();

            // Retrieve the employee with the given ID from the database
            //Employee employee = session.get(Employee.class, employeeId);
            studentWeb stdStudentWeb = session.get(studentWeb.class, regd);

            // Update the employee's information
            if (stdStudentWeb != null) {
                stdStudentWeb.setName(nameString);
                stdStudentWeb.setEmail(emailString);

                // Save the updated employee to the database
                session.merge(stdStudentWeb);
            } else {
            	response.setContentType("text/html");
        		PrintWriter out = response.getWriter();
            	out.println("<h1 style='text-align:center;'>Student Not Found</h1>");
        		out.println("<h1 style='text-align:center;'><a href='display.jsp'>View all Student</a></h1>");
            }

            // Commit the transaction
            session.getTransaction().commit();
        } finally {
            session.close();
        }

        // Redirect to a success page or a list of employees
        response.sendRedirect("display.jsp");
	}

}
