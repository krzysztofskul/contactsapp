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
				id: getId(),
				addressEntryList: getAddressArray(),
				phoneNumberEntries: getPhoneNumberEntries(),
				emailEntries: getEmailEntries(),
				subject: getSubject()
			}
		}
	
	var testDiv = '<div class="border">TEST</div>';
	function testFunction() {
		//addressArray = getAddressArray();
		console.log(getContact());
	}
	
	function getId() {
		return $("#contactId").attr("value");
	}
	
	function getSubject() {
		var type;
		if ($("input[name='subjectName']").val() == undefined) {
			type = "Person"
		} else {
			type = "Company"
		}
		return {
			type: type,
			id: $("input[name='subjectId']").val(), 
			name: $("input[name='subjectName']").val(),
			nameFirst: $("input[name='subjectNameFirst']").val(),
			nameLast: $("input[name='subjectNameLast']").val()
		}
	}
	
	function getAddressArray() {
		var arrayDivAddressEntry = $(".addressEntry");
		var addressEntryArray = [];

		arrayDivAddressEntry.each(function() {
			var AddressEntry = new Object();
			var Address = new Object();
			AddressEntry.id = $(this).find("input[name='addressEntryId']").val();			
			AddressEntry.name = $(this).find("input[name='addressName']").val();
			Address.id = $(this).find("input[name='addressId']").val();
			Address.country = $(this).find("input[name='addressCountry']").val();
			Address.zipCode = $(this).find("input[name='addressZipCode']").val();
			Address.city = $(this).find("input[name='addressCity']").val();
			Address.streetName = $(this).find("input[name='addressStreetName']").val();
			Address.streetNo = $(this).find("input[name='addressStreetNo']").val();
			Address.flatNo = $(this).find("input[name='addressFlatNo']").val();
			AddressEntry.address = Address;
			addressEntryArray.push(AddressEntry);
		});
		return addressEntryArray;
	}
	
	function getPhoneNumberEntries() {
		var arrayDivPhoneNumberEntries = $(".phoneNumberEntry");
		var phoneNumberEntryArray = [];

		arrayDivPhoneNumberEntries.each(function() {
			var PhoneNumberEntry = new Object();
			PhoneNumberEntry.id = $(this).find("input[name='phoneNumberEntryId']").val();			
			PhoneNumberEntry.name = $(this).find("input[name='phoneNumberEntryName']").val();
			PhoneNumberEntry.data = $(this).find("input[name='phoneNumberEntryData']").val();
			phoneNumberEntryArray.push(PhoneNumberEntry);
		});
		return phoneNumberEntryArray;
	}
	
	function getEmailEntries() {
		var arrayDivEmailEntries = $(".emailEntry");
		var emailEntryArray = [];

		arrayDivEmailEntries.each(function() {
			var EmailEntry = new Object();
			EmailEntry.id = $(this).find("input[name='emailEntryId']").val();			
			EmailEntry.name = $(this).find("input[name='emailEntryName']").val();
			EmailEntry.data = $(this).find("input[name='emailEntryData']").val();
			emailEntryArray.push(EmailEntry);
		});
		return emailEntryArray;
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
		return '	<div class="row emailEntry"> \
				<input id="emailId_0" name="emailEntryId" value="0" type="hidden">\
				<div class="col-2"> \
					<input type="text" th:id="emailEntryName_0" name="emailEntryName" class="form-control"> \
				</div> \
				<div class="col-10"> \
				  <input type="text" th:id="emailEntryData_0" name="emailEntryData" class="form-control"> \
				</div> \
			</div>'
	} 
					
	var newEmailRow = getNewEmailRow();
	
	function getNewPhoneNumerRow() {
		return '	<div class="row phoneNumberEntry"> \
				<input id="phoneNumberId_0" name="phoneNumberEntryId" value="0" type="hidden">\
				<div class="col-2"> \
					<input type="text" th:id="phoneNumberEntryName_0" name="phoneNumberEntryName" class="form-control"> \
				</div> \
				<div class="col-10"> \
				  <input type="text" th:id="phoneNumberEntryData_0" name="phoneNumberEntryData" class="form-control"> \
				</div> \
			</div>'
		 	
	}
	
	var newPhoneNumerRow = getNewPhoneNumerRow();
	
	function initButtons() {
		btnAddAddress.on("click", function() {
			$(this).before(newAddressRow);
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
 		$.ajax({
                url: "/restapi/contacts/"+Contact.id,
                dataType: "JSON",
                type: "POST",
                data: JSON.stringify(getContact()),
                contentType: "application/json"
            }).done(function () {
                alert("Contact saved!");
            }).fail(function () {
                alert("Contact haven't been saved to DB!");
            }).always(function () {
                location.replace("/contacts/"+Contact.id);
				
            });

		
 	}
	
	function initJs() {
		initButtons();
		testFunction();		
	}
	
	initJs();
	
	});