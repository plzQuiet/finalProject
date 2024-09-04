const payBtn = document.getElementById("pay-btn");
const popUpHeader = document.getElementsByClassName("popup_header");
const popUpContent = document.getElementsByClassName("popup_content");

/* 식권 구매 모달 */
payBtn.addEventListener("click", ()=> {
	  
	popUpHeader[0].innerHTML= "<p>식권 구매</p>"
	popUpContent[0].innerHTML = `<div class="pay-meal-ticket">
									<div class="meal-ticket-amount">
										<p>식권</p>
										<div class="meal-ticket-btnArea">
											<input type="button" onclick='count("minus")' value='-' id="minusBtn" disabled='true'/>
											<div id="qty-result">0</div>
											<input type ="button" onclick='count("plus")' value='+' id="plusBtn"/>
										</div>
									</div>
									<hr/>
									<div class="meal-ticket-amount">
										<p>가격</p>
										<div id="price-result">0</div>
									</div>
								</div>
								`
	popUpLayer.style.display = 'block';
	  
	confirmBtn.innerText="결제";
})


/* count 함수  */

let qty = 0;
let price = 0;

function count(type){
	const qtyResult = document.getElementById("qty-result");
	const priceResult = document.getElementById("price-result");

	if(qty >= 1){
		// 더하기/ 빼기
		if(type === "plus"){
			qty += 1;
			price = 1 * qty;
		}else if(type === "minus"){
			qty -= 1;
			price = 1 * qty;
		}

	}else{
		
		// 더하기/ 빼기
		if(type === "plus"){
			qty += 1;
			price = 1 * qty;
		}
	}
 	
	if(qty>0){
		document.getElementById("minusBtn").disabled=false;
	}else{
		document.getElementById("minusBtn").disabled=true;
	}
	// 결과 출력
	qtyResult.innerText = qty;
	priceResult.innerText = price;

}

/* 취소 버튼 눌렀을 때, qty, price 초기화 */
cancelBtn.addEventListener("click", ()=>{
	qty = 0;
	price = 0;
})

/* 결제 버튼 눌렀을 때 결제창 api 시작해야됨 */
confirmBtn.addEventListener("click", ()=>{
	IMP.init('imp03608625');	// 아임포트 관리자 콘솔에서 확인한 '가맹점 식별코드' 입력
	IMP.request_pay({
		pg: "kakaopay.TC0ONETIME", 	//pg사명 or pg사명.CID (잘못 입력할 경우, 기본 PG사가 띄워짐)
		pay_method : "card",
		merchant_uid : "iamport_test_id",	// 가맹점 주문번호(아임포트를 사용하는 가맹점에서 중복되지 않은 임의의 문자열을 입력)
		name:"식권", //결제창에 노출될 상품명
		amount : price	// 금액
	}, function(resp){	// callback
		if(resp.success){
			popUpHeader[0].innerHTML= "<p>식권 구매</p>"
			popUpContent[0].innerHTML = `<div class="pay-meal-ticket">
											<p>구매가 완료되었습니다.</p>
										</div>
										
										`
			popUpLayer.style.display = 'block';
		}else{
			alert("실패 : 코드(" + resp.error_cod+") / 메세지(" + resp.error_msg + " )");
		}
	}
)
})
