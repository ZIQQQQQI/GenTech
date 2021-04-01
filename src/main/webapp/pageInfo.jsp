<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: silu
  Date: 31/03/2021
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Information</title>

    <!-- Google Font: Source Sans Pro -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="Front-End/resources/plugins/fontawesome-free/css/all.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="Front-End/resources/dist/css/adminlte.min.css">
</head>

<body class="hold-transition sidebar-mini" >
<div id="reussi"  >
    <section class="content-header">
        <div class="container-fluid">
            <div class="row mb-2">
                <div class="col-sm-6">
                    <h1 class="text-info">Notation: </h1>
                </div>
            </div>
        </div><!-- /.container-fluid -->
    </section>
    <!-- Main content -->
    <section class="content">
        <div class="error-page">
            <h2 class="headline text-info">Félicitation</h2>

            <div class="error-content">
                <h3><i class="far fa-lightbulb text-info"></i> Votre conmmande est enregistée.</h3>
            </div>
        </div>

        <!-- /.error-page -->
    </section>
    <div>
        <a href="ServletPanierDetail"><button class="btn btn-info">Retour</button></a>
    </div>
</div>

<div id="echoue">
    <section class="content-header">
        <div class="container-fluid">
            <div class="row mb-2">
                <div class="col-sm-6">
                    <h1 class="text-danger">Notation: </h1>
                </div>
            </div>
        </div><!-- /.container-fluid -->
    </section>
    <!-- Main content -->
    <section class="content">
        <div class="error-page">
            <h2 class="headline text-danger">Oops!</h2>

            <div class="error-content">
                <%ArrayList<String> note=(ArrayList<String>)request.getAttribute("note");
                for(String s:note){%>
                     <p><i class="fas fa-exclamation-triangle text-danger"></i> <%out.print(s);%></p>
                   <% }%>



            </div>
        </div>

        <!-- /.error-page -->
    </section>
    <div style="margin: 20px">
        <a href="ServletPanierDetail"><button  class="btn btn-danger">Retour</button></a>
    </div>
</div>

<script>
window.onload=verifier;
function verifier() {
    var ok=document.getElementById("reussi");
    var pasok=document.getElementById("echoue");
    if(<%out.print(note.size()==0);%>){
        pasok.style.display="none";
    }else{
        ok.style.display="none";
    }
}
</script>





<!-- jQuery -->
<script src="../../plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="../../plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script src="../../dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="../../dist/js/demo.js"></script>
</body>
</html>
