<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--<form method="post">--%>
<%--    name identyczne z  nazwa zmiennych w klasie entity Student, zeby zaszlo bindowanie danych--%>
<%--    <input type="text" name="firstName">--%>
<%--    <input type="text" name="lastName">--%>
<%--    <input type="submit">--%>
<%--</form>--%>

<%--ponizszy kod umozliwia automatyczne wypelnienie pol (przydatne do modyfikacji)--%>
<form:form method="post"
           modelAttribute="student">
    <form:input path="firstName" />
    <form:input path="lastName" />
    <input type="submit" value="Save">
</form:form>

</body>
</html>
