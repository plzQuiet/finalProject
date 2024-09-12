const popUpLayer = document.getElementById("popup_layer");

const payBtn = document.getElementById("pay-btn");
const popUpHeader = document.getElementsByClassName("popup_header");
const popUpContent = document.getElementsByClassName("popup_content");
const popupBox = document.getElementsByClassName("popup_box")[0];

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
			if(qty != 0 && price != 0){
				qty = 0;
				price = 0;
			}
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

function menuAddFrmModal(){
	
}

/* 메뉴 추가 */
if(menuAddBtn != null){
	menuAddBtn.addEventListener("click", () => {
		popUpHeader[0].innerHTML= "<p>메뉴 추가</p>"
		popUpContent[0].innerHTML = `
								<form action="/food/insert" method="POST" enctype="multipart/form-data" name="menuAddFrm" id="menuAddFrm">
									<div class="menu-add-area">
										<div class="menu-name-area">
											<p>이름 :</p>
											<input type="text" name="menuName"  id="menuName"/>
										</div>
										<div class="image-area">
											<p>이미지 :</p>
											<div class="left-image-area">
												<label for="menuImage"> 
													<img class="preview">
												</label> 
												<i class="fa-solid fa-xmark" id="delete-image-btn"></i>
												<input type="file" class="inputImage" id="menuImage" accept="image/*" name="menuImage"> 
											</div>

											<div class="right-image-area">
<pre>
- 이미지 등록 
(권장사이즈 : 가로 200px X 세로 150px 혹은 4 : 3 비율)
- 파일양식 : jpg, jpeg, png(8MB 제한)
</pre>
												<div class="image-btn">
													<button type="button" id="image-add-btn">사진등록</button>
												</div>
											</div>
										</div>
									</div>
									<div class="popup_btn">
										<button type="submit" id="confirm_btn" class="menu_add">추가</button>
										<button id="cancel_btn" type="button">취소</button>
									</div>
								</form>
									
									`
		
		popupBox.classList.add("menu-add-popupBox");
		popUpLayer.style.display = 'block';


		const preview = document.getElementsByClassName("preview")[0];
		const inputImage = document.getElementsByClassName("inputImage")[0];

		/* 캔슬 버튼 */
		document.getElementById("cancel_btn").addEventListener("click", ()=> {
			/* 이름이랑 image 삭제해야됨 */
			popUpLayer.style.display = 'none';
		})

		// 미리보기 삭제(x버튼)
		document.getElementById("delete-image-btn").addEventListener("click", e=>{

			// 미리보기 이미지가 있을 경우
			if(preview.getAttribute("src") != ""){

				preview.removeAttribute("src");

				inputImage.value="";
				$('#delete-image-btn').css('display', 'none');
			}
		})

		// 파일이 선택되거나, 선택 후 취소되었을 때
		$('.inputImage').on("change", e=>{
			const file = e.target.files[0]; // 선택된 파일의 데이터

			if(file != undefined){  // 파일이 선택되었을 때
				const reader = new FileReader();    // 파일을 읽는 객체

				reader.readAsDataURL(file);
				// 지정된 파일을 읽은 후 result에 URL 형식으로 저장

				reader.onload= e=>{ // 파일을 다 읽은 후 수행
					preview.setAttribute("src", e.target.result);
				}

				$('#delete-image-btn').css('display', 'block');

			}else{  // 선택 후 취소되었을 때
				// -> 선택된 파일 없음 -> 미리보기 삭제
				preview.removeAttribute("src");
				$('#delete-image-btn').css('display', 'none');
			}
		})


		/* 사진 등록 버튼 */
		$('#image-add-btn').on("click", ()=>{
			inputImage.click();
		})

		$('#confirm_btn').on("click", (e)=>{
			if(document.getElementById("menuName").value == 0 ){
				e.preventDefault();
				popupBox.classList.remove("menu-add-popupBox");
				popUpContent[0].innerHTML = `
					<p>메뉴 이름을 기입해주세요!</p>
					<div class="popup_btn">
						<button id="menu-add-btn" onclick="agree()">확인</button>
					</div>
				`
			}
		})
		
	})
}

/* agree 함수 */
function agree(){
	popUpLayer.style.display = 'none';
}

if(addMenu != ""){
	popupBox.classList.remove("menu-add-popupBox");
	popUpLayer.style.display = 'block';
	if(addMenu != 0){
		menuAddSuccess();
	}else{
		menuAddFail();
	}
}


/* 메뉴 추가 성공 */
function menuAddSuccess(){
	popUpContent[0].innerHTML = `
				<p>메뉴 추가가 완료되었습니다.</p>
				<div class="popup_btn">
				<button id="agree_btn" onclick="agree()">확인</button>
				</div>
				`
}

/* 메뉴 추가 실패 */
function menuAddFail(){
	popUpContent[0].innerHTML = `
				<p>메뉴 추가를 실패하였습니다.</p>
				<div class="popup_btn">
				<button id="agree_btn" onclick="agree()">확인</button>
				</div>
				`
}