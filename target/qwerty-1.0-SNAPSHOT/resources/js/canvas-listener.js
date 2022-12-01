const canvas = document.querySelector("#canvas");
const ctx = canvas.getContext('2d');

canvas.addEventListener("click", function (event){
    let x = event.offsetX;
    let y = event.offsetY;
    let radius = document.getElementById("j_idt7:radius").value;
    radius = parseFloat(radius);
    if (isNaN(radius)) return;

    curX = (x-200)/37.5;
    curY = -(y-200)/37.5;
    if (curX >= 0 && curY >= 0){
        if (curY <= -2*curX+radius) drawPoint(x, y, "green");
        else drawPoint(x, y, "red");
    }
    else if (curX >= 0 && curY <= 0){
        if (curX*curX + curY*curY <= radius*radius) drawPoint(x, y, "green");
        else drawPoint(x, y, "red");
    }
    else if (curX <= 0 && curY <= 0){
        if (curX >= -(radius) && curY >= -(radius)/2) drawPoint(x, y, "green");
        else drawPoint(x, y, "red");
    }
    else drawPoint(x, y, "red");

    document.getElementById("hiddenForm:hiddenX").value = curX.toFixed(5);
    document.getElementById("hiddenForm:hiddenY").value = curY.toFixed(5);
    document.getElementById("hiddenForm:hiddenRadius").value = radius.toFixed(5);
    document.getElementById("hiddenForm:hiddenButton").click();
});

function drawPoint(offsetX, offsetY, fillStyle){
    ctx.beginPath();
    ctx.arc(offsetX, offsetY, 3, 0, Math.PI*2, true);
    ctx.fillStyle = fillStyle;
    ctx.fill();
    ctx.closePath();
}