var real = document.getElementsByClassName("real")[0];
var realing = document.getElementsByClassName("realing")[0];
var touPic = document.getElementsByClassName("touPic");
var userName = document.getElementsByClassName("useName")[0];
userName.textContent = $.cookie('stdnumber');
for(let i; i<touPic.length; i++) {
	touPic[i].src = "http://120.79.86.1:8080" + $.cookie('imge');
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
// var content = document.createElement("div");
/*content.className = "content";
var imgClass = document.createElement("div");
imgClass.className = "img";
var TimeACt = document.createElement("div");
TimeACt.className = "TimeACt";
var time = document.createElement("div");
time.className = "time";
time.innerText = "2018/11/03 17:30"
var img = document.createElement("img");
var detals = document.createElement("div");
detals.className = "detals";
detals.innerText = ""
var some = document.createElement("span");
some.className = "some";
some.innerText = "";
var more = document.createElement("span");
more.innerText = "【详情】";
imgClass.appendChild(img);
imgClass.getElementsByTagName("img")[0].src = "";
TimeACt.appendChild(detals);
some.appendChild(more);
TimeACt.appendChild(some);
content.appendChild(imgClass);
content.appendChild(TimeACt);
content.appendChild(time);
real.appendChild(content);
var arrySome = new Array();
var arryDetals = new Array();
ajax({
	method: 'POST',
	url: 'http://120.79.86.1:8080/pagination/pagination.action',
	data: {
	},
	async: true,
	dataType: 'JSON',
	success:function(data) {
		var data = JSON.parse(data);
		if (data.) {
			
			for(let i; i<100; i++) {
				var real = document.getElementsByClassName("real")[0];
				var content = document.createElement("div");
				content.className = "content";
				var imgClass = document.createElement("div");
				imgClass.className = "img";
				var TimeACt = document.createElement("div");
				TimeACt.className = "TimeACt";
				var time = document.createElement("div");
				time.className = "time";
				time.innerText = data.
				var img = document.createElement("img");
				var detals = document.createElement("div");
				detals.className = "detals";
				arryDetals.push(data.);
				detals.innerText = data.
				var some = document.createElement("span");
				some.className = "some";
				arrySome.push(data.);
				some.innerText = data.substr(0,20);
				var more = document.createElement("span");
				more.className = "more";
				more.innerText = "【详情】";
				imgClass.appendChild(img);
				imgClass.getElementsByTagName("img")[0].src = data.;
				TimeACt.appendChild(detals);
				some.appendChild(more);
				TimeACt.appendChild(some);
				content.appendChild(imgClass);
				content.appendChild(TimeACt);
				content.appendChild(time);
				real.appendChild(content);
			}
			var real = document.getElementsByClassName("real")[0];
		}else {
			alert(data.)
		}
	},
	fail:function(data) {
		alert('请检查你的网络');
	}
})*/
var more = real.getElementsByClassName("more");
var tanForm = document.getElementsByClassName("tanForm")[0];
var tanForm1 = document.getElementsByClassName("tanForm1")[0];
var tanForm2 = document.getElementsByClassName("tanForm2")[0];
var title = tanForm.getElementsByClassName("title");
var titleDiv1 = title[0].getElementsByTagName("div")[1];
var titleDiv2 = title[1].getElementsByTagName("div")[1];
var Return = tanForm.getElementsByClassName("return")[0];
var Return1 = tanForm2.getElementsByClassName("return")[0];
var sendmsg = document.getElementsByClassName("sendmsg")[0];
var submmit = document.getElementsByClassName("submmit")[0];

for(let i=0; i<more.length; i++) {
	more[i].onclick = function() {
		console.log(222);
		tanForm.style.display = "flex";
		tanForm1.style.display = "flex";
		titleDiv1.innerText = arrySome[i];
		titleDiv2.innerText = arryDetals[i];
	}
}
Return.onclick = function() {
	tanForm.style.display = "none";
	tanForm1.style.display = "none";
}
sendmsg.onclick = function() {
	tanForm2.style.display = "flex";
	tanForm1.style.display = "flex";
}
Return1.onclick = function() {
	tanForm2.style.display = "none";
	tanForm1.style.display = "none";
}
submmit.onclick = function() {
	var content = document.createElement("div");
	content.className = "content";
	var imgClass = document.createElement("div");
	imgClass.className = "img";
	var TimeACt = document.createElement("div");
	TimeACt.className = "TimeACt";
	var time = document.createElement("div");
	time.className = "time";
	time.innerText = "2018/11/03 17:30"
	var img = document.createElement("img");
	img.src = "imgs/touPic.jpg"
	var detals = document.createElement("div");
	detals.className = "detals";
	detals.innerText = tanForm2.getElementsByTagName("input")[0].value;
	var some = document.createElement("span");
	some.className = "some";
	some.innerText = tanForm2.getElementsByTagName("input")[1].value;
	var more = document.createElement("span");
	more.innerText = "【详情】";
	imgClass.appendChild(img);
	TimeACt.appendChild(detals);
	some.appendChild(more);
	TimeACt.appendChild(some);
	content.appendChild(imgClass);
	content.appendChild(TimeACt);
	content.appendChild(time);
	realing.insertBefore(content, realing.firstChild);
	var arrySome = new Array();
	var arryDetals = new Array();
	tanForm2.style.display = "none";
	tanForm1.style.display = "none";
	/*/*ajax({
		method: 'POST',
		url: 'http://120.79.86.1:8080/pagination/pagination.action',
		data: {
			title: tanForm2.getElementsByTagName("input")[0].innerText,
			moreMessge: tanForm2.getElementsByTagName("input")[0].innerText
		},
		async: true,
		dataType: 'JSON',
		success:function(data) {
			var data = JSON.parse(data);
			if (data.) {
				alert("提交成功");
			}else {
				alert(“请稍后重试)
			}
		},
		fail:function(data) {
			alert('请检查你的网络');
		}
	})*/
}