<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@include file="header.jsp" %>
<body>
<%@include file="navigation.jsp" %>
<div class="jumbotron text-center">
    <h1>Listing des Actions pour la mission ${mission.getWording()}</h1>
</div>

<div class="container">
    <a class="btn btn-secondary" href="${pageContext.request.contextPath}/authentification/accueil" role="button"><span
            class="glyphicon glyphicon-menu-left"></span> Retour accueil</a>
    <h2>Tableau des Actions</h2>
    <div class="container">
        <h3>Liste des Actions pour la mission ${mission.getWording()}</h3>
        <table class="table table-hover">
            <tr>
                <th class="col-md-1">id</th>
                <th class="col-md-1">fk_action</th>
                <th class="col-md-2">wording</th>
                <th class="col-md-2">scoreMinimum</th>
                <th class="col-md-2">Action Wording</th>
            </tr>
            <c:forEach items="${actions}" var="item">
                <tr>
                    <td> ${item.getIdAction()} </td>
                    <td> ${item.getFkAction()} </td>
                    <td> ${item.getWording()} </td>
                    <td> ${item.getScoreMinimum()} </td>
                    <td> ${item.getActionEntity().getWording()} </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>


<%@include file="footer.jsp" %>
</body>
