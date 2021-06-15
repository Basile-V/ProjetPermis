<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@include file="header.jsp" %>
<body>
<%@include file="navigation.jsp" %>
<div class="jumbotron text-center">
    <h1>Listing des Missions</h1>
</div>

<div class="container">
    <a class="btn btn-secondary" href="${pageContext.request.contextPath}/authentification/accueil" role="button"><span
            class="glyphicon glyphicon-menu-left"></span> Retour accueil</a>
    <h2>Tableau des Missions</h2>
    <div class="container">
        <h3>Liste des Missions</h3>
        <table class="table table-hover">
            <tr>
                <th class="col-md-1">Id</th>
                <th class="col-md-2">wording</th>
                <th class="col-md-2">Actions</th>

            </tr>
            <c:forEach items="${missions}" var="item">
                <tr>
                    <td> ${item.getId()} </td>
                    <td> ${item.getWording()} </td>
                    <td><a class="btn btn-info" href="listerActions/${item.getId()}" role="button">
                        <span class="glyphicon glyphicon-pencil"></span>
                        Action
                    </a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
<%@include file="footer.jsp" %>
</body>
