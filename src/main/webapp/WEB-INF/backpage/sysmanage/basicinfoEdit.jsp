<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="bjui-pageContent">
    <form id="form_lab" action="${pageContext.request.contextPath}/admin/directBusiness/edit" data-toggle="validate" data-reload-navtab="true">
        <input type="hidden" name="businessid" value="${businessinfoEntity.businessid}" >
        <input type="hidden" name="userid" value="${userinfoEntity.userid}" >
        <input type="hidden" name="valid" value="0">
        <input type="hidden" name="fatherbusinessid" value="${businessinfoEntity.fatherbusinessid}">
        <div class="pageFormContent" data-layout-h="0">
            <table class="table table-condensed table-hover" width="100%">
                <tbody>
                <tr>
                    <td align="right">
                        <label class="control-label ">*运营商名称：</label>
                    </td><td>
                    <input type='text' name="businessname" value="${businessinfoEntity.businessname}" data-rule="required" readonly/>　
                </td>
                </tr>
                <tr>
                    <td align="right">
                        <label class="control-label ">*地&nbsp;&nbsp;&nbsp;&nbsp;址：</label>
                    </td><td>
                    <input type='text'name="address"  value="${businessinfoEntity.address}"  data-rule="required"/>　
                </td>
                </tr>
                <tr>
                    <td align="right">
                        <label class="control-label ">*统一信用代码：</label>
                    </td><td>
                    <input type='text'name="creditcode"  value="${businessinfoEntity.creditcode}" data-rule="required" readonly/>　
                </td>
                </tr>
                <tr>
                    <td align="right">
                        <label class="control-label ">*地理范围：</label>
                    </td><td>
                    <input type='text'name="area"  value="${businessinfoEntity.area}" data-rule="required"/>　
                </td>
                </tr>
                <tr>
                    <td align="right">
                        <label class="control-label ">*联系人：</label>
                    </td><td>
                    <input type='text'name="contacts"  value="${businessinfoEntity.contacts}" data-rule="required"/>　
                </td>
                </tr>
                <tr>
                    <td align="right">
                        <label class="control-label ">*联系电话：</label>
                    </td><td>
                    <input type='text'name="phone"  value="${businessinfoEntity.phone}" data-rule="required"/>　
                </td>
                </tr>
                <tr>
                    <td  align="right">
                        <label class="control-label ">*运营商账号：</label>
                    </td><td>
                    <input type='text'name="username"  value="${userinfoEntity.username}" data-rule="required" readonly/>　
                </td>
                </tr>
                <tr>
                    <td align="right">
                        <label class="control-label ">*运营商账户密码：</label>
                    </td><td>
                    <input type='password' name="password"  value="${userinfoEntity.password}" data-rule="required"/>　
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






