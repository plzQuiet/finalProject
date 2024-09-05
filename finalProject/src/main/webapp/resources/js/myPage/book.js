const btn = document.querySelectorAll(".btn-area > button")
const table = document.getElementById("list-table");
const thead = document.querySelector("#list-table > thead");
const tbody = document.querySelector("#list-table > tbody");

btn[0].addEventListener("click", e=>{
    fetch("/booksLoan")
    .then(resp => resp.json())
    .then(list => {
        if(list == null){
            return;
        }

        thead.innerHTML = `<tr>
                                <th>등록번호</th>
                                <th>도서명</th>
                                <th>대출일/반납예정일</th>
                                <th>대출상태</th>
                           </tr>`;
        
        tbody.innerHTML = "";
        
        let value = "";
        for(let item of list){
            value += `<tr>
						<td>JU0000041821</td>
						<td>${item.title}</td>
						<td>2008-02-21<br>2008-03-06</td>
						<td>연체중</td>
					  </tr>`;
        }

        for(let i=0; i<btn.length; i++){
            btn[i].classList.remove("selected");
        }
        btn[0].classList.add("selected");
    })
    .catch(e=>console.log(e))
})

btn[1].addEventListener("click", e=>{
    fetch("/loanHistory")
    .then(resp => resp.json())
    .then(list => {
        if(list == null){
            return;
        }

        for(let i=0; i<btn.length; i++){
            btn[i].classList.remove("selected");
        }
        btn[1].classList.add("selected");
    })
    .catch(e=>console.log(e))
})

btn[2].addEventListener("click", e=>{
    fetch("/reservationBook")
    .then(resp => resp.json())
    .then(list => {
        if(list == null){
            return;
        }

        for(let i=0; i<btn.length; i++){
            btn[i].classList.remove("selected");
        }
        btn[2].classList.add("selected");
    })
    .catch(e=>console.log(e))
})

btn[3].addEventListener("click", e=>{
    fetch("/bookRequestHistory")
    .then(resp => resp.json())
    .then(list => {
        if(list == null){
            return;
        }

        for(let i=0; i<btn.length; i++){
            btn[i].classList.remove("selected");
        }
        btn[3].classList.add("selected");
    })
    .catch(e=>console.log(e))
})