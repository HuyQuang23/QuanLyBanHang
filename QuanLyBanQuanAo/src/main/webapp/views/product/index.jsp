<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 6/2/2023
  Time: 10:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <script src="	https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<style>
    * {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
        font-family: sans-serif;
    }

    section {
        width: 100%;
        height: 20vh;
    }

    section header {
        display: flex;
        align-items: center;
        justify-content: space-around;
        box-shadow: 0 0 20px rgba(0, 0, 0, 0.3);
    }

    section header .logo {
        font-size: 30px;
        color: black;
        text-decoration: none;
        font-weight: bold;
        margin: 15px 0;
    }

    section header .logo span {
        color: #f9004d;
    }

    section header ul {
        list-style: none;
    }

    section header ul li {
        display: inline-block;
        margin: 5px 5px;
        padding: 5px 20px;
    }

    section header ul li a {
        color: black;
        text-decoration: none;
    }

    section header ul li a:hover {
        color: #f9004d;
    }

    section header p {
        cursor: pointer;
        padding: 10px 25px;
        border: 1px solid #b36982;
        border-radius: 30px;
        transition: 0.3s;
    }

    section header p:hover {
        color: white;
        background: #b36982;
    }

    .circle {
        position: absolute;
        top: 0;
        left: 0;
        width: 100%;
        height: 100%;
        background: rgb(179, 105, 130);
        clip-path: circle(320px at left -230px);
        z-index: -1;
    }

    .circles {
        position: absolute;
        top: 0;
        left: 0;
        width: 100%;
        height: 100%;
        background: #b36982;
        clip-path: circle(250px at right 800px);
        z-index: -1;
    }

    section .texts h1 {
        position: absolute;
        top: 30%;
        left: 4%;
        font-size: 100px;
        color: #6a6666;
    }

    section .texts h1 span {
        color: #b36982;
    }

    section .texts p {
        width: 650px;
        position: absolute;
        top: 50%;
        left: 4%;
        line-height: 26px;
        text-align: justify;
    }

    section .background_image img {
        width: 750px;
        position: absolute;
        top: 25%;
        left: 47%;
        margin-left: 25px;
    }

    section .btn {
        position: relative;
        top: 77%;
        left: 38px;
        width: 340px;
        display: flex;
        align-items: center;
        justify-content: space-around;
    }


    section .btn .read {
        background: #b36982;
        color: white;
        cursor: pointer;
    }

    section .btn p {
        padding: 10px 25px;
        background: none;
        border: 2px solid #b36982;
        cursor: pointer;
    }


    .about {
        width: 100%;
        height: 240vh;
        padding: 50px;
    }

    .about .box {
        width: 100%;
        padding: 60px 0;
        display: flex;
        align-items: center;
        justify-content: center;
    }

    .about .box .card {
        width: 170px;
        height: auto;
        padding: 5px 10px;
        margin: 0 15px;
        background: gainsboro;
        border: 1px solid gainsboro;
        cursor: pointer;
        z-index: 1;
        transition: 0.3s;
    }

    .about .box .card:hover {
        box-shadow: 3px 5px 20px rgba(0, 0, 0, 0.3);
        transform: scale(1.1);
        border-radius: 5px;
    }

    .about .box .card img {
        width: 150px;
    }

    .about hr {
        height: 2px;
        background: #d98ca5;
        border-radius: 5px;
        margin: 30px 110px;
    }

    .about .Clothes h1 {
        font-size: 70px;
        display: flex;
        justify-content: center;
        align-items: center;
        margin: 35px 0;
    }

    .about .Clothes p {
        text-align: center;
        margin: 35px 0;
        color: gray;
        font-size: 25px;
    }

    .about .clothes_box {
        width: 100%;
        display: grid;
        grid-template-columns: 1fr 1fr 1fr 1fr;
        grid-gap: 15px;
    }

    .about .clothes_box .clothes_card {
        background: #e5e5e5;
        width: 350px;
        padding: 25px 25px;
        text-align: center;
        border-radius: 10px;
        transition: 0.3s;
    }

    .about .clothes_box .clothes_card:hover {
        box-shadow: 5px 5px 5px rgba(0, 0, 0, 0.6);
    }

    .about .Clothes .clothes_box img {
        width: 250px;
        height: 300px;
        cursor: pointer;
        transition: 0.3s;
    }

    .about .Clothes .clothes_box img:hover {
        transform: scale(1.1);
    }

    .about .clothes_box .clothes_card h1 {
        font-size: 35px;
        color: #24262b;
        margin: 15px 0;
    }

    .about .clothes_box .clothes_card p {
        color: #191919;
        margin: 25px 0;
        font-size: 17px;
    }

    .about .clothes_box .clothes_card .btn {
        text-decoration: none;
        color: white;
        padding: 10px 30px;
        background: #f9004d;
    }

    .about .Food p {
        text-align: center;
        margin: 35px 0;
        color: gray;
        font-size: 25px;
    }

    .about .food_box {
        width: 100%;
        display: grid;
        grid-template-columns: 1fr 1fr 1fr 1fr;
        grid-gap: 15px;
    }

    .about .food_box .food_card {
        background: #9d9d9d;
        width: 350px;
        padding: 25px 25px;
        text-align: center;
        border-radius: 10px;
        transition: 0.3s;
    }

    .about .food_box .food_card:hover {
        box-shadow: 5px 5px 5px rgba(0, 0, 0, 0.6);
    }

    .about .food_box .food_card img {
        width: 250px;
        cursor: pointer;
        transition: 0.3s;
    }

    .about .food_box .food_card img:hover {
        transform: scale(1.1);
    }

    .about .food_box .food_card h1 {
        font-size: 35px;
        color: gainsboro;
        margin: 15px 0;
    }

    .about .food_box .food_card p {
        color: white;
        margin: 25px 0;
        font-size: 17px;
    }

    .about .food_box .food_card .btn {
        text-decoration: none;
        color: white;
        padding: 10px 30px;
        background: #f9004d;
        text-align: center;
        border-radius: 20px;
        transition: 0.3s;
    }


    .footer {
        background: #24262b;
        padding: 50px;
    }

    .footer .main {
        max-width: 1170px;
        margin: auto;
    }

    ul {
        list-style: none;
    }

    .row {
        display: flex;
        flex-wrap: wrap;
    }

    .footer_col {
        width: 25%;
        padding: 0 15px;
    }

    .footer_col h4 {
        font-size: 18px;
        color: white;
        text-transform: capitalize;
        margin-bottom: 30px;
        font-weight: 500;
        position: relative;
    }

    .footer_col h4::before {
        content: '';
        position: absolute;
        left: 0;
        bottom: -10px;
        background: #e91e63;
        height: 2px;
        box-sizing: border-box;
        width: 50px;
    }

    .footer_col ul li {
        margin-bottom: 20px;
    }

    .footer_col ul li a {
        text-decoration: none;
        color: #6d6d6d;
        cursor: pointer;
    }

    .footer_col .social img {
        width: 20px;
        margin: 5px;
    }
    .center {
         text-align: center;
         margin-top: 50px;
         margin-bottom: 50px;
     }

    .pagination {
        display: inline-block;
    }

    .pagination a {
        color: black;
        float: left;
        padding: 8px 16px;
        text-decoration: none;
        transition: background-color .3s;
        border: 1px solid #ddd;
        margin: 0 4px;
    }

    .pagination a.active {
        background-color: #4CAF50;
        color: white;
        border: 1px solid #4CAF50;
    }

    .pagination a:hover:not(.active) {
        background-color: #ddd;
    }
</style>

<body>

<section>
    <header>
        <div class="circle"></div>
        <div class="circles"></div>
        <a href="#" class="logo">Shop<span>ifty</span></a>
        <ul>
            <li><a href="/admin">Lịch Sử hoá đơn</a></li>
            <li><a href="/product/index">product</a></li>
            <li><a href="/catecory/index">category</a></li>
            <li><a href="#">News</a></li>
            <li><a href="#">Contact</a></li>
        </ul>
    </header>

</section>


<a class="btn btn-outline-primary" href="/product/viewadd">ViewAdd</a>
<table border="1" class="table table-striped table-hover" style="width:100%">
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>IMG</th>
        <th>Price</th>
        <th>Date</th>
        <th>Category</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="item" items="${items.content}">
        <tr>
            <td>${item.id}</td>
            <td>${item.name}</td>
            <td><img src="data:image/jpg;base64,${item.getIMGByte()}" width="60" height="60"/>
            </td>
            <td>${item.price}</td>
            <td>${item.createDate}</td>
            <td>${item.category.name}</td>
            <td>
                <a class="btn btn-outline-danger" href="/product/delete/${item.id}">Delete</a>
                <a class="btn btn-outline-danger" href="/product/view-update/${item.id}">Update</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div class="center">
    <div class="pagination">
        <a href="/product/index?p=0">&laquo;</a>
        <a href="/product/index?p=${items.number-1}">1</a>
        <a href="/product/index?p=${items.number+1}">2</a>
        <a href="/product/index?p=${items.totalPages-1}">&raquo;</a>
    </div>
</div>

</body>
</html>
