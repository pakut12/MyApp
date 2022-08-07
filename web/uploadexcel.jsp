<%-- 
    Document   : home
    Created on : 30 ก.ค. 2565, 9:05:56
    Author     : Gus
--%>

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
                                Upload Excel
                            </div>
                            <div class="card-body">
                                <div class="container col-6 ">
                                    <form action="upload" method="post" enctype="multipart/form-data">
                                        <label>File : </label>
                                        <input class="form-control form-control-sm mb-3" type="file" name="filename" accept=".xls" ></input>
                                        <div class="text-center">
                                            <button class="btn btn-sm btn-success " type="submit" name="submit" id="submit">OK</button>
                                            <button class="btn btn-sm btn-danger mx-2" type="reset" name="reset" id="reset">Reset</button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                        
                    </div>
                </div>
            </div>
            
        </div>
        
        <script>
            $(document).ready(function (){
                $("#page3").addClass("active");
               
            });
        </script>
        <%@ include file="nav/footer.jsp" %>
    </body>
</html>
