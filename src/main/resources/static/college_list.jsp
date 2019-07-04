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
    <title>ԺУ����</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> ��ҳ <span class="c-gray en">&gt;</span> ԺУ���� <span class="c-gray en">&gt;</span> ԺУ���� <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="ˢ��" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="pd-20">
    <div class="text-c">
        <input type="text" class="input-text" style="width:250px" placeholder="����ԺУ����ID" id="" name=""><button type="submit" class="btn btn-success" id="" name=""><i class="icon-search"></i> ��ԺУ</button>

    </div>
    <div class="cl pd-5 bg-1 bk-gray mt-20">
    <span class="l"><a href="javascript:;" onclick="datadel()" class="btn btn-danger radius"><i class="icon-trash"></i> ����ɾ��</a>
    <a href="javascript:;" onclick="user_add('550','','���ԺУ','user-add.html')" class="btn btn-primary radius"><i class="icon-plus"></i> ���ԺУ</a></span>
        <span class="r">�������ݣ�<strong>88</strong> ��</span>
    </div>
    <table class="table table-border table-bordered table-hover table-bg table-sort">
        <thead>
        <tr class="text-c">
            <th width="25"><input type="checkbox" name="" value=""></th>
            <th width="">ԺУID</th>
            <th width="">ѧУ��</th>
            <th width="">Ժϵ��</th>
            <th width="100">����</th>
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
                    <a title="�༭" href="javascript:;" onclick="updateCollege('4','550','','�༭','user-add.html')" class="ml-5" style="text-decoration:none"><i class="icon-edit"></i></a>
                    <a title="ɾ��" href="javascript:;" onclick="deleteCollege(${clist.collegeId})" class="ml-5" style="text-decoration:none"><i class="icon-trash"></i></a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div id="pageNav" class="pageNav"></div>
</div>
<!--_footer ��Ϊ����ģ������ȥ-->
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script>
<!--/_footer ��Ϊ����ģ������ȥ-->

<!--�����·�д��ҳ��ҵ����صĽű�-->
<script type="text/javascript" src="lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript">
    window.onload = (function(){
        // optional set
        pageNav.pre="&lt;��һҳ";
        pageNav.next="��һҳ&gt;";
        // p,��ǰҳ��,pn,��ҳ��
        pageNav.fn = function(p,pn){$("#pageinfo").text("��ǰҳ:"+p+" ��ҳ: "+pn);};
        //��д��ҳ״̬,��������ҳ,��ҳ33ҳ
        pageNav.go(1,13);
    });
    $('.table-sort').dataTable({
        "lengthMenu":false,//��ʾ����ѡ��
        "bFilter": false,//���˹���
        "bPaginate": false,//��ҳ��Ϣ
        "bInfo": false,//������Ϣ
        "aaSorting": [[ 1, "desc" ]],//Ĭ�ϵڼ�������
        "bStateSave": true,//״̬����
        "aoColumnDefs": [
            //{"bVisible": false, "aTargets": [ 3 ]} //�����е�������ʾ
            {"orderable":false,"aTargets":[0,8,9]}// �ƶ��в���������
        ]
    });
</script>
</body>
</html>
