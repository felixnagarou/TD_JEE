<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 08/09/2023
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<jsp:useBean id="mode" type="java.lang.String" scope = "request" />
<jsp:useBean id="book" type="com.example.td_jee.models.BookDTO" scope = "request" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Manage books</title>
</head>
<body>
<main>
    <h1>Add a book</h1>
    <hr>
    <form action="" method="post">
        <div><label for="title"></label><input type="text" name="title" id="title" required></div>
        <div><label for="author"></label><input type="text" name = "author" id ="author" required></div>
        <div><label for="publicationType"></label><input type="text" name="publicationType" id="publicationType" required></div>
        <div><label for="publicationDate"></label><input type="text" name="publicationDate" id="publicationDate" required></div>
        <div><label for="editor"></label><input type="text" name="editor" id="editor" required></div>
        <div><label for="isbn"></label><input type="text" name="isbn" id="isbn" required></div>
    </form>
</main>
</body>
</html>
