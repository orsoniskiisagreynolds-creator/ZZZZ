<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html><head>
    <meta charset="UTF-8"><title>编辑笔记</title>
    <link href="https://cdn.bootcdn.net/ajax/libs/bootstrap/4.6.2/css/bootstrap.min.css" rel="stylesheet">
    <style>body{background:#1a1a2e;color:#fff;min-height:100vh}</style>
</head><body>
<div class="container mt-5">
<h2 class="mb-4">编辑笔记</h2>
<form action="${pageContext.request.contextPath}/note/update" method="post">
<input type="hidden" name="id" value="${note.id}">
<div class="form-group"><label>标题</label><input type="text" name="title" value="${note.title}" class="form-control bg-dark text-white border-secondary"></div>
<div class="form-group"><label>内容</label><input type="text" name="content" value="${note.content}" class="form-control bg-dark text-white border-secondary"></div>
<div class="form-group"><label>摘要</label><input type="text" name="summary" value="${note.summary}" class="form-control bg-dark text-white border-secondary"></div>
<button type="submit" class="btn btn-primary">更新</button>
<a href="${pageContext.request.contextPath}/note/list" class="btn btn-secondary">取消</a>
</form></div>
</body></html>