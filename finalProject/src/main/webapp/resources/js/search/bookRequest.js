
// 신청하기 버튼 클릭 시 모달을 여는 코드
document.addEventListener("DOMContentLoaded", function () {
    const requestBtn = document.querySelectorAll("#request-btn"); // 신청하기 버튼
    const popUpLayer = document.getElementById("popup_layer");
    const confirmBtn = document.getElementById("confirm_btn");


    

    requestBtn.forEach(function (button) {
        button.addEventListener("click", function () {
            popUpLayer.style.display = 'block'; // 모달 열기
            
            
        });
    });

    confirmBtn.addEventListener("click", function () {
        popUpLayer.style.display = 'none'; // 모달 닫기
    });

    // 모달 외부 클릭 시 닫기
    window.addEventListener("click", function (e) {
        if (e.target === popUpLayer) {
            popUpLayer.style.display = 'none';
        }
    });
   
 
});


