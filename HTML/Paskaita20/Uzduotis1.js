const commentsArray = [];

const allSquares = document.querySelectorAll(".square");

const commentsLink = document.querySelector("#switch-to-comments");
commentsLink.addEventListener("click", () => {
    window.open("Comments.html", "_self" );
} )

let generateColorCode = () => Math.floor(Math.random() * 255);

let randomiseBackground = (index) => {
    console.log(index);
    let randomColor = `rgb(${generateColorCode()}, ${generateColorCode()}, ${generateColorCode()}, ${Math.random()})`;
    allSquares[index].style.backgroundColor = randomColor;
}

let registerSquares = () => {
    for (let i =0; i < allSquares.length; i++) {
        allSquares[i].addEventListener("click", () => randomiseBackground(i));
    }
}

registerSquares();








