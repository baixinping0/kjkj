<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<link href="css/index.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="js/Calendar.js"></script>
<script type="text/javascript">
	$(function() {
		$("#all").click(
				function() {
					$("[name=resources]:checkbox").attr("checked",
							$("#all").attr("checked") == "checked");
				});
		$("#reverse").click(function() {
			$("[name=resources]:checkbox").each(function() {
				$(this).attr("checked", !$(this).attr("checked"));
			});

		});
	});
	/*
	在js中规定，除了false，“false”， FALSE，“FALSE”之外的值都为true。
	checkedBox的checked属性，接收的参数为bool类型。
	 */
	$(function() {
		//为checkBox绑定点击事件
		$("#all").click(function() {
			//使用属性选择器，此时选中的是一组数据 
			//$("[name = resUuids]").attr("checked","checked");
			//获取当前点击组件的状态，将所有组件设置和当前状态相同
			var flag = $(this).attr("checked");
			//$(this).attr("checked")：
			//checked属性：接收的值是bool类型。
			//js语法规定，除了false，“false”， FALSE，“FALSE”之外的值都为true 
			$("[name = resUuids]").attr("checked", flag == "checked");
		});

		$("#reverse").click(function() {
			//当选择器选择多个组件时候，获取组件的任何属性，都是对第一个组件的属性进行获取。

			//对每个组件进行遍历获取
			$("[name = resUuids]").each(function() {
				var flag = $(this).attr("checked");
				$(this).attr("checked", !(flag == "checked"));
			});
			check();
		});

		$("[name = resUuids]").click(function() {
			//在js中   &：位运算：返回值为1或者0
			//			&&：逻辑运算，返回值为bool
			check();
		});

		function check() {
			var flag = true;
			$("[name = resUuids]").each(function() {
				flag = flag && ($(this).attr("checked") == "checked");
			});
			$("#all").attr("checked", flag);
		}
		;
	});
</script>
<div class="content-right">
	<div class="content-r-pic_w">
		<div style="margin:8px auto auto 12px;margin-top:6px">
			<span class="page_title">角色管理</span>
		</div>
	</div>
	<div class="content-text">
		<div class="square-order">
			<form action="role_save" method="post">
				<s:hidden name="role.uuid" />
				<div style="border:1px solid #cecece;">
					<table width="100%" border="0" cellpadding="0" cellspacing="0">
						<tr bgcolor="#FFFFFF">
							<td>&nbsp;</td>
						</tr>
					</table>
					<table width="100%" border="0" cellpadding="0" cellspacing="0">
						<tr bgcolor="#FFFFFF">
							<td width="18%" height="30" align="center">角色名称</td>
							<td width="32%"><s:textfield name="role.name" size="25" /></td>
							<td width="18%" align="center">角色编码</td>
							<td width="32%"><s:textfield name="role.code" size="25" /></td>
						</tr>
						<tr bgcolor="#FFFFFF">
							<td colspan="4">&nbsp;</td>
						</tr>
					</table>
					<table>
						<tr bgcolor="#FFFFFF">
							<td width="18%" height="30" align="center">资源名称</td>
							<td width="82%" colspan="3"><input type="checkbox" id="all">全选&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="checkbox" id="reverse">反选</td>
						</tr>
						<tr bgcolor="#FFFFFF">
							<td width="18%" height="30" align="center">&nbsp;</td>
							<td><s:checkboxlist name="resUuids" list="resList"
									listKey="uuid" listValue="name" />
						</tr>
						<tr bgcolor="#FFFFFF">
							<td width="18%" height="30" align="center">菜单名称</td>
							<td width="82%" colspan="3"><input type="checkbox" id="all">全选&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="checkbox" id="reverse">反选</td>
						</tr>
						<tr bgcolor="#FFFFFF">
							<td width="18%" height="30" align="center">&nbsp;</td>
							<td width="82%" colspan="3">
								<s:checkboxlist name="menuUuids" list="menuList" listKey="uuid" listValue="name"/>
							</td>
						</tr>
						<tr bgcolor="#FFFFFF">
							<td colspan="4">&nbsp;</td>
						</tr>
					</table>
				</div>
				<div class="order-botton">
					<div style="margin:1px auto auto 1px;">
						<table width="100%" border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td><a href="javascript:document.forms[0].submit()"><img
										src="images/order_tuo.gif" border="0" /></a></td>
								<td>&nbsp;</td>
								<td><a id="roleSave"><img src="images/order_tuo.gif"
										border="0" /></a></td>
								<td>&nbsp;</td>
								<td><a href="#"><img src="images/order_tuo.gif"
										border="0" /></a></td>
							</tr>

						</table>
					</div>
				</div>
			</form>
		</div>
		<!--"square-order"end-->
	</div>
	<script type="text/javascript">
		$(function() {
			("#roleSave").click(function() {
				("form:first").submit();
			});
		});
	</script>
	<!--"content-text"end-->
	<div class="content-bbg">
		<img src="images/content_bbg.jpg" />
	</div>
</div>
