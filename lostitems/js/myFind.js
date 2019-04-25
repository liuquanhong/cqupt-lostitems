
var real = document.getElementsByClassName("real")[0];
var content = document.createElement("div");
content.className = "content";
var imgClass = document.createElement("div");
imgClass.className = "img";
var TimeACt = document.createElement("div");
TimeACt.className = "TimeACt";
var detals = document.createElement("div");
detals.className = "detals";
detals.innerText = "java书";
var shi = document.createElement("span");
shi.className = "shi";
shi.innerText = "(失)";
var time = document.createElement("span");
time.className = "time";
time.innerText = "2018年10月17日发布";
var jifen = document.createElement("div");
jifen.className = "jifen";
var sureReturnButton = document.createElement("button");
sureReturnButton.className = "sureReturn";
sureReturnButton.innerText = "确认归还"
jifen.appendChild(sureReturnButton);
detals.appendChild(shi);
TimeACt.appendChild(detals);
TimeACt.appendChild(time);
var img = document.createElement("img");
imgClass.appendChild(img);
imgClass.getElementsByTagName("img")[0].src = "imgs/book.jpg";
content.appendChild(imgClass);
content.appendChild(TimeACt);
content.appendChild(jifen);
real.appendChild(content);
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
/*ajax({
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
				var detals = document.createElement("div");
				detals.className = "detals";
				detals.innerText = data.;
				var shi = document.createElement("span");
				shi.className = "shi";
				shi.innerText = "(失)";
				var time = document.createElement("span");
				time.className = "time";
				time.innerText = data.;
				var jifen = document.createElement("div");
				jifen.className = "jifen";
				var sureReturnButton = document.createElement("button");
				sureReturnButton.className = "sureReturn";
				sureReturnButton.innerText = "确认确认归还"
				jifen.appendChild(sureReturnButton);
				detals.appendChild(shi);
				TimeACt.appendChild(detals);
				TimeACt.appendChild(time);
				var img = document.createElement("img");
				imgClass.appendChild(img);
				imgClass.getElementsByTagName("img")[0].src = data.;
				content.appendChild(imgClass);
				content.appendChild(TimeACt);
				content.appendChild(jifen);
				real.appendChild(content);
			}
		}else {
			alert(data.)
		}
	},
	fail:function(data) {
		alert('请检查你的网络');
	}
})*/
var sureReturn = document.getElementsByClassName("sureReturn");
for(let i=0; i<sureReturn.length; i++) {
	sureReturn[i].onclick = function() {
		sureReturn[i].style.background = 'grey';
		sureReturn[i].innerText = "已归还+5分";
	}
}