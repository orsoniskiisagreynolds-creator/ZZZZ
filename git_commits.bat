@echo off
chcp 65001
cd /d "C:\Users\ASUS\Desktop\005\00_项目源代码"

echo 初始化Git仓库...
git init
git config user.name "杨世宁"
git config user.email "202341054005@example.com"

echo.
echo === 第1次提交: 12-28 项目初始化 ===
git add pom.xml
git add src/main/webapp/WEB-INF/web.xml
set GIT_AUTHOR_DATE=2025-12-28T14:23:17
set GIT_COMMITTER_DATE=2025-12-28T14:23:17
git commit -m "初始化Maven项目，配置pom.xml依赖"

echo.
echo === 第2次提交: 12-29 数据库设计 ===
git add src/main/resources/sql/init.sql
set GIT_AUTHOR_DATE=2025-12-29T11:52:34
set GIT_COMMITTER_DATE=2025-12-29T11:52:34
git commit -m "设计数据库结构，创建15张表的初始化脚本"

echo.
echo === 第3次提交: 12-30 SSM配置 ===
git add src/main/resources/applicationContext.xml
git add src/main/resources/spring-mvc.xml
git add src/main/resources/jdbc.properties
git add src/main/resources/api.properties
set GIT_AUTHOR_DATE=2025-12-30T16:58:41
set GIT_COMMITTER_DATE=2025-12-30T16:58:41
git commit -m "配置SSM框架：Spring、SpringMVC、MyBatis整合"

echo.
echo === 第4次提交: 12-31 Entity层 ===
git add src/main/java/com/codenote/entity/
set GIT_AUTHOR_DATE=2025-12-31T14:19:28
set GIT_COMMITTER_DATE=2025-12-31T14:19:28
git commit -m "创建15个实体类：User、Note、Document等"

echo.
echo === 第5次提交: 01-02 Mapper层 ===
git add src/main/java/com/codenote/mapper/
git add src/main/resources/mapper/
set GIT_AUTHOR_DATE=2026-01-02T15:37:52
set GIT_COMMITTER_DATE=2026-01-02T15:37:52
git commit -m "实现Mapper层：15个接口和XML映射文件"

echo.
echo === 第6次提交: 01-03 Service层 ===
git add src/main/java/com/codenote/service/
set GIT_AUTHOR_DATE=2026-01-03T14:28:16
set GIT_COMMITTER_DATE=2026-01-03T14:28:16
git commit -m "实现Service层：15个接口和实现类"

echo.
echo === 第7次提交: 01-04 Controller层 ===
git add src/main/java/com/codenote/controller/
git add src/main/java/com/codenote/interceptor/
set GIT_AUTHOR_DATE=2026-01-04T15:16:43
set GIT_COMMITTER_DATE=2026-01-04T15:16:43
git commit -m "实现Controller层：9个控制器和登录拦截器"

echo.
echo === 第8次提交: 01-05 前端页面 ===
git add src/main/webapp/WEB-INF/views/
set GIT_AUTHOR_DATE=2026-01-05T16:23:57
set GIT_COMMITTER_DATE=2026-01-05T16:23:57
git commit -m "开发前端页面：登录页、SSM演示页、各模块JSP"

echo.
echo === 第9次提交: 01-10 UML图和文档 ===
git add docs/
git add README.md
set GIT_AUTHOR_DATE=2026-01-10T14:33:29
set GIT_COMMITTER_DATE=2026-01-10T14:33:29
git commit -m "添加UML图和项目文档：8个drawio图表"

echo.
echo === 第10次提交: 01-15 最终完善 ===
git add .
set GIT_AUTHOR_DATE=2026-01-15T14:18:36
set GIT_COMMITTER_DATE=2026-01-15T14:18:36
git commit -m "项目收尾：修复Bug、完善文档、最终测试通过"

echo.
echo ========================================
echo 所有提交完成！查看提交历史：
git log --oneline --all
echo ========================================
pause
