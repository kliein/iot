<html>
<head>
    <meta charset="utf-8">
    <title>系统登录</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">
    <link href="/iot/css/login.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-offset-3 col-md-6">
            <form class="form-horizontal" action="/iot/admin/save" method="post">
                <span class="heading">测试平台登录</span>
                <div class="form-group">
                    <input name="userName" type="text" class="form-control" id="inputEmail3" placeholder="用户名或电子邮件">
                    <i class="fa fa-user"></i>
                </div>
                <div class="form-group help">
                    <input name="passWord" type="password" class="form-control" id="inputPassword3" placeholder="密　码">
                    <i class="fa fa-lock"></i>
                    <a href="#" class="fa fa-question-circle"></a>
                </div>

                <div class="form-group">
                    <div class="main-checkbox">
                        <input type="checkbox" value="None" id="checkbox1" name="check"/>
                        <label for="checkbox1"></label>
                    </div>
                    <span class="text">记住密码</span>
                    <a data-toggle="modal" data-target="#register" type="button" class="btn btn-default btn-primary">注册测试账号</a>
                    <button type="submit" class="btn btn-default form-group">登 录</button>

                </div>
            </form>
        </div>
    </div>
</div>

<div class="modal fade" id="register" >
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h4 class="modal-title" id="myModalLabel">
                    注册账号申请
                </h4>
            </div>
            <div class="modal-body">
                                     <form class="form-group" action="/iot/admin/register" method="post">
                                             <div class="form-group">
                                                 <label for="">用户名</label>
                                                 <input name="userName" class="form-control" type="text" placeholder="6-15位字母或数字" autocomplete="off">
                                             </div>
                                             <div class="form-group">
                                                 <label for="">密码</label>
                                                 <input name="passWord" class="form-control" type="password" placeholder="至少6位字母或数字">
                                             </div>
                                             <div class="form-group">
                                                 <label for="">再次输入密码</label>
                                                 <input class="form-control" type="password" placeholder="至少6位字母或数字">
                                             </div>
                                             <div class="form-group">
                                                 <label for="">授权码</label>
                                                 <input name="serialNumber" class="form-control" type="text" placeholder="请联系本公司客服获取" autocomplete="off">
                                             </div>
                                             <div class="text-right">
                                                 <button class="btn btn-primary" type="submit">提交</button>
                                                 <button class="btn btn-danger" data-dismiss="modal">取消</button>
                                             </div>
                                             <a href="" data-toggle="modal" data-dismiss="modal" data-target="#login">已有账号？点我登录</a>
                                     </form>
                                 </div>
        </div>

    </div>
</div>
</body>
</html>