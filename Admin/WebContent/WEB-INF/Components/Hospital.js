$(document).ready(function() {
    if ($("#alertSuccess").text().trim() == "") {
        $("#alertSuccess").hide();
    }
    $("#alertError").hide();
});
// SAVE ============================================
$(document).on("click", "#btnSave", function(event) {
    // Clear alerts---------------------
    $("#alertSuccess").text("");
    $("#alertSuccess").hide();
    $("#alertError").text("");
    $("#alertError").hide();
    // Form validation-------------------
    var status = validateHospitalForm();
    if (status != true) {
        $("#alertError").text(status);
        $("#alertError").show();
        return;
    }
    // If valid------------------------
    $("#formHospital").submit();
});
// UPDATE==========================================
$(document).on("click", ".btnUpdate", function(event) {
    $("#HospitalIDSave").val($(this).closest("tr").find('#HospitalIDUpdate').val());
    $("#Hospital_Name").val($(this).closest("tr").find('td:eq(0)').text());
    $("#Hospital_Address").val($(this).closest("tr").find('td:eq(1)').text());
    $("#Hospital_City").val($(this).closest("tr").find('td:eq(2)').text());
    $("#Hospital_Phone").val($(this).closest("tr").find('td:eq(3)').text());
    $("#Hospital_Email").val($(this).closest("tr").find('td:eq(4)').text());
    $("#Hospital_Description").val($(this).closest("tr").find('td:eq(5)').text());
    $("#Open_Hours").val($(this).closest("tr").find('td:eq(6)').text());
});
// CLIENTMODEL=========================================================================
function validateHospitalForm() {
    
    if ($("#Hospital_Name").val().trim() == "") {
        return "Insert Hospital name.";
    }
    
    if ($("#Hospital_Address").val().trim() == "") {
        return "Insert Hospital Address.";
    }
    

    if ($("#Hospital_City").val().trim() == "") {
        return "Insert Hospital City.";
    }

    if ($("#Hospital_Phone").val().trim() == "") {
        return "Insert Hospital Phone.";
    }
    
    if ($("#Hospital_Email").val().trim() == "") {
        return "Insert Hospital email.";
    }
    
    if ($("#Hospital_Description").val().trim() == "") {
        return "Insert Hospital Description.";
    }
    
    if ($("#Open_Hours").val().trim() == "") {
        return "Insert Hospital Open_Hours.";
    }
    return true;
}