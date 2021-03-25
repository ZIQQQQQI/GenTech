<%@ page import="metier.Produit" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="metier.Rayon" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="metier.Magasin" %><%--
  Created by IntelliJ IDEA.
  User: woshi
  Date: 2021/3/23
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%

%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Magasin en ligne</title>

    <!-- Google Font: Source Sans Pro -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="./Front-End/resources/plugins/fontawesome-free/css/all.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="./Front-End/resources/dist/css/adminlte.min.css">
    <!-- overlayScrollbars -->
    <link rel="stylesheet" href="./Front-End/resources/plugins/overlayScrollbars/css/OverlayScrollbars.min.css">
</head>


<body class="hold-transition sidebar-mini layout-fixed" data-panel-auto-height-mode="height">
<div class="wrapper">

    <!-- Navbar -->
    <nav class="main-header navbar navbar-expand navbar-white navbar-light">
        <!-- Left navbar links -->
        <ul class="navbar-nav ml-auto" style="height: 100px" >
            <li class="nav-item">
                <a class="nav-link" data-widget="pushmenu" href="#" role="button"><i class="fas fa-bars"></i></a>
            </li>




        </ul>

        <!-- Right navbar links -->
        <ul class="navbar-nav ml-auto">
            <!-- Navbar Search -->
            <li class="nav-item">
                <a class="nav-link" data-widget="navbar-search" href="#" role="button">
                    <i class="fas fa-search"></i>
                </a>
                <div class="navbar-search-block">
                    <form class="form-inline" method="get" action="ServletAccueil">
                        <div class="input-group input-group-sm">
                            <input id="keyword" name="keyword" class="form-control form-control-navbar" type="search" placeholder="Search" aria-label="Search">
                            <div class="input-group-append">
                                <button class="btn btn-navbar" type="submit">
                                    <i class="fas fa-search"></i>
                                </button>
                                <button class="btn btn-navbar" type="button" data-widget="navbar-search">
                                    <i class="fas fa-times"></i>
                                </button>
                            </div>
                        </div>
                    </form>
                    <div id="zoneaff" style="display: none;width: 100%;height: 193px; border-width: 1px;border-style: solid;border-color: #7F9DB9;margin-top: 1px;padding: 2px;overflow:auto;z-index:9999;">
                    </div>
                </div>
            </li>

            <!-- Messages Dropdown Menu -->

            <!--Panier-->
            <li class="nav-item dropdown">
                <a class="nav-link" data-toggle="dropdown" href="#">
                    <i class="fas fa-shopping-basket"></i>
                    <span class="badge badge-danger navbar-badge">0</span>
                </a>
                <div class="dropdown-menu dropdown-menu-lg dropdown-menu-right">
                    <a href="#" class="dropdown-item">
                        <!-- Premier Produit -->
                        <div class="media">
                            <!-- image de Produi -->
                            <img src="" alt="User Avatar" class="img-size-50 mr-3 img-circle">
                            <div class="media-body">
                                <h3 class="dropdown-item-title">
                                    Nom Produit
                                    <span class="float-right text-sm text-danger"><i class="fas fa-star"></i></span> <!-- 左上角的星星 -->
                                </h3>
                            </div>
                        </div></a>

                    <div class="dropdown-divider"></div>
                    <a href="#" class="dropdown-item dropdown-footer">Valider mon panier</a>
                </div>
            </li>

            <li class="nav-item dropdown">
                <a class="nav-link" data-toggle="dropdown" href="#">
                    <i class="fas fa-store"></i>
                </a>
                <div class="dropdown-menu dropdown-menu-lg dropdown-menu-right">

                    <%
                     ArrayList<Magasin> listM=(ArrayList<Magasin>)request.getAttribute("listMagasin");
                        for (Magasin m:listM
                             ) {
                            %>
                        <a href="#" class="dropdown-item">
                        <div class="media">
                            <div class="media-body">
                                <h3 class="dropdown-item-title">
                                    <%out.print(m.getLibelleMagasin());%>
                                    <span class="float-right text-sm text-danger"><i class="fas fa-star"></i></span> <!-- 左上角的星星 -->
                                </h3>
                            </div>
                        </div></a>

                            <%
                        }


                    %>



                </div>
            </li>


            <li class="nav-item">
                <a class="nav-link" data-widget="fullscreen" href="#" role="button">
                    <i class="fas fa-expand-arrows-alt"></i>
                </a>
            </li>

            <li class="nav-item">
                <a class="nav-link" data-widget="control-sidebar" data-slide="true" href="#" role="button">
                    <i class="fas fa-th-large"></i>
                </a>
            </li>

        </ul>
    </nav>
    <!-- /.navbar -->



    <!-- Main Sidebar Container -->
    <aside class="main-sidebar sidebar-dark-primary elevation-4">
        <!-- Brand Logo -->
        <a href="ServletAccueil" class="brand-link">
            <img src=".\Front-End\resources\image\logo.PNG" alt="logo" class="brand-image img-circle elevation-3" style="opacity: .8"> <!--notre Logo-->
            <span class="brand-text font-weight-light">Magasin en ligne!</span>
        </a>

        <!-- Sidebar -->
        <div class="sidebar">
            <!-- Sidebar user panel (optional) -->
            <div class="user-panel mt-3 pb-3 mb-3 d-flex">
                <div class="info">
                    <a href=".\Front-End\login.jsp" class="d-block">Log in</a><!-- 跳转login -->
                </div>
            </div>

            <!-- Sidebar Menu -->
            <nav class="mt-2">
                <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
                    <!-- Add icons to the links using the .nav-icon class
                         with font-awesome or any other icon font library -->

                    <li>
                        <a href="ServletAccueil">
                        <i class="fas fa-cookie-bite"></i>
                        Tous les produit
                    </a>
                    </li>
                    <br>
                    <% HashMap<Rayon,ArrayList<Rayon>> list=(HashMap<Rayon,ArrayList<Rayon>>)request.getAttribute("listRayonandcategories");
                        for(Rayon r:list.keySet()){
                    %>
                    <li class="nav-item">
                        <a href=" " class="nav-link">
                        <i class="nav-icon fas fa-chart-pie"></i>
                        <p> <%out.print(r.getNomCate());%>
                            <i class="right fas fa-angle-left"></i>
                        </p >
                    </a>
                        <%for(Rayon cat:list.get(r)){ %>
                    <ul class="nav nav-treeview">
                        <li class="nav-item">
                            <a href="ServletAccueil?idCategorie=<%out.print(cat.getNumCate());%>&math=<%out.print(Math.random());%>" >
                            <i class="far fa-circle nav-icon"></i>

                            <% out.print(cat.getNomCate());%>
                        </a>
                        </li>
                    </ul>
                        <%  }%>
                    </li>
                    <%} %>






                    <li class="nav-header">LABELS</li>
                    <li class="nav-item">
                        <a href="#" class="nav-link">
                        <i class="nav-icon far fa-circle text-danger"></i>
                        <p class="text">Important</p >
                    </a>
                    </li>
                    <li class="nav-item">
                        <a href="#" class="nav-link">
                        <i class="nav-icon far fa-circle text-warning"></i>
                        <p>Warning</p >
                    </a>
                    </li>
                    <li class="nav-item">
                        <a href="#" class="nav-link">
                        <i class="nav-icon far fa-circle text-info"></i>
                        <p>Informational</p >
                    </a>
                    </li>
                </ul>
            </nav>
            <!-- /.sidebar-menu -->
        </div>
        <!-- /.sidebar -->
    </aside>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper iframe-mode" data-widget="iframe" data-loading-screen="750">
        <div class="nav navbar navbar-expand navbar-white navbar-light border-bottom p-0">
            <div align="right">
                <a class="nav-link bg-light" href="#" data-widget="iframe-fullscreen"><i class="fas fa-expand" ></i></a></div>
        </div>

        <!--Afficher les produit-->
        <div class="tab-content" >

            <!--<iframe src="./Front-End/pageProd.jsp" scrolling="yes" frameborder="0" id="Prod"></iframe> -->
            <jsp:include page="./Front-End/afficherProduit.jsp" flush="true"></jsp:include>
        </div>
    </div>
    <!-- /.content-wrapper -->
    <footer class="main-footer">

    </footer>

    <!-- Control Sidebar -->
    <aside class="control-sidebar control-sidebar-dark">
        <!-- Control sidebar content goes here -->
    </aside>
    <!-- /.control-sidebar -->
</div>
<!-- ./wrapper -->

<!-- jQuery -->
<script src=".\Front-End\resources\plugins\jquery\jquery.min.js"></script>
<script type="text/JavaScript" src="js/fctxml.js"></script>
<!-- jQuery UI 1.11.4 -->
<script src="Front-End/resources/plugins/jquery-ui/jquery-ui.min.js"></script>
<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
<script>
    $.widget.bridge('uibutton', $.ui.button)
</script>
<!-- Bootstrap 4 -->
<script src="Front-End/resources/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- overlayScrollbars -->
<script src="Front-End/resources/plugins/overlayScrollbars/js/jquery.overlayScrollbars.min.js"></script>
<!-- AdminLTE App -->
<script src="Front-End/resources/dist/js/adminlte.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="Front-End/resources/dist/js/demo.js"></script>
</body>
</html>
