var loginIn = document.getElementsByClassName("loginIn")[0];
var signIn = document.getElementsByClassName("signIn")[0];
var Return = document.getElementsByClassName("return")[0];
var input = document.getElementsByTagName("input");
var send = document.getElementById("send");
if (input.lenght>3) {
	var warn = document.getElementsByClassName("warn")[0];
}
loginIn.onclick = function() {
	window.location.href='http://120.79.86.1:8080/lostitems/loginIn.html'
}
signIn.onclick = function() {
	window.location.href='http://120.79.86.1:8080/lostitems/signIn.html'
}
Return.onclick = function() {
	window.location.href='http://120.79.86.1:8080/lostitems/index.html'
}


for(let i=0; i<input.length; i++) {
	input[i].onkeyup = function() {
		if (send.textContent == "注册") {
			var warn = document.getElementsByClassName("warn")[0];
			warn.style.display = "none";
		}
		var reg = checkChinese(input[i].value);
		var arry = new String();
		var Value = input[i].value;
		for(var m=0; m<Value.length; m++) {
			arry = arry.concat(Value[m]);
		}
		console.log(arry)
		if(i == 0){
			if (Value.length>10) {
				alert("最多输入10个数字或字母");
				input[i].value = arry.substr(0,10);
				return
			}
			if (reg == false) {
				alert("请输入字母或数字");
				input[i].value = '';
				return
			}
		}
		if(i == 1){
			if (Value.length>20) {
				alert("最多输入10个数字或字母");
				input[i].value = arry.substr(0,20);
				return
			}
			if (reg == false) {
				alert("请输入字母或数字");
				input[i].value = '';
				return
			}
		}
		if(i == 2){
			if (Value.length>20) {
				alert("最多输入10个数字或字母");
				input[i].value = arry.substr(0,20);
				return
			}
			if (reg == false) {
				alert("请输入字母或数字");
				input[i].value = '';
				return
			}
		}else {
			if (Value.length>11) {
				alert("最多输入12个数字或字母");
				input[i].value = arry.substr(0,12);
				return
			}
			if (reg == false) {
				alert("请输入字母或数字");
				input[i].value = '';
				return
			}
		}
 		
	}
}


send.onclick = function() {
	for(var i=0; i<input.length; i++) {
			if (input[i].value == '') {
				alert("请输入您的账号和密码")
				return;
			}
		}
	if (send.textContent == "登录") {
		ajax({
			method: 'POST',
			url: 'http://120.79.86.1:8080/cqupt-items-platom/login',
			data: {
				stdnumber: input[0].value,
				password: input[1].value
			},
			async: true,
			dataType: 'JSON',
			success:function(data) {
				var data = JSON.parse(data);
				if (data.status == 200) {
					alert("登陆成功");
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
	}
	if (send.textContent == "注册") {
		var warn = document.getElementsByClassName("warn")[0];
		if(input[0].value == "2017210404") {
			
			warn.style.display = "flex";
		}
		ajax({
			method: 'POST',
			url: 'http://120.79.86.1:8080/cqupt-items-platom/registr',
			data: {
				stdnumber: input[0].value,
				password: input[1].value,
				telephone: input[2].value,
				email: input[3].value
			},
			async: true,
			dataType: 'JSON',
			success:function(data) {
				var data = JSON.parse(data);
				if (data.status == 200) {
					alert("注册成功");
					window.location.href='http://120.79.86.1:8080/lostitems/loginIn.html'
				}
				else if(data.status == 500){
					alert(data.message);
				}else {
					alert(data.status)
				}
			},
			fail:function(data) {
				alert('请检查你的网络');
			}
		})
	}
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

