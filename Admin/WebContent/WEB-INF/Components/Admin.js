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
    $("#formAdmin").submit();
});
// UPDATE==========================================
$(document).on("click", ".btnUpdate", function(event) {
    $("#AdminIDSave").val($(this).closest("tr").find('#AdminIDUpdate').val());
    $("#Admin_Name").val($(this).closest("tr").find('td:eq(0)').text());
    $("#Admin_Gender").val($(this).closest("tr").find('td:eq(1)').text());
    $("#Admin_Address").val($(this).closest("tr").find('td:eq(2)').text());
    $("#Admin_Password").val($(this).closest("tr").find('td:eq(3)').text());
    $("#Admin_Phone").val($(this).closest("tr").find('td:eq(4)').text());
    $("#Admin_Email").val($(this).closest("tr").find('td:eq(5)').text());
   
});
// CLIENTMODEL=========================================================================
function validateAdminForm() {
    
    if ($("#Admin_Name").val().trim() == "") {
        return "Insert Admin Name.";
    }
    
    if ($("#Admin_Gender").val().trim() == "") {
        return "Insert Admin Gender.";
    }
    

    if ($("#Admin_Address").val().trim() == "") {
        return "Insert Admin Address.";
    }

    if ($("#Admin_Password").val().trim() == "") {
        return "Insert Admin Password.";
    }
    
    if ($("#Admin_Phone").val().trim() == "") {
        return "Insert Admin Phone.";
    }
    
    if ($("#Admin_Email").val().trim() == "") {
        return "Insert Admin Email.";
    }
    
   
    return true;
} 

