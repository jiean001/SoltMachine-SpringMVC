<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="bjui-pageContent">
    <form action="${pageContext.request.contextPath}/admin/directBusiness/add" data-toggle="validate" data-reload-navtab="true">

        <div class="pageFormContent" data-layout-h="0">
            <table class="table table-condensed table-hover" width="100%">

                <tbody>
                <tr>
                    <td colspan="2">
                        <label class="control-label " style="width: 100px">*运营商名称：</label>
                        <input type='text' name="businessname" value="${businessinfoEntity.businessname}"  data-rule="required;remote[${pageContext.request.contextPath}/admin/directBusiness/checkAccount]"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <label class="control-label " style="width: 100px">*地&nbsp;&nbsp;&nbsp;&nbsp;址：</label>
                        <input type='text'name="address"  value="${businessinfoEntity.address}"  data-rule="required"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <label class="control-label " style="width: 100px">*统一信用代码：</label>
                        <input type='text'name="creditcode"  value="${businessinfoEntity.creditcode}" data-rule="required" />
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <label class="control-label " style="width: 100px">*地理范围：</label>
                        <input type='text'name="area"  value="${businessinfoEntity.area}" data-rule="required" />
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <label class="control-label " style="width: 100px">*联系人：</label>
                        <input type='text'name="contacts"  value="${businessinfoEntity.contacts}" data-rule="required"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <label class="control-label " style="width: 100px">联系电话：</label>
                        <input type='text'name="phone"  value="${businessinfoEntity.phone}" data-rule="required" />
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <label class="control-label " style="width: 100px">*运营商账号：</label>
                        <input type='text'name="username"  value="${tUserinfoEntity.username}" data-rule="required" />
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <label class="control-label " style="width: 100px">*初始密码：</label>
                        <input type='password' name="password"  value="${tUserinfoEntity.password}"  data-rule="required"/>
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




