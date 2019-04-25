var todayLost = document.getElementsByClassName("todayLost")[0];
var lunbo = todayLost.getElementsByClassName("lunbo")[0];
var one = document.getElementsByClassName("one");
var two = document.getElementsByClassName("two");
var three = document.getElementsByClassName("three");
var four = document.getElementsByClassName("four");
var five = document.getElementsByClassName("five");
var sendFind  = document.getElementsByClassName("send-find")[0];
var sendLost  = document.getElementsByClassName("send-lost")[0];
var bar = document.getElementsByClassName("bar");
var login = document.getElementsByClassName("login-in")[0];
var sign = document.getElementsByClassName("sign-in")[0];
lunbo.onclick = function() {
	window.location.href='http://120.79.86.1:8080/lostitems/class.html'
}


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
		if (data.) {
			one[0].src = data.;
			one[1].src = data.;
			one[2].src = data.;
			two[0].src = data.;
			two[1].src = data.;
			two[2].src = data.;
			three[0].src = data.;
			three[1].src = data.;
			three[2].src = data.;
			four[0].src = data.;
			four[1].src = data.;
			four[2].src = data.;
			five[0].src = data.;
			five[1].src = data.;
			five[2].src = data.;
		}else {
			alert(data.)
		}
	},
	fail:function(data) {
		alert('请检查你的网络');
	}
})*/
if (login.textContent == "登录") {
	console.log(555)
	login.onclick = function() {
		window.location.href='http://120.79.86.1:8080/lostitems/loginIn.html'
	}
	sign.onclick = function() {
		window.location.href='http://120.79.86.1:8080/lostitems/signIn.html'
	}
	sendFind.onclick = function() {
		alert("请先登录")
	}
	sendLost.onclick = function() {
		alert("请先登录")
	}
	for(let i=0; i<bar.length; i++) {
		bar[i].onclick = function() {
			alert("请先登录");
			return;
		}
	}
}else {
	var touPic = document.getElementsByClassName("touPic");
	var userName = document.getElementsByClassName("useName")[0];
	var zhuxiao = document.getElementsByClassName("zhuxiao")[0];
	userName.textContent = $.cookie('stdnumber');
	for(let i; i<touPic.length; i++) {
		touPic[i].src = "http://120.79.86.1:8080" + $.cookie('imge');
	}
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
			userName.textContent = data.beanList.useer.stdnumber;
			for(let i; i<touPic.length; i++) {
				touPic[i].src = "http://120.79.86.1:8080" + data.beanList.useer.imge;
			}
		},
		fail:function(data) {
			alert('请检查你的网络');
		}
	})*/
	login.onclick = function() {
		window.location.href='http://120.79.86.1:8080/lostitems/In.html'
	}
	sign.onclick = function() {
		/*ajax({
			method: 'POST',
			url: 'http://120.79.86.1:8080/pagination/pagination.action',
			data: {
				stop: 1
			},
			async: true,
			dataType: 'JSON',
			success:function(data) {
				var data = JSON.parse(data);
				if (data.) {
					alert("注销成功");
					window.location.href='http://120.79.86.1:8080/lostitems/index.html'
				}else {
					alert(data.)
				}
			},
			fail:function(data) {
				alert('请检查你的网络');
			}
		})*/
	}
	sendFind.onclick = function() {
		window.location.href='http://120.79.86.1:8080/lostitems/lost.html'
	}
	sendLost.onclick = function() {
		window.location.href='http://120.79.86.1:8080/lostitems/find.html'
	}
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
}

var timer = 0;
function play() {
	setTimeout(function() {
		timer += 1000;
		if(timer>2000) {
			timer = 0;
			lunbo.style.left = -timer + "px";
		}
		lunbo.style.left = -timer + "px";
		play();
		}, 2000)
}
play();