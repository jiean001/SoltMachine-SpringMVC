<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="bjui-pageContent">
    <div class="pageFormContent" data-layout-h="0">
            <table class="table table-condensed table-hover" width="100%">
                <tbody>
                <tr>
                    <td align="right">
                        <label class="control-label ">*运营商名称：</label>
                        </td><td>
                       ${businessinfoEntity.businessname}
                    </td>
                </tr>
                <tr>
                    <td align="right">
                        <label class="control-label ">*地&nbsp;&nbsp;&nbsp;&nbsp;址：</label>
                    </td><td>
                       ${businessinfoEntity.address}　
                    </td>
                </tr>
                <tr>
                    <td align="right">
                        <label class="control-label ">*统一信用代码：</label>
                    </td><td>
                       ${businessinfoEntity.creditcode}
                    </td>
                </tr>
                <tr>
                    <td align="right">
                        <label class="control-label ">*地理范围：</label>
                    </td><td>
                       ${businessinfoEntity.area}
                    </td>
                </tr>
                <tr>
                    <td align="right">
                        <label class="control-label ">*联系人：</label>
                    </td><td>
                      ${businessinfoEntity.contacts}　
                    </td>
                </tr>
                <tr>
                    <td align="right">
                        <label class="control-label ">*联系电话：</label>
                    </td><td>
                       ${businessinfoEntity.phone}
                    </td>
                </tr>
                <tr>
                    <td align="right">
                        <label class="control-label ">*运营商账号：</label>
                    </td><td>
                      ${userinfoEntity.username}
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
</div>
<div class="bjui-pageFooter">
    <ul>

        <li>
            <button type="button" class="btn btn-default"
                    data-url="${pageContext.request.contextPath}/admin/basicInfo/basicPage?type=2"
                    data-toggle="navtab" data-id="working_0" data-title="基本信息管理" style="margin:2px;">维护
            </button></li>
    </ul>
</div>






