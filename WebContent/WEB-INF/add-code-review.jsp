<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>When Is My Code Review?</title>

<!-- Bootstrap CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="css/style.css" rel="stylesheet">

<!-- Custom Fonts -->
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link rel="stylesheet" href="bower_components/jquery-ui/themes/base/jquery-ui.css">
<!-- <link rel="stylesheet"
	href="WebContent/bower_components/bower_components/bootstrap/dist/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="WebContent/bower_components/eonasdan-bootstrap-datetimepicker/build/css/bootstrap-datetimepicker.min.css" />
<script type="text/javascript"
	src="WebContent/bower_components/jquery/dist/jquery.min.js"></script>
	<script type="text/javascript"
	src="WebContent/bower_components/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="WebContent/bower_components/moment/min/moment.min.js"></script>
<script type="text/javascript"
	src="WebContent/bower_components/eonasdan-bootstrap-datetimepicker/build/js/bootstrap-datetimepicker.min.js"></script>-->
</head>
<body>

	<div id="wrapper">

		<!-- Navigation -->
		<nav class="navbar navbar-default navbar-static-top container-fluid"
			role="navigation" style="margin-bottom: 0">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="dashboard">When Is My Code Review?</a>
			</div>
			<!-- /.navbar-header -->

			<ul class="nav navbar-top-links navbar-right">
				<li class="dropdown"><a class="dropdown-toggle navlink"
					data-toggle="dropdown" href="#"> <i class="fa fa-gear fa-fw"></i>
						G�rer les code reviews <i class="fa fa-caret-down"></i>
				</a>
					<ul class="dropdown-menu dropdown-user">
						<li><a href="add-promotion"><i class="fa fa-users fa-fw"></i>
								Ajouter une promotion</a></li>
						<li><a href="add-member"><i class="fa fa-user fa-fw"></i>
								Ajouter un membre</a></li>
						<li><a href="add-code-review"><i
								class="fa fa-calendar fa-fw"></i> Cr�er un rendez-vous</a></li>
					</ul></li>
			</ul>
		</nav>

		<div id="page-wrapper" class="container-fluid">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">Ajouter une code review</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-10 col-lg-offset-1">
					<!-- /.panel -->
					<div class="panel panel-default">
						<div class="panel-body">
							<div class="row">
								<div class="col-xs-12">
									<form action="add-code-review" method="post" class="">
										<div class="form-group">
											<label for="name">Nom</label> <input type="text" name="name"
												class="input-lg form-control" id="name" placeholder="Nom">
										</div>
										<div class="form-group">
											<label for="description">Description</label> <input
												type="text" class="input-lg form-control" id="description" name="description"
												placeholder="Description">
										</div>
										<div class="form-group">
											<label for="date">Date</label> <input type='text' name="date"
												id='datetimepicker1' class="input-lg form-control"
												placeholder="Date de l'�v�nement" /> 
										</div>
										<script type="text/javascript">
										$( function() {
										    $( "#datepicker" ).datepicker();
										  } );
										</script>
										<div class="form-group">
											<label for="promotion">Promotion</label> <select name="promotion"
												class="input-lg form-control" id="promotion">
												<c:forEach items="${promotions}" var="promotion">
													<option>${promotion.name}</option>
												</c:forEach>
											</select>
										</div>

										<div class="text-right">
											<button type="submit" class="btn btn-lg btn-primary">Enregistrer</button>
										</div>
									</form>
								</div>
							</div>
							<!-- /.row -->
						</div>
						<!-- /.panel-body -->
					</div>
					<!-- /.panel -->
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
		</div>
		<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->
	<footer class="footer">
		<div class="container">
			<div class="row text-center">
				<img src="img/ebusiness.png" class="logo" alt=""> &bullet;
				2017
			</div>
		</div>
	</footer>

	<!-- jQuery -->
	<script src="js/jquery-3.1.1.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>
	
	<script src="bower_components/jquery-ui/jquery-ui.min.js"></script>

</body>

</html>