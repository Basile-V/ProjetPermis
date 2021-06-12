<%--
  Created by IntelliJ IDEA.
  User: christian
  Date: 06/04/2018
  Time: 14:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@include file="vues/header.jsp" %>
<link rel="stylesheet"  type="text/css" href="<c:url value="/css/homePage.css"/>">
<body>
<%@include file="vues/navigation.jsp"%>
<h1>Acceuil</h1>
<div class="jumbotron text-center">
    <div>
        <h2>Bienvenue dans l'application Permis Piste !</h2>
        <p>Nous sommes le <%= (new java.util.Date()).toLocaleString()%></p>
        <p>Cette application vous permettra de suivre pas à pas votre apprentissage.</p>
        <p>En vous souhaitant une agréable visite !</p>

        <h2>Pour commencer, vous pouvez vous :</h2>
        <ol>
            <li>Enregistrer en tant qu'apprenant</li>
            <li>Inscrire à un jeu depuis la liste</li>
            <li>Accèder à la liste des missions pour valider des actions</li>
        </ol>
        <p>D'autres informations comme la liste des apprenants ou des actions sont disponibles en haut à droite</p>
    </div>
    <div>
        <img src="https://upload.wikimedia.org/wikipedia/fr/8/8d/Logo_polytech_lyon.png" alt="logo polytech">
    </div>

    <c:if test="${not empty message}">
        <div class="alert alert-danger fade in">
            <div class="col-md-3 ">
                <strong> Modification !</strong> <c:out value="${message}" />
            </div>
        </div>
    </c:if>

</div>
<%@include file="vues/footer.jsp"%>
</body>
</html>


