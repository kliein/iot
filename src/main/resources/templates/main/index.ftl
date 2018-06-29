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
                <button type="button" class="btn btn-default btn-info ">${(userName)!''}:${(serialNumber)!''}</button>
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
                        <tr>
                            <th>ID</th>
                            <th>设备编号</th>
                            <th>设备IP(IP:PORT)</th>
                            <th>通讯方式</th>
                            <th>数据(HEX)</th>
                            <th>创建时间</th>
                        </tr>
                        </thead>
                        <#list testDataPage.content as testData>
                        <tbody>
                        <tr>
                            <td>${(testData.testDataId)!''}</td>
                            <td>${(testData.slaveNumber)!''}</td>
                            <td>${(testData.slaveIp)!''}</td>
                            <td>${(testData.type)!''}</td>
                            <td>${(testData.testDataInfo)!''}</td>
                            <td>${(testData.createTime)!''}</td>
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
                        <li> <a href="/iot/test/list?page=${currentPage-1}&size=${size}">上一页</a></li>
                    </#if>


                   <#list 1..testDataPage.getTotalPages() as index>
                       <#if currentPage==index>
                        <li class="disabled"><a href="#">${index}</a></li>
                       <#else>
                        <li><a href="/iot/test/list?page=${index}&size=${size}">${index}</a></li>
                       </#if>
                   </#list>



                    <#if currentPage gte testDataPage.getTotalPages()>
                        <li class="disabled"><a href="#">下一页</a></li>
                    <#else >
                        <li><a href="/iot/test/list?page=${currentPage+1}&size=${size}">下一页</a></li>
                    </#if>

                    </ul>
                </div>
        </div>
    </div>


    </div>




</div>
</body>
<script>
    // setTimeout('location.reload()',3000)
</script>
</html>
