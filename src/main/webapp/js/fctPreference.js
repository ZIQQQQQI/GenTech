/*
 *@param null
 *@return
 *@author Tu
 *@description
 *@exception
 *@date 29/03/2021 08:37
*/
function preference(){
    var xhr = new XMLHttpRequest();
    var url = "ServletPreference?idPP="+this.getAttribute("idppp");
    var id=this.getAttribute("idppp")
    var elt = document.getElementById("addPre");
    var block=this
    var c = parseInt(elt.innerHTML);
    var d1= document.getElementById("addPreference");
    xhr.open("GET", url,true);
    xhr.onload = function(){
        if (xhr.status === 200) {


            c= c+1;
            elt.innerHTML=c.toString();
            block.style.display="none";
            var heart=document.getElementById(id);
            heart.style.display="block";

            var content = "<div class='media'><div class='media-body'><h3 class='dropdown-item-title' style='color:#666666'><span id='"+id+"'><i name='minusPre' class='far fa-trash-alt' style='float: left;margin-top: 18px;margin-right:10px'  idSup='"+id+"'></i><img style='height:50px;width: 50px;padding:10px;' src='./images/"+id+".jpg' alt='imgProd1'>"+xhr.responseText+"</span><hr style='margin-top: 5px;margin-bottom: 5px;'></h3></div></div>";

            d1.insertAdjacentHTML('beforeend',content);


        }}
    xhr.send();

}


function supprimerPre(){
    var xhr = new XMLHttpRequest();

    var url = "ServletSupprimerPre?idSup="+this.getAttribute("idSup");

    //var id = this.getAttribute("idSup");
    var idlistp = this.getAttribute("idSup")+"listp";
    // alert(idlistp);

    var elt = document.getElementById("addPre");
    var c = parseInt(elt.innerHTML);
    xhr.open("GET", url,true);
    xhr.onload = function(){
        if (xhr.status === 200)
        {
            c= c-1;

            var zone = document.getElementById(idlistp);
            // alert(zone.innerHTML);
            zone.innerHTML="";

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