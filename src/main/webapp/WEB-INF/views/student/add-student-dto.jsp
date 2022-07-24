<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<form:form method="post" modelAttribute="studentDto">
  <form:input path="firstName" />
  <form:input path="lastName" />

<%--  ponizej do poprawy wg zadania 3--%>

  <form:input path="gender" />
  <form:input path="country" />
  <form:input path="notes" />

  <form:checkbox path="mailingList"/>

  <form:select path="programmingSkills">
    <form:option value="-" label="--Please Select--"/>
    <form:options items="${programmingSkills}"/>
  </form:select>

  <form:checkboxes path="hobbies" items="${hobbies}" itemLabel="hobbies"/>
</form:form>

<%--do edycji mozna uzyc hidden id--%>
</body>
</html>