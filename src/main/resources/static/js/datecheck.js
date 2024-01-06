function restrictMaxDate(inputDateElem) {
dtToday = new Date();
month = dtToday.getMonth() + 1;     // getMonth() is zero-based
day = dtToday.getDate();
year = dtToday.getFullYear();
if (month < 10)
	month = '0' + month.toString();
if (day < 10)
	day = '0' + day.toString();

maxDate = year + '-' + month + '-' + day;
$(inputDateElem).attr('max', maxDate);
}

function restrictMinDate(inputDateElem) {
dtToday = new Date();
month = dtToday.getMonth() + 1;     // getMonth() is zero-based
day = dtToday.getDate();
year = dtToday.getFullYear();
if (month < 10)
	month = '0' + month.toString();
if (day < 10)
	day = '0' + day.toString();

minDate = year + '-' + month + '-' + day;
$(inputDateElem).attr('min', minDate);
}