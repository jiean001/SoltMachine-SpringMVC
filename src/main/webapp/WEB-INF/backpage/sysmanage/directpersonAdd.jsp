<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="bjui-pageContent">
    <form action="${pageContext.request.contextPath}/admin/directPerson/add" data-toggle="validate" data-reload-navtab="true">

        <div class="pageFormContent" data-layout-h="0">
            <table class="table table-condensed table-hover" width="100%">

                <tbody>
                <tr>
                    <td colspan="2">
                        <label class="control-label " style="width: 100px">*姓名：</label>
                        <input type='text' name="realname" value="${tBusinessmaninfoEntities.realname}"  data-rule="required"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <label class="control-label " style="width: 100px">*联系电话：</label>
                        <input type='text'name="phone"  value="${tBusinessmaninfoEntities.phone}"  data-rule="required"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <label class="control-label " style="width: 100px">*身份证号：</label>
                        <input type='text'name="idcard"  value="${tBusinessmaninfoEntities.idcard}" data-rule="required" />
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <label class="control-label " style="width: 100px">*登录账号：</label>
                        <input type='text'name="username"  value="${tUserinfoEntity.username}" data-rule="required"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <label class="control-label " style="width: 100px">初始密码：</label>
                        <input type='password' name="password"  value="${tUserinfoEntity.password}" data-rule="required" />
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <label class="control-label " style="width: 100px">*入职时间：</label>
                        <input type='text'name="jobtime"  value="${tBusinessmaninfoEntities.jobtime}" data-rule="required" />
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <label class="control-label " style="width: 100px">*角色：</label>
                        <input type='radio'name="rolename1"  value=2 onclick="GetSelectedVal(2)"/>系统管理员
                        <input type='radio'name="rolename1"  value=3 onclick="GetSelectedVal(3)"/>运营人员
                        <input type='radio'name="rolename1"  value=4 onclick="GetSelectedVal(4)"/>维护人员
                    </td>
                </tr>

                <td colspan="2">
                    <input type="hidden" name="roleid" id="roleid" value="${tRolesEntity.roleid}">
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



<script>
    function GetSelectedVal(val)
    {
        var roleput = document.getElementById("roleid")
        roleput.value=val;
    }
</script>




