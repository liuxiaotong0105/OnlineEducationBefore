<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>
<TITLE>登录页面</TITLE>
<link rel="stylesheet"
                  href="<%=request.getContextPath() %>/EasyUI/themes/default/easyui.css" type="text/css"/>

 <!-- 引入EasyUI的图标样式文件-->
 <link rel="stylesheet"
                  href="<%=request.getContextPath() %>/EasyUI/themes/icon.css" type="text/css"/>
 <script type="text/javascript"
                  src="<%=request.getContextPath() %>/EasyUI/jquery.min.js"></script>

 <!-- 引入EasyUI -->
 <script type="text/javascript"
                  src="<%=request.getContextPath() %>/EasyUI/jquery.easyui.min.js"></script>

 <!-- 引入EasyUI的中文国际化js，让EasyUI支持中文 -->
 <script type="text/javascript"
                  src="<%=request.getContextPath() %>/EasyUI/locale/easyui-lang-zh_CN.js"></script>
  
  <script type="text/javascript"
                 src="<%=request.getContextPath() %>/EasyUI/util-js.js"></script>


<STYLE>
body {
	background: #ebebeb;
	font-family: "Helvetica Neue", "Hiragino Sans GB", "Microsoft YaHei",
		"\9ED1\4F53", Arial, sans-serif;
	color: #222;
	font-size: 12px;
}

* {
	padding: 0px;
	margin: 0px;
}

.top_div {
	background: #008ead;
	width: 100%;
	height: 400px;
}

.ipt {
	border: 1px solid #d3d3d3;
	padding: 10px 10px;
	width: 290px;
	border-radius: 4px;
	padding-left: 35px;
	-webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075);
	box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075);
	-webkit-transition: border-color ease-in-out .15s, -webkit-box-shadow
		ease-in-out .15s;
	-o-transition: border-color ease-in-out .15s, box-shadow ease-in-out
		.15s;
	transition: border-color ease-in-out .15s, box-shadow ease-in-out .15s
}

.ipt:focus {
	border-color: #66afe9;
	outline: 0;
	-webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075), 0 0 8px
		rgba(102, 175, 233, .6);
	box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075), 0 0 8px
		rgba(102, 175, 233, .6)
}

.u_logo {
	background: url("images/username.png") no-repeat;
	padding: 10px 10px;
	position: absolute;
	top: 43px;
	left: 63px;
}

.p_logo {
	background: url("images/password.png") no-repeat;
	padding: 10px 10px;
	position: absolute;
	top: 12px;
	left: 63px;
}

a {
	text-decoration: none;
}

.tou {
	background: url("images/tou.png") no-repeat;
	width: 97px;
	height: 92px;
	position: absolute;
	top: -87px;
	left: 140px;
}

.left_hand {
	background: url("images/left_hand.png") no-repeat;
	width: 32px;
	height: 37px;
	position: absolute;
	top: -38px;
	left: 150px;
}

.right_hand {
	background: url("images/right_hand.png") no-repeat;
	width: 32px;
	height: 37px;
	position: absolute;
	top: -38px;
	right: -64px;
}

.initial_left_hand {
	background: url("images/hand.png") no-repeat;
	width: 30px;
	height: 20px;
	position: absolute;
	top: -12px;
	left: 100px;
}

.initial_right_hand {
	background: url("images/hand.png") no-repeat;
	width: 30px;
	height: 20px;
	position: absolute;
	top: -12px;
	right: -112px;
}

.left_handing {
	background: url("images/left-handing.png") no-repeat;
	width: 30px;
	height: 20px;
	position: absolute;
	top: -24px;
	left: 139px;
}

.right_handinging {
	background: url("images/right_handing.png") no-repeat;
	width: 30px;
	height: 20px;
	position: absolute;
	top: -21px;
	left: 210px;
}
</STYLE>



<SCRIPT type="text/javascript">
	$(function() {
		//得到焦点
		$("#password").focus(function() {
			$("#left_hand").animate({
				left : "150",
				top : " -38"
			}, {
				step : function() {
					if (parseInt($("#left_hand").css("left")) > 140) {
						$("#left_hand").attr("class", "left_hand");
					}
				}
			}, 2000);
			$("#right_hand").animate({
				right : "-64",
				top : "-38px"
			}, {
				step : function() {
					if (parseInt($("#right_hand").css("right")) > -70) {
						$("#right_hand").attr("class", "right_hand");
					}
				}
			}, 2000);
		});
		//失去焦点
		$("#password").blur(function() {
			$("#left_hand").attr("class", "initial_left_hand");
			$("#left_hand").attr("style", "left:100px;top:-12px;");
			$("#right_hand").attr("class", "initial_right_hand");
			$("#right_hand").attr("style", "right:-112px;top:-12px");
		});
	});
</SCRIPT>



<META name="GENERATOR" content="MSHTML 11.00.9600.17496">
</HEAD>

<BODY>

	<DIV class="top_div"></DIV>

	<DIV
		style="background: rgb(255, 255, 255); margin: -100px auto auto; border: 1px solid rgb(231, 231, 231); border-image: none; width: 400px; height: 236px; text-align: center;">

		<DIV style="width: 165px; height: 96px; position: absolute;">

			<DIV class="tou"></DIV>

			<DIV class="initial_left_hand" id="left_hand"></DIV>

			<DIV class="initial_right_hand" id="right_hand"></DIV>
		</DIV>
		<form id="form1" action="login!login.action" method="post">
		<P style="padding: 30px 0px 10px; position: relative;">
			<SPAN class="u_logo"></SPAN> <INPUT class="ipt" id="phoneName" type="text"
				placeholder="请输入手机号" value="">

		</P>

		<P style="position: relative;">
			<INPUT class="ipt" name="smsCode" 
				 placeholder="请输入验证码" value="" id="smsCode" style="width:195px">
				<span
					style="background: rgb(0, 142, 173);cursor:pointer; padding: 7px 10px; border-radius: 4px; border: 1px solid rgb(26, 117, 152); border-image: none; color: rgb(255, 255, 255); font-weight: bold;"
					id="getSMSCodeBtn">获取验证码</span> </SPAN>
				<!-- <a href="javascript:sendsmsCodeName();" style="float: left;line-height: 57px;" id="getSMSCodeBtn">获取验证码</a> -->
		</P>
		</form>

		<DIV
			style="height: 50px; line-height: 50px; margin-top: 68px; border-top-color: rgb(231, 231, 231); border-top-width: 1px; border-top-style: solid;">

			<P style="margin: 0px 35px 20px 45px;">
				
				<SPAN style="float: right;">
				<span
					style="background: rgb(0, 142, 173);cursor:pointer; padding: 7px 10px; border-radius: 4px; border: 1px solid rgb(26, 117, 152); border-image: none; color: rgb(255, 255, 255); font-weight: bold;"
					 id="loginBtnName">登录</span> </SPAN>
			</P>
		</DIV>
	</DIV>
	<script type="text/javascript">
	 $("#getSMSCodeBtn").click(function(){
		 
		 $.ajax({
				url:'../user/sendSmsName.do',
				type:'post',
				data:{
					phoneName:$('#phoneName').val()
				},
				dataType:'json',
				success:function(result){
					if(result){
						$.messager.alert('提示',"获取验证码成功");
						getValidated() 
					}
					else{
						$.messager.alert('提示',"获取验证码失败");
						
					}
				}
			})
	 })
	
		
		
	 $('#loginBtnName').click(function(){
		$.ajax({
			url:'../user/sendSmsNameCode.do',
			type:'post',
			data:{
				smsCode:$('#smsCode').val(),
				phoneName:$('#phoneName').val()
			},
			dataType:'json',
			success:function(result){
				if(result.code == 0){
					window.location.href='../user/toMain.do'
				}else{
					$.messager.alert('提示',result.msg,'info')
				}
			}
		})
	}) 
	
	var countdown=60; 
	function getValidated() { 
	if (countdown == 0) { 
	$('#getSMSCodeBtn').html("免费获取验证码")
	} else { 
	$('#getSMSCodeBtn').html("重新发送" + countdown + "")
	countdown--; 
	} 
		setTimeout(function() {  
			getValidated() 
		},1000)
	} 
	</script>
	<div style="text-align:center;"></div>
</BODY>