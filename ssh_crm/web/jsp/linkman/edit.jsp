﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>添加联系人</TITLE> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css
	rel=stylesheet>


<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
	<FORM id=form1 name=form1
		action="${pageContext.request.contextPath }/linkman_updateLinkMan.action"
		method=post>
		<input type="hidden" name="linkid" value="${linkman.linkid }"/>
		<%--<input type="hidden" name="linkid" value="${linkman.linkid}"/>--%>

		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_019.jpg"
						border=0></TD>
					<TD width="100%" background="${pageContext.request.contextPath }/images/new_020.jpg"
						 height=20></TD>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_021.jpg"
						border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15 background=${pageContext.request.contextPath }/images/new_022.jpg><IMG
						src="${pageContext.request.contextPath }/images/new_022.jpg" border=0></TD>
					<TD vAlign=top width="100%" bgColor=#ffffff>
						<TABLE cellSpacing=0 cellPadding=5 width="100%" border=0>
							<TR>
								<TD class=manageHead>当前位置：联系人管理 &gt; 修改联系人</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>
						<TABLE cellSpacing=0 cellPadding=5  border=0>
							<tr>
								<td>所属客户：</td>
								<td colspan="3">
								<select name="customer.cid">
									<c:forEach items="${listCustomer}" var="customer">
										<%--
											当前联系人所属客户id 和所有客户id 比较 ，如果相同 选中状态
										--%>
										<option value="${customer.cid}" <c:if test="${customer.cid==linkman.customer.cid}">selected</c:if>>${customer.custName} </option>

									</c:forEach>
								</select>

								</td>

							</tr>

							<%--	<tr>
									<td>所属客户：</td>
									<td colspan="3">
										<select name="customer.cid">
											<c:forEach items="${listCustomer }" var="customer">
												<!--
												当前联系人所属客户id 和所有客户id比较，如果相同 选中状态
												-->

												<option value="${customer.cid }" <c:if test="${customer.cid == linkman.customer.cid }">selected</c:if>>${customer.custName }</option>
											</c:forEach>
										</select>

									</td>
								</tr>
							<TR>--%>
								<td>联系人名称：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="linkName" value="${linkman.linkName}" >
								</td>
								<td>联系人性别：</td>
								<td>
								<input type="radio" value="男" name="lkmGender" <c:if test="${linkman.lkmGender=='男' }">checked</c:if>>男
								
								<input type="radio" value="女" name="lkmGender" <c:if test="${linkman.lkmGender=='女' }">checked</c:if>>女
								</td>
							</TR>
							<TR>
								<td>联系人办公电话 ：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="lkmPhone" value="${linkman.lkmPhone}">
								</td>
								<td>联系人手机 ：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="lkmMobile" value="${linkman.lkmMobile}">
								</td>
							</TR>
							<tr>
								<td rowspan=2>
								<INPUT class=button id=sButton2 type=submit
														value="保存 " name=sButton2>
								</td>
							</tr>
						</TABLE>
						
						
					</TD>
					<TD width=15 background="${pageContext.request.contextPath }/images/new_023.jpg">
					<IMG src="${pageContext.request.contextPath }/images/new_023.jpg" border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_024.jpg"
						border=0></TD>
					<TD align=middle width="100%"
						background="${pageContext.request.contextPath }/images/new_025.jpg" height=15></TD>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_026.jpg"
						border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
	</FORM>
</BODY>
</HTML>
