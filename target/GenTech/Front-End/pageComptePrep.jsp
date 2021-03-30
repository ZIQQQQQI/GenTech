<%@ page import="dao.DaoProduit" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="metier.Produit" %>
<%@ page import="dao.DaoRayonCategorie" %>
<%@ page import="metier.Rayon" %><%--
  Created by IntelliJ IDEA.
  User: olivi
  Date: 2021/3/28
  Time: 17:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Compte de preparateur</title>

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
    <div class="tab-content" >
        <section class="content">
            <div class="container-fluid">
                <a name="cmd"><i class="far fa-hand-point-down"></i>Saisir les commandes: </a>
                <div class="col-md-12">
                    <div style="text-align: center">
                        <form id="commandeAchat" action="" method="get">
                            <table class="table">
                                <tbody>
                                <tr>
                                    <td><b>Catégories</b></td>
                                    <td>
                                        <div class="form-group">
                                            <select class="form-control custom-select">
                                                <!--循环-->


                                            </select>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <b>Nom Produit</b>
                                    </td>
                                    <td>
                                        <div class="form-group">
                                            <select class="form-control custom-select">
                                                <% DaoProduit daoprod = new DaoProduit();
                                                    ArrayList<Produit> listeProd = daoprod.listProduitOrdrePrix("null");
                                                    for(Produit p:listeProd){%>
                                                <option><%out.print(p.getLibelleProduit());%></option>
                                                <%}
                                                %>
                                            </select>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <b>Quantité</b>
                                    </td>
                                    <td>
                                        <input type="text" id="qte">
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <b>Date</b>
                                    </td>
                                    <td>
                                        <input style="float: left;" type="date" name="date">
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                            <input type="submit" value="submit" class="btn btn-success"/>
                        </form><br/>

                        <form id="upload-form" action="ServletUploadFile" method="post" enctype="multipart/form-data" >
                            <b><i class="fas fa-paperclip"></i> Attachment</b>
                        　　 <input type="file" id="upload" name="attachement"/>
                            <input class="btn btn-success" type="submit" id="btnUpload" value="Upload" />　　　
                        </form>
                    </div>
                </div>


                <a name="Stockage"><i class="far fa-hand-point-down"></i>Le stockage de 15 jours: </a>
                <div class="col-md-12">
                    <div class="card card-primary card-outline">
                        <div class="card-body box-profile">
                            <h3 class="profile-username text-center">Les Stockage de 15 jours</h3>

                            <ul class="list-group list-group-unbordered mb-3">
                                <table class="table">

                                    <tbody>
                                    <!--循环日期-->
                                    <tr>
                                        <td><a href="pageStockage.jsp">01/01/2021</a> </td>
                                    </tr>

                                    </tbody>
                                </table>
                            </ul>
                        </div>
                        <!-- /.card-body -->
                    </div>

                </div>


                <a name="Creneau"><i class="far fa-hand-point-down"></i>Les créneau</a>
                <div class="col-md-12">
                    <div class="card card-primary">
                <div class="card-header">
                    <h3 class="card-title">Date picker</h3>
                </div>
                <div class="card-body">
                    <form action="" method="GET" id="creneau">
                        <!-- Date -->
                        <!-- Date range -->
                        <label>Duree:</label>
                        <div class="input-group">
                            <div class="input-group-prepend">
                              <span class="input-group-text">
                                <i class="far fa-calendar-alt"></i>
                              </span>
                            </div>
<%--                            <input type="text" class="form-control float-right" id="reservation">--%>
                            <select class="form-control custom-select">
                                <!--循环-->
                                <option>Date</option>
                            </select>
                        </div>
                        <!-- /.input group -->
                        <!-- Date and time range -->
                        <label>Creneaux:</label>
                        <div class="input-group">
                            <div class="input-group-prepend">
                                <span class="input-group-text"><i class="far fa-clock"></i></span>
                            </div>
<%--                            <input type="text" class="form-control float-right" id="reservationtime">--%>
                            <select class="form-control custom-select">
                                <!--循环-->
                                <option>Creneaux</option>
                            </select>
                        </div><br/>
                        <!-- /.input group -->
                        <input type="submit" value="Rechercher" class="btn btn-success">
                    </form>
                </div>

                </div>
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
