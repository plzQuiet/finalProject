/* 편집 모달 입력 변수 */
const scheduleName = document.getElementsByName("scheduleName")[0];
const startDate = document.getElementsByName("startDate")[0];
const endDate = document.getElementsByName("endDate")[0];
const calCateSelect = document.getElementById("calendarCategory");
const calCateOption = document.getElementById("calendarCategory").options;
console.log(calCateSelect);
console.log(calCateOption);

/* 편집 등록 버튼 */
const confirmBtn = document.getElementById("edit-confirm_btn");


/* 캘런더 */
const todayBtn = document.getElementById("today-btn");
const prevBtn = document.getElementById("prev-btn");
const nextBtn = document.getElementById("next-btn");
const dateDiv = document.getElementById("date-div");

/* 오늘 날짜 모양 포맷 */
const todayDate = new Date();
const dateFormat = ((todayDate.getMonth()+1) < 10 ? "0" + (todayDate.getMonth()+1) : (todayDate.getMonth()+1))
                + "월 " + ((todayDate.getDate()) < 10 ? "0" + (todayDate.getDate()) : (todayDate.getDate()) ) + "일";

/* 오늘 날짜 모양 포맷2 */
const dateFormat2 = todayDate.getFullYear() + "-" + ((todayDate.getMonth()+1) < 10 ? "0" + (todayDate.getMonth()+1) : (todayDate.getMonth()+1))
+ "-" + ((todayDate.getDate()) < 10 ? "0" + (todayDate.getDate()) : (todayDate.getDate()) ) ;
console.log(dateFormat2);

/* 오늘 포맷된 날짜, 캘랜더, 일정 보여줌 */
(function(){
    dateDiv.innerText = dateFormat;
    getTypeCal();
    createSchedule(dateFormat2);
})();

/* 선택된 날짜 */
let selectDate;

/* 캘랜더 만드는 전역 변수 */
var calendarEl;
var calendar ;

/* 캘런더 오늘 버튼 */
todayBtn.addEventListener("click",function() {
  calendar.today();
  dateDiv.innerText = dateFormat;
})

/* 캘런더 이전 버튼 */
prevBtn.addEventListener("click",function(){ calendar.prev();})

/* 캘런더 next 버튼 */
nextBtn.addEventListener("click",function() {calendar.next();})

/* 일정 등록 메소드 */
function insertSchedule(){

  let calType;

  for(let i = 0; i < calCateOption.length; i++){
    if(calCateOption[i].selected == true){
        calType = calCateOption[i].value;
    }
  }
  
  const insertCal = {
    calendarName : scheduleName.value,
    startDt : startDate.value,
    endDt : endDate.value,
    calendarType : calType
  }

  fetch("/intro2/insertShedule",{
    method : "POST",
    headers : {"Content-type" : "application/json"},
    body : JSON.stringify(insertCal)
  })
  .then(resp => resp.text())
  .then(result => {
    if(result > 0){
      getTypeCal();
      createSchedule(startDate.value);
      editPopup.style.display = "none";
    }else{
      alert("등록 안됨");
    }
  })
  .catch(e => {console.log(e)});
}

/* 일정 수정 메소드 */
function updateSchedule(calNo) {

  let calType;

  for(let i = 0; i < calCateOption.length; i++){
    if(calCateOption[i].selected == true){
        calType = calCateOption[i].value;
    }
  }
  
  const updateCal = {
    calendarNo : calNo,
    calendarName : scheduleName.value,
    startDt : startDate.value,
    endDt : endDate.value,
    calendarType : calType
  }

  fetch("/intro2/updateShedule",{
    method : "PUT",
    headers : {"Content-type" : "application/json"},
    body : JSON.stringify(updateCal)
  })
  .then(resp => resp.text())
  .then(result => {
    if(result > 0){
      getTypeCal();
      createSchedule(startDate.value);
      editPopup.style.display = "none";
    }else{
      alert("수정 안됨");
    }
  })
  .catch(e => {console.log(e)})

}

/* 일정 삭제 메소드 */
function deleteShedule(calNo, delDate) {
  console.log(calNo);
  console.log(delDate);

  fetch("/intro2/deleteShedule",{
    method : "DELETE",
    headers : {"Content-type" : "application/json"},
    body : calNo
  })
  .then(resp => resp.text())
  .then(result => {
    if(result > 0){
      getTypeCal();
      createSchedule(delDate);
      delPop.style.display = "none";
    }
  })
  .catch(e => {console.log(e)}) 
}

/* 캘런더 이번트 가져오는 메소드 */
function getTypeCal(){

  fetch("/intro2/getHECal")
  .then(resp => resp.json())
  .then( eventList => {
    console.log(eventList);

    /* 전체 이벤트를 담을 배열 */
    let events = [];

    for(let e of eventList){
        /* 값 하나하나 담을 객체 */
        let event = {
            title : e.calendarName,
            start : e.startDt
        };

        /* 종료일이 있다면 필드값 넣기 */
        if(e.endDt != null){
            event.end = e.endDt;
        }

        /* 타입별로 색 넣어주기 */
        if(e.calendarType == 2){
            event.color = "#d4d4d4";
            event.textColor = "#ffffff";
            event.rendering = "background";
        }

        if(e.calendarType == 3){
            event.color = "#5547ff";
            event.textColor = "#ffffff";
        }

        /* events 안에 event 넣기 */
        events.push(event);
    }

    console.log(events);

    /* 캘런더 생성 메소드 */
    createCalender(events);

  })
}

/* 캘런더 생성 메소드 */
function createCalender(event) {

  calendarEl = document.getElementById('calendar');
  calendar = new FullCalendar.Calendar(calendarEl, {
  initialView: 'dayGridMonth',
  headerToolbar:{
    start : 'title',
    center : "",
    end : ''
  },
  locale : 'ko',
  titleFormat : function(date){
    return date.date.year + "년 " + (parseInt(date.date.month) + 1) + "월";
  },
    // 일 빼기
dayCellContent : function(info){
    var number=document.createElement("a");
    number.classList.add("fc-daygrid-day-number");
    number.innerHTML =info.dayNumberText.replace("일","");
    return {
        html:number.outerHTML
    };
},
events: event ,
  selectable : true,/* 캘랜더 날짜 선택 */
 
    /* 캘런더 날짜 선택 시 함수 수행*/
  dateClick : function(e){
    selectDate = e.dateStr;

    createSchedule(selectDate);
    /* e.dateStr - 클릭한 날짜 가져옴 */

    /* 선택한 날짜에서 금요일 구하는 코드
    let day = new Date(selectDate).getDay();
    console.log(day);
    if(day == 5){
        alert("금요일은 선택할 수 없습니다.");
        return;
    } */
  }
  
});

/* 캘랜더 화면에 보여줌
  이 구문 없으면 안보임
*/
calendar.render();

}

const tbody = document.querySelector(".todo-surround > table > tbody");

/* 일정 목록 생성 */
function createSchedule(date){

  let selectArray = date.split("-");
  console.log(selectArray);
  dateDiv.innerText = selectArray[1] + "월 " + selectArray[2] + "일";

  fetch("/intro2/selectGetDate?date="+date)
  .then(resp => resp.json())
  .then(result =>{
    console.log(result);
    /* 일정 리스트를 담아둘 tbody */
    tbody.innerHTML = "";
    if(result != null){

      for(let r of result){

        /* 일정 담을 tr */
        const tr = document.createElement("tr");

        /* 일정 제목 */
        const eventTitle = document.createElement("td");
        eventTitle.innerText = r.calendarName;

        /* 일정 시작일 */
        const eventStart = document.createElement("td");
        eventStart.innerText = r.startDt;

        /* 일정 종료일 */
        const eventEnd = document.createElement("td");
        if(r.endDt != null){
          eventEnd.innerText = r.endDt;
        }

        /* 일정 타입 */
        const eventType = document.createElement("td");
        if(r.calendarType == 2){
          eventType.innerText = "휴관일";
        }else{
          eventType.innerText = "행사";
        }

        /* 비고(버튼 영역) */
        const eventBtnArea = document.createElement("td");

        /* 수정 버튼 */
        const upBtn = document.createElement("button");
        upBtn.innerText = "수정"
        upBtn.classList.add("scheduleUpdate");
        upBtn.setAttribute("onClick","openPopUpdate(this,"+ r.calendarNo +")")

        /* 삭제 버튼 */
        const delBtn = document.createElement("button");
        delBtn.innerText = "삭제";
        delBtn.classList.add("scheduleDelete");
        delBtn.setAttribute("onClick","openDelPopUp(" + r.calendarNo +",'"+ r.startDt +"')");
        console.log(r.startDt);

        eventBtnArea.append(upBtn,delBtn);

        /* tr 삽입 */
        tr.append(eventTitle,eventStart,eventEnd,eventType,eventBtnArea);

        /* tbody에 tr 삽입 */
        tbody.append(tr);
      }

    }

  })
  .catch(e => {console.log(e)})

}

/* ---------------------------------------------------------------------------------------------------------------- */
/* 편집 모달 열기 */
const editPopup = document.getElementById("edit-popup_layer");

document.getElementById("add-todo").addEventListener("click",() => {
    editPopup.style.display = "block";

    scheduleName.value = '';
    startDate.value = '';
    endDate.value = '';
    document.getElementsByTagName("option")[0].selected = true;

    startDate.value = selectDate;
    confirmBtn.setAttribute("onClick", "insertSchedule()");
});

/* 편집 모달 닫기 */
const editPopupClose = document.getElementById("edit-popup-close");
editPopupClose.addEventListener("click",() => {
    editPopup.style.display = "none";
    scheduleName.value = '';
    startDate.value = '';
    endDate.value = '';
    document.getElementsByTagName("option")[0].selected = true;
    confirmBtn.setAttribute("onClick","insertSchedule()");
});

/* 수정 버튼 클릭시 */
function openPopUpdate(e,calNo){
    const parentNode = e.parentElement;
    const calCate = parentNode.previousElementSibling;
    for(let i = 0; i < calCateOption.length; i++){
        if(calCateOption[i].innerText == calCate.innerText){
            calCateOption[i].selected = true;
        }
    }

    const endDt = calCate.previousElementSibling;
    endDate.value = endDt.innerText;

    const startDt = endDt.previousElementSibling;
    startDate.value = startDt.innerText;

    const scheduleNm = startDt.previousElementSibling;
    scheduleName.value = scheduleNm.innerText;

    confirmBtn.setAttribute("onClick","updateSchedule(" + calNo + ")");

    editPopup.style.display = "block";

}

const delPop = document.getElementById("popup_layer");

/* 삭제 알람창 취소 클릭시 */
document.getElementById("cancel_btn").addEventListener("click",() => {
  delPop.style.display = "none";
})

/* 삭제 알림창 열기 함수 */
function openDelPopUp(calNo, date){
  delPop.style.display = "block";

  document.getElementById("confirm_btn").setAttribute("onClick","deleteShedule("+calNo+",'"+date+"')");
}


