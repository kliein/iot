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
                    <table class="table table-bordered table-hover table-condensed">
                        <thead>
                        <tr class="error">
                            <#--<th>用户序列码</th>-->
                            <th>设备ID</th>
                            <th>设备IP地址</th>
                            <th>添加时间</th>
                            <th>备注</th>
                            <th style="text-align: center" colspan="2">操作</th>
                        </tr>
                        </thead>
                        <#list slaveInfoPage.content as slaveInfo>
                        <tbody>
                        <tr class="success">
                            <#--<td>${slaveInfo.userSerialNumber}</td>-->
                            <td>${slaveInfo.slaveNumber}</td>
                            <td>${slaveInfo.slaveIp}</td>
                            <td>${slaveInfo.createTime}</td>
                            <td>${(slaveInfo.slaveRemark)!''}</td>
                            <td class="text-center">
                                <a href="/iot/slave/delete?slaveNumber=${slaveInfo.slaveNumber}" type="button" class="btn btn-default btn-danger">删除</a>

                                <a href="#" type="button" class="btn btn-default btn-primary">下发数据</a>
                            </td>

                        </tr>
                        </tbody>
                        </#list>
                    </table>
                </div>


                <div class="col-md-12 column">
                    <ul class="pagination pull-right">
                    <#if currentPage lte 1>
                        <li class="disabled"><a href="#">上一页</a></li>
                    <#else >
                        <li> <a href="/iot/slave/list?page=${currentPage-1}&size=${size}">上一页</a></li>
                    </#if>


                   <#list 1..slaveInfoPage.getTotalPages() as index>
                       <#if currentPage==index>
                        <li class="disabled"><a href="#">${index}</a></li>
                       <#else>
                        <li><a href="/iot/slave/list?page=${index}&size=${size}">${index}</a></li>
                       </#if>
                   </#list>



                    <#if currentPage gte slaveInfoPage.getTotalPages()>
                        <li class="disabled"><a href="#">下一页</a></li>
                    <#else >
                        <li><a href="/iot/slave/list?page=${currentPage+1}&size=${size}">下一页</a></li>
                    </#if>

                    </ul>
                </div>
        </div>
    </div>


    </div>




</div>
</body>
<script>
    setTimeout('location.reload()"',3000)
</script>
</html>
