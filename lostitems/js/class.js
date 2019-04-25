var classCh = document.getElementsByClassName("classCh");
var Class = document.getElementsByClassName("class")[0];
var Class1 = document.getElementsByClassName("class1")[0];
var Class2 = document.getElementsByClassName("class2")[0];
var Class3 = document.getElementsByClassName("class3")[0];
var Class4 = document.getElementsByClassName("class4")[0];
var moreCard = Class.getElementsByClassName("moreCard");
var moreBook = Class2.getElementsByClassName("moreBook");
var moreWallet = Class1.getElementsByClassName("moreWallet");
var moreJi = Class3.getElementsByClassName("moreJi");
var more = Class4.getElementsByClassName("more");
var Card = document.getElementsByClassName("Card");
var Wallet = document.getElementsByClassName("Wallet");
var Book = document.getElementsByClassName("Book");
var Ji = document.getElementsByClassName("Ji");
var returnCard = document.getElementsByClassName("returnCard");
var returnWallet = document.getElementsByClassName("returnWallet");
var returnBook = document.getElementsByClassName("returnBook");
var returnJi = document.getElementsByClassName("returnJi");
var returnCard = document.getElementsByClassName("returnCard");
var touPic = document.getElementsByClassName("touPic");
var userName = document.getElementsByClassName("useName")[0];
userName.textContent = $.cookie('username');
for(let i; i<touPic.length; i++) {
	touPic[i].src = "http://120.79.86.1:8080" + $.cookie('imge');
}
var tanForm = document.getElementsByClassName("tanForm")[0];
var tanForm1 = document.getElementsByClassName("tanForm1")[0];
var tanForm1Return = tanForm.getElementsByTagName("button")[0];
var demotest = document.getElementsByClassName("demotest");
var tanForm2 = document.getElementsByClassName("tanForm2")[0];
var tanForm2Return = tanForm2.getElementsByTagName("button")[0];
tanForm1Return.onclick = function() {
	tanForm1.style.display="none";
	tanForm.style.display="none";
}
demotest[0].onclick = function() {
	tanForm1.style.display="flex";
	tanForm.style.display="flex";
}
demotest[1].onclick = function() {
	tanForm1.style.display="flex";
	tanForm.style.display="flex";
}
tanForm1Return.onclick = function() {
	tanForm1.style.display="none";
	tanForm.style.display="none";
}
tanForm2Return.onclick = function() {
	tanForm1.style.display="none";
	tanForm2.style.display="none";
}
demotest[2].onclick = function() {
	tanForm.style.display="none";
	tanForm1.style.display="flex";
	tanForm2.style.display="flex";
}
demotest[3].onclick = function() {
	tanForm.style.display="none";
	tanForm1.style.display="flex";
	tanForm2.style.display="flex";
}
/*ajax({
	method: 'POST',
	url: 'http://120.79.86.1:8080/pagination/pagination.action',
	data: {
		species: "一卡通",
		page: 1,
		pagecord: 4
	},
	async: true,
	dataType: 'JSON',
	success:function(data) {
		var data = JSON.parse(data);
		var img = Class.getElementsByClassName("img")[0];
		var relimg = img.getElementsByTagName("img");
		for(let i=0; i<relimg.length; i++) {
			relimg[i].src = "http://120.79.86.1:8080" + data.beanList.pageInfo.list.image;
		}
	},
	fail:function(data) {
		alert('请检查你的网络');
	}
})
ajax({
	method: 'POST',
	url: 'http://120.79.86.1:8080/pagination/pagination.action',
	data: {
		species: "银行卡",
		page: 1,
		pagecord: 4
	},
	async: true,
	dataType: 'JSON',
	success:function(data) {
		var data = JSON.parse(data);
		var img = Class.getElementsByClassName("img")[0];
		var relimg = img.getElementsByTagName("img");
		for(let i=0; i<relimg.length; i++) {
			relimg[i].src = "http://120.79.86.1:8080" + data.beanList.pageInfo.list.image;
		}
	},
	fail:function(data) {
		alert('请检查你的网络');
	}
})
ajax({
	method: 'POST',
	url: 'http://120.79.86.1:8080/pagination/pagination.action',
	data: {
		species: "其他",
		page: 1,
		pagecord: 4
	},
	async: true,
	dataType: 'JSON',
	success:function(data) {
		var data = JSON.parse(data);
		var img = Class.getElementsByClassName("img")[0];
		var relimg = img.getElementsByTagName("img");
		for(let i=0; i<relimg.length; i++) {
			relimg[i].src = "http://120.79.86.1:8080" + data.beanList.pageInfo.list.image;
		}
	},
	fail:function(data) {
		alert('请检查你的网络');
	}
})*/
for(let i=0; i<classCh.length; i++) {
	classCh[i].onclick = function() {
		switch (i) {
			case 0:
				appearClass(0);
				var div = Class.getElementsByTagName("div");
				
				break;
			case 1:
				appearClass1(1);
				var div = Class.getElementsByTagName("div");
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
							for(let i; i<div.length; i++) {
								img = div[i].getElementsByTagName("img");
								for(let m; m<div.length; m++) {
									img[m].src = data.
								}
							}
						}else {
							alert(data.)
						}
					},
					fail:function(data) {
						alert('请检查你的网络');
					}
				})*/
				break;
			case 2:
				appearClass2(i);
				var div = Class.getElementsByTagName("div");
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
							for(let i; i<div.length; i++) {
								img = div[i].getElementsByTagName("img");
								for(let m; m<div.length; m++) {
									img[m].src = data.
								}
							}
						}else {
							alert(data.)
						}
					},
					fail:function(data) {
						alert('请检查你的网络');
					}
				})*/
				break;
			case 3:
				appearClass3(i);
				var div = Class.getElementsByTagName("div");
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
							for(let i; i<div.length; i++) {
								img = div[i].getElementsByTagName("img");
								for(let m; m<div.length; m++) {
									img[m].src = data.
								}
							}
						}else {
							alert(data.)
						}
					},
					fail:function(data) {
						alert('请检查你的网络');
					}
				})*/
				break;
			case 4:
				appearClass4(i);
				var div = Class.getElementsByTagName("div");
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
							for(let i; i<div.length; i++) {
								img = div[i].getElementsByTagName("img");
								for(let m; m<div.length; m++) {
									img[m].src = data.
								}
							}
						}else {
							alert(data.)
						}
					},
					fail:function(data) {
						alert('请检查你的网络');
					}
				})*/
				break;
			default:
				break;
		}
	}
}
for(let i=0; i<moreCard.length; i++) {
	moreCard[i].onclick = function() {
		Class.style.display = 'none';
		for(let m=0; m<Card.length; m++) {
			Card[m].style.display = "none";
		}
		var img = Card[i].getElementsByTagName("img");
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
					for(let i; i<img.length; i++) {
							img[i].src = data.
					}
				}else {
					alert(data.)
				}
			},
			fail:function(data) {
				alert('请检查你的网络');
			}
		})*/
		Card[i].style.display = "flex";
	}
}
for(let i=0; i<moreWallet.length; i++) {
	moreWallet[i].onclick = function() {
		Class1.style.display = 'none';
		for(let m=0; m<Wallet.length; m++) {
			Wallet[m].style.display = "none";
		}
		var img = Card[i].getElementsByTagName("img");
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
					for(let i; i<img.length; i++) {
							img[i].src = data.
					}
				}else {
					alert(data.)
				}
			},
			fail:function(data) {
				alert('请检查你的网络');
			}
		})*/
		Wallet[i].style.display = "flex";
	}
}
for(let i=0; i<moreBook.length; i++) {
	moreBook[i].onclick = function() {
		Class2.style.display = 'none';
		for(let m=0; m<Book.length; m++) {
			Book[m].style.display = "none";
		}
		var img = Card[i].getElementsByTagName("img");
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
					for(let i; i<img.length; i++) {
							img[i].src = data.
					}
				}else {
					alert(data.)
				}
			},
			fail:function(data) {
				alert('请检查你的网络');
			}
		})*/
		Book[i].style.display = "flex";
	}
}
for(let i=0; i<moreJi.length; i++) {
	moreJi[i].onclick = function() {
		Class3.style.display = 'none';
		for(let m=0; m<Ji.length; m++) {
			Ji[m].style.display = "none";
		}
		var img = Card[i].getElementsByTagName("img");
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
					for(let i; i<img.length; i++) {
							img[i].src = data.
					}
				}else {
					alert(data.)
				}
			},
			fail:function(data) {
				alert('请检查你的网络');
			}
		})*/
		Ji[i].style.display = "flex";
	}
}
for(let i=0; i<returnCard.length; i++) {
	returnCard[i].onclick = function() {
		appearClass(0);
	}
}
for(let i=0; i<returnWallet.length; i++) {
	returnWallet[i].onclick = function() {
		appearClass1(1);
	}
}
for(let i=0; i<returnBook.length; i++) {
	returnBook[i].onclick = function() {
		appearClass2(2);
	}
}
for(let i=0; i<returnJi.length; i++) {
	returnJi[i].onclick = function() {
		appearClass3(3);
	}
}
function appearClass(i) {
	Class.style.display = "flex";
	Class1.style.display = "none";
	Class2.style.display = "none";
	Class3.style.display = "none";
	Class4.style.display = "none";
	for(let m=0; m<Card.length; m++) {
		Card[m].style.display = "none";
	}
	for(let m=0; m<Wallet.length; m++) {
		Wallet[m].style.display = "none";
	}
	for(let m=0; m<Book.length; m++) {
		Book[m].style.display = "none";
	}
	for(let m=0; m<Ji.length; m++) {
		Ji[m].style.display = "none";
	}
	for(let m=0; m<classCh.length; m++) {
		if (classCh[m].className.match(new RegExp("(\\s|^)" + 'bc' + "(\\s|$)"))) {
			classCh[m].className = "classCh";
		}
	}
	classCh[i].className += " " + 'bc';
}
function appearClass1(i) {
	Class1.style.display = "flex";
	Class.style.display = "none";
	Class2.style.display = "none";
	Class3.style.display = "none";
	Class4.style.display = "none";
	for(let m=0; m<Card.length; m++) {
		Card[m].style.display = "none";
	}
	for(let m=0; m<Wallet.length; m++) {
		Wallet[m].style.display = "none";
	}
	for(let m=0; m<Book.length; m++) {
		Book[m].style.display = "none";
	}
	for(let m=0; m<Ji.length; m++) {
		Ji[m].style.display = "none";
	}
	for(let m=0; m<classCh.length; m++) {
		if (classCh[m].className.match(new RegExp("(\\s|^)" + 'bc' + "(\\s|$)"))) {
			classCh[m].className = "classCh";
		}
	}
	classCh[i].className += " " + 'bc';
}
function appearClass2(i) {
	Class2.style.display = "flex";
	Class1.style.display = "none";
	Class.style.display = "none";
	Class3.style.display = "none";
	Class4.style.display = "none";
	for(let m=0; m<Card.length; m++) {
		Card[m].style.display = "none";
	}
	for(let m=0; m<Wallet.length; m++) {
		Wallet[m].style.display = "none";
	}
	for(let m=0; m<Book.length; m++) {
		Book[m].style.display = "none";
	}
	for(let m=0; m<Ji.length; m++) {
		Ji[m].style.display = "none";
	}
	for(let m=0; m<classCh.length; m++) {
		if (classCh[m].className.match(new RegExp("(\\s|^)" + 'bc' + "(\\s|$)"))) {
			classCh[m].className = "classCh";
		}
	}
	classCh[i].className += " " + 'bc';
}
function appearClass3(i) {
	Class3.style.display = "flex";
	Class1.style.display = "none";
	Class2.style.display = "none";
	Class.style.display = "none";
	Class4.style.display = "none";
	for(let m=0; m<Card.length; m++) {
		Card[m].style.display = "none";
	}
	for(let m=0; m<Wallet.length; m++) {
		Wallet[m].style.display = "none";
	}
	for(let m=0; m<Book.length; m++) {
		Book[m].style.display = "none";
	}
	for(let m=0; m<Ji.length; m++) {
		Ji[m].style.display = "none";
	}
	for(let m=0; m<classCh.length; m++) {
		if (classCh[m].className.match(new RegExp("(\\s|^)" + 'bc' + "(\\s|$)"))) {
			classCh[m].className = "classCh";
		}
	}
	classCh[i].className += " " + 'bc';
}
function appearClass4(i) {
	Class4.style.display = "flex";
	Class1.style.display = "none";
	Class2.style.display = "none";
	Class3.style.display = "none";
	Class.style.display = "none";
	for(let m=0; m<Card.length; m++) {
		Card[m].style.display = "none";
	}
	for(let m=0; m<Wallet.length; m++) {
		Wallet[m].style.display = "none";
	}
	for(let m=0; m<Book.length; m++) {
		Book[m].style.display = "none";
	}
	for(let m=0; m<Ji.length; m++) {
		Ji[m].style.display = "none";
	}
	for(let m=0; m<classCh.length; m++) {
		if (classCh[m].className.match(new RegExp("(\\s|^)" + 'bc' + "(\\s|$)"))) {
			classCh[m].className = "classCh";
		}
	}
	classCh[i].className += " " + 'bc';
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