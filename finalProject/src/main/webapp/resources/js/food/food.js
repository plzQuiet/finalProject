const popUpLayer = document.getElementById("popup_layer");

const payBtn = document.getElementById("pay-btn");
const popUpHeader = document.getElementsByClassName("popup_header");
const popUpContent = document.getElementsByClassName("popup_content");

if(payBtn != null){

	/* 식권 구매 모달 */
	payBtn.addEventListener("click", ()=> {
	
		popUpHeader[0].innerHTML= "<p>식권 구매</p>"
		popUpContent[0].innerHTML = `
										<div class="pay-meal-ticket">
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
										<div class="popup_btn">
											<button id="confirm_btn">결제</button>
											<button id="cancel_btn">취소</button>
										</div>
									`
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
					name:"식권", //결제창에 노출될 상품명
					amount : price	// 금액
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
					if(resp.success){
						popUpHeader[0].innerHTML= "<p>식권 구매</p>"
						popUpContent[0].innerHTML = `<div class="pay-meal-ticket">
														<p>구매가 완료되었습니다.</p>
													</div>
													<div class="popup_btn">
														<button id="agree_btn" onclick="agree()">확인</button>
													</div>
													`
						result='0';
						popUpLayer.style.display = 'block';
	
						
	
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
			popUpLayer.style.display = 'none';
		})
	
	});
}



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
			price = 6000 * qty;
		}else if(type === "minus"){
			qty -= 1;
			price = 6000 * qty;
		}

	}else{
		// 더하기/ 빼기
		if(type === "plus"){
			qty += 1;
			price = 6000 * qty;
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

/* 결제 완료 후 완료되었습니다. 했을 때 확인 버튼 */
function agree(){
	qty= 0;
	price=0;
	popUpLayer.style.display = 'none';
}

/* 관리자아아아아아ㅏ앙아ㅏ앙 */
const menuAddBtn = document.getElementById("menu-add-btn");
const menuUpdateBtn = document.getElementById("menu-update-btn");

/* 메뉴 추가 */
if(menuAddBtn != null){
	menuAddBtn.addEventListener("click", () => {
		popUpHeader[0].innerHTML= "<p>메뉴 추가</p>"
		popUpContent[0].innerHTML = `
										<div class="menu-add-area">
											<div class="menu-name-area">
												<p>이름 :</p>
												<input type="text"/>
											</div>
											<div class="image-area">
												<p>이미지 :</p>
												<div class="left-image-area">
													<label for="menuImage"> 
														<img class="preview">
													</label> 
													<input type="file" class="inputImage" id="menuImage" accept="image/*" name="menuImage"> 
													<span class="delete-image">&times;</span>
												</div>

												<div class="right-image-area">
<pre>
 - 이미지 등록 
(권장사이즈 : 가로 200px X 세로 150px 혹은 4 : 3 비율)
 - 파일양식 : jpg, jpeg, png(8MB 제한)
</pre>
													<div class="image-btn">
														<button type="button">사진등록</button>
													</div>
												</div>
											</div>
										</div>
										<div>
											<button>추가</button>
											<button>취소</button>
										</div>
									`
		const popupBox = document.getElementsByClassName("popup_box")[0];
		popupBox.classList.add("menu-add-popupBox");
		popUpLayer.style.display = 'block';
		  
	})
}

/* popupBox.classList.remove("menu-add-popupBox"); 나중에 줘야됨 */