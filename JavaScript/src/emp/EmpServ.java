package emp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EmpServ") // 이 페이지의 주소
public class EmpServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EmpServ() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		EmpDAO dao = new EmpDAO();
		List<Employee> list = dao.getEmpList();
		out.println("{\"data\":[");
		int cnt = 0;
		for (Employee emp : list) {
			out.println("{\"firstName\":\"" + emp.getFirstName() + "\",\"lastName\":\"" + emp.getLastName()
					+ "\",\"email\":\"" + emp.getEmail() + "\"}");// 스크립트 출력(\"는 글자 그대로 보이게)
			cnt++;
			if (list.size() != cnt)
				out.println(",");
		}
		out.println("]}");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
