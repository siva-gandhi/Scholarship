<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.List"%>
<%@ page import="sch.ScholarshipDetails"%>
<%@ page import="javax.naming.InitialContext"%>
<%@ page import="scb.SchbeanLocal"%>
<%@ page import="scb.Schbean"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2 Final//EN">
<html lang="en">
<head>
<meta charset="UTF-8">
<title>AU Scholarships</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <style>
*
{
    margin:0;
    padding: 0;
    font-family: Arial, Helvetica, sans-serif;
}
body
{
background-color: #ff7700;
background-image: url("data:image/svg+xml,%3Csvg xmlns='http://www.w3.org/2000/svg' viewBox='0 0 1600 900'%3E%3Cpolygon fill='%23cc0000' points='957 450 539 900 1396 900'/%3E%3Cpolygon fill='%23aa0000' points='957 450 872.9 900 1396 900'/%3E%3Cpolygon fill='%23d6002b' points='-60 900 398 662 816 900'/%3E%3Cpolygon fill='%23b10022' points='337 900 398 662 816 900'/%3E%3Cpolygon fill='%23d9004b' points='1203 546 1552 900 876 900'/%3E%3Cpolygon fill='%23b2003d' points='1203 546 1552 900 1162 900'/%3E%3Cpolygon fill='%23d3006c' points='641 695 886 900 367 900'/%3E%3Cpolygon fill='%23ac0057' points='587 900 641 695 886 900'/%3E%3Cpolygon fill='%23c4008c' points='1710 900 1401 632 1096 900'/%3E%3Cpolygon fill='%239e0071' points='1710 900 1401 632 1365 900'/%3E%3Cpolygon fill='%23aa00aa' points='1210 900 971 687 725 900'/%3E%3Cpolygon fill='%23880088' points='943 900 1210 900 971 687'/%3E%3C/svg%3E");
background-attachment: fixed;
background-size: cover;}
form{
    background: #262626;
    padding: 20px;
    opacity:0.95;
    display:inline-flex;
    flex-direction: column;
    align-items: center;
    border-radius: 8px;
    box-shadow: 0 0 10px rgba(0,0,0,.8);
    width:900px;
    height:100%;
}
form h2{
    margin-top:10px;
    font-size: 50px;
    color:white;
    font-family:times new roman;
}
.div1,.div2{
    border-radius: 35px;
    border:solid 2px #ff7700;
    color: white;
    font-size: 40px;
    font-family: times new roman;
    width:80%;
    height:60px;
    float:left;
    vertical-align: middle;
}
.div1:hover
{
    background: #ff7700;
}
table{
    padding-top:30%;
    width:90%;
    height:100%;
}
td,th
{
    font-size: 25px;
    font-family: times new roman;
    text-transform: uppercase;
    text-align: center;
    color: white;
    vertical-align: middle;
}
  </style>
</head>     
<%!
    private static SchbeanLocal values;
     List<ScholarshipDetails> l2;
    public void jspInit()
    {
        try
        {
            InitialContext ic =new InitialContext();
            values = (SchbeanLocal)ic.lookup("java:global/Scholarship/Schbean");
            l2=values.getscholar();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }  
%>
<%
    Iterator it=l2.iterator();
    %>
    <body>
    <center>
    <form>
    <h2> SCHOLARSHIPS</h2>
    <br><br>
    <%
    if(l2.isEmpty())
    {%>
    <br><br><br>
        <div class="div1">
          <table width="100%">
              <tr>
              <td width="100%"><b><i>NOTHING  AVAILABLE  NOW</i></b></td>
              </tr>
          </table>
        </div>
        <%
            }
    else
{   %>
    <div class="div2">
        <table width="100%">
            <tr>
            <th width="50%"> NAME</th>
                <th width="20%">AMOUNT</th>
                <th width="30%">LAST DATE</th>
            </tr>
        </table>
    </div><br><br>

<%
    }
    while(it.hasNext())
    {
      %><%  ScholarshipDetails stemp=(ScholarshipDetails)it.next();
      %> <div class="div1">
          <table width="100%">
              <tr>
              <td width="50%"><% out.print(stemp.getName());%></td>
              <td width="20%"><% out.print(stemp.getAmount());%></td>
              <td width="30%"><% out.print(stemp.getLastdate());%></td>
              </tr>
          </table>
      </div><br><%
    }
    %>
    </form>
    </center>     
   </body>
</html>
