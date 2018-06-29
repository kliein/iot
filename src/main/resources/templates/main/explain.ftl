<html>
    <#include "../common/header.ftl">
<style>


</style>
<body>

<div id="wrapper" class="toggled">
    <nav class="navbar navbar-default navbar-fixed-top " role="navigation">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">物联网测试平台</a>
            </div>
            <form class="navbar-form navbar-right" role="search">
                <button type="button" class="btn btn-default btn-info ">${userName}:${serialNumber}</button>
            </form>
        </div>
    </nav>
<#--边栏-->
        <#include "../common/nav.ftl">

<#--内容-->
    <div id="page-content-wrapper">
    <div class="container-fluid">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <div class="jumbotron">
                    <h2>
                        欢迎使用!
                    </h2>
                    <p>

                        This is a template for a simple marketing or informational website. It includes a large callout called the hero unit and three supporting pieces of content. Use it as a starting point to create something more unique.
                    </p>
                </div>
                <#--<div class="list-group">-->
                    <#--<a href="#" class="list-group-item active">Home</a>-->
                    <#--<div class="list-group-item">-->
                        <#--List header-->
                    <#--</div>-->
                    <#--<div class="list-group-item">-->
                        <#--<h4 class="list-group-item-heading">-->
                            <#--List group item heading-->
                        <#--</h4>-->
                        <#--<p class="list-group-item-text">-->
                            <#--...-->
                        <#--</p>-->
                    <#--</div>-->
                    <#--<div class="list-group-item">-->
                        <#--<span class="badge">14</span> Help-->
                    <#--</div> <a class="list-group-item active"> <span class="badge">14</span> Help</a>-->
                <#--</div>-->
            </div>
        </div>
    </div>
    </div>
    <div class="panel-group" id="accordion">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a data-toggle="collapse" data-parent="#accordion"
                       href="#collapseOne">
                        点击我进行展开，再次点击我进行折叠。第 1 部分--hide 方法
                    </a>
                </h4>
            </div>
            <div id="collapseOne" class="panel-collapse collapse in">
                <div class="panel-body">
                    Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred
                    nesciunt sapiente ea proident. Ad vegan excepteur butcher vice
                    lomo.
                </div>
            </div>
        </div>
        <div class="panel panel-success">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a data-toggle="collapse" data-parent="#accordion"
                       href="#collapseTwo">
                        点击我进行展开，再次点击我进行折叠。第 2 部分--show 方法
                    </a>
                </h4>
            </div>
            <div id="collapseTwo" class="panel-collapse collapse">
                <div class="panel-body">
                    Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred
                    nesciunt sapiente ea proident. Ad vegan excepteur butcher vice
                    lomo.
                </div>
            </div>
        </div>
        <div class="panel panel-info">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a data-toggle="collapse" data-parent="#accordion"
                       href="#collapseThree">
                        点击我进行展开，再次点击我进行折叠。第 3 部分--toggle 方法
                    </a>
                </h4>
            </div>
            <div id="collapseThree" class="panel-collapse collapse">
                <div class="panel-body">
                    Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred
                    nesciunt sapiente ea proident. Ad vegan excepteur butcher vice
                    lomo.
                </div>
            </div>
        </div>
        <div class="panel panel-warning">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a data-toggle="collapse" data-parent="#accordion"
                       href="#collapseFour">
                        点击我进行展开，再次点击我进行折叠。第 4 部分--options 方法
                    </a>
                </h4>
            </div>
            <div id="collapseFour" class="panel-collapse collapse">
                <div class="panel-body">
                    Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred
                    nesciunt sapiente ea proident. Ad vegan excepteur butcher vice
                    lomo.
                </div>
            </div>
        </div>
    </div>
    <script type="text/javascript">
        $(function () { $('#collapseFour').collapse({
            toggle: false
        })});
        $(function () { $('#collapseTwo').collapse('show')});
        $(function () { $('#collapseThree').collapse('toggle')});
        $(function () { $('#collapseOne').collapse('hide')});
    </script>



</div>
</body>
</html>
