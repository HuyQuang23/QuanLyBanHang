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
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <script src="	https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<%@ page pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<div class="row">
    <div class="col-3"></div>
    <div class="col-6">
        <br>
        <h3 style="text-align: center; color: red">ADD Product</h3>
        <form action="/product/create" method="post" enctype="multipart/form-data">
            <label>Name</label>
            <input type="text" class="form-control" name="name" required>
            <br>

            <label>Price</label>
            <input type="text" class="form-control" name="price" required >
            <br>

            <label>Date</label>
            <input type="date" class="form-control" name="createDate" >
            <br>
            <label>Category</label>
            <select class="form-select" name="category">
                <c:forEach items="${categoryeis}" var="h">
                    <option value="${h.id}">${h.name}</option>
                </c:forEach>
            </select>
            <br>
            <label>Image</label>
            <input type="file" class="form-control" name="image" >
            <br>
            <hr>
            <button class="btn btn-outline-primary">Add</button>
        </form>
    </div>
    <div class="col-3"></div>
</div>
</body>
</html>
