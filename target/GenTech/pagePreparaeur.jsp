<%--
  Created by IntelliJ IDEA.
  User: olivi
  Date: 2021/3/28
  Time: 16:54
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
    <title>Mon Compte</title>

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
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" data-widget="pushmenu" href="#" role="button"><i class="fas fa-bars"></i></a>
            </li>
        </ul>

        <!-- Right navbar links -->
        <ul class="navbar-nav ml-auto">


            <!-- Messages Dropdown Menu -->

            <li class="nav-item dropdown">
                <a class="nav-link" data-toggle="dropdown" href="#">
                    <i class="fas fa-store"></i>
                </a>
                <div class="dropdown-menu dropdown-menu-lg dropdown-menu-right">
                    <a href="#" class="dropdown-item">
                        <div class="media">
                            <div class="media-body">
                                <h3 class="dropdown-item-title">
                                    Nom magasin 1
                                    <span class="float-right text-sm text-danger"><i class="fas fa-star"></i></span> <!-- 左上角的星星 -->
                                </h3>
                            </div>
                        </div></a>
                    <a href="#" class="dropdown-item">
                        <div class="media">
                            <div class="media-body">
                                <h3 class="dropdown-item-title">
                                    Nom magasin 2
                                    <span class="float-right text-sm text-danger"><i class="fas fa-star"></i></span> <!-- 左上角的星星 -->
                                </h3>
                            </div>
                        </div></a>

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
        <a href="" class="brand-link">
            <img src=".\Front-End\resources\image\logo.PNG" alt="logo" class="brand-image img-circle elevation-3" style="opacity: .8"> <!--notre Logo-->
            <span class="brand-text font-weight-light">Magasin en ligne!</span>
        </a>

        <!-- Sidebar -->
        <div class="sidebar">
            <!-- Sidebar user panel (optional) -->
            <div class="user-panel mt-3 pb-3 mb-3 d-flex">
                <div class="info">
                    <a href="pageCommande.jsp" class="d-block">Nom Utilisateur</a><!-- 跳转login -->
                </div>
            </div>

            <!-- Sidebar Menu -->
            <nav class="mt-2">
                <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">

                    <li class="nav-header">Services</li>
                    <li class="nav-item">
                        <a href="#cmd"><i class="nav-icon far fa-circle text-danger"></i>
                            Saisir Commandes</a >
                    </li>
                    <li class="nav-item">
                        <a href="#Stockage"><i class="nav-icon far fa-circle text-info"></i>
                            Stockage</a>
                    </li>
                    <li class="nav-item">
                        <a href="#Creneau">
                            <i class="nav-icon far fa-circle text-warning"></i>
                            Créneau </a>
                    </li>

                </ul>
            </nav>
            <!-- /.sidebar-menu -->
        </div>
        <!-- /.sidebar -->
    </aside>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper iframe-mode" data-widget="iframe" data-loading-screen="750">

        <!--Afficher-->
        <div class="tab-content" >
            <jsp:include page="./Front-End/pageComptePrep.jsp"></jsp:include>

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

<script type="text/JavaScript" src="js/fctRayon.js"></script>
</body>
</html>
