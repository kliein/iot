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
                        欢迎使用本测试平台，本测试平台仅提供给购买本公司通讯模块的用户使用，本平台支持TCP，UDP通信方式，其中TCP通信方式为长连接，心跳时间为120S，120S之内没有通信交互，平台将断开TCP连接，再次通信需要重新连接。用户使用通讯模块向指定ID+端口根据我们制定的协议
                        发送数据，发送完成后，在本平台可查看发送数据记录，完成通讯的测试，下面提供测试方法。
                    </p>
                </div>
            </div>
        </div>
    </div>
    </div>
    <div class="container-fluid">
    <div class="panel-group" id="accordion">
        <div class="panel panel-warning">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a data-toggle="collapse" data-parent="#accordion"
                       href="#collapseOne">
                        测试IP和端口
                    </a>
                </h4>
            </div>
            <div id="collapseOne" class="panel-collapse collapse in">
                <div class="panel-body">
                本平台指定IP+端口，IP为118.24.14.231，TCP通信端口为：10002，UDP通信端口为：10001。
                </div>
            </div>
        </div>
        <div class="panel panel-success">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a data-toggle="collapse" data-parent="#accordion"
                       href="#collapseTwo">
                        测试协议
                    </a>
                </h4>
            </div>
            <div id="collapseTwo" class="panel-collapse collapse">
                <div class="panel-body">
                    <div class="col-md-12 column">
                        <table class="table table-bordered" >
                            <thead>
                            <tr>
                                <th>协议头（2字节）</th>
                                <th>用户序列号（3字节）</th>
                                <th>设备ID（3字节）</th>
                                <th>数据长度（2字节）</th>
                                <th>数据内容（自定义）</th>
                                <th>校验（1字节）</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr >
                                <td>55 AA</td>
                                <td>如ID为123456的对应HEX数据为 1E 24 00 </td>
                                <td>如ID为5的对呀HEX数据为 00 00 05</td>
                                <td>数据包所携带数据的长度</td>
                                <td>携带的数据</td>
                                <td>校验值为和校验，数据头到除校验位之外求和，并取低八位为校验和</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <div class="panel panel-info">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a data-toggle="collapse" data-parent="#accordion"
                       href="#collapseThree">
                        测试数据示例(数据均为16进制），第一行数据为发送数据示例，第二行为十进制数据示例。
                    </a>
                </h4>
            </div>
            <div id="collapseThree" class="panel-collapse collapse">
                <div class="panel-body">
                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <th>协议头（2字节）</th>
                            <th>用户序列号（3字节）</th>
                            <th>设备ID（3字节）</th>
                            <th>数据长度（2字节）</th>
                            <th>数据内容（自定义）</th>
                            <th>校验（1字节）</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>55 AA</td>
                            <td>5A 94 09</td>
                            <td>00 00 04</td>
                            <td>00 02</td>
                            <td>11 11</td>
                            <td>1E</td>
                        </tr>
                        <tr>
                            <td>55 AA</td>
                            <td>371017</td>
                            <td>4</td>
                            <td>2</td>
                            <td>11 11</td>
                            <td>1E</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
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
