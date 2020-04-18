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
    var status = validatePaymentForm();
    if (status != true) {
        $("#alertError").text(status);
        $("#alertError").show();
        return;
    }
    // If valid------------------------
    $("#formPayment").submit();
});
// UPDATE==========================================
$(document).on("click", ".btnUpdate", function(event) {
    $("#PaymentIDSave").val($(this).closest("tr").find('#PaymentIDUpdate').val());
    $("#paymentType").val($(this).closest("tr").find('td:eq(1)').text());
    $("#paymentAmount").val($(this).closest("tr").find('td:eq(2)').text());
    $("#appointmentID").val($(this).closest("tr").find('td:eq(3)').text());
    
});
// CLIENTMODEL=========================================================================
function validatePaymentForm() {
    
    if ($("#paymentType").val().trim() == "") {
        return "Insert Payment Type.";
    }
    
    if ($("#paymentAmount").val().trim() == "") {
        return "Insert Payment Amount.";
    }
    

    if ($("#appointmentID").val().trim() == "") {
        return "Insert Appointment ID.";
    }

   
    return true;
}