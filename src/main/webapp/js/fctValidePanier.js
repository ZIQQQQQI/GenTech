function changeQte(){
    var idp=this.getAttribute("idc");
    var qte=this.value

    var xhr = new XMLHttpRequest();
    var url = "ServletChangeQte?idp="+idp+"&qte="+qte;
    xhr.open("GET",url,true);
    xhr.onload = function(){
        if (xhr.status === 200) {


        }}
    xhr.send();

}



document.addEventListener("DOMContentLoaded", () => {
    var tab = document.getElementsByName("changeQte");

    for(j =0; j<tab.length; j++){
        tab[j].addEventListener("change",changeQte);
    }


});