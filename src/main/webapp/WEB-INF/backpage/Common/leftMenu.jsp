<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="bjui-leftside">
    <div id="bjui-sidebar-s">
        <div class="collapse"></div>
    </div>
    <div id="bjui-sidebar">
        <div class="toggleCollapse"><h2><i class="fa fa-bars"></i> 导航栏 <i class="fa fa-bars"></i></h2><a href="javascript:;" class="lock"><i class="fa fa-lock"></i></a></div>
        <div class="panel-group panel-main" data-toggle="accordion" id="bjui-accordionmenu" data-heightbox="#bjui-sidebar" data-offsety="26">
            <div class="panel panel-default">
            <%
                String role = session.getAttribute("role").toString();
                if(role.indexOf("1")>-1){
            %>
            <div class="panel-heading panelContent">
                <h4 class="panel-title"><a data-toggle="collapse" data-parent="#bjui-accordionmenu" href="#bjui-collapse1" class=""><i class="fa fa-caret-square-o-down"></i>&nbsp;系统管理</a></h4>
            </div>
            <div id="bjui-collapse1" class="panel-collapse panelContent collapse">
                <div class="panel-body" >
                    <ul id="bjui-tree0" class="ztree ztree_main" data-toggle="ztree" data-on-click="MainMenuClick" data-expand-all="true">
                        <li data-id="working_0"  data-url="<%=request.getContextPath()%>/admin/directBusiness/listByPage" data-tabid="working_0" data-fresh="true" data-reloadWarn="true">顶层运营商管理</li>
                    </ul>
                </div>
            </div>
            <%
            }else if(role.indexOf("2")>-1){
            %>
            <div class="panel-heading panelContent">
                <h4 class="panel-title"><a data-toggle="collapse" data-parent="#bjui-accordionmenu" href="#bjui-collapse2" class=""><i class="fa fa-caret-square-o-down"></i>&nbsp;系统管理</a></h4>
            </div>
            <div id="bjui-collapse2" class="panel-collapse panelContent collapse">
                <div class="panel-body" >
                    <ul id="bjui-tree1" class="ztree ztree_main" data-toggle="ztree" data-on-click="MainMenuClick" data-expand-all="true">
                        <li data-id="working_0"  data-url="<%=request.getContextPath()%>/admin/basicInfo/basicPage?type=1" data-tabid="working_0" data-fresh="true" data-reloadWarn="true">基本信息管理</li>
                        <li data-id="working_0"  data-url="<%=request.getContextPath()%>/admin/directPerson/listByPage" data-tabid="working_0" data-fresh="true" data-reloadWarn="true">直属人员管理</li>
                        <li data-id="working_0"  data-url="<%=request.getContextPath()%>/admin/directBusiness/listByPage" data-tabid="working_0" data-fresh="true" data-reloadWarn="true">直属运营商管理</li>
                    </ul>
                </div>
            </div>
            <div class="panel-heading panelContent">
                <h4 class="panel-title"><a data-toggle="collapse" data-parent="#bjui-accordionmenu" href="#bjui-collapse3" class=""><i class="fa fa-caret-square-o-down"></i>&nbsp;商品管理</a></h4>
            </div>
            <div id="bjui-collapse3" class="panel-collapse panelContent collapse">
                <div class="panel-body" >
                    <ul id="bjui-tree2" class="ztree ztree_main" data-toggle="ztree" data-on-click="MainMenuClick" data-expand-all="true">
                        <li data-id="working_0"  data-url="<%=request.getContextPath()%>/admin/kind/listByPage" data-tabid="working_0" data-fresh="true" data-reloadWarn="true">商品类别信息管理</li>
                        <li data-id="working_0"  data-url="<%=request.getContextPath()%>/admin/goods/listByPage" data-tabid="working_0" data-fresh="true" data-reloadWarn="true">商品信息管理</li>
                    </ul>
                </div>
            </div>

            <div class="panel-heading panelContent">
                <h4 class="panel-title"><a data-toggle="collapse" data-parent="#bjui-accordionmenu" href="#bjui-collapse4" class=""><i class="fa fa-caret-square-o-down"></i>&nbsp;售货机管理</a></h4>
            </div>
            <div id="bjui-collapse4" class="panel-collapse panelContent collapse">
                <div class="panel-body" >
                    <ul id="bjui-tree3" class="ztree ztree_main" data-toggle="ztree" data-on-click="MainMenuClick" data-expand-all="true">
                        <li data-id="working_0"   data-tabid="working_0" data-url="<%=request.getContextPath()%>/admin/machine/listByPage" data-fresh="true" data-reloadWarn="true">售货机信息管理</li>
                        <li data-id="working_0"  data-url="<%=request.getContextPath()%>/admin/goodsway/listByPage?type=1" data-tabid="working_0" data-fresh="true" data-reloadWarn="true">售货机货道管理</li>
                        <li data-id="working_0"  data-url="<%=request.getContextPath()%>/admin/goodsway/listByPage?type=2" data-tabid="working_0" data-fresh="true" data-reloadWarn="true">售货机补货</li>
                        <li data-id="working_0"   data-tabid="working_0" data-url="<%=request.getContextPath()%>/admin/errormachine/listByPage" data-fresh="true" data-reloadWarn="true">售货机故障管理</li>
                    </ul>
                </div>
            </div>

            <div class="panel-heading panelContent">
                <h4 class="panel-title"><a data-toggle="collapse" data-parent="#bjui-accordionmenu" href="#bjui-collapse5" class=""><i class="fa fa-caret-square-o-down"></i>&nbsp;综合查询</a></h4>
            </div>
            <div id="bjui-collapse5" class="panel-collapse panelContent collapse">
                <div class="panel-body" >
                    <ul id="bjui-tree10" class="ztree ztree_main" data-toggle="ztree" data-on-click="MainMenuClick" data-expand-all="true">
                        <li data-id="working_0" data-tabid="working_0" data-url="<%=request.getContextPath()%>/admin/query/listByPage" data-fresh="true" data-reloadWarn="true">售货机信息综合查询</li>
                        <li data-id="working_0" data-tabid="working_0" data-url="<%=request.getContextPath()%>/admin/query/salesStatic?type=2" data-fresh="true" data-reloadWarn="true">销售信息综合查询</li>
                    </ul>
                </div>
            </div>
            <%
            }else if(role.indexOf("3")>-1){
            %>
            <div class="panel-heading panelContent">
                <h4 class="panel-title"><a data-toggle="collapse" data-parent="#bjui-accordionmenu" href="#bjui-collapse6" class=""><i class="fa fa-caret-square-o-down"></i>&nbsp;商品管理</a></h4>
            </div>
            <div id="bjui-collapse6" class="panel-collapse panelContent collapse">
                <div class="panel-body" >
                    <ul id="bjui-tree12" class="ztree ztree_main" data-toggle="ztree" data-on-click="MainMenuClick" data-expand-all="true">
                        <li data-id="working_0"  data-url="<%=request.getContextPath()%>/admin/kind/listByPage" data-tabid="working_0" data-fresh="true" data-reloadWarn="true">商品类别信息管理</li>
                        <li data-id="working_0"  data-url="<%=request.getContextPath()%>/admin/goods/listByPage" data-tabid="working_0" data-fresh="true" data-reloadWarn="true">商品信息管理</li>
                    </ul>
                </div>
            </div>

            <div class="panel-heading panelContent">
                <h4 class="panel-title"><a data-toggle="collapse" data-parent="#bjui-accordionmenu" href="#bjui-collapse7" class=""><i class="fa fa-caret-square-o-down"></i>&nbsp;售货机管理</a></h4>
            </div>
            <div id="bjui-collapse7" class="panel-collapse panelContent collapse">
                <div class="panel-body" >
                    <ul id="bjui-tree13" class="ztree ztree_main" data-toggle="ztree" data-on-click="MainMenuClick" data-expand-all="true">
                        <li data-id="working_0"   data-tabid="working_0" data-url="<%=request.getContextPath()%>/admin/machine/listByPage" data-fresh="true" data-reloadWarn="true">售货机信息管理</li>
                        <li data-id="working_0"  data-url="<%=request.getContextPath()%>/admin/goodsway/listByPage?type=1" data-tabid="working_0" data-fresh="true" data-reloadWarn="true">售货机货道管理</li>
                    </ul>
                </div>
            </div>

            <div class="panel-heading panelContent">
                <h4 class="panel-title"><a data-toggle="collapse" data-parent="#bjui-accordionmenu" href="#bjui-collapse8" class=""><i class="fa fa-caret-square-o-down"></i>&nbsp;综合查询</a></h4>
            </div>
            <div id="bjui-collapse8" class="panel-collapse panelContent collapse">
                <div class="panel-body" >
                    <ul id="bjui-tree14" class="ztree ztree_main" data-toggle="ztree" data-on-click="MainMenuClick" data-expand-all="true">
                        <li data-id="working_0" data-tabid="working_0" data-url="<%=request.getContextPath()%>/admin/query/listByPage" data-fresh="true" data-reloadWarn="true">售货机信息综合查询</li>
                        <li data-id="working_0" data-tabid="working_0" data-url="<%=request.getContextPath()%>/admin/query/salesStatic?type=2" data-fresh="true" data-reloadWarn="true">销售信息综合查询</li>
                    </ul>
                </div>
            </div>
            <%
            }else if(role.indexOf("4")>-1){
            %>
            <div class="panel-heading panelContent">
                <h4 class="panel-title"><a data-toggle="collapse" data-parent="#bjui-accordionmenu" href="#bjui-collapse9" class=""><i class="fa fa-caret-square-o-down"></i>&nbsp;售货机管理</a></h4>
            </div>
            <div id="bjui-collapse9" class="panel-collapse panelContent collapse">
                <div class="panel-body" >
                    <ul id="bjui-tree23" class="ztree ztree_main" data-toggle="ztree" data-on-click="MainMenuClick" data-expand-all="true">
                        <li data-id="working_0"  data-url="<%=request.getContextPath()%>/admin/goodsway/listByPage?type=2" data-tabid="working_0" data-fresh="true" data-reloadWarn="true">售货机补货</li>
                        <li data-id="working_0"   data-tabid="working_0" data-url="<%=request.getContextPath()%>/admin/errormachine/listByPage" data-fresh="true" data-reloadWarn="true">售货机故障管理</li>
                    </ul>
                </div>
            </div>
            <%
                }
            %>
        </div>
        </div>
    </div>
</div>