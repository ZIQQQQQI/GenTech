<%@ page import="java.util.HashMap" %>
<%@ page import="java.text.DecimalFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="metier.*" %><%--
  Created by IntelliJ IDEA.
  User: olivi
  Date: 2021/3/28
  Time: 15:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Mon Panier</title>

    <!-- Google Font: Source Sans Pro -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="Front-End/resources/plugins/fontawesome-free/css/all.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="Front-End/resources/dist/css/adminlte.min.css">
</head>
<body>
<%Client client =(Client)request.getAttribute("client");
    Magasin magasin=(Magasin)request.getAttribute("magasin");
%>

<!-- Content Header (Page header) -->
<section class="content-header">
    <div class="container-fluid">
        <div class="row mb-2">
            <div class="col-sm-6">
                <h1>Mon Panier</h1>
            </div>
        </div>
    </div><!-- /.container-fluid -->
</section>

<section class="content">
    <div class="container-fluid">
        <div class="row">
            <div class="col-12">


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
                                <th>Economies</th>
                            </tr>
                            </thead>
                            <tbody>
                            <%DecimalFormat df   =new DecimalFormat("00.00");
                                HashMap<Produit,Integer> list=(HashMap<Produit,Integer>)request.getAttribute("listProduitPanier");
                                HashMap<Produit,Promotion> produitPromo =(HashMap<Produit, Promotion>)request.getAttribute("listProduitPromo");
                                Double sum=0.00;
                                Double economies=0.00;
                                double sumEco=0.00;
                            for (Produit p:list.keySet()){
                                sum=sum+ p.getPrixVente()*list.get(p);%>
                            <tr>
                                <!--循环produit-->
                                <td><%out.print(p.getLibelleProduit());%></td>
                                <td><input type="number" name="changeQte" min="1" max="99" idc="<%out.print(p.getCodeProduit());%>" value="<%out.print(list.get(p));%>"></td>
<%--                                <td><a href="ServletModifierPainer?codeProduit=<%out.print(p.getCodeProduit());%>&qte=<%out.print(list.get(p));%>&operation=minus"><i class="fas fa-minus"></i></a> <%out.print(list.get(p));%> <a href="ServletModifierPainer?codeProduit=<%out.print(p.getCodeProduit());%>&qte=<%out.print(list.get(p));%>&operation=add"><i class="fas fa-plus"></i></a></td>--%>
                                <td>€<%out.print(df.format(p.getPrixVente()*list.get(p)));%></td>

                            <%if(produitPromo.containsKey(p)){
                                %>
                                <td>€<%out.print(df.format(economies=p.getPrix()*produitPromo.get(p).getReduction()*list.get(p)));
                                    sumEco=sumEco+economies;%></td>
                                    <%} else{ economies=0.00;
                                        sumEco=sumEco+economies;%>
                                <td>€<%out.print(df.format(economies));%><td>
                                    <%}}%>
                            </tr>
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
                        <p class="lead">Prix Commande</p>

                        <div class="table-responsive">
                            <table class="table">
                                <tr>
                                    <th style="width:50%">Total original:</th>
                                    <td>€<%out.print(df.format(sum));%></td>
                                </tr>
                                <th>Promotion:</th>
                                <td>€<%out.print(df.format(sumEco));%></td>
                                </tr>
                                <tr>
                                    <th>Total:</th>
                                    <td><b>€<%out.print(df.format(sum-sumEco));%></b></td>
                                </tr>
                                <tr>
                                    <th>Point fidélité:</th>
                                    <td><%out.print(client.getScore());%> <button type="button" class="btn btn-primary float-right">Avoir la redution</button></td>
                                </tr>
                                <tr>
                            </table>
                        </div>
                    </div>
                    <!-- /.col -->
                </div>
                <!-- /.row -->

                <!-- this row will not appear when printing -->
                <div class="row no-print">
                    <div class="col-12">
                        <a href="" rel="noopener" target="_blank" class="btn btn-default">Retour</a>
                        <a href="ServletModifierPainer?operation=annuler">Annuler</a>
                        <button id="btnValider" type="button" class="btn btn-success float-right"></i>Suivant
                        </button>
                    </div>
                </div>
                <br/>
                <script type="text/javascript">
                    function OpenDiv(){
                        document.getElementById("zoneModif").style.display="block";}

                    document.addEventListener("DOMContentLoaded", () => {
                        document.getElementById("btnValider").addEventListener("click",OpenDiv);
                    })
                </script>

                <div id="zoneModif" style="display: none;">
                    <div class="col-12">
                        <h5>Confirmer le magasin de retrait</h5>
                        <table class="table">
                            <thead>
                            <tr>
                                <th>Num Magasin</th>
                                <th>Libelle de Magasin</th>
                                <th>Adresse de Magasin</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td><%out.print(magasin.getIdMagasin());%></td>
                                <td><%out.print(magasin.getLibelleMagasin());%></td>
                                <td><%out.print(magasin.getAdresseMagasin());%></td>
                            </tr>
                            </tbody>
                        </table>
                    </div>


                    <div class="col-12">
                        <h5>Choisir le creneau de retrait</h5>
                        <table class="table">
                            <thead>
                            <tr>
                                <th>Date</th>
                                <th>Creneuax</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td><div class="form-group">
                                    <select class="form-control custom-select">
                                        <%Date date=new Date();
                                            SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-YYYY");
                                            Calendar calendar=Calendar.getInstance();
                                            calendar.setTime(new Date());
                                            for (int i = 0; i < 15; i++) { %>
                                        <!--循环 填入日期-->
                                        <option value=<%calendar.add(Calendar.DATE,1);
                                        Date date1=calendar.getTime();
                                            out.print(dateFormat.format(date1));%>><%out.print(dateFormat.format(date1));%></option>

                                        <%}%>
                                    </select>
                                </div>
                                </td>
                                <td><div class="form-group">
                                    <select id="inputStatus" class="form-control custom-select">
                                        <!--循环 填入时间-->
                                        <%
                                            ArrayList<Creneau> listC=(ArrayList<Creneau>)request.getAttribute("listcreneau");
                                            for(int i=0; i<listC.size(); i++)
                                            {
                                        %>
                                        <option value= <%out.print(listC.get(i).getHeureRetrait());%>><% out.print(listC.get(i).getDescription());%></option>

                                        <%}%>
                                    </select>
                                </div>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                    <div class="row no-print">
                        <div class="col-12">
                            <button type="button" class="btn btn-success float-right"><i class="far fa-calendar-alt"></i> Valider
                            </button>
                        </div>
                    </div>
                </div>
                <!-- /.invoice -->
            </div><!-- /.col -->
        </div><!-- /.row -->
    </div><!-- /.container-fluid -->
</section>
<!-- /.content -->
<script src="js/fctValidePanier.js"></script>
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
