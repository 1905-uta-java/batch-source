let email = sessionStorage.getItem("email");
let token = sessionStorage.getItem("token");
let baseUrl = "http://localhost:8080/CompanyEmployeeHub";
let employee;
let id;
let events;
let isManager = false;
let today = new Date();

let dd = String(today.getDate()).padStart(2, '0');
let mm = String(today.getMonth() + 1).padStart(2, '0');
let yyyy = today.getFullYear();
let pending = 0;

//Setup the main page
ajaxGet(baseUrl+"/api/employee?email="+email,setup);

//Basic employee information get
function setup(xhr){
    employee = JSON.parse(xhr.response);
    let name = employee.firstName + " " + employee.lastName;
    id = employee.empId;
    document.getElementById("presName").innerHTML = `Name:   ${name}`;
    document.getElementById("presEmail").innerHTML = `Email:   ${email}`;
    document.getElementById("presId").innerHTML = `Employee Id:   ${id}`;

    //Display manager stuff
    if(id > 199999 || id == "100001"){
        showManagerOptions();
        isManager = true;
    }

    //Display events
    ajaxGet(baseUrl+"/api/events?emp_id="+id,displayEvents);

    //Set date
    document.getElementById("current-date").innerHTML = mm + "/" + dd + "/" + yyyy;

    //Load Reimbursements
    ajaxGet(baseUrl+"/api/reimbursements?emp_id="+id,displayReimbursements);

    //Load Emplyoees
    if(isManager){
       ajaxGet(baseUrl+"/api/employees?emp_id="+id,displayEmployees); 
    }

    showPage("employee-overview");

    //Fill in the employee settings update info
    document.getElementById("new-first").value=employee.firstName;
    document.getElementById("new-last").value=employee.lastName;
    document.getElementById("new-phone").value=employee.phoneNumber;

    //Generate all eventListeners
    document.getElementById("emp-add-submit").addEventListener("click",newEmployee);
    document.getElementById("emp-upd-submit").addEventListener("click",updateEmployee);
    document.getElementById("emp-del-submit").addEventListener("click",deleteEmployee);
    document.getElementById("emp-promote-submit").addEventListener("click",promoteEmployee);
    document.getElementById("emp-upd-id").addEventListener("change",shouldFillInfo);
    document.getElementById("logout-button").addEventListener("click",logout);
    document.getElementById("update-employee-info").addEventListener("click",updateEmployeeInfo);
    document.getElementById("update-password").addEventListener("click",changePassword);
    document.getElementById("inp-submit-request").addEventListener("click",newRequest);
    document.getElementById("toggle-new-event").addEventListener("click",toggleAddEvents);
    document.getElementById("new-event").addEventListener("click",addEvents);

    setupRequestSearch();
    setupEmployeeSearch();


}

//Shows manager options
function showManagerOptions(){
    let managerOptions = document.getElementsByClassName("manager");
    for(let x of managerOptions){
        x.hidden = false;
    }
}

//Hides manager options
function hideManagerOptions(){
    let managerOptions = document.getElementsByClassName("manager");
    for(let x of managerOptions){
        x.hidden = true;
    }
}

//Display Correct Page
function showPage(id){
    let pages = document.getElementsByClassName("view-page");
    for(let i of pages){
        i.hidden = true;
    }
    document.getElementById(id).hidden = false;
}

//Display Events
function displayEvents(xhr){
    let events = JSON.parse(xhr.response);
    events.sort(compareDateTime);

    //Get the table to insert into
    let table = document.getElementById("table-of-events");
    table.innerHTML = "";

    for(let e of events){
        let row = document.createElement("tr");
        let date = new Date(e.dateTime);
        let eMonth = String(date.getMonth() + 1).padStart(2, '0');
        let eDay = String(date.getDate()).padStart(2, '0');
        let eHour = date.getHours();
        eHour = eHour % 12;
        if(eHour === 0){
            eHour = 12;
        }
        let eMins = date.getMinutes();
        if(eMins < 10){
            eMins = "0"+eMins;
        }
        //Check if its todays date
        if(eMonth === mm && eDay === dd){
            let mes = e.message;
            let dataDate = document.createElement("td");
            dataDate.classList.add("td-date");
            dataDate.innerHTML = eMonth + "/" +eDay +" "+eHour+":"+eMins;
            let dataMessage = document.createElement("td");
            dataMessage.classList.add("td-desc");
            dataMessage.innerHTML = mes;
            row.appendChild(dataDate);
            row.appendChild(dataMessage);
            table.appendChild(row);
        }
    }

}

//Display requests
function displayReimbursements(xhr){
    pending = 0;
    let requests = JSON.parse(xhr.response);
    requests.sort(compareReqStatus);

    let table = document.getElementById("table-of-requests");
    table.innerHTML = "";

    for(let r of requests){
        let row = document.createElement("tr");
        let RReqId = r.reqId;
        let RStatus = r.status;
        let RAmount = r.amount;
        let RReason = r.reason;
        let REmpId = r.empId;
        let REmpNotes = r.empNotes;
        let tDate = new Date(r.date);
        let day = String(tDate.getDate()).padStart(2, '0');
        let month = String(tDate.getMonth() + 1).padStart(2, '0');
        let year = tDate.getFullYear(); 

        let RDate = month+"/"+day+"/"+year;


        //Set id of tr to the request id
        row.setAttribute("id",RReqId);

        //Create the options for declineing and accepting pending requests.
        //Must be a manager, status pending, and not be your request
        let Doptions = document.createElement("td");
        if(isManager && RStatus === "Pending" && r.empId !== employee.empId){
            pending = pending + 1;
            let Oaccept = document.createElement("em");
            let aAtt = document.createAttribute("class");
            aAtt.value = "fas fa-check";
            Oaccept.setAttributeNode(aAtt); 
            Oaccept.addEventListener("click", function(){ acceptRequest(RReqId); });

            let Odecline = document.createElement("em");
            let dAtt = document.createAttribute("class");
            dAtt.value = "fas fa-ban";
            Odecline.setAttributeNode(dAtt);
            Odecline.addEventListener("click", function(){ declineRequest(RReqId); }); 

            Oaccept.classList.add("green-icon");
            Odecline.classList.add("red-icon");

            Doptions.appendChild(Oaccept);
            Doptions.appendChild(Odecline);
        }
        
        let DReqId = document.createElement("td");
        DReqId.innerHTML = RReqId;
        let DStatus = document.createElement("td");
        DStatus.innerHTML = RStatus;
        let DAmount = document.createElement("td");
        DAmount.innerHTML = RAmount;
        let DReason = document.createElement("td");
        DReason.innerHTML = RReason;
        let DEmpId = document.createElement("td");
        DEmpId.innerHTML = REmpId;
        let DEmpNotes = document.createElement("td");
        DEmpNotes.innerHTML = REmpNotes;
        let DDate = document.createElement("td");
        DDate.innerHTML = RDate;

        row.appendChild(Doptions);
        row.appendChild(DReqId);
        row.appendChild(DStatus);
        row.appendChild(DDate);
        row.appendChild(DEmpId);
        row.appendChild(DAmount);
        row.appendChild(DReason);
        row.appendChild(DEmpNotes);

        table.appendChild(row);
    }

    //Set up notifications
    if(pending > 0){
        document.getElementById("pending-notif").innerHTML = pending;
        document.getElementById("pending-notif").classList.add("red-icon");
        document.getElementById("pending-notif").classList.remove("green-icon");
    }else{
        document.getElementById("pending-notif").innerHTML = pending;
        document.getElementById("pending-notif").classList.add("green-icon");
        document.getElementById("pending-notif").classList.remove("red-icon");
    }

}

//Display Employees
function displayEmployees(xhr){
    let employees = JSON.parse(xhr.response);
    employees.sort(compareEmpId);

    //Get the table to insert into
    let table = document.getElementById("table-of-employees");
    table.innerHTML = "";

    document.getElementById("emp-add-manager").innerHTML = '<option value=""></option>';
    document.getElementById("emp-upd-manager").innerHTML = '<option value=""></option>';
    document.getElementById("emp-upd-id").innerHTML = '<option value=""></option>';
    document.getElementById("del-emp").innerHTML = '<option value=""></option>';
    document.getElementById("promote-emp").innerHTML = '<option value=""></option>';

    //Loop through and use all the information to populate the employees page
    for(let e of employees){
        if(e.empId != "0"){
            let row = document.createElement("tr");
            let EempId = e.empId;
            let Ename = e.firstName +" "+ e.lastName;
            let Ephone = e.phoneNumber;
            let EmanagerId = e.managerId;
            let Eemail = e.email;

            //Populate the table 
            let DempId = document.createElement("td");
            DempId.innerHTML = EempId;
            let Dname = document.createElement("td");
            Dname.innerHTML = Ename;
            let Dphone = document.createElement("td");
            Dphone.innerHTML = Ephone;
            let DmanagerId = document.createElement("td");
            DmanagerId.innerHTML = EmanagerId;
            let Demail = document.createElement("td");
            Demail.innerHTML = Eemail;
            row.appendChild(DempId);
            row.appendChild(Dname);
            row.appendChild(Dphone);
            row.appendChild(Demail);
            row.appendChild(DmanagerId);
            table.appendChild(row);

            let arr = ["emp-add-manager","emp-upd-manager","emp-upd-id","del-emp","promote-emp"];


            for(let a of arr){
                //Add the id to the appropriate select tags for employee options
                let optionEmp = document.createElement("option");
                let att = document.createAttribute("value");
                att.value = EempId;
                optionEmp.setAttributeNode(att);
                optionEmp.innerHTML = EempId;

                if(a === "emp-upd-id"|| a==="del-emp"||a==="promote-emp"){
                    if(id !== EempId){
                        document.getElementById(a).appendChild(optionEmp);
                    }
                }else{
                    document.getElementById(a).appendChild(optionEmp);
                }

            }
        }
    }

}

//Accept a reimbursement request
function acceptRequest(RReqId){
    ajaxPut(baseUrl+"/api/reimbursement?id="+RReqId+"&status=Accepted",function(){},function(){});
    let tableData = document.getElementById(RReqId).children;
    tableData[0].innerHTML = " ";
    tableData[2].innerHTML = "Accepted";
}

//Decline a reimbursement request
function declineRequest(RReqId){
    ajaxPut(baseUrl+"/api/reimbursement?id="+RReqId+"&status=Declined",function(){},function(){});
    let tableData = document.getElementById(RReqId).children;
    tableData[0].innerHTML = " ";
    tableData[2].innerHTML = "Declined";
}

//Create a new employee
function newEmployee(){
    let valid = true;

    //Input Labels
    let lblLast = document.getElementById("lbl-add-last");
    let lblFirst = document.getElementById("lbl-add-first");
    let lblPhone = document.getElementById("lbl-add-phone");
    let lblManager = document.getElementById("lbl-add-manager");
    let lblTitle = document.getElementById("h4-add-emp");

    //Reset input labels from incorrect input
    lblManager.innerHTML = "Manager Id"
    lblManager.classList.remove("invalid-input");
    lblLast.innerHTML = "Last Name"
    lblLast.classList.remove("invalid-input");
    lblFirst.innerHTML = "First Name"
    lblFirst.classList.remove("invalid-input");
    lblPhone.innerHTML = "Phone Number"
    lblPhone.classList.remove("invalid-input");
    lblTitle.innerHTML = "Add Emplyoee"
    lblTitle.classList.remove("invalid-input");

    //Get all information
    let inputFirstName = document.getElementById("emp-add-first").value;
    let inputLastName = document.getElementById("emp-add-last").value;
    let inputPhone = document.getElementById("emp-add-phone").value;
    let inputManager = document.getElementById("emp-add-manager").value;

    //Check that all information was entered correctly
    if(!validPhoneNumber(inputPhone)){
        lblPhone.innerHTML = "Phone Number - Invalid"
        lblPhone.classList.add("invalid-input");
        valid = false;
    }
    if(inputFirstName == ""){
        lblFirst.innerHTML = "First Name - Invalid"
        lblFirst.classList.add("invalid-input");
        valid = false;
    }
    if(inputLastName == ""){
        lblLast.innerHTML = "Last Name - Invalid"
        lblLast.classList.add("invalid-input");
        valid = false;
    }
    if(inputManager == ""){
        lblManager.innerHTML = "Manager Id - Invalid"
        lblManager.classList.add("invalid-input");
        valid = false;
    }

    if(valid){
        let newEmployee = {"email":"","password":"","empId":"","firstName":inputFirstName, "lastName":inputLastName, "phoneNumber":inputPhone, "managerId":inputManager};
        let newUrl = baseUrl + "/api/employee";
        document.getElementById("emp-add-first").value = "";
        document.getElementById("emp-add-last").value= "";
        document.getElementById("emp-add-phone").value= "";
        document.getElementById("emp-add-manager").value= "";
        ajaxPost(newUrl, JSON.stringify(newEmployee), displayUpdateEmployee,faliedCreateEmployee);
    }
}

//Update the employee display
function displayUpdateEmployee(xhr){
    ajaxGet(baseUrl+"/api/employees?emp_id="+id,displayEmployees);
    ajaxGet(baseUrl+"/api/reimbursements?emp_id="+id,displayReimbursements); 
}

//Update an existing employee
function updateEmployee(){
    let valid = true;

    //Input Labels
    let lblLast = document.getElementById("lbl-upd-last");
    let lblFirst = document.getElementById("lbl-upd-first");
    let lblPhone = document.getElementById("lbl-upd-phone");
    let lblManager = document.getElementById("lbl-upd-manager");
    let lblTitle = document.getElementById("h4-upd-emp");

    //Reset input labels from incorrect input
    lblManager.innerHTML = "Manager"
    lblManager.classList.remove("invalid-input");
    lblLast.innerHTML = "Last Name"
    lblLast.classList.remove("invalid-input");
    lblFirst.innerHTML = "First Name"
    lblFirst.classList.remove("invalid-input");
    lblPhone.innerHTML = "Phone Number"
    lblPhone.classList.remove("invalid-input");
    lblTitle.innerHTML = "Update Emplyoee"
    lblTitle.classList.remove("invalid-input");

    //Get all information
    let inputFirstName = document.getElementById("emp-upd-first").value;
    let inputLastName = document.getElementById("emp-upd-last").value;
    let inputPhone = document.getElementById("emp-upd-phone").value;
    let inputManager = document.getElementById("emp-upd-manager").value;
    let inputId = document.getElementById("emp-upd-id").value;

    //Check that all information was entered correctly
    if(!validPhoneNumber(inputPhone)){
        lblPhone.innerHTML = "Phone Number - Invalid"
        lblPhone.classList.add("invalid-input");
        valid = false;
    }
    if(inputFirstName == ""){
        lblFirst.innerHTML = "First Name - Invalid"
        lblFirst.classList.add("invalid-input");
        valid = false;
    }
    if(inputLastName == ""){
        lblLast.innerHTML = "Last Name - Invalid"
        lblLast.classList.add("invalid-input");
        valid = false;
    }
    if(inputManager == ""){
        lblManager.classList.add("invalid-input");
        valid = false;
    }
    if(inputId == ""){
        lblId.classList.add("invalid-input");
        valid = false; 
    }
    
    if(valid){
        let updateEmployee = {"email":"","password":"","empId":inputId,"firstName":inputFirstName, "lastName":inputLastName, "phoneNumber":inputPhone, "managerId":inputManager};
        let newUrl = baseUrl + "/api/employee";
        document.getElementById("emp-upd-first").value="";
        document.getElementById("emp-upd-last").value="";
        document.getElementById("emp-upd-phone").value="";
        document.getElementById("emp-upd-manager").value="";
        document.getElementById("emp-upd-id").value="";
        ajaxPut(newUrl, JSON.stringify(updateEmployee), displayUpdateEmployee,failedUpdateEmployee);
    }
}

//Delete an employee
function deleteEmployee(){
    document.getElementById("lbl-del-emp").classList.remove("invalid-input");
    let inputId = document.getElementById("del-emp").value;

    if(inputId == ""){
        document.getElementById("lbl-del-emp").classList.add("invalid-input");
    }else{
        let newUrl = baseUrl + "/api/employee?emp_id="+inputId;
        document.getElementById("del-emp").value = "";
        ajaxDelete(newUrl, displayUpdateEmployee);

        
    }


}

//Promote an employee
function promoteEmployee(){
    document.getElementById("lbl-promote-emp").classList.remove("invalid-input");
    let inputId = document.getElementById("promote-emp").value;

    if(inputId == ""){
        document.getElementById("lbl-promote-emp").classList.add("invalid-input");
    }else{
        let newUrl = baseUrl + "/api/employee/promote?emp_id="+inputId;
        document.getElementById("promote-emp").value = "";
        ajaxPut(newUrl, "",displayUpdateEmployee);

    }
}

//Fill in update employee info
function fillUpdateInfo(xhr){
    let fillemployee = JSON.parse(xhr.response);
    console.log("Filling Employee Info!")
    console.log(fillemployee);

    document.getElementById("emp-upd-first").value = fillemployee.firstName;
    document.getElementById("emp-upd-last").value = fillemployee.lastName;
    document.getElementById("emp-upd-phone").value = fillemployee.phoneNumber;
    document.getElementById("emp-upd-manager").value = fillemployee.managerId;
}

//Should information be filled
function shouldFillInfo(){
    if(document.getElementById("emp-upd-id").value !== ""){
        ajaxGet(baseUrl+"/api/employee?emp_id="+document.getElementById("emp-upd-id").value,fillUpdateInfo);
    }
}

//Logout
function logout(){
    sessionStorage.removeItem("token");
    window.location.href="http://localhost:8080/CompanyEmployeeHub/loginPage";
}

//Update information
function updateEmployeeInfo(){
    let valid = true;

    //Input Labels
    let lblLast = document.getElementById("lbl-last");
    let lblFirst = document.getElementById("lbl-first");
    let lblPhone = document.getElementById("lbl-phone");

    //Reset input labels from incorrect input
    lblLast.innerHTML = "Last Name"
    lblLast.classList.remove("invalid-input");
    lblFirst.innerHTML = "First Name"
    lblFirst.classList.remove("invalid-input");
    lblPhone.innerHTML = "Phone Number"
    lblPhone.classList.remove("invalid-input");
    document.getElementById("update-info-emp").innerHTML = "Update Info"
    document.getElementById("update-info-emp").classList.remove("invalid-input");

    //Get all the information
    let inputFirstName = document.getElementById("new-first").value;
    let inputLastName = document.getElementById("new-last").value;
    let inputPhone = document.getElementById("new-phone").value;

    if(!validPhoneNumber(inputPhone)){
        lblPhone.innerHTML = "Phone Number - Invalid"
        lblPhone.classList.add("invalid-input");
        valid = false;
    }
    if(inputFirstName == ""){
        lblFirst.innerHTML = "First Name - Invalid"
        lblFirst.classList.add("invalid-input");
        valid = false;
    }
    if(inputLastName == ""){
        lblLast.innerHTML = "Last Name - Invalid"
        lblLast.classList.add("invalid-input");
        valid = false;
    }

    if(valid){
        let updateEmployee = {"email":"","password":"","empId":employee.empId,"firstName":inputFirstName, "lastName":inputLastName, "phoneNumber":inputPhone, "managerId":employee.managerId};
        let newUrl = baseUrl + "/api/employee";
        document.getElementById("new-first").value="";
        document.getElementById("new-last").value="";
        document.getElementById("new-phone").value="";
        employee.firstName = inputFirstName;
        employee.lastName = inputLastName;
        employee.phoneNumber = inputPhone;
        document.getElementById("presName").innerHTML = `Name: ${employee.firstName} ${employee.lastName}`;
        ajaxPut(newUrl, JSON.stringify(updateEmployee),displayUpdateEmployee,faliedUpdateInfo);
    }


}

//Verify a phone number entered is 11 digits and all numbers
function validPhoneNumber(phone){
    let newPhone = phone.match(/\d/g);
    if(newPhone == null){
        return false;
    }
    return newPhone.length === 11;
    
}

//Change password
function changePassword(){
    let valid = true;

    //Input Labels
    let lblCurPass = document.getElementById("lbl-cur-pass");
    let lblNewPass1 = document.getElementById("lbl-new-pass-1");
    let lblNewPass2 = document.getElementById("lbl-new-pass-2");

    //Reset input labels from incorrect input
    lblCurPass.innerHTML = "Current Password";
    lblCurPass.classList.remove("invalid-input");
    lblNewPass1.innerHTML = "Enter New Password";
    lblNewPass1.classList.remove("invalid-input");
    lblNewPass2.innerHTML = "Renter New Password";
    lblNewPass2.classList.remove("invalid-input");

    //Get all the information
    let inputCurPass = document.getElementById("cur-pass").value;
    let inputNewPass1 = document.getElementById("new-pass-1").value;
    let inputNewPass2 = document.getElementById("new-pass-2").value;

    if(inputNewPass1 !== inputNewPass2){
        valid = false;
        lblNewPass1.innerHTML = "Enter New Password - Don't Match";
        lblNewPass1.classList.add("invalid-input");
        lblNewPass2.innerHTML = "Renter New Password - Don't Match";
        lblNewPass2.classList.add("invalid-input");
    }

    if(valid){
        let newUrl = baseUrl + `/api/employee/changepassword?emp_id=${id}&password=${inputCurPass}&newpass=${inputNewPass1}`;
        document.getElementById("cur-pass").value = "";
        document.getElementById("new-pass-1").value = "";
        document.getElementById("new-pass-2").value = "";
        ajaxPut(newUrl, "",displayUpdateEmployee,failedPassword);
    }
}

//New Request
function newRequest(){

    //Get all labels
    let lblAmount = document.getElementById("lbl-req-amount");
    lblAmount.innerHTML = "Amount";
    lblAmount.classList.remove("invalid-input");
    let lblTitle = document.getElementById("h3-new-req");
    lblTitle.innerHTML = "New Reimbursement";
    lblTitle.classList.remove("invalid-input");

    //Get the users input
    let inputAmount = document.getElementById("inp-amount").value;
    let inputReason = document.getElementById("sel-reason").value;
    let inputMessage = document.getElementById("inp-info").value;


    //Test amount to be valid
    if (/^\d+(?:\.\d{0,2})$/.test(inputAmount)){
        let newReq = {"reqId":"","empId":id, "status":"Pending","amount":inputAmount,"reason":inputReason,"managerId":employee.managerId,"empNotes":inputMessage,"managerNotes":"","date":today};
            
        let newUrl = baseUrl + "/api/reimbursement";

        document.getElementById("inp-amount").value = "";
        document.getElementById("sel-reason").value = "Travel";
        document.getElementById("inp-info").value = "";

        ajaxPost(newUrl, JSON.stringify(newReq), displayUpdateRequests,faliedCreateRequest);

    }else{
        lblAmount.innerHTML = "Amount";
        lblAmount.classList.add("invalid-input");
    }
}

//Update the display requests
function displayUpdateRequests(xhr){
    ajaxGet(baseUrl+"/api/reimbursements?emp_id="+id,displayReimbursements);
}

//Toggle showing add event option
function toggleAddEvents(){
    let addEventView = document.getElementById("event-add");
    let timeView = document.getElementById("event-date");
    let toggleEventButton = document.getElementById("toggle-new-event")

    if(addEventView.hidden){
        addEventView.hidden = false;
        timeView.hidden = true;
        toggleEventButton.classList.remove("fa-plus");
        toggleEventButton.classList.add("fa-minus");
    }else{
        addEventView.hidden = true;
        timeView.hidden = false;
        toggleEventButton.classList.add("fa-plus");
        toggleEventButton.classList.remove("fa-minus");
    }
}

//Add events to server
function addEvents(){
    let dateAndTime = document.getElementById("event-add-date").value;
    let newEventInfo = document.getElementById("event-info").value;
    let valid = true;

    document.getElementById("lbl-event-add-date").classList.remove("invalid-input");
    document.getElementById("lbl-event-add-desc").classList.remove("invalid-input");

    //Validate input
    if(newEventInfo === ""){
        document.getElementById("lbl-event-add-desc").classList.add("invalid-input");
        valid = false;
    }

    if(dateAndTime === ""){
        document.getElementById("lbl-event-add-date").classList.add("invalid-input");
        valid = false;
    }

    if(valid){
        let newUrl = baseUrl + "/api/events";
        let newDate = new Date(dateAndTime);
        let newEvents = {"id":"","dateTime":newDate,"message":newEventInfo, "empId":id}
        document.getElementById("event-add-date").value= "";
        document.getElementById("event-info").value= "";
        document.getElementById("lbl-event-add-date").classList.remove("invalid-input");
        document.getElementById("lbl-event-add-desc").classList.remove("invalid-input");
        ajaxPost(newUrl, JSON.stringify(newEvents), displayUpdateEvents,faliedCreateEvents);
    }

}

//Display update events
function displayUpdateEvents(xhr){
    ajaxGet(baseUrl+"/api/events?emp_id="+id,displayEvents);
}

//Basic Ajax Get function
function ajaxGet(url, callback){
    let xhr = new XMLHttpRequest();
    xhr.open("GET",url);
	xhr.onreadystatechange = function(){
		if(this.readyState === 4 && this.status === 200){
			
			callback(this);
		}
	}
	xhr.setRequestHeader("Authorization",token);
	xhr.send();
}

//Basic Ajax Post function
function ajaxPost(url, jsonBody, callback,failcallback){
    let xhr = new XMLHttpRequest();
    xhr.open("POST",url);
	xhr.onreadystatechange = function(){
		if(this.readyState === 4 && this.status === 200){
			callback(this);
		}else if(this.readyState === 4 && this.status === 404){
            failcallback(this);
        }
	}
    xhr.setRequestHeader("Authorization",token);
    xhr.setRequestHeader("Content-Type", "application/json");
	xhr.send(jsonBody);
}

//Basic Ajax Put function
function ajaxPut(url, jsonBody, callback, failcallback){
    let xhr = new XMLHttpRequest();
    xhr.open("PUT",url);
	xhr.onreadystatechange = function(){
		if(this.readyState === 4  && this.status === 201){
			callback(this);
		}else if(this.readyState === 4 && this.status === 404){
            failcallback(this);
        }
	}
    xhr.setRequestHeader("Authorization",token);
    xhr.setRequestHeader("Content-Type", "application/json");
	xhr.send(jsonBody);
}

//Basic Ajax Delete function
function ajaxDelete(url,callback){
    let xhr = new XMLHttpRequest();
    xhr.open("DELETE",url);
	xhr.onreadystatechange = function(){
		if(this.readyState === 4 && this.status === 202){
			callback(this);
		}
	}
    xhr.setRequestHeader("Authorization",token);
	xhr.send();
}

//Invalid current password
function failedPassword(xhr){
    document.getElementById("lbl-cur-pass").innerHTML = "Current Password - Incorrect";
    document.getElementById("lbl-cur-pass").classList.add("invalid-input");
}

//Invalid create employee
function faliedCreateEmployee(xhr){
    document.getElementById("h4-add-emp").innerHTML = "Add Emplyoee - Failed"
    document.getElementById("h4-add-emp").classList.add("invalid-input");
}

//Invalid update employee
function failedUpdateEmployee(xhr){
    document.getElementById("h4-upd-emp").innerHTML = "Update Emplyoee - Failed"
    document.getElementById("h4-upd-emp").classList.add("invalid-input");
}

//Invalid update employe info
function faliedUpdateInfo(xhr){
    document.getElementById("update-info-emp").innerHTML = "Update Info - Failed"
    document.getElementById("update-info-emp").classList.add("invalid-input");
}

//Invalid request
function faliedCreateRequest(){
    document.getElementById("h3-new-req").innerHTML = "New Reimbursement - Failed"
    document.getElementById("h3-new-req").classList.add("invalid-input");
}

//Invalid events made
function faliedCreateEvents(){

}

//Setup searching reim requests table
function setupRequestSearch(){
    $("#reim-search").keyup(function() {
        var value = this.value.toLowerCase().trim();

        $("#reim-table").find("tr").each(function(index) {
            var id = $(this).find("td").text().toLowerCase().trim();
            $(this).toggle(id.indexOf(value) !== -1);
        });
    });
}

//Setup searching employee table
function setupEmployeeSearch(){
    $("#emp-search").keyup(function() {
        var value = this.value.toLowerCase().trim();

        $("#table-of-employees").find("tr").each(function(index) {
            var id = $(this).find("td").text().toLowerCase().trim();
            $(this).toggle(id.indexOf(value) !== -1);
        });
    });
}

//compare to sort object arrays of employees by id
function compareEmpId(a, b) {

    const ida = a.empId;
    const idb = b.empId;
  
    let comparison = 0;
    if (ida > idb) {
      comparison = 1;
    } else if (ida < idb) {
      comparison = -1;
    }
    return comparison;
}
  
//Compare requests to order them in order of pending, accepted, declined
function compareReqStatus(a, b) {

    const statusa = a.status;
    const statusb = b.status;
    const ida = a.reqId;
    const idb = b.reqId;
  
    let comparison = 0;

    if(statusa === "Pending" && statusa === statusb){
        if(ida < idb){
            comparison = -1;
        }else if(ida > idb){
            comparison = 1;
        }
    }else if(statusa === "Pending"){
        comparison = -1;
    }else if(statusa !== "Pending" && statusb === "Pending"){
        comparison = 1
    }else if(statusa !== "Pending" && statusb !== "Pending"){
        if(statusa === "Accepted" && statusa === statusb){
            if(ida < idb){
                comparison = -1;
            }else if(ida > idb){
                comparison = 1;
            }
        }else if(statusa === "Accepted"){
            comparison = -1;
        }else if(statusa === "Declined"  && statusb === "Accepted"){
            comparison = 1;
        }else{
            if(ida < idb){
                comparison = -1;
            }else if(ida > idb){
                comparison = 1;
            }
        }
    }

    return comparison;
}

//Compare the date and time of events to order them
function compareDateTime(a,b){
    let aDate = new Date(a.dateTime);  
    let aMonth = aDate.getMonth()+1;
    let aDay = aDate.getDate();
    let aHour = aDate.getHours();
    let aMins = aDate.getMinutes();

    let bDate = new Date(b.dateTime);  
    let bMonth = bDate.getMonth()+1;
    let bDay = bDate.getDate();
    let bHour = bDate.getHours();
    let bMins = bDate.getMinutes();


    let comparison = 0;
    if(aMonth === bMonth){
        if(aDay === bDay){
            if(aHour === bHour){
                if(aMins === bMins){
                    comparison = 1;
                }else if(aMins > bMins){
                    comparison = 1;
                }else{
                    comparison = -1;
                }
            }else if(aHour > bHour){
                comparison = 1;
            }else{
                comparison = -1;
            }
        }else if(aDay > bDay){
            comparison = 1;
        }else{
            comparison = -1;
        }
    }else if(aMonth > bMonth){
        comparison = 1;
    }else{
        comparison = -1;
    }


    return comparison;
}