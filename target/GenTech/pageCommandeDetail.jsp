<%@ page import="java.util.HashMap" %>
<%@ page import="java.text.DecimalFormat" %>
<%@ page import="metier.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.lang.reflect.Method" %><%--
  Created by IntelliJ IDEA.
  User: olivi
  Date: 2021/3/28
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Detail de commande</title>

    <!-- Google Font: Source Sans Pro -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="Front-End/resources/plugins/fontawesome-free/css/all.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="Front-End/resources/dist/css/adminlte.min.css">

</head>
<body>
<%Client client=(Client)request.getAttribute("client");
Magasin magasin=(Magasin)request.getAttribute("magasin");
    Commande commande =(Commande)request.getAttribute("commande");
    HashMap<Produit,Integer> ligneCommande =(HashMap<Produit,Integer>)request.getAttribute("ligneCommande");
%>

<!-- Content Header (Page header) -->
<section class="content-header">
    <div class="container-fluid">
        <div class="row mb-2">
            <div class="col-sm-6">
                <h1><b>Ma Commande</b></h1>
            </div>
        </div>
    </div><!-- /.container-fluid -->
</section>

<section class="content">
    <div class="container-fluid">
        <div class="row">
            <div class="col-12">
                <div class="callout callout-info">
                    <h5><i class="fas fa-info"></i> Etat de commande:<b><%out.print(commande.getEtat());%></b></h5>

                    <!--输入 l'etat de commande-->
                </div>


                <!-- Main content -->
                <div class="invoice p-3 mb-3">
                    <!-- title row -->
                    <div class="row">
                        <div class="col-12">
                            <h4>
                                <h3 class="float-left"><b>Information Detail</b></h3>
                            </h4>
                        </div>
                        <!-- /.col -->
                    </div>
                    <!-- info row -->
                    <div class="row invoice-info">
                        <div class="col-sm-4 invoice-col">

                            <address>
                                Nom Prenom:<strong><%out.print(client.getNomClient());%> <%out.print(client.getPrenomClient());%></strong><br>
                                Tel Client:<b><%out.print(client.getTelClient());%></b><br>
                                Email de client:<b><%out.print(client.getEmailClient());%></b><br>
                                Num Commande: <b><%out.print(commande.getIdCdeCli());%></b><br>
                                Date Commande:<b><%out.print(commande.getDateCdeCli());%></b>
                            </address>
                        </div>
                        <!-- /.col -->
                        <div class="col-sm-4 invoice-col">

                        </div>
                        <!-- /.col -->
                        <div class="col-sm-4 invoice-col">
                            Date de retrait:<b><%out.print(commande.getDateRetrait());%> </b><br>
                            creneau de retrait:<b><%String cr=commande.getHeureRetrait();

                            switch (cr){
                                case "1":
                                    out.print("8:00-9:00");break;
                                case "2":
                                    out.print("9:00-10:00");break;
                                case "3":
                                    out.print("10:00-11:00");break;
                                case "4":
                                    out.print("11:00-12:00");break;
                                case "5":
                                    out.print("12:00-13:00");break;
                                case "6":
                                    out.print("13:00-14:00");break;
                                case "7":
                                    out.print("14:00-15:00");break;
                                case "8":
                                    out.print("15:00-16:00");break;
                                case "9":
                                    out.print("16:00-17:00");break;
                                case "10":
                                    out.print("17:00-18:00");break;

                            }
                        %></b><br>
                            Numero de magasin de retrait:<b><%out.print(magasin.getIdMagasin());%></b><br>
                            Nom de magasin de retrait:<b><%out.print(magasin.getLibelleMagasin());%></b><br>
                            Adreese de magasin:<b><%out.print(magasin.getAdresseMagasin());%></b>
                        </div>
                        <!-- /.col -->
                    </div>
                    <!-- /.row -->

                    <!-- Table row -->
                    <div class="row">
                        <div class="col-12 table-responsive">
                            <table class="table table-striped">
                                <thead>
                                <tr>
                                    <th>Nom de Produit</th>
                                    <th>Qty</th>
                                    <th>Subtotal</th>
                                </tr>
                                </thead>
                                <tbody>

                                    <!--循环produit-->
                                    <%for(Produit p:ligneCommande.keySet()){
                                       %>
                                    <tr>
                                    <td><%out.print(p.getLibelleProduit());%></td>
                                    <td><%out.print(ligneCommande.get(p));%></td>
                                    <td>€<%DecimalFormat df   =new DecimalFormat("#.00");

                                        out.print(df.format(p.getPrixVente()*ligneCommande.get(p)));%></td>
                                    </tr>
                                    <%}%>

                                </tbody>
                            </table>
                        </div>
                        <!-- /.col -->
                    </div>
                    <!-- /.row -->

                    <div class="row">
                        <!-- accepted payments column -->

                        <!-- /.col -->
                        <div class="col-12">
                            <p class="lead"><b>Prix Commande</b></p>

                            <div class="table-responsive">
                                <table class="table">
                                    <tr>
                                        <th style="width:50%">Total original:</th>
                                        <td>€<%out.print(commande.getEconomie()+commande.getPrixTotal());%></td>
                                    </tr>
                                    <tr>
                                        <th>Promotion:</th>
                                        <td>€<%out.print(commande.getEconomie());%></td>
                                    </tr>
                                    <tr>
                                        <th>Total:</th>
                                        <td>€<%out.print(commande.getPrixTotal());%></td>
                                    </tr>
                                </table>
                            </div>
                        </div>
                        <!-- /.col -->
                    </div>
                    <!-- /.row -->

                    <!-- this row will not appear when printing -->
                    <div class="row no-print">
                        <div class="col-12">
                            <a href="ServletCompteProfil" rel="noopener" target="_blank" class="btn btn-default">Retour</a>
                            <% if(!commande.getEtat().equals("Termine")){
                                out.print("<button type='button' id='btnModif' class='btn btn-success float-right'><i class='far fa-calendar-alt'></i>Modifier</button>");


                            }%>
                        </div>
                    </div>
                    <br/>
                    <script type="text/javascript">
                        function OpenDiv(){
                            document.getElementById("zoneModif").style.display="block";}

                        document.addEventListener("DOMContentLoaded", () => {
                            document.getElementById("btnModif").addEventListener("click",OpenDiv);
                        })
                    </script>

                    <div id="zoneModif" style="display: none;">


                    <div class="col-12">
                        <h5>Changer le creneau de retrait</h5>
                        <form action="ServletCreneau" method="get">
                        <table class="table">
                            <tbody>
                            <tr>
                                </td>
                                <td><div class="form-group">
                                    <select class="form-control custom-select" name="idCreneau">
                                        <!--循环 填入时间-->
                                        <%
                                            ArrayList<Creneau> listC=(ArrayList<Creneau>)request.getAttribute("listcreneau");
                                            for(int i=0; i<listC.size(); i++)
                                            {
                                        %>
                                            <option value= <%out.print(listC.get(i).getHeureRetrait());%>
                                                    <%if(listC.get(i).getHeureRetrait().equals(cr)){
                                                    out.print("selected");
                                                    }%>


                                            ><% out.print(listC.get(i).getDescription());%></option>

                                <%}%>
                                    </select>
                                    <input type="hidden" name="idCde" value=<%out.print(commande.getIdCdeCli());%>>
                                </div>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                            <div class="row no-print">
                                <div class="col-12">
                                    <a><button type="submit" class="btn btn-success float-right">Modifier</button></a>
                                </div>
                            </div>

                        </form>
                    </div>
                    <!-- /.invoice -->
                </div><!-- /.col -->
                </div>
            </div><!-- /.row -->
        </div><!-- /.container-fluid -->
        <script type="text/javascript">

        </script>

    </div>
</section>
<!-- /.content -->

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
