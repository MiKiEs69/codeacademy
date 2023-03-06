const sentences = ["Hello, world", "I am programmer", "I like JS"];
const scrollLeftButton = document.querySelector("#scroll-left");
const scrollRightButton = document.querySelector("#scroll-right");
const textArea = document.querySelector("p");

console.log(scrollLeftButton);
console.log(scrollRightButton);

let currentPPos = 0;

let scroll = event => {
    if (event.target.id == "scroll-left") {
        if (currentPPos === 0) currentPPos = 2;
        else currentPPos--;
    } else {
        if (currentPPos === 2) currentPPos = 0;
        else currentPPos++;
    }
    textArea.textContent = sentences[currentPPos];

}

scrollLeftButton.addEventListener("click", scroll);
scrollRightButton.addEventListener("click", scroll);
