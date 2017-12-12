function ClearArea(areaid)
{
    $("#" + areaid).empty();
    $("#" + areaid).append("<option value=''>请选择</option>");
}
function BindRootAreaDict(areaid) {
    ClearArea(areaid);
    $.ajax({
        url: "../home/areadict.do",
        cache: true,
        type: 'POST',
        dataType: "json",
        success: function (data) {
            var count = data.length;
            for (var i = 0; i < count; i++) {
                $("#" + areaid).append("<option value='" + data[i].id + "'>" + data[i].areaname + "</option>");
            }
        },
        error: function (data) {
            alert(data.responseText);
        }
    });

}

function BindAreaDict(pid, areaid) {
    ClearArea(areaid);
    $.ajax({
        url: "../home/areadict.do",
        cache: true,
        data: { id: pid },
        type: 'POST',
        dataType: "json",
        success: function (data) {
            var count = data.length;
            for (var i = 0; i < count; i++) {
                $("#" + areaid).append("<option value='" + data[i].id + "'>" + data[i].areaname + "</option>");
            }
        },
        error: function (data) {
            alert(data.responseText);
        }
    });

}

function BindMemberDict(memberid, membertype) {
    $("#" + memberid).empty();
    $("#" + memberid).append("<option value=''>请选择</option>");
    $.ajax({
        url: "../home/memberdict.do",
        cache: true,
        data: { id: membertype },
        type: 'POST',
        dataType: "json",
        success: function (data) {
            var count = data.length;
            for (var i = 0; i < count; i++) {
                $("#" + memberid).append("<option value='" + data[i].id + "'>" + data[i].name + "</option>");
            }
        },
        error: function (data) {
            alert(data.responseText);
        }
    });

}

function BindArea(id, areaid) {
    $("#" + areaid).empty();

    $.ajax({
        url: "../home/areadict.do",
        cache: false,
        type: 'POST',
        dataType: "json",
        data: {
            id: id
        },
        success: function (data) {
            var count = data.length;
            for (var i = 0; i < count; i++) {
                $("#" + areaid).append("<option value='" + data[i].id + "'>" + data[i].areaname + "</option>");
            }
        },
        error: function (data) {
            alert(data.responseText);
        }
    });
}

function BindAgent(id, agentid) {
    $("#" + agentid).empty();

    $.ajax({
        url: "../home/agentict.do",
        cache: false,
        type: 'POST',
        dataType: "json",
        data: {
            id: id
        },
        success: function (data) {
            var count = data.length;
            $("#" + agentid).append("<option value=''>"+'请选择'+"</option>");
            for (var i = 0; i < count; i++) {
                $("#" + agentid).append("<option value='" + data[i].id + "'>" + data[i].realname + "</option>");
            }
        },
        error: function (data) {
            alert(data.responseText);
        }
    });
}

function BindAttachment(type, id, imglistid) {
    $.ajax({
        url: "../home/listclaimattachment.do",
        cache: false,
        type: 'POST',
        dataType: "html",
        data: {
            id: id,
            type: type
        },
        success: function (data) {
            $("#" + imglistid).html(data);
        },
        error: function (data) {
            alert(data.responseText);
        }
    });
}


//索赔人
function BindOneAgent(agentid,membername,memberid){
	
	 $("#" + membername).prop("value","")

	    $.ajax({
	        url: "../home/oneagentdict.do",
	        cache: false,
	        type: 'POST',
	        dataType: "json",
	        data: {
	            id:agentid
	        },
	        
	        success: function (data) {
	        	//alert(data.memberid);
               $("#"+membername).prop("value",data.membername);
               $("#"+memberid).prop("value",data.memberid);
	        },
	        error: function (data) {
	            alert(data.responseText);
	        }
	    });
	}

//指定索赔员
function BindMember(claimmemberid){
	
	$("#" + claimmemberid).empty();

	    $.ajax({
	        url: "../home/memberdict.do",
	        cache: false,
	        type: 'POST',
	        dataType: "json",
	        data: {
	        	
	        },
	        
	        success: function (data) {
	        	$("#" + claimmemberid).append("<option value=''>请选择</option>");
	            var count = data.length;
	            for (var i = 0; i < count; i++) {
	                $("#" + claimmemberid).append("<option value='" + data[i].id + "'>" + data[i].realname + "</option>");
	            }
	        },
	        error: function (data) {
	            alert(data.responseText);
	        }
	    });
	}


//当前步骤
function auditStepDict(searchauditstatus){
	
	$("#" + searchauditstatus).empty();
   
    $.ajax({
        url: "../home/auditstepdict.do",
        cache: true,
        type: 'POST',
        dataType: "json",
        success: function (data) {
        	$("#" + searchauditstatus).append("<option value=''>全部</option>");
            var count = data.length;
            //alert(JSON.stringify(data));
            for (var i = 0; i < count; i++) {
            	//alert(data[i].key);
                $("#" + searchauditstatus).append("<option value='" + data[i].key + "'>" + data[i].value + "</option>");
            }
        },
        error: function (data) {
            alert(data.responseText);
        }
    });
}

//所有厂家
function factorysDict(searchfactoryid){
	$("#" + searchfactoryid).empty();
    $.ajax({
        url: "../home/factorysdict.do",
        cache: true,
        type: 'POST',
        dataType: "json",
        success: function (data) {
        	$("#" + searchfactoryid).append("<option value=''>所有厂家</option>");
            var count = data.length;
            for (var i = 0; i < count; i++) {
                $("#" + searchfactoryid).append("<option value='" + data[i].id + "'>" + data[i].realname + "</option>");
            }
        },
        error: function (data) {
            alert(data.responseText);
        }
    });
}

//所有品牌
function carbrandDict(searchcarbrandid){
	$("#" + searchcarbrandid).empty();
    $.ajax({
        url: "../home/carbranddict.do",
        cache: true,
        type: 'POST',
        dataType: "json",
        success: function (data) {
        	$("#" + searchcarbrandid).append("<option value=''>所有品牌</option>");
            var count = data.length;
            for (var i = 0; i < count; i++) {
                $("#" + searchcarbrandid).append("<option value='" + data[i].id + "'>" + data[i].brandname + "</option>");
            }
        },
        error: function (data) {
            alert(data.responseText);
        }
    });
}


//所有产品
function ProductNameDict(searchproductid) {
    $("#" + searchproductid).empty();
    $("#" + searchproductid).append("<option value=''>所有产品</option>");
    $.ajax({
        url: "../home/productnamedict.do",
        cache: true,
        type: 'POST',
        dataType: "json",
        success: function (data) {
            var count = data.length;
            for (var i = 0; i < count; i++) {
                $("#" + searchproductid).append("<option value='" + data[i].id + "'>" + data[i].productname + "</option>");
            }
        },
        error: function (data) {
            alert(data.responseText);
        }
    });

}

//所有车型
function CarModelNameDict(searchcarmodelid) {
    $("#" + searchcarmodelid).empty();
    $("#" + searchcarmodelid).append("<option value=''>所有车型</option>");
    $.ajax({
        url: "../home/carmodelnamedict.do",
        cache: true,
        type: 'POST',
        dataType: "json",
        success: function (data) {
            var count = data.length;
            for (var i = 0; i < count; i++) {
                $("#" + searchcarmodelid).append("<option value='" + data[i].id + "'>" + data[i].modelname + "</option>");
            }
        },
        error: function (data) {
            alert(data.responseText);
        }
    });

}
//所有地区
function AreaNameDict(searchareaid) {
    $("#" + searchareaid).empty();
    $("#" + searchareaid).append("<option value=''>所有地区</option>");
    $.ajax({
        url: "../home/areanamedict.do",
        cache: true,
        type: 'POST',
        dataType: "json",
        success: function (data) {
            var count = data.length;
            for (var i = 0; i < count; i++) {
                $("#" + searchareaid).append("<option value='" + data[i].id + "'>" + data[i].areaname + "</option>");
            }
        },
        error: function (data) {
            alert(data.responseText);
        }
    });

}
//所有角色
function memberroleDict(searchroleid) {
    $("#" + searchroleid).empty();
    $("#" + searchroleid).append("<option value=''>所有角色</option>");
    $.ajax({
        url: "../home/memberroledict.do",
        cache: true,
        type: 'POST',
        dataType: "json",
        success: function (data) {
            var count = data.length;
            for (var i = 0; i < count; i++) {
                $("#" + searchroleid).append("<option value='" + data[i].id + "'>" + data[i].rolename + "</option>");
            }
        },
        error: function (data) {
            alert(data.responseText);
        }
    });

}
//所有保险公司
function insuranceDict(insuranceid) {
    $("#" + insuranceid).empty();
    $("#" + insuranceid).append("<option value=''>请选择</option>");
    $.ajax({
        url: "../home/insurancedict.do",
        cache: true,
        type: 'POST',
        dataType: "json",
        success: function (data) {
            var count = data.length;
            for (var i = 0; i < count; i++) {
                $("#" + insuranceid).append("<option value='" + data[i].id + "'>" + data[i].realname + "</option>");
            }
        },
        error: function (data) {
            alert(data.responseText);
        }
    });

}
//单证状态
function ticketstatusDict (ticketstatus) {
    $("#" + ticketstatus).empty();
    $("#" + ticketstatus).append("<option value=''>请选择</option>");
    $.ajax({
        url: "../home/ticketstatusdict.do",
        cache: true,
        type: 'POST',
        dataType: "json",
        success: function (data) {
            var count = data.length;
            for (var i = 0; i < count; i++) {
                $("#" + ticketstatus).append("<option value='" + data[i].key + "'>" + data[i].value + "</option>");
            }
        },
        error: function (data) {
            alert(data.responseText);
        }
    });

}