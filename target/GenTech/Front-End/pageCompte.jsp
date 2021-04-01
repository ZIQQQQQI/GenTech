<%@ page import="metier.Commande" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="metier.Rayon" %>
<%@ page import="metier.Produit" %><%--
  Created by IntelliJ IDEA.
  User: olivi
  Date: 2021/3/24
  Time: 19:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Compte</title>

    <!-- Google Font: Source Sans Pro -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="resources/plugins/fontawesome-free/css/all.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="resources/dist/css/adminlte.min.css">
    <!-- overlayScrollbars -->
    <link rel="stylesheet" href="resources/plugins/overlayScrollbars/css/OverlayScrollbars.min.css">
</head>
<body class="hold-transition sidebar-mini">
<div class="tab-content" >
        <section class="content">
            <div class="container-fluid">

            <!--commandes的锚点-->
                <a name="cmd"><i class="far fa-hand-point-down"></i>Commandes</a>
                    <div class="col-md-12">
                        <div class="card card-primary card-outline">
                            <div class="card-body box-profile">
                                <h3 class="profile-username text-center">Les commandes en cours</h3>

                                <ul class="list-group list-group-unbordered mb-3">
                                        <table>
                                            <thead>
                                                <tr>
                                                    <th>Id</th>
                                                    <th>Date Commande</th>
                                                    <th>Date Retrait</th>
                                                    <th>Etat</th>
                                                    <th>Prix</th>
                                                    <th>Magasin</th>
                                                </tr>
                                            </thead>
                                             <tbody>
                                            <%
                                                HashMap<Commande,String> list =(HashMap<Commande,String>)request.getAttribute("listEnCours");
                                            for (Commande c:list.keySet()){%>
                                            <tr>
                                                <td><a href="ServletCommandeDetail?idCde=<%out.print(c.getIdCdeCli());%>"><%out.print(c.getIdCdeCli());%></a> </td>
                                                <td><%out.print(c.getDateCdeCli());%></td>
                                                <td><%out.print(c.getDateRetrait());%></td>
                                                <td><%out.print(c.getEtat());%></td>
                                                <td><%out.print(c.getPrixTotal());%></td>
                                                <td><%out.print(list.get(c));%></td>
                                            </tr>
                                            <%}%>
                                            <!---循环Commandes en cours-->

                                            </tbody>
                                        </table>
                                </ul>
                            </div>
                            <!-- /.card-body -->
                        </div>
                        <!-- /.card -->
                    </div>


                    <!-- /.col -->
                    <div class="col-md-12">
                        <div class="card card-primary card-outline">
                            <div class="card-body box-profile">
                                <h3 class="profile-username text-center">Les commandes termines</h3>

                                <ul class="list-group list-group-unbordered mb-3">
                                    <!---循环Commandes termines-->
                                    <table>
                                        <thead>
                                        <tr>
                                            <th>Id</th>
                                            <th>Date Commande</th>
                                            <th>Date Retrait</th>
                                            <th>Prix</th>
                                            <th>Magasin</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <!---循环Commandes Termines-->
                                        <%HashMap<Commande,String> listT =(HashMap<Commande,String>)request.getAttribute("listTermine");
                                            for (Commande c:listT.keySet()){%>
                                        <tr>
                                            <td><a href="ServletCommandeDetail?idCde=<%out.print(c.getIdCdeCli());%>"><%out.print(c.getIdCdeCli());%></a> </td>
                                            <td><%out.print(c.getDateCdeCli());%></td>
                                            <td><%out.print(c.getDateRetrait());%></td>
                                            <td><%out.print(c.getPrixTotal());%></td>
                                            <td><%out.print(listT.get(c));%></td>
                                        </tr>
                                        <%}%>
                                        </tbody>
                                    </table>
                                </ul>
                            </div>
                            <!-- /.card-body -->
                        </div>
                        <!-- /.card -->
                    </div>


                <!--Preference的锚点-->
                <a name="pref"><i class="far fa-hand-point-down"></i>Préférences</a>
                <div class="row">

                    <!--最常购买的categories-->
                    <div class="col-md-4">
                        <div class="card card-primary card-outline">
                            <div class="card-body box-profile">
                                <h3 class="profile-username text-center">Categorie</h3>

                               <ul class="list-group list-group-unbordered mb-3">
                                   <!---循环Categories-->
                                    <%ArrayList<Rayon> listRayonPrefere=(ArrayList<Rayon>)request.getAttribute("listRayonPrefer");
                                    for(Rayon r:listRayonPrefere){
                                        %>

                                    <li class="list-group-item" style="text-align: center">
                                        <b><a href="#"><i class="fas fa-cookie-bite"></i><%out.print(r.getNomCate());%></a></b>
                                    </li>
                                    <%}%>
                                </ul>
                            </div>
                            <!-- /.card-body -->
                        </div>
                        <!-- /.card -->
                    </div>

                    <!--最常购买的marques-->
                    <div class="col-md-4">
                        <div class="card card-primary card-outline">
                            <div class="card-body box-profile">
                                <h3 class="profile-username text-center">Marques</h3>

                                <ul class="list-group list-group-unbordered mb-3">
                                    <!---循环marques-->
                                    <%ArrayList<String> listMarques=(ArrayList<String>)request.getAttribute("listMarques");
                                    for (String s:listMarques){
                                        %>
                                    <li class="list-group-item" style="text-align: center">
                                        <b><a href="#"><i class="fas fa-registered"></i><%out.print(s);%></a></b>
                                    </li>
                                    <%}%>

                                </ul>
                            </div>
                            <!-- /.card-body -->
                        </div>
                        <!-- /.card -->
                    </div>

                    <div class="col-md-4">
                        <div class="card card-primary card-outline">
                            <div class="card-body box-profile">
                                <h3 class="profile-username text-center">BIO et Nutri-Score</h3>

                                <ul class="list-group list-group-unbordered mb-3">
                                    <table>
                                        <tbody>
                                          <tr>
                                            <td><b>Pourcentage de produit BIO</b></td>
                                            <hr>
                                            <td><%String pourcentage=(String)request.getAttribute("pourcentage");
                                                    out.print(pourcentage);%></td><!--BIO消费占比-->

                                        </tr>
                                        <tr>
                                            <td><b>Nutri-Score le plus préféré</b></td>
                                            <td>A</td><!--营养等级-->
                                        </tr>
                                        </tbody>
                                    </table>
                                </ul>
                            </div>
                            <!-- /.card-body -->
                        </div>
                        <!-- /.card -->
                    </div>
                </div>

                    <!--最常购买的produit-->
                    <div class="col-md-12">
                        <div class="card card-primary card-outline">
                            <div class="card-body box-profile">
                                <h3 class="profile-username text-center">Produit</h3>
                                <hr>

                                <ul class="list-group list-group-unbordered mb-3">
                                    <div class="post">
                                        <div class="user-block">
                                           <!---循环Produit-->
                                            <%ArrayList<Produit> listProduitPrefere=(ArrayList<Produit>)request.getAttribute("listProduitPrefere");
                                            for(Produit p:listProduitPrefere){ %>
                                            <img class="img-circle img-bordered-sm" src="./images/<%out.println( p.getCodeProduit());%>.jpg" alt="imgProd">
                                            <span class="username">
                                              <a href="#"><%out.print(p.getLibelleProduit());%></a>
                                                <a href="#" class="float-right btn-tool"><i class="fas fa-plus-circle"></i></a>
                                                <hr>

                                            </span>
                                            <%}%>
                                        </div>
                                    </div>
                                </ul>
                            </div>
                            <!-- /.card-body -->
                        </div>
                    </div>
                <!--Profle的锚点-->
                <a name="profile"><i class="far fa-hand-point-down"></i>Profile</a>
                <div>
                    <%--                <jsp:include page="pageChart.jsp"></jsp:include>--%>
                    <iframe src="Front-End/pageChart.jsp" style="height: 700px"></iframe>
                </div>

            </div>
        </section>

</div>
<!-- jQuery -->
<script src="resources/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="resources/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- ChartJS -->
<script src="resources/plugins/chart.js/Chart.min.js"></script>
<!-- AdminLTE App -->
<script src="resources/dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="resources/dist/js/demo.js"></script>

</body>
</html>
