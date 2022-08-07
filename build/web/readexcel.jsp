<%-- 
    Document   : home
    Created on : 30 ก.ค. 2565, 9:05:56
    Author     : Gus
--%>
<%@page import="java.io.*"%>
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
                                ReadExcel
                            </div>
                            <div class="card-body">
                                <div class="container col-auto ">
                                    <table class="table table-sm " id="mytable1">
                                        <thead>
                                            <tr>
                                                <th>No</th>
                                                <th>NameFile</th>
                                                <th>Detail</th>
                                            </tr>
                                        </thead>                
                                        <tbody>
                                            <%
            String[] list;

            File f = new File(DB.ConnDB.getpathupload());
            list = f.list();
            int n = 0;
            for (String arr : list) {
                n++;
                                            %>
                                            <tr>
                                                <td><%= n%></td>
                                                <td><%= arr%></td>
                                                <td><a href="excel?path=<%= arr%>"><button class="btn btn-sm btn-info">View</button></a></td>
                                            </tr>
                                            <%            }
                                            %>
                                        </tbody>
                                    </table>           
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            
        </div>
        
        <script>
            $(document).ready(function (){
                $("#page4").addClass("active");
                $("#mytable1").DataTable();
            });
        </script>
        <%@ include file="nav/footer.jsp" %>
    </body>
</html>
