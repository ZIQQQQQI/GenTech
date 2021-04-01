<%--
  Created by IntelliJ IDEA.
  User: olivi
  Date: 2021/3/28
  Time: 17:42
  To change this template use File | Settings | File Templates.
--%>
<%--/*--%>
<%--*@param nomCate--%>
<%--*@return metier.Rayon--%>
<%--*@author Tu--%>
<%--*@description--%>
<%--*@exception--%>
<%--*@date 30/03/2021 10:54--%>
<%--*/--%>
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
                <br>
                <a name="cmd"><i class="far fa-hand-point-down"></i>Saisir les commandes: </a>
                <p></p>

                <div class="col-md-12">
                    <div class="card card-primary">
                        <div class="card-header">
                            <h3 class="card-title" style="text-align: center">La formulaire de nouvelle commande d'achat</h3>
                        </div>
                        <div class="card-body">
                        <form id="commandeAchatEntrepot" action="ServletNewCommande" method="get">
                            <table class="table table-striped">
                                <tbody>
                                <tr style="text-align: center;">
                                    <td style="width: 400px;"><b>ID Commande Achat: </b></td>
                                    <td>

                                            <input type="text" name="formidCdeAchat" style="width:400px;" value="<%=request.getParameter("formidCdeAchat")==null?"":request.getParameter("formidCdeAchat")%>">

                                    </td>
                                </tr>
                                <tr style="text-align: center;">
                                    <td style="width: 200px;"><b>Date Commande Achat:</b></td>
                                    <td>

                                        <input type="date" name="formdateCdeAchat" style="width:400px;">

                                    </td>
                                </tr>
                                <tr style="text-align: center;">
                                    <td style="width: 200px;"><b>Date Commande Arrive: </b></td>
                                    <td>

                                        <input type="date" name="formdateCdeArrive" style="width:400px;">

                                    </td>
                                </tr>
                                <tr style="text-align: center;">
                                    <td style="width: 200px;"><b>Etat Commande Achat: </b></td>
                                    <td>

                                        <input type="text" name="formetatCdeArrive" style="width:400px;">

                                    </td>
                                </tr>
                                <tr style="text-align: center;">
                                    <td style="width: 200px;"><b>ID Magasin: </b></td>
                                    <td>

                                        <input type="text" name="formidMagasin" style="width:400px;">

                                    </td>
                                </tr>
                                </tbody>
                            </table>
                                <input type="submit" id="btn_submit1" value="submit" class="btn btn-success" style="display:block;margin:0 auto"/>

                        </form><br>
                            <div style="text-align:center">
                                <% String Msg = (String)session.getAttribute("Msg");
                                if(Msg != null) {
                                    out.print(Msg);
                                    session.removeAttribute("Msg");
                                }
                                %>
                            </div>
                        </div>

                        <div class="card-body">

                            <form id="commandeLigneAchat" action="ServletLigneAchat" method="get">
                                <table class="table table-striped">
                                    <tbody>

                                <tr style="text-align: center;">
                                    <td style="width: 400px;"><b>ID Commande Achat: </b></td>
                                    <td>

                                        <input type="text" name="formidCdeAchatA" style="width:400px;">

                                    </td>
                                </tr>
                                <tr style="text-align: center;">
                                    <td style="width: 200px;"><b>EAN du Produit: </b></td>
                                    <td>

                                            <input type="text" name="formidProduit" style="width:400px;">

                                    </td>
                                </tr>
                                <tr style="text-align: center;">
                                    <td style="width: 200px;"><b>Quantité Achat: </b></td>
                                    <td>

                                            <input type="text" name="formqteAchat" style="width:400px;">

                                    </td>
                                </tr>
                                <tr style="text-align: center;">
                                    <td style="width: 200px;"><b>Quantité Reste: </b></td>
                                    <td>

                                            <input type="text" name="formqteReste" style="width:400px;">

                                    </td>
                                </tr>

                                </tbody>
                            </table>
                            <input type="submit" id="btn_submit2" value="submit" class="btn btn-success" style="display:block;margin:0 auto"/>
                        </form><br/>
                            <div style="text-align:center">
                                <% String LinMsg = (String)session.getAttribute("LinMsg");
                                    if(LinMsg != null) {
                                        out.print(LinMsg);
                                        session.removeAttribute("LinMsg");
                                    }
                                %>
                            </div>

                        </div>
                    </div>
                </div>

                <br>
                <a name="Stockage"><i class="far fa-hand-point-down"></i>Choisir les rayons et les produits </a>
                <p></p>
                <div class="col-md-12">
                    <div class="card card-primary">
                        <div class="card-header">
                            <h3 class="card-title" style="text-align: center">Afficher les produits</h3>
                        </div>
                        <div class="card-body box-profile">
<%--                            <h3 class="profile-username text-center">Les Stockage de 15 jours</h3>--%>

                            <select id="listRayon"><option>----------</option></select>
                            <input id="bt_Rayon" type="button" value="Afficher les rayons" />
                            <div id="lproduit"><br></div>

                        </div>
                        <!-- /.card-body -->
                    </div>

                </div>

                <br>
                <a name="stock"><i class="far fa-hand-point-down"></i>les stocks pour chaque produit </a>
                <p></p>
                <div class="col-md-12">
                    <div class="card card-primary">
                <div class="card-header">
                    <h3 class="card-title" style="text-align: center">Les stocks pour 15 jours</h3>
                </div>
                <div class="card-body">

                        <!-- Date -->
                        <!-- Date range -->
                        <table class="table" style="table-layout: fixed">
                            <tr>
                                <td>produitid</td>
                                <td>qteachat</td>
                                <td>date</td>
                                <td>reste</td>
                                <td>restetotal</td>
                            </tr>
                        </table>
                        <table class="table table-striped" id="rayonprod" style="table-layout: fixed">

                        </table>

                </div>

                </div>
            </div>


            </div>
        </section>
    </div>

<!-- jQuery -->

    <script src="resources/plugins/jquery/jquery.min.js"></script>
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
