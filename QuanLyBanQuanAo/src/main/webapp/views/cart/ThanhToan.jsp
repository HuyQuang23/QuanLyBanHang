<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Student Form</title>
</head>
<body>
<h2>Thanh Toán</h2>

<div>${message}</div>

<form:form action="/cart/purchase" method="POST" modelAttribute="order">
  <table>
    <tr>
      <td>Nhập Địa Chỉ:</td>
      <td><form:input path="address"/></td>
    </tr>
  </table>
  <input class="btn btn-outline-danger" type="submit" value="Thanh Toán"/>
</form:form>
</body>
</html>
