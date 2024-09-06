// 예약 / 소장 정보 버튼 클릭 시
document.addEventListener("DOMContentLoaded", function() {
   
    const informButtons = document.querySelectorAll("#informBtn");
    
    
    informButtons.forEach(function(button) {
        button.addEventListener("click", function() {
           
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


$.ajax({
    method: "GET",
    url: "https://dapi.kakao.com/v3/search/book?target=title",
    data: { query:"잘린 머리처럼" },
    headers: {Authorization: "KakaoAK ae9b73b7e0b950cf9da13887e83fa9e1" }
  })
    .done(function( msg ) {
      console.log(msg);
      $( "p").append("<strong>"+msg.documnets[0].title+"</strong>");
      $( "p").append("<img src='"+msg.documnets[0].thumbnail+"'/>");
    });
