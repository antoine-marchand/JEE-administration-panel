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
						Gérer les code reviews <i class="fa fa-caret-down"></i>
				</a>
					<ul class="dropdown-menu dropdown-user">
						<li><a href="add-promotion"><i class="fa fa-users fa-fw"></i>
								Ajouter une promotion</a></li>
						<li><a href="add-member"><i class="fa fa-user fa-fw"></i>
								Ajouter un membre</a></li>
						<li><a href="add-code-review"><i
								class="fa fa-calendar fa-fw"></i> Créer un rendez-vous</a></li>
					</ul></li>
			</ul>
		</nav>

		<div id="page-wrapper" class="container-fluid">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">Panneau d'administration</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-4 col-md-4">
					<div class="panel panel-primary">
						<div class="panel-heading">
							<div class="row">
								<div class="col-xs-3">
									<i class="fa fa-users fa-5x"></i>
								</div>
								<div class="col-xs-9 text-right">
									<div class="huge">${numberPromotions}</div>
									<div class="huge-label">Promotions</div>
								</div>
							</div>
						</div>
						<a href="add-promotion">
							<div class="panel-footer">
								<span class="pull-left">Ajouter une promotion</span> <span
									class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
								<div class="clearfix"></div>
							</div>
						</a>
					</div>
				</div>
				<div class="col-lg-4 col-md-4">
					<div class="panel panel-green">
						<div class="panel-heading">
							<div class="row">
								<div class="col-xs-3">
									<i class="fa fa-user fa-5x"></i>
								</div>
								<div class="col-xs-9 text-right">
									<div class="huge">${numberMembers}</div>
									<div class="huge-label">Membres inscrits</div>
								</div>
							</div>
						</div>
						<a href="add-member">
							<div class="panel-footer">
								<span class="pull-left">Ajouter un membre</span> <span
									class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
								<div class="clearfix"></div>
							</div>
						</a>
					</div>
				</div>
				<div class="col-lg-4 col-md-4">
					<div class="panel panel-yellow">
						<div class="panel-heading">
							<div class="row">
								<div class="col-xs-3">
									<i class="fa fa-calendar fa-5x"></i>
								</div>
								<div class="col-xs-9 text-right">
									<div class="huge">${numberCodeReviews}</div>
									<div class="huge-label">Code reviews programmées</div>
								</div>
							</div>
						</div>
						<a href="add-code-review">
							<div class="panel-footer">
								<span class="pull-left">Ajouter une code review</span> <span
									class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
								<div class="clearfix"></div>
							</div>
						</a>
					</div>
				</div>
			</div>
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-8">
					<!-- /.panel -->
					<div class="panel panel-default">
						<div class="panel-heading">
							<i class="fa fa-user fa-fw"></i> Gestion des membres
						</div>
						<!-- /.panel-heading -->
						<div class="panel-body">
							<div class="row">
								<div class="col-lg-12">
									<div class="table-responsive">
										<table class="table table-hover table-striped">
											<thead>
												<tr>
													<th>Nom</th>
													<th>Email</th>
													<th>Birthdate</th>
													<th class="text-right">Action</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${members}" var="member">
													<tr>
														<td>${member.name}</td>
														<td>${member.email}</td>
														<td>${member.birthdate}</td>
														<td class="text-right">
															<form action="edit-member">
																<input type="hidden" name="memberId"
																	value="${member.id}" /><input type="submit"
																	class="btn btn-sm btn-warning" value="Modifier" />
															</form>
															<form action="delete-member">
																<input type="hidden" name="memberId"
																	value="${member.id}" /><input type="submit"
																	class="btn btn-sm btn-warning" value="Supprimer" />
															</form>
														</td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
										<div class="text-center">
											<ul class="pagination">
												<li><a href="#">1</a></li>
												<li><a href="#">2</a></li>
												<li><a href="#">3</a></li>
											</ul>
										</div>
									</div>
									<!-- /.table-responsive -->
								</div>
							</div>
							<!-- /.row -->
						</div>
						<!-- /.panel-body -->
					</div>
					<!-- /.panel -->
				</div>
				<!-- /.col-lg-8 -->
				<div class="col-lg-4">
					<div class="panel panel-default">
						<div class="panel-heading">
							<i class="fa fa-calendar fa-fw"></i> Codes reviews programmées
						</div>
						<div class="panel-body">
							<table class="table table-striped">

								<c:forEach items="${codeReviews}" var="codeReview">
									<tr>
										<td>${codeReview.name}</td>
										<td>${codeReview.description}</td>
										<td class="text-right"><span class="text-muted small">${codeReview.datetime}</span></td>
									</tr>
								</c:forEach>

								<tr>
									<td>Code review 1</td>
									<td>Date sample</td>
									<td class="text-right"><span class="text-muted small">24/02/2017</span></td>
								</tr>
							</table>
							<a href="add-code-review" class="btn btn-default btn-block">Programmer
								une code review</a>
						</div>
						<!-- /.panel-body -->
					</div>
					<!-- /.panel -->

					<div class="panel panel-default">
						<div class="panel-heading">
							<i class="fa fa-users fa-fw"></i> Gestion des promotions
						</div>
						<!-- /.panel-heading -->
						<div class="panel-body">
							<div class="list-group">

								<c:forEach items="${promotions}" var="promotion"
									varStatus="loop">
									<a href="#" class="list-group-item"> <i
										class="fa fa-users fa-fw"></i> ${promotion.name}<span
										class="pull-right text-muted small"><em>${numberMembersPromotion[loop.index]}
												membres</em> </span>
									</a>
								</c:forEach>

								<a href="#" class="list-group-item"> <i
									class="fa fa-users fa-fw"></i> Promo Février <span
									class="pull-right text-muted small"><em>8 membres</em> </span>
								</a>
							</div>
							<!-- /.list-group -->
							<a href="add-promotion" class="btn btn-default btn-block">Créer
								une nouvelle promotion</a>
						</div>
						<!-- /.panel-body -->
					</div>
					<!-- /.panel -->
				</div>
				<!-- /.col-lg-4 -->
			</div>
			<!-- /.row -->
		</div>
		<!-- /#page-wrapper -->

	</div>






	<!-- Modal -->
	<div class="modal fade" id="modalSupprimer" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Supprimer un
						membre</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">Voulez vous vraiment supprimer ce
					membre</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Oui</button>
					<button type="button" class="btn btn-primary">Non</button>
				</div>
			</div>
		</div>
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

</body>

</html>
