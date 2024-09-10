// 예약 / 소장 정보 버튼 클릭 시 세부 정보를 표시/숨기기
document.addEventListener("DOMContentLoaded", function () {
    const informButtons = document.querySelectorAll("#informBtn");

    informButtons.forEach(function (button) {
        button.addEventListener("click", function () {
            const searchBodyDetail = this.closest(".searchBody").nextElementSibling;

            if (searchBodyDetail) {
                if (searchBodyDetail.style.display === "none" || searchBodyDetail.style.display === "") {
                    searchBodyDetail.style.display = "block"; // 표시
                } else {
                    searchBodyDetail.style.display = "none"; // 숨기기
                }
            }
        });
    });
});

// 예약하기 버튼 클릭 시 모달을 여는 코드
document.addEventListener("DOMContentLoaded", function () {
    const reservationButtons = document.querySelectorAll("#reservationBtn"); // 예약하기 버튼
    const popUpLayer = document.getElementById("popup_layer");
    const cancelBtn = document.getElementById("cancel_btn");
    const confirmBtn = document.getElementById("confirm_btn");
    const messageBox = document.getElementById("message_box");
    const detailBox= document.getElementById("detailBox");

    let step = 1; // 단계 (확인 버튼 구별 위함)

    reservationButtons.forEach(function (button) {
        button.addEventListener("click", function () {
            popUpLayer.style.display = 'block'; // 모달 열기
            messageBox.innerHTML = '도서 (도서이름)을 정말 예약하시겠습니까?' ;
            detailBox.innerHTML = '';
            cancelBtn.style.display="inline-block";
            step = 1;
        });
    });

    cancelBtn.addEventListener("click", function () {
        popUpLayer.style.display = 'none'; // 모달 닫기
    });

    // 모달 외부 클릭 시 닫기
    window.addEventListener("click", function (e) {
        if (e.target === popUpLayer) {
            popUpLayer.style.display = 'none';
        }
    });
    // 확인 버튼 클릭 시 모달 창 이동 
    // 확인 버튼 클릭 시 단계에 따라 다른 동작 수행
    confirmBtn.addEventListener("click", function () {
        if (step === 1) {
            // 첫 단계에서는 유의사항을 보여주고 단계 상태를 2로 변경
            messageBox.innerHTML = '도서 (도서이름)이 예약되었습니다.';
            detailBox.innerHTML = `
                <h2>도서 예약 유의 사항</h2>
                <ul>
                    <li>예약 후 24시간 내 본인 직접 수령이 원칙입니다.</li>
                    <li>예약 후 수령하지 않는 경우, 예약이 해제됩니다.</li>
                    <li>반복적으로 수령하지 않는 경우 불이익이 있을 수 있습니다.</li>
                    <li>예약 장소: JAVA LIBRARY</li>
                </ul>
            `;
            cancelBtn.style.display = 'none'; // 취소 버튼 숨기기
            step = 2; // 두 번째 단계로 변경
        } else if (step === 2) {
            // 두 번째 단계에서는 모달을 닫음
            popUpLayer.style.display = 'none';
        }
    });
});

// Kakao API 호출
$.ajax({
    method: "GET",
    url: "https://dapi.kakao.com/v3/search/book?target=title",
    data: { query: "잘린 머리처럼" },
    headers: { Authorization: "KakaoAK ae9b73b7e0b950cf9da13887e83fa9e1" }
})
    .done(function (msg) {
        console.log(msg);
        $("p").append("<strong>" + msg.documents[0].title + "</strong>");
        $("p").append("<img src='" + msg.documents[0].thumbnail + "'/>");
    });
