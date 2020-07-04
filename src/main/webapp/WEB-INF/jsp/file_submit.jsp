<%--
  Created by IntelliJ IDEA.
  User: zhaoyuan
  Date: 2020/05/24
  Time: 2:46 pm
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
	<script type="text/javascript"
			src="${pageContext.request.contextPath}/js/mapping.js"></script>
	<style type="text/css">
		.wrap {
			font-size: 0px;
		}

		.Source_box{
			width: 200px;
			height: 200px;
			border: 1px solid #666;
			font-size: 14px;
			overflow: auto;
		}
		
		.Source_box>div{
			cursor: default;
		}

		.package {
			display: inline-block;
			font-size: 16px;
			margin-right: 20px;
			vertical-align: top;
		}

		.bt {
			display: inline-block;
			vertical-align: top;
			margin-top: 70px;
			margin-right: 20px;
		}

		.bt > input {
			display: block;
			width: 80px;
			height: 30px;
			margin-bottom: 15px;
			font-size: 15px;
		}

		.button_btn {
			margin-left: 300px;
			margin-top: 30px;
		}

		.button_btn > input {
			width: 80px;
			margin-right: 40px;
			height: 25px;
			font-size: 15px;
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
			<%--选择sheet--%>
			<div class="layui-tab-item layui-show">
				<div id="test1" class="demo-transfer"></div>
			</div>
			<%--预览记录数--%>
			<div class="layui-tab-item">

			</div>
			<%--数据清洗--%>
			<div class="layui-tab-item">
				<div class="layui-form-item">
					<label class="layui-form-label" style="width: 100px">去除前后空格</label>
					<div class="layui-input-block">
						<span>去除 <input type="radio" checked="checked" name="is_space" value="01" style="margin-top: 12px"></span>
						<span>不去除 <input type="radio" name="is_space" value="02" style="margin-top: 12px"></span>
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label" style="width: 100px">导入批次</label>
					<div class="layui-input-block">
						<input type="text" name="drpc" style="margin-top: 12px">
					</div>
				</div>
			</div>
			<%--选择映射关系--%>
			<div class="layui-tab-item">
				<div class="wrap">
					<!-- 源字段 -->
					<div class="package">
						源字段
						<div class="Source_field">
							<div class="Source_box">
								<%--<div>eid(企业eid)</div>
								<div>ename(企业名称)</div>
								<div>same_person(有疑似关系的企业列表)</div>
								<div>tag(用于动态更新数据的标记)</div>
								<div>created_time(数据更新时间)</div>--%>
							</div>
							<div>自动选择目标<input type="checkbox"></div>
							<div>隐藏已经匹配的源字段<input type="checkbox"></div>
						</div>
					</div>

					<!-- 目标字段 -->
					<div class="package">
						目标字段
						<div class="Source_field">
							<div class="Source_box">
								<%--<div>ID</div>
								<div>EID</div>
								<div>ENAME</div>
								<div>SAME_PERSON</div>
								<div>TAG</div>
								<div>CREATED_TLME</div>
								<div>CREATED</div>
								<div>UPDATED</div>--%>
							</div>
							<div>自动选择源<input type="checkbox"></div>
							<div>隐藏已经匹配的目标字段<input type="checkbox"></div>
						</div>
					</div>

					<!-- 添加删除按钮 -->
					<div class="bt">
						<input type="button" value="Add(A)">
						<input type="button" value="删除(D)">
					</div>

					<!-- 映射 -->
					<div class="package">
						映射
						<div class="Source_field">
							<div class="Source_box">
								<%--<div> lMPORT_NUM --> lMPORT_NUM</div>--%>
							</div>
						</div>
					</div>

					<!-- 底部三个按钮 -->
					<div class="button_btn">
						<input type="button" id="sm" value="确定(O)">
						<input type="button" value="猜一猜(G)">
						<input type="button" value="取消(C)">
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="bottom">
		<%--<button type="button" class="layui-btn layui-btn-normal layui-btn-radius">百搭按钮</button>--%>
	</div>
</div>

<script type="text/javascript">

	//文件ID
	var fileId = "${fileId}";

	var transferData = "";

	//0表示该tab没有点击，1表示点击过，不在发送xhr请求
	var is_sheet_tab = 0;
	var is_view_tab = 0;
	var is_mapping_tab = 0;

	layui.use(['form','element','transfer', 'layer', 'util'], function(){
		var $ = layui.jquery
				,form = layui.form
				,element = layui.element //Tab的切换功能，切换事件监听等，需要依赖element模块
				,transfer = layui.transfer
				,layer = layui.layer
				,util = layui.util;
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
			//console.log(this); //当前Tab标题所在的原始DOM元素
			//console.log(elem.elem); //得到当前的Tab大容器

			var index = elem.index;

			//处理sheet
			if(0 == index && 0 == is_sheet_tab){
				var $sheetHtml = $(".layui-tab-content>div").eq(0);

				//异步获取sheet
				$.ajax({
					type: "GET",
					url: "${pageContext.request.contextPath}/filesubmit/getFileSheetList/"
							+ fileId,
					dataType: "json",
					success: function (result) {
						if(200 == result.status){
							var sheetList = result.data;
							transfer.render({
								elem: '#test1',
								title:['sheet','已选sheet'],
								id:"sheet",
								height:250,
								data: sheetList
							});

							/*if(0 == is_sheet_tab){
								//追加案件标号和导入批次输入框
								var showHtml = "<label class=\"layui-form-label\">案件标号</label>\n" +
										"\t\t\t\t<div class=\"layui-input-block\">\n" +
										"\t\t\t\t\t<input type=\"text\" name=\"ajbh\" lay-verify=\"required\" autocomplete=\"off\" placeholder=\"请输入案件标号\" class=\"layui-input\" style=\"width: 30vw\">\n" +
										"\t\t\t\t</div>\n" +
										"\t\t\t\t<label class=\"layui-form-label\">导入批次</label>\n" +
										"\t\t\t\t<div class=\"layui-input-block\">\n" +
										"\t\t\t\t\t<input type=\"text\" name=\"importnum\"  lay-verify=\"required|number\" autocomplete=\"off\" placeholder=\"请输入导入批次\" class=\"layui-input\" style=\"width: 30vw\">\n" +
										"\t\t\t\t</div>";
								$(".demo-transfer").after(showHtml);
							}*/
							is_sheet_tab = 1;
						}
					}
				});
			} else if(1 == index){//预览记录
				if(0 == is_view_tab){
					//TODO 验证案件标号和导入批次???

					//判断是否已选择sheet
					if(0 == is_sheet_tab){
						layer.msg('请先选择sheet', function(){
							//关闭后的操作
						});
						return false;
					}

					//获取layui穿梭框右侧的数据
					var sheetData_transfer = transfer.getData('sheet');
					var stringify = JSON.stringify(sheetData_transfer);
					transferData = stringify;

					is_view_tab = 1;

					layer.prompt(
							{title: '预览记录数'},
							function(val, index){
								//layer.msg('得到了'+val);
								var b = isNaN(val);
								if(!b){
									//console.log(sheetData_transfer);

									//TODO 显示表格
									$.ajax({
										url:'${pageContext.request.contextPath}/filesubmit/viewExcel',
										type:'post',
										data:{
											fileId:fileId,
											viewNum:val,
											sheetData_transfer:stringify
										},
										dataType:'json',
										success:function (result) {
											if(200 == result.status){
												var data = result.data;
												var $viewContent = $(".layui-tab-content>div").eq(1);
												$viewContent.html(data);

												//关闭弹窗
												layer.close(index);
											}else{
												layer.msg(result.msg, {icon: 5});
											}
										}
									});
								}else{
									layer.msg('请输入数字，'+val+'不是数字😟');
								}
							});
				}

			}else if(3 == index) {//选择映射关系

				if(0 == is_mapping_tab){
					is_mapping_tab = 1;
					//初始化源字段和目标字段数据
					$.ajax({
						type:'get',
						url:'${pageContext.request.contextPath}/filesubmit/getSDfield/'+fileId,
						dataType:'json',
						success:function (result) {
							if(200 == result.status){

								var data = result.data;

								var sfieldl = data.SFIELDL;//源字段数据
								var dfieldl = data.DFIELDL;//目标字段数据

								var $sourceFieldC = $(".Source_field>.Source_box").eq(0);
								var $dbFieldC = $(".Source_field>.Source_box").eq(1);

								for(var i = 0;i<sfieldl.length;i++){
									var title = sfieldl[i];
									$sourceFieldC.append("<div>"+title+"</div>");
								}

								for(var i = 0;i<dfieldl.length;i++){
									var comments = dfieldl[i].comments;
									$dbFieldC.append("<div>"+comments+"</div>");
								}

							}else{
								layer.msg(result.msg, {icon: 5});
							}
						}
					});
				}
			}
		});

	});

	$(function () {
		doSubmit();
	});

	/**
	 * 最终提交
	 * 需要四个参数
	 * @param fileId
	 * @param 是否去除空格
	 * @param 导入批次
	 * @param sheet
	 * @param 映射
	 */
	function doSubmit(){

		$("#sm").click(function () {
			var index = layer.load();
			//获取参数
			var drpc = $("input[name='drpc']").val();//导入批次
			var is_space = $("input[name='is_space']:checked").val();//是否去除空格

			//校验导入批次参数
			var b = isNaN(drpc);
			if("" == drpc || true == b){
				layer.msg('导入批次参数错误', {icon: 5});
				return;
			}
			if("" == transferData){
				layer.msg('请先选择预览记录', {icon: 5});
				return;
			}

			//获取映射后的数据
			var $mappingField = $(".Source_field>.Source_box").eq(2).find("div");

			var mappingList = [];
			$.each($mappingField,function (i,n) {
				//映射中的某个div
				var mHtml = $(n).html();

				var splitArray = mHtml.split(" –&gt; ");
				var splitArrayS = splitArray[0];//title
				var splitArrayD = splitArray[1];//column

				var obj = new Object();
				obj.valueS = splitArrayS;
				obj.valueD = splitArrayD;

				mappingList.push(obj);
			});

			if(0 == mappingList.length){
				layer.msg('请选择映射关系', {icon: 5});
				return;
			}

			//提交
			$.ajax({
				url:'${pageContext.request.contextPath}/filesubmit/doS',
				type:'post',
				dataType:'json',
				data:{
					fileId:fileId,
					drpc:drpc,
					is_space:is_space,
					transferData:transferData,
					mappingListS:JSON.stringify(mappingList)
				},
				success:function (result) {
					//关闭加载层
					layer.close(index);
					if(200 == result.status){
						var data = result.data;
						var total = data.TOTAL;
						var success = data.SUCCESS;
						var error = data.ERROR;
						var time = data.TIME;

						var alertStr = "共读取到 "+total+" 条文档记录，成功导入 "+success+" 条文档记录，失败 "+error+" 条文档记录，用时 "+time+" 毫秒，失败的请联系系统管理员查看日志。"

						//layer.alert(alertStr, {icon: 6});

						layer.alert(alertStr, {icon: 6, title:'提示'},function(index){
							layer.close(index);
							var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
							parent.location.reload();
							parent.layer.close(index); //再执行关闭
						});


					}else{
						layer.msg(result.msg, {icon: 5});
					}

				}
			});



		});
	}
</script>
</body>
</html>