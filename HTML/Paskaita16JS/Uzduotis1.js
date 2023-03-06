
const counterStorageKey = "counter";
let counter;

window.onload = () => {
    const subButton = document.getElementById("subtract-button");
    const addButton = document.getElementById("add-button");
    subButton.addEventListener("click", subtractCount);
    addButton.addEventListener("click", addCount);
    if (sessionStorage.length === 0) {
        sessionStorage.setItem(counterStorageKey, 0)
        counter = 0;
    } else {
        counterText = sessionStorage.getItem(counterStorageKey);
        let storedNumber = parseInt(counterText);
        if (!isNaN(storedNumber)) counter = storedNumber;
        displayCount();
    }
}

let storeCounterInSession = () => { sessionStorage.setItem(counterStorageKey, counter) };

function subtractCount() {
    counter--;
    storeCounterInSession();
    displayCount();
}

function addCount() {
    counter++;
    storeCounterInSession();
    displayCount();
}

function displayCount() {
    document.getElementById('number').innerText = counter;
}






