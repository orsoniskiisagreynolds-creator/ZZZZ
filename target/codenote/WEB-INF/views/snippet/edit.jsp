<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html><head>
    <meta charset="UTF-8"><title>编辑代码片段</title>
    <link href="https://cdn.bootcdn.net/ajax/libs/bootstrap/4.6.2/css/bootstrap.min.css" rel="stylesheet">
    <style>body{background:#1a1a2e;color:#fff;min-height:100vh}</style>
</head><body>
<div class="container mt-5">
<h2 class="mb-4">编辑代码片段</h2>
<form action="${pageContext.request.contextPath}/snippet/update" method="post">
<input type="hidden" name="id" value="${codeSnippet.id}">
<div class="form-group"><label>标题</label><input type="text" name="title" value="${codeSnippet.title}" class="form-control bg-dark text-white border-secondary"></div>
<div class="form-group"><label>代码</label><input type="text" name="code" value="${codeSnippet.code}" class="form-control bg-dark text-white border-secondary"></div>
<div class="form-group"><label>语言</label><input type="text" name="language" value="${codeSnippet.language}" class="form-control bg-dark text-white border-secondary"></div>
<button type="submit" class="btn btn-primary">更新</button>
<a href="${pageContext.request.contextPath}/snippet/list" class="btn btn-secondary">取消</a>
</form></div>
</body></html>