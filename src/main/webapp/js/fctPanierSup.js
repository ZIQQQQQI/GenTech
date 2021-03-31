/*
     *@param nomCate
     *@return metier.Rayon
     *@author Tu
     *@description
     *@exception
     *@date 30/03/2021 10:54
     */
function supprimerPan(){
    var xhr = new XMLHttpRequest();

    var url = "ServletSupprimerPan?idSupPan="+this.getAttribute("idSupPan");

    //alert(this.getAttribute("idSupPan"));
    var idlistpan = this.getAttribute("idSupPan")+"listpan";
    //alert(idlistpan);

    var elt = document.getElementById("addPan");
    var c = parseInt(elt.innerHTML);
    //alert(c);
    xhr.open("GET", url,true);
    xhr.onload = function(){
        if (xhr.status === 200)
        {
            c= c-1;
            //alert(c);
            var zone = document.getElementById(idlistpan);
            zone.innerHTML="";

            elt.innerHTML=c.toString();
        }

    };
    xhr.send();
}

document.addEventListener("DOMContentLoaded", () => {


    var tab1 = document.getElementsByName("minusPan");
    for(j =0; j<tab1.length; j++){
        tab1[j].addEventListener("click",supprimerPan);
    }



})