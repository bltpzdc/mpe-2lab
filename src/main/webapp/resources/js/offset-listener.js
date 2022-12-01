window.addEventListener("load", () => {
    let date = new Date();
   let value = parseInt(-date.getTimezoneOffset()/60);
   if (value > 0) value = '+' + value;
   document.getElementById("offsetForm:offset").value = value;
   document.getElementById("offsetForm:offsetSubmit").click();
});

