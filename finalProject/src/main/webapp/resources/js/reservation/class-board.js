/* 알림창 모달 */
const popupLayer = document.getElementById("popup_layer");
const cancelPopup = document.getElementById("cancel_btn");

/* 게시글 작성 모달 열기 */
function writeModal(e){
    popupLayer.style.display = "block";
}
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

/* 알림창 모달 닫기 */
cancelPopup.addEventListener("click",() => {
    popupLayer.style.display = "none";
});