<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<link href="css/index.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript">
	$(function() {
		$("#query").click(function() {
			/* $("[name=pageNum]").val(1); */
			$("form:first").submit();
		});
	});
	/*
	function showMsg(msg,uuid){
		//top.document.getElementById("context-msg").style.display = "block";
		top.$('context-msg').style.display = "block";
		top.$('context-msg-text').innerHTML=msg;
		top.$('hid-action').value="actionName";
		top.lock.show();
	}
	 */
	function showMsg(msg, uuid) {
		//显示遮罩层
		top.lock.show();
		//显示数据区
		top.$('context-msg').style.display = "block";
		top.$('context-msg-text').innerHTML = msg;
		top.$('hid-action').value = "dep_delete.action?dep.uuid=" + uuid;
	}
</script>
<div class="content-right">
	<div class="content-r-pic_w">
		<div style="margin:8px auto auto 12px;margin-top:6px">
			<span class="page_title">部门管理</span>
		</div>
	</div>
	<div class="content-text">
		<s:form action="dep_list" method="post">
			<div class="square-o-top">
				<table width="100%" border="0" cellpadding="0" cellspacing="0"
					style="font-size:14px; font-weight:bold; font-family:"黑体";">
					<tr>
						<td width="68" height="30">&nbsp;&nbsp;&nbsp;</td>
						<td width="123">&nbsp;</td>
						<td width="62">部门名称:</td>
						<td width="142"><s:textfield name="depq.name" size="18" /></td>
						<td width="60">电话:</td>
						<td width="149"><s:textfield name="depq.tele" size="18" /></td>
						<td width="70"><a id="query"> <img
								src="images/can_b_01.gif" border="0" />
						</a></td>
						<td width="70"><a href="dep_input.action"> <img
								src="images/can_b_02.gif" border="0" />
						</a></td>
					</tr>
				</table>
			</div>
			<!--"square-o-top"end-->
			<div class="square-order">
				<!-- if的test属性中应该定义的条件是如果集合中没有元素，显示提示信息，否则显示数据 -->
				<!-- depList没有数据depList.size() == 0 -->
				<!-- ==<s:property value="#depList.toString()"/>==
				==<s:property value="depList.size()"/>==
				==<s:property value="2"/>==
				==<s:property value="#depList.size() == 2"/>== -->
				<s:if test="#depList.size() == 0">
					<center>
						<span style="font-size:20px;color:#96D34A;font-weight:bold">没有查找到满足条件的数据！</span>
					</center>
				</s:if>
				<s:else>
					<table width="100%" border="1" cellpadding="0" cellspacing="0">
						<tr align="center"
							style="background:url(images/table_bg.gif) repeat-x;">
							<td width="13%" height="30">编号</td>
							<td width="13%">部门名称</td>
							<td width="16%">电话</td>
							<td width="16%">操作</td>
						</tr>
						<s:iterator value="depList">
							<tr align="center" bgcolor="#FFFFFF">
								<td width="13%" height="30">${uuid}</td>
								<td>${name}</td>
								<td>${tele}</td>
								<td><img src="images/icon_3.gif" /> <span
									style="line-height:12px; text-align:center;"> <s:a
											action="dep_input" cssClass="xiu">
											<s:param name="dep.uuid" value="uuid" />
											修改
										</s:a>
								</span> <img src="images/icon_04.gif" /> <span
									style="line-height:12px; text-align:center;"> 
										<%-- <s:a
											action="dep_delete" cssClass="xiu">
											<s:param name="dep.uuid" value="uuid" />
											删除
										</s:a>
										 --%>
										 <a href="javascript:void(0)" class="xiu" onclick="showMsg('是否删除当前部门信息？',${uuid})">删除</a>
								</span></td>
							</tr>
						</s:iterator>
					</table>
					<table width="100%" border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td width="51%">&nbsp;</td>
							<td width="13%">共${dataTotal}条记录
							<td width="6%"><a id="fir" class="sye">首&nbsp;&nbsp;页</a></td>
							<td width="6%"><a id="pre" class="sye">上一页</a></td>
							<td width="6%"><a id="next" class="sye">下一页</a></td>
							<td width="6%"><a id="last" class="sye">末&nbsp;&nbsp;页</a></td>
							<td width="12%">当前第<span style="color:red;">${pageNum}</span>/${maxPageNum }页
							</td>
						</tr>
					</table>
					<s:hidden name="pageNum" />
					<script type="text/javascript">
						$(function() {

							var pageNum = ${pageNum};
							var maxPageNum = ${maxPageNum};
							/* 
							如果数据只有一页，则全部不显示
							如果在第一页，前两个不显示
							如果是最后一页，后两个不显示
							在中间全部显示
							 */
							if (maxPageNum == 1) {
								$("#fir").css("display", "none");
								$("#pre").css("display", "none");
								$("#next").css("display", "none");
								$("#last").css("display", "none");

							} else if (pageNum == 1) {
								$("#fir").css("display", "none");
								$("#pre").css("display", "none");
								$("#next").css("display", "inline");
								$("#last").css("display", "inline");

							} else if (pageNum == maxPageNum) {
								$("#fir").css("display", "inline");
								$("#pre").css("display", "inline");
								$("#next").css("display", "none");
								$("#last").css("display", "none");

							} else {
								$("#fir").css("display", "inline");
								$("#pre").css("display", "inline");
								$("#next").css("display", "inline");
								$("#last").css("display", "inline");

							}

							$("#next")
									.click(
											function() {
												//收集页码值，将页码值设置为指定值，提交表单
												$("[name=pageNum]").val(
														$("[name=pageNum]")
																.val() * 1 + 1);
												$("form:first").submit();
											});

							$("#pre").click(
									function() {
										//收集页码值，将页码值设置为指定值，提交表单
										$("[name=pageNum]").val(
												$("[name=pageNum]").val() - 1);
										$("form:first").submit();
									});

							$("#fir").click(function() {
								//收集页码值，将页码值设置为指定值，提交表单
								$("[name=pageNum]").val(1);
								$("form:first").submit();
							});

							$("#last").click(function() {
								//收集页码值，将页码值设置为指定值，提交表单
								$("[name=pageNum]").val(${maxPageNum});
								$("form:first").submit();
							});
						});
					</script>
				</s:else>
			</div>
		</s:form>
	</div>
	<div class="content-bbg"></div>
</div>
