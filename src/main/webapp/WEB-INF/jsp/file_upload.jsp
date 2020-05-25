<%--
  Created by IntelliJ IDEA.
  User: zhaoyuan
  Date: 2020/05/23
  Time: 5:41 pm
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
		.file-upload{
			width: 99vw;
			border: #0C0C0C 1px solid;
		}
	</style>
</head>
<body>
<div class="main">
	<div class="file-upload">
		<div class="layui-upload">
			<button type="button" class="layui-btn layui-btn-normal" id="testList">选择多文件</button>
			<div class="layui-upload-list">
				<table class="layui-table">
					<thead>
					<tr><th>文件名</th>
						<th>大小</th>
						<th>状态</th>
						<th>操作</th>
					</tr></thead>
					<tbody id="demoList"></tbody>
				</table>
			</div>
			<button type="button" class="layui-btn" id="testListAction">开始上传</button>
		</div>
	</div>
</div>

<script type="text/javascript">
	layui.use('upload', function(){
		var $ = layui.jquery
				,upload = layui.upload;

		//多文件列表示例
		var demoListView = $('#demoList')
				,uploadListIns = upload.render({
			elem: '#testList'
			,url: '/fileupload/upload' //改成您自己的上传接口
			,accept: 'file'
			,multiple: true
			,auto: false
			,bindAction: '#testListAction'
			,choose: function(obj){
				var files = this.files = obj.pushFile(); //将每次选择的文件追加到文件队列
				//读取本地文件
				obj.preview(function(index, file, result){
					var tr = $(['<tr id="upload-'+ index +'">'
						,'<td>'+ file.name +'</td>'
						,'<td>'+ (file.size/1024).toFixed(1) +'kb</td>'
						,'<td>等待上传</td>'
						,'<td>'
						,'<button class="layui-btn layui-btn-xs demo-reload layui-hide">重传</button>'
						,'<button class="layui-btn layui-btn-xs layui-btn-danger demo-delete">删除</button>'
						,'</td>'
						,'</tr>'].join(''));

					//单个重传
					tr.find('.demo-reload').on('click', function(){
						obj.upload(index, file);
					});

					//删除
					tr.find('.demo-delete').on('click', function(){
						delete files[index]; //删除对应的文件
						tr.remove();
						uploadListIns.config.elem.next()[0].value = ''; //清空 input file 值，以免删除后出现同名文件不可选
					});

					demoListView.append(tr);
				});
			}
			,done: function(res, index, upload){
				if(0 == res.code){ //上传成功
					//存入数据库的文件唯一标识
					var id = res.data.id;

					var tr = demoListView.find('tr#upload-'+ index)
							,tds = tr.children();
					tds.eq(2).html('<span style="color: #5FB878;">上传成功</span>');

					//绑定提交事件
					tds.eq(3).html("<button type=\"button\" class=\"layui-btn layui-btn-xs layui-btn-normal\" onclick=\"goSubmit('"+id+"')\">提交</button>"); //清空操作
					return delete this.files[index]; //删除文件队列已经上传成功的文件
				}
				this.error(index, upload);
			}
			,allDone: function(obj){ //当文件全部被提交后，才触发
				console.log(obj.total); //得到总文件数
				console.log(obj.successful); //请求成功的文件数
				console.log(obj.aborted); //请求失败的文件数
			}
			,error: function(index, upload){
				var tr = demoListView.find('tr#upload-'+ index)
						,tds = tr.children();
				tds.eq(2).html('<span style="color: #FF5722;">上传失败</span>');
				tds.eq(3).find('.demo-reload').removeClass('layui-hide'); //显示重传
			}
		});

	});

	/**
	 * 跳转到提交页面
	 * @param id
	 */
	function goSubmit(id){
		//iframe层-父子操作
		layer.open({
			type: 2,
			area: ['80vw', '90vh'],
			fixed: false, //不固定
			maxmin: true,
			content: '/filesubmit/page/'+id
		});
	}

</script>
</body>
</html>