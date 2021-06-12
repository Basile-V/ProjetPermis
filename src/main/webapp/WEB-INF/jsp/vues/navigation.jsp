<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/authentification/accueil">Permis Piste</a>
        </div>
        <ul class="nav navbar-nav">
            <li><a href="/authentification/accueil"> <span class="glyphicon glyphicon-home"></span> Accueil</a></li>
            <c:if test="${sessionScope.id == null }">
            <li class="dropdown">
                <a class="nav navbar-nav navbar-right"  href="/authentification/login">
                    <span class="glyphicon glyphicon-user"></span>
                    Se Connecter
                    <span class="caret"></span>
                </a>
                </c:if>
            </li>
            <c:if test="${sessionScope.id > 0  }">
                <li><a href="/mission/getMissions"> <span class=" glyphicon glyphicon-tasks"></span>Missions</a></li>
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <span class="glyphicon glyphicon-education"></span>
                        Apprenants
                        <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="/learner/getLearners"><span class="glyphicon glyphicon-th-list"></span> Lister les apprenants</a></li>
                        <li><a href="/learner/ajoutLearner"> <span class="glyphicon glyphicon-plus"></span>Ajouter Apprenant</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <span class="glyphicon glyphicon-tasks"></span>
                        Actions
                        <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="/action/getActions"> <span class="glyphicon glyphicon-th-list"></span>Lister Actions</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <span class="glyphicon glyphicon-user"></span>
                        Indicators
                        <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="/indicator/getIndicators"> <span class="glyphicon glyphicon-th-list"></span> Lister les
                            indicators </a></li>
                    </ul>
                </li>



                <li><a href="javascript:window.close();"><span class="glyphicon glyphicon-log-out"></span> Quitter</a></li>
            </c:if>
        </ul>
    </div>
</nav>
