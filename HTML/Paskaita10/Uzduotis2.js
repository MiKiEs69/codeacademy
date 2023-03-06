const addButton = document.getElementById("add-button");
const array = [];
const arrayLenghtReadout = document.getElementById("arrayReadout");

addButton.addEventListener("click", () => {
    array.push(0);
    arrayLenghtReadout.value = array.length;
});

const removeButton = document.getElementById("remove-button");
removeButton.addEventListener("click", () => {
    if (array.length > 0) {
        array.pop();
        arrayLenghtReadout.value = array.length;
    } else {
        arrayLenghtReadout.value = "no elements to remove!";
    }
});

