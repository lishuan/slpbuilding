$(document).ready(function (e) {    
	//左搜索下拉模拟
	$(".lselt").mouseenter(function(e) {
        $(this).find("ul").show();
    });
	$(".lselt").mouseleave(function(e) {
        $(this).find("ul").hide();
    });
	$(".lselt li").click(function(e) {
		$(".lselt li").removeClass("cur");
		$(this).addClass("cur");
        thistxt=$(this).text();
		$(this).parents(".p").find(".soipt").attr("placeholder",thistxt);
		$(this).parents(".p").find(".lselt .txt").text(thistxt);
		$(this).parents(".p").find(".phTips").text(thistxt);
		$(this).parents("ul").hide();
    });
	//自动计算浏览器窗口高度
	bodyH=$(window).height();
	mainconboxHeight();
	//日期独选式效果
	$(".timeselsobox ul li a").click(function(e) {
        $(".timeselsobox").find("li").removeClass("active");
		$(this).parent("li").addClass("active");
    });
});
$(window).resize(function(e) {
	bodyH=$(window).height();
    mainconboxHeight();	
});
//交互主区高度
function mainconboxHeight(){	
	$(".mainconbox").height(bodyH-90);
    
}

//选项卡
function setTab(name,cursel,n){
 for(i=1;i<=n;i++){
  var menu=document.getElementById(name+i);
  var con=document.getElementById("c_"+name+"_"+i);
  menu.className=i==cursel?"hover":"";
  con.style.display=i==cursel?"block":"none";
 }
}


//滚动图
function DY_scroll(wraper,prev,next,img,speed,or)
 { 
  var wraper = $(wraper);
  var prev = $(prev);
  var next = $(next);
  var img = $(img).find('ul');
  var w = img.find('li').outerWidth(true);
  var s = speed;
  next.click(function()
       {
        img.animate({'margin-left':-w},function()
                  {
                   img.find('li').eq(0).appendTo(img);
                   img.css({'margin-left':0});
                   });
        });
  prev.click(function()
       {
        img.find('li:last').prependTo(img);
        img.css({'margin-left':-w});
        img.animate({'margin-left':0});
        });
  if (or == true)
  {
   ad = setInterval(function() { next.click();},s*1000);
   wraper.hover(function(){clearInterval(ad);},function(){ad = setInterval(function() { next.click();},s*1000);});

  }
 }
 //DY_scroll('.img-scroll','.prev','.next','.img-list',3,true);// true为自动播放，不加此参数或false就默认不
 
 