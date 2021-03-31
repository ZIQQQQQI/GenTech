<%--
  Created by IntelliJ IDEA.
  User: olivi
  Date: 2021/3/30
  Time: 16:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Ma Liste des courses</title>
    <!-- Google Font: Source Sans Pro -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="./Front-End/resources/plugins/fontawesome-free/css/all.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="./Front-End/resources/dist/css/adminlte.min.css">
    <!-- overlayScrollbars -->
    <link rel="stylesheet" href="./Front-End/resources/plugins/overlayScrollbars/css/OverlayScrollbars.min.css">
</head>
<body>
<section class="content-header">
    <div class="container-fluid" >
        <div class="row mb-2">
            <div class="col-sm-12">
                <h1 style="margin:10px"><b>Liste des courses</b></h1>
            </div>
        </div>
    </div><!-- /.container-fluid -->
</section>
<section class="content">
    <div class="row">
        <div class="col-12">

            <form action="" method="GET">
                <table class="table" style="text-align: center;">
                    <thead>
                    <tr>
                        <th></th>
                        <th>Produit</th>
                        <th>Quantité</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>N1 de liste</td>
                        <td><select style="width:100%; ">
                            <option></option>
                            <option>preference1</option>
                            <option>preference2</option>
                        </select></td>
                        <td>1</td>
                    </tr>
                    <tr>
                        <td>N2 de liste</td>
                        <td><select style="width:100%;">
                            <option></option>
                            <option>preference1</option>
                            <option>preference2</option>
                        </select></td>
                        <td>3</td>
                    </tr>
                    </tbody>
                </table>
                <input type="submit" class="btn btn-info float-right" style="margin: 20px" name="btnListeCourses" value="Valider">

            </form>
        </div>
    </div>

</section>

<!-- jQuery -->
<script src="../../plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="../../plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script src="../../dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="../../dist/js/demo.js"></script>


</body>
</html>
