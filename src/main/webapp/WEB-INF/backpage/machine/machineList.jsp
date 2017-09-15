<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<div class="bjui-pageHeader">
    <form id="pagerForm" data-toggle="ajaxsearch" action="${pageContext.request.contextPath}/admin/machine/listByPage" method="post" >
        <input type="hidden" name="pageSize" value="${machinepage.size}">
        <input type="hidden" name="pageCurrent" value="${machinepage.number+1}">
        <div class="bjui-searchBar">
            <div class="pull-right">
                <div class="btn-group">
                    <button type="button" class="btn-default" ><a href="${pageContext.request.contextPath}/admin/machine/addPage" data-toggle="dialog" data-width="900" data-height="580" data-id="dialog-mask" data-mask="true" style="text-decoration: none;"><i class="fa fa-plus"></i> 新增售后机</a></button>
                </div>
            </div>
        </div>
    </form>
</div>

<div class="bjui-pageContent">
    <table data-toggle="tablefixed" data-width="100%" data-nowrap="true">
        <thead>
        <tr>
            <th >设备编号</th>
            <th >型号</th>
            <th >制造商</th>
            <th >所在地址</th>
            <th >投产时间</th>
            <th >操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="list" items="${machinepage.content}">
            <tr>
                <td>${list.machinenum}</td>
                <td>${list.machinetype.machinetype}</td>
                <td>${list.manufacturer}</td>
                <td>${list.machineplace}</td>
                <td>${list.producetime}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/admin/machine/editPage?machineid=${list.machineid}"  class="btn btn-default" data-toggle="dialog" data-width="900" data-height="580" data-id="dialog-mask" data-mask="true">修改</a>
                    <a href="${pageContext.request.contextPath}/admin/machine/delete?machineid=${list.machineid}" class="btn btn-red" data-toggle="doajax" data-confirm-msg="确定要退役吗？">退役</a>
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
                <option value="5" <c:if test="${machinepage.size==5}">selected</c:if>>5</option>
                <option value="10" <c:if test="${machinepage.size==10}">selected</c:if>>10</option>
                <option value="20" <c:if test="${machinepage.size==20}">selected</c:if>>20</option>
                <option value="50" <c:if test="${machinepage.size==50}">selected</c:if>>50</option>

            </select>
        </div>
        <span>&nbsp;条，共 ${machinepage.totalElements} 条</span>
    </div>
    <div class="pagination-box" data-toggle="pagination" data-total="${machinepage.totalElements}" data-page-size="${machinepage.size}" data-page-current="${machinepage.number+1}">
    </div>
</div>
