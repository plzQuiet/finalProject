const popUpLayer = document.getElementById("popup_layer");

const payBtn = document.getElementById("pay-btn");
const popUpHeader = document.getElementsByClassName("popup_header");
const popUpContent = document.getElementsByClassName("popup_content");

/* 음료 구매 모달 */
payBtn.addEventListener("click", ()=> {
	  
	popUpHeader[0].innerHTML= "<p>음료 구매</p>"
	popUpContent[0].innerHTML = `
                                    <div class="mcafe">
                                        <div class="mcafe-menu-area">
											<p>메뉴 :</p>
											<div class="mcafe-menu-list">
												<div class="mcafe-menu">
													<img src="/resources/images/food/americano.png">
													<div class="mcafe-menu-detail">
														<h4>아메리카노 (Iced)</h4>
														<span>아이스 아메리카노이다. 생명수이다.</span>
														<div class="mcafe-menu-price">
															<span>3500원</span>
														</div>
													</div>
												</div>

												<div class="mcafe-menu">
													<img src="/resources/images/food/americano.png">
													<div class="mcafe-menu-detail">
														<h4>아메리카노 (Iced)</h4>
														<span>아이스 아메리카노이다. 생명수이다.</span>
														<div class="mcafe-menu-price">
															<span>3500원</span>
														</div>
													</div>
												</div>

												
												<div class="mcafe-menu">
													<img src="/resources/images/food/americano.png">
													<div class="mcafe-menu-detail">
														<h4>아메리카노 (Iced)</h4>
														<span>아이스 아메리카노이다. 생명수이다.</span>
														<div class="mcafe-menu-price">
															<span>3500원</span>
														</div>
													</div>
												</div>
												
												<div class="mcafe-menu">
													<img src="/resources/images/food/americano.png">
													<div class="mcafe-menu-detail">
														<h4>아메리카노 (Iced)</h4>
														<span>아이스 아메리카노이다. 생명수이다.</span>
														<div class="mcafe-menu-price">
															<span>3500원</span>
														</div>
													</div>
												</div>

												<div class="mcafe-menu">
													<img src="/resources/images/food/americano.png">
													<div class="mcafe-menu-detail">
														<h4>아메리카노 (Iced)</h4>
														<span>아이스 아메리카노이다. 생명수이다.</span>
														<div class="mcafe-menu-price">
															<span>3500원</span>
														</div>
													</div>
												</div>
												
											</div>
											
                                        </div>
                                        <div class="mcafe-cart-area">
											<div class="mcafe-cart">
												<p>장바구니 :</p>
												<div class="mcafe-cart-list">
													<div class="mcafe-cart-menu">
														<p>아메리카노(Iced)</p>
														<div class="meal-ticket-btnArea">
															<input type="button" onclick='count("minus")' value='-' id="minusBtn" disabled='true'/>
															<div id="qty-result">0</div>
															<input type ="button" onclick='count("plus")' value='+' id="plusBtn"/>
														</div>
													</div>
													
													<div class="mcafe-cart-menu">
														<p>아메리카노(Iced)</p>
														<div class="meal-ticket-btnArea">
															<input type="button" onclick='count("minus")' value='-' id="minusBtn" disabled='true'/>
															<div id="qty-result">0</div>
															<input type ="button" onclick='count("plus")' value='+' id="plusBtn"/>
														</div>
													</div>

													<div class="mcafe-cart-menu">
														<p>아메리카노(Iced)</p>
														<div class="meal-ticket-btnArea">
															<input type="button" onclick='count("minus")' value='-' id="minusBtn" disabled='true'/>
															<div id="qty-result">0</div>
															<input type ="button" onclick='count("plus")' value='+' id="plusBtn"/>
														</div>
													</div>

													<div class="mcafe-cart-menu">
														<p>아메리카노(Iced)</p>
														<div class="meal-ticket-btnArea">
															<input type="button" onclick='count("minus")' value='-' id="minusBtn" disabled='true'/>
															<div id="qty-result">0</div>
															<input type ="button" onclick='count("plus")' value='+' id="plusBtn"/>
														</div>
													</div>

													<div class="mcafe-cart-menu">
														<p>아메리카노(Iced)</p>
														<div class="meal-ticket-btnArea">
															<input type="button" onclick='count("minus")' value='-' id="minusBtn" disabled='true'/>
															<div id="qty-result">0</div>
															<input type ="button" onclick='count("plus")' value='+' id="plusBtn"/>
														</div>
													</div>
												</div>
											</div>
											<div class="mcafe-price">
												<p>가격 :</p>
												<p>가격금액</p>
											</div>
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
