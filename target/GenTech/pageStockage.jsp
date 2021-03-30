<%--
  Created by IntelliJ IDEA.
  User: olivi
  Date: 2021/3/28
  Time: 23:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Stockage</title>

    <!-- Google Font: Source Sans Pro -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="Front-End/resources/plugins/fontawesome-free/css/all.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="Front-End/resources/dist/css/adminlte.min.css">
</head>
<body>
<section class="content-header">
    <div class="container-fluid">
        <div class="row mb-2">
            <div class="col-sm-6">
                <h1>Stockage</h1>
            </div>
        </div>
    </div><!-- /.container-fluid -->
</section>

<section class="content">
    <div class="row">
        <div class="col-md-12">
            <div class="card">
                <div class="card-header p-2">
                    <ul class="nav nav-pills">
                        <!--循环categories-->
                        <li class="nav-item"><a class="nav-link active" href="#cat1" data-toggle="tab">Categorie1</a></li>
                        <li class="nav-item"><a class="nav-link" href="#cat2" data-toggle="tab">Categorie2</a></li>
                        <li class="nav-item"><a class="nav-link" href="#cat3" data-toggle="tab">Categorie3</a></li>
                    </ul>
                </div><!-- /.card-header -->
                <div class="card-body">
                    <div class="tab-content">

                        <div class="active tab-pane" id="cat1">
                         <!-- Post -->
                            <div class="post">
                                <table class="table">
                                    <thead>
                                    <tr>
                                        <th>nomProduit</th>
                                        <th>quantite</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td>nomProd1</td>
                                        <td>1000</td>
                                    </tr>

                                    </tbody>
                                </table>

                            </div>
                            <!-- /.post -->
                        </div>


                        <!-- /.tab-pane -->
                        <div class="tab-pane" id="cat2">
                            <!-- The timeline -->
                            <div class="post">

                            </div>
                            <!-- /.post -->


                            <!-- Post -->
                            <div class="post">
                                <table class="table">
                                    <thead>
                                    <tr>
                                        <th>nomProduit</th>
                                        <th>quantite</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td>nomProd2</td>
                                        <td>500</td>
                                    </tr>

                                    </tbody>
                                </table>

                            </div>
                        </div>
                        <!-- /.tab-pane -->



                        <div class="tab-pane" id="cat3">
                            <div class="post">

                            </div>
                            <!-- /.post -->


                            <!-- Post -->
                            <div class="post">
                                <table class="table">
                                    <thead>
                                    <tr>
                                        <th>nomProduit</th>
                                        <th>quantite</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td>nomProd3</td>
                                        <td>600</td>
                                    </tr>

                                    </tbody>
                                </table>

                            </div>
                        </div>
                        <!-- /.tab-pane -->
                    </div>
                    <!-- /.tab-content -->
                </div><!-- /.card-body -->
            </div>
            <!-- /.card -->
        </div>
    </div>
</section>



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
