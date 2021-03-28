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
<%@ page import="metier.Lignecommande" %>
<%@ page import="metier.Creneau" %><%--
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
        <a href="">
            <select>
               <% ArrayList<Creneau> listC=(ArrayList<Creneau>)request.getAttribute("listProduit");%>
                <option href="Servletcreaneau?idCreneau=<%out.print(listC.getHeureRetrait());%" value ="c1">8:00-9:00</option>


            </select>

            <div style=" height:auto; float:left; display:inline"> <h2>Commande id: </h2></div>
            <div style="height:auto; float:left; display:inline"><p>Prix Total : , Economie: </p></div>
        </a>

            </div>
   </div>
</body>