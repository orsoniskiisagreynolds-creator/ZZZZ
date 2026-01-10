# CodeNote Learning Studio

## SSM技术学习与知识管理一体化平台

### 项目简介

CodeNote Learning Studio 是一个基于SSM框架（Spring + SpringMVC + MyBatis）开发的个人知识管理平台。项目融合了交互式SSM架构教学演示功能与实用的知识管理功能，是学习SSM框架的最佳实践项目。

### 技术栈

- **后端框架**: Spring 5.2.22 + SpringMVC 5.2.22 + MyBatis 3.5.9
- **数据库**: MySQL 8.0
- **前端技术**: JSP + Bootstrap 4.6.2 + jQuery 3.6.0
- **构建工具**: Maven 3.6+

### 功能模块

1. **SSM教学演示**: 交互式8步教学动画，展示SSM三层架构工作原理
2. **笔记管理**: 笔记的CRUD、分类、标签、版本历史
3. **文档管理**: 技术文档的管理
4. **代码片段**: 代码收藏与语法高亮
5. **学习路径**: 学习计划与进度追踪
6. **AI对话**: 与AI助手对话学习
7. **导出功能**: 笔记导出为PDF/Markdown
8. **外部资源**: 知识网站链接管理

### 数据库设计

系统共包含15张数据表：
- sys_user: 用户表
- sys_log: 操作日志表
- note_category: 笔记分类表
- note: 笔记表
- note_tag: 标签表
- note_tag_relation: 笔记标签关联表
- note_history: 笔记历史表
- step: 教学步骤表
- document: 文档表
- code_snippet: 代码片段表
- learning_path: 学习路径表
- chat_history: AI对话历史表
- export_log: 导出记录表
- external_resource: 外部资源表
- note_share: 笔记分享表

### 项目结构

```
CodeNote-Learning-Studio/
├── src/main/java/com/codenote/
│   ├── entity/           # 15个实体类
│   ├── mapper/           # 15个Mapper接口
│   ├── service/          # 15个Service接口
│   │   └── impl/         # 15个Service实现
│   ├── controller/       # 9个Controller
│   └── interceptor/      # 登录拦截器
├── src/main/resources/
│   ├── mapper/           # 15个Mapper XML
│   ├── sql/              # 数据库初始化脚本
│   ├── applicationContext.xml
│   ├── spring-mvc.xml
│   └── jdbc.properties
├── src/main/webapp/
│   ├── WEB-INF/views/    # JSP页面
│   └── static/           # 静态资源
└── docs/
    ├── uml/              # UML图表(drawio格式)
    └── *.docx            # 需求分析文档
```

### 快速开始

#### 1. 环境准备

- JDK 8 或 JDK 11
- Maven 3.6+
- MySQL 8.0
- Tomcat 9.x

#### 2. 数据库初始化

```sql
-- 创建数据库
CREATE DATABASE codenote DEFAULT CHARACTER SET utf8mb4;

-- 导入数据库脚本
source src/main/resources/sql/init.sql
```

#### 3. 配置修改

修改 `src/main/resources/jdbc.properties` 中的数据库连接信息：

```properties
jdbc.url=jdbc:mysql://localhost:3306/codenote?useSSL=false&serverTimezone=Asia/Shanghai
jdbc.username=your_username
jdbc.password=your_password
```

#### 4. 编译运行

```bash
# 编译打包
mvn clean package

# 将war包部署到Tomcat
# 或使用IDE直接运行
```

#### 5. 访问系统

打开浏览器访问: http://localhost:8080/codenote

默认账号: admin / admin123

### 核心亮点

1. **交互式SSM教学演示**（guide.jsp）
   - 动画展示SSM三层架构
   - 代码语法高亮
   - 步骤进度条

2. **完整的知识管理功能**
   - 笔记、文档、代码片段管理
   - 分类和标签系统
   - 版本历史和分享功能

3. **技术学习迭代**
   - 从简单CRUD到复杂功能
   - 体现"简单技术重复运用"思想

### 文档资料

- `docs/CodeNote-Learning-Studio需求分析文档.docx` - 300页完整需求分析
- `docs/uml/` - 8个UML图表（drawio格式）
  - 01-系统架构图.drawio
  - 02-系统用例图.drawio
  - 03-数据库ER图.drawio
  - 04-类图.drawio
  - 05-保存笔记序列图.drawio
  - 06-笔记状态图.drawio
  - 07-创建笔记活动图.drawio
  - 08-部署图.drawio

### 作者信息

- 作者: 杨世宁
- 班级: 软件2391班
- 学号: 202341054005
- 完成时间: 2025年1月

### License

MIT License
