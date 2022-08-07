$(document).ready(function (){

    function reclass(){
        $("#page1").removeClass("active");
        $("#page2").removeClass("active");
        $("#page3").removeClass("active");
        $("#page4").removeClass("active");
        $("#page5").removeClass("active");
        $("#dropdown").removeClass("active");                        
    }
    $("#page1").click(function(){
        reclass();
        $("#page1").addClass("active");
        
    });
    $("#page2").click(function(){
        reclass();
        $("#page2").addClass("active");
       
    });
    $("#page3").click(function(){
        reclass();
        $("#page3").addClass("active");
       
    });
    $("#page4").click(function(){
        reclass();
        $("#page4").addClass("active");
        
    });
    $("#page5").click(function(){
        reclass();
        $("#page5").addClass("active");
        
    });
    $("#dropdown").click(function(){
        reclass();
        $("#dropdown").addClass("active");                    
    });
    
                
});

