<%@ page language="java" contentType="text/html; charset=GB18030"
         pageEncoding="GB18030"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="com.kb.csrm.college.dto.CollegeDto" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <!--[if lt IE 9]>
    <script type="text/javascript" src="lib/html5shiv.js"></script>
    <script type="text/javascript" src="lib/respond.min.js"></script>
    <![endif]-->
    <link rel="stylesheet" type="text/css" href="static/h-ui/css/H-ui.min.css" />
    <link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/H-ui.admin.css" />
    <link rel="stylesheet" type="text/css" href="lib/Hui-iconfont/1.0.8/iconfont.css" />
    <link rel="stylesheet" type="text/css" href="static/h-ui.admin/skin/default/skin.css" id="skin" />
    <link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/style.css" />
    <!--[if IE 6]>
    <script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
    <script>DD_belatedPNG.fix('*');</script>
    <![endif]-->
    <title>院校管理</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 院校管理 <span class="c-gray en">&gt;</span> 院校管理 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="pd-20">
    <div class="text-c">
        <input type="text" class="input-text" style="width:250px" placeholder="输入院校名或ID" id="" name=""><button type="submit" class="btn btn-success" id="" name=""><i class="icon-search"></i> 搜院校</button>

    </div>
    <div class="cl pd-5 bg-1 bk-gray mt-20">
    <span class="l"><a href="javascript:;" onclick="datadel()" class="btn btn-danger radius"><i class="icon-trash"></i> 批量删除</a>
    <a href="javascript:;" onclick="user_add('550','','添加院校','user-add.html')" class="btn btn-primary radius"><i class="icon-plus"></i> 添加院校</a></span>
        <span class="r">共有数据：<strong>88</strong> 条</span>
    </div>
    <table class="table table-border table-bordered table-hover table-bg table-sort">
        <thead>
        <tr class="text-c">
            <th width="25"><input type="checkbox" name="" value=""></th>
            <th width="">院校ID</th>
            <th width="">学校名</th>
            <th width="">院系名</th>
            <th width="100">操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="collegeList" var="clist" varStatus="st">
            <tr class="text-c">
                <td><input type="checkbox" value="" name=""></td>
                <td>${clist.collegeId}</td>
                <td>${clist.collegeName}</td>
                <td>${clist.facultyName}</td>
                <td class="f-14 user-manage">
                    <a title="编辑" href="javascript:;" onclick="updateCollege('4','550','','编辑','user-add.html')" class="ml-5" style="text-decoration:none"><i class="icon-edit"></i></a>
                    <a title="删除" href="javascript:;" onclick="deleteCollege(${clist.collegeId})" class="ml-5" style="text-decoration:none"><i class="icon-trash"></i></a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div id="pageNav" class="pageNav"></div>
</div>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script>
<!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript">
    window.onload = (function(){
        // optional set
        pageNav.pre="&lt;上一页";
        pageNav.next="下一页&gt;";
        // p,当前页码,pn,总页面
        pageNav.fn = function(p,pn){$("#pageinfo").text("当前页:"+p+" 总页: "+pn);};
        //重写分页状态,跳到第三页,总页33页
        pageNav.go(1,13);
    });
    $('.table-sort').dataTable({
        "lengthMenu":false,//显示数量选择
        "bFilter": false,//过滤功能
        "bPaginate": false,//翻页信息
        "bInfo": false,//数量信息
        "aaSorting": [[ 1, "desc" ]],//默认第几个排序
        "bStateSave": true,//状态保存
        "aoColumnDefs": [
            //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
            {"orderable":false,"aTargets":[0,8,9]}// 制定列不参与排序
        ]
    });
</script>
</body>
</html>
