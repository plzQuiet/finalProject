/* 캘랜더 위에 버튼 및 년월 포맷 */
const todayBtn = document.getElementById("today-btn");
const prevBtn = document.getElementById("prev-btn");
const nextBtn = document.getElementById("next-btn");
const dateDiv = document.getElementById("date-div");

/* 오늘 날짜 */
const todayDate = new Date();

/* 오늘 날짜 모양 포맷 */
const dateFormat = ((todayDate.getMonth()+1) < 10 ? "0" + (todayDate.getMonth()+1) : (todayDate.getMonth()+1))
+ "월 " + ((todayDate.getDate()) < 10 ? "0" + (todayDate.getDate()) : (todayDate.getDate()) ) + "일";

/* 오늘 날짜 모양 포맷2 */
const dateFormat2 = todayDate.getFullYear() + "-" + ((todayDate.getMonth()+1) < 10 ? "0" + (todayDate.getMonth()+1) : (todayDate.getMonth()+1))
+ "-" + ((todayDate.getDate()) < 10 ? "0" + (todayDate.getDate()) : (todayDate.getDate()) ) ;
console.log(dateFormat2);

/*오늘 포맷된 날짜, 캘랜더, 일정 보여줌 */
(function(){
    dateDiv.innerText = dateFormat;
    typeCalendar(1);
})();

/* 선택된 날짜 저장변수 */
let selectDate;

/* 캘런더 만드는 변수 전역변수로 선언 */
var calendarEl = document.getElementById('calendar');
var calendar;

/* 캘랜더 타입별로 이벤트 가져오는 함수 */
function typeCalendar(type){

    fetch("/intro2/getTypeCalendar?type="+type)
    .then(resp => resp.json())
    .then(eventList => {
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
            if(type == 1){
                event.color = "#FF0000";
                event.textColor = "#ffffff";
            }

            if(type == 2){
                event.color = "#d4d4d4";
                event.textColor = "#ffffff";
                event.rendering = "background";
            }

            if(type == 3){
                event.color = "#5547ff";
                event.textColor = "#ffffff";
            }

            if(type == 4){
                event.color = "#FFFF00";
                event.textColor = "#000000";
            }

            /* events 안에 event 넣기 */
            events.push(event);
        }

        console.log(events);
        /* 캘런더 생성 메소드 */
        createCalender(events, type);
    })
}

/* 캘런더 생성 메소드 */
function createCalender(event, type) {
    
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
    console.log(selectDate);
    let selectArray = selectDate.split("-");
    console.log(selectArray);
    dateDiv.innerText = selectArray[1] + "월 " + selectArray[2] + "일";

    /* e.dateStr - 클릭한 날짜 가져옴 */
    }/* ,

    datesSet: function (info) {
        currentMonth = info.view.title;               
        calendar.refetchEvents(); // FullCalendar에 이벤트 업데이트
        
    } */
    
});

/* 캘랜더 화면에 보여줌
  이 구문 없으면 안보임
*/
calendar.render();

}

/* 캘런더 오늘 버튼 */
todayBtn.addEventListener("click",function() {
    calendar.today();
    dateDiv.innerText = dateFormat;
})

/* 캘런더 이전 버튼 */
prevBtn.addEventListener("click",function(){ calendar.prev();})

/* 캘런더 next 버튼 */
nextBtn.addEventListener("click",function() {calendar.next();})