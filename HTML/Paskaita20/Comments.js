let commentsList = [];
const commentsLink = document.querySelector("#switch-to-boxes");
commentsLink.addEventListener("click", () => {
    window.open("Uzduotis1.html", "_self");
})

const commentsWrapper = document.querySelector(".comments-wrapper");
const commentInputText = document.querySelector("#comment-input");
commentInputText.addEventListener("click", () => {
    inputAlertReadout.remove();
});

const addButton = document.querySelector("#add-comment-button");

const messageWrapper = document.querySelector(".title-message-wrapper");
let inputAlertReadout = document.createElement("div");

let alertCommentInputStatus = (text, style) => {
    inputAlertReadout.classList.add("readout");
    inputAlertReadout.classList.add(style);
    inputAlertReadout.innerHTML = text;
    messageWrapper.append(inputAlertReadout);
}

let validateComment = () => {
    inputAlertReadout.classList = "";
    inputAlertReadout.remove();
    if (!commentInputText.value) {
        alertCommentInputStatus("Comment field is empty!", "red-alert-text");
        return;
    }
    addCommentToList(commentInputText.value);
}

addButton.addEventListener("click", validateComment);


let putCommentIntoWrapper = (text) => {
    let newCommentContainer = document.createElement("div");
    newCommentContainer.classList.add("comments-flex");
    newCommentContainer.append(text);
    commentsWrapper.append(newCommentContainer);
}


let refreshLocalStorage = () => {
    localStorage.setItem("Comments", JSON.stringify(commentsList));
}

let resetCommentsList = () => {
    while (commentsWrapper.firstChild) {
        commentsWrapper.removeChild(commentsWrapper.lastChild);
    }
}

let redrawCommentsList = () => {
    resetCommentsList();
    commentsList.forEach(currentComment => {
        putCommentIntoWrapper(currentComment);
    })
}

let addCommentToList = (comment) => {
    commentsList.push(comment);
    console.log(commentsList);
    redrawCommentsList();
    refreshLocalStorage();
    alertCommentInputStatus("The comment added successfully!!!", "green-alert-text")
}

window.onload = () => {

    let getCommentsFromLocal = () => {
        let commentsFromLocal = localStorage.getItem("Comments");
        try {
            commentsList = JSON.parse(commentsFromLocal);
            redrawCommentsList();
        }
        catch (error) {
            console.error("Wrong format of comments list", error);
        }
    }

    if (localStorage.length > 0) getCommentsFromLocal();
}
