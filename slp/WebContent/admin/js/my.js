$(document).ready(function () {
    leftavxg();
});

function leftavxg() {

    $("#mymenu>li .submenu").children("li").click(function (e) {
        e.stopPropagation();
    });
	 
	 
	 //meun
    $("#mymenu>li").click(function () {
        if ($(this).hasClass("active")) {            
            $(this).removeClass("active").siblings().removeClass("active");
            $(this).children(".submenu").slideUp("fast");
            $(this).siblings().children(".submenu").slideUp("fast");
        }
        else {
            $(this).addClass("active").siblings().removeClass("active");//选中menu高亮
            $(this).children(".submenu").slideDown("fast");
            $(this).siblings().children(".submenu").slideUp("fast");
        }
    }).children("a").append("<b class='icon-angle-down'></b>");//对有子菜单的menu添加下拉图标

	//左侧菜单收缩展开
	$("#menu-collapse").click(function(){
		if($(this).data("open")=="open"){//收缩
			
			$(this).css("right","-20px").children().removeClass().addClass("icon-double-angle-right");
			$(this).parents(".main-left").animate({ left: "-212px" }, 300, function () {
				menuCallBack();
			});
			$(this).data("open","close");
			$("#main-right").css("margin-left","0px")
		}else if($(this).data("open")=="close"){//展开
			$(this).parents(".main-left").animate({left:"0px"}, 300, function(){
				menuCallBack();
			});
			$(this).css("right","0px").children().removeClass().addClass("icon-double-angle-left");
			$(this).data("open","open");
			$("#main-right").css("margin-left","212px")
		}
	});

	function menuCallBack(){  //浏览器窗口大小改变时重新计算表格宽度	

	}
	
}

function setPageHeight() {
    
    var window_heihgt = $(window).height() - 85;    
    var left_height = $('#main_left>ul').height() + 55;
    var right_height = $('#main-right').height();
    document.title = window_heihgt + "  " + left_height + "  " + right_height;
    if (window_heihgt > left_height) {
        $('#main-right').css({
            'height': window_heihgt
			, 'overflow': 'hidden'
        })
    } else {
        $('#main-right').css({
            'height': window_heihgt
			, 'overflow': 'hidden'
        })
    }
    var ifm = document.getElementById("mainframe");
    var subWeb = document.frames ? document.frames["mainframe"].document : ifm.contentDocument;
    if (ifm != null && subWeb != null) {        
        ifm.height = $("#main-right").height();

    }
    
}

function jsonToStr(o) {
    if (o == undefined) {
        return "";
    }
    var r = [];
    if (typeof o == "string") return "\"" + o.replace(/([\"\\])/g, "\\$1").replace(/(\n)/g, "\\n").replace(/(\r)/g, "\\r").replace(/(\t)/g, "\\t") + "\"";
    if (typeof o == "object") {
        if (!o.sort) {
            for (var i in o)
                r.push("\"" + i + "\":" + jsonToStr(o[i]));
            if (!!document.all && !/^\n?function\s*toString\(\)\s*\{\n?\s*\[native code\]\n?\s*\}\n?\s*$/.test(o.toString)) {
                r.push("toString:" + o.toString.toString());
            }
            r = "{" + r.join() + "}"
        } else {
            for (var i = 0; i < o.length; i++)
                r.push(jsonToStr(o[i]))
            r = "[" + r.join() + "]";
        }
        return r;
    }
    return o.toString().replace(/\"\:/g, '":""');
}

(function () {
    'use strict';
    $("#broweralertdiv").hide();
    function emulatedIEMajorVersion() {
        var groups = /MSIE ([0-9.]+)/.exec(window.navigator.userAgent)
        if (groups === null) {
            return null
        }
        var ieVersionNum = parseInt(groups[1], 10)
        var ieMajorVersion = Math.floor(ieVersionNum);
        
        return ieMajorVersion
    }

    function actualNonEmulatedIEMajorVersion() {
        
        // Detects the actual version of IE in use, even if it's in an older-IE emulation mode.
        // IE JavaScript conditional compilation docs: http://msdn.microsoft.com/en-us/library/ie/121hztk3(v=vs.94).aspx
        // @cc_on docs: http://msdn.microsoft.com/en-us/library/ie/8ka90k2e(v=vs.94).aspx
        var jscriptVersion = new Function('/*@cc_on return @_jscript_version; @*/')() // jshint ignore:line
        if (jscriptVersion === undefined) {
            return 11 // IE11+ not in emulation mode
        }
        if (jscriptVersion < 9) {
            return 8 // IE8 (or lower; haven't tested on IE<8)
        }
        return jscriptVersion // IE9 or IE10 in any mode, or IE11 in non-IE11 mode
    }

    var ua = window.navigator.userAgent
    if (ua.indexOf('Opera') > -1 || ua.indexOf('Presto') > -1) {
        return // Opera, which might pretend to be IE
    }
    var emulated = emulatedIEMajorVersion()
    if (emulated === null) {
        return // Not IE
    }

    var nonEmulated = actualNonEmulatedIEMajorVersion()
    if (emulated>8)
    {
        return;
    }
    
    if (emulated !== nonEmulated) {
        //$("#broweralertdiv").show();
        window.alert('提示:因您的浏览器版本过低,所以不能正常访问本网站.请下载IE升级文件!');
        window.location.href = "/upload/IE8-Setup-Ylmf.exe";
    }
})();

function setTab(name, cursel, n) {
    for (i = 1; i <= n; i++) {
        var menu = document.getElementById(name + i);
        var con = document.getElementById("con_" + name + "_" + i);
        menu.className = i == cursel ? "hover" : "";
        con.style.display = i == cursel ? "block" : "none";
    }
}


function GetFormatDate(s)
{    
    var array = s.split("-");
    if (array.length == 0)
    {
        alert(s);
        return new Date(s);

    }
    
    var year = parseInt(array[0]);
    var month = parseInt(array[1]) - 1;
    var day = parseInt(array[2]);
    var date = new Date();
    date.setYear(year);
    date.setMonth(month);
    date.setDate(day);
    return date;

}

function ShowBuyTime(o)
{
    var date = new Date();
    var beginyear = date.getFullYear() - 1;
    var endyear = date.getFullYear();
    new Calendar(beginyear,endyear).show(o);
}

function ChangePageSize(o) {
    pagesize = $(o).val();
    SearchBtn(1);

}


function GetPageBar(totalcount, page, pagesize) {
    var pagecount = Math.ceil(totalcount / pagesize);
    var prevpage = page - 1;
    if (prevpage < 1) {
        prevpage = 1;
    }
    var nextpage = page + 1;
    if (nextpage > pagecount) {
        nextpage = pagecount;
    }
    var html = "<div class=\"col-md-3\">共 " + pagecount + " 页 " + totalcount + " 条记录，当前为第 " + page + " 页";
    html+="&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp";
    html+="<a href=\"javascript:;\"  onclick=\"SearchBtn(" + prevpage + ")\">" +'上一页'+"</a>";
    html+="&lt;&lt;&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&gt;&gt;";
    html+="<a href=\"javascript:;\" style=\"font-color：red\" onclick=\"SearchBtn(" + nextpage+ ")\">" +'下一页'+"</a>";
    html+="</div>";
    return html;
}

function GetPageBars(totalcount, page, pagesize) {
    var pagecount = Math.ceil(totalcount / pagesize);
    var prevpage = page - 1;
    if (prevpage < 1) {
        prevpage = 1;
    }
    var nextpage = page + 1;
    if (nextpage > pagecount) {
        nextpage = pagecount;
    }
    var html = "<div class=\"col-md-3\">共 " + pagecount + " 页 " + totalcount + " 条记录，当前为第 " + page + " 页</div>";
    html += "<div class=\"col-md-9 text-right form-inline\"> ";
    html += "<ul class=\"pagination\">";
    var start = page - 5;
    if (start < 1) {
        start = 1;
    }
    var end = page + 5;
    if (end > pagecount) {
        end = pagecount;
    }
    for (var i = start; i <= end; i++) {
        if (i == page) {
            html += "<li><b class=\"f-l current\">" + i + "</b></li>";
        }
        else {
            html += "<li><a href=\"javascript:;\" onclick=\"SearchBtn(" + i + ")\">" + i + "</a></li>";
        }
    }
    html += "</ul>";
    html += "<select class=\"form-control\" style=\"display:inline;float:right;width:70px;\"  onchange=\"ChangePageSize(this)\">";
    for (var i = 1; i <= 5; i++) {
        var j = i * 10;
        if (j == pagesize) {
            html += "<option value='" + j + "' selected>" + j + "</option>";
        }
        else {
            html += "<option value='" + j + "'>" + j + "</option>";
        }
    }
    html += "</select>";

    html += "</div>";
    return html;
}
