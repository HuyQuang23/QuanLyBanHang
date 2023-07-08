<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 6/5/2023
  Time: 11:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<%@ page pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
${product.id}<br>
${product.name}<br>
<img src="data:image/jpg;base64,${product.getIMGByte()}" width="60" height="60"/>
${product.price}<br>
${product.createDate}<br>
${product.category.name}<br>
</body>
</html>
