<%-- 
    Document   : index
    Created on : 29 ก.ค. 2565, 19:47:54
    Author     : Gus
--%>
<%@page import="java.util.*"%>
<%@page import="java.sql.*"%>
<%@page import="DB.ConnDB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <%@include file="nav/head.jsp"%> 
    </head>
    <body>
        
        
        <form action="login" method="post" class="needs-validation" novalidate>
            <div class="container mt-5">
                <div class="card shadow-lg col-6 mx-auto ">
                    <div class="card-header">
                        Login
                    </div>
                    <div class="card-body ">
                        <label>User : </label>
                        <input class="form-control form-control-sm " type="text" name="txt1" id="txt1" required> 
                        <div class="invalid-feedback mb-3 text-center">
                            กรุณาใส่ข้อมูลให้ถูกต้อง
                        </div>
                        <label>Pass : </label>
                        <input class="form-control form-control-sm " type="password" name="txt2" id="txt2" required> 
                        <div class="invalid-feedback mb-3 text-center">
                            กรุณาใส่ข้อมูลให้ถูกต้อง
                        </div>
                        <br>
                        <div class="text-center">
                            <button type="submit" class="btn btn-sm btn-success ">OK</button>
                            <button class="btn btn-sm btn-danger" type="button" id="reset" name="reset">Reset</button>
                        </div>
                    </div>
                </div>
            </div>
       
        </form>
        
        <script>
            $(document).ready(function(){
                $("#reset").click(function (){
                    $("#txt1").val("");
                    $("#txt2").val("");
                });
            });
        </script>
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
        <%@ include file="nav/footer.jsp" %>
    </body>
</html>
