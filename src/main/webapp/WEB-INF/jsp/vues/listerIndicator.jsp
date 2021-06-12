<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@include file="header.jsp" %>
<body>
<%@include file="navigation.jsp" %>
<div class="jumbotron text-center">
    <h1>Listing des indicators</h1>
</div>

<div class="container">
    <a class="btn btn-secondary" href="/authentification/accueil" role="button"><span
            class="glyphicon glyphicon-menu-left"></span> Retour accueil</a>
    <h2>Tableau des Indicators</h2>
    <div class="container">
        <h3>Liste des Indicators</h3>
        <table class="table table-hover">
            <tr>
                <th class="col-md-1">id</th>
                <th class="col-md-2">fk_action</th>
                <th class="col-md-2">wording</th>
                <th class="col-md-2">value_if_check</th>
                <th class="col-md-2">value_if_un_check</th>

            </tr>
            <c:forEach items="${mesIndicators}" var="item">
                <tr>
                    <td> ${item.getId()} </td>
                    <td> ${item.getFkAction()} </td>
                    <td> ${item.getWording()} </td>
                    <td> ${item.getValueIfCheck()} </td>
                    <td> ${item.getValueIfUnCheck()} </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
<%@include file="footer.jsp" %>
</body>

</html>