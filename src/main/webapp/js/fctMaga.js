function choisirMagasin(){
    var xhr = new XMLHttpRequest();
    var url = "ServletMagasin?nomMagasin="+this.innerText;
    xhr.open("GET", url,true);
    xhr.onload = function(){
        if (xhr.status === 200) {}}
    xhr.send();

}


document.addEventListener("DOMContentLoaded", () => {
    var tab = document.getElementsByName("maga");
    for(j =0; j<tab.length; j++){
        tab[j].addEventListener("click",choisirMagasin);
    }



});