<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@include file="header.jsp" %>
<body>
<%@include file="navigation.jsp" %>
<div class="jumbotron text-center">
    <h1>Listing des Apprenants</h1>
</div>

<div class="container">
    <a class="btn btn-secondary" href="../authentification/accueil" role="button"><span
            class="glyphicon glyphicon-menu-left"></span> Retour accueil</a>
    <h2>Tableau des Apprenants</h2>
    <div class="container">
        <h3>Liste des Apprenants</h3>
        <table class="table table-hover">
            <tr>
                <th class="col-md-1">Numéro</th>
                <th class="col-md-1">Nom de l'apprenant</th>
                <th class="col-md-1">Prénom de l'apprenant</th>
                <th class="col-md-1">email de l'apprenant</th>
                <th class="col-md-1"></th>
                <th class="col-md-1"></th>
            </tr>
            <c:forEach items="${mesLearners}" var="item">
                <tr>
                    <td> ${item.getIdLearner()}</td>
                    <td> ${item.surname} </td>
                    <td> ${item.forname} </td>
                    <td> ${item.email} </td>
                    <td><a class="btn btn-info" href="modifier/${item.getIdLearner()}" role="button"><span
                            class="glyphicon glyphicon-pencil"></span> Modifier</a>
                    </td>
                    <td>
                        <a class="btn btn-danger" href="supprimerLearner/${item.getIdLearner()}" role="button"><span
                            class="glyphicon glyphicon-remove-circle"></span> Supprimer</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
<%@include file="footer.jsp" %>
</body>

