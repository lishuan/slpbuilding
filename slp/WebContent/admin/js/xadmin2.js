//批量删除的样式控制
function selectaudio(){
	$(".layui-form-checkbox").click(function(event) {
	    if($(this).hasClass('layui-form-checked')){
	        $(this).removeClass('layui-form-checked');
	        if($(this).hasClass('header')){
	            $(".layui-form-checkbox").removeClass('layui-form-checked');
	        }
	    }else{
	        $(this).addClass('layui-form-checked');
	        if($(this).hasClass('header')){
	            $(".layui-form-checkbox").addClass('layui-form-checked');
	        }
	    }
	    
	});
}