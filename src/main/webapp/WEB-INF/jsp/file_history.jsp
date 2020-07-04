<%--
  Created by IntelliJ IDEA.
  User: zhaoyuan
  Date: 2020/07/04
  Time: 23:27 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

	</style>
</head>
<body>
<div class="main">
	<table class="layui-hide" id="test" lay-filter="test"></table>

	<script type="text/html" id="barDemo">
		<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
	</script>
</div>

<script type="text/javascript">
	layui.use('table', function(){
		var table = layui.table;

		table.render({
			elem: '#test'
			,cellMinWidth: 80 //全局定义常规单元格的最小宽度
			,url:'/file/history/getFileImportHistory'
			,cols: [[
				{type:'numbers',fixed: 'left'}
				,{field:'id', title: 'id', fixed: 'left'}
				,{field:'fileName', title: '文件名称', fixed: 'left'}
				,{field:'fileImportNum', title: '导入批次', sort: true}
				,{field:'fileRowNum', title: '文件导入数量', sort: true}
				,{field:'catagory', title: '分类'}
				,{fixed: 'right', title:'操作', toolbar: '#barDemo', fixed: 'right'}
			]]
			,page: true
		});

		//监听行工具事件
		table.on('tool(test)', function(obj){
			var data = obj.data;
			//console.log(obj)
			var historyId = data.id;
			var category = data.catagory;
			if(obj.event === 'del'){
				layer.confirm('真的删除行么,确认将删除该文件所有的导入文档记录!!!', function(index){
					$.ajax({
						url:'${pageContext.request.contextPath}/file/history/delete/'+historyId+"/"+category,
						type:'get',
						dataType:'json',
						success:function (result) {
							if(200 == result.status){
								obj.del();
								layer.msg('成功删除 '+result.data+" 条文档记录");
							}
						}
					});

					layer.close(index);
				});
			}
		});
	});

</script>
</body>
</html>