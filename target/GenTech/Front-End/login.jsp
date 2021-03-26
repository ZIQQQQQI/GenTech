<%@ page import="metier.Client" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: woshi
  Date: 2021/3/23
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Dashboard">
    <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
    <title>Login In</title>

    <!-- Favicons -->
    <link href=".\resources\img\favicon.png" rel="icon">
    <link href=".\resources\img\apple-touch-icon.png" rel="apple-touch-icon">

    <!-- Bootstrap core CSS -->
    <link href=".\resources\lib\bootstrap\css\bootstrap.min.css" rel="stylesheet">
    <!--external css-->
    <link href=".\resources\lib\font-awesome\css\font-awesome.css" rel="stylesheet" />
    <!-- Custom styles for this template -->
    <link href=".\resources\css\style.css" rel="stylesheet">
    <link href=".\resources\css\style-responsive.css" rel="stylesheet">

    <!-- =======================================================
      Template Name: Dashio
      Template URL: https://templatemag.com/dashio-bootstrap-admin-template/
      Author: TemplateMag.com
      License: https://templatemag.com/license/
    ======================================================= -->
</head>
<%


%>
<body>
<!-- **********************************************************************************************************************************************************
    MAIN CONTENT
    *********************************************************************************************************************************************************** -->
<div id="login-page">
    <div class="container">
        <form class="form-login" method="get" action="../ServletLogin">
            <h2 class="form-login-heading">Login in</h2>
            <div class="login-wrap">

                <input id="idemail" name="idEmail" type="text" class="form-control" placeholder="ID" autofocus>
                <span id="message"></span>
                <br>

                <input name="mdp" type="password" class="form-control" placeholder="Mot de passe">
                <label class="checkbox">
            <span class="pull-right">
            <a data-toggle="modal" href="login.html#myModal"> Oubliez votre mot de passe?</a>
            </span>
                </label>

                <input class="btn btn-theme btn-block" type="submit"><i class="fa fa-lock"></i> LOGIN</input>

                    <hr>
                <div class="registration">
                    Vous n'avez pas encore de compte?<br/>
                    <a class="" href="#">
                        Créer mon compte
                    </a>
                </div>
            </div>
            <!-- Modal -->
            <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModal" class="modal fade">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h4 class="modal-title">Oubliez votre mot de passe ?</h4>
                        </div>

                        <!--<div class="modal-body">
                            <p>Saisissez votre address électronique.</p>
                            <input type="text" name="email" placeholder="Email" autocomplete="off" class="form-control placeholder-no-fix">
                        </div>-->
                        <div class="modal-footer">
                            <button data-dismiss="modal" class="btn btn-default" type="button">Annuler</button>
                            <button class="btn btn-theme" type="button">Envoyer</button>
                        </div>
                    </div>
                </div>
            </div>
            <!-- modal -->
        </form>
    </div>
</div>
<!-- js placed at the end of the document so the pages load faster -->
<script type="text/JavaScript" src="../js/fctLogin.js"></script>
<script src="resources/lib/jquery/jquery.min.js"></script>
<script src="resources/lib/bootstrap/js/bootstrap.min.js"></script>
<!--BACKSTRETCH-->
<!-- You can use an image of whatever size. This script will stretch to fit in any screen size.-->
<script type="resources/text/javascript" src="lib/jquery.backstretch.min.js"></script>

</body>

</html>

