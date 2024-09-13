/* 알림창 변수 선언 */
/* 알림창 전체 */
const popupNoticeLayer = document.getElementById("popup_layer");

/* 알림창 내용 */
const popupNoticeContent = document.querySelector(".popup_content > p");

if(message != ""){
    popupNoticeLayer.style.display = "block";
    openNoticeMessage(message);
}

function openNoticeMessage(message){
    popupNoticeContent.innerHTML = message;
    document.getElementById("confirm_btn").setAttribute("onClick", "closeNoticeMessage()");
}

function closeNoticeMessage(){
    popupNoticeLayer.style.display = "none";
}