	function keyPress() {
		var keyCode = event.keyCode;
		if ((keyCode >= 48 && keyCode <= 57)) {
			event.returnValue = true;
		} else {
			event.returnValue = false;
		}
	}
	function checkform() {
		var houseTitle = document.getElementById("houseTitle");
		var houseAddDetail = document.getElementById("houseAddDetail");
		var houseArea = document.getElementById("houseArea");
		var houseRoom = document.getElementById("houseRoom");
		var houseWc = document.getElementById("hosueWc");
		var houseHall = document.getElementById("houseHall");
		var housePrice = document.getElementById("housePrice");
		var tel = document.getElementById("tel");

	}
function showdiv(){
	var pic2 =document.getElementById("pic2");
	var pic3 =document.getElementById("pic3");
	var pic4 =document.getElementById("pic4");
	var pic5 =document.getElementById("pic5");
	var pic6 =document.getElementById("pic6");
	var img1 =document.getElementById("image1");
	var img2 =document.getElementById("image2");
	var img3 =document.getElementById("image3");
	var img4 =document.getElementById("image4");
	var img5 =document.getElementById("image5");
	
	if(img1.value!=""){
		pic2.style.display="block";
	}
		if(img2.value!=""){
		pic3.style.display="block";
	}
	
		if(img3.value!=""){
		pic4.style.display="block";
	}
	
		if(img4.value!=""){
		pic5.style.display="block";
	}
	
		if(img5.value!=""){
		pic6.style.display="block";
	}
	
}
function change(img, image) {
    var pic = document.getElementById(img),
        file = document.getElementById(image);
 
    var ext=file.value.substring(file.value.lastIndexOf(".")+1).toLowerCase();
 
     // gif在IE浏览器暂时无法显示
     if(ext!='png'&&ext!='jpg'&&ext!='jpeg'){
         alert("图片的格式必须为png或者jpg或者jpeg格式！"); 
         return;
     }
     var isIE = navigator.userAgent.match(/MSIE/)!= null,
         isIE6 = navigator.userAgent.match(/MSIE 6.0/)!= null;
 
     if(isIE) {
        file.select();
        var reallocalpath = document.selection.createRange().text;
 
        // IE6浏览器设置img的src为本地路径可以直接显示图片
         if (isIE6) {
            pic.src = reallocalpath;
         }else {
            // 非IE6版本的IE由于安全问题直接设置img的src无法显示本地图片，但是可以通过滤镜来实现
             pic.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod='image',src=\"" + reallocalpath + "\")";
             // 设置img的src为base64编码的透明图片 取消显示浏览器默认图片
             pic.src = 'data:image/gif;base64,R0lGODlhAQABAIAAAP///wAAACH5BAEAAAAALAAAAAABAAEAAAICRAEAOw==';
         }
     }else {
        html5Reader(file,img);
     }
}
 
 function html5Reader(file,img){
     var file = file.files[0];
     var reader = new FileReader();
     reader.readAsDataURL(file);
     reader.onload = function(e){
         var pic = document.getElementById(img);
         pic.src=this.result;
     }
 } 