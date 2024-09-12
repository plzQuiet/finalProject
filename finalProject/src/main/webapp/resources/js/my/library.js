const side = document.querySelectorAll(".side-wrap > a");
const libNav = document.querySelectorAll(".nav-area > a");
const params = new URL(location.href).searchParams;

for(let i = 0; i < side.length; i++){
    if(side[i].getAttribute("href") == location.pathname){
        side[i].style.fontWeight = "bold";
    }
}

for(let i = 0; i < libNav.length; i++){
    if(params.get("m") == null){
        libNav[0].classList.add("selected");

    }else{
        if(params.get("m") == i){
            libNav[i - 1].classList.add("selected");
        }
    }
}

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