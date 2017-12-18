+function () {

    var $alphanumericPattern = /^[\w\d]{3,15}$/,
        $emailPattern = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/,
        $textPattern = /^[\w]{2,15}$/,
        $groupNumberPattern = /^[\d]{1,10}$/
    ;

    var Validation = {

        switchButtons: function (btns, condition) {
            if (btns) {
                if (condition) {
                    btns.some(function (button) {
                        button.removeAttr('disabled')
                    })
                } else {
                    btns.some(function (button) {
                        button.attr("disabled", true)
                    })
                }
            }
        },

        validateOnEmpty: function (inputs) {
            for(var i = 0; i < inputs.length; i++) {
                if(!inputs[i].val().trim()) {
                    return false;
                }
            }
            return true;
        },

        validateAlphanumericField: function (value) {
            return $alphanumericPattern.test(value.val());
        },

        validateEmail: function (email) {
            return $emailPattern.test(email.val().toLowerCase());
        },

        validatePasswordRepeating: function (password, repeat) {
            return (password.val() === repeat.val());
        },

        validateTextField: function (value) {
            return $textPattern.test(value.val());
        },

        validateGroupNumber: function (value) {
            return $groupNumberPattern.test(value.val());
        }

    };

    window.Validation = Validation;

}();
