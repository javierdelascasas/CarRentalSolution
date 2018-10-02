let UI = {
    loadScreen: {
        screen: $('#loadBg'),
        spinner: $('#loadSpinner'),
    },
    formSearchCar: {
        form: $('#formSearchCar'),
        selectCarType: $('#selectCarType'),
        selectLocation: $('#selectLocation'),
        inputFromDate: $('#inputFromDate'),
        inputFromTime: $('#inputFromTime'),
        inputToDate: $('#inputToDate'),
        inputToTime: $('#inputToTime'),
        buttonSearchCar: $('#buttonSearchCar'),
    },
    carList: {
        list: $('#carList'),
    },
}

$(document).ready(() => {
    UI.formSearchCar.inputFromDate.val(parseDate(new Date()));
    UI.formSearchCar.inputFromTime.val(parseTime(new Date()));
    UI.formSearchCar.inputToDate.val(parseDate(addDays(new Date(), 1)));
    UI.formSearchCar.inputToTime.val(parseTime(new Date()));
    UI.formSearchCar.buttonSearchCar.click(searchAvailableCars);
});

function parseDate(date) {
    let today = date;
    let dd = today.getDate();
    if (dd < 10) {
        dd = '0' + dd;
    }
    let mm = today.getMonth() + 1;
    if (mm < 10) {
        mm = '0' + mm;
    }
    let yyyy = today.getFullYear();
    return yyyy + '-' + mm + '-' + dd;
}

function parseTime(date) {
    let today = date;
    let hh = today.getHours();
    if (hh < 10) {
        hh = '0' + hh;
    }
    let MM = today.getMinutes();
    if (MM <= 15) {
        MM = '15';
    } else if (MM <= 30) {
        MM = '30';
    } else if (MM <= 45) {
        MM = '45';
    } else if (MM <= 59) {
        today = addTime(today, 60);
        hh = today.getHours();
        if (hh < 10) {
            hh = '0' + hh;
        }
        MM = '00';
    }
    return hh + ':' + MM;
}

function addDays(date, days) {
    date.setDate(date.getDate() + days);
    return date;
}

function addTime(date, min) {
    return new Date(date.getTime() + min * 60000);
}

function searchAvailableCars() {
    let form = {
        carType: UI.formSearchCar.selectCarType.val(),
        location: "1",
        fromDateTime: new Date(),
    }
    startLoadScreen();
    fetch('/searchAvailableCars', {
        method: 'post',
        headers: {
            'Content-Type': 'application/json'
            // 'Content-Type': 'application/x-www-form-urlencoded'
        },
        body: JSON.stringify(form)
    }).then(function(response) {
        return response.json();
    }).then(function(data) {
        console.table(data);
        if (data) {
            console.log('About to spawn');
            spawnCarItemsOnList(data);
        }
    });
    setTimeout(stopLoadScreen, 500);
}

function startLoadScreen() {
    UI.loadScreen.screen.removeClass('myHidden');
    UI.loadScreen.spinner.addClass('spinning');
}

function stopLoadScreen() {
    UI.loadScreen.spinner.removeClass('spinning');
    UI.loadScreen.screen.addClass('myHidden');
}

function spawnCarItemsOnList(data) {
    UI.carList.list.empty();
    for (let i = 0; i < data.length; i++) {
        console.log('inside loop');
        let car = data[i];
        console.log(car);
        let carItemForm = document.createElement('FORM');
        carItemForm.setAttribute('id', 'carItemForm' + i);
        carItemForm.classList.add('carItemForm', 'pure-form');

        let section1 = document.createElement('SECTION');
        section1.classList.add('carItem');

        let brand = document.createElement('P');
        brand.innerHTML = car.brand.brandName;
        brand.style.gridArea = 'carBrand';

        let year = document.createElement('P');
        year.innerHTML = car.carYear;
        year.style.gridArea = 'carYear';

        let model = document.createElement('P');
        model.innerHTML = car.carModel;
        model.style.gridArea = 'carModel';

        let milage = document.createElement('P');
        milage.innerHTML = car.carMilage + 'km';
        milage.style.gridArea = 'carMilage';

        // let img = document.createElement('IMG');
        // let fileName = '';
        // switch (car.carCategory.carCategoryID) {
        //     case 1:
        //         fileName = 'smcar';
        //         break;
        //     case 2:
        //         fileName = 'car';
        //         break;
        //     case 3:
        //         fileName = 'bus';
        //         break;
        // }
        // img.setAttribute('src', '/img/' + fileName + '.png');
        // img.style.gridArea = 'img';

        let button = document.createElement('BUTTON');
        button.setAttribute('id', 'buttonCarItem' + i);
        button.setAttribute('type', 'button');
        button.setAttribute('value', i);
        button.classList.add('pure-button');
        button.innerHTML = 'Book';
        button.style.gridArea = 'button';


        section1.appendChild(brand);
        section1.appendChild(year);
        section1.appendChild(model);
        section1.appendChild(milage);
        // section1.appendChild(img);
        section1.appendChild(button);

        let section2 = document.createElement('SECTION');
        section2.setAttribute('id', 'carItemForm2' + i);
        section2.classList.add('carItemForm2');

        let tab = document.createElement('DIV');
        tab.classList.add('carItemForm2Tab');
        tab.style.gridArea = 'tab';

        let brand2 = document.createElement('P');
        brand2.innerHTML = car.brand.brandName;
        brand2.style.gridArea = 'carBrand';

        let year2 = document.createElement('P');
        year2.innerHTML = car.carYear;
        year2.style.gridArea = 'carYear';

        let model2 = document.createElement('P');
        model2.innerHTML = car.carModel;
        model2.style.gridArea = 'carModel';

        let birthDate = createAndPlaceElement('INPUT', '', 'birthDate');
        birthDate.setAttribute('placeholder', 'Date of birth');

        let fName = createAndPlaceElement('INPUT', '', 'fName');
        fName.setAttribute('placeholder', 'First Name');

        let lName = createAndPlaceElement('INPUT', '', 'lName');
        lName.setAttribute('placeholder', 'Last Name');

        let phone = createAndPlaceElement('INPUT', '', 'phone');
        phone.setAttribute('placeholder', 'Telephone');

        let email = createAndPlaceElement('INPUT', '', 'email');
        email.setAttribute('placeholder', 'E-mail');

        let button2 = createAndPlaceElement('BUTTON', 'Send', 'button');
        
        let button3 = createAndPlaceElement('BUTTON', 'Cancel', 'cancel');


        section2.appendChild(tab);
        section2.appendChild(brand2);
        section2.appendChild(year2);
        section2.appendChild(model2);
        section2.appendChild(birthDate);
        section2.appendChild(fName);
        section2.appendChild(lName);
        section2.appendChild(phone);
        section2.appendChild(email);
        section2.appendChild(button2);
        section2.appendChild(button3);

        carItemForm.appendChild(section1);
        carItemForm.appendChild(section2);
        UI.carList.list.append(carItemForm);
        $('#buttonCarItem' + i).click(showCarItemForm2);
    }
}

function showCarItemForm2() {
    resetSelectedCarItemForms2();
    $('#carItemForm2' + $(this).val() + '').addClass('selectedCarItem');
}

function resetSelectedCarItemForms2() {
    for (let i = 0; i < UI.carList.list.children().length; i++) {
        $('#carItemForm2' + i + '').removeClass('selectedCarItem');
    }
}

function createAndPlaceElement(type, inner, area) {
    let element = document.createElement(type)
    element.innerHTML = inner;
    element.style.gridArea = area;
    return element;
}