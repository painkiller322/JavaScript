package emp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateEmpServ")
public class UpdateEmpServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateEmpServ() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String empId = request.getParameter("empId");// 메소드를 통해 아이디와 샐러리를 받겠다.
		String salary = request.getParameter("salary");
		String email = request.getParameter("email");
		Employee emp = new Employee();
		emp.setEmployeeId(Integer.parseInt(empId));
		emp.setSalary(Integer.parseInt(salary));
		emp.setEmail(email);

		EmpDAO dao = new EmpDAO();//받은걸 db에 보냄
		dao.updateEmp(emp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
