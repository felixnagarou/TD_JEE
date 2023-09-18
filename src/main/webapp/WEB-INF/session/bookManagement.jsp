<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 08/09/2023
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<jsp:useBean id="errors" type="java.util.List<java.lang.String>" scope="request"/>
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
        <div><label for="title"></label><input type="text" name="title" id="title" required>Title</div>
        <div><label for="author"></label><input type="text" name = "author" id ="author" required>Author</div>
        <div><label for="publicationType"></label><input type="text" name="publicationType" id="publicationType" required>Publication Type (essay, novel, article...)</div>
        <div><label for="publicationDate"></label><input type="text" name="publicationDate" id="publicationDate" required> Date of publication</div>
        <div><label for="editor"></label><input type="text" name="editor" id="editor" required>Name of editor</div>
        <div><label for="isbn"></label><input type="text" name="isbn" id="isbn" required>ISBN (Should be formatted likewise : xx-xxxx-xxxx-xx)</div>
    </form>
    <a href=""></a>
    <button >Submit</button>
</main>
</body>
</html>
