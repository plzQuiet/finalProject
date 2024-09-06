/* 편집 모달 입력 변수 */
const scheduleName = document.getElementsByName("scheduleName")[0];
const startDate = document.getElementsByName("startDate")[0];
const endDate = document.getElementsByName("endDate")[0];
const calCateSelect = document.getElementById("calendarCategory");
const calCateOption = document.getElementById("calendarCategory").options;
console.log(calCateSelect);
console.log(calCateOption);
const confirmBtn = document.getElementById("edit-confirm_btn");


/* 캘런더 */
const todayBtn = document.getElementById("today-btn");
const prevBtn = document.getElementById("prev-btn");
const nextBtn = document.getElementById("next-btn");
const dateDiv = document.getElementById("date-div");
const todayDate = new Date();
const dateFormat = ((todayDate.getMonth()+1) < 10 ? "0" + (todayDate.getMonth()+1) : (todayDate.getMonth()+1))
                + "월 " + ((todayDate.getDate()) < 10 ? "0" + (todayDate.getDate()) : (todayDate.getDate()) ) + "일";
/*  const dateFormat = todayDate.getFullYear() + "-" + ((todayDate.getMonth()+1) < 10 ? "0" + (todayDate.getMonth()+1) : (todayDate.getMonth()+1))
                + "-" + ((todayDate.getDate()) < 10 ? "0" + (todayDate.getDate()) : (todayDate.getDate()) ); */
(function(){
    dateDiv.innerText = dateFormat;
})();


let selectDate;

var calendarEl = document.getElementById('calendar');
var calendar = new FullCalendar.Calendar(calendarEl, {
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
  selectable : true,/* 캘랜더 날짜 선택 */
 
    /* 캘런더 날짜 선택 시 함수 수행*/
  dateClick : function(e){
    selectDate = e.dateStr;
    let selectArray = selectDate.split("-");
    console.log(selectArray);
    dateDiv.innerText = selectArray[1] + "월 " + selectArray[2] + "일";
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
calendar.render();

/* 캘런더 오늘 버튼 */
todayBtn.addEventListener("click",function() {
    calendar.today();
    dateDiv.innerText = dateFormat;
})

/* 캘런더 이전 버튼 */
prevBtn.addEventListener("click",function(){ calendar.prev();})

/* 캘런더 next 버튼 */
nextBtn.addEventListener("click",function() {calendar.next();})

/* ---------------------------------------------------------------------------------------------------------------- */
/* 편집 모달 열기 */
const editPopup = document.getElementById("edit-popup_layer");
document.getElementById("add-todo").addEventListener("click",() => {
    editPopup.style.display = "block";
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
function openPopUdate(e){
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

    confirmBtn.setAttribute("onClick","updateSchedule()");

    editPopup.style.display = "block";

}

/* 일정 등록 메소드 */
function insertSchedule(){}

/* 일정 수정 메소드 */
function updateSchedule() {}

/* 캘런더 생성 메소드 */
function createCalender() {}

/* 일정 목록 생성 */
function createSchedule(){}
