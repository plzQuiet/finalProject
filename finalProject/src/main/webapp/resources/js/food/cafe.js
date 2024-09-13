const popUpLayer = document.getElementById("popup_layer");

const payBtn = document.getElementById("pay-btn");
const popUpHeader = document.getElementsByClassName("popup_header");
const popUpContent = document.getElementsByClassName("popup_content");
const popupBox = document.getElementsByClassName("popup_box")[0];


/* cost : 전체 총합 */
/* price : 음식 각각 가격 */
/* qty : 수량 */
let cost = 0;
let price = 0;
let qty = 1;

/* 요소 구분을 위한 인덱스번호 */
var i = 1;
let itemPrices = {};  // 각 아이템의 가격을 저장할 객체

if(payBtn!= null){

	/* 음료 구매 모달 */
	payBtn.addEventListener("click", ()=> {
	
		/* 비동기 형식 */
		fetch("/api/cafe")
		.then(resp => resp.json())
		.then(result => {
			let html = ``;
			result.forEach(coffee => {
				html += `<div class="mcafe-menu" onclick='addCartMenu("${coffee.foodName}"," ${coffee.foodPrice}", "${coffee.foodNo}")'>
							<img src="${coffee.foodImg}">
							<div class="mcafe-menu-detail">
								<h4>${coffee.foodName}</h4>
								<span>${coffee.foodDes}</span>
								<div class="mcafe-menu-price">
									<span>${coffee.foodPrice}원</span>
								</div>
							</div>
						</div>`
			})
	
			$('.mcafe-menu-list').html(html)
		})
		.catch( e => {
			console.log("예외 발생!")
			console.log(e)
		})
	
	
		popUpHeader[0].innerHTML= "<p>음료 구매</p>"
		popUpContent[0].innerHTML = `
										<div class="mcafe">
											<div class="mcafe-menu-area">
												<p>메뉴 :</p>
												<div class="mcafe-menu-list">
												</div>
												
											</div>
											<div class="mcafe-cart-area">
												<div class="mcafe-cart">
													<p>장바구니 :</p>
													<div class="mcafe-cart-list">
														<table class="mcafe-cart-table">
														</table>
													</div>
												</div>
												<div class="mcafe-price">
													<p>가격 :</p>
													<div id="price-result"></div>
												</div>
											</div>
										</div>
										<div class="popup_btn">
											<button id="confirm_btn">결제</button>
											<button id="cancel_btn">취소</button>
										</div>
									`
		const popupBox = document.getElementsByClassName("popup_box")[0];
		popupBox.classList.add("mcafe-popupBox");
		popUpLayer.style.display = 'block';
	
		/* 동적으로 생성된 버튼에 이벤트 리스너 추가 */
		const confirmBtn = document.getElementById("confirm_btn");
		const cancelBtn = document.getElementById("cancel_btn");
	
		/* 결제 버튼임 */
		/* 결제 버튼 눌렀을 때 결제창 api 시작해야됨 */
		confirmBtn.addEventListener("click", ()=>{
			IMP.init('imp03608625');	// 아임포트 관리자 콘솔에서 확인한 '가맹점 식별코드' 입력
			IMP.request_pay(
				{
					pg: "kakaopay.TC0ONETIME", 	//pg사명 or pg사명.CID (잘못 입력할 경우, 기본 PG사가 띄워짐)
					pay_method : "card",
					merchant_uid : "merchant_" + new Date().getTime(),	// 가맹점 주문번호(아임포트를 사용하는 가맹점에서 중복되지 않은 임의의 문자열을 입력)
					name:"카페", //결제창에 노출될 상품명
					amount : cost	// 금액
					/* 나중에 DB와 연결할 때 쓸 듯 */
					/*
					buyer_email : 'iamport@siot.do'//구매자 이메일,
					buyer_name : '구매자이름',
					buyer_tel : '010-1234-5678'구매자 연락처,
					buyer_addr : '서울특별시 강남구 삼성동' // 구매자 주소,
					buyer_postcode : '123-456' // 구매자 우편번호
					*/
				}, function(resp){	// callback
					var result = '';
					popupBox.classList.remove("mcafe-popupBox");
					
					if(resp.success){
						popUpHeader[0].innerHTML= "<p>음료 구매</p>"
						popUpContent[0].innerHTML = `<div class="pay-meal-ticket">
														<p>구매가 완료되었습니다.</p>
													</div>
													<div class="popup_btn">
														<button id="agree_btn" onclick="agree()">확인</button>
													</div>
													`
						result='0';
						popUpLayer.style.display = 'block';
						itemPrices={};
						
	
					}else{
						popUpHeader[0].innerHTML= "<p>결제 실패</p>"
						popUpContent[0].innerHTML = `<div class="pay-meal-ticket">
														<p>${resp.error_msg}</p>
													</div>
													<div class="popup_btn">
														<button id="agree_btn" onclick="agree()">확인</button>
													</div>
													`
						result='1';
						popUpLayer.style.display = 'block';
						itemPrices={};
					}
	
					if(result == '0'){
						// location.href=
					}
				}
			)
		})
	
		/* 캔슬 버튼 */
		cancelBtn.addEventListener("click", ()=> {
			qty = 0;
			price = 0;
			cost = 0;
			itemPrices = {};
			popUpLayer.style.display = 'none';
		})
	
	});
}



/* function - cancel() */
function cancelCartMenu(i){
	const mCartMenu = document.getElementById("mcart-menu" +i);
	mCartMenu.remove();
	delete itemPrices[i];  // 아이템 목록에서 제거
	updateTotalCost();  // 총합 다시 계산

}


/* function - addCartMenu() */
function addCartMenu(name, price, foodNo){
	const mCartTable = document.getElementsByClassName("mcafe-cart-table")[0];

	// foodNo를 기반으로 해당 메뉴가 이미 카트에 있는지 확인
	for(let i in itemPrices){
		if(itemPrices[i].no== foodNo){
			// 이미 있으면 qty만 증가시키기
			itemPrices[i].qty += 1;
			const qtyResult = document.getElementById("qty-result" + i);
			qtyResult.innerText = itemPrices[i].qty;

			// 총합 업데이트
			updateTotalCost();
			return;
		}
	}

	/* 해당 메뉴가 처음 추가될 때만 초기 수량 설정 */
	if (!itemPrices[i]) {
		itemPrices[i] = {price: Number(price), qty: 1 , no:foodNo};
	}

	/* 조건문 추가해야됨 -> 만약 cart에 물건이 담겨 있다면 +가 자동적으로 되게 */
	mCartTable.innerHTML += `
								<tr class="mcafe-cart-menu" id="mcart-menu${i}">
									<td>
										<span>${name}</span>
										<input type="button" value='x' onclick='cancelCartMenu(${i})' id="cancelBtn"/>
									</td>
									<td class="meal-ticket-btnArea">
										<input type="button" onclick='count("minus", ${i})' value='-' class="minusBtn" id="minusBtn${i}"/>
										<div class="qty-result" id="qty-result${i}">1</div>
										<input type ="button" onclick='count("plus", ${i++})' value='+' id="plusBtn"/>
									</td>
								</tr>
							`;

		updateTotalCost();
	/* cost += Number(price);
	const priceResult = document.getElementById("price-result");
	priceResult.innerText = cost + "원"; */
}

/* count 함수  */
function count(type, i){
	const qtyResult = document.getElementById("qty-result"+i);
	let qty =  parseInt(qtyResult.innerText, 10);

	if(type === "plus"){
		qty += 1;

	}else if(type === "minus" && qty > 0){
		qty-=1;
	}

	// 수량 변경 적용
	itemPrices[i].qty = qty;
	qtyResult.innerText = qty;

	// 마이너스 버튼 block하기
	if (qty == 0) {
		document.getElementById("minusBtn"+i).style.backgroundColor='#ddd';
	} else {
		document.getElementById("minusBtn"+i).style.backgroundColor='#8FB788';
	}

	// 총합 업데이트
	updateTotalCost();
 	
}

/* 총합 업데이트 함수 */
function updateTotalCost() {
	cost = 0;  // 총합 초기화
	for (let key in itemPrices) {
		let item = itemPrices[key];
		cost += item.price * item.qty;
	}
	const priceResult = document.getElementById("price-result");
	cost = cost.toLocaleString('ko-KR');
	priceResult.innerText = cost + "원";
}


/* agree 함수 */
function agree(){
	popUpLayer.style.display = 'none';
	window.location.reload();
}

/* ***************** 관리자 ************************************** */

/* 메뉴 삭제 */
document.querySelectorAll('#menu-del-btn').forEach(button => {
    button.addEventListener('click', function() {
        const foodNo = this.getAttribute('foodNo');

		fetch("/food/del", {
			method: "PUT",
			headers : {"Content-Type" : "application/json"},
       	 	body: JSON.stringify(foodNo)
		})
		.then(resp=> resp.text())
		.then(result => {

			if(result>0){
				popupBox.classList.remove("menu-add-popupBox");
				popUpLayer.style.display = 'block';
				popUpHeader[0].innerHTML= "<p>메뉴 삭제</p>"
				popUpContent[0].innerHTML= `
												<p style="margin:20px">정말 해당 메뉴를 삭제하시겠습니까?</p>
												<div class="popup_btn">
													<button id="agree_btn" onclick="agreeDel()">확인</button>
													<button id="cancel_btn" type="button" onclick="cancel()">취소</button>
												</div>
											`

				
			}else{
				popupBox.classList.remove("menu-add-popupBox");
				popUpLayer.style.display = 'block';
				popUpHeader[0].innerHTML= "<p>메뉴 삭제</p>"
				popUpContent[0].innerHTML= `
												<p>메뉴 삭제에 실패하였습니다.</p>
												<div class="popup_btn">
													<button id="agree_btn" onclick="agree()">확인</button>
												</div>
											`
			}
		})
		.catch( e=> console.log(e))
    });
});

function cancel(){
	popUpLayer.style.display = 'none';
}

function agreeDel(){
	popupBox.classList.remove("menu-add-popupBox");
	popUpLayer.style.display = 'block';
	popUpContent[0].innerHTML=	 `
									<p>삭제되었습니다!</p>
									<div class="popup_btn">
										<button id="agree_btn" onclick="agree()">확인</button>
									</div>
								`
}