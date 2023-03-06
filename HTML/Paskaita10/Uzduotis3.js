

let previousId = -1;
function logSymbol() {
    let buttonNumber = Number.parseInt(this.id);
    let pressedKey = document.getElementById(buttonNumber);
    pressedKey.innerHTML = "X";
    if (previousId === -1) {
        previousId = buttonNumber;
    } else {
        if (previousId < buttonNumber) {
            for (let i = previousId + 1; i < buttonNumber; i++) {
                let currentKey = document.getElementById(i);
                currentKey.innerHTML = "O";
            }
            previousId = buttonNumber;
        } else {
            if (previousId > buttonNumber) {
                for (let j = previousId; j > buttonNumber; j--) {
                    let currentKey = document.getElementById(j);
                    if (!currentKey.innerHTML) currentKey.innerHTML = "O";
                }
            }
        }
    }
}

for (let i = 0; i < 20; i++) {
    let currentKey = document.getElementById(i);
    currentKey.addEventListener("click", logSymbol);
}