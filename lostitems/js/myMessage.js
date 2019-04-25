var reset = document.getElementsByClassName("reset");
var input = document.getElementsByTagName("input");
var setIn = document.getElementsByClassName("setIn")[0];
var resetImg = document.getElementsByClassName("resetImg")[0];
var sure = document.getElementsByClassName("sure")[0];
var cancel = document.getElementsByClassName("cancel")[0];
var tanForm = document.getElementsByClassName("tanForm")[0];
var tanForm1 = document.getElementsByClassName("tanForm1")[0];
var touPic = document.getElementsByClassName("touPic");
var userName = document.getElementsByClassName("useName")[0];
userName.textContent = $.cookie('stdnumber');
for(let i; i<touPic.length; i++) {
	touPic[i].src = "http://120.79.86.1:8080" + $.cookie('imge');
}
input[1].value = $.cookie('stdnumber')
input[2].value = $.cookie('telephone')
input[3].value = $.cookie('email')
input[4].value = $.cookie('password')

cancel.onclick = function() {
	tanForm.style.display = "none";
	tanForm1.style.display = "none";
}
for(let i=0; i<reset.length; i++) {
	reset[i].onclick = function() {
		input[i+1].focus();
	}
}
for(let i=0; i<input.length; i++) {
	if(i == 1) {
		
	}else {
		input[i].onkeyup = function() {
		if (i!=0) {
			var reg = checkChinese(input[i].value);
			var arry = new String();
			var Value = input[i].value;
			for(var m=0; m<Value.length; m++) {
				arry = arry.concat(Value[m]);
			}
			if (Value.length>11) {
				alert("最多输入10个数字或字母");
				input[i].value = arry.substr(0,12);
				return
			}
			if (reg == false) {
				alert("请输入字母或数字");
				input[i].value = '';
				return
			}
		}else {
			var arry = new String();
			var Value = input[i].value;
			for(var m=0; m<Value.length; m++) {
				arry = arry.concat(Value[m]);
			}
			if (Value.length>11) {
				alert("最多输入12个数字或字母");
				input[i].value = arry.substr(0,12);
				return
			}
		}
	}
	}
}
setIn.onclick = function() {
	for(var i=0; i<input.length; i++) {
		if (input[i].value == '') {
			alert("请输入您的账号和密码")
			return;
		}
	}
	ajax({
		method: 'POST',
		url: 'http://120.79.86.1:8080/cqupt-items-platom/updateUser',
		data: {
			stdnumber: input[1].value,
			password: input[2].value,
			phoneNum: input[3].value,
			qqEmail: input[4].value,
			userImg: picture
		},
		async: true,
		dataType: 'JSON',
		success:function(data) {
			var data = JSON.parse(data);
			$.cookie('stdnumber', input[1].value)
			$.cookie('telephone', input[2].value)
			$.cookie('email', input[3].value)
			$.cookie('password', input[4].value)
			ajax({
			method: 'POST',
			url: 'http://120.79.86.1:8080/cqupt-items-platom/login',
			data: {
				stdnumber: input[1].value,
				password: input[4].value
			},
			async: true,
			dataType: 'JSON',
			success:function(data) {
				var data = JSON.parse(data);
				if (data.status == 200) {
					alert("修改成功");
					$.cookie('uid', data.beanList.user.uid);
					$.cookie('stdnumber', data.beanList.user.stdnumber);
					$.cookie('telephone', data.beanList.user.telephone);
					$.cookie('email', data.beanList.user.email);
					$.cookie('password', data.beanList.user.password);
					$.cookie('imge', "http://120.79.86.1:8080" + data.beanList.user.imge);
					$.cookie('foundId', data.beanList.user.foundId);
					$.cookie('lostId', data.beanList.user.lostId);
					$.cookie('intergration', data.beanList.user.intergration);
					window.location.href='http://120.79.86.1:8080/lostitems/In.html'
				}else {
					alert(data.message)
				}
			},
			fail:function(data) {
				alert('请检查你的网络');
			}
		})
			if (data.status == 200) {
				alert("修改成功");
				window.location.href='http://120.79.86.1:8080/lostitems/In.html'
			}else {
				alert("请稍后重试")
			}
		},
		fail:function(data) {
			alert('请检查你的网络');
		}
	})
}
function checkChinese(str) {
	for (var i=0; i<str.length; i++) {
		
		console.log(str[i])
		if (str.charCodeAt(i)>255) {
			return false;
		}
		else {
			if (i>=str.length-1) {
				return true;
			}
		}
	}
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
var zhuxiao = document.getElementsByClassName("zhuxiao")[0];
zhuxiao.onclick = function() {
ajax({
	method: 'POST',
	url: 'http://120.79.86.1:8080/cqupt-items-platom/cancellation',
	data: {
		stop: 1
	},
	async: true,
	dataType: 'JSON',
	success:function(data) {
		var data = JSON.parse(data);
		if (data.status == 200) {
			alert("注销成功");
			window.location.href='http://120.79.86.1:8080/lostitems/index.html'
		}else {
			alert("请稍后重试");
		}
	},
	fail:function(data) {
		alert('请检查你的网络');
	}
})
}