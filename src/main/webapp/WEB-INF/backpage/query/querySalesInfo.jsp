<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<div class="pageFormContent">
    <div style="float: right;width: 100%;margin-top: 30px;padding-left:2%;" >
        <select data-toggle="selectpicker" class="show-tick" name="goodskindid" data-rule="required;" >
            <option value="1" selected>当前周</option>
            <option value="2" selected>当前月份</option>
            <option value="3">当前季度</option>
            <option value="4">当前年份</option>
        </select>
        <input type='button' class="btn btn-red"  value="统计" style="margin-left:20px;"/>
    </div>


    <div style="float:left;width: 50%;padding-left: 2%;padding-right: 2%">

        <label style="float: left;width: 100px; font-size: 14px;margin-top: 30px;">机器销量排行榜</label>
        <input type='button' class="btn btn-default" onclick="showmachinetable()" value="列表" id="machinetablebtn" style="display: block;float: right; margin-top: 25px;"/>
        <input type='button' class="btn btn-default" onclick="showmachinebar()" value="柱状图" id="machinebarbtn" style="display: none;float: right; margin-top: 25px;"/>　

        <div style="float:left;min-height: 450px;width:100%;margin-top: 30px;border: 1px solid #bbb">
            <div id="machinebar" style="display: block">
                <canvas id="barChart" width="500" height="400" style="margin: 20px;"></canvas>
            </div>
            <div id="machinetable" style="display: none">
                <table data-toggle="tablefixed" data-nowrap="true" width="500">
                    <thead>
                    <tr>
                        <th class="th" >设备编号</th>
                        <th class="th">销量</th>
                        <th class="th" width="200">所在地址</th>
                    </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td class="th">104978321</td>
                            <td class="th">5</td>
                            <td class="th">湖北省武汉市江汉区中山大道326号</td>
                        </tr>
                        <tr>
                            <td class="th">104978332</td>
                            <td class="th">5</td>
                            <td class="th">湖北省武汉市江汉区中山大道312号</td>
                        </tr>
                        <tr>
                            <td class="th">104978344</td>
                            <td class="th">3</td>
                            <td class="th">湖北省武汉市江汉区中山大道303号</td>
                        </tr>
                        <tr>
                            <td class="th">104978335</td>
                            <td class="th">2</td>
                            <td class="th">湖北省武汉市江汉区中山大道125号</td>
                        </tr>
                        <tr>
                            <td class="th">104978323</td>
                            <td class="th">1</td>
                            <td class="th">湖北省武汉市江汉区中山大道106号</td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <div style="float:left;width: 50%;padding-left: 2%;padding-right: 2%">

        <label style="float: left;width: 100px; font-size: 14px;margin-top: 30px;">商品销量排行榜</label>
        <input type='button' class="btn btn-default" onclick="showsaletable()"  value="列表" id="saletablebtn" style="display: block;float: right; margin-top: 25px;"/>
        <input type='button' class="btn btn-default" onclick="showsalepie()"  value="饼状图" id="salepiebtn" style="display: none;float: right; margin-top: 25px;"/>　

        <div style="float:left;min-height: 450px;width:100%;margin-top: 30px;border: 1px solid #bbb">
            <div id="salepie" style="display: block">
                <canvas id="pieChart" width="500" height="400" style="margin: 20px;"></canvas>
             </div>
            <div id="saletable" style="display: none">
                <table  data-toggle="tablefixed" data-nowrap="true"  width="500">
                    <thead>
                    <tr>
                        <th class="th"  width="200">商品名称</th>
                        <th class="th">商品类别</th>
                        <th class="th">销量</th>
                    </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td class="th">蒙牛 纯甄常温酸牛奶200g</td>
                            <td class="th">酸奶</td>
                            <td class="th">5</td>
                        </tr>
                        <tr>
                            <td class="th">农夫山泉 矿泉水 500ml</td>
                            <td class="th">矿泉水</td>
                            <td class="th">3</td>
                        </tr>
                        <tr>
                            <td class="th">昆仑山 雪山矿泉水 510ml</td>
                            <td class="th">矿泉水</td>
                            <td class="th">3</td>
                        </tr>
                        <tr>
                            <td class="th">蒙牛红枣口味早餐奶250ml</td>
                            <td class="th">牛奶</td>
                            <td class="th">2</td>
                        </tr>
                        <tr>
                            <td class="th">安慕希希腊风味酸奶 原味 205g</td>
                            <td class="th">酸奶</td>
                            <td class="th">1</td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>


    </div>
</div>

<script src="${pageContext.request.contextPath}/assets/js/chart.js"></script>
<script>
    var databar = {
        labels : ["104978321","104978332","104978344","104978335","104978323"],
        datasets : [
            {
                barItemName: "machinelist",
                fillColor : "rgba(151,187,205,0.5)",
                strokeColor : "rgba(151,187,205,1)",
                data : [5,5,3,2,1]
            }
        ]
    };

    var datapie = [
        {
            label: "蒙牛 纯甄常温酸牛奶200g",
            value : 5,
            color : "#F7464A"
        },
        {
            label: "农夫山泉 矿泉水 500ml",
            value: 3,
            color:"#F38630"
        },
        {
            label: "昆仑山 雪山矿泉水 510ml",
            value : 3,
            color : "#E0E4CC"
        },
        {
            label: "蒙牛红枣口味早餐奶250ml",
            value : 2,
            color : "#69D2E7"
        },
        {
            label: "安慕希希腊风味酸奶 原味 205g",
            value : 1,
            color : "#D4CCC5"
        }
    ];

    var chartBar = null;
    var chartPie = null;

    var ctx = document.getElementById("barChart").getContext("2d");
    chartBar = new Chart(ctx).Bar(databar);
    initEvent(chartBar, barclickCall);
    var ctx = document.getElementById("pieChart").getContext("2d");
    chartPie = new Chart(ctx).Pie(datapie, {segmentShowStroke : false, showTooltips : 1});
    initEvent(chartPie, pieclickCall);

    function barclickCall(evt){
        var activeBar = chartBar.getBarSingleAtEvent(evt);
        if ( activeBar !== null )
            alert(activeBar.label + ": " + activeBar.barItemName + " ____ " + activeBar.value);
    }

    function pieclickCall(evt) {
        var segments = chartPie.getSegmentsAtEvent(evt);

        if ( segments.length > 0 ) {
            var segment = segments[0];
            alert( segment.label + ": " + segment.value);
        }
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

    function showmachinebar(){
        var machinebarbtn = document.getElementById("machinebarbtn");
        var machinetablebtn = document.getElementById("machinetablebtn");
        var machinebar = document.getElementById("machinebar");
        var machinetable = document.getElementById("machinetable");
        machinebarbtn.style.display = "none";
        machinetablebtn.style.display = "block";
        machinebar.style.display = "block";
        machinetable.style.display = "none";
    }

    function showmachinetable(){
        var machinebarbtn = document.getElementById("machinebarbtn");
        var machinetablebtn = document.getElementById("machinetablebtn");
        var machinebar = document.getElementById("machinebar");
        var machinetable = document.getElementById("machinetable");
        machinebarbtn.style.display = "block";
        machinetablebtn.style.display = "none";
        machinebar.style.display = "none";
        machinetable.style.display = "block";
    }

    function showsalepie(){
        var saletablebtn = document.getElementById("saletablebtn");
        var salepiebtn = document.getElementById("salepiebtn");
        var salepie = document.getElementById("salepie");
        var saletable = document.getElementById("saletable");
        saletablebtn.style.display = "block";
        salepiebtn.style.display = "none";
        salepie.style.display = "block";
        saletable.style.display = "none";
    }

    function showsaletable(){
        var saletablebtn = document.getElementById("saletablebtn");
        var salepiebtn = document.getElementById("salepiebtn");
        var salepie = document.getElementById("salepie");
        var saletable = document.getElementById("saletable");
        saletablebtn.style.display = "none";
        salepiebtn.style.display = "block";
        salepie.style.display = "none";
        saletable.style.display = "block";
    }


</script>
