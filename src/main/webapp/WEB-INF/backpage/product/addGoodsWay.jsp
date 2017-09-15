<%@ page import="java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="bjui-pageContent">
    <form action="${pageContext.request.contextPath}/admin/goodsway/addGoodsWay" data-toggle="validate" data-reload-navtab="true">

        <div class="pageFormContent" data-layout-h="0">
            <table class="table table-condensed table-hover" width="100%">

                <tbody>
                <tr>
                    <td width="10%" align="right">
                        <label class="control-label " style="width: 100px">*商品名称：</label>
                    </td>
                    <td>
                        <select data-toggle="selectpicker" class="show-tick" style="display: none;" name="goodsid"
                                data-rule="required;">
                            <option value="">请选择</option>
                            <c:forEach var="goodsinfoEntitys" items="${goodsinfoEntitys}">
                                <option value="${goodsinfoEntitys.goodsid}"> ${goodsinfoEntitys.goodsname}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="control-label " style="width: 100px">*价格（元）：</label>
                    </td>
                    <td>
                        <input type='text' name="price" data-rule="number;required;"/>
                        <input type='hidden' name="machineid" value="${machineid}"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="control-label " style="width: 100px">*货道编号：</label>
                    </td>
                    <td>
                        <c:forEach var="goodswaynum" items="${goodswaynum}" varStatus="status">
                            <input name="goodswaynum" type="checkbox" value="${goodswaynum}"
                                   data-rule="required;"/>货道${goodswaynum}&nbsp;&nbsp;&nbsp;&nbsp;
                            <c:if test="${ (status.index+1) % 3 == 0}"><br/></c:if>
                        </c:forEach>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </form>
</div>
<div class="bjui-pageFooter">
    <ul>
        <li>
            <button type="button" class="btn-close" data-icon="close">关闭</button>
        </li>
        <li>
            <button type="submit" class="btn-default" data-icon="save">保存</button>
        </li>
    </ul>
</div>




