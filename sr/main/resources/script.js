async function fetchAvailableRooms() {
    const response = await fetch('/rooms/available');
    const rooms = await response.json();
    const roomList = document.getElementById('availableRooms');
    roomList.innerHTML = "";
    rooms.forEach(room => {
        let li = document.createElement("li");
        li.textContent = Room ${room.number} (Floor ${room.floor});
        roomList.appendChild(li);
    });
}

async function bookRooms() {
    const numRooms = document.getElementById('numRooms').value;
    const response = await fetch(/rooms/book/${numRooms}, { method: 'POST' });
    const bookedRooms = await response.json();
    const bookedList = document.getElementById('bookedRooms');
    bookedList.innerHTML = "";
    bookedRooms.forEach(room => {
        let li = document.createElement("li");
        li.textContent = Room ${room.number} (Floor ${room.floor});
        bookedList.appendChild(li);
    });
    fetchAvailableRooms();
}

async function resetRooms() {
    await fetch('/rooms/reset', { method: 'POST' });
    document.getElementById('bookedRooms').innerHTML = "";
    fetchAvailableRooms();
}

window.onload = fetchAvailableRooms;
