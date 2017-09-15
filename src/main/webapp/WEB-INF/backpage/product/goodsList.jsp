<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<div class="bjui-pageHeader">
    <form id="pagerForm" data-toggle="ajaxsearch" action="${pageContext.request.contextPath}/admin/goods/listByPage" method="post" >
        <input type="hidden" name="pageSize" value="${goodsentityspage.size}">
        <input type="hidden" name="pageCurrent" value="${goodsentityspage.number+1}">
        <div class="bjui-searchBar">

            <div class="pull-right">
                <div class="btn-group">
                    <button type="button" class="btn-default" ><a href="${pageContext.request.contextPath}/admin/goods/addPage" data-toggle="dialog" data-width="580" data-height="400" data-id="dialog-mask" data-mask="true" style="text-decoration: none;"><i class="fa fa-plus"></i> 新增商品信息</a></button>
                </div>
            </div>
        </div>
    </form>
</div>

<div class="bjui-pageContent">
    <table data-toggle="tablefixed" data-width="100%" data-nowrap="true">
        <thead>
        <tr>
            <th >商品名称</th>
            <th >商品类别</th>
            <th >商品积分</th>
            <th >操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="list" items="${goodsentityspage.content}">
            <tr>
                <td>${list.goodsname}</td>
                <td>${list.goodskind.goodskind}</td>
                <td>${list.goodsscore}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/admin/goods/showPage?goodsid=${list.goodsid}" class="btn btn-default" data-toggle="dialog" data-width="580" data-height="400" data-id="dialog-mask" data-mask="true">详情</a>
                    <a href="${pageContext.request.contextPath}/admin/goods/editPage?goodsid=${list.goodsid}" class="btn btn-default" data-toggle="dialog" data-width="580" data-height="400" data-id="dialog-mask" data-mask="true">修改</a>
                    <a href="${pageContext.request.contextPath}/admin/goods/delete?goodsid=${list.goodsid}" class="btn btn-red" data-toggle="doajax" data-confirm-msg="确定要删除吗？">删除</a>
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
                <option value="5" <c:if test="${goodsentityspage.size==5}">selected</c:if>>5</option>
                <option value="10" <c:if test="${goodsentityspage.size==10}">selected</c:if>>10</option>
                <option value="20" <c:if test="${goodsentityspage.size==20}">selected</c:if>>20</option>
                <option value="50" <c:if test="${goodsentityspage.size==50}">selected</c:if>>50</option>

            </select>
        </div>
        <span>&nbsp;条，共 ${goodsentityspage.totalElements} 条</span>
    </div>
    <div class="pagination-box" data-toggle="pagination" data-total="${goodsentityspage.totalElements}" data-page-size="${goodsentityspage.size}" data-page-current="${goodsentityspage.number+1}">
    </div>
</div>
