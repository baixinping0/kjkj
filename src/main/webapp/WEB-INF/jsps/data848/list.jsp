<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<link href="css/index.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="js/Calendar.js"></script>
<script type="text/javascript">
	$(function() {
		$("#query").click(function() {
			$("[name='pageNum']").val(1);
			$("form:first").submit();
		});
	});
	function showMsg(msg, uuid) {
		//显示遮罩层
		top.lock.show();
		//显示数据区
		top.$('context-msg').style.display = "block";
		top.$('context-msg-text').innerHTML = msg;
		top.$('hid-action').value = "emp_delete.action?emp.uuid=" + uuid;
	}
</script>
<div class="content-right">
	<div class="content-r-pic_w">
		<div style="margin:8px auto auto 12px;margin-top:6px">
			<span class="page_title">员工管理</span>
		</div>
	</div>
	<div class="content-text">
		<s:form action="data848_list">
			<s:hidden name="pageNum"/>
			<div class="square-o-top">
				<table width="100%" border="0" cellpadding="0" cellspacing="0"
					style="font-size:14px; font-weight:bold; font-family:"黑体";">
					<tr>
						<td>错误帧</td>
						<td><s:textfield name="data848q.errorFrame" size="8" /></td>
						<td>错误帧</td>
						<td><s:textfield name="data848q.errorFrame2" size="8" /></td>

						<td>正确码</td>
						<td><s:textfield name="data848q.correctCode" size="8" /></td>
						<td>实际码</td>
						<td><s:textfield name="data848q.actualCode" size="8" /></td>
						<td>操作人员</td>
						<td><s:select name="reporterUuid"  list="empList" listKey="uuid" listValue="name"
									  headerKey="-1" headerValue="---请-选-择---" cssClass="kuan" ></s:select></td>

					</tr>
					<tr>
						<td>产生日期</td>
						<td><input type="text" size="8"
								   onfocus="c.showMoreDay=false;c.show(this);" readonly="true"
								   value="${data848q.produceTimeView}" /> <s:hidden name="data848q.produceTime" />
						</td>
						<td>产生日期</td>
						<td><input type="text" size="8"
								   onfocus="c.showMoreDay=false;c.show(this);" readonly="true"
								   value="${data848q.produceTime2View}" /> <s:hidden name="data848q.produceTime2" /></td>
						<td>上传日期</td>
						<td><input type="text" size="8"
								   onfocus="c.showMoreDay=false;c.show(this);" readonly="true"
								   value="${data848q.inputTimeView}" /> <s:hidden name="data848q.inputTime" />
						</td>
						<td>上传日期</td>
						<td><input type="text" size="8"
								   onfocus="c.showMoreDay=false;c.show(this);" readonly="true"
								   value="${data848q.inputTime2View}" /> <s:hidden name="data848q.inputTime2" /></td>
						<td></td>
						<td><a id="query"> <img src="images/can_b_01.gif"
												border="0" /></a></td>
					</tr>

				</table>
			</div>
		</s:form>
		<script type="text/javascript">
			$(function() {
				$("#query").click(function() {
					$("form:first").submit();
				});
			});
		</script>

		<!--"square-o-top"end-->
		<div class="square-order">
			<table width="100%" border="1" cellpadding="0" cellspacing="0">
				<tr align="center"
					style="background:url(images/table_bg.gif) repeat-x;">
					<td width="10%" height="30">错误帧</td>
					<td width="10%">正确码</td>
					<td width="5%">实际码</td>
					<td width="9%">产生时间</td>
					<td width="16%">上传时间</td>
					<td width="16%">上传人</td>
				</tr>
				<s:iterator value="data848List">
					<tr align="center" bgcolor="#FFFFFF">
						<td width="13%" height="30" >${errorFrame}</td>
						<td>${correctCode}</td>
						<td>${actualCode}</td>
						<td>${inputTimeView}</td>
						<td>${produceTimeView}</td>
						<td>${reporter.name}</td>
					</tr>
				</s:iterator>
			</table>
			<%@include file="/WEB-INF/jsps/tools/paging.jsp"%>
		</div>
		</form>
	</div>
	<div class="content-bbg"></div>
</div>
