<%@ page import="java.util.ArrayList" %>
<%@ page import="metier.Produit" %><%--
  Created by IntelliJ IDEA.
  User: woshi
  Date: 2021/3/23
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  ArrayList<Produit> list=(ArrayList<Produit>)request.getAttribute("listProduit");

%>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>AfficherProduit</title>

  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
  <!-- Font Awesome -->
  <link rel="stylesheet" href=".\resources\plugins\fontawesome-free\css\all.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href=".\resources\dist\css\adminlte.min.css">

</head>
<body class="hold-transition sidebar-mini">
<div class="wrapper">
  <div class="container-fluid">
    <a href="">
      <h2>Produit</h2>
    </a>
    <%

      Integer total=list.size()/3;
      for(int i=0;i<total;i++){


    %>
    <div class="row">
      <%
        for(int j=0;j<3;j++){
          Produit p=list.get(j+i*3);
      %>
      <div class="col-md-4">
        <!--prod1-->
        <div class="card">
          <div class="card-header">
            <a href="ServletProduitDetail?idProduit=<%out.print( p.getCodeProduit());%>">
              <h3 class="card-title"><%out.println( p.getLibelleProduit());%></h3>
            </a>

            <%
              if(p.getBio()==1){
                out.print("<i class=\"fas fa-leaf\" style=\"float: right;color: green;\"></i>");
              }
            %>

          </div>
          <div class="card-body">
            <div align="middle">
              <img    style="height:100px;width: 80px" src="./images/<%out.println( p.getCodeProduit());%>.jpg" alt="imgProd1">
            </div>
            <div>
              <p style="float: left;"><%out.print(p.getPrix());%>  € </p>
              <a href="#"><i class="fas fa-plus-circle" style="float: right;"></i></a>
            </div>
          </div>
        </div>
      </div><!-- FIN DE PROD1-->

<%
      }//fin de 2e for
    %></div> <%//fin de 1e if
  }//fin de 1e for
%>


  <!-- 切换页面 -->
  <div class="card-footer clearfix">
    <ul class="pagination pagination-sm m-0 float-right">
      <li class="page-item"><a class="page-link" href="#">&laquo;</a></li>
      <li class="page-item"><a class="page-link" href="#">1</a></li>
      <li class="page-item"><a class="page-link" href="#">2</a></li>
      <li class="page-item"><a class="page-link" href="#">3</a></li>
      <li class="page-item"><a class="page-link" href="#">&raquo;</a></li>
    </ul>
  </div>
</div>
</div>
</body>
</html>