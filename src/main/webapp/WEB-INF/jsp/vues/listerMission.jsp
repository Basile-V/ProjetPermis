<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@include file="header.jsp" %>
<body>
<%@include file="navigation.jsp" %>
<div class="jumbotron text-center">
    <h1>Listing des Missions</h1>
</div>

<div class="container">
    <a class="btn btn-secondary" href="../authentification/accueil" role="button"><span
            class="glyphicon glyphicon-menu-left"></span> Retour accueil</a>
    <h2>Tableau des Missions</h2>
    <div class="container">
        <h3>Liste des Missions</h3>
        <table class="table table-hover">
            <tr>
                <th class="col-md-1">Id</th>
                <th class="col-md-2">wording</th>

            </tr>
            <c:forEach items="${mesMissions}" var="item">
                <tr>
                    <td> ${item.getId()} </td>
                    <td> ${item.getWording()} </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
<%@include file="footer.jsp" %>
</body>
