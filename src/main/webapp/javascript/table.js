let userData;
if(localStorage.getItem("userData") == "null"){
	document.write("you logged out remember?");
} else{
	userData = JSON.parse(localStorage.getItem("userData"));

	populateTable("new");
}


function showTables(data){
    $('#table').DataTable({
    	"pageLength" : 2,
    	"data": data,
    	"columns": [
            { data: 'imbId' },
            { data: 'imbAmount' },
            { data: 'imbSubmitted' },
            { data: 'imbDescription' },
            {
                "className": 'options',
                "data": 'imbType',
                "render": function(data, type, full, meta){
                	if(data == 1) {
	                   return "Food";
                	} else if (data == 2) {
		                   return "Travel";

                	} else if (data == 3) {
		                   return "Lodging";

                	} else if (data == 4) {
	                   return "Other";

                		}
                }
            },
            
            {
                "className":'options',
                "data":'imbStatus',
                "render": function(data, type, full, meta){
                	if(data == 1) {
	                   return "<img src = 'assets/pending.png' style = 'height: 59px'/>";
                	} else if (data == 2) {
		                   return "<img src = 'assets/checkmark.png' style = 'height: 60px'/>";

                	} else if (data ==3) {
		                   return "<img src = 'assets/chainsaw.png' style = 'height: 60px'/>";

                		}
                }
            }
        ]
    } );
}

 

function addReimb(){
	
	let type = document.getElementById("selector").value;
	let amount = document.getElementById("amount").value;
	let desc = document.getElementById("desc").value;
	
	const formData = new FormData();
	

	formData.append('type', type);
	formData.append('amount', amount);
	formData.append('desc', desc);
	formData.append('author', userData.id);

	fetch('./addImbursement', {
	  method: 'POST',
	  body: formData
	})
	.then((response) => response)
	.then((result) => {
		console.log(result);
	  populateTable("update");
	  console.log("anything after");
	})
	.catch((error) => {
	  console.error('Error:', error);
	});
}

function populateTable(value){
	
const formData = new FormData();
	

	formData.append('id', userData.id);
	
	
	fetch('./getAllReimbursements', {
		  method: 'POST',
		  body: formData
		})
		.then((response) => response.json())
		.then((data) => {
			if(value == "update"){
			    $('#table').dataTable().fnClearTable();
		    	$('#table').dataTable().fnAddData(data);
		    	clearReimb();
		    	} else {
			    	showTables(data);
		    	}
	    })
		.catch((error) => {
		  console.error('Error:', error);
		});
}

function clearReimb(){
	document.getElementById("amount").value = "";
	document.getElementById("desc").value = "";
	document.getElementById("selector").selectedIndex = 0
	
	console.log("check it out bitchhes")
}

function logout(){
	
	window.location.href = "/project1";
	localStorage.setItem("userData", null);
	
}
