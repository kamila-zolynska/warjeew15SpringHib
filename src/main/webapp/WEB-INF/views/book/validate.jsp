<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
  <c:forEach items="${validator}" var="validator">
    <h2>${validator.getPropertyPath()} : ${validator.getMessage()}</h2>
  </c:forEach>
</body>
</html>
