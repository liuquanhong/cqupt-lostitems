var fenlei = document.getElementsByClassName("fenlei");
var space = document.getElementsByClassName('space');
var card = document.getElementsByClassName("card");
var planB = document.getElementsByClassName("planB")[0];
var submmit = document.getElementById("submmit");
var Return = document.getElementsByClassName("return")[0];
var title = document.getElementsByClassName("title")[0];
var time = document.getElementsByClassName("time")[0];
var pstimg = document.getElementById("pstimg");
var touPic = document.getElementsByClassName("touPic");
for(let i; i<touPic.length; i++) {
	touPic[i].src = "http://120.79.86.1:8080" + $.cookie('imge');
}
Return.onclick = function() {
	window.location.href='E:\网站\\一图寻物\\In.html'
}
for(let i=0; i<fenlei.length; i++) {
	fenlei[i].onclick = function() {
		if (fenlei[i].getElementsByTagName("ul")[0].style.display != 'none') {
			fenlei[i].getElementsByTagName("ul")[0].style.display = 'none';
		}else {
			fenlei[i].getElementsByTagName("ul")[0].style.display = 'flex';
		}
	}
}
for(let i=0; i<space.length; i++) {
	space[i].onclick = function() {
		fenlei[0].getElementsByTagName("input")[0].value = space[i].textContent;
	}
}
for(let i=0; i<card.length; i++) {
	card[i].onclick = function() {
		fenlei[1].getElementsByTagName("input")[0].value = card[i].textContent;
	}
}
planB.onkeyup = function() {
	var arry = new String();
	var Value = planB.value;
	for(var m=0; m<Value.length; m++) {
		arry = arry.concat(Value[m]);
	}
	if (arry.length>19) {
		alert("最多输入5个数字或字母");
		planB.value = arry.substr(0,20);
		return;
	}
}
submmit.onclick = function() {
	for(var i=0; i<document.getElementsByTagName("input").length; i++) {
		if (document.getElementsByTagName("input")[i].value == '') {
			alert("请完成信息填写");
			return;
		}
	}
	alert("提交成功")
	window.location.href='http://120.79.86.1:8080/lostitems/FindBar.html'
	/*ajax({
		method: 'POST',
		url: 'http://120.79.86.1:8080/cqupt-items-platom/releaseFind',
		data: {
			findTime: time.value,
			findAddress: fenlei[0].textContent,
			species: fenlei[1].textContent,
			description: title.textContent,
			findItems: pstimg.name
		},
		async: true,
		dataType: 'JSON',
		success:function(data) {
			var data = JSON.parse(data);
			if (data.status == 200) {
				alert("提交成功");
				window.location.href='E:\网站\\一图寻物\\In.html'
			}else {
				alert("提交失败请稍后重试")
			}
		},
		fail:function(data) {
			alert('请检查你的网络');
		}
	})*/
}

$(function(){
	$("#pstimg").change(function(){
		console.log("555")
		var file = this.files[0];
		alert("文件大小:"+(file.size / 1024).toFixed(1)+"kB");
		if (window.FileReader) {
			var reader = new FileReader();
			reader.readAsDataURL(file);
			//监听文件读取结束后事件
			reader.onloadend = function (e) {
				showXY(e.target.result,file.fileName);
			};
		}
	});
});
function showXY(source){
	var img = document.getElementById("loc_img");
	img.src = source;
	alert("Width:"+img.width+", Height:"+img.height);
}