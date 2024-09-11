function cancle(rNo){
    fetch("/bookCancle",{
        method : "DELETE",
        headers : {"Content-Type" : "application/json"},
        body : rNo
    })
    .then(resp => resp.text())
    .then(result => {
        if(result == 0){
            alert("실패");
            return;
        }

        location.reload();
    })
    .catch(e=>console.log(e))
}