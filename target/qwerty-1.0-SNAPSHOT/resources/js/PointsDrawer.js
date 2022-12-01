function updatePoints(){
    let table = document.getElementById("info-table");

    var x;
    var y
    var wasHit;
    var color;

    for (var i = 1; i < table.rows.length; i++){
        x = parseFloat(table.rows[i].cells[0].innerText);
        y = parseFloat(table.rows[i].cells[1].innerText);
        if (isNaN(x) || isNaN(y)) return;
        wasHit = table.rows[i].cells[3].innerText;
        if (wasHit === "true") color = "green";
        else color = "red";
        ctx.beginPath();
        ctx.arc(x*37.5+200, y*(-37.5)+200, 3, 0, Math.PI*2, true);
        ctx.fillStyle = color;
        ctx.fill();
        ctx.closePath();
    }
}

setInterval(updatePoints, 500);
document.getElementById("clearButton").addEventListener("click", event => {
    var radius = document.getElementById("j_idt7:radius").value;
    ctx.beginPath();
    ctx.moveTo(0, 0);
    ctx.lineTo(0, 400);
    ctx.lineTo(400, 400);
    ctx.lineTo(400, 0);
    ctx.lineTo(0, 0);
    ctx.fillStyle = "#091921"
    ctx.fill();
    ctx.closePath();
    ctx.strokeStyle = "#008080";
    ctx.lineWidth = "10";
    ctx.strokeRect(0, 0, 400, 400);

    ctx.beginPath();
    ctx.moveTo(200, 0);
    ctx.lineTo(190, 20);
    ctx.lineTo(210, 20);
    ctx.lineTo(200, 0);
    ctx.fillStyle = "#008080";
    ctx.fill();
    ctx.closePath();

    ctx.beginPath();
    ctx.moveTo(400, 200);
    ctx.lineTo(380, 190);
    ctx.lineTo(380, 210);
    ctx.lineTo(400, 200);
    ctx.fill();
    ctx.closePath();

    ctx.beginPath();
    ctx.moveTo(200+75/4*radius, 200);
    ctx.lineTo(200, 200-150/4*radius);
    ctx.lineTo(200, 200);
    ctx.lineTo(200+75/4*radius, 200);
    ctx.fillStyle = "#696969"
    ctx.fill();
    ctx.closePath();

    ctx.beginPath();
    ctx.moveTo(200, 200+75/4*radius);
    ctx.lineTo(200, 200);
    ctx.lineTo(200-150/4*radius, 200);
    ctx.lineTo(200-150/4*radius, 200+75/4*radius);
    ctx.lineTo(200, 200+75/4*radius);
    ctx.fill();
    ctx.closePath();

    ctx.beginPath();
    ctx.arc(200, 200, 150/4*radius, 0, Math.PI*0.5, false);
    ctx.lineTo(200, 200);
    ctx.lineTo(50, 200);
    ctx.fill();
    ctx.closePath();

    ctx.beginPath();
    ctx.lineWidth = 3;
    ctx.moveTo(195, 200-75/4*radius);
    ctx.lineTo(205, 200-75/4*radius);
    ctx.stroke();
    ctx.moveTo(200+75/4*radius, 195);
    ctx.lineTo(200+75/4*radius, 205);
    ctx.stroke();
    ctx.moveTo(200+150/4*radius, 195);
    ctx.lineTo(200+150/4*radius, 205);
    ctx.stroke();
    ctx.moveTo(195, 200-150/4*radius);
    ctx.lineTo(205, 200-150/4*radius);
    ctx.stroke();
    ctx.closePath();

    ctx.moveTo(200, 400);
    ctx.lineWidth = "3";
    ctx.lineTo(200, 0);
    ctx.stroke();

    ctx.moveTo(0, 200);
    ctx.lineTo(400, 200);
    ctx.stroke();

    ctx.beginPath();
    ctx.fillStyle = "white";
    ctx.font = "17px serif";
    ctx.fillText("R/2", 167, 200-70/4*radius);
    ctx.fillText("R", 180, 200-145/4*radius);
    ctx.fillText("R/2", 200+62/4*radius, 190);
    ctx.fillText("R", 200+144/4*radius, 190);
    ctx.closePath();
})