/* 알림창 모달 */
const popupLayer = document.getElementById("popup_layer");
const cancelPopup = document.getElementById("cancel_btn");

const reservPopup = document.getElementById("reserv_confirm_btn");

/* 클래스 신청 모달 열기 */
function applyModal(e){
    popupLayer.style.display = "block";
}
/* 게시글 수정 모달 열기 */
function updateModal(e){
    popupLayer.style.display = "block";
}
/* 게시글 삭제 모달 열기 */
function deleteModal(e){
    popupLayer.style.display = "block";
}
/* 게시글 등록 취소 모달 열기 */
function cancelModal(e){
    popupLayer.style.display = "block";
}

/* 게시글 등록 모달 열기 */
function registModal(e){
    popupLayer.style.display = "block";
}

/* 게시글 등록 모달 열기 */
function reservSeatModal(e){
    popupLayer.style.display = "block";
}

/* 알림창 모달 닫기 */
cancelPopup.addEventListener("click",() => {
    popupLayer.style.display = "none";
});



/* 예약 이력 모달 열기 */
reservPopup.addEventListener("click",() => {
    
    popupLayer.style.display = "block";
});