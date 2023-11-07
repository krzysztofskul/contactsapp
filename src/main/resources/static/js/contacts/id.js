/**
 * 
 */

$(document).ready(function() {

	// alert("id.js test"); 
	
	var btnAddAddress = $("#btn-add-address");
	var btnAddEmail = $("#btn-add-email");
	var btnAddPhoneNumber = $("#btn-add-phoneNumber");
	var btnSubmit = $("button[type='submit']");

	var Contact = getContact(); 
	
	function getContact() {
		return {
				id: $("#contactId").attr("value"),
				//addressEntryList: getAddressArray(),
				subject: {type: "Company", name: "test", id: "1"}
			}
		}
	
	var addressArray;
	
	var testDiv = '<div class="border">TEST</div>';
	function testFunction() {
		//addressArray = getAddressArray();
		console.log(getContact());
	}
	
	function getAddressArray() {
		var arrayDivAddressEntry = $(".addressEntry");
		var addressEntryArray = [];
		arrayDivAddressEntry.each(function() {
			var AddressEntry = new Object();
			AddressEntry.name = $(this).find("input[name='addressName']").val();
			AddressEntry.id = $(this).find("input[name='addressId']").attr("value");
/*			Address.country = $(this).find("input[name='addressCountry']").val();
			Address.zipCode = $(this).find("input[name='addressZipCode']").val();
			Address.city = $(this).find("input[name='addressCity']").val();
			Address.streetName = $(this).find("input[name='addressStreetName']").val();
			Address.streetNo = $(this).find("input[name='addressStreetNo']").val();
			Address.flatNo = $(this).find("input[name='addressFlatNo']").val();*/
			addressEntryArray.push(AddressEntry);
		});
		return addressEntryArray;
	}
	
	var newAddressRow = getAddressRow();
	
	function getAddressRow() {
	 
			return '<div class="row addressEntry"> \
			<input id="addressId_0" name="addressId" value="0" type="hidden">\
			<div class="col-2"> \
				<input id="addressName_0" name="addressName" type="text" class="form-control" placeholder="address name"> \
			</div> \
			<div class="col-4">\
			  <input id="addressCountry_0" name="addressCountry" type="text" class="form-control" placeholder="country">\
			</div>\
			<div class="col-2">\
			  <input id="addressZipCode_0" name="addressZipCode" type="text" class="form-control text-right" placeholder="zip-code">\
			</div>\
			<div class="col-4">\
			  <input id="addressCity_0" name="addressCity" type="text" class="form-control" placeholder="city">\
			</div>\
			<div class="col-2">\</div>\
			<div class="col-8">\
			  <input id="addressStreetName_0" name="addressStreetName" type="text" class="form-control" placeholder="street name">\
			</div>\
			<div class="col-1">\
			  <input id="addressStreetNo_0" name="addressStreetNo" type="text" class="form-control" placeholder="street no.">\
			</div>\
			<div class="col-1">\
			  <input id="addressFlatNo_0" name="addressFlatNo" type="text" class="form-control" placeholder="flat no.">\
			</div>\
			</div>'
	}
		
	function getNewEmailRow() {
		return '	<div class="row"> \
				<div class="col-2"> \
					<input type="text" class="form-control" th:placeholder="${emailEntry?.name} ?  ${emailEntry?.name}"> \
				</div> \
				<div class="col-10"> \
				  <input type="text" class="form-control" th:placeholder="${emailEntry?.data} ?  ${emailEntry?.data}"> \
				</div> \
			</div>'
	} 
					
	var newEmailRow = getNewEmailRow();
	
	function getNewPhoneNumerRow() {
		'	<div th:each="phoneNumberEntry : ${contact.phoneNumberEntries}" class="row"> \
				<div class="col-2"> \
					<input type="text" class="form-control" th:placeholder="${phoneNumberEntry?.name} ?  ${phoneNumberEntry?.name}"> \
				</div> \
				<div class="col-10"> \
				  <input type="text" class="form-control" th:placeholder="${phoneNumberEntry?.data} ?  ${phoneNumberEntry?.data}"> \
				</div> \
			</div>'
		return 	
	}
	
	var newPhoneNumerRow = getNewPhoneNumerRow();
	
	function initButtons() {
		btnAddAddress.on("click", function() {
			$(this).before(newAddressRow);
			testFunction();
		});
		btnAddEmail.on("click", function() {
			$(this).before(newEmailRow);
		});
		btnAddPhoneNumber.on("click", function() {
			$(this).before(newPhoneNumerRow);
		});
		
		btnSubmit.on("mouseenter", function(event) {
			testFunction();
		})
		btnSubmit.on("click", function(event){
			event.preventDefault();
			ajaxSend();
		})
	}
	
	function ajaxSend() {
/*		$.post(

			"/restapi/contacts/"+Contact.id,
			JSON.stringify(Contact),
			function(data, status) {
				alert(data+"\n"+status);
			}
		);*/
		console.log(JSON.stringify(getContact()));
 		$.ajax({
                url: "/restapi/contacts/"+Contact.id,
                dataType: "JSON",
                type: "POST",
                data: JSON.stringify(getContact()),
                contentType: "application/json"
            }).done(function () {
                alert("new foo send to DB!");
            }).fail(function () {
                alert("new foo haven't been saved to DB!");
            }).always(function () {
                //alert("saving new foo to DB process finished!");
                /**
                 * JS page redirection
                 */
                //window.location = "/home";
                //location.replace("/foos");
            });

		
	}
	
	
	
	function initJs() {
		initButtons();
		testFunction();		
	}
	
	initJs();
	
	});