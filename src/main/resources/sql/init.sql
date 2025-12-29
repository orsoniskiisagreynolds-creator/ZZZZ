-- ============================================================
-- CodeNote Learning Studio 数据库初始化脚本
-- 数据库名：codenote_db | 共15张表
-- ============================================================

CREATE DATABASE IF NOT EXISTS codenote_db DEFAULT CHARACTER SET utf8mb4;
USE codenote_db;

-- 1. 用户表
DROP TABLE IF EXISTS sys_user;
CREATE TABLE sys_user (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    nickname VARCHAR(50),
    email VARCHAR(100),
    avatar VARCHAR(200),
    status TINYINT DEFAULT 1,
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP,
    update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 2. 操作日志表
DROP TABLE IF EXISTS sys_log;
CREATE TABLE sys_log (
    id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    module VARCHAR(50),
    operation VARCHAR(100),
    method VARCHAR(200),
    params TEXT,
    ip VARCHAR(50),
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 3. 笔记分类表
DROP TABLE IF EXISTS note_category;
CREATE TABLE note_category (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    parent_id INT DEFAULT 0,
    sort_order INT DEFAULT 0,
    user_id INT,
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 4. 笔记表
DROP TABLE IF EXISTS note;
CREATE TABLE note (
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(200) NOT NULL,
    content TEXT,
    summary VARCHAR(500),
    category_id INT,
    user_id INT,
    status TINYINT DEFAULT 1,
    view_count INT DEFAULT 0,
    is_top TINYINT DEFAULT 0,
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP,
    update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 5. 标签表
DROP TABLE IF EXISTS note_tag;
CREATE TABLE note_tag (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(30) NOT NULL,
    color VARCHAR(20) DEFAULT '#007bff',
    user_id INT,
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 6. 笔记标签关联表
DROP TABLE IF EXISTS note_tag_relation;
CREATE TABLE note_tag_relation (
    id INT PRIMARY KEY AUTO_INCREMENT,
    note_id INT NOT NULL,
    tag_id INT NOT NULL,
    UNIQUE KEY uk_note_tag (note_id, tag_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 7. 笔记历史版本表
DROP TABLE IF EXISTS note_history;
CREATE TABLE note_history (
    id INT PRIMARY KEY AUTO_INCREMENT,
    note_id INT NOT NULL,
    title VARCHAR(200),
    content TEXT,
    version INT DEFAULT 1,
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 8. 教学步骤表（SSM演示）
DROP TABLE IF EXISTS step;
CREATE TABLE step (
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(100) NOT NULL,
    description TEXT,
    code TEXT,
    layer VARCHAR(50),
    file_index INT DEFAULT -1,
    sort_order INT DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 9. 文档表
DROP TABLE IF EXISTS document;
CREATE TABLE document (
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(200) NOT NULL,
    content LONGTEXT,
    doc_type VARCHAR(20) DEFAULT 'markdown',
    category VARCHAR(50),
    user_id INT,
    is_public TINYINT DEFAULT 0,
    view_count INT DEFAULT 0,
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP,
    update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 10. 代码片段表
DROP TABLE IF EXISTS code_snippet;
CREATE TABLE code_snippet (
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(100) NOT NULL,
    code TEXT NOT NULL,
    language VARCHAR(30) DEFAULT 'java',
    description VARCHAR(500),
    user_id INT,
    is_favorite TINYINT DEFAULT 0,
    use_count INT DEFAULT 0,
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP,
    update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 11. 学习路径表
DROP TABLE IF EXISTS learning_path;
CREATE TABLE learning_path (
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(100) NOT NULL,
    description TEXT,
    total_steps INT DEFAULT 0,
    completed_steps INT DEFAULT 0,
    progress INT DEFAULT 0,
    status TINYINT DEFAULT 0,
    user_id INT,
    start_time DATETIME,
    end_time DATETIME,
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP,
    update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 12. AI对话历史表
DROP TABLE IF EXISTS chat_history;
CREATE TABLE chat_history (
    id INT PRIMARY KEY AUTO_INCREMENT,
    session_id VARCHAR(50),
    role VARCHAR(20) DEFAULT 'user',
    content TEXT NOT NULL,
    tokens INT DEFAULT 0,
    user_id INT,
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 13. 导出记录表
DROP TABLE IF EXISTS export_log;
CREATE TABLE export_log (
    id INT PRIMARY KEY AUTO_INCREMENT,
    file_name VARCHAR(200) NOT NULL,
    file_type VARCHAR(20) DEFAULT 'pdf',
    file_path VARCHAR(500),
    file_size BIGINT DEFAULT 0,
    source_type VARCHAR(50),
    source_id INT,
    user_id INT,
    status TINYINT DEFAULT 1,
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 14. 外部资源表
DROP TABLE IF EXISTS external_resource;
CREATE TABLE external_resource (
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(200) NOT NULL,
    url VARCHAR(500) NOT NULL,
    description TEXT,
    category VARCHAR(50),
    favicon VARCHAR(200),
    user_id INT,
    is_favorite TINYINT DEFAULT 0,
    visit_count INT DEFAULT 0,
    last_visit_time DATETIME,
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 15. 笔记分享表
DROP TABLE IF EXISTS note_share;
CREATE TABLE note_share (
    id INT PRIMARY KEY AUTO_INCREMENT,
    note_id INT NOT NULL,
    share_code VARCHAR(50) UNIQUE,
    share_url VARCHAR(200),
    password VARCHAR(20),
    expire_time DATETIME,
    view_count INT DEFAULT 0,
    status TINYINT DEFAULT 1,
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ============================================================
-- 初始数据
-- ============================================================

-- 默认用户（密码：123456）
INSERT INTO sys_user (username, password, nickname, email) VALUES
('admin', '123456', '杨世宁', 'admin@codenote.com');

-- 默认分类
INSERT INTO note_category (name, parent_id, sort_order, user_id) VALUES
('Java学习', 0, 1, 1), ('SSM框架', 1, 1, 1), ('Spring', 1, 2, 1),
('数据库', 0, 2, 1), ('MySQL', 4, 1, 1), ('前端技术', 0, 3, 1);

-- 默认标签
INSERT INTO note_tag (name, color, user_id) VALUES
('重要', '#dc3545', 1), ('待复习', '#ffc107', 1), ('已掌握', '#28a745', 1);

-- SSM教学步骤
INSERT INTO step (title, description, code, layer, file_index, sort_order) VALUES
('第1步：创建实体类', 'Entity是数据模型层，映射数据库表', 'public class Note {\n    private Integer id;\n    private String title;\n}', 'entity', 0, 1),
('第2步：创建Mapper接口', 'Mapper接口定义数据库操作方法', 'public interface NoteMapper {\n    List<Note> findAll();\n}', 'mapper', 1, 2),
('第3步：编写Mapper XML', 'XML文件包含SQL语句', '<select id=\"findAll\">\n    SELECT * FROM note\n</select>', 'mapper', 2, 3),
('第4步：创建Service接口', 'Service定义业务逻辑方法', 'public interface NoteService {\n    List<Note> getAllNotes();\n}', 'service', 3, 4),
('第5步：实现Service', 'ServiceImpl包含具体业务逻辑', '@Service\npublic class NoteServiceImpl {\n    @Autowired\n    private NoteMapper mapper;\n}', 'service', 4, 5),
('第6步：创建Controller', 'Controller处理HTTP请求', '@Controller\npublic class NoteController {\n    @GetMapping(\"/list\")\n    public String list() {}\n}', 'controller', 5, 6),
('第7步：配置Spring', 'applicationContext.xml配置IoC容器', '<context:component-scan base-package=\"com.codenote\"/>', 'all', 6, 7),
('第8步：配置SpringMVC', 'spring-mvc.xml配置Web层', '<mvc:annotation-driven/>', 'all', 7, 8);

-- 示例笔记
INSERT INTO note (title, content, summary, category_id, user_id) VALUES
('SSM框架学习笔记', '# SSM框架\nSSM = Spring + SpringMVC + MyBatis', 'SSM入门笔记', 2, 1),
('Java基础复习', '# Java基础\n面向对象、集合框架', 'Java基础知识', 1, 1);

-- 示例文档
INSERT INTO document (title, content, category, user_id) VALUES
('SSM项目搭建指南', '# 搭建步骤\n1. 创建Maven项目\n2. 添加依赖', '技术文档', 1);

-- 示例代码片段
INSERT INTO code_snippet (title, code, language, description, user_id) VALUES
('Spring单例模式', '@Component\npublic class Bean {}', 'java', 'Spring默认单例', 1);

-- 学习路径
INSERT INTO learning_path (title, description, total_steps, completed_steps, progress, status, user_id) VALUES
('SSM框架入门', 'Spring+SpringMVC+MyBatis学习', 8, 5, 62, 1, 1);

-- 外部资源
INSERT INTO external_resource (title, url, category, user_id) VALUES
('Spring官方文档', 'https://spring.io/docs', '官方文档', 1),
('MyBatis中文文档', 'https://mybatis.org/mybatis-3/zh/', '官方文档', 1);

SELECT '数据库初始化完成！共15张表' AS message;
