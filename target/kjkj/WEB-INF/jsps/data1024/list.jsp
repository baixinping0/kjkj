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
			<span class="data1024_title">1024数据管理</span>
		</div>
	</div>
	<div class="content-text">
		<s:form action="data1024_list">
			<s:hidden name="pageNum"/>
			<div class="square-o-top">
				<table width="100%" border="0" cellpadding="0" cellspacing="0"
					style="font-size:14px; font-weight:bold; font-family:"黑体";">
					<tr>
						<td>通道</td>
						<td><s:textfield name="data1024q.chanel" cssClass="kuan" /></td>
						<td>通道</td>
						<td><s:textfield name="data1024q.chanel2" cssClass="kuan" /></td>
						<td>数据类型</td>
						<td><s:select  name="data1024q.dataType"
									  list="@com.bxp.kjkj.data.entity.Data1024Model@dataTypeMap"
									  headerKey="-1" headerValue="---请-选-择---" cssClass="kuan" /></td>
						<td>错误类型</td>
						<td><s:select  name="data1024q.errorType"
									  list="@com.bxp.kjkj.data.entity.Data1024Model@errorTypeMap"
									  headerKey="-1" headerValue="---请-选-择---" cssClass="kuan" /></td>

					</tr>
					<tr>
						<td>错误行</td>
						<td><s:textfield name="data1024q.errorRow" cssClass="kuan" /></td>
						<td>错误行</td>
						<td><s:textfield name="data1024q.errorRow2" cssClass="kuan" /></td>
						<td>当前计数</td>
						<td><s:textfield name="data1024q.currentCount" cssClass="kuan" /></td>
						<td>当前计数</td>
						<td><s:textfield name="data1024q.currentCount2" cssClass="kuan" /></td>

					</tr>
					<tr>
						<td>下帧计数</td>
						<td><s:textfield name="data1024q.nextCount" cssClass="kuan" /></td>
						<td>下帧计数</td>
						<td><s:textfield name="data1024q.nextCount2" cssClass="kuan" /></td>

						<td>产生日期</td>
						<td><input type="text" size="11"
							onfocus="c.showMoreDay=false;c.show(this);" readonly="true"
							value="${data1024q.produceTimeView}" /> <s:hidden name="data1024q.produceTime" />
						</td>
						<td>产生日期</td>
						<td><input type="text" size="11"
							onfocus="c.showMoreDay=false;c.show(this);" readonly="true"
							value="${data1024q.produceTime2View}" /> <s:hidden name="data1024q.produceTime2" /></td>
					</tr>
					<tr>
						<td>上传日期</td>
						<td><input type="text" size="11"
								   onfocus="c.showMoreDay=false;c.show(this);" readonly="true"
								   value="${data1024q.inputTimeView}" /> <s:hidden name="data1024q.inputTime" />
						</td>
						<td>上传日期</td>
						<td><input type="text" size="11"
								   onfocus="c.showMoreDay=false;c.show(this);" readonly="true"
								   value="${data1024q.inputTime2View}" /> <s:hidden name="data1024q.inputTime2" /></td>
						<td>操作人员</td>
						<td><s:select name="reporterUuid"  list="empList" listKey="uuid" listValue="name"
									  headerKey="-1" headerValue="---请-选-择---" cssClass="kuan" ></s:select></td>
						<td></td>
						<td><a id="query"> <img src="images/can_b_01.gif"
												border="0" />
						</a></td>
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
					<td width="10%" height="30">通道</td>
					<td width="10%">数据类型</td>
					<td width="5%">错误行</td>
					<td width="12%">错误类型</td>
					<td width="10%">当前计数</td>
					<td width="12%">下一帧计数</td>
					<td width="9%">产生时间</td>
					<td width="16%">上传时间</td>
					<td width="16%">上传人</td>
				</tr>
				<s:iterator value="data1024List">
					<tr align="center" bgcolor="#FFFFFF">
						<td width="13%" height="30" >${chanel}</td>
						<td>${dataTypeView}</td>
						<td>${errorRow}</td>
						<td>${errorTypeView}</td>
						<td>${currentCount}</td>
						<td>${nextCount}</td>
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
