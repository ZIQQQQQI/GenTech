<%--
  Created by IntelliJ IDEA.
  User: olivi
  Date: 2021/3/30
  Time: 9:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Liste des courses</title>
    <!-- Google Font: Source Sans Pro -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="./Front-End/resources/plugins/fontawesome-free/css/all.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="./Front-End/resources/dist/css/adminlte.min.css">
    <!-- overlayScrollbars -->
    <link rel="stylesheet" href="./Front-End/resources/plugins/overlayScrollbars/css/OverlayScrollbars.min.css">
</head>
<%
String id=(String)request.getAttribute("id");

%>
<body>

<section class="content-header">
    <div class="container-fluid" >
        <div class="row mb-2">
            <div class="col-sm-12">
                <h1 style="margin:10px"><b>Nouvelle Liste</b></h1>
            </div>
        </div>
    </div><!-- /.container-fluid -->
</section>
<section class="content">
    <div class="row">
        <div class="col-12">

            <form action="ServletCreerList" method="GET">
                <table class="table" style="text-align: center;">
                    Nom de Liste:<input type="text" name="nom">

                    <input type="hidden" value="<%out.print(id);%>" name="id">
                    <tbody>
                    <tr>
                        <td>1</td>
                        <td>Post-It:</td>
                        <td><input type="text" name="num1"></td>
                    </tr>
                    <tr>
                        <td>2</td>
                        <td>Post-It:</td>
                        <td><input type="text" name="num2"></td>
                    </tr>
                    <tr>
                        <td>3</td>
                        <td>Post-It:</td>
                        <td><input type="text" name="num3"></td>
                    </tr>
                    <tr>
                        <td>4</td>
                        <td>Post-It:</td>
                        <td><input type="text" name="num4"></td>
                    </tr>
                    <tr>
                        <td>5</td>
                        <td>Post-It:</td>
                        <td><input type="text" name="num5"></td>
                    </tr>
                    </tbody>
                </table>
                <a href="ServletCompteProfil" class="btn btn-info float-right" style="margin: 20px">Annuler</a>
                <input type="submit" class="btn btn-info float-right" style="margin: 20px" name="btnListeCourses" value="Creer">

            </form>
        </div>
    </div>

</section>


<!-- jQuery -->
<script src=".\Front-End\resources\plugins\jquery\jquery.min.js"></script>
<!-- jQuery UI 1.11.4 -->
<script src="Front-End/resources/plugins/jquery-ui/jquery-ui.min.js"></script>
<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
<script>
    $.widget.bridge('uibutton', $.ui.button)
</script>
<!-- Bootstrap 4 -->
<script src="Front-End/resources/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- overlayScrollbars -->
<script src="Front-End/resources/plugins/overlayScrollbars/js/jquery.overlayScrollbars.min.js"></script>
<!-- AdminLTE App -->
<script src="Front-End/resources/dist/js/adminlte.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="Front-End/resources/dist/js/demo.js"></script>
</body>
</html>
