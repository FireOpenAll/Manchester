$(document).ready(function(){
//	UIloginDL();//下拉菜单
//	UIuserDL();
//	tabFixed();
//	aaa();
//	lr();
//	tabAdd();
	UIdialog();
	UIselect();
	UIslide();
	UItab();
// 	pie();
	
});
function UIloginDL(){
	var $trigger = $(".nav").find("li.login");
	var $target;
	var timeoutID;
	var show = function(){
		var $thisTigger = $(this);
		timeoutID = setTimeout(function(){
			$target = $thisTigger.children(".downlist");
			var h=$target.height();
			$target.slideDown(200,function(){$target.css({"overflow":""}).find("button").animate({"right":-15});});
			$target.siblings().addClass("hover");
		},100)
	}
	var hide = function(){
		clearTimeout(timeoutID);
		$target = $(this).children(".downlist");
		$target.find("button").stop().animate({"right":0},200,function(){$target.slideUp(200,function(){$target.siblings().removeClass("hover");});});
	}
	$trigger.hover(show,hide);
}

function UIuserDL(){
	var $trigger = $(".nav").find("li.user");
	var $target;
	var timeoutID;
	var show = function(){
		var $thisTigger = $(this);
		timeoutID = setTimeout(function(){
			$target = $thisTigger.children(".downlist");
			var h=$target.height();
			$target.slideDown(200);
			$target.siblings().addClass("hover");
		},100)
	}
	var hide = function(){
		clearTimeout(timeoutID);
		$target = $(this).children(".downlist");
		$target.slideUp(200,function(){$target.siblings().removeClass("hover");});
	}
	$trigger.hover(show,hide);
}

function aaa(){
	var $list=$(".index_list>li");
	var $card=$('<div class="cardBg"></div><div class="card"></div>')
	$list.each(function(){
		var $this=$(this);
		$this.hover(
			function(){
				$this.addClass("choose").prepend($card).find(".card").html($this.find("img").attr("alt"));
			},
			function(){
				$this.removeClass("choose").find("a").siblings().remove();
			}
		)
	})
}

function lr(){
	var leftH=$(".global_leftMenu").outerHeight();
	var rightH=$(".global_right").outerHeight();
	if(leftH>rightH){
		rightH=leftH;
		$(".global_right").outerHeight(rightH);
	}else{
		leftH=rightH;
		$(".global_leftMenu").outerHeight(leftH);
	}
	
	
}

function tabFixed(){
	var $fixedTab=$(".global_headTab");
	var $tempTab=$('<div class="global_headTabTemp"></div>')
	var headH=$(".global_head").outerHeight();
	var scrollHeight;
	$(window).scroll(function(){
		scrollHeight = document.documentElement.scrollTop+document.body.scrollTop; 
		if(headH<scrollHeight){
			$fixedTab.before($tempTab);
			$fixedTab.prev(".global_headTabTemp").height($fixedTab.outerHeight());
			$fixedTab.addClass("global_headTabFixed");
		}else{
			$fixedTab.removeClass("global_headTabFixed").prev(".global_headTabTemp").remove();
		}
	})
}

function UIdialogNew(thisBtn){
	var $coverCreate=$('<div class="global_cover"></div>'),
		$dialogCreate=$('<div class="global_dialog"></div>'),
		$closeCreate=$('<div class="dialogClose"><a href="javascript:void(0);"></a></div>'),
		$titleCreate=$('<div class="dialogTitle"></div>'),
		$info=$("#"+thisBtn.attr("UIdialogNew"));
		
	$info.show().before($coverCreate).wrap($dialogCreate).before($closeCreate).before($titleCreate).after($info.find(".dialogSave"));
	var $dialog=$info.parents(".global_dialog"),
		$cover=$dialog.prev(".global_cover"),
		$close=$dialog.find(".dialogClose"),
		$title=$dialog.find(".dialogTitle"),
		$save=$dialog.find(".dialogSave");
		
	eval(thisBtn.attr("UIdialogNew")+"Dialog($dialog,hideDialog)");
	UIscroll($info);
	$dialog.width($info.width());
	$save.css({"width":$dialog.outerWidth()});
	$title.css({"width":$dialog.outerWidth()});
	$dialog.css({"top":($(window).height()-$dialog.outerHeight())/2+document.documentElement.scrollTop+document.body.scrollTop,"left":($(window).width()-$dialog.outerWidth())/2});
	$cover.height($(document).outerHeight());
	$title.html($info.attr("dialogTitle"));
	$save.find("a").html($info.attr("dialogSave"));
	
	function hideDialog(){
		$info.prepend($save).prependTo("body").hide();
		$dialog.empty().remove();
		$cover.remove();
	}
}

function UIdialog(){
	var $initAddDialog=$("#addModule").clone();
		
	var coreVar = "UIdialog"; 
	var $root = $("*["+coreVar+"]");
	if($root.length != 0){
		var init={
			headH:$(".template_headBg").css("height"),
			h1Size:$(".template_headInner h1").css("fontSize"),
			h1Color:color16($(".template_headInner h1").css("color")),
			dragTitleSize:$(".col>div .title").css("fontSize"),
			dragTitleColor:color16($(".col>div .title").css("color"))
		}
	}
	$root.each(function(){
		var $this=$(this);
		var $coverCreate=$('<div class="global_cover"></div>');
		var $dialogCreate=$('<div class="global_dialog"></div>');
		var $closeCreate=$('<div class="dialogClose"><a href="javascript:void(0);"></a></div>');
		var $titleCreate=$('<div class="dialogTitle"></div>');
		$this.unbind("click").click(function(){
			var $info=$("#"+$this.attr("UIdialog"));
			var DialogJudge=$this.attr("UIdialog")+"DialogJudge";
//			try{
//				if(typeof(eval(DialogJudge)) == "function"){
//				eval(DialogJudge+"()");
//				}
//			}catch(e){};
			var $save=$info.find(".dialogSave");
			$info.show().before($coverCreate).wrap($dialogCreate).before($closeCreate).before($titleCreate).after($save);
			var $dialog=$info.parents(".global_dialog");
			var $cover=$dialog.prev(".global_cover");
			var $close=$dialog.find(".dialogClose");
			var $title=$dialog.find(".dialogTitle");
			var $save=$dialog.find(".dialogSave");
			eval($this.attr("UIdialog")+"Dialog($dialog,hideDialog,init,$this,$initAddDialog,$info)");
			UIscroll($info);
			$dialog.width($info.width());
			$save.css({"width":$dialog.outerWidth()});
			$title.css({"width":$dialog.outerWidth()});
			$dialog.css({"top":($(window).height()-$dialog.outerHeight())/2+document.documentElement.scrollTop+document.body.scrollTop,"left":($(window).width()-$dialog.outerWidth())/2});
			$cover.height($(document).outerHeight());
			$title.html($info.attr("dialogTitle"));
			$save.find("a").html($info.attr("dialogSave"));
//			$close.click(closeDialog)
			function hideDialog(){
				$info.prepend($save).prependTo("body").hide();
				$dialog.empty().remove();
				$cover.remove();
			}
		})
	})
}
function color16(a){
	if(typeof(a) != "undefined"){
		var browser=navigator.appName;
		if (!$.support.leadingWhitespace){
			return a;
		}else{
			var parts = a.match(/^rgb\((\d+),\s*(\d+),\s*(\d+)\)$/);
			delete (parts[0]);
			for (i = 1; i <= 3; ++i) {
			parts[i] = parseInt(parts[i]).toString(16);
			if (parts[i].length == 1) parts[i] = '0' + parts[i];
			}
			return "#"+parts.join(''); // "#0070ff"
		}
	}
}
function clone(oldObj){ 
	if(typeof(oldObj) != 'object') return oldObj; 
	if(oldObj == null) return oldObj; 
	var newObj = new Object(); 
	for(var i in oldObj)
	newObj[i] = clone(oldObj[i]); 
	return newObj; 
} 

//左右滑动（不循环）JS
function UIslide(){
	/*=======================================
	自定义属性标识:slide="数字"
	必备class标枳:leftArrow/rightArrow/ableArrow/disableArrow/slideInfo
	-----------------------------------------
	应用结构
	=========================================*/
	var coreVar = "slide"; 
	var $root = $("*["+coreVar+"]");
	$root.each(function(index){
		var rootValue = $root.eq(index).attr(coreVar);
		var $triggerLeft = $(this).find(".leftArrow");
		var $triggerRight = $(this).find(".rightArrow");
		var $target = $(this).find(".slideInfo"); 
		
		var $targetChildren=$target.children();//获取滑动元素
		var slideLength = $targetChildren.outerWidth() * rootValue;//单次滑动距离
		var slideSpeed = 500; 
		var targetWidth = $targetChildren.outerWidth() * $targetChildren.length;//滑动区域宽度
		var targetVisualWidth = $target.parent().outerWidth();//滑动区可视宽度
		var targetPosition = 0;//左键定位初始值
		var error = '在第 ' + (index+1) + ' 个包含' + coreVar + '属性的DOM中，' + coreVar + '属性值应为“数字”,现在的值为“' + rootValue + '”，还不快改！！';
		
		$target.parent().css({"height":$target.children("div").outerHeight()});
		
		$target.css({"left":targetPosition,"width":targetWidth});
		
		if(targetVisualWidth >= targetWidth){
			$triggerLeft.addClass("disableArrow");
			$triggerRight.addClass("disableArrow");
		}else{
			$triggerLeft.addClass("disableArrow");
		}
		
		$triggerLeft.unbind("click").click(function(){
			if(isNaN(parseFloat(rootValue))){
				alert(error);
			}
			else{
				if(targetPosition < 0 && targetPosition + slideLength <= 0){
					targetPosition += slideLength;
					$target.animate({"left":targetPosition},slideSpeed);
				}else{
					targetPosition -= targetPosition;
					$target.animate({"left":targetPosition},slideSpeed);
				}
				arrowStyle();
			}
		})
		$triggerRight.unbind("click").click(function(){
			if(isNaN(parseFloat(rootValue))){
				alert(error);
			}else{
				var mod = targetPosition + targetWidth - targetVisualWidth;
				if(targetPosition + targetWidth >= targetVisualWidth && mod >= slideLength){
					targetPosition -= slideLength;
					$target.animate({"left":targetPosition},slideSpeed);
				}else if(targetVisualWidth >= targetWidth){
				}else{
					targetPosition -= mod;
					$target.animate({"left":targetPosition},slideSpeed);
				}
				arrowStyle();
			}
		})
		function arrowStyle(){
			if(targetPosition < 0){
				$triggerLeft.removeClass("disableArrow");
				$triggerLeft.addClass("ableArrow");
			}else{
				$triggerLeft.removeClass("ableArrow");
				$triggerLeft.addClass("disableArrow");
			}
			if(targetPosition + targetWidth <= targetVisualWidth){
				$triggerRight.removeClass("ableArrow");
				$triggerRight.addClass("disableArrow");
			}else{
				$triggerRight.removeClass("disableArrow");
				$triggerRight.addClass("ableArrow");
			}
		}
	})
}

//下拉菜单JS
function UIselect(){
	var coreVar = "UIselect"; 
	var $root = $("*["+coreVar+"]");
	$root.each(function(){
		var $this=$(this);							//当前组
		var $select=$this.find(".select");
		$select.each(function(){
			var $thisSelect=$(this);
			var $downlist=$thisSelect.find(".downlist");
			var $selBar=$thisSelect.find(".bar");
			$selBar.width(parseInt($thisSelect.css("width"))-2).hover(
				function(){$(this).addClass("barHover")},
				function(){$(this).removeClass("barHover")}
			)
			$thisSelect.unbind("click")
			.click(function(){
				$thisSelect.parent().css({"position":"relative","zIndex":5});
				$downlist.show();
				UIscroll($downlist.find("ul"));
				var downlistH=$downlist.height();
				$downlist.css({"height":0}).stop().animate({"height":downlistH},200);
			})
			.mouseleave(function(){
				$downlist.slideUp(200,function(){
					$thisSelect.removeAttr("style").parent().css({"position":"","zIndex":1});
				});
			})
			$downlist.width(parseInt($thisSelect.css("width"))-2).find("li").each(function(){
				$(this)
				.hover(
					function(){$(this).addClass("hover")},
					function(){$(this).removeClass("hover")}
				)
				.unbind("click").click(function(e){
					$(this).parents(".downlist").siblings(".bar").html($(this).html()).trigger("mouseleave");
					if(typeof($thisSelect.attr("selectCallback")) != "undefined"){
						eval($thisSelect.attr("selectCallback")+"Select($(this))");
					}
					
					stopBubble(e);
				})
			})
		})
	})
}
//停止冒泡
function stopBubble(e) { 
	if (e && e.stopPropagation) {
		e.stopPropagation(); 
	}else{
		window.event.cancelBubble = true; 
	}
}

function UItab(){
    var coreVar = "UItab"; 
    var $root = $("*["+coreVar+"]");
    $root.each(function(){
        //标签切换
        var $this   = $(this),
            $tabBar = $this.find(".tabBarInner"),
            $arrowL = $this.find(".tabArrowL"),
            $arrowR = $this.find(".tabArrowR"),
            $ul     = $tabBar.find("ul"),
            $li     = $ul.find("li");
        $li.each(function(n){
            $(this).unbind("click").click(function(){
                $li.removeClass("choose").eq(n).addClass("choose");
                $this.find(".tabBody ol").hide().eq(n).show();
            })
        })
        $li.eq(0).trigger("click");
        //标签轮换
        var liW=$li.outerWidth()+parseInt($li.css("marginLeft"))+parseInt($li.css("marginRight")),
            left=0;
        $ul.width((liW)*$li.length);
        if($ul.width()>$tabBar.width()){
            $tabBar.css({"margin":"0px 30px"})
            $arrowL.show().unbind("click").click(function(){
                if($ul.is(":not(:animated)")){
                    if(left%liW == 0){
                        left = parseInt($ul.css("left"))+liW;
                    }else{
                        left = parseInt($ul.css("left"))-(left%liW);
                    }
                    if(left>0){
                        left=0;
                    }
                    $ul.animate({"left":left});
                }
            })
            $arrowR.show().unbind("click").click(function(){
                if($ul.is(":not(:animated)")){
                    left = parseInt($ul.css("left"))-liW;
                    if(left<$tabBar.width()-$ul.width()){
                        left=$tabBar.width()-$ul.width();
                    }
                    $ul.animate({"left":left});
                }
            })
        }
    })
    
}

function UIscroll(){
	var coreVar = "UIscroll"; 
	var $root;
	if(arguments.length != 0){
		$root = arguments[0];
		
	}else{
		$root = $("*["+coreVar+"]");
	}
	$root.each(function(){
		var $this=$(this);
		//结构初始化-解包
		if($this.parent().is(".scrollOuter")){
			$this.siblings().remove();
			$this.unwrap();
		}
		//结构初始化-打包
		var $outer=$('<div class="scrollOuter"></div>').css({"width":"100%"}).insertBefore($this).prepend($this),																						//
			innerH=$this.outerHeight();
		if(innerH>=$this.attr(coreVar)){
			$outer.css({"height":$this.attr(coreVar)});
		}else{
			$outer.css({"height":innerH});
			$this.css({"top":0});
		}
		
		var outerH=$outer.height(),
			pctH=outerH/innerH;
			
		if(pctH<1){
			var $scrollBg=$('<div class="scrollBg globalPIE" style="height:'+($outer.height()-4)+'px"></div>').prependTo($outer),
				$scroll=$('<div class="scroll" style="height:'+pctH*100+'%"></div>').prependTo($outer),					//
				$scrollInner=$('<div class="scrollInner globalPIE"></div>').css({"height":$scroll.height()-6}).prependTo($scroll),//
				srcolltop,
				innerTop=parseInt($this.css("top"));
				$this.parent(".scrollOuter").css({"overflow":"hidden"});
			if(isNaN(innerTop) || innerTop==0){
				
				srcolltop=0;
			}else{
				srcolltop=innerTop/(-1)*pctH;
			}
			roll();
			//拖动事件
			$scroll.mousedown(function(ev){
				var oEvent = ev || event;
				var sXY=oEvent.clientY-$scroll.offset().top;
				document.onmousemove = function(ev){
					var oEvent = ev || event;
					srcolltop=oEvent.clientY-sXY-$outer.offset().top;
					if (srcolltop<0){
						srcolltop=0;
					}
					if (srcolltop>outerH-$scroll.height()){
						srcolltop = outerH-$scroll.height();
					}
					roll();
				};
				document.onmouseup = function(){
					document.onmousemove = null;
					document.onmouseup = null;
				};
				return false;
			})
			//滚轮事件
			var scrollFunc=function(ev){
				var oEvent = ev || event;
				if(oEvent.wheelDelta){//IE/Opera/Chrome
					if(oEvent.wheelDelta>0 && srcolltop>=0){
						srcolltop=srcolltop-10*pctH;
						if(srcolltop<0){srcolltop=0};
					}else if(oEvent.wheelDelta<0 && srcolltop<$outer.height()-$scroll.height()){
						srcolltop=srcolltop+10*pctH
						if($outer.height()<=$scroll.height()+srcolltop){srcolltop=$outer.height()-$scroll.height()}
					}
					roll()
				}else if(oEvent.detail){//Firefox
					if(oEvent.detail>0 && srcolltop>=0){
						srcolltop=srcolltop+10*pctH;
						if($outer.height()<$scroll.height()+srcolltop){srcolltop=$outer.height()-$scroll.height()}
					}else if(oEvent.detail<0 && srcolltop<=$outer.height()-$scroll.height()){
						srcolltop=srcolltop-10*pctH;
						if(srcolltop<0){srcolltop=0};
					}
				}
				roll();
				//冻结浏览器滚动条
				if (oEvent&&oEvent.preventDefault){ 
					oEvent.preventDefault();
					oEvent.stopPropagation();
				}else{ 
					oEvent.returnvalue=false;  
					return false;     
				}
			}
			/*注册滚轮事件*/
			if($outer.get(0).addEventListener){//W3C
				$outer.get(0).addEventListener('DOMMouseScroll',scrollFunc,false);
			}
			$outer.get(0).onmousewheel=scrollFunc;//IE/Opera/Chrome/Safari
			//滚动算法
			
		}
		function roll(){
			innerTop=-1/pctH*srcolltop;
			$scroll.css({"top":srcolltop});
			$this.css({"top":innerTop});
		}
	})
}

//IE兼容CSS3
function pie(){
	var url="url('http://www.huodongshu.com/static_page/css/PIE.htc')";
	var aaa="\
	.global_form .input_small,\
	.global_form .input_big,\
	.global_form textarea,\
	.global_form .btn_small,\
	.global_form .btn_big,\
	.scrollBg,\
	.scrollInner,\
	.global_dialog\
	";
	var init=$(aaa);
	init.css({"behavior":url});
	if(arguments.length != 0){
		arguments[0].css({"behavior":url});
	}
	
}











