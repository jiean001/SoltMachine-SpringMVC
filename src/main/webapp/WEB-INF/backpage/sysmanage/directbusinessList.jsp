<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<div class="bjui-pageHeader">
    <form id="pagerForm" data-toggle="ajaxsearch" action="${pageContext.request.contextPath}/admin/directBusiness/listBusinessByPage" method="post" >
        <input type="hidden" name="pageSize" value="${businesssinfoentitiespage.size}">
        <input type="hidden" name="pageCurrent" value="${businesssinfoentitiespage.number+1}">
        <div class="bjui-searchBar">

            <div class="pull-right">
                <div class="btn-group">
                    <button type="button" class="btn-default" ><a href="${pageContext.request.contextPath}/admin/directBusiness/addPage" data-toggle="dialog" data-width="900" data-height="580" data-id="dialog-mask" data-mask="true" style="text-decoration: none;"><i class="fa fa-plus"></i> 新增下级运营商</a></button>
                </div>
            </div>
        </div>
    </form>
</div>

<div class="bjui-pageContent">
    <table data-toggle="tablefixed" data-width="100%" data-nowrap="true">
        <thead>
        <tr>
            <th >运营商名称</th>
            <th >统一信用代码</th>
            <th >地址</th>
            <th >联系电话</th>
            <th >操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="list" items="${businesssinfoentitiespage.content}">
            <tr>
                <td>${list.businessname}</td>
                <td>${list.creditcode}</td>
                <td>${list.address}</td>
                <td>${list.phone}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/admin/directBusiness/editPage?businessid=${list.businessid}"  class="btn btn-default" data-toggle="dialog" data-width="900" data-height="580" data-id="dialog-mask" data-mask="true">修改</a>
                    <a href="${pageContext.request.contextPath}/admin/directBusiness/delete?businessid=${list.businessid}" class="btn btn-red" data-toggle="doajax" data-confirm-msg="确定要删除吗？">删除</a>
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
                <option value="5" <c:if test="${businesssinfoentitiespage.size==5}">selected</c:if>>5</option>
                <option value="10" <c:if test="${businesssinfoentitiespage.size==10}">selected</c:if>>10</option>
                <option value="20" <c:if test="${businesssinfoentitiespage.size==20}">selected</c:if>>20</option>
                <option value="50" <c:if test="${businesssinfoentitiespage.size==50}">selected</c:if>>50</option>

            </select>
        </div>
        <span>&nbsp;条，共 ${businesssinfoentitiespage.totalElements} 条</span>
    </div>
    <div class="pagination-box" data-toggle="pagination" data-total="${businesssinfoentitiespage.totalElements}" data-page-size="${businesssinfoentitiespage.size}" data-page-current="${businesssinfoentitiespage.number+1}">
    </div>
</div>
