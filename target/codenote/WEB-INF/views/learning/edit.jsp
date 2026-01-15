<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html><head>
    <meta charset="UTF-8"><title>编辑学习路径</title>
    <link href="https://cdn.bootcdn.net/ajax/libs/bootstrap/4.6.2/css/bootstrap.min.css" rel="stylesheet">
    <style>body{background:#1a1a2e;color:#fff;min-height:100vh}</style>
</head><body>
<div class="container mt-5">
<h2 class="mb-4">编辑学习路径</h2>
<form action="${pageContext.request.contextPath}/learning/update" method="post">
<input type="hidden" name="id" value="${learningPath.id}">
<div class="form-group"><label>主题</label><input type="text" name="title" value="${learningPath.title}" class="form-control bg-dark text-white border-secondary"></div>
<div class="form-group"><label>描述</label><input type="text" name="description" value="${learningPath.description}" class="form-control bg-dark text-white border-secondary"></div>
<div class="form-group"><label>总步骤</label><input type="text" name="totalSteps" value="${learningPath.totalSteps}" class="form-control bg-dark text-white border-secondary"></div>
<button type="submit" class="btn btn-primary">更新</button>
<a href="${pageContext.request.contextPath}/learning/list" class="btn btn-secondary">取消</a>
</form></div>
</body></html>