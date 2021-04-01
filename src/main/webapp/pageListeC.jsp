<%@ page import="metier.Listecourse" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="metier.Postit" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="metier.Produit" %><%--
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
<%
    Listecourse listecourse=(Listecourse)request.getAttribute("listC");
    ArrayList<Postit> listP=(ArrayList<Postit>)request.getAttribute("listP");
    HashMap<Postit,ArrayList<Produit>> listO=(HashMap<Postit,ArrayList<Produit>>) request.getAttribute("listOption");

%>
<body class="hold-transition sidebar-mini layout-fixed" data-panel-auto-height-mode="height">
<section class="content-header">
    <div class="container-fluid" >
        <div class="row mb-2">
            <div class="col-sm-12">
                <h1 class="text-info" style="text-align: center;"><b><%out.print(listecourse.getLibelleListe());%></b></h1>
            </div>
        </div>
    </div><!-- /.container-fluid -->
</section>
<section class="content">
    <div class="row">
        <div class="col-12">

            <form action="ServletChangeOption" method="GET">
                <input type="hidden" name="size" value="<%out.print(listP.size());%>">
                <input type="hidden" name="idL" value="<%out.print(listecourse.getIdListe());%>">
                <table class="table" style="text-align: center;margin: 20px;">
                    <thead>
                    <tr>
                        <th></th>
                        <th>Produit</th>
                        <th>Quantité</th>
                    </tr>
                    </thead>
                    <tbody>

                    <%
                        for (Postit p:listP
                             ) {


                    %>
                    <tr>
                        <td><%out.print(p.getLibellePost());  %></td>
                        <%
                        ArrayList<Produit> listOption=listO.get(p);
                        %>
                        <td><select name="<%out.print(p.getIdPost());%>" style="width:100%; ">
                            <option value="0"></option>
                            <%
                                for (Produit produit:listOption
                                     ) {%>

                            <option value="<%out.print(produit.getCodeProduit()) ;%>" <%
                                if (produit.getCodeProduit()==p.getIdProduit()){
                                    out.print("selected='selected'");
                                }//slecte

                            %> ><%out.print(produit.getLibelleProduit());%></option>

                             <%   }//fin  for option


                            %>

                        </select></td>
                        <td><input type="number" name="qte<%out.print(p.getIdPost());%>" min="1" max="50" value="<%out.print(p.getQuantite());%>"></td>
                    </tr>
                    <%
                        }//fin for post
                    %>
                    </tbody>
                </table>
                <input type="submit" class="btn btn-info float-right" style="margin: 20px" name="btnListeCourses" value="Modifier">

            </form>

            <%
            if(listP.size()<5){
                %>
            <br/>
            <form method="post" action="ServletAjouterPost">
                <table class="table" style="text-align: center;margin: 20px;">
                    <tbody>
                        <tr>
                            <td style="text-align: center">Post-It:</td>
                            <td><input name="post" required type="text" style="width: 100%"></td>
                            <td><input type="hidden" name="listC" value="<%out.print(listecourse.getIdListe());%>"></td>
                        </tr>
                    </tbody>
                </table>
                <td><input class="btn btn-info float-right" type="submit" value="Ajouter" style="margin: 20px"></td>
            </form>



            <%
            }//fin if
            %>
            <table class="table" style="text-align: center">
                <tbody>
                <tr><td>Ajouter la liste au panier,une fois le boutton clique,la liste va etre supprime et le post-it pour lequel vous n'avez pas choisi de produit ne va pas etre ajoute</td></tr>
                <tr><td> <a href="ServletAjouterPanier?id=<%out.print(listecourse.getIdListe());%>" class="btn btn-info">Ajouter au panier</a></td></tr>
                </tbody>
            </table>
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
