<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book</title>
</head>
<body>
  <form:form method="post" modelAttribute="book">
    <table>
      <tr>
        <td><form:label path="title"/>Tytul: </td>
        <td><form:input path="title"/></td>
      </tr>
      <tr>
        <td><form:label path="rating"/>Ocena od 1 do 10: </td>
        <td><form:input path="rating" type="number"/></td>
      </tr>
      <tr>
        <td><form:label path="description"/>Opis: </td>
        <td><form:textarea path="description"/></td>
      </tr>
      <tr>
        <td><form:label path="publisher">Wydawnictwo:  </form:label></td>
        <td><form:radiobuttons
                path="publisher" items="${publishers}" itemLabel="name" itemValue="id"/></td>
      </tr>
      <tr>
        <td><form:label path="authors">Autorzy:  </form:label></td>
        <td>
          <form:select path="authors">
            <form:option value="-" label="--Please Select--"/>
            <form:options items="${authors}" itemValue="id" itemLabel="lastName"/>
          </form:select>
        </td>
      </tr>
      <tr>
        <td>
          <input type="submit" value="Zapisz">
        </td>
      </tr>
    </table>
  </form:form>

</body>
</html>
