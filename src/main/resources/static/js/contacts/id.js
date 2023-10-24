/**
 * 
 */

$(document).ready(function() {

	// alert("id.js test"); 
	
	var btnAddAddress = $("#btn-add-address");
	var btnAddEmail = $("#btn-add-email");
	var btnAddPhoneNumber = $("#btn-add-phoneNumber");
	
	var testDiv = '<div class="border">TEST</div>';
	
	var newAddressRow = 
		'	<div class="row"> \
			<div class="col-2"> \
				<input type="text" class="form-control" th:placeholder="${addressEntry?.name} ?  ${addressEntry?.name}"> \
			</div> \
			<div class="col-4">\
			  <input type="text" class="form-control" th:placeholder="${addressEntry?.address?.country} ?  ${addressEntry?.address?.country}">\
			</div>\
			<div class="col-2">\
			  <input type="text" class="form-control text-right" th:placeholder="${addressEntry?.address?.zipCode} ?  ${addressEntry?.address?.zipCode}">\
			</div>\
			<div class="col-4">\
			  <input type="text" class="form-control" th:placeholder="${addressEntry?.address?.city} ?  ${addressEntry?.address?.city}">\
			</div>\
			<div class="col-2">\</div>\
			<div class="col-8">\
			  <input type="text" class="form-control" th:placeholder="${addressEntry?.address?.streetName} ?  ${addressEntry?.address?.streetName}">\
			</div>\
			<div class="col-1">\
			  <input type="text" class="form-control" th:placeholder="${addressEntry?.address?.streetNo} ?  ${addressEntry?.address?.streetNo}">\
			</div>\
			<div class="col-1">\
			  <input type="text" class="form-control" th:placeholder="${addressEntry?.address?.flatNo} ?  ${addressEntry?.address?.flatNo}">\
			</div>\
			</div>'
	;
					
	var newEmailRow = 
		'	<div class="row"> \
				<div class="col-2"> \
					<input type="text" class="form-control" th:placeholder="${emailEntry?.name} ?  ${emailEntry?.name}"> \
				</div> \
				<div class="col-10"> \
				  <input type="text" class="form-control" th:placeholder="${emailEntry?.data} ?  ${emailEntry?.data}"> \
				</div> \
			</div>'
	;
	
	var newPhoneNumerRow = 
		'	<div th:each="phoneNumberEntry : ${contact.phoneNumberEntries}" class="row"> \
				<div class="col-2"> \
					<input type="text" class="form-control" th:placeholder="${phoneNumberEntry?.name} ?  ${phoneNumberEntry?.name}"> \
				</div> \
				<div class="col-10"> \
				  <input type="text" class="form-control" th:placeholder="${phoneNumberEntry?.data} ?  ${phoneNumberEntry?.data}"> \
				</div> \
			</div>'
	;
	
	
	btnAddAddress.on("click", function() {
		$(this).before(newAddressRow);
	});
	btnAddEmail.on("click", function() {
		$(this).before(newEmailRow);
	});
	btnAddPhoneNumber.on("click", function() {
		$(this).before(newPhoneNumerRow);
	});
	
});