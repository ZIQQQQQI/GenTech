function preference(){
    var xhr = new XMLHttpRequest();

    var url = "ServletPreference?idPP="+this.getAttribute("idppp");
    var id=this.getAttribute("idppp")
    var elt = document.getElementById("addPre");
    var block=this
    var c = parseInt(elt.innerHTML);



    xhr.open("GET", url,true);
    xhr.onload = function(){
        if (xhr.status === 200) {


            c= c+1;
            elt.innerHTML=c.toString();
            block.style.display="none";
            var heart=document.getElementById(id);
            heart.style.display="block"


        }}
    xhr.send();

}


function supprimerPre(){
    var xhr = new XMLHttpRequest();

    var url = "ServletSupprimerPre?idSup="+this.getAttribute("idSup");

    //alert(this.getAttribute("idSup"));
    var elt = document.getElementById("addPre");
    var c = parseInt(elt.innerHTML);
    xhr.open("GET", url,true);
    xhr.onload = function(){
        if (xhr.status === 200)
        {
            c= c-1;


            elt.innerHTML=c.toString();
        }

    };
    xhr.send();
}




document.addEventListener("DOMContentLoaded", () => {
    var tab = document.getElementsByName("pre");

    for(j =0; j<tab.length; j++){
        tab[j].addEventListener("click",preference);
    }

    var tab1 = document.getElementsByName("minusPre");
    for(j =0; j<tab1.length; j++){
        tab1[j].addEventListener("click",supprimerPre);
    }



});