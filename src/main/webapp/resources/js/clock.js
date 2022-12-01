function animatedClocks() {
    const deg = 6;

    let date = new Date();
    let hr = document.getElementById("hr");
    let min = document.getElementById("min");
    let sec = document.getElementById("sec");


    let hh = date.getHours() * 30;
    let mm = date.getMinutes() * deg;
    let ss = date.getSeconds() * deg;
    let a = (hh + mm / 12);


    hr.style.transform = 'rotateZ(' + a + 'deg)';
    min.style.transform = 'rotateZ(' + mm + 'deg)';
    sec.style.transform = 'rotateZ(' + ss + 'deg)';
}

setInterval(animatedClocks, 12 * 1000);