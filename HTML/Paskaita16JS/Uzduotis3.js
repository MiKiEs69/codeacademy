window.onload = () => {

    let trainsTableRows = [];
    let rowInsertIndex = trainsTableRows.length;
    const rowInputForm = document.querySelector(".train-table-row-input");
    const formInputs = rowInputForm.querySelectorAll("input,select");
    console.log(formInputs);
    let inputAlertReadout = document.createElement("div");
    inputAlertReadout.classList.add("readout");
    inputAlertReadout.classList.add("red-alert-text");
    let tableBody = document.querySelector(".train-table").querySelector(" tbody");
    const submitButton = document.querySelector("#submit-button");

    //----------------- set row object template
    let setObjectContainer = () => {
        let objectContainer = {};
        formInputs.forEach(input => {
            objectContainer[input.name] = "";
        });
        return objectContainer;
    }
    let rowObjectContainer = setObjectContainer();
    const rowObjectKeys = Object.keys(rowObjectContainer);

    //-----------Redraw HTML block

    let createRow = () => {
        return document.createElement("tr");
    }

    let createCurrentTd = (currentData) => {
        let tableData = document.createElement("td");
        tableData.textContent = currentData;
        return tableData;
    }

    let addEditButton = (id) => {
        let newEditButton = document.createElement("button");
        newEditButton.id = id;
        newEditButton.textContent = "Edit";
        newEditButton.addEventListener("click", editTableRow);
        return newEditButton;
    }

    let addDeleteButton = (id) => {
        let newDeleteButton = document.createElement("button");
        newDeleteButton.id = id;
        newDeleteButton.textContent = "Delete";
        newDeleteButton.addEventListener("click", deleteTableRow);
        return newDeleteButton;
    }
    let resetHtmlTableRows = () => {
        while (tableBody.firstChild) {
            tableBody.removeChild(tableBody.lastChild);
        }
    }
    let redrawHtmlTable = () => {
        resetHtmlTableRows();
        submitButton.textContent = "Add";
        let currentTableRow = "";
        trainsTableRows.forEach(rowObject => {
            currentTableRow = createRow();
            rowObjectKeys.forEach(e => {
                currentTableRow.append(createCurrentTd(rowObject[e]));
            })
            currentTableRow.append(addDeleteButton(rowObject.id));
            currentTableRow.append(addEditButton(rowObject.id));
            tableBody.append(currentTableRow);
        })
    }

    //------------Action Block



    let refreshLocalStorage = () => {
        localStorage.setItem("TrainsTable", JSON.stringify(trainsTableRows));
    }

    let deleteTableRow = (event) => {
        trainsTableRows = trainsTableRows.filter(obj => obj.id !== event.target.id);
        redrawHtmlTable();
        refreshLocalStorage();
    }

    let prepareFormFields = (itemToEdit) => {
        rowObjectKeys.forEach(key => {
            formInputs[rowObjectKeys.indexOf(key)].value = itemToEdit[key];
        });
        submitButton.textContent = "save";

    }


    let editTableRow = (event) => {
        let editedItemId = event.target.id;
        let arrayItemToEdit = trainsTableRows.find(obj => obj.id === editedItemId);
        prepareFormFields(arrayItemToEdit);
        rowInsertIndex = trainsTableRows.indexOf(arrayItemToEdit);
    }



    let validateInput = (allInputs) => {
        for (let input of allInputs) {
            if ((input.tagName == "INPUT" || input.tagName == "SELECT") && !input.value) {
                currentEmptyInputLabel = input.labels[0].innerHTML;
                inputAlertReadout.innerHTML = `Field "${currentEmptyInputLabel}" is empty!`;
                rowInputForm.append(inputAlertReadout);
                return false;
            }
        };
        return true;
    }

    let createArrayObject = (data, defaultContainer) => {
        let currentObject = Object.assign({}, defaultContainer);
        rowObjectKeys.forEach(key => {
            currentObject[key] = data[key].value;
        });
        return currentObject;

    }

    let addRowToTrainTable = (event) => {
        event.preventDefault();
        let inputElements = event.target.elements;
        if (validateInput(inputElements)) {
            inputAlertReadout.remove();
            trainsTableRows.splice(rowInsertIndex, 1, createArrayObject(inputElements, rowObjectContainer));
            redrawHtmlTable(rowObjectContainer);
            refreshLocalStorage();
            rowInsertIndex = trainsTableRows.length;
            rowInputForm.reset();

        };
    }

    let getTableDataFromLocal = () => {
        let tableDataFromLocal = localStorage.getItem("TrainsTable");
        try {
            trainsTableRows = JSON.parse(tableDataFromLocal);
            rowInsertIndex = trainsTableRows.length;
            redrawHtmlTable();
        }
        catch (error) {
            console.error("Wrong format of Table list", error);
        }
    }


    if (localStorage.length > 0) getTableDataFromLocal();


    rowInputForm.addEventListener("submit", addRowToTrainTable);


}