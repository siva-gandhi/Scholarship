import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;
import scb.SchbeanLocal;
import sch.ScholarshipDetails;
import sch.Users;

public class Validate extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                
             String username = request.getParameter("username");
             String password = request.getParameter("password");
             boolean found=false;
             InitialContext ic=new InitialContext();
             SchbeanLocal sbean;
             sbean=(SchbeanLocal)ic.lookup("java:global/Scholarship/Schbean");
              HttpSession session=request.getSession();
             
              if(username.equals("admin@gmail.com") && password.equals("admin123"))             ## Considering just a single Admin this can be stated directly instead of a Database Fetch
                   response.sendRedirect("add.html");                                           ## If Multiple Admins are allowed then it their details will be fetched and matched as it has been for users
              
              Session ssn=HibernateUtil.getSessionFactory().openSession();
              ssn.beginTransaction(); 
              List list=ssn.createQuery("from Users").list();                                   ## Fetch User details
              Iterator iter=list.iterator();
              while(iter.hasNext())
              {
                 Users temp=(Users)iter.next();                                                 ## Iterate through users and fetch data for a match
                 System.out.println(temp.getUsername());
                 if(temp.getUsername().equals(username)&&temp.getPassword().equals(password))           
                 {
                     found=true;
                     String qstr="from ScholarshipDetails as p where (p.gender=:gid or p.gender='General') and p.income>:inc and (p.comm=:cid or p.comm='oth') and (p.department=:did or p.department='all')";
                     List l1=ssn.createQuery(qstr).setString("gid", temp.getGender()).setInteger("inc",temp.getInc()).setString("cid", temp.getComm()).setString("did",temp.getBranch()).list();
                     Iterator it=l1.iterator();
                     ssn.getTransaction().commit();                                             ## Query to fetch the appropriate Scholarship IDs for the Respective user
                     ssn.close();
                     sbean.restart();
                     while(it.hasNext())
                     {
                         ScholarshipDetails stemp=(ScholarshipDetails)it.next();
                         System.out.println(stemp.getName());
                         sbean.addscholar(stemp);                                               ## Fetch the details for the selected Scholarships
                     }
                     System.out.println(sbean.getscholar().size());
                     break;         
                 }
              } 
            if(found==true)
               response.sendRedirect("search.jsp");                                             ## Redirect the User to Listing or Index page appropriately
            else
               response.sendRedirect("index.html");
        }
        catch(Exception e)
        {
            System.err.println (e);
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
