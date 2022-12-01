let date = new Date();
let day = date.getDate();
let month = date.getMonth() + 1;
let year = date.getFullYear();

if (day.length === 1) day = "0" + day;
if (month.length === 1) day = "0" + month;

console.log(day, month, year);

document.getElementById("date-heading").innerHTML = day + "." + month + "." + year;