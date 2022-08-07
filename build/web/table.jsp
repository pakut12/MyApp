<%-- 
    Document   : home
    Created on : 30 ก.ค. 2565, 9:05:56
    Author     : Gus
--%>
<%@page import="java.sql.*"%>
<%@page import="DB.*"%>
<%@page import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <%@include file="nav/head.jsp"%> 
    </head>
    <body>
        
        
        <%@include file="nav/nav.jsp" %>
        
        <div class="container">
            <div class="row">
                <div class="col-3"> 
                    <div class="card shadow ">
                        <div class="card-header">
                            โปรไฟล์
                        </div>
                        <div class="card-body text-center">
                            <p>รูปโปรไฟล์</p>
                            <img src="https://cdn-icons-png.flaticon.com/512/149/149071.png" class="img-thumbnail w-50 h-50 mb-3" >
                            <p>User : <%= session.getAttribute("user")%></p>
                        </div>
                    </div>
                </div>
                <div class="col-9">
                    <div id="pageview">
                        <div class="card shadow ">
                            <div class="card-header">
                                Table
                            </div>
                            <div class="card-body">
                                <table class="table table-sm " id="mytable">
                                    <thead>
                                        <tr>
                                            <th>No</th>
                                            <th>User</th>
                                            <th>Pass</th>
                                            <th>Edit</th>
                                            <th>Del</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%
            String sql = "SELECT * FROM `tb_user`;";

            ArrayList<String> user = DB.ConnDB.getsqldata(sql, "user");
            ArrayList<String> pass = DB.ConnDB.getsqldata(sql, "pass");

            try {
                if (user.size() > 0 && pass.size() > 0) {

                    for (int n = 0; n < user.size(); n++) {
                        int id = (n + 1);
                        out.print("<tr>");
                        out.print("<td>" + id + "</td>");
                        out.print("<td>" + user.get(n) + "</td>");
                        out.print("<td>" + pass.get(n) + "</td>");
                        out.print("<td><a href='page/edit.jsp?id=" + id + "'><button type='button' class='btn btn-sm btn-warning'>Edit</button></a></td>");
                        out.print("<td><a href='del?id=" + id + "'><button type='button' class='btn btn-sm btn-danger'>Del</button></a></td>");
                        out.print("</tr>");
                    }

                }
            } catch (Exception e) {
                out.print(e);
            }


                                        %>
                                        
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            
        </div>
        <script>
            $(document).ready(function (){
                $("#page2").addClass("active");
                $("#mytable").DataTable();
            });
        </script>
        <%@ include file="nav/footer.jsp" %>
        
    </body>
</html>
