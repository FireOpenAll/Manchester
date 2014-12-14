<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>创建活动</title>

  <!-- Bootstrap -->
  <link href="/resources/activity2/css/bootstrap/bootstrap.min.css" rel="stylesheet">
  <!--datetimepicker css-->
  <link href="/resources/activity2/css/jquery/jquery.datetimepicker.css" rel="stylesheet">


  <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
  <script src="/resources/activity2/js/jquery/1.11.1.jquery.min.js"></script>
  <!--datetimepicker js-->
  <script src="/resources/activity2/js/jquery/jquery.datetimepicker.js"></script>
  <!--jquery validate js-->
  <script src="/resources/activity2/js/jquery/jquery.validate.js"></script>
   
   <!-- baidu map -->
   <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=CAmOf78i9fRk5nT89tt8c7Er"></script>
   <script src="/resources/activity2/js/hsq/baidumap.js"></script>
   
  <!-- Include all compiled plugins (below), or include individual files as needed -->
  <script src="/resources/activity2/js/bootstrap/bootstrap.min.js"></script>

  <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
  <!--[if lt IE 9]>
  <script src="../../assets/js/ie8-responsive-file-warning.js"></script>
  <![endif]-->
  <script src="/resources/activity2/js/bootstrap/ie-emulation-modes-warning.js"></script>

  <script src="/resources/activity2/js/bootstrap/docs.min.js"></script>
  <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
  <script src="/resources/activity2/js/bootstrap/ie10-viewport-bug-workaround.js"></script>
  <!--hsq-->
  <script type="text/javascript" src="/resources/activity2/js/hsq/location.js"></script>
  <script type="text/javascript" src="/resources/activity2/js/hsq/create.form.validate.js"></script>
  <script src="/resources/activity2/js/hsq/create.js"></script>
  <script src="/resources/activity2/js/hsq/category.js"></script>

  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
  <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
  <![endif]-->
  <style type="text/css">
  .mypanel {
    padding-left: 50px;
    padding-right: 50px;
  }
</style>

</head>
<body>

  <nav class="navbar navbar-inverse" role="navigation">
    <div class="container-fluid">
      <!-- Brand and toggle get grouped for better mobile display -->
      <div class="navbar-header">
        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
          <span class="sr-only">Toggle navigation</span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="/">友朋</a>
      </div>

      <!-- Collect the nav links, forms, and other content for toggling -->
      <div class="collapse navbar-collapse nav-justified" id="bs-example-navbar-collapse-1">
        <ul class="nav navbar-nav">
          <li class="active">
            <a href="#">创建活动</a>
          </li>
          <li>
            <a href="#">我的活动</a>
          </li>
        </ul>

        <ul class="nav navbar-nav navbar-right">
          <li>
            <a href="#">我的信息</a>
          </li>
          <li>
            <a href="#" >欢迎&nbsp;&nbsp;
            <shiro:authenticated>
            <shiro:principal property="loginName"/>
            </shiro:authenticated>
            
            <!--  %=request.getSession().getAttribute("userName")%-->
            &nbsp;</a>
          </li>

          <li >
            <a href="#">&nbsp;退出&nbsp;</a>
          </li>
        </ul>
      </div>
      <!-- /.navbar-collapse --> </div>
    <!-- /.container-fluid --> </nav>

  <div class = "mypanel">
    <form class="form-horizontal" role="form" id="form" action="/activity/create" enctype="multipart/form-data" method="POST">
      <div class="panel panel-default">
        <!--div class="panel-heading ">
        <h4>基本信息:</h4>
      </div-->
      <div class="panel-body">
        <!--start baseinfo -->
        <div id ="baseinfo">
          <h5> <strong>基本信息:</strong>
          </h5>
          <hr>
          <div id="baseinfoform">
            <div class="form-group">
              <label for="name" class="col-lg-2 control-label">活动名称:</label>
              <div class="col-lg-10">
                <input type="text" class="form-control" id="name" name="name" placeholder="活动名称">
              </div>
            </div>
            <div class="form-group">
              <label for="event_time" class="col-lg-2 control-label">活动时间:</label>
              <div class="col-lg-10 form-inline" id="event_time">

                <input type="text" class="form-control col-lg-3" id="start_time" name="start_time" placeholder="开始时间">              
                <input type="text"   class="form-control col-lg-3" id="end_time" name="end_time" placeholder="结束时间"></div>
            </div>
            <div class="form-group">
              <label for="location" class="col-lg-2 control-label">活动地点:</label>
              <div class="col-lg-10 form-inline" id ="location">
                 
                           
                <select class="col-lg-2 text-center" id="province_select" onchange="getCity()">
                  <option value="0">--省--</option>
                 
                </select>
                <span>&nbsp;&nbsp;</span>
                <select class="col-lg-2" id="city_select" onchange="getDistrict()">
                  <option value="0">--市--</option>
                </select>
                <span>&nbsp;&nbsp;</span>
                <select class="col-lg-2" id="district_select" onchange="setDistrict()">
                  <option value="0">--区--</option>
                </select>

                <input type="hidden" id="province" name="province">
                <input type="hidden" id="city" name="city">
                <input type="hidden" id="area" name="area">
              </div>
            </div>
            <div class="form-group">
              <label for="address-form" class="col-lg-2 control-label">活动详细地址:</label>
              <div class="col-lg-10" id="address-form">
                <input type="text" class=" col-lg-6 form-control" id="address_detail" name="address_detail" placeholder="活动详细地址">
                <label>点击地图详细地址，让小伙伴们更好的发现你的活动</label>
              </div>
              <div class="col-lg-offset-2 col-lg-6" id="l-map" style="height:300px;"></div>
              <input type="hidden" id="longtitude" name="longtitude" value="0">
              <input type="hidden" id="latitude" name="latitude" value="0">
              <div id = "item"> </div>
              <div id="searchResultPanel" style="border:1px solid #C0C0C0;width:150px;height:auto; display:none;"></div>
            </div>
            <div class="form-group">
              <label for="haibaos" class="col-lg-2 control-label">活动海报:</label>
              <div class="col-lg-10" id="haibaos">
                <input type="file" class="form-control" id="haibao1" name="haibao1">
                <input type="file" class="form-control" id="haibao2" name="haibao2">
                <input type="file" class="form-control" id="haibao3" name="haibao3">
              </div>
            </div>
            <div class="form-group">
              <label for="sponsor" class="col-lg-2 control-label">活动主办方:</label>
              <div class="col-lg-10">
                <input type="text" class="form-control" id="sponsor" name="sponsor" placeholder="活动主办方">
              </div>
            </div>
            <div class="form-group">
              <label for="phone" class="col-lg-2 control-label">咨询电话:</label>
              <div class="col-lg-10">
                <input type="text" class="form-control" id="phone" name="phone" placeholder="咨询电话">
              </div>
            </div>
            <div class="form-group">
              <label for="tags" class="col-lg-2 control-label">活动标签:</label>
              <div class="col-lg-10">
                <input type="text" class="form-control" id="tags" name="tags" placeholder="活动标签以及关键词，用空格分割，让大家更容易发现你的活动">
              </div>
            </div>
            <div class="form-group">
              <label for="description" class="col-lg-2 control-label">活动简介:</label>
              <div class="col-lg-10">
                <textarea class="form-control" id="description" name="description" placeholder="活动简介">
                  
                </textarea>
              </div>
            </div>
            <div class="form-group">
              <label for="detail" class="col-lg-2 control-label">活动详情:</label>
              <div class="col-lg-10">
                <textarea class="form-control" id="detail" name ="detail" placeholder="活动详情" rows = "5">
                  
                </textarea>
              </div>
            </div>
            
            

          </div>
        </div>
        <!--end baseinfo -->

        <!--start ticketinfo -->
        <div id ="ticketinfo">
          <h5> <strong>门票信息:</strong>
          </h5>
          <hr>        
          <div id="ticketinfoform">
            <table class="table table-bordered">
              <thead>
                <tr>
                  <th class="col-lg-2">类型</th>
                  <th>门票名称</th>
                  <th>数量</th>
                  <th>价格</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td >活动门票</td>
                  <td><input type="text" id ="ticket_name" name="ticket_name" /></td>
                  <td><input type="text" id ="ticket_num" name="ticket_num" /></td>
                  <td><input type="text" id ="ticket_price" name="ticket_price" /></td>
                </tr>
                <!--tr>
                  <td >收费门票</td>
                  <td><input type="text" id ="ticket2_name" name="ticket2_name" /></td>
                  <td><input type="text" id ="ticket2_num" name="ticket2_num" /></td>
                  <td><input type="text" id ="ticket2_price" name="ticket2_price" /></td>
                </tr-->
              </tbody>
            </table>
          </div>
        </div>
        <!--end ticketinfo -->

        <!--start ticketinfo -->
        <div id ="tuiguangtinfo">
          <h5> <strong>推广信息:</strong>
          </h5>
          <hr>        
          <div id="tuiguangtinfo">
            <div class="radio">
              <label>
                <input type="radio" name="optionsRadios" id="optionsRadios" value="1" checked>公开（发布到活动平台）</label>
            </div>
            <div class="radio">
              <label>
                <input type="radio" name="optionsRadios" id="optionsRadios" value="2">不公开（只有知道网址才能访问）</label>
            </div>

            <br/>        
            <!--p>活动分类：</p-->
            <div class="form-group">
              <label for="category" class="col-lg-2 control-label">活动分类:</label>
              <div class="col-lg-10 form-inline" id ="category">
                 
                           
                <select class="col-lg-2 text-center" id="category1" onchange="getCategory2()">
                  <option value="0">--分类1--</option>
                 
                </select>
                <span>&nbsp;&nbsp;</span>
                <select class="col-lg-2" id="category2" onchange="setCategory2()">
                  <option value="0">--分类2--</option>
                </select>

                <input type="hidden" id=catId1 name="catId1">
                <input type="hidden" id="catId2" name="catId2" value="0">
              </div>
            </div>
            
            <!--div class="col-lg-2">
              <select class="form-control" id="category_select" onchange="setCategory()">
                <option value="0">--选择分类--</option>
              </select>
              <input type="hidden" id="category" name="category">
            </div-->


          </div>
        </div>
        <!--end tuiguanginfo -->
        
        <br/>
        <br/>

        <div>
          <button type="submit" class="btn-primary btn-lg pull-right" id ="btn_submit">提交活动</button>

        </div>

        <br/>
        <br/>

      </div>
    </div>
  </form>
</div>

</body>
</html>
<script type="text/javascript">
	// 百度地图API功能
	function G(id) {
		return document.getElementById(id);
	}

	var map = new BMap.Map("l-map");
	map.centerAndZoom("北京",12);                   // 初始化地图,设置城市和地图级别。

	var ac = new BMap.Autocomplete(    //建立一个自动完成的对象
		{"input" : "address_detail"
		,"location" : map
	});

	ac.addEventListener("onhighlight", function(e) {  //鼠标放在下拉列表上的事件
	var str = "";
		var _value = e.fromitem.value;
		var value = "";
		if (e.fromitem.index > -1) {
			value = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
		}    
		str = "FromItem<br />index = " + e.fromitem.index + "<br />value = " + value;
		
		value = "";
		if (e.toitem.index > -1) {
			_value = e.toitem.value;
			value = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
		}    
		str += "<br />ToItem<br />index = " + e.toitem.index + "<br />value = " + value;
		G("searchResultPanel").innerHTML = str;
	});

	var myValue;
	ac.addEventListener("onconfirm", function(e) {    //鼠标点击下拉列表后的事件
	var _value = e.item.value;
        var str = '&province=' + _value.province + '&city=' + _value.city + '&district=' + _value.district + '&street=' + _value.street+ '&address=' + _value.business;
        getPoint(str);
		myValue = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
		G("searchResultPanel").innerHTML ="onconfirm<br />index = " + e.item.index + "<br />myValue = " + myValue;
		
		setPlace();
	});

	function setPlace(){
		map.clearOverlays();    //清除地图上所有覆盖物
		function myFun(){
			var pp = local.getResults().getPoi(0).point;    //获取第一个智能搜索的结果
			map.centerAndZoom(pp, 18);
			map.addOverlay(new BMap.Marker(pp));    //添加标注
		}
		var local = new BMap.LocalSearch(map, { //智能搜索
		  onSearchComplete: myFun
		});
		local.search(myValue);
	}
</script>