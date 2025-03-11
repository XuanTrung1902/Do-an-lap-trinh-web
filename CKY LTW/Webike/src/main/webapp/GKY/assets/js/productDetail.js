// thay doi mau xe dua theo lua chon
function changeBikeColor(id) {
    var imgscr = document.getElementById("img");
    var btnid = document.getElementById(id);
    if (btnid.id == "red") {
        imgscr.src = "assets/img/ducati red.png";
        btnid.style.background = "rgb(147, 157, 163)";
        document.getElementById("black").style.background ="none"
    } else if(btnid.id){
        imgscr.src = "assets/img/ducati black.png";
        btnid.style.background = "rgb(147, 157, 163)";
        document.getElementById("red").style.background ="none"
    }
}


