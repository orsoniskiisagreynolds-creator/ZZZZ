@echo off
chcp 65001
echo ========================================
echo  CodeNote Learning Studio 部署脚本
echo ========================================
echo.

:: 检查Java
java -version >nul 2>&1
if errorlevel 1 (
    echo [错误] 未找到Java，请先安装JDK 8或11
    pause
    exit /b 1
)
echo [√] Java 已安装

:: 检查Maven
mvn -v >nul 2>&1
if errorlevel 1 (
    echo [错误] 未找到Maven，请先安装Maven 3.6+
    pause
    exit /b 1
)
echo [√] Maven 已安装

:: 检查MySQL
mysql --version >nul 2>&1
if errorlevel 1 (
    echo [警告] 未找到MySQL命令行工具，请手动初始化数据库
) else (
    echo [√] MySQL 已安装
)

echo.
echo [1] 编译项目...
call mvn clean package -DskipTests

if errorlevel 1 (
    echo [错误] 编译失败
    pause
    exit /b 1
)

echo.
echo [√] 编译成功!
echo.
echo 部署步骤:
echo 1. 在MySQL中创建数据库: CREATE DATABASE codenote DEFAULT CHARACTER SET utf8mb4;
echo 2. 导入数据库脚本: source src/main/resources/sql/init.sql
echo 3. 修改jdbc.properties中的数据库连接信息
echo 4. 将target/codenote.war部署到Tomcat的webapps目录
echo 5. 启动Tomcat，访问 http://localhost:8080/codenote
echo.
pause
