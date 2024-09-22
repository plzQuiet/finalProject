const query = document.getElementById("query");
const queryResult = document.getElementById("queryResult");
const searchBtn = document.getElementById("searchBtn");

const sidelow = document.querySelectorAll(".side-side-current a");
for(let i=0; i<sidelow.length; i++){
    if(sidelow[i].getAttribute("href") == location.pathname){
        sidelow[i].style.fontWeight = "bold";
    }
}

searchBtn.addEventListener("click", ()=>{

    const options = document.querySelectorAll("#key > option");

    let key;
    for(let o of options){
        if(o.selected){
            key = o.value;
        }
    }

    if(query.value.trim().length != 0){
        fetch("/book/search?query=" + query.value + 
            "&key=" + key + "&memberNo=" + loginMemberNo)
        .then(resp => resp.json())
        .then(result => {

            const bList = result.bookList;
            const lList = result.likeList;

            queryResult.innerText = ""
            
            if(bList.length == 0){
                return;
            }

            for(let b of bList){
                const bookRow = document.createElement("div");
                bookRow.classList.add("book-row");

                const bookInfoWapper = document.createElement("div");
                bookInfoWapper.classList.add("book-info-wapper");

                const thumbnail = document.createElement("img");
                thumbnail.setAttribute("src", `${b.thumbnail}`);

                const bookInfo = document.createElement("div");
                bookInfo.classList.add("book-info");

                const span = document.createElement("span");
                if(lList.indexOf(b.bookNo) == -1){
                    span.innerText = "☆";

                }else{
                    span.innerText = "★";
                }

                const p1 = document.createElement("p");
                p1.innerText = `${b.bookTitle}`;
                const p2 = document.createElement("p");
                p2.innerText = `${b.bookAuthor}`
                const p3 = document.createElement("p");
                p3.innerText = `${b.isbn}`;
                const p4 = document.createElement("p");
                p4.innerText = `책상태 : `;
                
                const borrowText = document.createElement("span");

                if(b.bookState == 'I'){
                    borrowText.style.color = "red";
                    borrowText.innerText = "대출 불가능";
    
                    const resvBtn = document.createElement("button");
                    resvBtn.classList.add("resvBtn");
                    resvBtn.innerText = `예약 / 소장정보`;
                    resvBtn.addEventListener("click", e=>{
                        const table = e.target.parentElement.parentElement.parentElement.nextElementSibling;
                        console.log(table);
                        if(table.style.display == "none"){
                            table.style.display = "table";
                        }else{
                            table.style.display = "none";
                        }
                    });
    
                    const i = document.createElement("i");
                    i.classList.add("fa-solid", "fa-caret-down");

                    resvBtn.append(i);

                    p4.append(borrowText, resvBtn);
                    
                }else{
                    borrowText.style.color = "green";
                    borrowText.innerText = "대출 가능";
                    p4.append(borrowText);
                }

                bookInfo.append(p1, p2, p3, p4);

                bookInfoWapper.append(thumbnail, bookInfo, span);

                bookRow.append(bookInfoWapper);

                queryResult.append(bookRow);

                if(b.bookState == 'I'){
                    const table = document.createElement("table");
                    table.setAttribute("style", "display : none");
                    
                    const thead = document.createElement("thead");
                    const tbody = document.createElement("tbody");

                    const theadTr = document.createElement("tr");

                    const th1 = document.createElement("th");
                    th1.innerText = "도서관";
                    const th2 = document.createElement("th");
                    th2.innerText = "대출상태";
                    const th3 = document.createElement("th");
                    th3.innerText = "반납 예정일";
                    const th4 = document.createElement("th");
                    th4.innerText = "예약";
                    const th5 = document.createElement("th");
                    th5.innerText = "부록";
                    const th6 = document.createElement("th");
                    th6.innerText = "비고";

                    const tbodyTr = document.createElement("tr");

                    const td1 = document.createElement("td");
                    td1.innerText = `JAVA LIBRARY`;
                    const td2 = document.createElement("td");
                    td2.innerText = `대출 중
                                     (예약 가능)
                                     (예약 : ${b.resvCount}명)`;
                    const td3 = document.createElement("td");
                    td3.innerText = `${b.returnDueDate}`;
                    const td4 = document.createElement("td");
                    const td5 = document.createElement("td");
                    td5.innerText = `${(b.bookSupple == 'N' ? "없음" : "있음")}`;
                    const td6 = document.createElement("td");
                    td6.innerText = ``;
                    
                    const button = document.createElement("button");
                    button.innerText = "예약하기";

                    td4.append(button);

                    theadTr.append(th1, th2, th3, th4, th5, th6);
                    tbodyTr.append(td1, td2, td3, td4, td5, td6);

                    thead.append(theadTr);
                    tbody.append(tbodyTr);

                    table.append(thead, tbody);

                    bookRow.append(table);

                }
                
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







