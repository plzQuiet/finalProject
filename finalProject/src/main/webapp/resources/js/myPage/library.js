const btn = document.querySelectorAll(".btn-area > button")

btn[0].addEventListener("click", e=>{
    fetch("/booksLoan")
    .then(resp => resp.json())
    .then(list => {
        for(let i=0; i<btn.length; i++){
            btn[i].classList.remove("selected");
            btn[i].classList.add("selected");
        }
    })
    .catch(e=>console.log(e))
})

btn[1].addEventListener("click", e=>{
    fetch("/loanHistory")
    .then(resp => resp.json())
    .then(list => {
        for(let i=0; i<btn.length; i++){
            btn[i].classList.remove("selected");
            btn[i].classList.add("selected");
        }
    })
    .catch(e=>console.log(e))
})

btn[2].addEventListener("click", e=>{
    fetch("/reservationBook")
    .then(resp => resp.json())
    .then(list => {
        for(let i=0; i<btn.length; i++){
            btn[i].classList.remove("selected");
            btn[i].classList.add("selected");
        }
    })
    .catch(e=>console.log(e))
})

btn[3].addEventListener("click", e=>{
    fetch("/bookRequestHistory")
    .then(resp => resp.json())
    .then(list => {
        for(let i=0; i<btn.length; i++){
            btn[i].classList.remove("selected");
            btn[i].classList.add("selected");
        }
    })
    .catch(e=>console.log(e))
})