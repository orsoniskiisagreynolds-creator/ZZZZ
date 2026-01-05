<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html><head>
    <meta charset="UTF-8"><title>登录 - CodeNote Learning Studio</title>
    <link href="https://cdn.bootcdn.net/ajax/libs/bootstrap/4.6.2/css/bootstrap.min.css" rel="stylesheet">
    <style>body{background:linear-gradient(135deg,#1a1a2e,#16213e);min-height:100vh;display:flex;align-items:center;justify-content:center}</style>
</head><body>
<div class="card p-5" style="background:rgba(255,255,255,0.1);border-radius:15px;width:400px">
<h3 class="text-white text-center mb-4">CodeNote Learning Studio</h3>
<% if(request.getParameter("error") != null) { %>
<div class="alert alert-danger">用户名或密码错误</div>
<% } %>
<form action="${pageContext.request.contextPath}/doLogin" method="post">
<div class="form-group"><input type="text" name="username" class="form-control bg-dark text-white border-secondary" placeholder="用户名" required></div>
<div class="form-group"><input type="password" name="password" class="form-control bg-dark text-white border-secondary" placeholder="密码" required></div>
<button type="submit" class="btn btn-primary btn-block">登录</button>
</form>
<p class="text-muted text-center mt-3" style="font-size:12px">默认账号: admin / 123456</p>
</div>
</body></html>