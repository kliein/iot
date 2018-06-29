
<nav class="navbar  navbar-fixed-top" id="sidebar-wrapper" role="navigation">
    <ul class="nav sidebar-nav" style="float: left">
    <li class="sidebar-brand">
        <a href="#">
            物联网测试平台
        </a>
    </li>
    <#--<li>-->
        <#--<a href="/sell/seller/order/list"><i class="fa fa-fw fa-list-alt"></i> 测试</a>-->
    <#--</li>-->
    <li class="dropdown open">
        <#--<a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true"><i class="fa fa-fw fa-plus"></i> 商品 <span class="caret"></span></a>-->
        <ul class="dropdown-menu" role="menu">
            <li class="dropdown-header">测试管理</li>
            <li><a href="/iot/test/list">测试记录</a></li>
            <li><a href="/iot/test/explain">说明</a></li>
        </ul>
    </li>
    <li class="dropdown open">
        <#--<a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true"><i class="fa fa-fw fa-plus"></i> 类目 <span class="caret"></span></a>-->
        <ul class="dropdown-menu" role="menu">
            <li class="dropdown-header">设备管理</li>
            <li><a href="/iot/slave/list">设备列表</a></li>
            <li><a data-toggle="modal" data-target="#modal1" href="#">添加设备</a></li>
        </ul>
    </li>

    <li>
        <a href="/iot/admin/logout"><i class="fa fa-fw fa-list-alt"></i> 登出</a>
    </li>
</ul>
</nav>


<div class="modal fade" id="modal1" >
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h4 class="modal-title" id="myModalLabel">
                    添加设备
                </h4>
            </div>
            <div class="modal-body">
                <form class="form-group" action="/iot/slave/save" method="post">
                    <div class="form-group">
                        <label for="">设备ID</label>
                        <input name="slaveNumber" class="form-control" type="text" placeholder="用户自定义" autocomplete="off">
                    </div>
                    <div class="form-group">
                        <label for="">备注</label>
                        <input name="slaveRemark" class="form-control" type="text" placeholder="设备备注信息" autocomplete="off">
                    </div>
                    <div class="text-right">
                        <button class="btn btn-primary" type="submit">添加</button>
                        <button class="btn btn-danger" data-dismiss="modal">取消</button>
                    </div>
                </form>
            </div>
        </div>

    </div>
</div>