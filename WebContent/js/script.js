// Include form validation functions here
function validation() {
                var a = document.forms["form"]["txtTitle"].value;
                if(a == "" ) {
                                alert("Title is Required");
                                return false;
                             }
                if ((a.length < 2) || (a.length > 100)) {
                                alert("Title should have 2 to 100 characters.");
                                return false;
                             }
                var b = document.forms["form"]["txtGross"].value;
                if(b == "" ) {
                                alert("Box Office is required.");
                                return false;
                             }
                if(/[^0-9/]/.test(b)) {
                                alert("Box Office has to be a number.");
                                return false;
                             }
                var c = document.forms["form"]["txtDoL"].value;
                if( c == "" ){
                                alert("Date of Launch is required.");
                                return false;
                             }
				var d = document.forms["form"]["txtGenre"].value;
                if( d == "" ){
                                alert("Select one Genre.");
                                return false;
                             }
                      }