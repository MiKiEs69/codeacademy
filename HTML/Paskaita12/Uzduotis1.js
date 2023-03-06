const allSquares = document.getElementsByClassName("square");
const resetButton = document.getElementById("reset-button");

resetButton.addEventListener("click", () => window.location.reload());

function hideSquare(index) {
    console.log(allSquares[index]);
    allSquares[index].style.backgroundColor = "unset";
}


for (let i = 0; i < allSquares.length; i++) {
    allSquares[i].addEventListener("click", () => hideSquare(i));
    console.log(allSquares[i].className + " " + i);
}