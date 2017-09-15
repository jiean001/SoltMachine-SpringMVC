<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="pull-left" style="margin:10px 5px 10px 5px;font-weight: bold ">
    售货机信息
</div>
<div class="pageFormContent" data-layout-h="0">
    <table class="table table-condensed table-hover" width="100%">
        <tbody>
        <tr>
            <td width="20%" align="right">
                <label class="control-label " style="width: 100px">设备编号：</label>
            </td>
            <td>
                ${machineEntity.machinenum}
            </td>
        </tr>
        <tr>
            <td align="right">
                <label class="control-label " style="width: 100px">型号：</label>
            </td>
            <td>
                ${machineEntity.machinetype.machinetype}
            </td>
        </tr>
        <tr>
            <td align="right">
                <label class="control-label " style="width: 100px">制造商：</label>
            </td>
            <td>
                ${machineEntity.manufacturer}
            </td>
        </tr>
        <tr>
            <td align="right">
                <label class="control-label " style="width: 100px">所在地址：</label>
            </td>
            <td>
                ${machineEntity.machineplace}
            </td>
        </tr>
        </tbody>
    </table>
</div>

<div class="pull-left" style="margin:10px 5px 10px 5px;font-weight: bold ">
    货道信息
</div>
<div class="pull-right">
    <div class="btn-group">
        <button type="button" class="btn btn-default" data-url="${pageContext.request.contextPath}/admin/goodsway/addGoodsWayPage?machineid=${machineEntity.machineid}"
                data-toggle="dialog" data-width="580" data-height="400" data-id="dialog-mask" data-mask="true" style="margin:2px;">新增
        </button>
        <button type="button" class="btn btn-default"
                data-url="${pageContext.request.contextPath}/admin/goodsway/listByPage?type=1"
                data-toggle="navtab" data-id="working_0" data-title="售货机货道管理" style="margin:2px;">返回
        </button>
    </div>
</div>

<table data-toggle="tablefixed" data-width="100%" data-nowrap="true">
    <thead>
    <tr>
        <th>货道编号</th>
        <th>商品名称</th>
        <th>价格（元）</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="list" items="${goodswaygoodsEntitys}">
        <tr>
            <td>货道${list.goodswaynum}</td>
            <td>${list.goods.goodsname}</td>
            <td>${list.machinegoodsentity.price}</td>
            <td>
                <a href="${pageContext.request.contextPath}/admin/goodsway/delete?goodswaygoodsid=${list.goodswaygoodsid}"
                   class="btn btn-red" data-toggle="doajax" data-confirm-msg="确定要删除吗？">删除</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
