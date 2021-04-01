/*
 *@param null
 *@return
 *@author Tu
 *@description
 *@exception
 *@date 29/03/2021 08:37
*/
function addProduit(){
    var xhr = new XMLHttpRequest();
    var idp= this.getAttribute("idp");
    var email= this.getAttribute("email");

    var elt = document.getElementById("addPan");
    var count = parseInt(elt.innerHTML);
    var d1= document.getElementById("addPanier");

    if(email!="null"){

        var url = "ServletPanier?idp="+idp+"&email="+email;
        xhr.open("GET", url,true);
        xhr.onload = function(){
            if (xhr.status === 200) {
                count= count+1;
                elt.innerHTML=count.toString();

                if(xhr.responseText=="success"){
                    alert("exsit dans votre panier!")
                }else {
                    alert("success d'ajouter")
                    var content = "<div class='media'><div class='media-body'><h3 class='dropdown-item-title' style='color:#666666'><span id='"+idp+"'><i name='minusPan' class='far fa-trash-alt' style='float: left;margin-top: 18px;margin-right:10px' idSupPan='"+idp+"'></i><img style='height:50px;width: 50px;padding:10px;' src='./images/"+idp+".jpg' alt='imgProd1'>"+xhr.responseText+"</span><hr style='margin-top: 5px;margin-bottom: 5px;'></h3></div></div>";
                    d1.insertAdjacentHTML('beforeend',content);
                }

            }}
        xhr.send();
    }else {
        alert("S'il vous plait,Connectez-vous d'abord");
    }
}




document.addEventListener("DOMContentLoaded", () => {

    var produitAdd = document.getElementsByName("produidIdAdd");
    for(j =0;j< produitAdd.length; j++){
        produitAdd[j].addEventListener("click",addProduit);
    }



})