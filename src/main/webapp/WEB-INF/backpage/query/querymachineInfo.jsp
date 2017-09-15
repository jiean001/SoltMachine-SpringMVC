<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>


<div class="bjui-pageContent">

    <form id="pagerForm" data-toggle="ajaxsearch" action="${pageContext.request.contextPath}/admin/query/queryPage?machineid=${tMachineEntity.machineid}" method="post" >
        <input type="hidden" name="pageSize" value="${goodswaygoodspage.size}">
        <input type="hidden" name="pageCurrent" value="${goodswaygoodspage.number+1}">


        <div class="pageFormContent" data-layout-h="0">

            <table class="table table-condensed table-hover" width="100%">

                <tbody>
                <tr>
                    <td colspan="2">
                        <label class="control-label " style="width: 100px">售货机编号：</label>
                        ${tMachineEntity.machinenum}　
                    </td>
                    <td colspan="2">
                        <label class="control-label " style="width: 100px">型号：</label>
                        ${tMachineEntity.machinenum}
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <label class="control-label " style="width: 100px">制造商：</label>
                        ${tMachineEntity.machinenum}
                    </td>
                    <td colspan="2">
                        <label class="control-label " style="width: 100px">所在地址：</label>
                        ${tMachineEntity.machineplace}
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <label class="control-label " style="width: 100px">投产时间：</label>
                        ${tMachineEntity.producetime}
                    </td>
                    <td colspan="2">
                        <label class="control-label " style="width: 100px">是否支持广告：</label>
                        ${tMachineEntity.machinetype.adshow}
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <label class="control-label " style="width: 100px">是否温度控制：</label>
                        ${tMachineEntity.machinetype.temperaturecontrol}
                    </td>
                    <td colspan="2"></td>
                </tr>

                </tbody>
            </table>


            <div style="float: left;width: 100%;height: 5px;border-top: 1px solid #ddd;" ></div>

            <div style="float:left;width: 50%">
                <div style="float:left;min-height: 300px;width:100%;margin: 30px 10px 0px 10px;border: 1px solid #bbb">
                    <table  data-toggle="tablefixed" data-width="100%" data-nowrap="true">
                        <thead>
                        <tr>
                            <th class="th" >货道编号</th>
                            <th class="th">商品名称</th>
                            <th class="th">价格</th>
                            <th class="th">数量</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="list" items="${goodswaygoodspage.content}">
                            <tr>
                                <td class="th">货道${list.goodswaynum}</td>
                                <td class="th">${list.goods.goodsname}</td>
                                <td class="th">${list.machinegoodsentity.price}</td>
                                <td class="th">${list.goodsnum}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="bjui-pageFooter" style="position:static ;margin: 0px 10px 0px 10px;float: left;width: 100%">
                    <div class="pagination-box" style="float: right" data-toggle="pagination" data-total="${goodswaygoodspage.totalElements}" data-page-size="${goodswaygoodspage.size}" data-page-current="${goodswaygoodspage.number+1}">
                    </div>
                    <div class="pages"style="margin-right: 0px;margin-left: 0px; padding: 0px">
                        <span>共 ${goodswaygoodspage.totalElements} 条</span>
                    </div>
                </div>
            </div>
            <div style="float:right;right: 50%">
                <div style="float:right;min-height: 330px;width:400px;margin: 30px 10px 0px 10px;border: 1px solid #bbb">
                    <canvas id="lineChart" width="400" height="330"></canvas>
                </div>
            </div>
        </div>
    </form>
</div>

<script src="${pageContext.request.contextPath}/assets/js/chart.js"></script>
<script>

    var data = {
        labels : ["5月","6月","7月","8月"],
        datasets : [
            {
                lineItemName : "machine",
                fillColor : "rgba(151,187,205,0.5)",
                strokeColor : "rgba(151,187,205,1)",
                pointColor : "rgba(151,187,205,1)",
                pointStrokeColor : "#fff",
                data : [3,1,2,4]
            }
        ]
    };

    var chartLine = null;
    var ctx = document.getElementById("lineChart").getContext("2d");
    chartLine = new Chart(ctx).Line(data);
    initEvent(chartLine, clickCall);

    function clickCall(evt) {
        var point = chartLine.getPointSingleAtEvent(evt);

        if ( point !== null )
            alert( point.label + ": " + point.lineItemName + " ____ " + point.value);
    }

    function initEvent(chart, handler) {
        var method = handler;
        var eventType = "click";
        var node = chart.chart.canvas;

        if (node.addEventListener) {
            node.addEventListener(eventType, method);
        } else if (node.attachEvent) {
            node.attachEvent("on" + eventType, method);
        } else {
            node["on" + eventType] = method;
        }
    }
</script>
