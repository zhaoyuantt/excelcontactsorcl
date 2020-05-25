<%--
  Created by IntelliJ IDEA.
  User: zhaoyuan
  Date: 2020/05/24
  Time: 2:46 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport"
		  content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>file upload</title>
	<link rel="shortcut icon"
		  href="${pageContext.request.contextPath}/images/shortcut.ico">
	<link rel="stylesheet"
		  href="${pageContext.request.contextPath}/js/plugins/layui-v2.5.6/layui/css/layui.css"
		  rel="external nofollow">
	<script type="text/javascript"
			src="${pageContext.request.contextPath}/js/plugins/jQuery/jquery-1.8.3.js"></script>
	<script type="text/javascript"
			src="${pageContext.request.contextPath}/js/plugins/layui-v2.5.6/layui/layui.all.js"></script>
	<script type="text/javascript"
			src="${pageContext.request.contextPath}/js/plugins/layui-v2.5.6/layui/layui.js"></script>
	<style type="text/css">
		.bottom{
			text-align: center;
		}
	</style>
</head>
<body>
<div class="main">
	<div class="layui-tab layui-tab-card" lay-filter="test">
		<ul class="layui-tab-title">
			<li class="layui-this">选择sheet</li>
			<li>预览记录</li>
			<li>数据清洗</li>
			<li>映射</li>
		</ul>
		<div class="layui-tab-content" style="height: 70vh;">
			<div class="layui-tab-item layui-show">默认宽度是相对于父元素100%适应的，你也可以固定宽度。</div>
			<div class="layui-tab-item">2</div>
			<div class="layui-tab-item">3</div>
			<div class="layui-tab-item">4</div>
		</div>
	</div>
	<div class="bottom">
		<button type="button" class="layui-btn layui-btn-normal layui-btn-radius">百搭按钮</button>
	</div>
</div>

<script type="text/javascript">
	layui.use('element', function(){
		var $ = layui.jquery
				,element = layui.element; //Tab的切换功能，切换事件监听等，需要依赖element模块

		//触发事件
		var active = {
			tabChange: function(){
				//切换到指定Tab项
				element.tabChange('demo', '22'); //切换到：用户管理
			}
		};

		$('.site-demo-active').on('click', function(){
			var othis = $(this), type = othis.data('type');
			active[type] ? active[type].call(this, othis) : '';
		});

		//Hash地址的定位
		var layid = location.hash.replace(/^#test=/, '');
		element.tabChange('test', layid);

		/**
		 * 监听选项卡切换
		 */
		element.on('tab(test)', function(elem){
			location.hash = 'test='+ $(this).attr('lay-id');
			console.log("当前Tab的所在下标:"+elem.index); //得到当前Tab的所在下标
			console.log(this); //当前Tab标题所在的原始DOM元素
			console.log(elem.elem); //得到当前的Tab大容器

			var index = elem.index;

			//处理sheet
			if(0 == index){
				console.log("taojie");
				var $sheetHtml = $(".layui-tab-content>div").eq(0);

				//异步获取sheet
				$.ajax({
					type: "GET",
					url: "${pageContext.request.contextPath}/adminUser/findAdminUserByUsername/"
							+ username,
					dataType: "json",
					success: function (result) {

					}
				});
			}
		});

	});
</script>
</body>
</html>