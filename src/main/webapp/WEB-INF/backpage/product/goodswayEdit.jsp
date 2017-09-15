<%@ page import="java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="bjui-pageContent">
    <form id="form_lab" action="${pageContext.request.contextPath}/admin/goodsway/edit" data-toggle="validate" data-reload-navtab="true">
        <input type="hidden" name="goodswaygoodsid" value="${goodswayEntity.goodswaygoodsid}" >
        <input type="hidden" name="valid" value="0">
        <input type='hidden' name="machineid" value="${goodswayEntity.machineid}" readonly />
        <div class="pageFormContent" data-layout-h="0">
            <table class="table table-condensed table-hover" width="100%">
                <tbody>
                <tr>
                    <td width="10%" align="right">
                        <label class="control-label " style="width: 100px">*货道编号：</label>
                    </td><td>
                    <input type='text' value="货道${goodswayEntity.goodswaynum}" readonly />
                    <input type='hidden' name="goodswaynum" value="${goodswayEntity.goodswaynum}" />
                </td>
                </tr>
                <tr>
                    <td>
                        <label class="control-label " style="width: 100px">*商品名称：</label>
                    </td><td>
                    <input type='text' value="${goodswayEntity.goods.goodsname}" readonly />
                    <input type='hidden' name="goodsid" value="${goodswayEntity.goods.goodsid}" />
                </td>
                </tr>
                <tr>
                    <td >
                        <label class="control-label " style="width: 100px">*数量：</label>
                    </td><td>
                        <input type='text' name="goodsnum"  value="${goodswayEntity.goodsnum}" data-rule="number;required;" />
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </form>
</div>
<div class="bjui-pageFooter">
    <ul>
        <li><button type="button" class="btn-close" data-icon="close">关闭</button></li>
        <li><button type="submit" class="btn-default" data-icon="save">保存</button></li>
    </ul>
</div>




