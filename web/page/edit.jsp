<%-- 
    Document   : home
    Created on : 30 ก.ค. 2565, 9:05:56
    Author     : Gus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>

<html>
    <head>
        <%@include file="../nav/head.jsp"%> 
    </head>
    <body>
        
        <%
            String id = request.getParameter("id");
            String sql = "SELECT * FROM `tb_user` WHERE id = '" + id + "';";
            ArrayList<String> user = DB.ConnDB.getsqldata(sql, "user");
            ArrayList<String> pass = DB.ConnDB.getsqldata(sql, "pass");
            String status = null;


        %>
        <br><br><br><br>
        <div class="container">
            <div class="row">
                
                <div class="col-6 mx-auto">
                    <div class="card shadow ">
                        <div class="card-header">
                            เเก้ไข
                        </div>
                        <div class="card-body text-center">
                            <form action="../edit" method="post" class="needs-validation">
                                <div class="container">
                                    <label>ID</label>
                                    <input class="form-control form-control-sm mb-3 text-center" type="text" name="txt1" id="txt1" readonly value="<%= id%>">
                                    <label>User</label>
                                    <input class="form-control form-control-sm  text-center" type="text" name="txt2" id="txt2"  value="<%= user.get(0)%>" required>
                                    <div class="invalid-feedback mb-3">
                                        กรุณาใส่ข้อมูลให้ถูกต้อง
                                    </div>
                                    <label>Pass</label>
                                    <input class="form-control form-control-sm  text-center" type="text" name="txt3" id="txt3"  value="<%= pass.get(0)%>" required>
                                    <div class="invalid-feedback mb-3">
                                        กรุณาใส่ข้อมูลให้ถูกต้อง
                                    </div>
                                    
                                    <br>
                                    <button class="btn btn-sm btn-success" name="submit" id="submit"  type="submit">OK</button>
                                    <button class="btn btn-sm btn-danger" name="reset" id="reset" type="button">Reset</button>
                                    <button class="btn btn-sm btn-info" name="home" id="home" type="button">Home</button>
                                </div>
                            </form>
                            
                        </div>
                    </div>
                </div>
            </div>
            
        </div>
        <script>
            (function () {
                'use strict'

                // Fetch all the forms we want to apply custom Bootstrap validation styles to
                var forms = document.querySelectorAll('.needs-validation')

                // Loop over them and prevent submission
                Array.prototype.slice.call(forms)
                .forEach(function (form) {
                    form.addEventListener('submit', function (event) {
                        if (!form.checkValidity()) {
                            event.preventDefault()
                            event.stopPropagation()
                        }
                        form.classList.add('was-validated')
                    }, false)
                })
            })()
        </script>
        <script>
            $(document).ready(function (){
                $("#reset").click(function (){
                    $("#txt2").val("");
                    $("#txt3").val("");
                });
                $("#home").click(function (){
                    location.replace("../home.jsp")
                });
            });
        </script>
        <%@ include file="../nav/footer.jsp" %>
        
    </body>
</html>
