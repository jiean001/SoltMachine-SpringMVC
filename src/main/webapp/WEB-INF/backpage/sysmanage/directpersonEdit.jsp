<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="bjui-pageContent">
    <form id="form_lab" action="${pageContext.request.contextPath}/admin/directPerson/edit" data-toggle="validate" data-reload-navtab="true">
        <input type="hidden" name="businessmanid" value="${tBusinessmaninfoEntity.businessmanid}">
        <input type="hidden" name="businessid" value="${tBusinessmaninfoEntity.businessid}" >
        <input type="hidden" name="jobstate" value="${tBusinessmaninfoEntity.jobstate}" >
        <input type="hidden" name="userid" value="${userinfoEntity.userid}" >
        <input type="hidden" name="userrolesid" value="${tUserrolesEntity.userrolesid}" >
        <input type="hidden" name="valid" value="0">
        <div class="pageFormContent" data-layout-h="0">
            <table class="table table-condensed table-hover" width="100%">
                <tbody>
                <tr>
                    <td colspan="2">
                        <label class="control-label ">*姓名：</label>
                        <input type='text' name="realname" value="${tBusinessmaninfoEntity.realname}" data-rule="required" />　
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <label class="control-label ">*联系电话：</label>
                        <input type='text'name="phone"  value="${tBusinessmaninfoEntity.phone}"  data-rule="required"/>　
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <label class="control-label ">*身份证号：</label>
                        <input type='text'name="idcard"  value="${tBusinessmaninfoEntity.idcard}" data-rule="required" readonly/>　
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <label class="control-label ">*登录账号：</label>
                        <input type='text'name="username" readonly="true" value="${userinfoEntity.username}" data-rule="required" readonly/>　
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <label class="control-label ">*密码：</label>
                        <input type='password' name="password"  value="${userinfoEntity.password}" data-rule="required"/>　
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <label class="control-label ">*入职时间：</label>
                        <input type='text'name="jobtime" readonly="true" value="${tBusinessmaninfoEntity.jobtime}" data-rule="required" readonly/>　
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <label class="control-label ">*角色：</label>
                        <input type='radio'name="rolename1"  value=2  onclick="GetSelectedVal(2)" <c:if test="${tUserrolesEntity.roleid==2 }">checked="checked"</c:if>/>系统管理员
                        <input type='radio'name="rolename1"  value=3  onclick="GetSelectedVal(3)" <c:if test="${tUserrolesEntity.roleid==3 }">checked="checked"</c:if>/>运营人员
                        <input type='radio'name="rolename1"  value=4  onclick="GetSelectedVal(4)" <c:if test="${tUserrolesEntity.roleid==4 }">checked="checked"</c:if>/>维护人员
                    </td>
                </tr>
                <td colspan="2">
                    <input type="hidden" name="roleid" id="roleid" value="${tUserrolesEntity.roleid}">
                </td>
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

<script>
    function GetSelectedVal(val)
    {
        var roleput = document.getElementById("roleid")
        roleput.value=val;
    }
</script>




