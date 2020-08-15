import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import sch.ScholarshipDetails;
public class Insert extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) 
        {
            ScholarshipDetails obj = new ScholarshipDetails();
        
            Session s = HibernateUtil.getSessionFactory().openSession();
            Transaction t = s.beginTransaction();
            
            String opt=request.getParameter("act");
            
            switch (opt) {
                case "delete":
                    s.createQuery("delete from ScholarshipDetails where id=:sid ").setString("sid",request.getParameter("ID")).executeUpdate();
                    break;
                    
                case "update":
                    s.createQuery("update ScholarshipDetails set lastdate=:date where id=:uid").setString("date",request.getParameter("date")).setString("uid", request.getParameter("ID")).executeUpdate();
                    break;
                    
                case "add":
                    obj.setId(Integer.parseInt(request.getParameter("ID")));
                    obj.setName(request.getParameter("name"));
                    obj.setDepartment(request.getParameter("dept"));
                    obj.setGender(request.getParameter("gender"));
                    obj.setComm(request.getParameter("comm"));
                    obj.setIncome(Integer.parseInt(request.getParameter("income")));
                    obj.setAmount(Integer.parseInt(request.getParameter("amount")));
                    obj.setLastdate(request.getParameter("date"));
                    s.save(obj);
                    break;
                    
                default:
                    break;
            }
            t.commit();
            s.close();
            
            RequestDispatcher rd=request.getRequestDispatcher("add.html");  
            rd.forward(request, response);  
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}