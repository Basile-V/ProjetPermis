<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<body>
<%@include file="navigation.jsp"%>
<div class="jumbotron text-center">
<H1> Ajout d'un adhérent </H1>
</div>
<form method="post" action="/learner/insererLearner" onsubmit="return teste()">
<div class="col-md-12 well well-md">
    <h1>Ajouter Apprenant</h1>
    <div class="row" >
        <div class="col-md-12" style ="border:none; background-color:transparent; height :20px;">
        </div>
    </div>
    <div class="form-group">
        <label class="col-md-3 control-label">Nom de l'apprenant : </label>
        <div class="col-md-3">
            <INPUT type="text" name="txtnom" value="" id="nom" class="form-control" min="0">
        </div>

    </div>
    <div class="row" >
        <div class="col-md-12" style ="border:none; background-color:transparent; height :20px;">
        </div>
    </div>

    <div class="form-group">
        <label class="col-md-3 control-label">Prénom de l'apprenant : </label>
        <div class="col-md-3">
            <INPUT type="text" name="txtprenom" value="" id="prenom" class="form-control" min="0">
        </div>
    </div>
    <div class="row" >
        <div class="col-md-12" style ="border:none; background-color:transparent; height :20px;">
        </div>
    </div>
    <div class="form-group">
        <label class="col-md-3 control-label">Email de l'apprenant : </label>
        <div class="col-md-3">
            <INPUT type="text" name="email" id="email" class="form-control" min="0">
        </div>
    </div>
    <div class="row" >
        <div class="col-md-12" style ="border:none; background-color:transparent; height :20px;">
        </div>
    </div>
    <div class="form-group">
        <label class="col-md-3 control-label">mot de passe de l'apprenant : </label>
        <div class="col-md-3">
            <INPUT type="password" name="mdp" id="pwd" class="form-control" min="0">
        </div>
    </div>
    <div class="row" >
        <div class="col-md-12" style ="border:none; background-color:transparent; height :20px;">
        </div>
    </div>
    <div class="form-group">
        <label class="col-md-3 control-label">Role de l'apprenant : </label>
        <div class="col-md-3">
            <INPUT type="text" name="txtrole" id="role" class="form-control" min="0">
        </div>
    </div>
    <div class="row" >
        <div class="col-md-12" style ="border:none; background-color:transparent; height :20px;">
        </div>
    </div>

    <div class="form-group">
        <button type="submit" class="btn btn-default btn-primary"><span class="glyphicon glyphicon-ok"></span>
            Ajouter
        </button>

        <button type="button" class="btn btn-default btn-primary"
                onclick="{
                            window.location = '../authentification/accueil';
                        }">
            <span class="glyphicon glyphicon-remove"></span> Annuler

        </button>
    </div>
</div>
</form>
<%@include file="footer.jsp"%>
</body>

</html>