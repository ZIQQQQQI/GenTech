<%@ page import="java.util.ArrayList" %>
<%@ page import="metier.Ligneachat" %>
<%@ page import="dao.DaoProduit" %>
<%@ page import="dao.DaoPanier" %>
<%@ page import="metier.Produit" %><%--
  Created by IntelliJ IDEA.
  User: olivi
  Date: 2021/3/29
  Time: 9:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <%
        ArrayList<Ligneachat> ligneachats=(ArrayList<Ligneachat>)request.getAttribute("listLigne");
    %>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Title</title>

    <!-- Google Font: Source Sans Pro -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="Front-End/resources/plugins/fontawesome-free/css/all.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="Front-End/resources/dist/css/adminlte.min.css">
</head>
<body>
<section class="content">
    <div class="container-fluid">

        <div class="col-12">
            <div class="callout callout-info">
                <h5><i class="fas fa-info"></i> Formulaire de Commande</h5>
                <!--输入 l'etat de commande-->
            </div>
        <!--显示csv处理后的返回数据-->
            <form id="formRetour">
                <table class="table">
                    <thead>
                    <tr>
                        <th>Code Produit</th>
                       
                        <th>Quantité</th>
                    </tr>
                    </thead>
                    <tbody>
                    <!--循环-->
                    <%
                        for (Ligneachat l:ligneachats
                             ) {

                        %>
                    <tr>
                        <td><% out.print(l.getIdProduit()); %></td>
                        
                        <td><%  out.print(l.getQteReste()); %></td>
                    </tr>

                    <%}//fin for
                        %>
                    </tbody>
                </table>
                Date Arrive:<input style="float: left;" type="date" name="date">
                <p><input type="submit" value="Confirmer" class="btn btn-success"/></p>
            </form>
            </div>
        </div>

</section>

<!-- jQuery -->
<script src="Front-End/resources/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="Front-End/resources/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script src="Front-End/resources/dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="Front-End/resources/dist/js/demo.js"></script>
</body>
</html>
