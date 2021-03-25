/*
 *@param null
 *@return
 *@author Tu
 *@description js pour rechercher un produit par mot-cle
 *@exception
 *@date 25/03/2021 09:04
*/

function searchKeyword(){
    var xhr = new XMLHttpRequest();
    var content = document.getElementById("keyword").value;


    if(content != ""){
        document.getElementById("zoneaff").style.display = "block";
        //alert(content);
    }else{
        document.getElementById("zoneaff").style.display = "none";
    }

    var url = "ServletRechercher?keyword="+content;

    xhr.open("GET", url,true);
    xhr.onload = function(){
        if (xhr.status === 200)
        {
            var elt = document.getElementById("zoneaff");

            var prod = xhr.responseXML.getElementsByTagName("nomp");

            elt.innerHTML="";

            for (i = 0; i < prod.length; i++){
                //获取到table里面的儿子们
                produit1 = prod[i].firstChild.nodeValue;

                elt.insertAdjacentHTML('beforeend',"<p>"+produit1+"</p>");

            }

        }
    }
    xhr.send();
}

document.addEventListener("DOMContentLoaded", () => {

    document.getElementById("keyword").addEventListener("input",searchKeyword);

});