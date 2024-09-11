const todayBtn = document.getElementById("today-btn");
const prevBtn = document.getElementById("prev-btn");
const nextBtn = document.getElementById("next-btn");
const dateDiv = document.getElementById("date-div");
const timeSlotTable = document.getElementById("time-slot-table");///
const reserveBtn = document.getElementById("reserve-btn");///
let selectedSlots = [];///

const bookedSlots = {
    "2024-09-10": ["09:00", "09:30", "10:00", "14:30", "15:00", "15:30"],
};/* 위의 값은 예시 , 과연 DB에서 어떤식으로 가져와야 할까 고민 */ ///

const todayDate = new Date();
const dateFormat = ((todayDate.getMonth() + 1) < 10 ? "0" + (todayDate.getMonth() + 1) : (todayDate.getMonth() + 1))
    + "월 " + ((todayDate.getDate()) < 10 ? "0" + (todayDate.getDate()) : (todayDate.getDate())) + "일";
(function () {
    dateDiv.innerText = dateFormat;
})();

let selectDate;

var calendarEl = document.getElementById('calendar');
var calendar = new FullCalendar.Calendar(calendarEl, {
    initialView: 'dayGridMonth',
    headerToolbar: {
        start: '',
        center: "title",
        end: ''
    },
    locale: 'ko',
    titleFormat: function (date) {
        return date.date.year + "년 " + (parseInt(date.date.month) + 1) + "월";
    },
    dayCellContent: function (info) {
        var number = document.createElement("a");
        number.classList.add("fc-daygrid-day-number");
        number.innerHTML = info.dayNumberText.replace("일", "");
        return {
            html: number.outerHTML
        };
    },
    selectable: true, /* 캘랜더 날짜 선택 */

     /* 캘런더 날짜 선택 시 함수 수행*/
    dateClick: function (e) {
        selectDate = e.dateStr;
        let selectArray = selectDate.split("-");
        dateDiv.innerText = selectArray[1] + "월 " + selectArray[2] + "일";
        renderTimeSlots(selectDate);
    }
});
calendar.render();

/* 캘런더 오늘 버튼 */
todayBtn.addEventListener("click", function () {
    calendar.today();
    dateDiv.innerText = dateFormat;
});

/* 캘런더 이전 버튼 */
prevBtn.addEventListener("click", function () { calendar.prev(); });
/* 캘런더 next 버튼 */
nextBtn.addEventListener("click", function () { calendar.next(); });

reserveBtn.addEventListener("click", function () {
    if (selectedSlots.length > 0) {
        alert("예약일 : " + selectDate + "\n" + "예약 시간 : " + selectedSlots.join(", ") + "\n" + "예약이 완료되었습니다.");
    } else {
        alert("예약할 시간을 선택해 주세요.");
    }
});

function renderTimeSlots(date) {
    timeSlotTable.innerHTML = '';
    selectedSlots = [];
    const times = [
        "09:00", "09:30", "10:00", "10:30", "11:00", "11:30",
        "12:00", "12:30", "13:00", "13:30", "14:00", "14:30",
        "15:00", "15:30", "16:00", "16:30", "17:00", "17:30"
    ];

    times.forEach(time => {
        const div = document.createElement('div');
        div.innerText = time;
        if (bookedSlots[date] && bookedSlots[date].includes(time)) {
            div.className = 'time-slot booked';
        } else {
            div.className = 'time-slot available';
            div.addEventListener('click', function () {
                selectOrDeselectTimeSlot(div, time);
            });
        }
        timeSlotTable.appendChild(div);
    });
}

function selectOrDeselectTimeSlot(element, time) {
    if (selectedSlots.includes(time)) {
        // 선택 취소 조건: 가장 앞이나 뒤 시간만 취소 가능
        const firstSelected = selectedSlots[0];
        const lastSelected = selectedSlots[selectedSlots.length - 1];

        if (time !== firstSelected && time !== lastSelected) {
            alert("예약 시간은 연속되어야만 합니다.");
            return;
        }

        // 앞 시간 취소
        if (time === firstSelected) {
            selectedSlots.shift(); /* .shift() 배열의 첫 번째 요소 제거, 그 요소 반환 */
        }
        // 뒤 시간 취소
        else if (time === lastSelected) {
            selectedSlots.pop(); /* .pop() 배열의 마지막 요소 제거, 그 요소 반환 */
        }
        element.classList.remove('selected');
    } else {
        // 새로 선택하는 경우
        if (selectedSlots.length > 0 && (timeToIndex(time) !== timeToIndex(selectedSlots[selectedSlots.length - 1]) + 1)) {
            alert("예약 시간은 연속적으로 선택해야 합니다.");
            return;
        }
        if (selectedSlots.length >= 6) {
            alert("최대 3시간을 예약할 수 있습니다.");
            return;
        }
        selectedSlots.push(time); /* .push() 배열의 마지막에 새로운 요소 추가 후, 변경된 배열의 길이를 반환 */
        element.classList.add('selected');
    }
}

function timeToIndex(time) {
    const times = [
        "09:00", "09:30", "10:00", "10:30", "11:00", "11:30",
        "12:00", "12:30", "13:00", "13:30", "14:00", "14:30",
        "15:00", "15:30", "16:00", "16:30", "17:00", "17:30"
    ];
    return times.indexOf(time);
}