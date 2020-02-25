$(function(){
    console.log("js");
    
    $('.resizebtn').click(function(){
        console.log("btn click");  
    });

});


function imageToString(){
    
}


function reSizeImage(){
    
    var urlStr = "http://localhost:8080/imageservice";
    var endpoint ="/get/imageresize"
    // var reqResize = {
    //     width = 
    // }
    
    $.ajax({
        url: urlStr + endpoint,
        type: "POST",
        dataType:'json',
        success: function (response) {
            console.log(response);
        },
        error: function(error){
            console.log("Something went wrong", error);
        }
    });
}