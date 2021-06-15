<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@include file="header.jsp" %>
<body>
<%@include file="navigation.jsp" %>
<div class="jumbotron text-center">
    <h1>Listing des Inscription Actions</h1>
</div>

<div class="container">
    <a class="btn btn-secondary" href="/authentification/accueil" role="button"><span
            class="glyphicon glyphicon-menu-left"></span> Retour accueil</a>
    <h2>Tableau des Inscription Actions</h2>
    <div class="container">
        <h3>Liste des Inscription Actions</h3>
        <table class="table table-hover">
            <tr>
                <th class="col-md-1">id</th>
                <th class="col-md-2">fk_inscription</th>
                <th class="col-md-2">fk_action</th>
                <th class="col-md-2">sort</th>
                <th class="col-md-2">score</th>
                <th class="col-md-2">Inscription Date</th>

            </tr>
            <jsp:useBean id="mesInscriptionActions" scope="request" type="java.util.List"/>
            <c:forEach items="${mesInscriptionActions}" var="item">
                <tr>
                    <td> ${item.getId()}  </td>
                    <td> ${item.getFkInscription()}  </td>
                    <td> ${item.getFkAction()} </td>
                    <td> ${item.getSort()}  </td>
                    <td> ${item.getScore()}  </td>
                    <td> ${item.getInscriptionEntity().getDate()} </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
<%@include file="footer.jsp" %>
</body>

</html>