import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import sch.Users;
public class Enrol extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try  {
            Session ssn=HibernateUtil.getSessionFactory().openSession();
            ssn.beginTransaction();
            
            Users user=new Users();
            
            user.setName(request.getParameter("name"));
            user.setRoll(Integer.parseInt(request.getParameter("roll")));
            user.setGender(request.getParameter("gender"));
            user.setBranch((request.getParameter("branch")));
            user.setSem(Integer.parseInt((request.getParameter("sem"))));
            user.setComm((request.getParameter("comm")));
            user.setInc(Integer.parseInt(request.getParameter("income")));
            user.setUsername(request.getParameter("username"));
            user.setPassword(request.getParameter("password"));
            
            ssn.save(user);
            ssn.getTransaction().commit();
            ssn.close();
            
            RequestDispatcher rd=request.getRequestDispatcher("index.html");  
            rd.forward(request, response);
        }  
        catch(HibernateException | NumberFormatException | ServletException | IOException e)
        {
            System.err.println(e);
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