window.onload = () => {

    let storeLocallyTodoArray = () => {
        let liDataArray = [];
        let allLi = todoList.getElementsByTagName("li");
        for (i = 0; i < allLi.length; i++) {
            liDataArray.push(allLi[i].textContent)
        }
        localStorage.setItem("TodoListData", JSON.stringify(liDataArray));
    }

    let createNewLi = (inputText) => {
        let newListItem = document.createElement("li");
            newListItem.append(inputText);
            todoList.append(newListItem);
    }

    let getTodoIntoList = () => {
        readOutLabel.classList = "";
        let inputText = todoInput.value;
        console.log("|" + inputText.trim() + "|");
        if (inputText.trim()) {
            createNewLi(inputText);
            storeLocallyTodoArray();
            readOutLabel.classList.add("green-alert-text");
            readOutLabel.value = "Elementas į sąrašą pridėtas sėkmingai!"
        } else {
            readOutLabel.classList.add("red-alert-text");
            readOutLabel.value = "Negalima pridėti tuščio elemento!"
        }
    }


    let getTodoListFromLocal = () => {
        let todoListDataFromLocal = localStorage.getItem("TodoListData");
        try {
            liDataArray = JSON.parse(todoListDataFromLocal);
            liDataArray.forEach(e => {createNewLi(e)});
            readOutLabel.classList.add("green-alert-text");
            readOutLabel.value = "Elementai į sąrašą iš atminties įkrauti sėkmingai!"
        }
        catch (error) {
            console.error("Wrong format of ToDo list", error);
        }
    }

    let todoInput = document.querySelector("#text-input");
    let addButton = document.querySelector("#add-todo-item");
    let todoList = document.querySelector(".todo-list");
    let readOutLabel = document.querySelector("#readout-label");
    addButton.addEventListener("click", getTodoIntoList);

    if (localStorage.length > 0) getTodoListFromLocal();

}
