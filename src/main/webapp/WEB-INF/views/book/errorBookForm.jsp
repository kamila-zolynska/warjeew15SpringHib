<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Book</title>
</head>
<body>
<form:form method="post" modelAttribute="book">
      <label><form:label path="title"/>Tytul: </label>
      <p><form:input path="title"/></p>
      <form:errors path="title" cssClass="error-class"></form:errors><br><br>

      <label><form:label path="description"/>Opis: </label>
      <p><form:textarea path="description"/></p>
      <form:errors path="description" cssClass="error-class"></form:errors><br><br>

        <input type="submit" value="Zapisz">

</form:form>

</body>
</html>
