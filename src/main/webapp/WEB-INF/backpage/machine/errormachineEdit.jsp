<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="bjui-pageContent">


        <div class="pageFormContent" data-layout-h="0">
            <table class="table table-condensed table-hover" width="100%">
                <tbody>
                <tr>
                    <td colspan="2">
                        <label class="control-label ">* 设备编号：</label>
                        <input type='text' name="machinenum" readonly="true" value="${machine.machinenum}" data-rule="required" />　
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <label class="control-label ">*设备型号：</label>
                        <input type='text' name="machinetype" readonly="true" value="${machine.machinetype.machinetype}" />　
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <label class="control-label ">*制造商：</label>
                        <input type='text' name="manufacturer" readonly="true" value="${machine.manufacturer}" data-rule="required"/>　
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <label class="control-label ">*所在地址：</label>
                        <input type='text' name="machineplace" readonly="true" value="${machine.machineplace}" data-rule="required"/>　
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <label class="control-label ">*故障原因：</label>
                        <input type='text' name="faultcode" readonly="true" value="${fault.faultcode}" data-rule="required"/>　
                    </td>
                </tr>
                <form id="form_lab" action="${pageContext.request.contextPath}/admin/errormachine/edit" data-toggle="validate" data-reload-navtab="true">
                    <input type="hidden" name="machineid" value="${machine.machineid}" >
                    <input type="hidden" name="faultid" value="${fault.faultid}" >
                    <input type="hidden" name="valid" value="0">
                <tr>
                    <td colspan="2">
                        <label class="control-label ">*维修员：</label>
                        <input type='text' name="repairman"  value="${fault.repairman}" data-rule="required"/>　
                    </td>
                </tr>
                </form>
                </tbody>
            </table>
        </div>
</div>
<div class="bjui-pageFooter">
    <ul>
        <li><button type="button" class="btn-close" data-icon="close">关闭</button></li>
        <li><button type="submit" class="btn-default" data-icon="save">保存</button></li>
    </ul>
</div>






