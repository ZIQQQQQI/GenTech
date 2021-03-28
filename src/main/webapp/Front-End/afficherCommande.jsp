<%--
  Created by IntelliJ IDEA.
  User: 92930
  Date: 28-03-21
  Time: 09:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="metier.Produit" %>
<%@ page import="metier.Commande" %>
<%@ page import="metier.Lignecommande" %><%--
  Created by IntelliJ IDEA.
  User: liuyue
  Date: 2021/3/28
  Time: 09:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% /*
    String email=null;
    ArrayList<Produit> listPre=null;
    ArrayList<Produit> listPromo=(ArrayList<Produit>)request.getAttribute("listPromo");

    try{
        email=(String) session.getAttribute("email");
        listPre=(ArrayList<Produit>) request.getAttribute("listPre");
    }catch (Exception e){
    }
    ArrayList<Produit> list=(ArrayList<Produit>)request.getAttribute("listProduit");
*/%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>list de produit d'un commande</title>

    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
    <!-- Font Awesome -->
    <link rel="stylesheet" href=".\resources\plugins\fontawesome-free\css\all.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href=".\resources\dist\css\adminlte.min.css">
</head>
<body class="hold-transition sidebar-mini">
<div class="wrapper">
    <div class="container-fluid">
            </div>
        <a href="">
            <select>

                <option href="Servletcreaneau?idProduit" value ="c1">8:00-9:00</option>
                <option href="Servletcreaneau?idProduit" value ="c2">9:00-10:00</option>
                <option href="Servletcreaneau?idProduit" value="c3">10:00-11:00</option>
                <option href="Servletcreaneau?idProduit" value="c4">11:00-12:00</option>
                <option href="Servletcreaneau?idProduit" value="c5">12:00-13:00</option>
                <option href="Servletcreaneau?idProduit" value="c6">13:00-14:00</option>
                <option href="Servletcreaneau?idProduit" value="c7">14:00-15:00</option>
                <option href="Servletcreaneau?idProduit" value="c8">15:00-16:00</option>
                <option href="Servletcreaneau?idProduit" value="c9">16:00-17:00</option>
                <option href="SServletcreaneau?idProduit" value="c10">17:00-18:00</option>

            </select>
            <div style=" height:auto; float:left; display:inline"> <h2>Commande id: </h2></div>
            <div style="height:auto; float:left; display:inline"><p>Prix Total : , Economie: </p></div>
        </a>
        <div class="row">
                <%/*for (int i=0;i<3;i++
                       ) {
                Produit p=listPre.get(i);
                 */%>
            <div class="col-md-4">
                <!--prod1-->
                <div class="card">
                    <div class="card-header">
                        <a href="ServletProduitDetail?idProduit=<%//out.print( p.getCodeProduit());%>">
                            <h3 class="card-title"><%//out.println( p.getLibelleProduit());%></h3>
                        </a>
                        <%
                          /*  if(p.getBio()==1){
                                out.print("<i class=\"fas fa-leaf\" style=\"float: right;color: green;\"></i>");
                            }
                        */
                        %>
                    </div>
                    <div class="card-body">
                        <div align="left">
                            <tr><td><img  style="height:130px;width:100px;float:left;margin:5px;"  src="./images /<%out.println( p.getCodeProduit());%>.jpg" alt="imgProd1"></td>
                        </div>
                        <div>
                            <p style="float: left;"><%//out.print(p.getPrix());%> € </p>
                            <p style="float: left;"><%//out.print(p.getPrix()*(1-20%));%> € </p>
                            <a href="#"><i class="fas fa-plus-circle" style="float: right;"></i></a>
                        </div>
                </div><!-- FIN DE PROD1-->
            </div>
            </div>
%>