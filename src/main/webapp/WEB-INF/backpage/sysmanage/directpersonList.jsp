<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<div class="bjui-pageHeader">
    <form id="pagerForm" data-toggle="ajaxsearch" action="${pageContext.request.contextPath}/admin/directPerson/listBusinessByPage" method="post" >
        <input type="hidden" name="pageSize" value="${personpage.size}">
        <input type="hidden" name="pageCurrent" value="${personpage.number+1}">
        <div class="bjui-searchBar">

            <div class="pull-right">
                <div class="btn-group">
                    <button type="button" class="btn-default" ><a href="${pageContext.request.contextPath}/admin/directPerson/addPage" data-toggle="dialog" data-width="900" data-height="580" data-id="dialog-mask" data-mask="true" style="text-decoration: none;"><i class="fa fa-plus"></i> 新增人员</a></button>
                </div>
            </div>
        </div>
    </form>
</div>

<div class="bjui-pageContent">
    <table data-toggle="tablefixed" data-width="100%" data-nowrap="true">
        <thead>
        <tr>
            <th >姓名</th>
            <th >登录账号</th>
            <th >角色</th>
            <th >联系电话</th>
            <th >身份证号</th>
            <th >入职时间</th>
            <th >状态</th>
            <th >离职时间</th>
            <th >操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="list" items="${personpage.content}">
            <tr>
                <td>${list.realname}</td>
                <td>${list.user.username}</td>
                <td><c:forEach var="roleinfo" items="${list.user.role}">${roleinfo.rolename}</c:forEach></td>
                <td>${list.phone}</td>
                <td>${list.idcard}</td>
                <td>${list.jobtime}</td>
                <td><c:if test="${list.jobstate==0}">在职</c:if><c:if test="${list.jobstate==1}">离职</c:if></td>
                <td>${list.leavetime}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/admin/directPerson/editPage?businessmanid=${list.businessmanid}"  class="btn btn-default" data-toggle="dialog" data-width="900" data-height="580" data-id="dialog-mask" data-mask="true">修改</a>
                    <a href="${pageContext.request.contextPath}/admin/directPerson/delete?businessmanid=${list.businessmanid}" class="btn btn-red" data-toggle="doajax" data-confirm-msg="该人员确定离职吗？">离职</a>
                </td>

            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<div class="bjui-pageFooter">
    <div class="pages">
        <span>每页&nbsp;</span>
        <div class="selectPagesize">
            <select data-toggle="selectpicker" data-toggle-change="changepagesize">
                <option value="5" <c:if test="${personpage.size==5}">selected</c:if>>5</option>
                <option value="10" <c:if test="${personpage.size==10}">selected</c:if>>10</option>
                <option value="20" <c:if test="${personpage.size==20}">selected</c:if>>20</option>
                <option value="50" <c:if test="${personpage.size==50}">selected</c:if>>50</option>

            </select>
        </div>
        <span>&nbsp;条，共 ${personpage.totalElements} 条</span>
    </div>
    <div class="pagination-box" data-toggle="pagination" data-total="${personpage.totalElements}" data-page-size="${personpage.size}" data-page-current="${personpage.number+1}">
    </div>
</div>
