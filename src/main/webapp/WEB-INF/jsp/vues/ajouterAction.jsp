<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="header.jsp" %>
<body>
<%@include file="navigation.jsp" %>
<div class="jumbotron text-center">
    <H1> Ajout d'une action à la ${mission.getWording()} </H1>
</div>
<form method="post" action="../insererAction/${mission.getId()}" onsubmit="return teste()">
    <div class="col-md-12 well well-md">
        <h1>Ajouter d'une action à la ${mission.getWording()}</h1>
        <div class="row">
            <div class="col-md-12" style="border:none; background-color:transparent; height :20px;">
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-3 control-label">Id de l'action précédente : </label>
            <div class="col-md-3">
                <INPUT type="text" name="txtfkaction" value="" id="fkaction" class="form-control" min="0">
            </div>

        </div>
        <div class="row">
            <div class="col-md-12" style="border:none; background-color:transparent; height :20px;">
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-3 control-label">Wording de l'action : </label>
            <div class="col-md-3">
                <INPUT type="text" name="txtwording" value="" id="wording" class="form-control" min="0">
            </div>
        </div>
        <div class="row">
            <div class="col-md-12" style="border:none; background-color:transparent; height :20px;">
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-3 control-label">Score minimum de l'action </label>
            <div class="col-md-3">
                <INPUT type="text" name="txtscoreminimum" value="" id="scoreminimum" class="form-control" min="0">
            </div>
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-default btn-primary"><span class="glyphicon glyphicon-ok"></span>
                Ajouter
            </button>
            <button type="button" class="btn btn-default btn-primary"
                    onclick="{
                            window.location = '../../index.jsp';
                        }">
                <span class="glyphicon glyphicon-remove"></span> Annuler
            </button>
        </div>
    </div>
</form>
<%@include file="footer.jsp" %>
</body>

</html>