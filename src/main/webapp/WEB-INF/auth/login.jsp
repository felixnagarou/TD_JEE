<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 08/09/2023
  Time: 16:15
  To change this template use File | Settings | File Templates.
--%>
<jsp:useBean id="mode" type="java.lang.String" scope="request" />
<jsp:useBean id="user" type ="com.example.td_jee.models.UserDTO" scope = "request"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@ include file="/WEB-INF/bootstrapimports.html" %>
<head>
    <title>Authentification</title>
</head>
<body>
<main class="container">

    <form action="" method="post">

        <div>
            <label for="username">Username : </label>
            <input type="text" name = "username" id="username" value="<%user.getUsername(); %>">
        </div>
        <div>
            <label for="mail">Mail : </label>
            <input type="text" name = "mail" id="mail" value="<%user.getMail(); %>">
        </div>
        <div>
            <label for="password">Password : </label>
            <input type="text" name="password" id="password" value="<%user.getPassword();%>">
        </div>
        <hr>
        <a href="<%=mode.equals("signIn") ? "signUp" : "signIn"%>"  class = "btn btn-outline-info">Switch to<%=!mode.equals("signIn") ? "signIn" : "Register" %> </a>
        <button>Submit</button>
    </form>

</main>

</body>
</html>
