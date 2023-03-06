const numberOfJokesButton = document.getElementById("get-jokes-button");
const numberOfJokesInput = document.getElementById("number-of-jokes");
const flexWrapper = document.querySelector(".flex-wrapper");

let getBunchOfJokes = () => {
    cleanJokesWrapperChilds();
    console.log(numberOfJokesInput.value);
    if (!numberOfJokesInput.value) {
        console.log("No number of jokes was entered!");
        return;
    }
    let numberOfJokes = parseInt(numberOfJokesInput.value);
    for (let i = 0; i < numberOfJokes; i++) {
        fetch("https://api.chucknorris.io/jokes/random")
            .then(res => res.json())
            .then(res => {
                putJokeIntoWrapper(res);
            })
    }
}

numberOfJokesButton.addEventListener("click", getBunchOfJokes);

let putJokeIntoWrapper = (text) => {
    let newTextContainer = document.createElement("div");
    newTextContainer.classList.add("jokes-flex");
    newTextContainer.append(text.value);
    flexWrapper.append(newTextContainer);
}
let cleanJokesWrapperChilds = () => {
    while (flexWrapper.firstChild) {
        flexWrapper.removeChild(flexWrapper.lastChild);
    }
}