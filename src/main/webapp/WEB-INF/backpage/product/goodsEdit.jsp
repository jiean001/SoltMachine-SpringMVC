<%@ page import="java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="bjui-pageContent">
    <form id="form_lab" action="${pageContext.request.contextPath}/admin/goods/edit" data-toggle="validate" data-reload-navtab="true">
        <input type="hidden" name="goodsid" value="${goodsEntity.goodsid}" >
        <input type="hidden" name="valid" value="0">
        <div class="pageFormContent" data-layout-h="0">
            <table class="table table-condensed table-hover" width="100%">
                <tbody>
                <tr>
                    <td width="10%" align="right">
                        <label class="control-label " style="width: 100px">*商品名称：</label>
                    </td><td>
                    <input type='text' name="goodsname" data-rule="required;" value="${goodsEntity.goodsname}" readonly />
                </td>
                </tr>
                <tr>
                    <td>
                        <label class="control-label " style="width: 100px">*商品类别：</label>
                    </td><td>
                    <select data-toggle="selectpicker" class="show-tick" style="display: none;" name="goodskindid" data-rule="required;">
                        <c:forEach var="kind" items="${kindentitys}">
                            <option value="${kind.goodskindid}" <c:if test="${goodsEntity.goodskind.goodskindid == kind.goodskindid}"> selected </c:if> > ${kind.goodskind}</option>
                        </c:forEach>
                    </select>
                </td>
                </tr>
                <tr>
                    <td >
                        <label class="control-label " style="width: 100px">*商品积分：</label>
                    </td><td>
                        <input type='text' name="goodsscore"  value="${goodsEntity.goodsscore}" data-rule="number;required;" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="control-label " style="width: 100px">&nbsp;&nbsp;商品简介：</label>
                    </td><td>
                    <textarea name="goodsintroduction"  style="width:300px;height: 100px" data-toggle="autoheight">${goodsEntity.goodsintroduction}</textarea>
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




