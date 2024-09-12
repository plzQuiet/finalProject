// 댓글 목록 조회
function selectCommentList(){

    fetch("/comment?boardNo" + boardNo)
    .then(resp => resp.json())
    .then(list =>{

        const commentList = document.getElementById("commentList");
        commentList.innerHTML = "";
        
        for(let comment of list){
            
            const commentRow = document.createElement("li");
            commentRow.classList.add("comment-row");
            
            const commentWriter = document.createElement("p");
            commentWriter.classList.add("comment-writer");

            const memberName = document.createElement("span");
            memberName.innerText = comment.memberName;

            const commentCreateDate = document.createElement("span");
            commentCreateDate.classList.add("comment-date");
            commentCreateDate.innerText = "(" + comment.commentCreateDate + ")";

            commentWriter.append(memberName, commentCreateDate);

            const commentContent = document.createElement("p");
            commentContent.classList.add("comment-content");
            commentContent.innerHTML = comment.commentContent;

            commentRow.append(commentWriter, commentContent);

            if(loginMemberNo != ""){
                if(loginMemberNo == comment.memberNo){
                    const updateBtn = document.createElement("button");
                    updateBtn.innerText = "수정";
                    updateBtn.setAttribute("onclick", "showUpdateComment(" + comment.commentNo + ", this)");

                    const deleteBtn = document.createElement("button");
                    deleteBtn.innerText = "삭제";
                    deleteBtn.setAttribute("onclick", "deleteComment(" + comment.commentNo + ")");

                    commentBtnArea.append(updateBtn, deleteBtn);
                     
                }
            }
        
        }

    })
    .catch(e=>console.log(e));
}

// 댓글 등록
const commentContent = document.getElementById("commentContent")
const addComment = document.getElementById("addComment");

addComment.addEventListener("click", e=>{

    if(loginMemberNo == ""){
        alert("로그인후 이용해주세요.");
        return;
    }

    if(commentContent.value.trim().length == 0){
        alert("댓글을 작성한 후 등록 버튼을 눌러주세요.");
        commentContent.value = "";
        commentContent.focus();
        return;
    }

    const data = {"commentContent" : commentContent.value,
                    "memberNo" : loginMemberNo,
                    "boardNo" :  boardNo};
    // post 방식                
    fetch("/comment", {
        method   : "POST",
        headers  : {"Content-Type" : "application/json"},
        body     : JSON.stringify(data)
    }) 
    .then(resp => resp.text())
    .then(result => {

        if(result > 0){
            alert("댓글이 등록되었습니다.");
            commentContent.value = "";
            selectCommentList();

        }else{
            alert("댓글 등록에 실패했습니다. 다시 등록해주세요.");
        }
    })
    .catch(e => console.log(e));

});

// 댓글 삭제
function deleteComment(commentNo){

    if(confirm("정말 삭제하시겠습니까?")){

        fetch("/comment", {
            method  : "DELETE",
            headers : {"Content-Type" : "application/json"},
            body    : commentNo
        })
        .then(resp => resp.text())
        .then(result => {

            if(result  > 0){
                alert("댓글이 삭제되었습니다.");
                selectCommentList();
            
            }else {
                alert("댓글 삭제에 실패했습니다.");
            }
        })
        .catch(e => console.log(e));
    }
}

// 댓글 수정 화면 전환
let beforeCommentRow;

function showUpdateComment(commentNo, btn){

    const temp = document.getElementsByClassName("update-textarea");

    if(temp.length > 0){

        if(confirm("다른 댓글이 수정 중입니다. 현재 댓글을 수정 하시겠습니까?")){

            temp[0].parentElement.innerHTML = beforeCommentRow;
        }

    }else{
        return;
    }

    const commentRow = btn.parentElement.parentElement; 

    beforeCommentRow = commentRow.innerHTML;

    let beforeContent = commentRow.children[1].innerHTML;

    commentRow.innerHTML = "";

    const textarea = document.createElement("textarea");
    textarea.classList.add("update-textarea");

    beforeContent =  beforeContent.replaceAll("&amp;", "&");
    beforeContent =  beforeContent.replaceAll("&lt;", "<");
    beforeContent =  beforeContent.replaceAll("&gt;", ">");
    beforeContent =  beforeContent.replaceAll("&quot;", "\"");
    
    textarea.value = beforeContent; // 내용 추가

    commentRow.append(textarea);


    const commentBtnArea = document.createElement("div");
    commentBtnArea.classList.add("comment-btn-area");
    

    const updateBtn = document.createElement("button");
    updateBtn.innerText = "수정";
    updateBtn.setAttribute("onclick", "updateComment(" + commentNo + ", this)");


    const cancelBtn = document.createElement("button");
    cancelBtn.innerText = "취소";
    cancelBtn.setAttribute("onclick", "updateCancel(this)");


    commentBtnArea.append(updateBtn, cancelBtn);
    commentRow.append(commentBtnArea);
}

// 댓글 수정 취소
function updateCancel(btn){

    if(confirm("댓글 수정을 취소하시겠습니까?")){

        btn.parentElement.parentElement.innerHTML = beforeCommentRow;
    }
}

// 댓글 수정(AJAX)
function updateComment(commentNo, btn){

    const commentContent = btn.parentElement.previousElementSibling.value;
    
    const data = {"commentContent" : commentContent,
                  "commentNo" : commentNo}; 

    fetch("/comment", {
        method : "PUT",
        headers  :{"Content-Type" : "application/json"},
        body  : JSON.stringify(data)
    })
    .then(resp => resp.text())
    .then(result => {

        if(result > 0){
            alert("댓글이 수정되었습니다.");
            selectCommentList();

        }else{
            alert("댓글 수정 실패");
        }
    })
    .catch(err => console.log(err));

}