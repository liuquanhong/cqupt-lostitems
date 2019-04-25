var all = document.getElementsByClassName("all")[0];
var peopleMsg = new Array();
var moreDetals = new Array();
var tanForm = document.getElementsByClassName("tanForm")[0];
var tanFormSpan = tanForm.getElementsByTagName("span");
var tanFormImg = tanForm.getElementsByTagName("img")[0];
var tanForm1 = document.getElementsByClassName("tanForm1")[0];
var people = document.getElementsByClassName("people")[0];
var peopleSpan = people.getElementsByTagName("span");
var peopleImg = people.getElementsByTagName("img")[0];
var imging = document.getElementsByClassName("imging");
var imging1 = document.getElementsByClassName("imging1");
var peopleReturn = people.getElementsByTagName("button")[0];
var tanFormReturn = tanForm.getElementsByTagName("button")[0];
var touPic = document.getElementsByClassName("touPic");
var userName = document.getElementsByClassName("useName")[0];
userName.textContent = $.cookie('stdnumber');


if($.cookie('time') != undefined) {
var things = document.createElement("div");
things.className = "things";
var img = document.createElement("img");
var img1 = document.createElement("img");
var div1 = document.createElement("div");
var ID = document.createElement("div");
var time = document.createElement("div");
time.className = "time";
time.innerText = $.cookie('time');
ID.className = "ID";
div1.appendChild(ID);
div1.appendChild(time);
things.appendChild(img);
things.getElementsByTagName("img")[0].src = "imgs/card5.jpg"
things.appendChild(div1);
var name1 = document.createElement("span");
name1.className = "name"
name1.innerText = $.cookie('stdnumber');
div1.children[0].appendChild(img1);
div1.getElementsByTagName("img")[0].src = "imgs/touPic.jpg"
div1.children[0].appendChild(name1);
all.inserBofore(things, all.firstChild);
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





for(let i; i<touPic.length; i++) {
	touPic[i].src = "http://120.79.86.1:8080" + $.cookie('imge');
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
			alert("注销成功");
			for(var i=0; i<data.; i++) {
				var things = document.createElement("div");
				things.className = "things";
				var img = document.createElement("img");
				var img1 = document.createElement("img");
				var div1 = document.createElement("div");
				var ID = document.createElement("div");
				var time = document.createElement("div");
				time.className = "time";
				time.innerText = data.;
				ID.className = "ID";
				div1.appendChild(ID);
				div1.appendChild(time);
				things.appendChild(img);
				things.getElementsByTagName("img")[0].src = "demo"
				things.appendChild(div1);
				var name1 = document.createElement("span");
				name1.className = "name"
				name1.innerText = data.;
				// document.getElementsByTagName('ID')[0].appendChild(name);
				div1.children[0].appendChild(img1);
				div1.getElementsByTagName("img")[0].src = "demo"
				div1.children[0].appendChild(name1);
				all.appendChild(things);
				peopleMsg[i] = {
					username: data.,
					schoolNum : data.,
					phoneNum : data.,
					imgSrc: data.
				}
				moreDetals[i] = {
					fenlei: data.,
					elseMsg : data.,
					regMsg : data.,
					imgSrc: data.
				}
				all = document.getElementsByClassName("all")[0];
			}
		}else {
			alert(data.)
		}
	},
	fail:function(data) {
		alert('请检查你的网络');
	}
})*/

for(let i=0; i<imging.length; i++) {
	imging[i].onclick = function() {
		tanForm1.style.display="flex";
		people.style.display="flex";
		peopleSpan[0].innerText = peopleMsg[i].username;
		peopleSpan[1].innerText = peopleMsg[i].schoolNum;
		peopleSpan[2].innerText = peopleMsg[i].phoneNum;
		peopleImg.src = peopleMsg[i].imgSrc;
	}
}
peopleReturn.onclick = function() {
	tanForm1.style.display="none";
	people.style.display="none";
}


for(let i=0; i<imging1.length; i++) {
	imging1[i].onclick = function() {
		tanForm1.style.display="flex";
		tanForm.style.display="flex";
		tanFormSpan[0].innerText = moreDetals[i].fenlei;
		tanFormSpan[1].innerText = moreDetals[i].elseMsg;
		tanFormSpan[2].innerText = moreDetals[i].regMsg;
		tanFormImg.src = moreDetals[i].imgSrc;
	}
}
tanFormReturn.onclick = function() {
	tanForm1.style.display="none";
	tanForm.style.display="none";
}