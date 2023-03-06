const floorOp = document.getElementById("floor-button");
const ceilOp = document.getElementsByClassName("ceil-button")[0];
const roudnOp = document.getElementsByName("round-button")[0];
const truncOp = document.querySelector("#round-button");
let resultText = document.querySelector("#result-readout");

let getNumber = () => {
    let operandText = document.querySelector("#number-input").value;
    return Number.parseFloat(operandText);
}

let displayResult = result => resultText.value = result;

floorOp.addEventListener("click", () => {
    let result = Math.floor(getNumber());
    displayResult(result);
})

ceilOp.addEventListener("click", () => {
    let result = Math.ceil(getNumber());
    displayResult(result);
})

roudnOp.addEventListener("click", () => {
    let result = Math.round(getNumber());
    displayResult(result);
})

truncOp.addEventListener("click", () => {
    let result = Math.trunc(getNumber());
    displayResult(result);
})
