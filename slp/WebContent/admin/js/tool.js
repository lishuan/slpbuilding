function checkallitem(o)
{
    $("input[name='item'][type='checkbox']").prop("checked", $(o).prop("checked"));
}

function ConvertFloat(o) {
    var v = parseFloat(o);
    if (isNaN(v)) {
        v = 0;
    }
    return v;
}


function ValidateNumber(e) {
    var pnumber = $(e).val();
    //先把非数字的都替换掉，除了数字和.
    pnumber = pnumber.replace(/[^\d.]/g, "");
    //必须保证第一个为数字而不是.
    pnumber = pnumber.replace(/^\./g, "");
    //保证只有出现一个.而没有多个.
    pnumber = pnumber.replace(/\.{2,}/g, ".");
    //保证.只出现一次，而不能出现两次以上
    pnumber = pnumber.replace(".", "$#$").replace(/\./g, "").replace("$#$", ".");    
    $(e).val(pnumber);
    
}


/**
 * 判断字符串是否为空
 * str 需要验证的字符串
 * return 验证结果[true:成功;false:失败;]
 */
var IsNull = function (str) {

    if (str !== null && str !== "null" && str !== "" && str !== undefined && str !== "undefined" && str.replace(/(^s*)|(s*$)/g, "") !== "") {
        return false;
    }
    return true;
};

var VaildMobile = function (mobile) {
    if (mobile == "") {
        alert('请输入手机号码');
        return false;
    }
    if (mobile.length != 11) {
        alert('请输入有效的手机号码');
        return false;
    }
    var patrn = /^(1[0-9]{10})$/;
    if (!patrn.exec(mobile)) {
        return false
    }
    return true;

}

var VaildEmail = function (email) {
    if (email == "") {
        alert('请输入邮箱');
        return false;
    }
    var re = /^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/;
    if (re.test(email)) {
        return true;
    } else {
        alert("不是正确的邮箱格式");
        return false;
    }
}

var VaildPhone = function (phone) {
    if (phone == "") {
        alert('请输入电话号码');
        return false;
    }
    var re = /^0\d{2,3}-?\d{7,8}$/;
    if (re.test(phone)) {
        return true;
    } else {
        alert("不是正确的电话号码");
        return false;
    }
}

function CheckZip(mobile) {
    var reg = /^\d{6}$/;
    return reg.test(mobile);
}

//验证身份证是否合格
var vaildIdCard = function (idcard) {
    if (isNull(idcard)) {
        Dialog.alert("身份证号不能为空，请输入正确的身份证号！");
        return false;
    }

    if (idcard.length !== 15 && idcard.length !== 18) {
        Dialog.alert("身份证号格式不正确，请输入正确的身份证号！");
        return false;
    }

    var area = { 11: "北京", 12: "天津", 13: "河北", 14: "山西", 15: "内蒙古", 21: "辽宁", 22: "吉林", 23: "黑龙江", 31: "上海", 32: "江苏", 33: "浙江", 34: "安徽", 35: "福建", 36: "江西", 37: "山东", 41: "河南", 42: "湖北", 43: "湖南", 44: "广东", 45: "广西", 46: "海南", 50: "重庆", 51: "四川", 52: "贵州", 53: "云南", 54: "西藏", 61: "陕西", 62: "甘肃", 63: "青海", 64: "宁夏", 65: "新疆", 71: "台湾", 81: "香港", 82: "澳门", 91: "国外" };
    var pNO = idcard.substr(0, 2);
    if (isNaN(pNO) || area[parseInt(pNO)] == null) {
        Dialog.alert("身份证号不正确(地区非法)，请输入正确的身份证号！");
        return false;
    }

    var birth = "";
    var month = "";
    var day = "";

    if (idcard.length === 15) {
        var pattern = /^\d{15}$/;
        if (pattern.exec(idcard) === null) {
            Dialog.alert("15位身份证号码必须为数字，请输入正确的身份证号！");
            return false;
        }
        birth = parseInt("19" + idcard.substr(6, 2));
        month = idcard.substr(8, 2);
        day = parseInt(idcard.substr(10, 2));
        switch (month) {
            case '01':
            case '03':
            case '05':
            case '07':
            case '08':
            case '10':
            case '12':
                {
                    if (day > 31) {
                        Dialog.alert("输入身份证号码不格式正确，请输入正确的身份证号！");
                        return false;
                    }
                    break;
                }
            case '04':
            case '06':
            case '09':
            case '11':
                {
                    if (day > 30) {
                        Dialog.alert("输入身份证号码不格式正确，请输入正确的身份证号！");
                        return false;
                    }
                    break;
                }
            case '02':
                {
                    if ((birth % 4 == 0 && birth % 100 != 0) || birth % 400 == 0) {
                        if (day > 29) {
                            Dialog.alert("输入身份证号码不格式正确，请输入正确的身份证号！");
                            return false;
                        }
                    }
                    else {
                        if (day > 28) {
                            Dialog.alert("输入身份证号码不格式正确，请输入正确的身份证号！");
                            return false;
                        }
                    }
                    break;
                }
            default:
                {
                    Dialog.alert('输入身份证号码不格式正确，请输入正确的身份证号！');
                    return false;
                }
        }
        var nowYear = new Date().getFullYear();
        if (nowYear - parseInt(birth) < 15 || nowYear - parseInt(birth) > 100) {
            Dialog.alert("输入身份证号码不格式正确，请输入正确的身份证号！");
            return false;
        }

        //province:省份;
        return { "province": pNO, "YMD": birth + "-" + month + "-" + day, "sex": idcard.substr(idcard.length - 1) };
    }

    var Wi = new Array(7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2, 1);
    var lSum = 0;
    var nNum = 0;   
    for (var i = 0; i < 17; ++i) {
        if (idcard.charAt(i) < '0' || idcard.charAt(i) > '9') {
            alert("身份证号码不正确，请输入正确的身份证号！");
            return false;
        }
        else {
            nNum = idcard.charAt(i) - '0';
        }
        lSum += nNum * Wi[i];
    }
    if (idcard.charAt(17) === 'X' || idcard.charAt(17) === 'x') {
        lSum += 10 * Wi[17];
    }
    else if (idcard.charAt(17) < '0' || idcard.charAt(17) > '9') {
        alert("身份证号码不正确，请输入正确的身份证号！");
        return false;
    }
    else { lSum += (idcard.charAt(17) - '0') * Wi[17]; }

    if ((lSum % 11) == 1) { }
    else {
        alert("身份证号码不正确，请输入正确的身份证号！");
        return false;
    }

    birth = parseInt(idcard.substr(6, 4));
    month = idcard.substr(10, 2);
    day = idcard.substr(12, 2);

    //province:省份;
    return { "province": pNO, "YMD": birth + "-" + month + "-" + day, "sex": idcard.substr(idcard.length - 2, 1) };
};
 

//文件上传
var NewSwfUpload = function (cfg, callFun) {
    new SWFUpload({
        flash_url: "../swfupload/swfupload.swf",
        upload_url: "../other/swfuploadfile.do",
        file_size_limit: "102400", // 100MB
        file_types: "*.*",

        file_types_description: "All Files",
        file_upload_limit: "10",
        file_queue_limit: "0",
        file_queue_error_handler: fileQueueError,
        file_dialog_complete_handler: fileDialogComplete,
        upload_error_handler: uploadError,
        upload_success_handler: function uploadSuccess(file, serverData) {//相当于将handlers.js里的方法覆盖重写了,所以之前的状态一直是Uploading...   
            var obj = JSON.parse(serverData);
            if (callFun) {
                callFun(obj);
            }
        },
        button_image_url: cfg.btnimgurl,
        button_width: cfg.btnwidth,
        button_height: cfg.btnheight,
        button_placeholder_id: cfg.spanid,
        button_text: cfg.spantext,
        button_text_top_padding: cfg.spanpdtop,
        button_text_left_padding: cfg.spanpdleft,
        custom_settings: {
            progressTarget: "fsUploadProgress1"

        },
        debug: false
    });
};


//获取URL参数
var getQueryString = function (name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return unescape(r[2]); return null;
};

//文件上传2。李改，解决前台自定义按钮样式的问题。
var dsSwfUpload = function (cfgg, callFunn) {
    new SWFUpload({
        flash_url: "/content/swfupload/swfupload.swf",
        upload_url: "/other/SwfUploadFile",
        file_size_limit: "102400", // 100MB
        file_types: "*.*",

        file_types_description: "All Files",
        file_upload_limit: "10",
        file_queue_limit: "0",
        file_queue_error_handler: fileQueueError,
        file_dialog_complete_handler: fileDialogComplete,
        upload_error_handler: uploadError,
        upload_success_handler: function uploadSuccess(file, serverData) {//相当于将handlers.js里的方法覆盖重写了,所以之前的状态一直是Uploading...   
            var obj = JSON.parse(serverData);
            if (callFunn) {
                callFunn(obj);
            }
        },
        button_image_url: cfgg.upimgurl,
        button_width: cfgg.spanwidth,
        button_height: cfgg.spanheight,
        button_placeholder_id: cfgg.spanid,
        button_text: cfgg.spantext,
        button_text_top_padding: cfgg.spanpdtop,
        button_text_left_padding: cfgg.spanpdleft,
        custom_settings: {
            progressTarget: "fsUploadProgress1"

        },
        debug: false
    });
};

function dynamicLoad(file, fun) {
    var _doc = document.getElementsByTagName('head')[0];
    var js = document.createElement('script');
    js.setAttribute('type', 'text/javascript');
    js.setAttribute('src', file);
    _doc.appendChild(js);
    js.onload = js.onreadystatechange = function () {
        alert("ddd");
        if (typeof (fun) == "function") {
            fun();
        }
    }
}