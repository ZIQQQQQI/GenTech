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
  String email=null;
  try{
    email=(String) session.getAttribute("email");
  }catch (Exception e){

  }


  String motCle=null;
  try {
    motCle=(String) request.getAttribute("motCle");
  }catch (Exception e){

  }

  Integer idCategorie=null;
  try {
    idCategorie=(Integer)request.getAttribute("idCategorie");
  }catch (Exception e){

  }
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
<%--    <% if (email!=null){--%>
<%--      ArrayList<Produit> listPre=(ArrayList<Produit>)session.getAttribute("listPre");--%>
<%--   %>--%>
<%--    <a href="">--%>
<%--      <h2>Mes préférences</h2>--%>
<%--    </a>--%>
<%--    <div class="row">--%>
<%--      <% for(int i=0;i<3;i++){--%>
<%--        Produit p=listPre.get(i);--%>
<%--      %>--%>
<%--      <div class="col-md-4">--%>
<%--        <!--prod1-->--%>
<%--        <div class="card">--%>
<%--          <div class="card-header">--%>
<%--            <a href="ServletProduitDetail?idProduit=<%p.getCodeProduit()%>">--%>
<%--              <h3 class="card-title">Test</h3>--%>
<%--            </a>--%>

<%--&lt;%&ndash;            &lt;%&ndash;%>--%>
<%--&lt;%&ndash;              if(p.getBio()==1){&ndash;%&gt;--%>
<%--&lt;%&ndash;                out.print("<i class=\"fas fa-leaf\" style=\"float: right;color: green;\"></i>");&ndash;%&gt;--%>
<%--&lt;%&ndash;              }&ndash;%&gt;--%>
<%--&lt;%&ndash;            %>&ndash;%&gt;--%>

<%--          </div>--%>
<%--          <div class="card-body">--%>
<%--            <div align="middle">--%>
<%--             <img    style="height:100px;width: 80px" src="./images/<%out.println( p.getCodeProduit());%>.jpg" alt="imgProd1">--%>

<%--            </div>--%>
<%--            <div>--%>
<%--              <p style="float: left;"><%out.print(p.getPrix());%>  € </p>--%>
<%--              <a href="#"><i class="fas fa-plus-circle" style="float: right;"></i></a>--%>
<%--            </div>--%>
<%--          </div>--%>
<%--        </div>--%>
<%--      </div><!-- FIN DE PROD1-->--%>
<%--    <%} //fin de for pre%>--%>

<%--    </div>--%>

<%--    <%--%>
<%--      }//fin if preference--%>
<%--    %>--%>




    <!-- tous les produits -->
    <a href="">
      <h2>Produit</h2>
      <%if(motCle==null){%>

      <div style="text-align: right; ">
        Tirer:
        <a href="ServletAccueil?ordre=asc&idCategorie=<%out.print(idCategorie); %>"><i class="fas fa-sort-amount-down-alt">Asc</i></a>
        <a href="ServletAccueil?ordre=desc&idCategorie=<%out.print(idCategorie); %>"><i class="fas fa-sort-amount-up">Desc</i></a>
      </div>


      <%}%>

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
    %></div>

      <%//fin de 1e if
  }//fin de 1e for
    if(total*3<list.size()){
      %>
    <div class="row">
    <%
      for(int i=total;i<list.size();i++){
        Produit p=list.get(i);
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
        }//fin for
    }//if ferme
%>
    </div>








</div>
</div>
</body>
</html>