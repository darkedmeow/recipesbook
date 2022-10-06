$(document).ready(function () {

    // Invoke the corresponding URL to update the contacts section using Ajax
    $('.ing-update').on('click', 'button[data-update-ing-url]', function () {
        let url = $(this).data('update-ing-url');

        // adding the row index, needed when deleting a contact
        let formData = $('form').serializeArray();
        let param = {};
        param["name"] = $(this).attr('name');
        param["value"] = $(this).val();
        formData.push(param);
        // updating the contact section
        $('#tblIngs').load(url, formData);
    });

    $('.step-update').on('click', 'button[data-update-step-url]', function () {
            let url = $(this).data('update-step-url');

            // adding the row index, needed when deleting a contact
            let formData = $('form').serializeArray();
            let param = {};
            param["name"] = $(this).attr('name');
            param["value"] = $(this).val();
            formData.push(param);
            // updating the contact section
            $('#stepsForm').load(url, formData);
        });

    // autodismiss alerts
    window.setTimeout(function() {
        $(".alert").fadeTo(500, 0).slideUp(500, function(){
            $(this).remove();
        });
    }, 4000);
});

let inputTIme = document.getElementById('inputTime')
    $("#incTime").click(function () {
        inputTime.stepUp();
    });
    $("#decTime").click(function () {
        inputTime.stepDown();
    });