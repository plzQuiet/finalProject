const writeBtn = document.getElementById("writeBtn");

writeBtn.addEventListener("click", ()=>{
    const input = document.querySelectorAll(".request-form input");
    
    for(let i=0; i<input.length; i++){
        if(input[i].value.trim().length == 0){
            alert("입력하지 않은 항목이 있습니다.");
            return;
        }
    }

    const obj = {
        requestNo : requestNo,
        reqTitle : input[0].value,
        bookTitle : input[2].value,
        bookAuthor : input[3].value,
        bookPub : input[4].value,
        bookPubDate : input[5].value,
        reqOpinion : document.getElementById("opinion").value
    };

    fetch("update", {
        method : "POST",
        headers : {"Content-Type" : "application/json"},
        body : JSON.stringify(obj)
    })
    .then(resp=>resp.text())
    .then(result=>{
        if(result > 0){
            popUpLayer.style.display = "block";
        }
    })
    .catch(e=>console.log(e))
})