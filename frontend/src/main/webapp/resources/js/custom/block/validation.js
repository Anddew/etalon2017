+function () {

    var $alphanumericPattern = /^[\w]{3,15}$/,
        $emailPattern = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/,
        $textPattern = /^[\w]{2,15}$/,
        $groupNumberPattern = /^[\d]{1,10}$/,
        $excludeDigitsAndUnderscorePattern = /\d|_/,
        $avgScorePattern = /^\d(\.[\d]{1,2})?$/,
        $studentsCountPattern = /^\d{1,2}$/
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
                // if(!inputs[i].val().trim()) {
                if(!inputs[i].val()) {
                    return false;
                }
            }
            return true;
        },

        validateAlphanumericField: function (value) {
            var val = value.val();
            if(val === "") {
                return true;
            }
            return $alphanumericPattern.test(val);
        },

        validateEmail: function (value) {
            var email = value.val();
            if(email === "") {
                return true;
            }
            return $emailPattern.test(email.toLowerCase());
        },

        validatePasswordRepeating: function (password, repeat) {
            var pass = password.val();
            var rep = repeat.val();
            if(pass === "" || rep === "") {
                return true;
            }
            return (pass === rep);
        },

        validateTextField: function (value) {
            var text = value.val();
            if(text === "") {
                return true;
            }
            return $textPattern.test(text) && !$excludeDigitsAndUnderscorePattern.test(text);
        },

        validateGroupNumber: function (value) {
            var val = value.val();
            if(val === "") {
                return true;
            }
            return $groupNumberPattern.test(val);
        },

        validateAvgScore: function (val) {
            if(val === null || val === "") {
                return true;
            }
            return $avgScorePattern.test(val);
        },

        validateStudentsCount: function (value) {
            var val = value.val();
            if(val === null || val === "") {
                return true;
            }
            return $studentsCountPattern.test(val);
        },

        validateIsSelectChosen: function (value) {
            if(value === null || value === "") {
                return false;
            }
            return value != 0;
        },

        validateDates: function (dateStart, dateEnd) {
            var start = new Date(dateStart.val());
            var end = new Date(dateEnd.val());
            if(start === null || start === "" || end === null || end === "") {
                return false;
            }
            return (start - end) <= 0;
        },

        hideNotifications: function (notifications) {
        if(notifications) {
            for(var i = 0; i < notifications.length; i++) {
                notifications[i].hide();
            }
        }
    }

    };

    window.Validation = Validation;

}();
