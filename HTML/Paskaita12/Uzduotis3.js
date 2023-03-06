let allfirstTableDataRaws = document.querySelector(".first-table").querySelector("tbody").getElementsByTagName("tr");
let progressButton = document.querySelector(".progress-button");
let doneButton = document.querySelector(".done-button");
let criticalButton = document.querySelector(".critical-button");
let notNeededButton = document.querySelector(".not-needed-button");
 

function markRaw (row, button) {
    let currentRow = allfirstTableDataRaws[row];
    currentRow.classList = "";
    switch (button) {
        case "progress-button": {
            currentRow.classList.add("in-progress");
            currentRow.getElementsByClassName("status")[0].innerText = "In progress";
            break;
        }
        case "done-button": {
            currentRow.classList.add("done");
            currentRow.getElementsByClassName("status")[0].innerText = "Done";
            break;
        }
        case "critical-button": {
            currentRow.classList.add("critical");
            currentRow.getElementsByClassName("status")[0].innerText = "Critical";
            break;
        }
        case "not-needed-button": {
            currentRow.classList.add("not-needed");
            currentRow.getElementsByClassName("status")[0].innerText = "Not needed";
            break;
        }
    }
}

for (let i = 0; i < allfirstTableDataRaws.length; i++) {
    let rowButtons = allfirstTableDataRaws[i].getElementsByTagName("button");
    for (let j = 0; j < rowButtons.length; j++) {
        rowButtons[j].addEventListener("click", () => markRaw(i, rowButtons[j].className));
        console.log(rowButtons[j].className + " " + i);
    }
}
