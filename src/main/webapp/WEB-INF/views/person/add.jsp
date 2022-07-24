<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--<form method="post">--%>
<%--&lt;%&ndash;    name identyczne z  nazwa zmiennych w klasie entity Student, zeby zaszlo bindowanie danych&ndash;%&gt;--%>
<%--    <input type="text" name="login">--%>
<%--    <input type="text" name="email">--%>
<%--    <input type="text" name="password">--%>
<%--    <input type="submit">--%>
<%--</form>--%>

<%--ponizszy kod umozliwia automatyczne wypelnienie pol (przydatne do modyfikacji)--%>
<form:form method="post"
           modelAttribute="person">
    <form:input path="login" />
    <form:input path="email" />
    <form:input path="password" />
    <input type="submit" value="Save">
</form:form>

</body>
</html>