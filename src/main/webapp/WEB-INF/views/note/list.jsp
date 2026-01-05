<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html><head>
    <meta charset="UTF-8"><title>笔记列表</title>
    <link href="https://cdn.bootcdn.net/ajax/libs/bootstrap/4.6.2/css/bootstrap.min.css" rel="stylesheet">
    <style>body{background:#1a1a2e;color:#fff;min-height:100vh}.card{background:rgba(255,255,255,0.05);border:1px solid rgba(255,255,255,0.1)}.card:hover{transform:translateY(-3px)}</style>
</head><body>
<nav class="navbar navbar-dark mb-4" style="background:rgba(0,0,0,0.3)">
    <a class="navbar-brand" href="${pageContext.request.contextPath}/">CodeNote</a>
    <a href="${pageContext.request.contextPath}/note/create" class="btn btn-primary btn-sm">新建笔记</a>
</nav>
<div class="container"><h2 class="mb-4">笔记列表</h2>
<div class="row">
<c:forEach var="item" items="${list}">
<div class="col-md-4 mb-3"><div class="card h-100"><div class="card-body">
<h5 class="card-title" style="color:#4fc3f7">${item.title}</h5>
</div><div class="card-footer bg-transparent">
<a href="${pageContext.request.contextPath}/note/edit/${item.id}" class="btn btn-sm btn-outline-info">编辑</a>
<a href="${pageContext.request.contextPath}/note/delete/${item.id}" class="btn btn-sm btn-outline-danger" onclick="return confirm('确定删除?')">删除</a>
</div></div></div>
</c:forEach>
</div></div>
</body></html>