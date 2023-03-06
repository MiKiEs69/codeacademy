const flexWrapper = document.querySelector(".flex-wrapper");

let getPageNumber = () => Math.floor(Math.random() * 33 + 1);

let pictureUrl = "https://picsum.photos/v2/list?page=" + getPageNumber();

console.log(pictureUrl);

// var opts = {
//     headers: {
//         'mode': 'cors'
//     }
// }

fetch(pictureUrl)
    .then(res => res.json())
    .then(res => {
        console.log(res);
        displayPagePictures(res);
    })

let createPictureFrame = () => document.createElement("div");

let displayPagePictures = (pictureArray) => {
    for (currentPicture of pictureArray) {
        let currentPictureInFrame = createPictureFrame();
        
        currentPictureInFrame.classList.add("backround-wrapper");
        currentPictureInFrame.style.backgroundImage = `url(${currentPicture.download_url})`;
        flexWrapper.append(currentPictureInFrame);

    }
}

