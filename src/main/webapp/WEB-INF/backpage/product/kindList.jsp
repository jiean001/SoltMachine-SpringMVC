<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<div class="bjui-pageHeader">
    <form id="pagerForm" data-toggle="ajaxsearch" action="${pageContext.request.contextPath}/admin/kind/listByPage" method="post" >
        <input type="hidden" name="pageSize" value="${kindentityspage.size}">
        <input type="hidden" name="pageCurrent" value="${kindentityspage.number+1}">
        <div class="bjui-searchBar">

            <div class="pull-right">
                <div class="btn-group">
                    <button type="button" class="btn-default" ><a href="${pageContext.request.contextPath}/admin/kind/addPage" data-toggle="dialog" data-width="500" data-height="300" data-id="dialog-mask" data-mask="true" style="text-decoration: none;"><i class="fa fa-plus"></i> 新增商品类别</a></button>
                </div>
            </div>
        </div>
    </form>
</div>

<div class="bjui-pageContent">
    <table data-toggle="tablefixed" data-width="100%" data-nowrap="true">
        <thead>
        <tr>
            <th >商品类别</th>
            <th >操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="list" items="${kindentityspage.content}">
            <tr>
                <td>${list.goodskind}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/admin/kind/delete?kindid=${list.goodskindid}" class="btn btn-red" data-toggle="doajax" data-confirm-msg="确定要删除吗？">删除</a>
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
                <option value="5" <c:if test="${kindentityspage.size==5}">selected</c:if>>5</option>
                <option value="10" <c:if test="${kindentityspage.size==10}">selected</c:if>>10</option>
                <option value="20" <c:if test="${kindentityspage.size==20}">selected</c:if>>20</option>
                <option value="50" <c:if test="${kindentityspage.size==50}">selected</c:if>>50</option>

            </select>
        </div>
        <span>&nbsp;条，共 ${kindentityspage.totalElements} 条</span>
    </div>
    <div class="pagination-box" data-toggle="pagination" data-total="${kindentityspage.totalElements}" data-page-size="${kindentityspage.size}" data-page-current="${kindentityspage.number+1}">
    </div>
</div>
