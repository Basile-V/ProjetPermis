<jsp:useBean id="learner" scope="request" type="com.epul.oeuvre.domains.LearnerEntity"/>
<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="header.jsp" %>
<body>
<%@include file="navigation.jsp" %>
<div class="jumbotron text-center">
    <H1> Modification d'un learner </H1>
</div>
<form method="put" action="../updateLearner/${learner.getIdLearner()}" onsubmit="return teste()">
    <div class="col-md-12 well well-md">
        <h1>Modifier Learner</h1>
        <div class="row">
            <div class="col-md-12" style="border:none; background-color:transparent; height :20px;">
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-3 control-label">surname du learner : </label>
            <div class="col-md-3">
                <label>
                    <INPUT type="text" name="txtsurname" value="${learner.surname}" id="surname" class="form-control" min="0",>
                </label>
            </div>

        </div>
        <div class="row">
            <div class="col-md-12" style="border:none; background-color:transparent; height :20px;">
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-3 control-label">forname du learner : </label>
            <div class="col-md-3">
                <label>
                    <INPUT type="text" name="txtforname" value="${learner.forname}" id="forname" class="form-control" min="0">
                </label>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12" style="border:none; background-color:transparent; height :20px;">
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-3 control-label">email du learner : </label>
            <div class="col-md-3">
                <label>
                    <INPUT type="text" name="txtemail" value="${learner.email}" id="email" class="form-control" min="0">
                </label>
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-3 control-label">mdp du learner : </label>
            <div class="col-md-3">
                <label>
                    <INPUT type="text" name="txtmdp" value="${learner.mdp}" id="mdp" class="form-control" min="0">
                </label>
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-3 control-label">role du learner : </label>
            <div class="col-md-3">
                <label>
                    <INPUT type="text" name="txtrole" value="${learner.role}" id="role" class="form-control" min="0">
                </label>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12" style="border:none; background-color:transparent; height :20px;">
            </div>
        </div>

        <div class="form-group">
            <button type="submit" class="btn btn-default btn-primary"><span class="glyphicon glyphicon-ok"></span>
                Enregistrer les modifications
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
<%@include file="../footer.jsp" %>
</body>
