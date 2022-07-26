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
  <table>
    <tr>
      <td><form:label path="firstName">Wpisz swoje imie: </form:label></td>
      <td><form:input path="firstName" /></td>
    </tr>
    <tr>
      <td><form:label path="lastName">Wpisz swoje nazwisko: </form:label></td>
      <td><form:input path="lastName" /></td>
    </tr>
    <tr>
      <td><form:label path="gender">Plec:  </form:label></td>
      <td><form:radiobuttons path="gender" items="${genders}"  /></td>
    </tr>
    <tr>
      <td><form:label path="country">Panstwo:  </form:label></td>
      <td>
        <form:select path="country">
          <form:option value="-" label="--Please Select--"/>
          <form:options items="${countries}"/>
        </form:select>
      </td>
    </tr>
    <tr>
      <td><form:label path="notes">Notatki:  </form:label></td>
      <td><form:textarea path="notes" /></td>
    </tr>
    <tr>
      <td></td>
      <td><form:checkbox path="mailingList" label="Dolacz mnie do listy mailingowej"/></td>
    </tr>
    <tr>
      <td><form:label path="programmingSkills"/>Umiejetnosci: </td>
      <td>
        <form:select path="programmingSkills">
          <form:option value="-" label="--Please Select--"/>
          <form:options items="${programmingSkills}"/>
        </form:select>
      </td>
    </tr>
    <tr>
      <td><form:label path="hobbies"/>Hobby: </td>
      <td><form:checkboxes items="${hobbies}" path="hobbies"/></td>
    </tr>
    <tr>
      <td>
        <input type="submit" value="Save">
      </td>
    </tr>
  </table>
</form:form>
</body>
</html>