<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>在线考试系统---管理</title>
<style type="text/css">
   *{margin: 0;padding: 0;}
   #bd{
   	   width: 1000px;
   	   margin-left: 15%;
   	   margin-top: 5px;
   	   border: solid #123456;
   }
  #head{
    background-color: #123456;
    width: 100%;
    height: 40px;
    color: white;
    padding-top: 5px;
    font-family: "隶书";
    font-size: 32px;
  }
  #head p{
     margin-left: 15px;
  }
  #banner{
     width: 100%;
     background-color: #d4ebf9;
     height: 20px;
  }
  ul{
     list-style: none;
  }
  #content{
     height: 555px;
  }
  #left{
  float:left;
     border: solid 3px  #123456;
     width: 15%;
     height: 550px;
     background-color: #e5f4fd;
  }
  #left h3{
     padding: 5px 0px 5px;
     text-align:center;
     background-color: #123456;
     color: white;
  }
  #menu{
    margin-top: 10px;
    margin-left: 15px;
  }
  #menu h5{
     margin-top: 10px;
     font-family: "黑体";
     font-size: 16px;
  }
  #menu li{
    margin-top: 5px;
    margin-left: 20px;
  }
  #right{
  float:right;
  	width:84.06%;
  	height:550px;
  	border:3px #123456;
  	
  }
  #footer{
   	clear:both;
   	width: 100%;
   	height: 25px;
   	background-color: #123456;
   	color: white;
   	padding-top: 10px;
   	text-align: center;
   	font-family: "隶书";
   	font-size: 12px;
   }
   a{
   		text-decoration: none;
   }
   a:hover{
   		color:green;
   }
</style>
</head>
<body>
<div id="bd">
<div id="head"><p>华信智原在线考试系统</p></div>
<div id="banner"></div>
<div id="content">  
   <div id="left">
     <h3>系统管理</h3>
     <div id="menu">
       <h5>用户管理</h5>
       <ul>
         <li><a href="#">浏览用户</a>
         <li><a href="#">新建用户   </a>     
       </ul>
       <h5>科目管理</h5>
       <ul>
         <li><a href="#">查看科目</a> 
         <li><a href="#">增加科目 </a>        
       </ul>
       <h5>题型管理</h5>
       <ul>
         <li><a href="#">查看题型</a> 
         <li><a href="#">增加题型 </a>        
       </ul>
       <h5>试题管理</h5>
       <ul>
         <li><a href="#">浏览试题</a> 
         <li><a href="#">搜索试题 </a>        
         <li><a href="#">增加试题 </a>        
       </ul>
       <h5>成绩管理</h5>
     </div>
   </div>
 <div id="right">
 	<iframe src="http://baidu.com" frameborder="1" width="99%" height="550px" name="ck">
 </iframe>
 </div>
 
</div>
<div id="footer">
          华信智原&nbsp;&nbsp;
	版权所有&nbsp;&nbsp;
	2015年8月11日
</div>
</div>
</body>
</html>