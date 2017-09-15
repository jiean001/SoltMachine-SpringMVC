<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<div class="bjui-pageHeader">
    <form id="pagerForm" data-toggle="ajaxsearch" action="${pageContext.request.contextPath}/admin/goodsway/listByPage"
          method="post">
        <input type="hidden" name="pageSize" value="${vementityspage.size}">
        <input type="hidden" name="pageCurrent" value="${vementityspage.number+1}">
        <div class="bjui-searchBar">
            <div class="pull-right">
                <div class="btn-group">
                </div>
            </div>
        </div>
    </form>
</div>

<div class="bjui-pageContent">
    <table data-toggle="tablefixed" data-width="100%" data-nowrap="true">
        <thead>
        <tr>
            <th>设备编号</th>
            <th>型号</th>
            <th>制造商</th>
            <th>所在地址</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="list" items="${vementityspage.content}">
            <tr>
                <td>${list.machinenum}</td>
                <td>${list.machinetype.machinetype}</td>
                <td>${list.manufacturer}</td>
                <td>${list.machineplace}</td>
                <td>
                    <c:if test="${type == 1}">
                        <button type="button" class="btn btn-default" data-toggle="navtab" data-id="working_0"
                                data-url="${pageContext.request.contextPath}/admin/goodsway/setGoodsWay?machineid=${list.machineid}"
                                data-title="售货机货道管理">设置货道
                        </button>
                    </c:if>
                    <c:if test="${type == 2}">
                        <button type="button" class="btn btn-default" data-toggle="navtab" data-id="working_0"
                                data-url="${pageContext.request.contextPath}/admin/goodsway/setGoodsWayGoods?machineid=${list.machineid}"
                                data-title="售货机补货">补货
                        </button>
                    </c:if>
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
                <option value="5" <c:if test="${vementityspage.size==5}">selected</c:if>>5</option>
                <option value="10" <c:if test="${vementityspage.size==10}">selected</c:if>>10</option>
                <option value="20" <c:if test="${vementityspage.size==20}">selected</c:if>>20</option>
                <option value="50" <c:if test="${vementityspage.size==50}">selected</c:if>>50</option>

            </select>
        </div>
        <span>&nbsp;条，共 ${vementityspage.totalElements} 条</span>
    </div>
    <div class="pagination-box" data-toggle="pagination" data-total="${vementityspage.totalElements}"
         data-page-size="${vementityspage.size}" data-page-current="${vementityspage.number+1}">
    </div>
</div>
