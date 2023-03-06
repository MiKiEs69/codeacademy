
function winner(drawInput) {
    let autoDraw = Math.floor(Math.random() * 3) + 1;
    console.log(drawInput + " " + autoDraw);

    if (autoDraw === drawInput) {
        alert("Lygiosios!");
    } else {
        if (drawInput == 1 && autoDraw == 2 ||
            drawInput == 2 && autoDraw == 3 ||
            drawInput == 3 && autoDraw == 1) {
            alert("Laimėjot!");
        } else {
            alert("Pralaimėjot!");
        }
    }
}