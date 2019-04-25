var login = document.getElementsByClassName("login-in")[0];
var sign = document.getElementsByClassName("sign-in")[0];
var bar = document.getElementsByClassName("bar");
var About = document.getElementsByClassName("About")[0];
if (login.textContent != "登录") {
	img = About.getElementsByTagName("img");
}

if (login.textContent != "登录") {
	for(let i=0; i<img.length; i++) {
	img[i].onclick = function() {
		switch (i) {
			case 0:
				window.location.href='http://120.79.86.1:8080/lostitems/myFind.html'
				loginIn.html
				break;
			case 1:
				window.location.href='http://120.79.86.1:8080/lostitems/myLost.html'
				break;
			case 2:
				window.location.href='http://120.79.86.1:8080/lostitems/myMessage.html'
				break;
			default:
				break;
		}	
	}
	var touPic = document.getElementsByClassName("touPic");
	var userName = document.getElementsByClassName("userName")[0];
	/*ajax({
		method: 'POST',
		url: 'http://120.79.86.1:8080/cqupt-items-platom/queryUserByLogin',
		data: {
			user: "用户信息"
		},
		async: true,
		dataType: 'JSON',
		success:function(data) {
			var data = JSON.parse(data);
			userName.textContent = data.beanList.user.telephone;
			for(let i; i<touPic.length; i++) {
				touPic[i].src = "http://120.79.86.1:8080" + data.beanList.useer.imge;
			}
		},
		fail:function(data) {
			alert('请检查你的网络');
		}
	})*/
}
for(let i=0; i<bar.length; i++) {
	bar[i].onclick = function() {
	switch (i) {
			case 0:
				window.location.href='http://120.79.86.1:8080/lostitems/In.html'
				break;
			case 1:
				window.location.href='http://120.79.86.1:8080/lostitems/class.html'
				break;
			case 2:
				window.location.href='http://120.79.86.1:8080/lostitems/LostBar.html'
				break;
			case 3:
				window.location.href='http://120.79.86.1:8080/lostitems/FindBar.html'
				break;
			case 4:
				window.location.href='http://120.79.86.1:8080/lostitems/talking.html'
				break;
			case 5:
				window.location.href='http://120.79.86.1:8080/lostitems/AboutUs.html'
				break;
			default:
				break;
		}	
	}
}
}