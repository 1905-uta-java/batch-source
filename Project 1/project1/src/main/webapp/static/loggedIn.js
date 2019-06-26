document.getElementById("newTransaction").addEventListener('click', function(){
	window.location.href="http://localhost:8080/newTransaction";
});
document.getElementById('logout').addEventListener('click', function(){sessionStorage.removeItem("token")});

function startup(xhr){
	let employeeId = sessionStorage.getItem("token");
	
	let empid = sessionStorage.getItem("token");
	let emp = JSON.parse(sessionStorage.getItem("token"));
	
	let table = document.getElementById("table");
	table.className = "table table-striped";
	let tableRow = document.createElement('tr');
	
	function addData(tr, data){
		let tableData= document.createElement('td');
		tableData.innerHTML = data;
		tr.appendChild(tableData);
	}

	if(empid[6] == 1){
		let type = document.getElementById('type');
		type.innerHTML = "Employee: " + xhr.getResponseHeader("employee");
		
		addData(tableRow, "Transaction ID");
		addData(tableRow, "Amount");
		addData(tableRow, "Employee");
		addData(tableRow, "Manager");
		addData(tableRow, "Transaction Log");
		addData(tableRow, "Accept Button");
		addData(tableRow, "Deny Button");
		table.appendChild(tableRow);
		
		
		let javaObj = JSON.parse(xhr.response)[0];
			
		for(let i = 0; i < javaObj.transactions.length; i++){
			rowCreation(i ,javaObj, javaObj.transactions[i]);
		}
		
		function rowCreation(rowNum, javaObj, jst){
			let tr = document.createElement('tr');
			let AButton = document.createElement("button");
			AButton.innerHTML = "Accept";
			AButton.className="AcceptButton" + rowNum;
			let DButton = document.createElement("button");
			DButton.innerHTML = "Deny";
			DButton.className = "DenyButton" + rowNum;
			tr.className=rowNum;
			tr.addEventListener("click", function(){
				console.log(rowNum);
				
				
				
			});
			let id = jst.id;
			let amount = jst.amount;
			let eid = javaObj.empName;
			let mid = javaObj.manName;
			let log = jst.log;
			
			tr.append(data(id));
			tr.append(data(amount));
			tr.append(data(eid));
			tr.append(data(mid));
			tr.append(data(log));
			tr.append(AButton);
			tr.append(DButton);
			table.append(tr);
			
			
		}
	}
	
	else if(empid[6] == 2){
		let type = document.getElementById('type');
		type.innerHTML = "Manager: " + xhr.getResponseHeader("manager");
		
		addData(tableRow, "Transaction ID");
		addData(tableRow, "Amount");
		addData(tableRow, "Employee");
		addData(tableRow, "Manager");
		addData(tableRow, "Transaction Log");
		table.appendChild(tableRow);
		
		
		
		let javaObj = JSON.parse(xhr.response);
		
		for(let i = 0; i < javaObj.length; i++){
			running(javaObj[i]);
		}
		function running(javaObj){
			for(let i = 0; i < javaObj.transactions.length; i++){
				rowCreation(i ,javaObj, javaObj.transactions[i]);
			}
		}
		
		function rowCreation(rowNum, javaObj, jst){
			let tr = document.createElement('tr');
			tr.className=rowNum;
			//let button = //create button that passes rownum and allows more views
			tr.addEventListener("click", function(){
				
				console.log(rowNum);
				
				
				
			});
			let id = jst.id;
			let amount = jst.amount;
			let eid = javaObj.empName;
			let mid = javaObj.manName;
			let log = jst.log;
			
			tr.append(data(id));
			tr.append(data(amount));
			tr.append(data(eid));
			tr.append(data(mid));
			tr.append(data(log));
			table.append(tr);
			
			
		}
		
		
	}
		
	}
	
	function data(da){
		let td = document.createElement('td');
		td.innerHTML = da;
		return td;
	}


	





function request(mve){
	let xhr = new XMLHttpRequest();
	xhr.open("POST","http://localhost:8080/getTransactions");
	let ID = JSON.parse(sessionStorage.getItem("token"));
	let id = ID.id;
	xhr.onreadystatechange = function(){
		if(xhr.readyState === 4){
			startup(this);
		}
	}
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	let Body = "empId="+id;
	xhr.send(Body);
}


let mve = sessionStorage.getItem("token")[6];
window.onLoad = request(mve);
