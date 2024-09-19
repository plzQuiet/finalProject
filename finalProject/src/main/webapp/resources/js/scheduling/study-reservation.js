let selectedSeat = null; // 좌석 선택 상태를 저장하는 전역 변수

function updateSeats(e) {
    if (e) e.preventDefault();
    const reservationDt = document.getElementById("reservationDt").value;
    const startTime = document.getElementById("startTime").value;
    const endTime = document.getElementById("endTime").value;


    console.log(reservationDt)
    console.log(startTime)
    console.log(endTime)

    const data = {
        reservationDt: reservationDt,
        startTime: startTime,
        endTime: endTime
    };

    fetch('/reservation/study', {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(data)
    })
    .then(response => response.json())
    .then(seats => {
       
        console.log(seats);

        const seatSection = document.getElementById("seatSection");
        seatSection.innerHTML = '';

        const seatGroups = [[], [], []];

        seats.forEach(seat => {
            if (seat.seatNo >= 1 && seat.seatNo <= 8) {
                seatGroups[0].push(seat);
            } else if (seat.seatNo >= 9 && seat.seatNo <= 16) {
                seatGroups[1].push(seat);
            } else if (seat.seatNo >= 17 && seat.seatNo <= 24) {
                seatGroups[2].push(seat);
            }
        });

        seatGroups.forEach(group => {
            const groupDiv = document.createElement('div');
            groupDiv.className = 'seat-group';

            group.forEach(seat => {
                const table = document.createElement('table');
                table.className = seat.seatStatus === '사용중' ? 'private' : '';
                table.innerHTML = `
                    <tr><th>${seat.seatNo}</th></tr>
                    <tr><td>${seat.seatStatus}</td></tr>
                `;

                if (seat.seatStatus === '공석') {
                    table.addEventListener('click', () => {
                        if (selectedSeat) {
                            selectedSeat.classList.remove('private');
                            selectedSeat.classList.remove('selected');
                        }

                        if (selectedSeat === table) {
                            selectedSeat = null;
                        } else {
                            selectedSeat = table;
                            table.classList.add('private');
                            table.classList.add('selected');
                        }
                    });
                }

                groupDiv.appendChild(table);
            });

            seatSection.appendChild(groupDiv);
        });
    })
    .catch(e => console.log(e));
}

function bookSeat() {

    if (!selectedSeat) {
        alert("좌석을 선택해 주세요.");
        return;
    }

    const reservationDt = document.getElementById("reservationDt").value;
    const startTime = document.getElementById("startTime").value;
    const endTime = document.getElementById("endTime").value;
    const seatNo = selectedSeat.querySelector("th").textContent;

    console.log(reservationDt)
    console.log(startTime)
    console.log(endTime)
    console.log(seatNo)

    const alertModal = document.getElementById("alert_modal");
    const alertContent = document.getElementById("alert_content");

    alertContent.innerHTML = `
        <p>좌석 ${seatNo}을 예약 하시겠습니까?</p>
    `;
    
    alertModal.style.display = 'block';

    document.getElementById("confirm_btn").addEventListener("click", () => {
        // 확인 버튼 클릭 시 예약 처리
        const reservationData = {
            reservationDt: reservationDt,
            startTime: startTime,
            endTime: endTime,
            seatNo: seatNo
        };

        fetch('/reservation/study/book', {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(reservationData)
        })
        .then(response => response.json())
        .then(data => {
            if (data.result === 1) {
                showReservationSuccessModal(seatNo, reservationDt, startTime, endTime);
                alertModal.style.display = 'none'; // 예약 완료 후 모달 닫기
            } else {
                alert("예약 실패. 다시 시도해 주세요.");
            }
        })
        .catch(error => {
            console.error('예약 처리 중 오류 발생:', error);
            alert("예약 처리 중 오류가 발생했습니다.");
        });
    });

    document.getElementById("cancel_btn").addEventListener("click", () => {
        alertModal.style.display = 'none'; // 취소 버튼 클릭 시 모달 닫기
    });
}

function showReservationSuccessModal(seatNo, reservationDt, startTime, endTime) {
    const reservationModal = document.getElementById("reservation_modal");
    const reservationContent = document.getElementById("reservation_content");

    reservationContent.innerHTML = `
        <p>예약 좌석 : ${seatNo}번</p>
        <p>예약 일자 : ${reservationDt}</p>
        <p>예약 시간 : ${startTime} ~ ${endTime}</p>
    `;
    
    reservationModal.style.display = 'block';
}
