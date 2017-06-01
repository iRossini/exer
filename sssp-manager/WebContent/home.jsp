<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理系统</title>
<link rel="stylesheet" href="./layui/css/layui.css">
<link rel="stylesheet" href="./css/global.css">
<script type="text/javascript" src="./layui/layui.js"></script>
</head>
<body>
	<div class="layui-layout layui-layout-admin">
		<div class="layui-header header">
			<div class="layui-main">
				<a class="logo" href="http://www.phplaozhang.com" target="_blank">
					<!--  <img src="./images/logo-top.png" alt="Lz_CMS">-->

				</a>
				<ul class="layui-nav top-nav-container">
					<li class="layui-nav-item layui-this "><a
						href="javascript:void(0)">首页</a></li>
					<li class="layui-nav-item "><a href="javascript:void(0)">客户√</a>
					</li>
					<li class="layui-nav-item"><a href="javascript:void(0)">流转单</a>
					</li>
					<li class="layui-nav-item"><a href="javascript:void(0)">工作</a>
					</li>
					<li class="layui-nav-item"><a href="javascript:void(0)">部门√</a>
					</li>
					<li class="layui-nav-item"><a href="javascript:void(0)">员工√</a>
					</li>
					<li class="layui-nav-item"><a href="javascript:void(0)">仪器√</a>

					</li>
					<li class="layui-nav-item"><a href="logout">退出</a></li>
				</ul>



			</div>
		</div>
		<div class="layui-side layui-bg-black">
			<div class="layui-side-scroll">
				<!-- 首页： -->
				<ul class="layui-nav layui-nav-tree left_menu_ul">
					<li class="layui-nav-item layui-nav-title"><a>公司信息管理</a></li>
					<li class="layui-nav-item first-item layui-this"><a
						href="../home.html" target="main"> <i class="layui-icon">&#xe638;</i>
							<cite>通知栏</cite>
					</a></li>
					<li class="layui-nav-item "><a href="./form.html"
						target="main"> <i class="layui-icon">&#xe642;</i> <cite>暂无功能</cite>
					</a></li>
				</ul>
				<!-- 客户： -->
				<ul
					class="layui-nav layui-nav-tree left_menu_ul content_put_manage hide">
					<li class="layui-nav-item layui-nav-title"><a>客户信息管理</a></li>
					<li class="layui-nav-item first-item"><a href="customer-list"
						target="main"> <i class="layui-icon">&#xe609;</i> <cite>所有客户√</cite>
					</a></li>
					<li class="layui-nav-item "><a href="customer-input"
						target="main"> <i class="layui-icon">&#xe60a;</i> <cite>新增客户</cite>
					</a></li>
				</ul>
				<!-- 流转单： -->
				<ul class="layui-nav layui-nav-tree left_menu_ul hide">
					<li class="layui-nav-item layui-nav-title"><a>流转单信息管理</a></li>
					<li class="layui-nav-item first-item"><a href="order-list"
						target="main"> <i class="layui-icon">&#xe613;</i> <cite>所有流转单</cite>
					</a></li>
					<li class="layui-nav-item "><a href="order-input"
						target="main"> <i class="layui-icon">&#xe613;</i> <cite>创建流转单</cite>
					</a></li>
				</ul>
				<!-- 工作： -->
				<ul class="layui-nav layui-nav-tree left_menu_ul setting_ul hide">
					<li class="layui-nav-item layui-nav-title"><a>我的工作</a></li>
					<li class="layui-nav-item first-item "><a
						href="<?php echo url('setting/base','tab=1') ?>" target="main">
							<i class="layui-icon">&#xe620;</i> <cite>待完成证书</cite>
					</a></li>
					<li class="layui-nav-item"><a
						href="<?php echo url('setting/base','tab=2') ?>" target="main">
							<i class="layui-icon">&#xe612;</i> <cite>待提交证书</cite>
					</a></li>
					<li class="layui-nav-item"><a
						href="<?php echo url('setting/base','tab=3') ?>" target="main">
							<i class="layui-icon"></i> <cite>已提交证书</cite>
					</a></li>

				</ul>
				<!-- 部门： -->
				<ul class="layui-nav layui-nav-tree left_menu_ul  hide">
					<li class="layui-nav-item layui-nav-title"><a>部门管理</a></li>
					<li class="layui-nav-item first-item"><a
						href="department-list" target="main"> <cite>所有部门√</cite>
					</a></li>
					<li class="layui-nav-item"><a href="department-input"
						target="main"> <cite>新增部门</cite>
					</a></li>
				</ul>
				<!-- 员工： -->
				<ul class="layui-nav layui-nav-tree left_menu_ul  hide">
					<li class="layui-nav-item layui-nav-title"><a>员工管理</a></li>
					<li class="layui-nav-item first-item"><a href="emp-list"
						target="main"> <cite>员工资料√</cite>
					</a></li>

					<li class="layui-nav-item"><a href="emp-input" target="main">
							<cite>新增员工</cite>
					</a></li>
				</ul>
				<!-- 仪器： -->
				<ul class="layui-nav layui-nav-tree left_menu_ul  hide">
					<li class="layui-nav-item layui-nav-title"><a>仪器信息管理</a></li>
					<li class="layui-nav-item first-item"><a
						href="instrument-list" target="main"> <cite>台账管理√</cite>
					</a></li>

					<li class="layui-nav-item"><a href="instrument-input"
						target="main"> <cite>新增仪器</cite>
					</a></li>
				</ul>

				<!-- 个人中心： -->
				<ul class="layui-nav layui-nav-tree left_menu_ul  hide">
					<li class="layui-nav-item layui-nav-title"><a>个人中心</a></li>
					<li class="layui-nav-item first-item"><a
						href="category_list.html" target="main"> <cite>个人资料</cite>
					</a></li>

					<li class="layui-nav-item"><a href="./feedback_list.html"
						target="main"> <cite>修改密码</cite>
					</a></li>
				</ul>
			</div>



		</div>

		<div class="layui-body iframe-container">
			<div class="iframe-mask" id="iframe-mask"></div>
			<iframe class="admin-iframe" id="admin-iframe" name="main"
				src="./home.html"> </iframe>
		</div>

		<div class="layui-footer footer">
			<div class="layui-main">
				<p>
					2017 © <a href="#">luoxin</a>
				</p>
			</div>
		</div>
	</div>


	<script type="text/javascript">
		layui.use([ 'layer', 'element', 'jquery', 'tree' ], function() {
			var layer = layui.layer, element = layui.element() //导航的hover效果、二级菜单等功能，需要依赖element模块
			, jq = layui.jquery

			//头部菜单切换
			jq('.top-nav-container .layui-nav-item').click(
					function() {
						var menu_index = jq(this).index(
								'.top-nav-container .layui-nav-item');
						jq('.top-nav-container .layui-nav-item').removeClass(
								'layui-this');
						jq(this).addClass('layui-this');
						jq('.left_menu_ul').addClass('hide');
						jq('.left_menu_ul:eq(' + menu_index + ')').removeClass(
								'hide');
						jq('.left_menu_ul .layui-nav-item').removeClass(
								'layui-this');
						jq('.left_menu_ul:eq(' + menu_index + ')').find(
								'.first-item').addClass('layui-this');
						var url = jq('.left_menu_ul:eq(' + menu_index + ')')
								.find('.first-item a').attr('href');
						jq('.admin-iframe').attr('src', url);
						//出现遮罩层
						jq("#iframe-mask").show();
						//遮罩层消失
						jq("#admin-iframe").load(function() {
							jq("#iframe-mask").fadeOut(100);
						});
					});
			//左边菜单点击
			jq('.left_menu_ul .layui-nav-item').click(function() {
				jq('.left_menu_ul .layui-nav-item').removeClass('layui-this');
				jq(this).addClass('layui-this');
				//出现遮罩层

				jq("#iframe-mask").show();

				//遮罩层消失
				jq("#admin-iframe").load(function() {
					jq("#iframe-mask").fadeOut(1);
				});

			});

			//更新缓存
			jq('.update_cache').click(function() {
				loading = layer.load(2, {
					shade : [ 1, '#000' ]
				//0.2透明度的白色背景
				});
				jq.getJSON('', function(data) {
					if (data.code == 200) {
						layer.close(loading);
						layer.msg(data.msg, {
							icon : 1,
							time : 1000
						}, function() {
							location.reload();//do something
						});
					} else {
						layer.close(loading);
						layer.msg(data.msg, {
							icon : 2,
							anim : 6,
							time : 1000
						});
					}
				});
			});

		});
	</script>
</body>
</html>