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
    $("#DoctorIDSave").val($(this).closest("tr").find('#DoctorIDUpdate').val());
    $("#DoctorName").val($(this).closest("tr").find('td:eq(0)').text());
    $("#NIC").val($(this).closest("tr").find('td:eq(1)').text());
    $("#DepartmentName").val($(this).closest("tr").find('td:eq(2)').text());
    $("#Address").val($(this).closest("tr").find('td:eq(3)').text());
    $("#MobileNo").val($(this).closest("tr").find('td:eq(4)').text());
    $("#Email").val($(this).closest("tr").find('td:eq(5)').text());
    $("#Specialization").val($(this).closest("tr").find('td:eq(6)').text());
    $("#HospitalName").val($(this).closest("tr").find('td:eq(6)').text());
});
// CLIENTMODEL=========================================================================
function validateDoctorForm() {
    
    if ($("#DoctorName").val().trim() == "") {
        return "Insert Doctor Name.";
    }
    
    if ($("#NIC").val().trim() == "") {
        return "Insert NIC.";
    }
    

    if ($("#DepartmentName").val().trim() == "") {
        return "Insert Department Name.";
    }

    if ($("#Address").val().trim() == "") {
        return "Insert Address.";
    }
    
    if ($("#MobileNo").val().trim() == "") {
        return "Insert Mobile No.";
    }
    
    if ($("#Email").val().trim() == "") {
        return "Insert Email address.";
    }
    
    if ($("#Specialization").val().trim() == "") {
        return "Insert Specialization.";
    }
    
    if ($("#HospitalName").val().trim() == "") {
        return "Insert Hospital Name.";
    }
    return true;
} 

