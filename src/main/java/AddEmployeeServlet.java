

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/AddEmployeeServlet")
public class AddEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String empno=request.getParameter("empno");
				String empname=request.getParameter("empname");
		String salary=request.getParameter("salary");
		Employee e=new Employee();
		e.setEmpno(empno);
		e.setEmpname(empname);
		e.setSalary(salary);
		Employeedao d=new Employeedao();
		d.insert(e);
		HttpSession session =request.getSession();
		session.setAttribute("message","Record added successfully");
		
		
		response.sendRedirect("addEmployee.jsp");
		
		
		
		
		
		
	}

}
