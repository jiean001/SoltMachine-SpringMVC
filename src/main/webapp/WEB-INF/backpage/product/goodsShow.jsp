<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="bjui-pageContent">
    <form id="form_lab" action="${pageContext.request.contextPath}/admin/goods/edit" data-toggle="validate" data-reload-navtab="true">
        <input type="hidden" name="goodsid" value="${labentity.goodsid}" >
        <input type="hidden" name="isvalid" value="0">
        <div class="pageFormContent" data-layout-h="0">
            <table class="table table-condensed table-hover" width="100%">
                <tbody>
                <tr>
                    <td width="10%" align="right">
                        <label class="control-label " style="width: 100px">商品名称：</label>
                    </td><td>
                    ${goodsentity.goodsname}
                </td>
                </tr>
                <tr>
                    <td>
                        <label class="control-label " style="width: 100px">商品类别：</label>
                    </td><td>
                    ${goodsentity.goodskind.goodskind}
                </td>
                </tr>
                <tr>
                    <td >
                        <label class="control-label " style="width: 100px">商品积分：</label>
                    </td><td>
                     ${goodsentity.goodsscore}
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="control-label " style="width: 100px">商品简介：</label>
                    </td><td>
                   ${goodsentity.goodsintroduction}
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
    </ul>
</div>




