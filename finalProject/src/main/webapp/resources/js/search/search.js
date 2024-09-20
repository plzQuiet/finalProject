const query = document.getElementById("query");
const queryResult = document.getElementById("queryResult");
const searchBtn = document.getElementById("searchBtn");

searchBtn.addEventListener("click", ()=>{

    const options = document.querySelectorAll("#key > option");

    let key;
    for(let o of options){
        if(o.selected){
            key = o.value;
        }
    }

    if(query.value.trim().length != 0){
        fetch("/book/search?query=" + query.value + "&key=" + key)
        .then(resp => resp.json())
        .then(bList => {

            queryResult.innerText = ""
            
            if(bList.length == 0){
                return;
            }

            let value = "";

            for(let b of bList){
                const bookRow = document.createElement("div");
                bookRow.classList.add("book-row");

                const thumbnail = document.createElement("img");
                thumbnail.setAttribute("src", `${b.thumbnail}`);

                const bookInfo = document.createElement("div");
                bookInfo.classList.add("book-info");

                const span = document.createElement("span");
                span.innerText = "☆";

                const p1 = document.createElement("p");
                p1.innerText = `${b.bookTitle}`;
                const p2 = document.createElement("p");
                p2.innerText = `${b.bookAuthor}`
                const p3 = document.createElement("p");
                p3.innerText = `${b.isbn}`;
                const p4 = document.createElement("p");
                p4.innerText = `책상태 : `;
                
                const borrowText = document.createElement("span");
                borrowText.style.color = "red";
                borrowText.innerText = "대출 불가능";

                const resvBtn = document.createElement("button");
                resvBtn.classList.add("resvBtn");
                resvBtn.innerText = `예약 / 소장정보`;

                const i = document.createElement("i");
                i.classList.add("fa-solid", "fa-caret-down");

                resvBtn.append(i);

                p4.append(borrowText, resvBtn);

                bookInfo.append(p1, p2, p3, p4);

                bookRow.append(thumbnail, bookInfo, span);

                queryResult.append(bookRow);

            }
        })
        .catch(e => console.log(e))
    }
})


// swiper
const sampleSlider = new Swiper('.sample', {
    slidesPerView: 3,
    spaceBetween: 10,
    navigation: {
        nextEl: ".swiper-button-next",
        prevEl: ".swiper-button-prev"
    }
})







