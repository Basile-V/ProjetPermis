<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@include file="header.jsp" %>
<body>
<%@include file="navigation.jsp" %>
<div class="jumbotron text-center">
    <h1>Listing des Inscriptions</h1>
</div>

<div class="container">
    <a class="btn btn-secondary" href="${pageContext.request.contextPath}/authentification/accueil" role="button"><span
            class="glyphicon glyphicon-menu-left"></span> Retour accueil</a>
    <h2>Tableau des Inscriptions</h2>
    <div class="container">
        <h3>Liste des Inscriptions</h3>
        <table class="table table-hover">
            <tr>
                <th class="col-md-1">Id</th>
                <th class="col-md-2">fk_learner</th>
                <th class="col-md-2">fk_mission</th>
                <th class="col-md-2">date</th>
            </tr>
            <c:forEach items="${mesInscriptions}" var="item">
                <tr>
                    <td> ${item.getId()} </td>
                    <td> ${item.getFkLearner()} </td>
                    <td> ${item.getFkMission()} </td>
                    <td> ${item.getDate()} </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
<%@include file="footer.jsp" %>
</body>
