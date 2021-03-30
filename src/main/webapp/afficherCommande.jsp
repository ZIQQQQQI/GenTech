<%--
  Created by IntelliJ IDEA.
  User: 92930
  Date: 28-03-21
  Time: 09:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="metier.*" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: liuyue
  Date: 2021/3/28
  Time: 09:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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


                <a  href=" " class="dropdown-item">
                    <div class="media">
                        <div class="media-body">


 <%
        Integer count=0;
        ArrayList<Ligneachat> listf=(ArrayList<Ligneachat> )request.getAttribute("listfuture");
        ArrayList<HashMap<Ligneachat, Entrepot>> f = (ArrayList<HashMap<Ligneachat, Entrepot>> )request.getAttribute("listmapfuture");
        for(HashMap<Ligneachat, Entrepot> r1:f){
            for (Ligneachat key1 : r1.keySet()){
    %>
            <a>future</a>
            <a>produitid: <% out.print(key1.getIdProduit()); %></a>
            <a> qteachat<%out.print(key1.getQteAchat());%></a>
            <a>date: <% out.print(r1.get(key1).getDateCdeArrive()); %></a>
            <a> reste<% out.print(key1.getQteReste());%>
                <a> restetotal <% out.print(count=count+key1.getQteReste().intValue());%><br></a>
                <% }}%>

                 </div>

                </div>


            </div>
            </div>
            </body>
