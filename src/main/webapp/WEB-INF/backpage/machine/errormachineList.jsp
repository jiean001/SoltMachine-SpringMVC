<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<div class="bjui-pageHeader">
    <form id="pagerForm" data-toggle="ajaxsearch" action="${pageContext.request.contextPath}/admin/errormachine/listByPage" method="post" >
        <input type="hidden" name="pageSize" value="${errormachinepage.size}">
        <input type="hidden" name="pageCurrent" value="${errormachinepage.number+1}">
        <div class="bjui-searchBar">
            <div class="pull-right">
                <div class="btn-group"></div>
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
            <th >故障发生时间</th>
            <th >操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="list" items="${errormachinepage.content}">
            <tr>
                <td>${list.machine.machinenum}</td>
                <td>${list.machine.machinetype.machinetype}</td>
                <td>${list.machine.manufacturer}</td>
                <td>${list.machine.machineplace}</td>
                <td>${list.machine.producetime}</td>
                <td>${list.faulttime}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/admin/errormachine/editPage?faultid=${list.faultid}"  class="btn btn-default" data-toggle="dialog" data-width="900" data-height="580" data-id="dialog-mask" data-mask="true">维修</a>
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
                <option value="5" <c:if test="${errormachinepage.size==5}">selected</c:if>>5</option>
                <option value="10" <c:if test="${errormachinepage.size==10}">selected</c:if>>10</option>
                <option value="20" <c:if test="${errormachinepage.size==20}">selected</c:if>>20</option>
                <option value="50" <c:if test="${errormachinepage.size==50}">selected</c:if>>50</option>

            </select>
        </div>
        <span>&nbsp;条，共 ${errormachinepage.totalElements} 条</span>
    </div>
    <div class="pagination-box" data-toggle="pagination" data-total="${errormachinepage.totalElements}" data-page-size="${errormachinepage.size}" data-page-current="${errormachinepage.number+1}">
    </div>
</div>
