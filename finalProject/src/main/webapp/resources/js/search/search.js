// search 페이지
// 검색 
function searchBooks() {
    const query = document.getElementById('query').value;
    const key = document.getElementById('key').value;
    
    $.ajax({
        url: '/searchBook',  // 컨트롤러로 검색 요청을 보냄
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify({
            query: query,
            key: key
        }),
        success: function(data) {
            console.log("검색 성공:", data);
            
            // 결과를 표시할 div
            let resultDiv = document.getElementById('result');
            resultDiv.innerHTML = "";  // 이전 검색 결과 초기화

            if (data.length > 0) {
                // 검색 결과가 있을 때
                data.forEach(function(book) {
                    resultDiv.innerHTML += `
                        <div>
                            <img src="${book.bookThumbnail}" alt="Thumbnail" style="width:100px;height:150px;" />
                            <p><strong>${book.bookTitle}</strong> (${book.bookAuthor})</p>
                            <p>ISBN: ${book.bookIsbn}</p>
                            <p>상태: ${book.bookState}</p>
                            <hr />
                        </div>
                    `;
                });
            } else {
                // 검색 결과가 없을 때
                resultDiv.innerHTML = "<p>검색 결과가 없습니다.</p>";
                console.log(query);
                console.log(key);
            }
        },
        error: function() {
            console.log("검색 중 에러 발생");
            document.getElementById('result').innerHTML = "<p>검색 중 오류가 발생했습니다.</p>";
        }
    });
}

// swiper
const sampleSlider = new Swiper('.sample', {
    slidesPerView: 3,
    spaceBetween: 10,
    navigation: {
        nextEl: ".swiper-button-next",
        prevEl: ".swiper-button-prev"
    }
})







