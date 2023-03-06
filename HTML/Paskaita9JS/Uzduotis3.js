function kiekPasiskolinti() {

    let k = Number.parseInt(document.getElementById("banano-pradine-kaina").value);
    let n = Number.parseInt(document.getElementById("kario-pinigu-kiekis").value);
    let w = Number.parseInt(document.getElementById("visu-bananu-skaicius").value);

    // console.log(k + " " + n + " " + w);

    let piniguPoreikis = n - bananuSuma(w, k);

    if (piniguPoreikis >= 0) {
        alert("pinigų užtenka");
    } else {
        alert("reikia pasiskolinti " + -piniguPoreikis);
    }

}

function bananuSuma(w, k) {
    let suma = 0;
    for (let i = 1; i <= w; i++) {
        suma += i * k;
    }
    return suma;
}