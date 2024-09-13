// 신청 버튼 클릭 시
const confirmBtn = document.getElementById("confirm_btn")
if(confirmBtn != null){ 
    confirmBtn.addEventListener("click",()=>{
        location.href = 
    })
}


// 게시글 수정 버튼 클릭 시
const updateBtn = document.getElementById("updateBtn");

if(updateBtn != null){

    updateBtn.addEventListener("click",()=>{
        location.href = location.pathname + "/update" + location.search
    })
    
}


// 모달창 삭제 확인 버튼 클릭 시
const deleteConfirmBtn = document.getElementById("delete_confirm_btn");

if(deleteConfirmBtn != null){
    deleteConfirmBtn.addEventListener("click", ()=>{
        location.href = location.pathname + "/delete" + location.search
    })
}

// 목록으로
const goToListBtn = document.getElementById("goToListBtn")

if (goToListBtn != null) {

    goToListBtn.addEventListener("click",()=>{
    
        location.href = "/scheduling/" + cateCode + location.search;
    })

}



/* 알림창 모달 */
const popupLayer = document.getElementById("popup_layer");
const cancelPopup = document.getElementById("cancel_btn");


/* 클래스 신청 모달 열기 */
function applyModal(e){
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
