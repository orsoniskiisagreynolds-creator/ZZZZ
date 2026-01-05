<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>CodeNote Learning Studio - SSM架构交互式演示</title>
    <link href="https://cdn.bootcdn.net/ajax/libs/bootstrap/4.6.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        * { margin: 0; padding: 0; box-sizing: border-box; }
        body {
            font-family: 'Segoe UI', sans-serif;
            background: linear-gradient(135deg, #1a1a2e 0%, #16213e 100%);
            min-height: 100vh; color: #fff;
        }

        /* 顶部导航 */
        .top-nav {
            background: rgba(0,0,0,0.3);
            padding: 15px 30px;
            display: flex;
            justify-content: space-between;
            align-items: center;
            border-bottom: 1px solid rgba(255,255,255,0.1);
        }
        .logo { font-size: 1.5rem; font-weight: bold; color: #4fc3f7; }
        .nav-links a { color: #aaa; margin-left: 25px; text-decoration: none; }
        .nav-links a:hover { color: #4fc3f7; }

        /* 主容器 */
        .main-container {
            display: grid;
            grid-template-columns: 250px 1fr 300px;
            height: calc(100vh - 70px);
        }

        /* 左侧：文件树 */
        .file-tree {
            background: rgba(0,0,0,0.2);
            padding: 20px;
            border-right: 1px solid rgba(255,255,255,0.1);
            overflow-y: auto;
        }
        .file-tree h3 { font-size: 0.9rem; color: #888; margin-bottom: 15px; text-transform: uppercase; }
        .file-item {
            padding: 8px 12px;
            margin: 3px 0;
            border-radius: 5px;
            cursor: pointer;
            display: flex;
            align-items: center;
            transition: all 0.3s;
        }
        .file-item:hover { background: rgba(79,195,247,0.1); }
        .file-item.active { background: rgba(79,195,247,0.2); border-left: 3px solid #4fc3f7; }
        .file-icon { margin-right: 10px; font-size: 1.2rem; }
        .file-name { font-size: 0.85rem; }

        /* 中间：内容区 */
        .content-area {
            padding: 30px;
            overflow-y: auto;
        }
        .step-header { margin-bottom: 30px; }
        .step-number {
            display: inline-block;
            background: linear-gradient(45deg, #4fc3f7, #00bcd4);
            color: #fff;
            padding: 5px 15px;
            border-radius: 20px;
            font-size: 0.85rem;
            margin-bottom: 10px;
        }
        .step-title { font-size: 1.8rem; margin-bottom: 10px; }
        .step-desc { color: #aaa; line-height: 1.8; }

        /* 代码框 */
        .code-block {
            background: #0d1117;
            border-radius: 10px;
            padding: 20px;
            margin: 20px 0;
            border: 1px solid #30363d;
            position: relative;
        }
        .code-block pre {
            color: #c9d1d9;
            font-family: 'Consolas', monospace;
            font-size: 0.9rem;
            line-height: 1.6;
            margin: 0;
            white-space: pre-wrap;
        }
        .code-lang {
            position: absolute;
            top: 10px;
            right: 15px;
            background: #21262d;
            padding: 3px 10px;
            border-radius: 5px;
            font-size: 0.75rem;
            color: #8b949e;
        }

        /* 右侧：架构图 */
        .arch-panel {
            background: rgba(0,0,0,0.2);
            padding: 20px;
            border-left: 1px solid rgba(255,255,255,0.1);
        }
        .arch-panel h3 { font-size: 0.9rem; color: #888; margin-bottom: 20px; text-transform: uppercase; }
        .arch-box {
            background: rgba(255,255,255,0.05);
            border: 2px solid #333;
            border-radius: 10px;
            padding: 15px;
            text-align: center;
            margin: 10px 0;
            transition: all 0.5s;
        }
        .arch-box.active {
            border-color: #4fc3f7;
            box-shadow: 0 0 20px rgba(79,195,247,0.3);
            transform: scale(1.05);
        }
        .arch-box .layer-name { font-weight: bold; margin-bottom: 5px; }
        .arch-box .layer-desc { font-size: 0.75rem; color: #888; }
        .arch-arrow {
            text-align: center;
            color: #444;
            font-size: 1.5rem;
            margin: 5px 0;
        }

        /* 进度条 */
        .progress-bar-container {
            display: flex;
            justify-content: center;
            margin: 20px 0;
        }
        .progress-dot {
            width: 12px;
            height: 12px;
            border-radius: 50%;
            background: #333;
            margin: 0 8px;
            cursor: pointer;
            transition: all 0.3s;
        }
        .progress-dot.active { background: #4fc3f7; transform: scale(1.3); }
        .progress-dot.completed { background: #00c853; }

        /* 控制按钮 */
        .controls {
            display: flex;
            justify-content: center;
            gap: 15px;
            margin-top: 30px;
        }
        .btn-ctrl {
            padding: 12px 30px;
            border: none;
            border-radius: 25px;
            cursor: pointer;
            font-size: 0.9rem;
            transition: all 0.3s;
        }
        .btn-prev { background: #333; color: #fff; }
        .btn-next { background: linear-gradient(45deg, #4fc3f7, #00bcd4); color: #fff; }
        .btn-ctrl:hover { transform: translateY(-2px); box-shadow: 0 5px 15px rgba(0,0,0,0.3); }

        /* 语法高亮 */
        .keyword { color: #ff79c6; }
        .annotation { color: #50fa7b; }
        .string { color: #f1fa8c; }
        .comment { color: #6272a4; }
    </style>
</head>
<body>
    <!-- 顶部导航 -->
    <nav class="top-nav">
        <div class="logo">CodeNote Learning Studio</div>
        <div class="nav-links">
            <a href="${pageContext.request.contextPath}/guide">SSM演示</a>
            <a href="${pageContext.request.contextPath}/note/list">我的笔记</a>
            <a href="${pageContext.request.contextPath}/document/list">文档</a>
            <a href="${pageContext.request.contextPath}/snippet/list">代码片段</a>
            <a href="${pageContext.request.contextPath}/learning/list">学习路径</a>
            <a href="${pageContext.request.contextPath}/logout" style="color:#ff6b6b">退出</a>
        </div>
    </nav>

    <!-- 主容器 -->
    <div class="main-container">
        <!-- 左侧：文件树 -->
        <div class="file-tree">
            <h3>项目结构</h3>
            <div class="file-item" data-index="0">
                <span class="file-icon">📄</span>
                <span class="file-name">Note.java</span>
            </div>
            <div class="file-item" data-index="1">
                <span class="file-icon">📄</span>
                <span class="file-name">NoteMapper.java</span>
            </div>
            <div class="file-item" data-index="2">
                <span class="file-icon">📄</span>
                <span class="file-name">NoteMapper.xml</span>
            </div>
            <div class="file-item" data-index="3">
                <span class="file-icon">📄</span>
                <span class="file-name">NoteService.java</span>
            </div>
            <div class="file-item" data-index="4">
                <span class="file-icon">📄</span>
                <span class="file-name">NoteServiceImpl.java</span>
            </div>
            <div class="file-item" data-index="5">
                <span class="file-icon">📄</span>
                <span class="file-name">NoteController.java</span>
            </div>
            <div class="file-item" data-index="6">
                <span class="file-icon">⚙️</span>
                <span class="file-name">applicationContext.xml</span>
            </div>
            <div class="file-item" data-index="7">
                <span class="file-icon">⚙️</span>
                <span class="file-name">spring-mvc.xml</span>
            </div>
        </div>

        <!-- 中间：内容区 -->
        <div class="content-area">
            <div class="step-header">
                <span class="step-number" id="stepNumber">第 1 步 / 共 8 步</span>
                <h1 class="step-title" id="stepTitle">加载中...</h1>
                <p class="step-desc" id="stepDesc">请稍候...</p>
            </div>

            <div class="code-block">
                <span class="code-lang">Java</span>
                <pre id="stepCode">// 代码加载中...</pre>
            </div>

            <!-- 进度条 -->
            <div class="progress-bar-container" id="progressBar"></div>

            <!-- 控制按钮 -->
            <div class="controls">
                <button class="btn-ctrl btn-prev" onclick="prevStep()">上一步</button>
                <button class="btn-ctrl btn-next" onclick="nextStep()">下一步</button>
            </div>
        </div>

        <!-- 右侧：架构图 -->
        <div class="arch-panel">
            <h3>SSM 架构层次</h3>
            <div class="arch-box" id="layer-controller">
                <div class="layer-name">Controller 层</div>
                <div class="layer-desc">处理HTTP请求</div>
            </div>
            <div class="arch-arrow">↓</div>
            <div class="arch-box" id="layer-service">
                <div class="layer-name">Service 层</div>
                <div class="layer-desc">业务逻辑处理</div>
            </div>
            <div class="arch-arrow">↓</div>
            <div class="arch-box" id="layer-mapper">
                <div class="layer-name">Mapper 层</div>
                <div class="layer-desc">数据库操作</div>
            </div>
            <div class="arch-arrow">↓</div>
            <div class="arch-box" id="layer-entity">
                <div class="layer-name">Entity 层</div>
                <div class="layer-desc">数据模型</div>
            </div>
        </div>
    </div>

    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script>
        // 全局变量
        let steps = [];
        let currentStep = 0;

        // 页面加载时获取数据
        $(document).ready(function() {
            loadSteps();
        });

        // 从后端加载教学步骤
        function loadSteps() {
            $.ajax({
                url: '${pageContext.request.contextPath}/step/all',
                type: 'GET',
                dataType: 'json',
                success: function(data) {
                    steps = data;
                    initProgressBar();
                    showStep(0);
                },
                error: function() {
                    console.log('加载步骤数据失败');
                }
            });
        }

        // 初始化进度条
        function initProgressBar() {
            let html = '';
            for (let i = 0; i < steps.length; i++) {
                html += '<div class="progress-dot" data-index="' + i + '" onclick="goToStep(' + i + ')"></div>';
            }
            $('#progressBar').html(html);
        }

        // 显示指定步骤
        function showStep(index) {
            if (index < 0 || index >= steps.length) return;

            currentStep = index;
            let step = steps[index];

            // 更新内容
            $('#stepNumber').text('第 ' + (index + 1) + ' 步 / 共 ' + steps.length + ' 步');
            $('#stepTitle').text(step.title);
            $('#stepDesc').text(step.description);
            $('#stepCode').html(highlightCode(step.code));

            // 更新进度条
            $('.progress-dot').removeClass('active completed');
            for (let i = 0; i < index; i++) {
                $('.progress-dot[data-index="' + i + '"]').addClass('completed');
            }
            $('.progress-dot[data-index="' + index + '"]').addClass('active');

            // 更新文件树高亮
            $('.file-item').removeClass('active');
            $('.file-item[data-index="' + step.fileIndex + '"]').addClass('active');

            // 更新架构图高亮
            highlightLayer(step.layer);
        }

        // 高亮架构层
        function highlightLayer(layer) {
            $('.arch-box').removeClass('active');
            if (layer === 'entity') {
                $('#layer-entity').addClass('active');
            } else if (layer === 'mapper') {
                $('#layer-mapper').addClass('active');
            } else if (layer === 'service') {
                $('#layer-service').addClass('active');
            } else if (layer === 'controller') {
                $('#layer-controller').addClass('active');
            } else if (layer === 'all') {
                $('.arch-box').addClass('active');
            }
        }

        // 代码语法高亮
        function highlightCode(code) {
            if (!code) return '';
            code = code.replace(/</g, '&lt;').replace(/>/g, '&gt;');
            // 关键字
            code = code.replace(/\b(public|private|class|interface|void|return|new|if|else|for|while)\b/g, '<span class="keyword">$1</span>');
            // 注解
            code = code.replace(/(@\w+)/g, '<span class="annotation">$1</span>');
            // 字符串
            code = code.replace(/"([^"]*)"/g, '<span class="string">"$1"</span>');
            return code;
        }

        // 上一步
        function prevStep() {
            if (currentStep > 0) {
                showStep(currentStep - 1);
            }
        }

        // 下一步
        function nextStep() {
            if (currentStep < steps.length - 1) {
                showStep(currentStep + 1);
            }
        }

        // 跳转到指定步骤
        function goToStep(index) {
            showStep(index);
        }

        // 文件树点击
        $('.file-item').click(function() {
            let index = $(this).data('index');
            showStep(index);
        });
    </script>
</body>
</html>
