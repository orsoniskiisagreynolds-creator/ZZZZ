<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html><head>
    <meta charset="UTF-8"><title>新建外部资源</title>
    <link href="https://cdn.bootcdn.net/ajax/libs/bootstrap/4.6.2/css/bootstrap.min.css" rel="stylesheet">
    <style>body{background:#1a1a2e;color:#fff;min-height:100vh}</style>
</head><body>
<div class="container mt-5">
<h2 class="mb-4">新建外部资源</h2>
<form action="${pageContext.request.contextPath}/resource/save" method="post">
<div class="form-group"><label>标题</label><input type="text" name="title" class="form-control bg-dark text-white border-secondary" required></div>
<div class="form-group"><label>链接</label><input type="text" name="url" class="form-control bg-dark text-white border-secondary" required></div>
<div class="form-group"><label>分类</label><input type="text" name="category" class="form-control bg-dark text-white border-secondary" required></div>
<button type="submit" class="btn btn-primary">保存</button>
<a href="${pageContext.request.contextPath}/resource/list" class="btn btn-secondary">取消</a>
</form></div>
</body></html>