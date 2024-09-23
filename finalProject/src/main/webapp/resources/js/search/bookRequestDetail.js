const updateBtn = document.getElementById("updateBtn");

if(updateBtn != null){
    updateBtn.addEventListener("click",() => {
        location.href = location.pathname.replace("book", "book2") + "/update" + location.search;
    })
}

const deleteBtn = document.getElementById("deleteBtn");

if(deleteBtn != null){
    deleteBtn.addEventListener("click", () => {
        if(confirm("정말 삭제하시겠습니까?")){
            location.href = location.pathname.replace("book","board2") + "/delete"+ location.search;
        }
    })
}

const goToListBtn = document.getElementById("goToListBtn");

goToListBtn.addEventListener("click", ()=>{
    location.href = "/book/2/1" + location.search;
})