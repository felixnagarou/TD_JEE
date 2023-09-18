<%@ page import="com.example.td_jee.models.Book" %>
<%@ page import="com.example.td_jee.data.FakeDB" %><%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 08/09/2023
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<jsp:useBean id="mode" type="java.lang.String" scope="request" />
<jsp:useBean id="bookList" type="java.util.ArrayList<com.example.td_jee.data.FakeDB>" scope="request" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My Books</title>
</head>
<body>
<main class = "container">
    <h2> -My Books- </h2>
    <hr>
    <%if (!bookList.isEmpty()) { %>
        <table>
            <thead>
            <th>Title</th>
            <th>Author</th>
            <th>PublicationType</th>
            <th>PublicationDate</th>
            <th>Editor</th>
            <th>ISBN</th>
            </thead>
            <tbody>
            <tr>
                <%if (mode.equals("showAll")) { %>
                    <%for (Book b : FakeDB.bookList) {%>
                    <td><%= b.getTitle()%></td>
                    <td><%= b.getAuthor()%></td>
                    <td><%= b.getPublicationDate()%></td>
                    <td><%= b.getPublicationDate()%></td>
                    <td><%= b.getEditor()%></td>
                    <td><%= b.getIsbn()%></td>
                </tr>
                <%}%>
            <%}%>
        </tbody>
        </table>
    <%}%>
</main>

</body>
</html>
