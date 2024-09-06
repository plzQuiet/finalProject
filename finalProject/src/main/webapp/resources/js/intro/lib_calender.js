const todayBtn = document.getElementById("today-btn");
const prevBtn = document.getElementById("prev-btn");
const nextBtn = document.getElementById("next-btn");
const dateDiv = document.getElementById("date-div");
const todayDate = new Date();
const dateFormat = ((todayDate.getMonth()+1) < 10 ? "0" + (todayDate.getMonth()+1) : (todayDate.getMonth()+1))
+ "월 " + ((todayDate.getDate()) < 10 ? "0" + (todayDate.getDate()) : (todayDate.getDate()) ) + "일";
(function(){
    dateDiv.innerText = dateFormat;
})();

let selectDate;

var calendarEl = document.getElementById('calendar');
var calendar = new FullCalendar.Calendar(calendarEl, {
    initialView: 'dayGridMonth',
    headerToolbar:{
    start : '',
    center : "title",
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
    events: [] ,
    selectable : true,/* 캘랜더 날짜 선택 */
    
    /* 캘런더 날짜 선택 시 함수 수행*/
    dateClick : function(e){
    selectDate = e.dateStr;
    let selectArray = selectDate.split("-");
    console.log(selectArray);
    dateDiv.innerText = selectArray[1] + "월 " + selectArray[2] + "일";
    /* e.dateStr - 클릭한 날짜 가져옴 */
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


/* 캘런더 생성 메소드 */
function createCalender() {}

/* 일정 목록 생성 */
function createSchedule(){}