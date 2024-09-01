const checkObj = {
    "memberName" : false,
    "memberTel" : false
}

const memberName = document.getElementById("memberName");
const nameMessage = document.getElementById("nameMessage");

memberName.addEventListener("input", () => {

    if(memberName.value.trim().length == 0) {
        nameMessage.innerText = "이름를 입력해주세요.";
        memberName.value = "";
        nameMessage.classList.remove("confirm", "error");

        checkObj.memberName = false;
        return;
    }

    const regExp = /^[가-힣]{2,6}$/;

    if(regExp.test(memberName.value)) {

        nameMessage.innerText = "유효한 형식입니다."
        nameMessage.classList.add("confirm");
        nameMessage.classList.remove("error");

        checkObj.memberName = true;

    }else {
        nameMessage.innerText = "유효하지 않은 이름 형식입니다."
        nameMessage.classList.add("error");
        nameMessage.classList.remove("confirm");

        checkObj.memberName = false;
    }

})

const memberTel = document.getElementById("memberTel");
const telMessage = document.getElementById("telMessage");

memberTel.addEventListener("input", () => {

    if(memberTel.value.trim().length == 0) {
        telMessage.innerText = "전화번호를 입력해주세요.(- 제외)";
        memberTel.value = "";
        telMessage.classList.remove("confirm", "error");

        checkObj.memberTel = false;
        return;
    }

    const regExp = /^0(10|2|[3-6][1-5]|70)\d{3,4}\d{4}$/;

    if(regExp.test(memberTel.value)) {

        telMessage.innerText = "유효한 형식입니다."
        telMessage.classList.add("confirm");
        telMessage.classList.remove("error");

        checkObj.memberTel = true;

    }else {
        telMessage.innerText = "유효하지 않은 전화번호 형식입니다."
        telMessage.classList.add("error");
        telMessage.classList.remove("confirm");

        checkObj.memberTel = false;
    }

})

document.getElementById("findIdFrm").addEventListener("submit", e=>{
    for(let key in checkObj){
        if(!checkObj[key]){
            let str = "";

            switch(key){
                case "memberName"       : str="이름이"; break;
                case "memberTel"        : str="전화번호가"; break;
            }

            alert(str + " 유효하지 않습니다.");

            document.getElementById(key).focus();

            e.preventDefault();
            return;
        }
    }
})