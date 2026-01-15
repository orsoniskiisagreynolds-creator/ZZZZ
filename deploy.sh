#!/bin/bash

echo "========================================"
echo " CodeNote Learning Studio 部署脚本"
echo "========================================"
echo

# 检查Java
if ! command -v java &> /dev/null; then
    echo "[错误] 未找到Java，请先安装JDK 8或11"
    exit 1
fi
echo "[√] Java 已安装"

# 检查Maven
if ! command -v mvn &> /dev/null; then
    echo "[错误] 未找到Maven，请先安装Maven 3.6+"
    exit 1
fi
echo "[√] Maven 已安装"

# 检查MySQL
if ! command -v mysql &> /dev/null; then
    echo "[警告] 未找到MySQL命令行工具，请手动初始化数据库"
else
    echo "[√] MySQL 已安装"
fi

echo
echo "[1] 编译项目..."
mvn clean package -DskipTests

if [ $? -ne 0 ]; then
    echo "[错误] 编译失败"
    exit 1
fi

echo
echo "[√] 编译成功!"
echo
echo "部署步骤:"
echo "1. 在MySQL中创建数据库: CREATE DATABASE codenote DEFAULT CHARACTER SET utf8mb4;"
echo "2. 导入数据库脚本: source src/main/resources/sql/init.sql"
echo "3. 修改jdbc.properties中的数据库连接信息"
echo "4. 将target/codenote.war部署到Tomcat的webapps目录"
echo "5. 启动Tomcat，访问 http://localhost:8080/codenote"
echo
