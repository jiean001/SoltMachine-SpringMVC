<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="bjui-pageContent">
    <form action="${pageContext.request.contextPath}/admin/machine/add" data-toggle="validate" data-reload-navtab="true">

        <div class="pageFormContent" data-layout-h="0">
            <table class="table table-condensed table-hover" width="100%">

                <tbody>
                <tr>
                    <td colspan="2">
                        <label class="control-label ">*售后机编号：</label>
                        <input type='text' name="machinenum" value="${tMachineEntity.machinenum}" data-rule="required" />　
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <label class="control-label ">*所在地址：</label>
                        <input type='text'name="machineplace"  value="${tMachineEntity.machineplace}" data-rule="required"/>　
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <label class="control-label ">*投产时间：</label>
                        <input type='text'name="producetime"  value="${tMachineEntity.producetime}" data-rule="required"/>　
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




