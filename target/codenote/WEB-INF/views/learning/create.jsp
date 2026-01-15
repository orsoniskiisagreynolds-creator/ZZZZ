<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html><head>
    <meta charset="UTF-8"><title>新建学习路径</title>
    <link href="https://cdn.bootcdn.net/ajax/libs/bootstrap/4.6.2/css/bootstrap.min.css" rel="stylesheet">
    <style>body{background:#1a1a2e;color:#fff;min-height:100vh}</style>
</head><body>
<div class="container mt-5">
<h2 class="mb-4">新建学习路径</h2>
<form action="${pageContext.request.contextPath}/learning/save" method="post">
<div class="form-group"><label>主题</label><input type="text" name="title" class="form-control bg-dark text-white border-secondary" required></div>
<div class="form-group"><label>描述</label><input type="text" name="description" class="form-control bg-dark text-white border-secondary" required></div>
<div class="form-group"><label>总步骤</label><input type="text" name="totalSteps" class="form-control bg-dark text-white border-secondary" required></div>
<button type="submit" class="btn btn-primary">保存</button>
<a href="${pageContext.request.contextPath}/learning/list" class="btn btn-secondary">取消</a>
</form></div>
</body></html>