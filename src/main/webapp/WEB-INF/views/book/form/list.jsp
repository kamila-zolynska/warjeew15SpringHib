<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<table>
  <tr>
    <th>description</th>
    <th>title</th>
    <th>publisher</th>
    <th>rating</th>
  </tr>
  <c:forEach items="${books}" var="book">
    <tr>
      <td>${book.description}</td>
      <td>${book.title}</td>
      <td>${book.publisher.name}</td>
      <td>${book.rating}</td>
<%--      <td>--%>
<%--        <a href="<c:url value="/person/delete/${person.id}"/>">usun</a>--%>
<%--        <a href="<c:url value="/person/update/${person.id}"/>">edytuj</a>--%>
<%--      </td>--%>
    </tr>
  </c:forEach>
</table>
</body>
</html>
